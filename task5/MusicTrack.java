public class MusicTrack extends Media {
    private String artist;

    public MusicTrack() {
        super();
        this.artist = "Unknown Artist";
    }

    public MusicTrack(String title, int duration, String artist) {
        super(title, duration);
        this.artist = artist;
    }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    @Override
    public String toString() {
        return "MusicTrack{title='" + getTitle() + "', artist='" + artist + "', duration=" + getDuration() + "s}";
    }
}
