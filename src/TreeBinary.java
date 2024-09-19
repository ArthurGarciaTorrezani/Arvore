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
                    if(dad.getValue() < value) dad.setRight(null);
                    else dad.setLeft(null);
                    return true;
               }else if(noX.getRight() != null && noX.getLeft() != null){ // case 3
                    Node noDadRightLeft = farLeft(noX, noX.getRight());
                    Node substite = noDadRightLeft.getLeft();
                    noDadRightLeft.setLeft(null);
                    substite.setRight(noX.getRight());
                    substite.setLeft(noX.getLeft());
                    noX.setRight(null);
                    noX.setLeft(null);
                    if(dad.getValue() < value) dad.setRight(substite);
                    else dad.setLeft(substite);
               }else{ // case 2
                    if(noX.getRight() == null){
                         if(dad.getValue() > value) dad.setLeft(noX.getLeft());
                         else dad.setRight(noX.getLeft());

                    }
                    if(noX.getLeft() == null){
                         if(dad.getValue() > value) dad.setLeft(noX.getRight());
                         else dad.setRight(noX.getRight());
                    }
                    return true;
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

     // contar numero de nós de uma arvore binaria 1 
     public int numNos(){
          return numNos(root);
     }
     private int numNos(Node no){
          if(no == null) return 0;
          return numNos(no.getLeft()) + numNos(no.getRight()) + 1;
     }

     // contar numero de nós nao-folha 2
     public int numNosNF(){
          return numNosNF(root);
     }
     private int numNosNF(Node no){
          if(no == null) return 0;
          if(no.getLeft() == null && no.getRight() == null) return 0;
          return  1 + numNosNF(no.getLeft()) + numNosNF(no.getRight());
     }

     // conta o número de nós folhas de uma árvore binária. 3
     public int numNosF(){
          return numNosF(root);
     }
     private int numNosF(Node no){
          if(no == null) return 0;
          if(no.getLeft() == null && no.getRight() == null) return 1;
          return numNosF(no.getLeft()) + numNosF(no.getRight());
     }

     // calcular altura de uma arvore binaria
     public int tamanhoArovre(){
          return tamanhoArovre(root);
     }
     private int tamanhoArovre(Node no){
          if(no == null){
               return 0;
          }
          int e = tamanhoArovre(no.getLeft());
          int d = tamanhoArovre(no.getRight());
          if(e > d){
               return e  + 1;
          }
          return d + 1;
     }

     // remover elementos pares
     public void removerPares(){
          removerPares(root);
     }
     private void removerPares(Node no){
          if(no != null){
               removerPares(no.getLeft());
               removerPares(no.getRight());
               if(no.getValue() % 2 == 0){
                    remove(no.getValue());
               }      
          }
     }
}
