package com.company;

public class Main {

    public static void main(String[] args) {
        Arbol<Integer> a = new Arbol<>();
        for (int i = 0; i < 1000; i++)
            try {
                a.insertar((int) (Math.random() * 100) + 1);

            } catch (Exception e) {
               // System.out.println("Error");
            }
        a.print();
    }

}
