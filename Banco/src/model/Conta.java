package model;

import helper.Utils;

public class Conta {
	
	private static int contador = 101;
	
	private Cliente cliente;
	private int cod;
	private Double saldo = 0.0;
	private Double limite = 0.0;
	private Double saldoTotal;
	
	
	
	public Conta(Cliente cliente) {
		this.cod = Conta.contador;
		this.cliente = cliente;
		Conta.contador ++;
		this.atualizaSaldoTotal();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getLimite() {
		return limite;
	}
	public void setLimite(Double limite) {
		this.limite = limite;
		this.atualizaSaldoTotal();
	}
	public int getCod() {
		return cod;
	}
	public Double getSaldoTotal() {
		return saldoTotal;
	}
	
	private void atualizaSaldoTotal() {
		this.saldoTotal = this.getSaldo() + this.getLimite();
	}
	
	@Override
	public String toString() {

		return  "N�mero da Conta: " + this.cod +
				"\nCliente: " + this.cliente.getNome() +
				"\nSaldo Total: " + Utils.valorToString(this.saldoTotal);
	}
	
	public void depositar(Double valor){

		if(valor > 0){
			this.saldo += valor;
			this.atualizaSaldoTotal();
			System.out.println("Deposito efetuado com sucesso");
		}else{			
			System.out.println("Erro no valor depositado. Por favor, tente novamente");
		}
	}
	
	public void sacar(Double valor){
		if(valor > 0 && this.saldoTotal >= valor){
			if(this.getSaldo() >= valor){
				this.saldo -= valor;
				this.atualizaSaldoTotal();
				System.out.println("Saque efetuado com sucesso.");
				System.out.println("Saldo atual: " + this.getSaldoTotal());
				Utils.pausar(3);
			}else {
				Double restante = valor - this.getSaldo();
				this.limite -= restante;
				this.saldo = 0.0;
				this.atualizaSaldoTotal();
				System.out.println("Saque efetuado com sucesso");
			}
		}else {
			System.out.println("Saque n�o efetuado, tente novamente.");
		}
	}
	
	public void transferencia(Conta destino, Double valor){
		if(valor > 0 && this.saldoTotal >= valor){
			if(this.getSaldo() >= valor){
				this.saldo -= valor;
				destino.saldo += valor;
				this.atualizaSaldoTotal();
				destino.atualizaSaldoTotal();
				System.out.println("Transfer�ncia realizada com sucesso");
			}else {
				Double restante = valor - this.getSaldo();
				this.limite -= restante;
				this.saldo = 0.0;
				destino.saldo += valor;
				this.atualizaSaldoTotal();
				destino.atualizaSaldoTotal();
				System.out.println("Transfer�ncia efetuada com sucesso");
			}
		}else {
			System.out.println("Transfer�ncia n�o efetuada, tente novamente.");
		}
	}
}
