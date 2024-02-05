import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHelper {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static String Get(String url){
        return Get(url, "application/json");
    }

    public static String Get(String url, String contentType){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", contentType)
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if(statusCode >= 200 && statusCode < 299){
                return response.body();
            } else {
                return String.format("HTTP Error: %s!", statusCode);
            }

        } catch(IOException | InterruptedException exception){
            return exception.getMessage();
        }
    }
}