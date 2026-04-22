package pl.coderslab.assertJ;

public enum Status {
    COMPLETED("zakończone"),
    IN_PROGRESS("w trakcie"),
    NOT_STARTED("nie rozpoczęte");

    private final String description;

    Status(String description) {
        this.description = description;
    }
}
