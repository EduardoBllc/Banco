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

		return  "Número da Conta: " + this.cod +
				"\nCliente: " + this.cliente.getNome() +
				"\nSaldo Total: " + Utils.valorToString(this.saldoTotal);
	}
	
}
