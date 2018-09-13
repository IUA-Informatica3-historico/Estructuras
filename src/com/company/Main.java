package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        QueueArr c = new QueueArr(3);

        System.out.println(c.estaLlena());
        System.out.println(c.estaVacia());
        try {
            c.encolar(1);
            c.encolar(2);
            c.encolar(3);
            System.out.println(c.estaLlena());

            System.out.println(c.desencolar());
            c.encolar(4);
            System.out.println(c.desencolar());
            System.out.println(c.desencolar());
            System.out.println(c.desencolar());
            System.out.println(c.estaVacia());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            c.encolar(1);
            c.encolar(2);
            c.encolar(3);
            c.encolar(4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            c.desencolar();
            c.desencolar();
            c.desencolar();
            c.desencolar();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
