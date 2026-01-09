import com.alura.challengeconversor.acciones.Conversion;
import com.alura.challengeconversor.acciones.LlamadoConversor;
import com.alura.challengeconversor.modelos.Monedas;
import com.alura.challengeconversor.modelos.SolicitudConversion;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    //private static Object Monedas;

    public static void main(String[] args) {
        //Se determinana el tipo de cambio que se desea y el monto
        String monedaObjetivo = Monedas.USD.name();

        String monedaBase = Monedas.MXN.name();
        int montoAConvertir = 20;
        LlamadoConversor llamado = new LlamadoConversor();
        double tasa = llamado.tasaConversion(monedaBase, monedaObjetivo);
        //System.out.println(tasa);
        Conversion conversion = new Conversion();
        double montoConvertido = conversion.conversionDeMoneda(montoAConvertir, tasa);
        System.out.println("La conversión de " + montoAConvertir + " es: " + montoConvertido);
    }
}
