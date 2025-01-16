import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "SUA_CHAVE_AQUI"; // Substitua pela sua chave de API

    public String getExchangeRates(String moedaOrigem) {
        try {
            String urlString = API_URL + API_KEY + "/latest/" + moedaOrigem;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .timeout(Duration.ofSeconds(10))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("Erro na solicitação: Código HTTP " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Erro ao acessar a API: " + e.getMessage());
        }
        return null;
    }
}

