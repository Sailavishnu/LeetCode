import java.util.*;

public class LC987 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class NodeInfo implements Comparable<NodeInfo> {
        int row;
        int val;
        NodeInfo(int row, int val) {
            this.row = row;
            this.val = val;
        }
        @Override
        public int compareTo(NodeInfo other) {
            if (this.row != other.row) {
                return Integer.compare(this.row, other.row);
            }
            return Integer.compare(this.val, other.val);
        }
    }

    private TreeMap<Integer, List<NodeInfo>> nodesMap;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        nodesMap = new TreeMap<>();
        dfs(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<NodeInfo>> entry : nodesMap.entrySet()) {
            List<NodeInfo> list = entry.getValue();
            Collections.sort(list);
            List<Integer> colValues = new ArrayList<>();
            for (NodeInfo info : list) {
                colValues.add(info.val);
            }
            result.add(colValues);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        nodesMap.computeIfAbsent(col, k -> new ArrayList<>()).add(new NodeInfo(row, node.val));
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
