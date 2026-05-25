import java.util.Scanner;

public class MusicTrack {
    // 2. All fields are private (Encapsulation)
    private String title;
    private String artist;
    private int duration; // duration in seconds

    // 3. No-argument constructor
    public MusicTrack() {
        this.title = "Unknown Title";
        this.artist = "Unknown Artist";
        this.duration = 0;
    }

    // 3. Parameterized constructor
    public MusicTrack(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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

    public void setDuration(int duration) {
        if (duration >= 0) {
            this.duration = duration;
        } else {
            System.out.println("Error: Duration cannot be negative!");
        }
    }

    // Data input method
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter track title: ");
        this.title = scanner.nextLine();
        
        System.out.print("Enter artist name: ");
        this.artist = scanner.nextLine();
        
        System.out.print("Enter track duration (in seconds): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number of seconds!");
            scanner.next();
        }
        this.duration = scanner.nextInt();
    }

    // Data output method (Displaying information)
    public void displayInfo() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        System.out.println("--- Track Information ---");
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.printf("Duration: %d sec (%02d:%02d)\n", duration, minutes, seconds);
        System.out.println("-------------------------");
    }

    // toString() method
    @Override
    public String toString() {
        return "MusicTrack{title='" + title + "', artist='" + artist + "', duration=" + duration + "s}";
    }

    // Methods specific to Variant 8:

    // 1. Change duration
    public void changeDuration(int newDuration) {
        if (newDuration >= 0) {
            this.duration = newDuration;
            System.out.println("The duration of '" + title + "' was successfully changed to " + newDuration + " seconds.");
        } else {
            System.out.println("Error: Cannot set a negative duration.");
        }
    }

    // 2. Check track length (e.g., checks if the track is "long" — longer than 5 minutes / 300 seconds)
    public boolean isLongTrack() {
        return this.duration > 300;
    }
}
