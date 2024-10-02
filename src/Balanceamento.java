public class Balanceamento {
     public static Node balanceamento(Node no){
          if (no == null) {
               return null;
          }

          Node e = balanceamento(no.getLeft());
          Node d = balanceamento(no.getRight());

          if (d != null && e == null) {
               no.setFator(d.getFator() + 1);
          }
          if (d == null && e != null) {
               no.setFator(e.getFator() + 1);
          }
          if (d != null && e != null) {
               no.setFator(d.getFator() - e.getFator());
          }

          if (no.getFator() == 2) {
               if (no.getRight().getFator() == 1 || no.getRight().getFator() == 0) {
                   leftSimple(no);
               }
               if (no.getRight().getFator() == -1) {
                   rightLeft(no);
               }
          }

          if (no.getFator() == -2) {
               if (no.getRight().getFator() == -1 || no.getRight().getFator() == 0) {
                   leftSimple(no);
               }
               if (no.getRight().getFator() == 1) {
               leftRight(no);
               }
          }

          return no;
     }

     public static void leftSimple(Node no){
          Node aux = no.getRight();
          aux.setLeft(no);
          no.setRight(aux.getLeft());
          no = aux;
     }

     public static void rightLeft(Node no){
          Node aux = no.getRight().getLeft();

          no.setRight(aux.getLeft());
          no.getRight().setLeft(aux.getRight());

          aux.setRight(no.getRight());
          aux.setLeft(no);
          no.getRight().setLeft(aux.getRight());
          no.setRight(null);
          no = aux;
     }

     public static void rightSimple(Node no){
          Node aux = no.getLeft();
          aux.setRight(no);
          no.setLeft(aux.getRight());
          no = aux;
     }

     public static void leftRight(Node no){
          Node aux = no.getLeft().getRight();

          no.setLeft(aux.getRight());
          no.getLeft().setRight(aux.getLeft());

          aux.setRight(no);
          aux.setLeft(no.getLeft());
          no.getLeft().setRight(aux.getLeft());
          no.setLeft(null);
          no = aux;
     }
}
