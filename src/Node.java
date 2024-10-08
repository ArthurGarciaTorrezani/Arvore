public class Node {
     private Node right;
     private Node left;
     private int value;
     private int fatorBalanceamento = 0;

     public Node getRight() {
          return right;
     }

     public void setRight(Node right) {
          this.right = right;
     }

     public Node getLeft() {
          return left;
     }

     public void setLeft(Node left) {
          this.left = left;
     }

     public int getValue() {
          return value;
     }

     public void setValue(int value) {
          this.value = value;
     }

     public Node(int value){
          this.value = value;
     }

     public void setFator(int num){
          fatorBalanceamento += num;
     }

     public int getFator(){
          return fatorBalanceamento;
     }
}
