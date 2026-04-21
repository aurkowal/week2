package pl.coderslab.typ_enum;

public class TicketMachine {


    public double calculatePrice(Ticket ticket) {
        switch (ticket.getType()) {
            case NORMAL:
                return 10.0;
            case CHILD:
                return 5.0;
            case SENIOR:
                return 6.0;
            case STUDENT:
                return 7.0;
            default:
                throw new IllegalArgumentException("Nieznany typ biletu");
        }
    }
}
