package com.alura.challengeconversor.acciones;

import com.alura.challengeconversor.modelos.ConfiguracionMoneda;
import com.alura.challengeconversor.modelos.Monedas;

import java.util.ArrayList;
import java.util.List;

public class OpcionesYEntradaDatos {
    private List<ConfiguracionMoneda> listaDeOpciones;
    public OpcionesYEntradaDatos() {
        this.listaDeOpciones = new ArrayList<>();
        listaDeOpciones.add(new ConfiguracionMoneda(1, Monedas.USD, Monedas.MXN));
        listaDeOpciones.add(new ConfiguracionMoneda(2, Monedas.MXN, Monedas.USD));
        listaDeOpciones.add(new ConfiguracionMoneda(3, Monedas.USD, Monedas.ARS));
        listaDeOpciones.add(new ConfiguracionMoneda(4, Monedas.ARS, Monedas.USD));
        listaDeOpciones.add(new ConfiguracionMoneda(5, Monedas.USD, Monedas.BRL));
        listaDeOpciones.add(new ConfiguracionMoneda(6, Monedas.BRL, Monedas.USD));
        listaDeOpciones.add(new ConfiguracionMoneda(7, Monedas.USD, Monedas.COP));
        listaDeOpciones.add(new ConfiguracionMoneda(8, Monedas.COP, Monedas.USD));
        listaDeOpciones.add(new ConfiguracionMoneda(9, Monedas.USD, Monedas.BOB));
        listaDeOpciones.add(new ConfiguracionMoneda(10, Monedas.BOB, Monedas.USD));
        listaDeOpciones.add(new ConfiguracionMoneda(11, Monedas.USD, Monedas.CLP));
        listaDeOpciones.add(new ConfiguracionMoneda(12, Monedas.CLP, Monedas.USD));
    }

    //String monedaBase;
    //String monedaObjetivo;
    public void mostrarMenu(){
        System.out.println("""
                ****************************************************
                Gracias por usar el servicio de conversión de moneda León.
                Indicanos la opción que deseas:
                """);
        for(ConfiguracionMoneda conf : listaDeOpciones){
            System.out.println(conf.obtenerLineaMenu());
        }
    }
//    public SolicitudConversion recabarDatos() {
//
//        Scanner scanner = new Scanner(System.in);
//        int opcion = scanner.nextInt();
//
//        double monto = scanner.nextDouble();
//        return new SolicitudConversion(monedaBase, monedaObjetivo, monto);
//    }
}
