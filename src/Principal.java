import com.alura.challengeconversor.acciones.LlamadoConversor;
import com.alura.challengeconversor.acciones.OpcionesYEntradaDatos;
import com.alura.challengeconversor.modelos.ConfiguracionMoneda;

import java.net.http.HttpClient;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        /*
        Se declara un objeto de nuestra clase OpcionesYEntradaDatos, misma que contiene los métodos para lanzar el menú
        y que busca la opción que se ha escogido para la conversión de moneda.
         */
        OpcionesYEntradaDatos gestor = new OpcionesYEntradaDatos();
        /*
        Ciclo While que permite lanzar el menú indeterminadamente mientras que el usuario no lanze una solicitud
        expresa para finalizar el programa, tecleando la opción 0.
         */
        Scanner scanner = new Scanner(System.in);
        /*
    Creación del ciente para la consulta.
     */
        HttpClient cliente = HttpClient.newHttpClient();
        LlamadoConversor llamado = new LlamadoConversor();


        while (true) {
            /*
            Instanciamos el método mostrarMenu() de nuestro objeto gestor generado a partir de la clase del tipo
            Configuración moneda, posteriormente se crea una variable scanner del tipo Scanner para poder guardar la
            entrada de datos del cliente.
             */
            gestor.mostrarMenu();
            int opcion = scanner.nextInt();
            /*
            En principio se una un condicional para evaluar si el usuario a decidido cerrar el programa con lo que se
            lanzara una leyenda de finalización.
             */
            if (opcion == 0) {
                System.out.println("""
                        ++++++++++++++++++++++++++++++++++++++++++
                        Gracias por usar nuestro servicio de conversión de monesa.
                        Vuelva pronto.""");
                break;
            }
            /*
            Si se desea que el programa siga corriendo, se instanciará el metodo buscarPorId(opcion), de nuestro objeto
            gestor para extraer el conjunto de datos necesario para realizar la conversión deseada y se complementará
            con el nuevo scanner para solicitar el monto a convertir.
            En caso de que nuestro método buscarPorId nos devuelva null como resultado, se activará la condición else
            para marcar el error y hacer notar que la oçión ingresada no es valida.
             */

            ConfiguracionMoneda datosDeEntrada = gestor.buscarPorId(opcion);
            if (datosDeEntrada != null) {

                System.out.println("Digita el monto que deseas convertir");
                double monto = scanner.nextDouble();

                double tasa = llamado.tasaConversion(datosDeEntrada, cliente);
                double conversion = llamado.getConversion(monto, tasa);

                System.out.printf("""
                        Elejiste convertir de %s a %s, un monto de: %.2f %s.
                        La conversión final es: %.2f %s.
                        """,
                        datosDeEntrada.base().getDescripcion(),
                        datosDeEntrada.objetivo().getDescripcion(),
                        monto,
                        datosDeEntrada.base().name(),
                        conversion,
                        datosDeEntrada.objetivo().name());
            } else {
                System.out.println("Opción no valida, intente con otra opción");
            }
        }
    }
}
