import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDepth {

    static class Node{
        Node yes;
        Node no;

        public Node(){
            yes = null;
            no = null;
        }

        public Node(Node yes, Node no){
            this.yes = yes;
            this.no = no;
        }
    }

    public int depth(Node root){
        if(root == null){
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;

        // Traverse the tree level by level.
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            depth++;

            // Process all nodes at the current level.
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll(); // Remove the front node from the queue.

                // Add the children of the current node to the queue.
                if (curr.yes != null) {
                    queue.add(curr.yes);
                }
                if (curr.no != null) {
                    queue.add(curr.no);
                }
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        BinaryTreeDepth tree = new BinaryTreeDepth();

        Node root = new Node(
                new Node(
                        new Node(null, null),
                        null
                ),
                new Node(
                        null,
                        new Node(null, null)
                )
        );

        // Test 1: Balanced tree
        System.out.println(tree.depth(root)); // Expected: 3

        // Test 2: Empty tree
        System.out.println(tree.depth(null)); // Expected: 0

        // Test 3: Single node tree
        System.out.println(tree.depth(new Node())); // Expected: 1

        // Test 4: Skewed tree
        Node skewed = new Node(new Node(new Node(null, null), null),
                null);
        System.out.println(tree.depth(skewed)); // Expected: 3

        // Test 5: Balanced Tree
        Node balanced = new Node(
                new Node(null, null),
                new Node(null, null)
        );
        System.out.println(tree.depth(balanced)); // Expected: 2

        // Test 6: Imbalanced tree
        Node imbalanced = new Node(
                new Node(
                        new Node(
                                new Node(null, null),
                                null
                        ),
                        null
                ),
                new Node(null, null)
        );
        System.out.println(tree.depth(imbalanced)); // Expected: 4
    }
}
