public class MusicTrack {
    private String title;
    private String artist;
    private int duration; // in seconds

    public MusicTrack() {
        this.title = "Unknown Title";
        this.artist = "Unknown Artist";
        this.duration = 0;
    }

    // Constructor with built-in validation throwing a custom exception
    public MusicTrack(String title, String artist, int duration) throws InvalidTrackException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidTrackException("Track title cannot be empty or null!");
        }
        if (duration < 0) {
            throw new InvalidTrackException("Track duration cannot be negative (" + duration + "s)!");
        }
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() { 
        return title; 
    }

    public void setTitle(String title) throws InvalidTrackException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidTrackException("Track title cannot be empty!");
        }
        this.title = title;
    }

    public String getArtist() { 
        return artist; 
    }
    
    public void setArtist(String artist) { 
        this.artist = artist; 
    }

    public int getDuration() { 
        return duration; 
    }

    public void setDuration(int duration) throws InvalidTrackException {
        if (duration < 0) {
            throw new InvalidTrackException("Duration cannot be negative: " + duration + "s");
        }
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "MusicTrack{title='" + title + "', artist='" + artist + "', duration=" + duration + "s}";
    }
}
