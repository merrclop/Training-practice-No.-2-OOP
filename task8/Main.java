public class Main {
    public static void main(String[] args) {
        System.out.println("=== Final Comprehensive Program Demonstration ===\n");

        try {
            // Step 1: Instantiating minimum 3 track objects and 1 album container
            System.out.println("Step 1: Initializing Music Tracks and Album...");
            MusicAlbum compilation = new MusicAlbum("Starboy Essential Collection", 5, "R&B/Pop");

            MusicTrack track1 = new MusicTrack("Starboy", 230, "The Weeknd");
            MusicTrack track2 = new MusicTrack("False Alarm", 220, "The Weeknd");
            MusicTrack track3 = new MusicTrack("Reminder", 218, "The Weeknd");

            // Step 2: Demonstrating Composition insertion logic
            System.out.println("\nStep 2: Demonstrating Composition & Addition Logic...");
            compilation.addTrack(track1);
            compilation.addTrack(track2);
            compilation.addTrack(track3);

            // Step 3: Executing inherited base actions and specific child playback actions
            System.out.println("\nStep 3: Executing Base and Subclass Inherited Methods...");
            track1.play();
            track3.play();

            // Step 4: Executing dynamic duration calculator routine
            System.out.println("\nStep 4: Displaying Aggregated Calculations (Variant Tasks)...");
            compilation.displayTotalDuration();

            // Step 5: Testing encapsulation data updates and overridden string transformations
            System.out.println("\nStep 5: Testing Encapsulation Updates & Overridden toString()...");
            track2.setArtist("The Weeknd ft. Guest");
            System.out.println(compilation);

            // Step 6: Testing safe exception handling (uncomment or leave to see crash protection)
            System.out.println("\nStep 6: Confirming Exception Robustness...");
            track1.setDuration(-50); // Triggers custom exception catch block

        } catch (InvalidTrackException e) {
            System.out.println("Intercepted Runtime Validation Rule: " + e.getMessage());
        } finally {
            System.out.println("\n=== Final Program Workflow Terminated Cleanly ===");
        }
    }
}
