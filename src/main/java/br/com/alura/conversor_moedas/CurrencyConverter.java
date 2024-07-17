package br.com.alura.conversor_moedas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("BEM VINDO AO CONVERSOR DE MOEDAS!!!");
		System.out.println("Escolha uma opção de conversão:");
		System.out.println("1. USD para EUR");
		System.out.println("2. EUR para USD");
		System.out.println("3. USD para GBP");
		System.out.println("4. GBP para USD");
		System.out.println("5. USD para JPY");
		System.out.println("6. JPY para USD");

		int option = scanner.nextInt();
		System.out.print("Digite o valor para conversão: ");
		double amount = scanner.nextDouble();

		String fromCurrency = "";
		String toCurrency = "";

		switch (option) {
			case 1:
				fromCurrency = "USD";
				toCurrency = "EUR";
				break;
			case 2:
				fromCurrency = "EUR";
				toCurrency = "USD";
				break;
			case 3:
				fromCurrency = "USD";
				toCurrency = "GBP";
				break;
			case 4:
				fromCurrency = "GBP";
				toCurrency = "USD";
				break;
			case 5:
				fromCurrency = "USD";
				toCurrency = "JPY";
				break;
			case 6:
				fromCurrency = "JPY";
				toCurrency = "USD";
				break;
			default:
				System.out.println("Opção inválida.");
				System.exit(1);
		}

		ExchangeRateClient client = new ExchangeRateClient();
		try {
			HttpResponseHandler response = client.getExchangeRate(fromCurrency, toCurrency);
			if (response != null && response.getStatusCode() == 200) {
				JsonObject jsonObject = JsonParser.parseString(response.getBody()).getAsJsonObject();
				if (jsonObject.get("result").getAsString().equals("success")) {
					double rate = jsonObject.get("conversion_rate").getAsDouble();
					double convertedAmount = amount * rate;
					System.out.printf("O valor convertido é: %.2f %s%n", convertedAmount, toCurrency);
				} else {
					System.out.println("Erro na conversão. Tente novamente.");
				}
			} else {
				System.out.println("Erro na solicitação. Tente novamente.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
