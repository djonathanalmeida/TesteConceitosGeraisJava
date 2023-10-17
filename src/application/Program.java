package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Conta;
import entities.Fisica;
import entities.Juridica;
import entities.enums.TipoConta;
import services.ContaService;
import services.TaxaBrasil;
import services.TaxaEUA;
import services.TaxaService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println(Conta.BemVindo);
		System.out.println();

		char cont = 0;

		System.out.println("Quantas contas serão cadastradas?");
		System.out.println();
		Integer nContas = sc.nextInt();
		Conta[] vetContas = new Conta[nContas];
		List<Conta> listContas = new ArrayList<>();

		try {

			do {

				System.out.println("Conta FISICA ou JURIDICA?");
				TipoConta tc = TipoConta.valueOf(sc.next());

				if (tc == TipoConta.valueOf("FISICA")) {

					for (int i = 0; i < nContas; i++) {
						System.out.println("Qual o CPF?");
						String tipo = sc.next();

						System.out.println("Qual o número da conta?");
						Integer numConta = sc.nextInt();

						System.out.println("Qual o nome do titular?");
						String nome = sc.next();

						System.out.println("Qual o saldo inicial?");
						Double saldo = sc.nextDouble();

						Conta c1 = new Fisica(numConta, nome, saldo, tc, tipo, new TaxaBrasil());

						ContaService service = new ContaService();

						Conta contaSalva = service.saveConta(c1);

						vetContas[i] = new Fisica(numConta, nome, saldo, tc, tipo, new TaxaBrasil());

						System.out.println("Conta Física Cadastrada!");
						System.out.println();

						System.out.println("Deseja cadastrar outra conta agora? (S/N)");
						cont = sc.next().charAt(0);
						if (cont != 'S') {
							i = nContas;
						}

					}

				} else if (tc == TipoConta.valueOf("JURIDICA")) {

					for (Integer i = 0; i < nContas; i++) {

						System.out.println("Qual o CNPJ?");
						String tipo = sc.next();

						System.out.println("Qual o número da conta?");
						Integer numConta = sc.nextInt();

						System.out.println("Qual o nome da empresa?");
						String nome = sc.next();

						System.out.println("Qual o saldo inicial?");
						Double saldo = sc.nextDouble();

						listContas.add(new Juridica(numConta, nome, saldo, tc, nome, new TaxaEUA()));

						System.out.println("Conta Jurídica Cadastrada!");
						System.out.println();

						System.out.println("Deseja cadastrar outra conta agora? (S/N)");
						cont = sc.next().charAt(0);
						if (cont != 'S') {
							i = nContas;
						}

					}

				}

			} while (cont != 'N');

		} catch (IllegalArgumentException e) {

			System.out.println("Valor inválido!" + e.getMessage());
		}

		System.out.println();
		System.out.println("Contas físicas cadastradas: ");
		System.out.println();
		for (Conta x : vetContas) {
			System.out.println(x);
		}

		System.out.println();
		System.out.println("Contas jurídicas cadastradas: ");
		System.out.println();
		for (Conta y : listContas) {
			System.out.println(y);
		}

		TaxaBrasil tb = new TaxaBrasil();
		System.out.println();
		System.out.println(tb.testeDefaultMethods());

		sc.close();

	}

}
