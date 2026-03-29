import javax.swing.*;

public class TicketUsed {
    public static String show_movie_list(Ticket[] tickets) {
        String movie_list = "";

        for (int i = 0; i < tickets.length; i++) {
            movie_list += "T00" + (i + 1) + ": " + tickets[i].getMovie().toString() + "\n";
        }
        return movie_list;
    }

    public static void main(String[] args) {
        boolean is_loop = false;

        Ticket[] tickets = new Ticket[]{
                new Ticket("T001", new Movie("Titanic", 120, "PG-13"), "12:00", "B7", 280),
                new Ticket("T002", new Movie("Pokemon", 102, "PG"), "11:00", "G11", 240),
                new Ticket("T003", new Movie("Silent Hill", 125, "R-13"), "14:30", "H2", 240)
        };

        while (!is_loop) {
            int choice = JOptionPane.showConfirmDialog(null,
                    "Do you want to book or use a ticket?",
                    "Ticket",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                String ticket_id = JOptionPane.showInputDialog(show_movie_list(tickets) +
                        "\nEnter a ticket id for booking:");

                for (int i = 0; i < tickets.length; i++) {
                    String currentId = "T00" + (i + 1);

                    if (ticket_id.equalsIgnoreCase(currentId)) {
                        String menu = JOptionPane.showInputDialog("T00" + (i + 1) + ": " + tickets[i].getMovie().toString() +
                                "\n" +
                                "\nPress 1 to book a ticket" +
                                "\nPress 2 to use a ticket" +
                                "\nPress 3 to see a ticket status" +
                                "\n" +
                                "\nEnter a menu:");

                        switch (menu) {
                            case "1":
                                JOptionPane.showMessageDialog(null,
                                        tickets[i].bookTicket() +
                                                "\n--------------------" +
                                                "\n" + tickets[i].toString());
                                break;
                            case "2":
                                JOptionPane.showMessageDialog(null,
                                        tickets[i].useTicket() +
                                                "\n--------------------" +
                                                "\n" + tickets[i].toString());
                                break;
                            case "3":
                                JOptionPane.showMessageDialog(null, tickets[i].toString());
                                break;
                        }
                    }
                }
            } else {
                is_loop = true;
            }
        }
    }
}
