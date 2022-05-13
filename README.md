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

- BuildHeap
- Push Down
- Push Down Min
- Push Down Max
- Push Up
- Push Up Min
- Push Up Max


## Screenshots

![Min-Max-Heap Test Case](https://github.com/paulbernius/Min-Max-Heap/blob/main/sc.png?raw=true)


## References
“Min-Max Heap.” Wikipedia, Wikimedia Foundation, 4 Feb. 2022, https://en.wikipedia.org/wiki/Min-max_heap. 
