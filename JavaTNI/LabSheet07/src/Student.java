public class Student {
    public String name;
    public String id;
    public int score = 0;

    public void doHomework(int point) {
        this.score += point;
        System.out.println(this.name + " did homework " + point + " points");
    }

    public void takeExam(int point) {
        this.score += point;
        System.out.println(this.name + " took exam " + point + " points");
    }

    public String getResult() {
        if (this.score >= 50) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    public void showStatus() {
        System.out.println("Name: " + this.name +
                "\nStudent ID: " + this.id +
                "\nScore: " + this.score +
                "\nResult: " + getResult());
    }
}
