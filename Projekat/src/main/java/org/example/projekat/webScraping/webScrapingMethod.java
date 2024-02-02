package org.example.projekat.webScraping;

import javafx.scene.control.ListView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class webScrapingMethod {

    public static void main(String[] args) {
        String url = "https://www.goodreads.com/list/show/14220.IMDB_250";
        try {
            scrapeTopBooks(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> scrapeTopBooks(String url) throws IOException {
        Map<String, String> books = new HashMap<>();

        Document document = Jsoup.connect(url).get();
        String Array1[] = new String[250];
        String Array2[] = new String[250];
        int i = 0;
        Elements titleElements = document.select("a.bookTitle span[itemprop=name]");
        for (Element titleElement : titleElements) {
            String title = titleElement.text();
            Array1[i] = title;
            //System.out.println("Title: " + title);
            i++;
        }
        i = 0;
        // Selecting ratings
        Elements ratingElements = document.select("span.minirating");
        for (Element ratingElement : ratingElements) {
            String rating = ratingElement.text();
            Array2[i] = rating;
            i ++;
//            System.out.println("Rating: " + rating);
//            System.out.println("-----------------------------");
        }
        for(int j = 0; j < 250; j++){
            books.put(Array1[j], Array2[j]);
        }

        return books;
    }
}
