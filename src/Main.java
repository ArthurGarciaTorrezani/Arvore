//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TreeBinary tree = new TreeBinary();
        tree.insert(new Node(30));
        tree.insert(new Node(10));
        tree.insert(new Node(5));
        tree.insert(new Node(20));
        tree.insert(new Node(15));
        tree.insert(new Node(13));
        tree.insert(new Node(12));
        tree.insert(new Node(40));
        tree.insert(new Node(50));
        tree.insert(new Node(60));

        tree.preOrder();
        tree.remove(60);

        System.out.println("==============================");
        tree.preOrder();
        tree.remove(12);
        System.out.println("==============================");
        tree.preOrder();
        tree.remove(13);
        System.out.println("==============================");
        tree.preOrder();

    }
}
