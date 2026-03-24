package TNI_Lab.LabSheet;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class LabSheet05 {
        public static void main(String[] args) {
                final int price_per_person = 299;
                DecimalFormat frm = new DecimalFormat("#,###.00");
                int customer = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "How many customer?",
                                "Input",
                                JOptionPane.QUESTION_MESSAGE));
                double price_with_net = customer * price_per_person;
                double coupon = Double.parseDouble(JOptionPane.showInputDialog(null,
                                "Price with NET is " + frm.format(price_with_net + (price_with_net * 0.07))
                                                + "\nHow much of discount(%) on your coupon?",
                                "Input",
                                JOptionPane.QUESTION_MESSAGE));
                double price = (price_with_net + (price_with_net * 0.07));
                double total_price = price - (price * coupon / 100);
                double paid = Double.parseDouble(JOptionPane.showInputDialog(null,
                                "Total price is " + frm.format(total_price) + " baht"
                                                + "\nEnter the amount the customer paid:",
                                JOptionPane.QUESTION_MESSAGE));
                double change = paid - total_price;

                JOptionPane.showMessageDialog(null,
                                "Total price " + frm.format(total_price) + " baht." +
                                                "\nCustomer paid " + paid + " baht." +
                                                "\nGet change " + frm.format(change) + " baht.");
        }
}
