package com.kodilla.exception.test;

public class FirstChallenge {

    private double divide(double a, double b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result;
        try {
            result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e);
        } finally {
            result = 0;
        }

        System.out.println("Result: " + result);
    }
}
