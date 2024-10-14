import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMonedas {
    private static final String API_KEY = "033f769ad72f042fb6942086";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.print("Ingrese la moneda base (ej. USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        String jsonResponse = getExchangeRates(baseCurrency);
        if (jsonResponse != null) {
            displayRates(jsonResponse);
        }

        scanner.close();
    }

    private static String getExchangeRates(String baseCurrency) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + baseCurrency))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
            return null;
        }
    }

    private static void displayRates(String jsonResponse) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

        if (jsonObject.get("result").getAsString().equals("success")) {
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            System.out.println("\nTasas de cambio para " + jsonObject.get("base_code").getAsString() + ":");

            String[] interestedCurrencies = {"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "MXN", "BRL"};

            for (String currency : interestedCurrencies) {
                if (rates.has(currency)) {
                    System.out.printf("%s: %.4f%n", currency, rates.get(currency).getAsDouble());
                }
            }
        } else {
            System.out.println("Error: " + jsonObject.get("error-type").getAsString());
        }
    }
}