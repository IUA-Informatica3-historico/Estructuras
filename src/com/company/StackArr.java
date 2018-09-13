package com.company;

public class StackArr {
    private int tope;
    private int[] datos;

    public StackArr() {
        tope = -1;
        datos = new int[10];
    }

    public StackArr(int c) {
        tope = -1;
        datos = new int[c];
    }

    public void push(int d) throws Exception {
        if (tope + 1 >= datos.length)
            throw new Exception("Pila Llena");

        tope++;
        datos[tope] = d;
    }

    public int pop() throws Exception {
        if(tope < 0)
            throw new Exception("Pila vacia");

        return datos[tope--];
    }

    public boolean estaVacia() {
        return tope == -1;
    }
}
