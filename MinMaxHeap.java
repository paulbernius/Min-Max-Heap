public class MinMaxHeap {
    private int size;
    private int[] arr;

    public MinMaxHeap(int capacity) {
        arr = new int[capacity + 1];
        size = 0;
    }

    public MinMaxHeap(int[] arr) {
        this.arr = arr;
        this.size = arr.length - 1;
    }

    public static void main(String[] args) {
        /*
        Test cases:

        The first test case creates a new MinMaxHeap object with
        the capacity or size of the heap.
        Then, the Insert() method is tested by adding values
        to the newly created heap.
        Lastly, the Min() and Max() as well as the ExtractMin() and ExtractMax()
        are tested and printed. The test is completed after the heap is printed.

        The second test case creates a new MinMaxHeap object from a pre-existing array.
        Then the method BuildHeap() is tested and builds the heap from the data within the array.
        Lastly, the Min() and Max() as well as the ExtractMin() and ExtractMax()
        are tested and printed. The test is completed after the heap is printed.
        */


        MinMaxHeap Heap = new MinMaxHeap(15);                           // Initialize a new heap with size of 10

        System.out.println("Testing 'Insert()', 'Max()', 'ExtractMax()', 'Min()', and 'ExtractMin()' on the first heap");
        Heap.Insert(10);                                                      // Insert values into heap
        Heap.Insert(5);
        Heap.Insert(2);
        Heap.Insert(8);
        Heap.Insert(15);
        Heap.Insert(7);
        Heap.Insert(3);
        Heap.Insert(17);
        Heap.Insert(11);
        Heap.Insert(1);
        Heap.Insert(18);
        Heap.Insert(4);
        Heap.Insert(19);
        Heap.Insert(6);
        Heap.Insert(9);
        System.out.print("Heap before extractions: ");
        Heap.PrintHeap();
        System.out.println("Heap max: " + Heap.Max());                          // Prints maximum of heap
        System.out.println("Heap extracted max: " + Heap.ExtractMax());         // Extracts maximum of heap and prints it (This and the above line should print the same value)
        System.out.println("Heap min: " + Heap.Min());                          // Prints minimum of heap
        System.out.println("Heap extracted min: " + Heap.ExtractMin());         // Extracts minimum of heap and prints it (This and the above line should print the same value)
        System.out.print("Heap after extractions: ");
        Heap.PrintHeap();                                                       // Prints heap



        int[] newArr = {0, 12, 9, 5, 4, 8, 2, 1, 15, 3, 18, 13, 6, 17, 20, 22};                               // Initialize a new array
        MinMaxHeap newHeap = new MinMaxHeap(newArr);                            // Create MinMaxHeap object with 'newArr' data
        System.out.println("\n\nTesting 'BuildHeap()', 'Max()', 'ExtractMax()', 'Min()', and 'ExtractMin()' on the second heap");
        newHeap.BuildHeap();                                                    // Builds heap from 'newArr'
        System.out.print("newHeap before extractions: ");
        newHeap.PrintHeap();
        System.out.println("newHeap max: " + newHeap.Max());                    // Prints maximum of heap
        System.out.println("newHeap extracted max: " + newHeap.ExtractMax());   // Extracts maximum of heap and prints it (This and the above line should print the same value)
        System.out.println("newHeap min: " + newHeap.Min());                    // Prints minimum of heap
        System.out.println("newHeap extracted min: " + newHeap.ExtractMin());   // Extracts minimum of heap and prints it (This and the above line should print the same value)
        System.out.print("newHeap after extractions: ");
        newHeap.PrintHeap();                                                    // Prints heap

    }

    private int Left(int i) {
        return i * 2;
    }

    private int GrandChildLeft(int i) {
        return i * 4;
    }

    private int Right(int i) {
        return (i*2) + 1;
    }

    private int GrandChildRight(int i) {
        return i * 4;
    }

    private int Parent(int i) {
        return i / 2;
    }

    private int GrandParent(int i) {
        return i / 4;
    }

    public int[] BuildHeap() { // Builds a heap from an existing array
        for (int i = Math.floorDiv(arr.length, 2); i >= 1; i--) {
            PushDown(i);
        }
        return arr;
    }

    private void PushDown(int i) {
        int lvl = (int) Math.floor((Math.log10(i) / Math.log10(2)));
        if ((lvl % 2) == 0) { // If level is a min level:
            PushDownMin(i);     // Execute PushDownMin
        } else {                // If level is a max level:
            PushDownMax(i);     // Execute PushDownMax
        }
    }

    private void PushDownMin(int i) {
        if (Left(i) <= size) {      // Checks if children of i exist
            int min = i;
            int swapMin = i;
            if (GrandChildLeft(i) <= size) {        // Checks if grandchildren of i exist
                for (int j = GrandChildLeft(i); (j <= (GrandChildLeft(i) + 4)) && j <= size; j++) {
                    if (arr[min] > arr[j]) {
                        if (arr[swapMin] > arr[j]) {
                            swapMin = j;
                        }
                    }
                }
                int temp = arr[swapMin]; // Swap 'min' and 'swapMin'
                arr[swapMin] = arr[min];
                arr[min] = temp;
                if (swapMin == i) {
                    return;
                }
                PushDownMin(swapMin);
            }
        }
    }
    // PushDownMin and PushDownMax are identical with the comparison operators flipped.
    private void PushDownMax(int i) {
        if (Left(i) <= size) {      // Checks if children of i exist
            int min = i;
            int swapMin = i;
            if (GrandChildLeft(i) <= size) {        // Checks if grandchildren of i exist
                for (int j = GrandChildLeft(i); (j <= (GrandChildLeft(i) + 4)) && j <= size; j++) {
                    if (arr[min] < arr[j]) {
                        if (arr[swapMin] < arr[j]) {
                            swapMin = j;
                        }
                    }
                }
                int temp = arr[swapMin]; // Swap 'min' and 'swapMin'
                arr[swapMin] = arr[min];
                arr[min] = temp;
                if (swapMin == i) {
                    return;
                }
                PushDownMax(swapMin);
            }
        }
    }

    //Pre-condition: Heap is not full
    public void Insert(int i) {
        ++size;
        arr[size] = i;
        PushUp(size);
    }
    //Post-condition: Inserts new value into the heap

    private void PushUp(int i) {
        int lvl = (int) Math.floor((Math.log10(i) / (Math.log10(2))));
        if ((lvl % 2) == 0) {                                 // If level is a min level
            if ((Parent(i) > 0) && (arr[i] > arr[Parent(i)])) {	// If i has a parent
                int temp = arr[Parent(i)];						// Swap 'arr[Parent(i)' and 'arr[i]'
                arr[Parent(i)] = arr[i];
                arr[i] = temp;
                PushUpMax(Parent(i));                           // Execute PushUpMax
            } else {
                PushUpMin(i);                                   // Execute PushUpMin
            }
        } else {                                                // If level is a max level
            if ((Parent(i) > 0) && (arr[i] < arr[Parent(i)])) {	// If i has a parent
                int temp = arr[Parent(i)];						// Swap 'arr[Parent(i)' and 'arr[i]'
                arr[Parent(i)] = arr[i];
                arr[i] = temp;
                PushUpMin(Parent(i));                           // Execute PushUpMin
            } else {
                PushUpMax(i);                                   // Execute PushUpMax
            }
        }
    }

    private void PushUpMin(int i) {
        if (GrandParent(i) > 0) {				                // If i has a grandparent
            if (arr[i] < arr[GrandParent(i)]) {
                int temp = arr[GrandParent(i)];                 // Swap 'arr[GrandParent(i)' and 'arr[i]'
                arr[GrandParent(i)] = arr[i];
                arr[i] = temp;
                PushUpMin(GrandParent(i));
            }
        }
    }

    // PushUpMin and PushUpMax are identical with the comparison operators flipped.

    private void PushUpMax(int i) {
        if (GrandParent(i) > 0) {				                // If i has a grandparent
            if (arr[i] > arr[GrandParent(i)]) {
                int temp = arr[GrandParent(i)];
                arr[GrandParent(i)] = arr[i];
                arr[i] = temp;
                PushUpMax(GrandParent(i));
            }
        }
    }

    //Pre-condition: Heap is not empty
    public int Min() {
        return arr[1];
    }
    //Post-condition: The minimum value in the heap is returned

    //Pre-condition: Heap is not empty
    public int Max() {
        if (size == 1) {
            return arr[1];
        }
        if (arr[2] < arr[3]) {
            return arr[3];
        } else {
            return arr[2];
        }
    }
    //Post-condition: The maximum value in the heap is returned

    //Pre-condition: Heap is not empty
    public int ExtractMin() {
        int min = arr[1];
        arr[1] = arr[size--];
        PushDown(1);
        return min;
    }
    //Post-condition: The minimum value is extracted and returned, and PushDown is executed

    //Pre-condition: Heap is not empty
    public int ExtractMax() {
        int max;
        if (size == 1) {
            return arr[size--];
        }
        if (arr[2] < arr[3]) {
            max = arr[3];
            arr[3] = arr[size--];
            PushDown(3);
        } else {
            max = arr[2];
            arr[2] = arr[size--];
            PushDown(2);
        }
        return max;
    }
    //Post-condition: The maximum value is extracted and returned, and PushDown is executed
    private void PrintHeap() {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public boolean IsFull() {
        if (size == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }

    }
}