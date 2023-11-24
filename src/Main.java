import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.runtime.SwitchBootstraps;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;


public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
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

        //Novidade Java 9 - JShell
        /*
        Exemplo comandos utilizados no JShell via terminal iniciando com o comando JShell:
        jshell> System.out.println("Hello world")
        jshell> String nome = "João";
        jshell> nome.toUpperCase();
        jshell> "Renata"
        jshell> $4.toLowerCase();
        jshell> /set feedback verbose
        jshell> int idade;
        jshell> /set feedback silent 
        jshell> int numero;
        jshell> /set feedback normal
        jshell> public void somar(int a, int b) {
            ...> System.out.println(a + b);
            ...> }
        jshell> somar(1, 1);
        jshell> /edit
                class Principal{
                public void somar(int a, int b) {
                    System.out.println(a + b);
                    }
                }
        jshell> /drop 8

        O JShell permite salvar arquivos com extensão:
        /save *(nome do arquivo).(extensão)*
        */
        
        //Novidade Java 11 - HTTP/2 Client API
        /*
        URL url = new URL("https://www.google.com/");
        URLConnection uc = url.openConnection();
        BufferedReader br = new BufferedReader( new InputStreamReader(uc.getInputStream()));
        String line = "";
        while (br.readLine() != null) {
            line = line.concat(br.readLine()).concat(System.lineSeparator());
        }
        System.out.println(line);
        */
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder( new URI("https://www.google.com.br")).GET().build();
        HttpResponse<String> resp = httpClient.send(httpRequest, BodyHandlers.ofString()); //send(httpRequest, BodyHandlers.ofString());
        System.out.println(resp.body());
        System.out.println(resp.statusCode());
        System.out.println(resp.version());
    }
}