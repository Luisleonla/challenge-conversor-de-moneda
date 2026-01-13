package com.alura.challengeconversor.acciones;

import com.alura.challengeconversor.modelos.ConfiguracionMoneda;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlamadoConversor implements Conversion {

    private final String apiKey = System.getenv("EXCHANGE_RATE_KEY");

    public double tasaConversion(ConfiguracionMoneda datosDeEntrada, HttpClient cliente) {

        String monedaObjetivo = datosDeEntrada.objetivo().name();
        String monedaBase = datosDeEntrada.base().name();

        /*
        Investigar mas sobre esta línea. Misma que sirve para llamar la librería Gson para procesar la información en
        formato Json
         */

        Gson gson = new GsonBuilder()
                .setPrettyPrinting().create();

    /*
    Generación de la URI dinámica, se ha excluido el argumento montoACovertir debido a que se optó por hacer la lógica
    de conversión de manera interna en el programa.
     */
        String url = "https://v6.exchangerate-api.com/v6/"+ apiKey + "/pair/"
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
            JsonElement elemento = JsonParser.parseString(json);
            JsonObject objectRoot = elemento.getAsJsonObject();//Muestra toda la información en formato Json
            return objectRoot.get("conversion_rate").getAsDouble();//Retorna el valor de la tasa de conversión

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getConversion(double monto, double tasa) {
        return monto * tasa;
    }
}
