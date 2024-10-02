import java.util.Stack;

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
          if (newNode.getValue() < current.getValue()) { 
               current.setLeft(insertNewNode(newNode, current.getLeft()));
          } 
          return current;
     }

     public void preOrder() {
          preOrder(root);
     }

     private void preOrder(Node element) {
          if (element != null) {
               System.out.println(element.getValue()); 
               preOrder(element.getLeft()); 
               preOrder(element.getRight()); 
          }
     }

     public void Order() {
          Order(root);
     }

     private void Order(Node element) {
          if (element != null) {
               preOrder(element.getLeft()); 
               System.out.println(element.getValue()); 
               preOrder(element.getRight()); 
          }
     }

     public void posOrder() {
          posOrder(root);
     }

     private void posOrder(Node element) {
          if (element != null) {
              
               preOrder(element.getLeft()); 
               preOrder(element.getRight()); 
               System.out.println(element.getValue()); 
          }
     }

     public boolean remove(int value) {
          if (root == null) {
               return false; // A árvore está vazia
          }

          // Caso em que a raiz é o nó a ser removido
          if (root.getValue() == value) {
               // Se a raiz não tem filhos, simplesmente a remove
               if (root.getLeft() == null && root.getRight() == null) {
                    root = null;
               } else if (root.getLeft() == null) { // Se não tem filho esquerdo
                    root = root.getRight();
               } else if (root.getRight() == null) { // Se não tem filho direito
                    root = root.getLeft();
               } else { // Caso com dois filhos
                    Node noDadRightLeft = farLeft(root, root.getRight());
                    Node substite = noDadRightLeft.getLeft();
                    noDadRightLeft.setLeft(substite.getRight());
                    substite.setLeft(root.getLeft());
                    substite.setRight(root.getRight());
                    root = substite; // Substitui a raiz pela substituta
               }
               return true; // A raiz foi removida
          }

          // Para outros casos, procure o pai do nó a ser removido
          Node dad = searchDad(root, value);
          if (dad == null) {
               return false; // O valor não foi encontrado
          }

          Node noX = (dad.getValue() < value) ? dad.getRight() : dad.getLeft();

          // Caso 1: nó sem filhos
          if (noX.getRight() == null && noX.getLeft() == null) {
               if (dad.getValue() < value) {
                    dad.setRight(null);
               } else {
                    dad.setLeft(null);
               }
               return true;
          }

          // Caso 2: um filho
          if (noX.getRight() == null) {
               if (dad.getValue() < value) {
                    dad.setRight(noX.getLeft());
               } else {
                    dad.setLeft(noX.getLeft());
               }
          } else if (noX.getLeft() == null) {
               if (dad.getValue() < value) {
                    dad.setRight(noX.getRight());
               } else {
                    dad.setLeft(noX.getRight());
               }
          }

          // Caso 3: dois filhos
          if (noX.getRight() != null && noX.getLeft() != null) {
               Node noDadRightLeft = farLeft(noX, noX.getRight());
               Node substite = noDadRightLeft.getLeft();
               noDadRightLeft.setLeft(substite.getRight());
               substite.setRight(noX.getRight());
               substite.setLeft(noX.getLeft());
               noX.setRight(null);
               noX.setLeft(null);
               if (dad.getValue() < value)
                    dad.setRight(substite);
               else
                    dad.setLeft(substite);
          }

          return true;
     }

     private Node farLeft(Node dad, Node son) {
          if (son.getLeft() == null) {
               return dad;
          }
          return farLeft(son, son.getLeft());
     }

     public Node searchDad(Node current, int value) {
          if (current == null)
               return null;
          if (value > current.getValue()) {
               if (current.getRight() != null) {
                    if (current.getRight().getValue() == value) {
                         return current;
                    }
               }
          } else {
               if (current.getLeft() != null) {
                    if (current.getLeft().getValue() == value) {
                         return current;
                    }
               }
          }
          if (current.getValue() > value) {
               return searchDad(current.getLeft(), value);
          }
          if (current.getValue() < value) {
               return searchDad(current.getRight(), value);
          }
          return null;
     }

     // contar numero de nós de uma arvore binaria 1
     public int numNos() {
          return numNos(root);
     }

     private int numNos(Node no) {
          if (no == null)
               return 0;
          return numNos(no.getLeft()) + numNos(no.getRight()) + 1;
     }

     // contar numero de nós nao-folha 2
     public int numNosNF() {
          return numNosNF(root);
     }

     private int numNosNF(Node no) {
          if (no == null)
               return 0;
          if (no.getLeft() == null && no.getRight() == null)
               return 0;
          return 1 + numNosNF(no.getLeft()) + numNosNF(no.getRight());
     }

     // conta o número de nós folhas de uma árvore binária 3
     public int numNosF() {
          return numNosF(root);
     }

     private int numNosF(Node no) {
          if (no == null)
               return 0;
          if (no.getLeft() == null && no.getRight() == null)
               return 1;
          return numNosF(no.getLeft()) + numNosF(no.getRight());
     }

     // calcular altura de uma arvore binaria 4
     public int tamanhoArovre() {
          return tamanhoArovre(root);
     }

     private int tamanhoArovre(Node no) {
          if (no == null)
               return -1;

          int e = tamanhoArovre(no.getLeft());
          int d = tamanhoArovre(no.getRight());
          if (e > d) return e + 1;
          return d + 1;
     }

     // remover elementos pares 5
     public void removerPares() {
          removerPares(root);
     }

     private void removerPares(Node no) {
          if (no != null) {
               removerPares(no.getLeft());
               removerPares(no.getRight());
               if (no.getValue() % 2 == 0) {
                    remove(no.getValue());
               }
          }
     }

     // inverter arovre 6
     public void inverter() {
          inverter(root);
     }

     private void inverter(Node no) {
          if (no != null) {
               Node noE = no.getLeft();
               Node noD = no.getRight();
               no.setLeft(noD);
               no.setRight(noE);
               inverter(noD);
               inverter(noE);
          }

     }

     //
     private void balanceamento(Node no) {
         Balanceamento.balanceamento(no);
     }

     public void OrderPilha(){
          OrderPilha(root);
     }
     //  order pilha
     private void OrderPilha(Node root) {
          Stack<Node> pilha = new Stack<>();
          while (root != null || !pilha.isEmpty()) {
               if (root != null) {
                    pilha.push(root);
                    root = root.getLeft();
               }else{
                    root = pilha.pop();
                    System.out.println(root.getValue());
                    root = root.getRight();
               }
               
          }
     }

     public void PreOrderPilha(){
          PreOrderPilha(root);
     }
     // pre order pilha
     private void PreOrderPilha(Node root) {
          Stack<Node> pilha = new Stack<>();
          while (root != null || !pilha.isEmpty()) {
               if (root != null) {
                    pilha.push(root);
                    System.out.println(root.getValue());
                    root = root.getLeft();
               }else{
                    root = pilha.pop();
                    root = root.getRight();
               }
               
          }
     }


     public void PosOrderPilha(){
          PosOrderPilha(root);
     }
     // pos order pilha
     private void PosOrderPilha(Node root) {
          Stack<Node> pilha = new Stack<>();
          while (root != null || !pilha.isEmpty()) {
               if (root != null) {
                    pilha.push(root);
                    root = root.getRight();
               }else{
                    root = pilha.pop();
                    System.out.println(root.getValue());
                    root = root.getLeft();
                  
               }
               
          }
     }
}
