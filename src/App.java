import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

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
       var stickerGenerator = new StickerGenerator();

       for (Map<String, String> filme: listaDeFilmes) {
           String urlImagem = filme.get("image");
           String title= filme.get("title");
           String fileName = title + ".png";

           InputStream inputStream =  new URL(urlImagem).openStream();

           stickerGenerator.create(inputStream, fileName);
           System.out.println(title);
           System.out.println();
           
       }




    }
}
