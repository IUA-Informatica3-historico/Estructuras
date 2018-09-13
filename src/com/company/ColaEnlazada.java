package com.company;

public class ColaEnlazada {
    private Nodo entrada;
    private Nodo salida;

    ColaEnlazada() {
        entrada = null;
        salida = null;
    }

    void encolar(int d) {
        Nodo aux = new Nodo(d);
        if (entrada != null)
            entrada.setNext(aux);
        entrada = aux;
        if (salida == null)
            salida = entrada;
    }

    int desencolar() throws Exception {
        if (salida == null)
            throw new Exception("Cola vacia");

        int res = salida.getDato();
        salida = salida.getNext();
        if (salida == null)
            entrada = null;
        return res;
    }

    boolean esVacia() {
        return salida == null;
    }

    void vaciar() {
        entrada = null;
        salida = null;
    }
}
