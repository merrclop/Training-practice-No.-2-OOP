public class Main {
    public static void main(String[] args) {
        System.out.println("=== Program Demonstration: Task 4 (Inheritance) ===\n");

        // 1. Testing the Base Class (Media)
        System.out.println("Creating a generic Media object:");
        Media genericMedia = new Media("Abstract Video Guide", 600);
        System.out.println(genericMedia);
        
        System.out.println("\n-----------------------------------\n");

        // 2. Testing the Subclass (MusicTrack) via No-Argument Constructor
        System.out.println("Creating MusicTrack 1 (Default Constructor):");
        MusicTrack track1 = new MusicTrack();
        System.out.println("Before initialization: " + track1);
        
        // Initializing via setters (both inherited and native)
        track1.setTitle("Hype Boy");
        track1.setDuration(179);
        track1.setArtist("NewJeans");
        System.out.println("After initialization: " + track1);

        System.out.println("\n-----------------------------------\n");

        // 3. Testing the Subclass via Parameterized Constructor
        System.out.println("Creating MusicTrack 2 (Parameterized Constructor):");
        MusicTrack track2 = new MusicTrack("Save Your Tears", 215, "The Weeknd");
        System.out.println(track2);

        System.out.println("\n--- Testing Additional Task: Playing Tracks ---");
        // 4. Demonstrating the play() functionality
        track1.play();
        track2.play();

        System.out.println("\n--- Polymorphism and Encapsulation Check ---");
        // Demonstrating that a MusicTrack IS-A Media object
        Media polymorphicTrack = new MusicTrack("Blinding Lights", 200, "The Weeknd");
        System.out.println("Polymorphic call to toString(): " + polymorphicTrack);
    }
}
