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
          }
          if(newNode.getValue() < current.getValue()){
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

     public boolean remove(int value){
          if(root == null){
               return false;
          }else{
               Node dad;
               Node noX;
               //Case 1: nao possui nenhum filho
               if(root.getValue() != value){
                    dad = searchDad(root,value);
                    if(dad.getValue() > value){
                         dad.setLeft(null);
                         return true;
                    }else{
                         dad.setRight(null);
                         return true;
                    }
               }
               else{
                    dad = root;
                    noX = root;
               }
               //Case 2:
               if(noX.getRight() != null){

               }
          }
          return false;
     }

     public Node searchDad(Node current, int value){
          if(current == null) return null;
          if(value > current.getValue()){
               if(current.getRight() != null){
                    if(current.getRight().getValue() == value){
                         return current;
                    }
               }
          }
          else{
               if(current.getLeft() != null){
                    if(current.getLeft().getValue() == value){
                         return current;
                    }
               }
          }
          if(current.getValue() > value){
               return searchDad(current.getLeft(),value);
          }
          if(current.getValue() < value){
               return searchDad(current.getRight(), value);
          }
          return null;
     }
}
