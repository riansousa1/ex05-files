package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o caminho do arquivo: ");
		String arquivo = sc.nextLine();

		Map<String, Integer> contagemPalavras = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String conteudo;
			int totalLinhas = 0;
			int totalPalavras = 0;
			int totalCaracter = 0;

			// Total de linhas
			while ((conteudo = br.readLine()) != null) {

				// Separando com . porém pode criar espaços vazios se estiver ao final da
				// palavra

				String[] linhas = conteudo.split("\\.");
				// Ignorando as partes vazias
				int partesValidas = (int) java.util.Arrays.stream(linhas).filter(parte -> !parte.trim().isEmpty())
						.count();
				totalLinhas += partesValidas;

				// Total de palavras

				String[] palavras = conteudo.split("\\s+");
				for (String palavra : palavras) {
					if (!palavra.trim().isEmpty()) {
						totalPalavras++;
					}
				}

				// Total de caracteres

				for (char caractere : conteudo.toCharArray()) {
					if (Character.isLetter(caractere) || caractere == '.' || caractere == ',') {
						totalCaracter++;
					}
				}

				// Palavras mais frequentes

				String[] palavrasF = conteudo.toLowerCase().split("\\s+");

				for (String palav : palavrasF) {
					/* remover pontuação */
					palav = palav.replaceAll("[^a-zA-Z]", "");

					/* ignora as palavras vazias */
					if (!palav.trim().isEmpty()) {									 
						contagemPalavras.put(palav, contagemPalavras.getOrDefault(palav, 0) + 1);
					}
				}		

			}

			System.out.println("Total de Linhas: " + totalLinhas);
			System.out.println("Total de Palavras: " + totalPalavras);
			System.out.println("Total de Caracteres: " + totalCaracter);
			System.out.println();
			
			// Converter meu map para listagem ordenada
			
			List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(contagemPalavras.entrySet());
			listaOrdenada.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
			
			// Mostrar apenas as 5 mais usadas
			
			System.out.println("As 5 palavras mais usadas:");

			for (int i = 0; i < Math.min(5, listaOrdenada.size()); i++) {
				Map.Entry<String, Integer> entry = listaOrdenada.get(i);
				System.out.println(entry.getKey() + ": " + entry.getValue());

			}

		} catch (IOException e) {
			System.out.print("Error: " + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
