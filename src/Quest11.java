import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class Quest11 {

    private Map<String, String> hashMap;
    private HashSet<String> hashSet;
    private LinkedHashMap<String, String> linkedHashMap;
    private Hashtable<String, String> hashTable;

 
    public Quest11() {
        hashMap = new HashMap<>();
        hashSet = new HashSet<>();
        linkedHashMap = new LinkedHashMap<>();
        hashTable = new Hashtable<>();

       
        hashMap.put("chave1", "valor1");
        hashMap.put("chave2", "valor2");

   
        hashSet.add("valor3");
        hashSet.add("valor4");

    
        linkedHashMap.put("chave5", "valor5");
        linkedHashMap.put("chave6", "valor6");

      
        hashTable.put("chave7", "valor7");
        hashTable.put("chave8", "valor8");
    }

   
    public void exibirValoresHashMap() {
        for (Map.Entry<String, String> entrada : hashMap.entrySet()) {
            System.out.println("Chave: " + entrada.getKey() + " Valor: " + entrada.getValue());
        }
    }

    public void exibirValoresHashSet() {
        for (String valor : hashSet) {
            System.out.println("Valor: " + valor);
        }
    }

  
    public void exibirValoresLinkedHashMap() {
        for (Map.Entry<String, String> entrada : linkedHashMap.entrySet()) {
            System.out.println("Chave: " + entrada.getKey() + " Valor: " + entrada.getValue());
        }
    }


    public void exibirValoresHashTable() {
        for (Map.Entry<String, String> entrada : hashTable.entrySet()) {
            System.out.println("Chave: " + entrada.getKey() + " Valor: " + entrada.getValue());
        }
    }

    public static void main(String[] args) {
      
        Quest11 estruturas = new Quest11();

        System.out.println("Valores do HashMap:");
        estruturas.exibirValoresHashMap();

        System.out.println("\nValores do HashSet:");
        estruturas.exibirValoresHashSet();

        System.out.println("\nValores do LinkedHashMap:");
        estruturas.exibirValoresLinkedHashMap();

        System.out.println("\nValores da Hashtable:");
        estruturas.exibirValoresHashTable();
    }
}
