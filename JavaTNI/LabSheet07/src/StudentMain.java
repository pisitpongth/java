public class StudentMain {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Malee";
        s1.id = "25131110000";

        s1.showStatus();
        System.out.println("------------------------------");

        s1.doHomework(15);
        s1.showStatus();
        System.out.println("------------------------------");

        s1.takeExam(40);
        s1.showStatus();
        System.out.println("------------------------------");

        s1.takeExam(30);
        s1.showStatus();
        System.out.println("------------------------------");
    }
}
