package fr.bts.iris.slam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe Calculator.
 * 
 * Ce fichier sert de template pour apprendre :
 * - Structure AAA (Arrange-Act-Assert)
 * - Nommage descriptif des tests
 * - Tests de cas normaux et d'exceptions
 * - Utilisation de @BeforeEach pour la préparation commune
 */
class CalculatorTest {
    
    private Calculator calculator;
    
    /**
     * Méthode exécutée AVANT chaque test
     * Évite la duplication de code de préparation
     */
    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
    }
    
    // === TESTS D'ADDITION ===
    
    @Test
    public void shouldAddPositiveNumbers() {
        // ARRANGE - Préparer les données
        int a = 5;
        int b = 3;
        
        // ACT - Exécuter l'action à tester
        int result = this.calculator.add(a, b);
        
        // ASSERT - Vérifier le résultat
        assertEquals(8, result);
    }
    
    @Test
    public void shouldAddNegativeNumbers() {
        // ARRANGE - Préparer les données
        int a = -5;
        int b = -3;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.add(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(-8, result);
    }
    
    @Test
    public void shouldAddZero() {
        // ARRANGE - Préparer les données
        int a = 5;
        int b = 0;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.add(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(5, result);
    }
    
    // === TESTS DE SOUSTRACTION ===
    
    @Test
    public void shouldSubtractNumbers() {
        // ARRANGE - Préparer les données
        int a = 10;
        int b = 3;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.subtract(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(7, result);
    }
    
    @Test
    public void shouldSubtractResultingInNegative() {
        // ARRANGE - Préparer les données
        int a = 3;
        int b = 10;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.subtract(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(-7, result);
    }
    
    // === TESTS DE MULTIPLICATION ===
    
    @Test
    public void shouldMultiplyNumbers() {
        // ARRANGE - Préparer les données
        int a = 4;
        int b = 3;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.multiply(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(12, result);
    }
    
    @Test
    public void shouldReturnZeroWhenMultiplyingByZero() {
        // ARRANGE - Préparer les données
        int a = 5;
        int b = 0;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.multiply(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(0, result);
    }
    
    @Test
    public void shouldMultiplyNegativeNumbers() {
        // ARRANGE - Préparer les données
        int a = -2;
        int b = -3;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.multiply(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(6, result);
    }
    
    // === TESTS DE DIVISION ===
    
    @Test
    public void shouldDivideNumbers() {
        // ARRANGE - Préparer les données
        double a = 15.0;
        double b = 3.0;

        // ACT - Exécuter l'action à tester
        double result = this.calculator.divide(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(5.0, result);
    }
    
    @Test
    public void shouldThrowExceptionWhenDividingByZero() {
        // ARRANGE - Préparer les données
        double a = 5.0;
        double b = 0;

        // ACT - Exécuter l'action à tester + ASSERT - Vérifier le résultat
        assertThrows(ArithmeticException.class, () -> {
            this.calculator.divide(a, b);
        });
    }
    
    // === TESTS FACTORIELLE ===
    
    @Test
    public void shouldCalculateFactorialOfPositiveNumber() {
        // ARRANGE - Préparer les données
        int a = 5;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.factorial(a);

        // ASSERT - Vérifier le résultat
        assertEquals(120, result);
    }
    
    @Test
    public void shouldReturnOneForFactorialOfZero() {
        // ARRANGE - Préparer les données
        int a = 0;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.factorial(a);

        // ASSERT - Vérifier le résultat
        assertEquals(1, result);
    }
    
    @Test
    public void shouldReturnOneForFactorialOfOne() {
        // ARRANGE - Préparer les données
        int a = 1;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.factorial(a);

        // ASSERT - Vérifier le résultat
        assertEquals(1, result);
    }
    
    @Test
    public void shouldThrowExceptionForNegativeFactorial() {
        // ARRANGE - Préparer les données
        int a = -5;

        // ACT - Exécuter l'action à tester + ASSERT - Vérifier le résultat
        assertThrows(IllegalArgumentException.class, () -> {
            this.calculator.factorial(a);
        });
    }
    
    // === TESTS NOMBRE PAIR ===
    
    @Test
    public void shouldReturnTrueForEvenNumbers() {
        // ARRANGE - Préparer les données
        int a = 0;
        int b = 2;
        int c = 4;
        int d = 100;

        // ACT - Exécuter l'action à tester
        boolean result_a = this.calculator.isEven(a);
        boolean result_b = this.calculator.isEven(b);
        boolean result_c = this.calculator.isEven(c);
        boolean result_d = this.calculator.isEven(d);

        // ASSERT - Vérifier le résultat
        assertTrue(result_a);
        assertTrue(result_b);
        assertTrue(result_c);
        assertTrue(result_d);
    }
    
    @Test
    public void shouldReturnFalseForOddNumbers() {
        // ARRANGE - Préparer les données
        int a = 1;
        int b = 3;
        int c = 5;
        int d = 99;

        // ACT - Exécuter l'action à tester
        boolean result_a = this.calculator.isEven(a);
        boolean result_b = this.calculator.isEven(b);
        boolean result_c = this.calculator.isEven(c);
        boolean result_d = this.calculator.isEven(d);

        // ASSERT - Vérifier le résultat
        assertFalse(result_a);
        assertFalse(result_b);
        assertFalse(result_c);
        assertFalse(result_d);
    }
    
    // === TESTS PUISSANCE ===
    
    @Test
    public void shouldCalculatePowerCorrectly() {
        // ARRANGE - Préparer les données
        double a = 2;
        int b = 3;

        // ACT - Exécuter l'action à tester + ASSERT - Vérifier le résultat
        assertEquals(8.0, calculator.power(a, b), 0.001);
    }
    
    @Test
    public void shouldReturnOneForPowerZero() {
        // ARRANGE - Préparer les données
        double a = 2;
        int b = 0;

        // ACT - Exécuter l'action à tester + ASSERT - Vérifier le résultat
        assertEquals(1.0, calculator.power(a, b), 0.001);
    }
    
    @Test
    public void shouldThrowExceptionForNegativeExponent() {
        // ARRANGE - Préparer les données
        double a = 2;
        int b = -3;

        // ACT - Exécuter l'action à tester + ASSERT - Vérifier le résultat
        assertThrows(IllegalArgumentException.class, () -> {
            this.calculator.power(a, b);
        });
    }
    
    // === TESTS SUPPLÉMENTAIRES ===

    @Test
    public void souldCombineAddAndMultiply() {
        // ARRANGE - Préparer les données
        int a = 5;
        int b = 3;
        int c = 10;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.multiply(this.calculator.add(a, b), c);

        // ASSERT - Vérifier le résultat
        assertEquals(80, result);
    }

    @Test
    public void shouldReturnTrueForNegativeEvenNumbers() {
        // ARRANGE - Préparer les données
        int a = 0;
        int b = -2;
        int c = -4;
        int d = -100;

        // ACT - Exécuter l'action à tester
        boolean result_a = this.calculator.isEven(a);
        boolean result_b = this.calculator.isEven(b);
        boolean result_c = this.calculator.isEven(c);
        boolean result_d = this.calculator.isEven(d);

        // ASSERT - Vérifier le résultat
        assertTrue(result_a);
        assertTrue(result_b);
        assertTrue(result_c);
        assertTrue(result_d);
    }
}