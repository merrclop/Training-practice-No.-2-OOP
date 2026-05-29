public class MusicAlbum extends Album {
    private String genre;

    public MusicAlbum() {
        super();
        this.genre = "Unknown Genre";
    }

    public MusicAlbum(String albumName, int maxTracks, String genre) {
        super(albumName, maxTracks); // FIXED: No more semicolon syntax error here
        this.genre = genre;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int calculateTotalDuration() {
        int totalSeconds = 0;
        MusicTrack[] albumTracks = getTracks();
        
        for (int i = 0; i < getTrackCount(); i++) {
            totalSeconds += albumTracks[i].getDuration();
        }
        return totalSeconds;
    }

    public void displayTotalDuration() {
        int totalSeconds = calculateTotalDuration();
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        System.out.printf("Total Album Duration: %d seconds (%02d:%02d)\n", totalSeconds, minutes, seconds);
    }

    @Override
    public String toString() {
        return "MusicAlbum{name='" + getAlbumName() + "', genre='" + genre + 
               "', tracksCount=" + getTrackCount() + ", totalDuration=" + calculateTotalDuration() + "s}";
    }
}
