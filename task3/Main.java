public class Main {
    public static void main(String[] args) {
        System.out.println("=== Program Demonstration: Task 3 ===\n");

        // 1. Initializing an empty album with a maximum capacity of 3 tracks
        System.out.println("Initializing an empty album...");
        Album myAlbum = new Album("Starboy", "The Weeknd", 2016, 3);
        myAlbum.displayAlbumDetails();

        System.out.println("\n--- Testing Additional Task: Adding Tracks ---");

        // 2. Creating track objects using the nested class
        Album.MusicTrack track1 = new Album.MusicTrack("Starboy", 230);
        Album.MusicTrack track2 = new Album.MusicTrack("Party Monster", 241);
        Album.MusicTrack track3 = new Album.MusicTrack("I Feel It Coming", 269);
        Album.MusicTrack track4 = new Album.MusicTrack("Reminder", 218); // Extra track to test limit

        // 3. Adding tracks to demonstrate the functionality and validation
        myAlbum.addTrack(track1);
        myAlbum.addTrack(track2);
        myAlbum.addTrack(track3);
        
        // This one should trigger the overflow error because capacity is set to 3
        myAlbum.addTrack(track4); 

        // 4. Displaying full album structure via custom method and toString()
        System.out.println("\n--- Displaying Album State after Additions ---");
        myAlbum.displayAlbumDetails();

        System.out.println("\nTesting toString() output:");
        System.out.println(myAlbum);

        System.out.println("\n--- Testing Getters and Setters ---");
        // Modifying track 1 duration directly using composition access
        if (myAlbum.getTrackCount() > 0) {
            System.out.println("Original Track 1 duration: " + myAlbum.getTracks()[0].getDuration() + "s");
            myAlbum.getTracks()[0].setDuration(245);
            System.out.println("Updated Track 1 duration: " + myAlbum.getTracks()[0].getDuration() + "s");
        }
    }
}
