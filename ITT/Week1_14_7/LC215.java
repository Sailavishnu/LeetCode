import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            
            // If the heap exceeds size k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The top of the heap is the kth largest element
        return minHeap.peek();
    }
}
