package TNI_Lab.LabSheet;

import javax.swing.JOptionPane;

public class LabSheet03 {
    public static String find_grade(int score) {
        if (score >= 80 && score <= 100)
            return "A";
        else if (score >= 70)
            return "B";
        else if (score >= 60)
            return "C";
        else if (score >= 50)
            return "D";
        else
            return "F";
    }

    public static int cal_score(int midterm, int Final) {
        return midterm + Final;
    }

    public static int input_score(String message, int limit_score) {
        int score;

        while (true) {
            score = Integer.parseInt(JOptionPane.showInputDialog(message));

            if (score >= 0 && score <= limit_score) {
                return score;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Score must be in range between 0 and " + limit_score);
            }
        }
    }

    public static void main(String[] args) {
        int confirm = JOptionPane.showConfirmDialog(null,
                "Do you want to check your score? ",
                "Check score",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "END PROGRAM!!");
            return;
        }
        int midterm = input_score("Enter mid-term score: ", 45);
        int Final = input_score("Enter final-score: ", 55);
        int total = cal_score(midterm, Final);
        String grade = find_grade(total);

        JOptionPane.showMessageDialog(null,
                "Total score = " + total + "\nGrade = " + grade);
    }
}
