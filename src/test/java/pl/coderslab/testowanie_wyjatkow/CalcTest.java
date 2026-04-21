package pl.coderslab.testowanie_wyjatkow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void testFactorial() {
        Calc calc = new Calc();
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-19));
    }

    @Test
    void testSqrt() {
        Calc calc = new Calc();
        NegativeNumberException exception = assertThrows(NegativeNumberException.class, () -> calc.sqrt(-11));

        assertEquals("Negative number is not acceptable", exception.getMessage());
    }

}