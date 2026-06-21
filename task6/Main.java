public class Main {
    public static void main(String[] args) {
        System.out.println("=== Program Demonstration: Task 6 (Exceptions) ===\n");

        // 1. Test Case: Successful creation with valid data
        try {
            System.out.println("--- Test 1: Creating a valid track ---");
            MusicTrack validTrack = new MusicTrack("Blinding Lights", "The Weeknd", 200);
            System.out.println("Success: " + validTrack);
        } catch (InvalidTrackException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------\n");

        // 2. Test Case: Exception handling for empty track title
        try {
            System.out.println("--- Test 2: Creating a track with an empty title ---");
            MusicTrack badTrack1 = new MusicTrack("   ", "The Weeknd", 180); 
            System.out.println("This line will be skipped.");
        } catch (InvalidTrackException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------\n");

        // 3. Test Case: Exception handling for negative duration using try-catch-finally
        try {
            System.out.println("--- Test 3: Setting a negative duration via setter ---");
            MusicTrack track2 = new MusicTrack("Starboy", "The Weeknd", 230);
            
            // Triggering the exception
            track2.setDuration(-45); 
            System.out.println("This line will be skipped.");
        } catch (InvalidTrackException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        } finally {
            // Finally block always executes
            System.out.println("Finally Block: Verification routine completed safely.");
        }

        System.out.println("\nExecution finished successfully without crashing!");
    }
}
