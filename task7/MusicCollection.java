public class MusicCollection<T> {
    private T[] items;
    private int count;

    @SuppressWarnings("unchecked")
    public MusicCollection(int capacity) {
        // Safe casting from Object array to generic type array
        this.items = (T[]) new Object[capacity];
        this.count = 0;
    }

    // Method to add an item to the collection
    public void addItem(T item) {
        if (count < items.length) {
            items[count] = item;
            count++;
            System.out.println("Success: Item added to the collection.");
        } else {
            System.out.println("Error: Collection is full!");
        }
    }

    // Method to retrieve an item by index
    public T getItem(int index) {
        if (index >= 0 && index < count) {
            return items[index];
        }
        System.out.println("Error: Index out of bounds!");
        return null;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MusicCollection [");
        for (int i = 0; i < count; i++) {
            sb.append(items[i].toString());
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("] (Total elements: " + count + ")");
        return sb.toString();
    }
}
