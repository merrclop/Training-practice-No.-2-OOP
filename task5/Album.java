public class Album {
    private String albumName;
    private MusicTrack[] tracks;
    private int trackCount;

    public Album() {
        this.albumName = "Unknown Album";
        this.tracks = new MusicTrack[10];
        this.trackCount = 0;
    }

    public Album(String albumName, int maxTracks) {
        this.albumName = albumName;
        this.tracks = new MusicTrack[maxTracks];
        this.trackCount = 0;
    }

    public void addTrack(MusicTrack track) {
        if (trackCount < tracks.length) {
            tracks[trackCount] = track;
            trackCount++;
        } else {
            System.out.println("Album is full!");
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
