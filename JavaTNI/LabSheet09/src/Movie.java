public class Movie {
    private String title;
    private int minutes;
    private String rating;

    public Movie(String title, int minutes, String rating) {
        this.title = title;
        this.minutes = minutes;
        this.rating = rating;
    }

    public Movie() {
        this.title = "";
        this.minutes = 0;
        this.rating = "";
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return this.title + " (" + this.rating + ", " + this.minutes + " mins)";
    }
}
