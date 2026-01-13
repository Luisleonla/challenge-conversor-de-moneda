package com.alura.challengeconversor.acciones;

import com.alura.challengeconversor.modelos.ConfiguracionMoneda;
import com.alura.challengeconversor.modelos.Monedas;

import java.util.ArrayList;
import java.util.List;

public class OpcionesYEntradaDatos {
    //Creación y adición de base de datos de opciones de conversión en una lista para busqueda condicional.
    private final List<ConfiguracionMoneda> listaDeOpciones;

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
    /*
    Muestra menú de opciones de conversión, realiza un barrida por todos los elementos de nuestra lista y extrae el
    valor coincidente de nuestro Enum declarado con códigos y descripciones.
     */

    public void mostrarMenu() {
        System.out.println("""
                ****************************************************
                Gracias por usar el servicio de conversión de moneda León.
                Indicanos la opción que deseas:
                """);
        System.out.println(0 + ") Salir");
        for (ConfiguracionMoneda conf : listaDeOpciones) {
            System.out.println(conf.obtenerLineaMenu());
        }
        System.out.println("""
                ****************************************************
                Elija una opción valida""");
    }
    /*
    Método que retorna el conjunto de datos de la conversión elegida a partir de una busqueda de elementos en nuestra
    lista, usando el método Stream.
     */

    public ConfiguracionMoneda buscarPorId(int idUsuario) {
        return listaDeOpciones.stream()
                .filter(c -> c.id() == idUsuario)
                .findFirst()
                .orElse(null);
    }

}

