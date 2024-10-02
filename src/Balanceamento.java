public class Balanceamento {
     public static Node balanceamento(Node no) {
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
                    no = leftSimple(no);
               }
               if (no.getRight().getFator() == -1) {
                    no = rightLeft(no);
               }
          }

          if (no.getFator() == -2) {
               if (no.getRight().getFator() == -1 || no.getRight().getFator() == 0) {
                    no = rightSimple(no);
               }
               if (no.getRight().getFator() == 1) {
                    no = leftRight(no);
               }
          }

          return no;
     }

     private static Node leftSimple(Node no) {
          Node aux = no.getRight();
          no.setRight(aux.getLeft());
          aux.setLeft(no);
          return aux;
     }

     private static Node rightLeft(Node no) {
          Node aux = no.getRight().getLeft();

          no.setRight(aux.getLeft());
          no.getRight().setLeft(aux.getRight());

          aux.setRight(no.getRight());
          aux.setLeft(no);
          no.getRight().setLeft(aux.getRight());
          no.setRight(null);

          return aux;
     }

     private static Node rightSimple(Node no) {
          Node aux = no.getLeft();
          no.setLeft(aux.getRight());
          aux.setRight(no);
          return aux;
     }

     private static Node leftRight(Node no) {
          Node aux = no.getLeft().getRight();

          no.setLeft(aux.getRight());
          no.getLeft().setRight(aux.getLeft());

          aux.setRight(no);
          aux.setLeft(no.getLeft());
          no.getLeft().setRight(aux.getLeft());
          no.setLeft(null);
          return aux;
     }
}
