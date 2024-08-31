import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Define exchange rates (these are made-up values for demonstration)
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD_INR", 83.0);
        exchangeRates.put("EUR_INR", 91.0);
        exchangeRates.put("GBP_INR", 106.0);
        exchangeRates.put("INR_USD", 0.012); // Reverse conversion rates
        exchangeRates.put("INR_EUR", 0.011);
        exchangeRates.put("INR_GBP", 0.0094);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the amount from the user
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Get the source currency from the user
        System.out.print("Enter the source currency (USD, EUR, GBP, INR): ");
        String fromCurrency = scanner.next().toUpperCase();

        // Get the target currency from the user
        System.out.print("Enter the target currency (USD, EUR, GBP, INR): ");
        String toCurrency = scanner.next().toUpperCase();

        // Perform the conversion and get the exchange rate
        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
        String conversionKey = fromCurrency + "_" + toCurrency;
        Double exchangeRate = exchangeRates.get(conversionKey);

        if (convertedAmount == -1) {
            System.out.println("Invalid currency conversion.");
        } else {
            System.out.printf("Exchange Rate Used: 1 %s = %.2f %s%n", fromCurrency, exchangeRate, toCurrency);
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        }
    }

    // Method to perform currency conversion
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // Construct the key for the exchange rate map
        String conversionKey = fromCurrency + "_" + toCurrency;

        // Fetch the exchange rate
        Double exchangeRate = exchangeRates.get(conversionKey);

        if (exchangeRate != null) {
            // Convert the amount
            return amount * exchangeRate;
        } else {
            return -1; // Return -1 to indicate an invalid conversion
        }
    }
}
