/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/  boolean check(Node root, int mi, int ma) {
        if(root == null) return true;
        if(root.data < mi || root.data > ma) return false;
        return (check(root.left, mi, root.data - 1) && check(root.right, root.data + 1, ma));
        }
        boolean checkBST(Node root) {
        return check(root, -1, 100005);

        }