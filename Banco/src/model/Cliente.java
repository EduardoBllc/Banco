package model;

import java.util.Date;

import helper.Utils;

public class Cliente {
	
	private static int contador = 101;
	
	private int cod;
	private int cpf;
	private String nome;
	private String email;
	private Date dataNascimento;
	private Date dataCadastro;
	
	
	
	public Cliente(String nome, String email, Date dataNascimento) {
		
		this.cod = Cliente.contador;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = new Date();
		Cliente.contador ++;
		
	}
	public Date getDataCadastro() {
		return this.dataCadastro;
	}
	public int getCod() {
		return this.cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return  "Código: " + this.getCod() + 
				"\nNome: " + this.getNome() +
				"\nEmail: " + this.getEmail() +
				"\nCPF: " + this.getCpf() +
				"\nData de Nascimento: " + Utils.dateToString(this.getDataNascimento()) + 
				"\nData de Cadastro: " + Utils.dateToString(this.getDataCadastro());
	}
	
}
