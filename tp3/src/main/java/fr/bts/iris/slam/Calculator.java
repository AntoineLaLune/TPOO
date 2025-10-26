package fr.bts.iris.slam;

/**
 * Classe Calculator pour les premiers tests avec JUnit.
 * 
 * Cette classe contient des méthodes mathématiques simples pour apprendre
 * les concepts de base des tests unitaires :
 * - Comportement prévisible
 * - Cas normaux et cas d'erreur
 * - Gestion des exceptions
 */
public class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        }
        throw new ArithmeticException("Le diviseur est de zero");
    }
    
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("L'entrée est negative");
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i;
        }
        return res;
    }
    
    public boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public double power(double base, int exponent) {
        if (exponent < 0) {
            throw new  IllegalArgumentException("Erreur critique, explotion de la terre dans 10 seconde");
        }
        double ram = 1;
        for (int i = 0; i < exponent; i++) {
            ram = ram * base;
        }
        return ram;
    }
}