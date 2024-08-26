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
               if(root.getValue() == value){
                    dad = root;
                    noX = root;
               }else{
                    dad = searchDad(root, value);
                    if(dad.getValue() < value){
                         noX = dad.getRight();
                    }else{
                         noX = dad.getLeft();
                    }
               }
               if(noX.getRight() == null && noX.getLeft() == null){ //case 1
                    if(dad.getValue() < value){
                         dad.setRight(null);
                         return true;
                    }else{
                         dad.setLeft(null);
                         return true;
                    }
               }else if(noX.getRight() != null && noX.getLeft() != null){
                    Node noDadRightLeft = farLeft(noX, noX.getRight());
               }else{
                    if(noX.getRight() == null){
                         if(dad.getValue() > value){
                              dad.setLeft(noX.getLeft());
                              noX = null;
                         }else{
                              dad.setRight(noX.getLeft());
                              noX = null;
                         }
                    }
                    if(noX.getLeft() == null){
                         if(dad.getValue() > value){
                              dad.setLeft(noX.getRight());
                              noX = null;
                         }else{
                              dad.setRight(noX.getRight());
                              noX = null;
                         }
                    }
               }
               return false;
          }
     }

     private Node farLeft(Node dad, Node son){
          if(son.getLeft() == null){
               return dad;
          }
          return farLeft(son, son.getLeft());
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
