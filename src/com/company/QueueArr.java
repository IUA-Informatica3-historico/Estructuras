package com.company;

public class QueueArr {

    private int entrada;
    private int salida;

    private int[] datos;
    private int cantidad;

    public QueueArr() {
        entrada = 0;
        salida = 0;
        datos = new int[10];
        cantidad = 0;
    }

    public QueueArr(int t) {
        entrada = 0;
        salida = 0;
        datos = new int[t];
        cantidad = 0;
    }

    public void encolar(int d) throws Exception {
        if (estaLlena())
            throw new Exception("Cola llena: " + d);

        cantidad++;
        datos[entrada] = d;
        entrada = incrementar(entrada);
    }

    public int desencolar() throws Exception {
        if (estaVacia())
            throw new Exception("Cola vacia");

        cantidad--;
        int d = datos[salida];
        salida = incrementar(salida);
        return d;
    }

    public boolean estaVacia() {
        return entrada == salida && cantidad == 0;
    }

    public boolean estaLlena() {

        return entrada == salida && cantidad > 0;
    }

    public int mostrarSalida() {
        return datos[incrementar(salida)];
    }


    private int incrementar(int x) {
        return (x + 1) % datos.length;
    }


}
