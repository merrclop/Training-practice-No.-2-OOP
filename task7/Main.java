public class Main {
    public static void main(String[] args) {
        System.out.println("=== Program Demonstration: Task 7 (Generics) ===\n");

        // Type 1: Demonstrating the collection working with MusicTrack objects
        System.out.println("--- Test 1: Instantiating collection for MusicTrack objects ---");
        MusicCollection<MusicTrack> trackCollection = new MusicCollection<>(3);

        MusicTrack track1 = new MusicTrack("Blinding Lights", "The Weeknd");
        MusicTrack track2 = new MusicTrack("Starboy", "The Weeknd");

        trackCollection.addItem(track1);
        trackCollection.addItem(track2);

        System.out.println("Item at index 0: " + trackCollection.getItem(0));
        System.out.println("Track Collection Details:\n" + trackCollection);

        System.out.println("\n-----------------------------------\n");

        // Type 2: Demonstrating the collection working with standard String data type
        System.out.println("--- Test 2: Instantiating collection for String objects ---");
        MusicCollection<String> stringCollection = new MusicCollection<>(5);

        stringCollection.addItem("Rock Genre - Compilation Volume 1");
        stringCollection.addItem("Pop Genre - Compilation Volume 2");
        stringCollection.addItem("Jazz Genre - Compilation Volume 3");

        System.out.println("Item at index 1: " + stringCollection.getItem(1));
        System.out.println("String Collection Details:\n" + stringCollection);
    }
}
