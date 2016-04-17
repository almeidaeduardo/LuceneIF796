package lucene;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean stopword = false;
		boolean stemming = false;
		String resposta;

		System.out.println("Enter path: ");
		// C:\Users\Eduardo\Desktop\dtset
		// /Users/thais/Downloads/Lucene/arquivos
		// C:/Users/leoffarias/Desktop/Lucene/arquivos
		String docsPath = in.nextLine();

		System.out.println("Do you want to override stopwords? (Y/N): ");
		resposta = in.next();
		if (resposta.equals("Y") || resposta.equals("y")) {
			stopword = true;
		}

		System.out.println("Do you want to use Stemming? (Y/N): ");
		resposta = in.next();
		if (resposta.equals("Y") || resposta.equals("y")) {
			stemming = true;
		}

		IndexFiles indexacao = new IndexFiles(stopword, stemming, docsPath);

		indexacao.main(args);

		SearchFiles recuperacao = new SearchFiles(stopword, stemming);

		try {
			recuperacao.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
