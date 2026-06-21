public class Album {
    private String albumName;
    private MusicTrack[] tracks;
    private int trackCount;

    public Album() {
        this.albumName = "Unknown Album";
        this.tracks = new MusicTrack[5];
        this.trackCount = 0;
    }

    public Album(String albumName, int maxTracks) {
        this.albumName = albumName;
        this.tracks = new MusicTrack[maxTracks];
        this.trackCount = 0;
    }

    // Method to handle safe array composition insertion
    public void addTrack(MusicTrack track) {
        if (trackCount < tracks.length) {
            tracks[trackCount] = track;
            trackCount++;
            System.out.println("Track added successfully: " + track.getTitle());
        } else {
            System.out.println("Error: Album is full!");
        }
    }

    public String getAlbumName() { return albumName; }
    public MusicTrack[] getTracks() { return tracks; }
    public int getTrackCount() { return trackCount; }

    @Override
    public String toString() {
        return "Album{name='" + albumName + "', tracksCount=" + trackCount + "}";
    }
}
