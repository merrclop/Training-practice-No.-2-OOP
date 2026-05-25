public class Main {
    public static void main(String[] args) {
        System.out.println("=== Program Demonstration ===\n");

        // 1. Testing the no-argument constructor and data input method
        System.out.println("Creating the first track (User input via keyboard):");
        MusicTrack track1 = new MusicTrack();
        track1.inputData();
        System.out.println("\nInput result via toString():");
        System.out.println(track1);

        System.out.println();

        // 2. Testing the parameterized constructor
        System.out.println("Creating the second track using the parameterized constructor:");
        MusicTrack track2 = new MusicTrack("Blinding Lights", "The Weeknd", 200);
        track2.displayInfo();

        // 3. Testing specific Variant 8 methods
        System.out.println("Testing variant-specific methods for the second track:");
        
        // Changing duration
        track2.changeDuration(320); 
        track2.displayInfo();

        // Checking track length
        if (track2.isLongTrack()) {
            System.out.println("Check result: This is a long track (longer than 5 minutes).");
        } else {
            System.out.println("Check result: This is a standard length track.");
        }

        System.out.println();

        // 4. Demonstrating Encapsulation (Getters/Setters)
        System.out.println("Testing encapsulation (Getters/Setters):");
        track1.setArtist("New Artist Name");
        System.out.println("Changed the artist of the first track via setter. New artist: " + track1.getArtist());
    }
}
