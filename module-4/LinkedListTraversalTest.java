public class LinkedListTraversalTest {
    public static void main(String[] args) {
        // Test with 50,000 integers
        System.out.println("Testing with 50,000 integers...");
        testListTraversal(50000);

        // Test with 500,000 integers
        System.out.println("Testing with 500,000 integers...");
        testListTraversal(500000);
    }
}

private static void testListTraversal(int size) {
    LinkedList<Integer> list = new LinkedList<>();

    // Populate the list with integers from 1 to 'size'
    for (int i = 1; i <= size; i++) {
        list.add(i);
    }

    // Measure time to traverse using Iterator
    long startTime = System.nanoTime();
    traverseWithIterator(list);
    long endTime = System.nanoTime();
    long iteratorTime = endTime - startTime;
    System.out.println("Time taken to traverse using iterator: " + iteratorTime + " nanoseconds.");

    // Measure time to traverse using get(index)
    startTime = System.nanoTime();
    traverseWithGetMethod(list);
    endTime = System.nanoTime();
    long getMethodTime = endTime - startTime;
    System.out.println("Time taken to traverse using get(index): " + getMethodTime + " nanoseconds.");

    // Calculate and print the difference in time
    System.out.println("Difference in time: " + (getMethodTime - iteratorTime) + " nanoseconds.");
}

private static void traverseWithIterator(LinkedList<Integer> list) {
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
        iterator.next(); // We don't need to do anything with the value
    }
}

private static void traverseWithGetMethod(LinkedList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
        list.get(i); // We don't need to do anything with the value
    }
}