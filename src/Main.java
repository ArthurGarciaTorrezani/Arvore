//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TreeBinary tree = new TreeBinary();
        tree.insert(new Node(30));
        tree.insert(new Node(10));
        tree.insert(new Node(40));

        //tree.preOrder();
        
        System.out.println(tree.tamanhoArovre());
        tree.inverter();
        tree.preOrder();

    }
}
