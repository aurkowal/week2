package pl.coderslab.parametryzowanie_testow_enum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class SquareCalculatorTest {

    @ParameterizedTest
    @EnumSource(SquareScenario.class)
    void testSquareCalc(SquareScenario squareScenario) {
        int input = squareScenario.input;
        int expected = squareScenario.expectedOutput;

        int result = SquareCalculator.square(input);

        assertEquals(expected, result);
    }

}