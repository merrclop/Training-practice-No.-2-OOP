import java.util.Scanner;

public class Album {
    // Private fields for Album
    private String albumName;
    private String artist;
    private int releaseYear;
    private MusicTrack bonusTrack; // Composition: Album HAS A MusicTrack

    // 3. Static Nested Class (Вкладений клас)
    public static class MusicTrack {
        private String title;
        private int duration; // in seconds

        // Constructors for Nested Class
        public MusicTrack() {
            this.title = "Unknown Track";
            this.duration = 0;
        }

        public MusicTrack(String title, int duration) {
            this.title = title;
            this.duration = duration;
        }

        // Getters and Setters for Nested Class
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

        // Input method for Nested Class
        public void inputTrackData() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("  Enter bonus track title: ");
            this.title = scanner.nextLine();
            System.out.print("  Enter bonus track duration (seconds): ");
            while (!scanner.hasNextInt()) {
                System.out.println("  Please enter a valid number!");
                scanner.next();
            }
            this.duration = scanner.nextInt();
        }

        // toString for Nested Class
        @Override
        public String toString() {
            return "MusicTrack{title='" + title + "', duration=" + duration + "s}";
        }
    }

    // --- Album Class Implementation ---

    // Constructors for Album
    public Album() {
        this.albumName = "Unknown Album";
        this.artist = "Unknown Artist";
        this.releaseYear = 2000;
        this.bonusTrack = new MusicTrack(); // Initializing composition
    }

    public Album(String albumName, String artist, int releaseYear, MusicTrack bonusTrack) {
        this.albumName = albumName;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.bonusTrack = bonusTrack;
    }

    // Getters and Setters for Album
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

    public MusicTrack getBonusTrack() {
        return bonusTrack;
    }

    public void setBonusTrack(MusicTrack bonusTrack) {
        this.bonusTrack = bonusTrack;
    }

    // Input method for Album
    public void inputAlbumData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter album name: ");
        this.albumName = scanner.nextLine();
        System.out.print("Enter artist name: ");
        this.artist = scanner.nextLine();
        System.out.print("Enter release year: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid year!");
            scanner.next();
        }
        this.releaseYear = scanner.nextInt();
        
        System.out.println("Enter details for the bonus track:");
        this.bonusTrack.inputTrackData();
    }

    // Output method for Album
    public void displayAlbumInfo() {
        System.out.println("\n===================================");
        System.out.println("ALBUM INFO:");
        System.out.println("Name: " + albumName);
        System.out.println("Artist: " + artist);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Bonus Track Details:");
        System.out.println("  - Title: " + bonusTrack.getTitle());
        System.out.println("  - Duration: " + bonusTrack.getDuration() + " seconds");
        System.out.println("===================================");
    }

    // toString for Album
    @Override
    public String toString() {
        return "Album{albumName='" + albumName + "', artist='" + artist + 
               "', releaseYear=" + releaseYear + ", bonusTrack=" + bonusTrack + "}";
    }
}
