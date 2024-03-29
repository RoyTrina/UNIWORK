package labs.lab8;

/***********************************************************************
 *  Lab 8, exercise 1                                                  *
 **********************************************************************/

public class AVLTree {

    /*
     *  Standard binary search tree node, plus a field to store the
     *  balance factor.
     */
    private class Node {
        Node parent;
        Node left, right;
        int value;
        int bf;

        /*
         *  Constructor. Newly-created nodes have no children, so the
         *  default initializers of left = right = null and bf = 0 are
         *  correct.
         */
        private Node (int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        /*
         *  Is this node its parent's left/right child? ("No", if
         *  parent==null.)
         */
        private boolean isLeftChild () {
            return parent != null && parent.left == this;
        }

        private boolean isRightChild () {
            return parent != null && parent.right == this;
        }

        /*
         *  Is this node left/right-heavy?
         */
        private boolean isLeftHeavy ()  { return bf < 0; }
        private boolean isRightHeavy () { return bf > 0; }
    }

    /*
     *  Tree is initialized to be empty.
     */
    private Node root = null;

    /*
     *  findNode is a helper method that's useful for both insert and
     *  contains. If the tree is empty, it returns null. Otherwise, it
     *  returns either the node containing 'value' or the node that
     *  will be the parent of 'value' when 'value' is inserted.
     */
    private Node findNode (int value) {
        Node cur = root;

        while (cur != null && value != cur.value) {
            if (value < cur.value) {
                if (cur.left == null)
                    break;
                else cur = cur.left;
            } else /* value > cur.value */ {
                if (cur.right == null)
                    break;
                else cur = cur.right;
            }
        }
        return cur;
    }

    /*
     *  Find if a value is in the tree by calling findNode and seeing
     *  if the resulting node holds the value we're looking for.
     */
    public boolean contains (int value) {
        Node node = findNode (value);
        return node != null && node.value == value;
    }

    /*
     *  Insert a value into the tree. This requires inserting as in an
     *  ordinary BST, then adjusting balance factors, then possibly
     *  performing rotations.
     */
    public void insert (int value) {
        Node cur;

        /*
         *  Insert the value into the tree. Return immediately if this is the
         *  first node in the tree or if the tree already contained the value.
         */
        cur = findNode (value);
        if (cur == null) {
            root = new Node(value, null);
            return;
        } else if (value == cur.value)
            return;
        else if (value < cur.value) {
            cur.left = new Node(value, cur);
            cur.bf--;  // We increased the depth of the left subtree by one,
                       //  so our balance factor decreases by one.
        } else {
            cur.right = new Node(value, cur);
            cur.bf++;  // We increased the depth of the right subtree by one.
        }

        /*
         *  Retrace up the tree, adjusting branching factors. If the insertion
         *  was in a node's right subtree, that node's balance factor might have
         *  increased by 1; if it was in the left subtree, it might have dec-
         *  reased by 1. We stop when we hit the root, or a node that gets
         *  balance factor 0, +2 or -2. If it's the root or a 0, we're done.
         *  Otherwise, we need to rotate.
         */
        while (cur.parent != null && (cur.bf == -1 || cur.bf == +1)) {
            if (cur.isLeftChild())
                cur.parent.bf--;
            else
                cur.parent.bf++;
            cur = cur.parent;
        }

        /*
         *  Rotate if we created a node with balance factor +/-2.
         */
        if (cur.bf == -2) {
            if (cur.left.isLeftHeavy())
                rotateRight (cur);
            else
                rotateLeftRight (cur);
        } else if (cur.bf == 2) {
            if (cur.right.isRightHeavy())
                rotateLeft (cur);
            else
                rotateRightLeft (cur);
        }
    }

    /*
     *  Follows the naming used on slide 223.  We don't need to touch T1 or T3,
     *  because these remain the left child of x and right child of y,
     *  respectively.
     */
    private void rotateLeft (Node x) {
        System.out.println("rotateLeft at " + x.value);

        Node y = x.right; // Non-null because x is right-heavy.
        Node t2 = y.left; // Could be null.

        x.right = t2;
        if (t2 != null)
            t2.parent = x;
        y.left = x;

        y.parent = x.parent;
        if (x.isLeftChild())
            y.parent.left = y;
        else if (x.isRightChild())
            y.parent.right = y;
        else
            root = y;
        x.parent = y;

        x.bf = y.bf = 0;
    }

    /*
     *  Identical to rotateLeft, except swapping left and right
     *  when talking about x and y's children. (But not x's parent --
     *  if x was its parent's left child, then y still becomes that
     *  parent's left child.
     */
    private void rotateRight (Node x) {
        System.out.println("rotateRight at " + x.value);

        Node y = x.left; // Non-null because x is right-heavy.
        Node t2 = y.right; // Could be null.

        x.left = t2;
        if (t2 != null)
            t2.parent = x;
        y.right = x;

        y.parent = x.parent;
        if (x.isLeftChild())
            y.parent.left = y;
        else if (x.isRightChild())
            y.parent.right = y;
        else
            root = y;
        x.parent = y;

        x.bf = y.bf = 0;
    }

    private void rotateRightLeft (Node x) {
        System.out.println("rotateRightLeft at " + x.value);
        rotateRight (x.right);
        rotateLeft (x);
    }

    private void rotateLeftRight (Node x) {
        System.out.println("rotateLeftRight at " + x.value);
        rotateLeft (x.left);
        rotateRight (x);
    }

/***********************************************************************
 *  Test methods                                                       *
 **********************************************************************/

    /*
     *  inOrderTraversal prints out all the nodes in order, with their
     *  balance factors.
     */
    private void inOrderTraversal () {
        if (root != null) {
            inOrderTraversal(root);
            System.out.println();
        }
    }

    private void inOrderTraversal (Node node) {
        if (node.left != null)
            inOrderTraversal(node.left);
        System.out.print(node.value + " (" + node.bf + ") ");
        if (node.right != null)
            inOrderTraversal(node.right);
    }

    /*
     *  insertWithCommentary inserts all the integers from an array and
     *  prints out the tree contents after each one.
     */
    private void insertWithCommentary (int[] ints) {
        for (int i : ints) {
            insert (i);
            inOrderTraversal();
        }
    }

    public static void main (String[] args) {
        System.out.println("Insertion order 1,2,3: should cause left-rotation");
        new AVLTree().insertWithCommentary (new int[]{1,2,3});

        System.out.println("\nInsertion order 1,3,2: should cause right-left-rotation");
        new AVLTree().insertWithCommentary (new int[]{1,3,2});

        System.out.println("\nInsertion order 3,2,1: should cause right-rotation");
        new AVLTree().insertWithCommentary (new int[]{3,2,1});

        System.out.println("\nInsertion order 3,1,2: should cause left-right-rotation");
        new AVLTree().insertWithCommentary (new int[]{3,1,2});
    }
}
