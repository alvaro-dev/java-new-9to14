import java.lang.runtime.SwitchBootstraps;
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

        //Novidade Java 10 - Inferência de Variável
        var cpfPorNomes = new HashMap<String, String>();
        cpfPorNomes.put("Pedro", "01234587963");
        System.out.println(cpfPorNomes);

        //Novidade Java 13 - Text Blocks
        String texto = "\"Lorem ipsum dolor sit amet, consectetur adipiscing \n"
        + "elit, sed do eiusmod tempor incididunt ut labore et dolore magna \n"
        + "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco \n"
        + "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor \n"
        + "in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla \n"
        + "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa \n"
        + "qui officia deserunt mollit anim id est laborum.\"";
        System.out.println(texto);

        String textoFormatado = """
            Lorem ipsum dolor sit amet, consectetur adipiscing
            elit, sed do eiusmod tempor incididunt ut labore et dolore magna
            aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
            in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
            pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa
            qui officia deserunt mollit anim id est laborum.
        """;
        System.out.println(textoFormatado);

        //Novidade Java 14 - Switch Expressions
        String name = "João";
        switch (name) {
            case "Outro":
                System.out.println("Não Acertou: " + name);
                break;
            case "João":
                System.out.println("Acertou: " + name);
                break;
            default:
                System.out.println("nenhum nome encontrado: " + name);
                break;
        }
        
        switch (name) {
            case "Outro" -> System.out.println("Não Acertou: " + name);
            case "João"  -> System.out.println("Acertou: " + name);
            default      -> System.out.println("nenhum nome encontrado: " + name);
        }
   }
}