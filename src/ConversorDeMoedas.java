public class ConversorDeMoedas {
    private final ApiService apiService;

    public ConversorDeMoedas() {
        this.apiService = new ApiService();
    }

    public double converter(String moedaOrigem, String moedaDestino, double valor) {
        String jsonResponse = apiService.getExchangeRates(moedaOrigem);
        if (jsonResponse == null) {
            System.out.println("Erro ao obter os dados da API.");
            return -1;
        }

        double taxa = JsonParserUtil.getExchangeRate(jsonResponse, moedaDestino);
        if (taxa == -1) {
            System.out.println("Erro ao processar os dados da API.");
            return -1;
        }

        return valor * taxa;
    }
}
