import java.util.*;

class Solution {
    Node pre = null, suc = null;

    public ArrayList<Node> findPreSuc(Node root, int key) {
        pre = null;
        suc = null;

        findPreSucUtil(root, key);
        ArrayList<Node> result = new ArrayList<>();
        result.add(pre != null ? pre : null);
        result.add(suc != null ? suc : null);

        return result;
    }

    private void findPreSucUtil(Node root, int key) {

        if (root == null)
            return;

        if (root.data == key) {
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null)
                    temp = temp.right;

                pre = temp;
            }

            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;

                suc = temp;
            }

        } else if (key < root.data) {
            suc = root;
            findPreSucUtil(root.left, key);
        } else {
            pre = root;
            findPreSucUtil(root.right, key);
        }

    }
}

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}