package com.company;

public class Nodo {
    private int dato;
    private Nodo next;

    Nodo() {
        next = null;
    }

    Nodo(int d) {
        next = null;
        dato = d;
    }

    Nodo(int d, Nodo n) {
        next = n;
        dato = d;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
