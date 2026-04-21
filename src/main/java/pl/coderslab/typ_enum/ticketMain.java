package pl.coderslab.typ_enum;

import java.util.Scanner;

public class ticketMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicketMachine machine = new TicketMachine();

        System.out.println("DOSTĘPNE RODZAJE BILETÓW");
        System.out.println("NORMAL, CHILD, SENIOR, STUDENT");
        System.out.println("wybierz rodzaj biletu: ");
        String userType = scanner.nextLine().toUpperCase();

        try {
            TicketType ticketType = TicketType.valueOf(userType);
            Ticket ticket = new Ticket(ticketType);
            double price = machine.calculatePrice(ticket);
            ticket.setPrice(price);

            System.out.println("Cena biletu: " + ticket.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println("Błędny typ biletu");
        }
        scanner.close();

    }
}
