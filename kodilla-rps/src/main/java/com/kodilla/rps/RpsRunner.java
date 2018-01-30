package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        while( ! end) {
            System.out.println("Hello");
            end = true;
            int[] tablica = {1,2,3,4,5};
            for (int temp: tablica) {
                System.out.println(temp);
            }
        }
    }
}
