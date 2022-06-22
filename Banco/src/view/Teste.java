package view;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Teste {

	public static void main(String[] args) {
		
		Conta c101 = new Conta(new Cliente(
				"Pedro",
				"Pedro@gmail.com",
				Utils.stringToDate("05/08/2000"),
				"376.992.210-91"));
		
		Conta c102 = new Conta(new Cliente(
				"Maria",
				"Maria@gmail.com",
				Utils.stringToDate("24/10/2005"),
				"036.541.440-75"));
		
		c101.depositar(500.0);
		
		c101.setLimite(200.0);
		
		c101.transferencia(c102, 350.0);
		
		System.out.println();
		
		System.out.println(c101);
		System.out.println();
		System.out.println(c102);
	}

}
