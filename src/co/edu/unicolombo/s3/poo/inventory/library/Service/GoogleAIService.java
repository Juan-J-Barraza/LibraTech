package co.edu.unicolombo.s3.poo.inventory.library.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.AiService;

public class GoogleAIService implements AiService {

    private String apiKey;
    private String initialContext;

    public GoogleAIService(String apiKey, String initialContext) {
        this.apiKey = apiKey;
        this.initialContext = initialContext;
    }

    @Override
    public String getAIResponse(String prompt) throws Exception {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new Exception("La clave de API de Google no está configurada.");
        }

        // Nombre del modelo
        String modelName = "gemini-1.5-flash";
        // Endpoint de la API
        String endpoint = "https://generativelanguage.googleapis.com/v1beta/models/" + modelName
                + ":generateContent?key=" + apiKey;

        // Construir el cuerpo de la solicitud según la documentación
        JSONObject requestJson = new JSONObject();

        // Construir el contenido de la solicitud
        JSONArray contentsArray = new JSONArray();
        JSONObject contentObject = new JSONObject();
        JSONArray partsArray = new JSONArray();
        JSONObject partObject = new JSONObject();

        // Concatenar el contexto inicial al prompt si existe
        String fullPrompt = prompt;
        if (initialContext != null && !initialContext.isEmpty()) {
            fullPrompt = initialContext + "\n" + prompt;
        }

        // Agregar el texto al partObject
        partObject.put("text", fullPrompt);

        // Agregar el partObject al partsArray
        partsArray.put(partObject);

        // Agregar el partsArray al contentObject
        contentObject.put("parts", partsArray);

        // Agregar el contentObject al contentsArray
        contentsArray.put(contentObject);

        // Agregar el contentsArray al requestJson
        requestJson.put("contents", contentsArray);

        // Imprimir el cuerpo de la solicitud para depuración
        System.out.println("BODY: " + requestJson.toString());

        // Construir la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(requestJson.toString(), StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Imprimir el cuerpo de la respuesta para depuración
        System.out.println("Cuerpo de la respuesta: " + response.body());

        // Manejar la respuesta
        if (response.statusCode() == 200) {
            return parseResponse(response.body());
        } else {
            throw new Exception("Error en la solicitud: " + response.body());
        }
    }

    @Override
    public String parseResponse(String responseBody) throws Exception {
        JSONObject jsonObject = new JSONObject(responseBody);

        // Verificar si hay errores en la respuesta
        if (jsonObject.has("error")) {
            JSONObject errorDetails = jsonObject.getJSONObject("error");
            String errorMessage = errorDetails.optString("message", "Error desconocido");
            String errorCode = errorDetails.optString("code", "sin_codigo");
            throw new Exception("Error de API: " + errorMessage + " (Código: " + errorCode + ")");
        }

        // Parsear la respuesta según la estructura actual
        if (jsonObject.has("candidates")) {
            JSONArray candidatesArray = jsonObject.getJSONArray("candidates");
            if (candidatesArray.length() > 0) {
                JSONObject firstCandidate = candidatesArray.getJSONObject(0);
                if (firstCandidate.has("content")) {
                    JSONObject contentObject = firstCandidate.getJSONObject("content");
                    if (contentObject.has("parts")) {
                        JSONArray partsArray = contentObject.getJSONArray("parts");
                        StringBuilder outputBuilder = new StringBuilder();
                        for (int i = 0; i < partsArray.length(); i++) {
                            JSONObject partObject = partsArray.getJSONObject(i);
                            String text = partObject.optString("text", "");
                            outputBuilder.append(text);
                        }
                        return outputBuilder.toString().trim();
                    }
                }
            }
        }

        // Si no se pudo parsear la respuesta, lanzar una excepción
        throw new Exception("No se pudo parsear la respuesta de la API.");
    }

}
