public class Main {
    public static void main(String[] args) {
        System.out.println("=== Program Demonstration: Task 5 ===\n");

        System.out.println("Creating a new MusicAlbum instance...");
        MusicAlbum myAlbum = new MusicAlbum("After Hours", 5, "Synth-pop");

        MusicTrack track1 = new MusicTrack("Alone Again", 250, "The Weeknd");
        MusicTrack track2 = new MusicTrack("Too Late", 239, "The Weeknd");
        MusicTrack track3 = new MusicTrack("Blinding Lights", 200, "The Weeknd");

        myAlbum.addTrack(track1);
        myAlbum.addTrack(track2);
        myAlbum.addTrack(track3);

        System.out.println("\nTracks successfully added.");

        System.out.println("\n--- Executing Additional Task ---");
        myAlbum.displayTotalDuration();

        System.out.println("\n--- Testing Overridden toString() ---");
        System.out.println(myAlbum);
    }
}
