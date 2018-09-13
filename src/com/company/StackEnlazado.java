package com.company;

public class StackEnlazado {
    private Nodo tope;

    StackEnlazado() {
        tope = null;
    }

    void push(int d) {
        Nodo aux = new Nodo(d, tope);
        tope = aux;
        // tope = new Nodo(d, tope);
    }

    int pop() throws Exception {
        if (tope == null)
            throw new Exception("stack vacio");
        int res = tope.getDato();
        tope = tope.getNext();
        return res;
    }

    boolean esVacia() {
        return tope == null;
    }

    void vaciar() {
        tope = null;
    }
}
