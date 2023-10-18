package br.com.crud.model;

import java.time.LocalDateTime;

public class Cadastro {
	
	private int idCliente;
	
	private int Idade;

	private String enderecoCliente;

	private String cpfCliente;

	private String nomeCliente;
	
	private String telefoneCliente;
	
	
	


	public int getIdade() {
		return Idade;
	}

	public void setIdade(int idade) {
		Idade = idade;
	}

	

	public void setHorarioAtendimento(LocalDateTime parse) {
		// TODO Auto-generated method stub
		
	}

	public void setHorarioAgendamento(LocalDateTime parse) {
		// TODO Auto-generated method stub
		
	}

	public void setDescricao(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	

}
