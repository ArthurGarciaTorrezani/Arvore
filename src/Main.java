//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TreeBinary tree = new TreeBinary();
        tree.insert(new Node(2));
        tree.insert(new Node(1));
        tree.insert(new Node(3));

        //tree.preOrder();
        
        System.out.println("=============");
        tree.posOrder();
        System.out.println("============");
        tree.Order();
        System.out.println("============");
        tree.preOrder();
        System.out.println("============");
        tree.PosOrderPilha();
    }
}
