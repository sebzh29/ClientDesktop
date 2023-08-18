package fr.eni.application;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient(); //Creation HTTP Client

            // Preparation de la requete HTTP
            HttpRequest request  = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/articles"))
                    .GET()
                    .build();

            //L'envoie de la requete HTTP et receptionde la reponse

            // Affichage du body de la reponse
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}