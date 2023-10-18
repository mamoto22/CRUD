package br.com.crud.model;

public class Cliente {

	private int idCliente;

	private String nomeCliente;

	private String cpfCliente;

	private String enderecoCliente;

	private String telefoneCliente;
	
	

	public Cliente() {
		super();

	}

	public Cliente(String nomeCliente, String cpfCliente, String enderecoCliente, String telefoneCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.enderecoCliente = enderecoCliente;
		this.telefoneCliente = telefoneCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente(String string) {
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

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefone) {
		this.telefoneCliente = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
				+ ", enderecoCliente=" + enderecoCliente + ", telefone=" + telefoneCliente + "]";
	}

}
