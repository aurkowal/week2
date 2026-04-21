package pl.coderslab.parametryzowanie_testow_enum;

public enum PrimeScenario {
    TWO(2, true),
    THREE(3, true),
    FOUR(4, false),
    FIVE(5, true),
    SIX(6, false),
    SEVEN(7, true),
    EIGHT(8, false),
    NINE(9, false),
    TEN(10, false),
    ELEVEN(11, true),
    TWELVE(12, false);


    final int number;
    final boolean expected;

    PrimeScenario(int number, boolean expected) {
        this.expected = expected;
        this.number = number;
    }
}
