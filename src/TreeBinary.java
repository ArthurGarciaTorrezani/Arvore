public class TreeBinary {
     private Node root;

     public TreeBinary() {
          root = null;
     }

     public void insert(Node newNode) {
          root = insertNewNode(newNode, root);
     }

     private Node insertNewNode(Node newNode, Node current) {

          if (current == null)
               return newNode;

          if (newNode.getValue() > current.getValue()) {
               current.setRight(insertNewNode(newNode, current.getRight()));
          } else {
               current.setLeft(insertNewNode(newNode, current.getLeft()));
          }

          return current;
     }

     public void preOrder() {
          preOrder(root);
     }

     private void preOrder(Node element) {
          if (element != null) {
               System.out.println(element.getValue()); // R
               preOrder(element.getLeft()); // E
               preOrder(element.getRight()); // D
          }
     }
}
