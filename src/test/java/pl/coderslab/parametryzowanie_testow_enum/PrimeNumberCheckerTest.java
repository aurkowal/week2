package pl.coderslab.parametryzowanie_testow_enum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberCheckerTest {

    @ParameterizedTest
    @EnumSource(PrimeScenario.class)
    void testIsPrime(PrimeScenario scenario) {
        boolean result = PrimeNumberChecker.isPrime(scenario.number);

        assertEquals(scenario.expected, result);
    }

}