import java.net.URI;
import java.util.Map;
import java.util.List;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {

       String url = "https://imdb-api.com/en/API/Top250Movies/k_u79lrqn7";
       var endereco = URI.create(url);
       var client = HttpClient.newHttpClient();
       var request = HttpRequest.newBuilder(endereco).GET().build();
       HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
       String  body = response.body();

       JsonParser jsonParser = new JsonParser();
       List<Map<String, String>> listaDeFilmes = jsonParser.parse(body);

       for (Map<String, String> filme: listaDeFilmes) {
           System.out.println(filme.get("title"));
           System.out.println(filme.get("image"));
           System.out.println(filme.get("imDbRating"));
           System.out.println();
           
       }




    }
}
