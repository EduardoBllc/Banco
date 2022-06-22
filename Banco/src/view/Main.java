package view;

import java.util.ArrayList;
import java.util.Scanner;

import helper.Utils;
import model.Conta;

public class Main {
	
	static String nome = "Banco Top";
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Conta> contas;
	
	public static void main(String[] args) {
		Main.contas = new ArrayList<>();
		Main.menu();

	}
	
	public static void menu() {
		int opcao = 0;
		System.out.println("=======================================");
		System.out.println("================= ATM =================");
		System.out.println("============== " + Main.nome + " ==============");
		System.out.println("=======================================");
		System.out.println("Selecione uma opção:");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Efetuar saque");
		System.out.println("3 - Efetuar depósito");
		System.out.println("4 - Efetuar transferência");
		System.out.println("5 - Listar contas");
		System.out.println("6 - Sair do sistema");
		
		try {
			opcao = Integer.parseInt(teclado.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Por favor, informe uma opção válida.");
			Utils.pausar(2);
			Main.menu();
		}
		
		switch (opcao) {
		case 1:
			Main.criarConta();
			break;
		case 2:
			Main.efetuarSaque();
			break;
		case 3:
			Main.efetuarDeposito();
			break;
		case 4:
			Main.efetuarTransferencia();
			break;
		case 5:
			Main.listarContas();
			break;
		case 6:
			System.out.println("Obrigado, volte sempre.");
			Utils.pausar(3);
			System.exit(0);
		default:
			System.out.println("Opção inválida, por favor tente novamente.");
			Utils.pausar(3);
			Main.menu();
			break;
		}
	}
	
}
