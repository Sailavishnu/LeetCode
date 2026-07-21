/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: col -> Map: row -> List of node values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>(); // Stores {TreeNode, row, col}
        
        if (root != null) {
            queue.offer(new Object[]{root, 0, 0});
        }
        
        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int row = (int) curr[1];
            int col = (int) curr[2];
            
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(node.val);
            
            if (node.left != null) {
                queue.offer(new Object[]{node.left, row + 1, col - 1});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> cols : map.values()) {
            List<Integer> report = new ArrayList<>();
            for (PriorityQueue<Integer> rows : cols.values()) {
                while (!rows.isEmpty()) {
                    report.add(rows.poll());
                }
            }
            result.add(report);
        }
        
        return result;
    }
}
