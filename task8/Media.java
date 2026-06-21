public class Media {
    private String title;
    private int duration; // in seconds

    public Media() {
        this.title = "Untitled Media";
        this.duration = 0;
    }

    public Media(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() { 
        return title; 
    }
    
    public void setTitle(String title) { 
        this.title = title; 
    }

    public int getDuration() { 
        return duration; 
    }
    
    public void setDuration(int duration) throws InvalidTrackException {
        if (duration < 0) {
            throw new InvalidTrackException("Duration cannot be negative!");
        }
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Media{title='" + title + "', duration=" + duration + "s}";
    }
}
