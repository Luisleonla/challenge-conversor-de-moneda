import com.alura.challengeconversor.modelos.Monedas;
import com.alura.challengeconversor.modelos.SolicitudConversion;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) {
        //Se determinana el tipo de cambio que se desea y el monto
        Monedas monedaObjetivo = Monedas.MXN;
        Monedas monedaBase = Monedas.USD;
        int montoAConvertir = 1;
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
                + monedaBase + "/" + monedaObjetivo + "/" + montoAConvertir + "/";
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
            System.out.println(json);
            /*
            Traslado de la infomación en formato Json al objeto del tipo record con nombre SolicitudConversion
             */
            SolicitudConversion solicitudConversion = gson.fromJson(json, SolicitudConversion.class);
            System.out.println(solicitudConversion);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }




    }
}
