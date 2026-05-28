public class Album {
    // Private fields
    private String albumName;
    private String artist;
    private int releaseYear;
    private MusicTrack[] tracks; // Composition: Album contains an array of MusicTracks
    private int trackCount;      // Counter for currently added tracks

    // Static Nested Class
    public static class MusicTrack {
        private String title;
        private int duration; // in seconds

        // Constructors
        public MusicTrack() {
            this.title = "Unknown Track";
            this.duration = 0;
        }

        public MusicTrack(String title, int duration) {
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
            }
        }

        @Override
        public String toString() {
            return "MusicTrack{title='" + title + "', duration=" + duration + "s}";
        }
    }

    // --- Album Class Implementation ---

    // Constructors
    public Album() {
        this.albumName = "Unknown Album";
        this.artist = "Unknown Artist";
        this.releaseYear = 2000;
        this.tracks = new MusicTrack[5]; // Default capacity of 5 tracks
        this.trackCount = 0;
    }

    public Album(String albumName, String artist, int releaseYear, int maxTracks) {
        this.albumName = albumName;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.tracks = new MusicTrack[maxTracks]; // Custom capacity
        this.trackCount = 0;
    }

    // Additional Task: Method to add a track to the album
    public void addTrack(MusicTrack track) {
        if (track == null) {
            System.out.println("Error: Cannot add a null track.");
            return;
        }
        if (trackCount < tracks.length) {
            tracks[trackCount] = track;
            trackCount++;
            System.out.println("Track '" + track.getTitle() + "' successfully added to the album '" + albumName + "'.");
        } else {
            System.out.println("Error: Cannot add '" + track.getTitle() + "'. Album is full! (Max capacity: " + tracks.length + ")");
        }
    }

    // Getters and Setters
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public MusicTrack[] getTracks() {
        return tracks;
    }

    // Setter for the whole array (with reset of counter)
    public void setTracks(MusicTrack[] tracks) {
        this.tracks = tracks;
        this.trackCount = (tracks != null) ? tracks.length : 0;
    }

    public int getTrackCount() {
        return trackCount;
    }

    // Custom display method to review the album state
    public void displayAlbumDetails() {
        System.out.println("\n=========================================");
        System.out.println("ALBUM: " + albumName + " (" + releaseYear + ") by " + artist);
        System.out.println("Tracks added: " + trackCount + "/" + tracks.length);
        System.out.println("-----------------------------------------");
        if (trackCount == 0) {
            System.out.println("  [No tracks in this album yet]");
        } else {
            for (int i = 0; i < trackCount; i++) {
                System.out.printf("  %d. %s (%d:%02d)\n", 
                    (i + 1), 
                    tracks[i].getTitle(), 
                    tracks[i].getDuration() / 60, 
                    tracks[i].getDuration() % 60
                );
            }
        }
        System.out.println("=========================================");
    }

    // toString Method
    @Override
    public String toString() {
        StringBuilder tracksString = new StringBuilder("[");
        for (int i = 0; i < trackCount; i++) {
            tracksString.append(tracks[i].toString());
            if (i < trackCount - 1) tracksString.append(", ");
        }
        tracksString.append("]");

        return "Album{albumName='" + albumName + "', artist='" + artist + 
               "', releaseYear=" + releaseYear + ", maxCapacity=" + tracks.length + 
               ", currentTracks=" + tracksString.toString() + "}";
    }
}
