import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        //Fazer uma conexão HTTP e buscar os top250 filmes.
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        //Extrair apenas os dados que interessam (Título, Poster e a Classificação).
        var parser = new JsonParser();
        List<Map<String, String>> lista_de_filmes = parser.parse(body);

        //Exibir e manopuldar os dados.
        for (Map<String,String> filme : lista_de_filmes) {
            System.out.println(filme.get(Key: "title"));
        }

    }
}
 