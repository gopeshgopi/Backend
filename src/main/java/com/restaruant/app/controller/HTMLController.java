package com.restaruant.app.controller;


import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HTMLController {



    @GetMapping("/validate-html")
    public boolean validateHtml() {

        String html = "<htm(ekkada tag wrong istuna)>\n<body>\n\n<h1>My First Heading</h1>\n<p>My first paragraph.</p>\n\n</body>\n</html>";
        // String html = "<html>\n<body>\n\n<h1>My First Heading</h1>\n<p>My first paragraph.</p>\n\n</body>\n</html>";

        // String html = "<!DOCTYPE html>\\n<html>\\n<body>\\n\\n<h1>My First Heading</h1>\\n<p>My first paragraph.</p>\\n\\n</body>\\n</html>";
        try {
            Document doc = Jsoup.parse(html);


            Document cleanDocument = Jsoup.parse(Jsoup.clean(doc.html(), Whitelist.relaxed()));
            // If the cleaned document is the same as the original, then the HTML is valid
            String normal_html = normalizeHtml(cleanDocument.html());
            String doc_html = normalizeHtml(doc.html());
            return normalizeHtml(cleanDocument.html()).equals(normalizeHtml(doc.html()));


        } catch (Exception e) {

            return false;
        }
    }

    private static String normalizeHtml(String html) {

        return html.replaceAll("\\s+", "").replaceAll("\\\\", "").replaceAll("\n", "").trim();
    }



}

