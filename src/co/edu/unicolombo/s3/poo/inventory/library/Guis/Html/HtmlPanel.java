package co.edu.unicolombo.s3.poo.inventory.library.Guis.Html;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class HtmlPanel extends JEditorPane {
    public HtmlPanel(String htmlContent) {
        // Configurar el JEditorPane
        setContentType("text/html");
        setEditable(false);
        putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);

        // Configurar el estilo
        HTMLEditorKit kit = new HTMLEditorKit();
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("body {font-family: Arial; font-size: 14px; margin: 8px;}");
        styleSheet.addRule("h1 {font-size: 18px;}");
        styleSheet.addRule("h2 {font-size: 16px;}");
        styleSheet.addRule("h3 {font-size: 14px;}");
        styleSheet.addRule("ul {margin-left: 20px;}");
        styleSheet.addRule("li {margin-bottom: 5px;}");

        setEditorKit(kit);

        // Establecer el contenido HTML
        setText(htmlContent);
    }
}

