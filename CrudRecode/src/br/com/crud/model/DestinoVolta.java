package br.com.crud.model;
import java.sql.Date;

public class DestinoVolta {

	private int id;
	private String nomeDestino;
	private String nomeCliente;
	private java.sql.Date dataDestino;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public java.sql.Date getDataDestino() {
		return dataDestino;
	}
	public void setDataDestino(java.sql.Date dataDestino) {
		this.dataDestino = dataDestino;
	}
	public void setId(String nextLine) {
		// TODO Auto-generated method stub
		
	}
	public void setDataDestino(String trim) {
		// TODO Auto-generated method stub
		
	}

}
