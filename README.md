# Min-Max-Heap

## About

> In computer science, a min-max heap is a complete binary tree data structure which combines the usefulness of both a min-heap and a max-heap, that is, it provides constant time retrieval and logarithmic time removal of both the minimum and maximum elements in it. This makes the min-max heap a very useful data structure to implement a double-ended priority queue. Like binary min-heaps and max-heaps, min-max heaps support logarithmic insertion and deletion and can be built in linear time. Min-max heaps are often represented implicitly in an array; hence it's referred to as an implicit data structure. *(Min-Max Heap)*

![minmaxheapvisual](https://user-images.githubusercontent.com/100249266/168339613-d69ff4c5-2e29-4b5d-90d1-430f831bf602.png)

## Logic

### Description

> - A min-max heap is a complete binary tree containing alternating min (or even) and max (or odd) levels. Even levels are for example 0, 2, 4, etc, and odd levels are respectively 1, 3, 5, etc. We assume in the next points that the root element is at the first level, i.e., 0.
> - Each node in a min-max heap has a data member (usually called key) whose value is used to determine the order of the node in the min-max heap.
> - The root element is the smallest element in the min-max heap. *(Min-Max Heap)*
> - One of the two elements in the second level, which is a max (or odd) level, is the greatest element in the min-max heap
> - Let *x* be any node in a min-max heap.<br/>
>   - If *x* is on a min (or even) level, then *x*.key is the minimum key among all keys in the subtree with root *x*.<br/>
>   - If *x* is on a max (or odd) level, then *x*.key is the maximum key among all keys in the subtree with root *x*.<br/>
> - A node on a min (max) level is called a min (max) node.
> <br/><br/> *(Min-Max Heap)*

### Operations

> - BuildHeap: Creating a min-max heap is accomplished by an adaptation of Floyd's linear-time heap construction algorithm, which proceeds in a bottom-up fashion.
> - Push Down: Push Down new element.
> - Push Up: Push Up new element
> - Find Min: The minimum node (or a minimum node in the case of duplicate keys) of a Min-Max Heap is always located at the root. Find Minimum is thus a trivial constant time operation which simply returns the roots.
> - Find Max: The maximum node (or a maximum node in the case of duplicate keys) of a Min-Max Heap is always located on the first max level--i.e., as one of the immediate children of the root. Find Maximum thus requires at most one comparison, to determine which of the two children of the root is larger, and as such is also a constant time operation.
> - Remove Min: Removing the minimum is just a special case of removing an arbitrary node whose index in the array is known. In this case, the last element of the array is removed (reducing the length of the array) and used to replace the root, at the head of the array. Push Down is then called on the root index to restore the heap property.
> - Remove Max: Removing the maximum is again a special case of removing an arbitrary node with known index. As in the Find Maximum operation, a single comparison is required to identify the maximal child of the root, after which it is replaced with the final element of the array and Push Down is then called on the index of the replaced maximum to restore the heap property.
> - Insert: Insert new element into heap.
> <br/><br/> *(Min-Max Heap)*

## Applications

> - Heapsort: One of the best sorting methods being in-place and with no quadratic worst-case scenarios.
> - Selection algorithms: A heap allows access to the min or max element in constant time, and other selections (such as median or kth-element) can be done in sub-linear time on data that is in a heap.
> - Graph alogirthms: By using heaps as internal traversal data structures, run time will be reduced by polynomial order. Examples of such problems are Prim's minimal-spanning-tree algorithm and Dijkstra's shortest-path algorithm.
> - Priority Queue: A priority queue is an abstract concept like "a list" or "a map"; just as a list can be implemented with a linked list or an array, a priority queue can be implemented with a heap or a variety of other methods.
> - K-Way merge: A heap data structure is useful to merge many already-sorted input streams into a single sorted output stream. Examples of the need for merging include external sorting and streaming results from distributed data such as a log structured merge tree. The inner loop is obtaining the min element, replacing with the next element for the corresponding input stream, then doing a sift-down heap operation. (Alternatively the replace function.) (Using extract-max and insert functions of a priority queue are much less efficient.)
> - Order statistics: The Heap data structure can be used to efficiently find the kth smallest (or largest) element in an array.
> <br/><br/>*(Kavale)*

## Time-Complexity
This data structure runs in, at most, O(n) time.
- Insert: O(log n)
- Delete: O(log n)
- Extract Min & Max: O(n)


## Screenshots

![Min-Max-Heap Test Case](https://github.com/paulbernius/Min-Max-Heap/blob/main/sc.png?raw=true)


## References
“Min-Max Heap.” Wikipedia, Wikimedia Foundation, 4 Feb. 2022, https://en.wikipedia.org/wiki/Min-max_heap.<br/><br/>
Kavale, Rupali. “Max Heap and Min Heap.” OpenGenus IQ: Computing Expertise &amp; Legacy, OpenGenus IQ: Computing Expertise &amp; Legacy, 25 June 2019, https://iq.opengenus.org/max-heap-min-heap/. 
