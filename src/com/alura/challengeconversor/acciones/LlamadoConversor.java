package com.alura.challengeconversor.acciones;

import com.alura.challengeconversor.modelos.SolicitudConversion;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlamadoConversor {

    public double tasaConversion(String monedaBase, String monedaObjetivo) {
        /*
        Investigar mas sobre esta línea. Misma que sirve para llamar la librería Gson para procesar la información en
        formato Json
         */

        Gson gson = new GsonBuilder()
                .setPrettyPrinting().create();
    /*
    Creación del ciente para la consulta.
     */
        HttpClient cliente = HttpClient.newHttpClient();
    /*
    Generación de la URI dinámica.
     */
        String url = "https://v6.exchangerate-api.com/v6/62705828c13143d3d4201914/pair/"
                + monedaBase + "/" + monedaObjetivo + "/" /*+ montoAConvertir + "/"*/;
    /*
    Creacón de la solicitud a la API
     */
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            /*
            Envío de la consulta para cuardar en la variable response la información obtenida
             */
            HttpResponse<String> response = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            /*
            Conversión de respuesta a formato Json
             */
            String json = response.body();
            //System.out.println(json);
            /*
            Traslado de la infomación en formato Json al objeto del tipo record con nombre SolicitudConversion
             */
            SolicitudConversion solicitudConversion = gson.fromJson(json, SolicitudConversion.class);
            //System.out.println(solicitudConversion);
            JsonElement elemento = JsonParser.parseString(response.body());
            //System.out.println(elemento);
            JsonObject objectRoot = elemento.getAsJsonObject();
            //System.out.println(objectRoot);
            double tasa = objectRoot.get("conversion_rate").getAsDouble();
            //System.out.println(tasa);
            return tasa;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
