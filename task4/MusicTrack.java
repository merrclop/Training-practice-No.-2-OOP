// Inheritance: MusicTrack inherits from Media
public class MusicTrack extends Media {
    // Specific field for the subclass
    private String artist;

    // Constructors
    public MusicTrack() {
        super(); // Calls the no-argument constructor of Media
        this.artist = "Unknown Artist";
    }

    public MusicTrack(String title, int duration, String artist) {
        super(title, duration); // Passes parameters to the Media constructor
        this.artist = artist;
    }

    // Getters and Setters for the subclass field
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Additional Task: Method to play the track
    public void play() {
        int minutes = getDuration() / 60;
        int seconds = getDuration() % 60;
        System.out.println("Now playing: '" + getTitle() + "' by " + artist + " [" + String.format("%02d:%02d", minutes, seconds) + "]");
    }

    // 5. Overriding the toString() method from the base class
    @Override
    public String toString() {
        // Utilizing super.getTitle() and super.getDuration() because base fields are private
        return "MusicTrack{title='" + getTitle() + "', artist='" + artist + "', duration=" + getDuration() + "s}";
    }
}
