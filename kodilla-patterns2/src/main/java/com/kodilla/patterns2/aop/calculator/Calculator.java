package com.kodilla.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@EnableAspectJAutoProxy
public class Calculator {
    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return x / y;
    }

    public BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) > 0) {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        } else if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            throw new ArithmeticException("Factorial argument is negative!");
        }
    }
}
