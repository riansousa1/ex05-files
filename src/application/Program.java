package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o caminho do arquivo: ");
		String arquivo = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String conteudo;
			int totalLinhas = 0;
			int totalPalavras = 0;
			int totalCaracter = 0;
			
			// Total de linhas
			while((conteudo = br.readLine()) != null) {
				
				// Separando com . porém pode criar espaços vazios se estiver ao final da palavra
				
				String[] linhas = conteudo.split("\\.");
				// Ignorando as partes vazias
				int partesValidas = (int) java.util.Arrays.stream(linhas).filter(parte -> !parte.trim().isEmpty()).count();
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
				
			}						
			
				
			System.out.println("Total de Linhas: " +  totalLinhas);
			System.out.println("Total de Palavras: " + totalPalavras);
			System.out.println("Total de Caracteres: " + totalCaracter);
			
			
		} catch (IOException e) {
			System.out.print("Error: " + e.getMessage());
		} finally {		
			sc.close();
		}
		
		

	}

}
