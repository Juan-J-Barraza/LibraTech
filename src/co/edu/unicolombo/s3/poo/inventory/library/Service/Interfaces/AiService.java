package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces;

public interface AiService {
    public String getAIResponse(String prompt) throws Exception;
    public String parseResponse(String responseBody) throws Exception;
}
