public class MusicAlbum extends Album {
    private String genre;

    public MusicAlbum(String albumName, int maxTracks, String genre) {
        super(albumName, maxTracks);
        this.genre = genre;
    }

    public String getGenre() { 
        return genre; 
    }
    
    public void setGenre(String genre) { 
        this.genre = genre; 
    }

    // Calculation tool to sum up total duration
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
        System.out.printf("Aggregate Album Duration: %d seconds (%02d:%02d)\n", 
            totalSeconds, totalSeconds / 60, totalSeconds % 60);
    }

    @Override
    public String toString() {
        return "MusicAlbum{name='" + getAlbumName() + "', genre='" + genre + 
               "', tracks=" + getTrackCount() + ", totalDuration=" + calculateTotalDuration() + "s}";
    }
}
