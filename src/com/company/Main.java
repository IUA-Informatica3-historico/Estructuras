package com.company;

public class Main {

    public static void main(String[] args) {
        ArbolAVL<Integer> a = new ArbolAVL<>();
        for (int i = 0; i < 10000; i++)
            try {
                int rand = (int) (Math.random() * 10000) + 1;
                a.insertar(rand);
                System.out.println(rand + " --------------------------------------------------------");
                a.print();

            } catch (Exception e) {
               // System.out.println("Error");
            }
    }

}
