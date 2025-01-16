import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. ARS (Peso Argentino) -> BRL (Real Brasileiro)");
            System.out.println("2. BOB (Boliviano) -> BRL (Real Brasileiro)");
            System.out.println("3. CLP (Peso Chileno) -> BRL (Real Brasileiro)");
            System.out.println("4. COP (Peso Colombiano) -> BRL (Real Brasileiro)");
            System.out.println("5. USD (Dólar Americano) -> BRL (Real Brasileiro)");
            System.out.println("6. BRL (Real Brasileiro) -> USD (Dólar Americano)");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            if (escolha == 7) {
                continuar = false;
                System.out.println("Encerrando o programa...");
            } else if (escolha >= 1 && escolha <= 6) {
                realizarConversao(escolha, scanner);
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void realizarConversao(int escolha, Scanner scanner) {
        String moedaOrigem, moedaDestino;

        switch (escolha) {
            case 1 -> {
                moedaOrigem = "ARS";
                moedaDestino = "BRL";
            }
            case 2 -> {
                moedaOrigem = "BOB";
                moedaDestino = "BRL";
            }
            case 3 -> {
                moedaOrigem = "CLP";
                moedaDestino = "BRL";
            }
            case 4 -> {
                moedaOrigem = "COP";
                moedaDestino = "BRL";
            }
            case 5 -> {
                moedaOrigem = "USD";
                moedaDestino = "BRL";
            }
            case 6 -> {
                moedaOrigem = "BRL";
                moedaDestino = "USD";
            }
            default -> throw new IllegalStateException("Opção inválida.");
        }

        System.out.print("Digite o valor em " + moedaOrigem + ": ");
        double valor = scanner.nextDouble();

        ConversorDeMoedas conversor = new ConversorDeMoedas();
        double resultado = conversor.converter(moedaOrigem, moedaDestino, valor);

        if (resultado != -1) {
            System.out.printf("%.2f %s equivalem a %.2f %s%n", valor, moedaOrigem, resultado, moedaDestino);
        } else {
            System.out.println("Erro ao realizar a conversão.");
        }
    }
}

