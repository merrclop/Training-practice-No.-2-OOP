public class Main {
    public static void main(String[] args) {
        System.out.println("=== Program Demonstration: Task 2 ===\n");

        // 1. Creating Album using parameterized constructor and nested class object
        System.out.println("Creating Album 1 (Parameterized Constructor):");
        Album.MusicTrack trackForAlbum1 = new Album.MusicTrack("After Hours", 361);
        Album album1 = new Album("After Hours Album", "The Weeknd", 2020, trackForAlbum1);
        
        // Displaying info via display method and toString()
        album1.displayAlbumInfo();
        System.out.println("toString() output:\n" + album1);

        System.out.println("\n-----------------------------------\n");

        // 2. Creating Album via user input (Demonstrating input methods)
        System.out.println("Creating Album 2 (User Input):");
        Album album2 = new Album();
        album2.inputAlbumData();
        
        // Displaying info for Album 2
        album2.displayAlbumInfo();

        System.out.println("\n-----------------------------------\n");

        // 3. Demonstrating Getters/Setters and Encapsulation
        System.out.println("Testing Encapsulation & Composition Modifications:");
        album2.setAlbumName("Updated Album Name");
        
        // Changing the bonus track details using inner class setters via outer class getter
        album2.getBonusTrack().setTitle("Updated Bonus Track Title");
        
        System.out.println("Modified Album 2 toString():\n" + album2);
    }
}
