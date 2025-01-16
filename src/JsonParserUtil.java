import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserUtil {
    public static double getExchangeRate(String jsonResponse, String moedaDestino) {
        try {
            JsonObject json = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (json.has("conversion_rates")) {
                JsonObject taxas = json.getAsJsonObject("conversion_rates");
                if (taxas.has(moedaDestino)) {
                    return taxas.get(moedaDestino).getAsDouble();
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao analisar o JSON: " + e.getMessage());
        }
        return -1;
    }
}

