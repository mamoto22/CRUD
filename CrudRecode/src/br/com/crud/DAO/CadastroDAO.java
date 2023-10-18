package br.com.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;



import com.petshop.utils.Colors;

import br.com.crud.model.Cadastro;
import br.com.crud.model.Cliente;
import br.com.crud.model.Destino;

public class CadastroDAO {

	private static String sql;

	private static Connection connection = null;

	public CadastroDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createCadastro(Cadastro cadastro) {
		sql = "INSERT INTO cliente (idCliente,nomeCliente, cpfCliente,enderecoCliente,telefoneCliente ) VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setInt(1, cadastro.getIdCliente());
			stmt.setString(2, cadastro.getNomeCliente());
			stmt.setString(3, cadastro.getCpfCliente());
			stmt.setString(4, cadastro.getEnderecoCliente());
			stmt.setString(5, cadastro.getTelefoneCliente());
			// Lidando com Datas
			
			Cliente cliente = new Cliente();
		
			System.out.println(Colors.GREEN.get() + "Cadastro criado com sucesso" + Colors.RESET.get() +"Nome:" + cliente.getNomeCliente(""));
					
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o Cadastro do cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());

		}
	}
	
	
	// READ
	public static void readAllCadastro() {
		sql = "SELECT * FROM cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Destino destino = new Destino();
				
				Cadastro cadastro = new Cadastro();
				cadastro.setIdCliente(r.getInt("IdCliente"));
				cadastro.setNomeCliente(r.getString("Nome"));
				cadastro.setCpfCliente(r.getString("CPF"));
				cadastro.setIdade(r.getInt("idade"));
				destino.setNomeCliente(r.getString("Destino"));

				System.out.printf("ID: %d\n Nome: %s\n CRMV: %s\n Horario Disponivel: %s\n", cadastro.getNomeCliente(),
						cadastro.getIdade(), cadastro.getIdCliente());

			}
	

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes.Cadastro" + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}
	
	
	// UPDATE 
	public void updateCadastro(Cadastro cadastro) {
		sql = "UPDATE cliente SET  idCliente = ?, nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?,telefoneCliente =?, WHERE cadastro = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, cadastro.getIdCliente());
			stmt.setString(2, cadastro.getNomeCliente());
			stmt.setString(3, cadastro.getCpfCliente());
			stmt.setString(4, cadastro.getEnderecoCliente());
			stmt.setString(5, cadastro.getTelefoneCliente());
		
			
			System.out.println(Colors.GREEN.get() + "Cadastro Atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ cadastro.getNomeCliente() + "ID: " + cadastro.getIdCliente());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o Cadastro." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());

		}
	}
	
	
	// DELETE 
	public void deleteCadastro(int id) {
		sql = "DELETE FROM veterinario WHERE idVeterinario = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Veterinario deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar o veterinario." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	public void readAllAtendimentos() {
		// TODO Auto-generated method stub
		
	}

	public static void readAllCdastro() {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
