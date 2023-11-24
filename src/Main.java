import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Novidade do Java 9 - Factory Method para Collection
        /*
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("primeiro nome");
        nomes.add("segundo nome");
        nomes.add("terceiro nome");
        List<String> nomesImutaveis = Collections.unmodifiableList(nomes);
        System.out.println("Array: " + nomesImutaveis);
        */
        List<String> listas = List.of("primeiro nome","segundo nome");
        System.out.println("List: " + listas);
        Set<String> nomes = Set.of("Outro Nome");
        System.out.println("Set: " + nomes);
        Map<String, String> dicionarios = Map.of("nome","First Name");
        System.out.println("Map: " + dicionarios);
   }
}