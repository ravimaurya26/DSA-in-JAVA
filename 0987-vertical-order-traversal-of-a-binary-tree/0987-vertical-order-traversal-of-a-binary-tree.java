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
class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // column -> priority queue of {row, value}
        TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();

            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            // Create PQ for this column if it doesn't exist
            map.putIfAbsent(col, new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return a[0] - b[0];   // row
                    }
                    return a[1] - b[1];       // value
                }
            ));

            // Add {row, value}
            map.get(col).offer(new int[]{row, node.val});

            // Left
            if (node.left != null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }

            // Right
            if (node.right != null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        // TreeMap gives columns from left to right
        for (PriorityQueue<int[]> pq : map.values()) {

            List<Integer> column = new ArrayList<>();

            while (!pq.isEmpty()) {
                int[] pair = pq.poll();

                column.add(pair[1]);
            }

            ans.add(column);
        }

        return ans;
    }
}