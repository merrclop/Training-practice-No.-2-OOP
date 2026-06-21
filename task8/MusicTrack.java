public class MusicTrack extends Media {
    private String artist;

    public MusicTrack() {
        super();
        this.artist = "Unknown Artist";
    }

    public MusicTrack(String title, int duration, String artist) throws InvalidTrackException {
        super(title, duration);
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidTrackException("Track title cannot be empty!");
        }
        this.artist = artist;
    }

    public String getArtist() { 
        return artist; 
    }
    
    public void setArtist(String artist) { 
        this.artist = artist; 
    }

    // Subclass specific playback method
    public void play() {
        int minutes = getDuration() / 60;
        int seconds = getDuration() % 60;
        System.out.println("▶️ Playing: '" + getTitle() + "' by " + artist + " [" + String.format("%02d:%02d", minutes, seconds) + "]");
    }

    @Override
    public String toString() {
        return "MusicTrack{title='" + getTitle() + "', artist='" + artist + "', duration=" + getDuration() + "s}";
    }
}
