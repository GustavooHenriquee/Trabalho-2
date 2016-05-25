import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Trabalho {

	public static void main(String args[]) {
		
		String arquivo = "d://teste.txt";

		try {
			System.setIn(new FileInputStream(new File(arquivo)));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}

		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		DecimalFormat df = new DecimalFormat(".00");

		String vetnomes[], vetTel[];
		int vetTipo[], i, N, vetMinut[], j;
		double A[][], vetMinutos[];

		System.out.println("Quantas pessoas deseja cadastrar? ");
		N = sc.nextInt();

		vetTipo = new int[N];
		vetnomes = new String[N];
		vetTel = new String[N];
		vetMinut = new int[N];
		vetMinutos = new double[N];

		A = new double[3][2];

		System.out.println("Digite os elementos da matriz: ");

		for (i = 0; i < 3; i++) {
			for (j = 0; j < 2; j++) {
				System.out.print("[" + (i) + "," + (j) + "]: ");
				A[i][j] = sc.nextDouble();
			}
		}

		for (i = 0; i < N; i++) {

			System.out.println("Nome: ");
			sc.nextLine();
			vetnomes[i] = sc.nextLine();

			System.out.println("Telefone: ");
			vetTel[i] = sc.next();

			System.out.println("Tipo: ");
			vetTipo[i] = sc.nextInt();

			System.out.println("Minutos: ");
			vetMinut[i] = sc.nextInt();

			if (vetTipo[i] == 0) {

				if (vetMinut[i] > 90) {
					vetMinutos[i] = ( (vetMinut[i] - 90) * (A [0][1]) + (A [0][0]));
				} 
				else {
					vetMinutos[i] = A[0][0];
				}

			}
			if (vetTipo[i] == 1) {

				if (vetMinut[i] > 90) {
					vetMinutos[i] = ( A [1][0] + (vetMinut[i] - 90)* A[1][1]);
					
				} 
				else {
					vetMinutos[i] = A[1][0];
				}

			}
			if (vetTipo[i] == 2) {

				if (vetMinut[i] > 90) {
					vetMinutos[i] = ( A [2][0] + (vetMinut[i] - 90)* A[2][1]);
				} 
				else {
					vetMinutos[i] = A[2][0];
				}

			}
		}

		for (i = 0; i < N; i++) {
			System.out.print("Nome das pessoas ");
			System.out.print("\tTelefone");
			System.out.print("\tTipo");
			System.out.print("\tMinutos");
			System.out.print("\t\tValor da Conta");
			System.out.println("\n" + vetnomes[i] + "\t\t" + vetTel[i] + "\t  " + vetTipo[i] + "\t  " + vetMinut[i]
					+ "\t\t    " + "R$ " + df.format(vetMinutos[i]));

			for (i = 1; i < N; i++) {
				System.out.println(vetnomes[i] + "\t\t" + vetTel[i] + "\t  " + vetTipo[i] + "\t  " + vetMinut[i]
						+ "\t\t    " + "R$ "+ df.format(vetMinutos[i]));

			}
			sc.close();
		}

		int pos, quant, vetMinuto, acima, somaPor;
		double soma, mediaMins, por;

		quant = 0;
		soma = 0;
		pos = 0;
		vetMinuto = 0;
		mediaMins = 0;
		acima = 0;
		somaPor = 0;
		por = 0;
		
		for (i = 0; i < N; i++) {
			soma = soma + vetMinutos[i];

			if (vetMinutos[i] < vetMinutos[pos]) {
				pos = i;
			}

			if (vetTipo[i] == 1) {
				quant = quant + 1;
				vetMinuto = vetMinuto + vetMinut[i];
			}
			mediaMins = (vetMinuto / quant);

			if (vetMinut[i] > 120) {
				acima = acima + 1;
			}

			if (vetTipo[i] == 2) {
				somaPor = somaPor + 1;
			}
			por = (double) somaPor / N * 100;
			
			
		}
			
		System.out.printf("\nA soma de todas as contas da Telefônia = R$ %.2f", soma);
		System.out.println("\nNome e Telefone do cliente no qual a conta foi mais barata:\n\n" + vetnomes[pos] + "\t\t" + vetTel[pos]);
		System.out.println("\n\nMédia de minutos consumidos por clientes de conta tipo 1: " + mediaMins + " Minutos");
		System.out.println("\nA quantidade de clientes que consumiu acima de 120 minutos: " + acima);
		System.out.printf("\nA porcentagem de clientes que possuem conta tipo 2, em relação ao total de contas: %.2f", por);
		System.out.print("%");
		System.out.println("\n\n"
				+ "Nomes e Telefones dos clientes que não consumiram minutos excedentes\n");
		for(i = 0; i<N; i++){
			
			if(vetMinut[i] < 90){
				System.out.println(vetnomes[i] + "\t\t" + vetTel[i]);
			}
			else{
				
			}
		}
		
		
	}

}
