import com.alura.challengeconversor.acciones.Conversion;
import com.alura.challengeconversor.acciones.LlamadoConversor;
import com.alura.challengeconversor.acciones.OpcionesYEntradaDatos;
import com.alura.challengeconversor.modelos.SolicitudConversion;

public class Principal {
    //private static Object Monedas;

    public static void main(String[] args) {
        //Se determinana el tipo de cambio que se desea y el monto
        OpcionesYEntradaDatos gestor = new OpcionesYEntradaDatos();
        gestor.mostrarMenu();
//        SolicitudConversion datosDeEntrada = lanzarMenu.recabarDatos();
//        System.out.println(datosDeEntrada);
//
//        String monedaObjetivo = datosDeEntrada.monedaObjetivo();
//        String monedaBase = datosDeEntrada.monedaBase();
//        double montoAConvertir = datosDeEntrada.montoAConvertir();
//
//        LlamadoConversor llamado = new LlamadoConversor();
//        double tasa = llamado.tasaConversion(monedaBase, monedaObjetivo);
//        //System.out.println(tasa);
//        Conversion conversion = new Conversion();
//        double montoConvertido = conversion.conversionDeMoneda(montoAConvertir, tasa);
//        System.out.println("La conversión de " + montoAConvertir + " es: " + montoConvertido);
    }
}
