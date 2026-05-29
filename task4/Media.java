public class Media {
    // Private fields for the base class
    private String title;
    private int duration; // in seconds

    // Constructors
    public Media() {
        this.title = "Untitled Media";
        this.duration = 0;
    }

    public Media(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration >= 0) {
            this.duration = duration;
        } else {
            System.out.println("Error: Duration cannot be negative.");
        }
    }

    // Base toString method
    @Override
    public String toString() {
        return "Media{title='" + title + "', duration=" + duration + "s}";
    }
}
