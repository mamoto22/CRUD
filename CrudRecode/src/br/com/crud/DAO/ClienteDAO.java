package br.com.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.petshop.utils.Colors;

import br.com.crud.model.Cliente;

public class ClienteDAO {

	private static String sql;

	private static Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createClient(Cliente cliente) {
		sql = "INSERT INTO cliente (idCliente,nomeCliente, cpfCliente, enderecoCliente, telefoneCliente) VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, cliente.getIdCliente());
			stmt.setString(2, cliente.getNomeCliente(""));
			stmt.setString(3, cliente.getCpfCliente());
			stmt.setString(4, cliente.getEnderecoCliente());
			stmt.setString(5, cliente.getTelefoneCliente());
			
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Cliente criado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ cliente.getNomeCliente("") + "\nCPF: " + cliente.getCpfCliente());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());

		}
	}

	// READ
	public static void readAllClients() {
		sql = "SELECT * FROM cliente ";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEnderecoCliente(r.getString("enderecoCliente"));
				cliente.setTelefoneCliente(r.getString("TelefoneCliente"));

				System.out.printf("ID: %d\n Nome: %s\n CPF: %s\n Endereco: %s\n Telefone: %s\n", cliente.getIdCliente(),
						cliente.getNomeCliente(""), cliente.getCpfCliente(), cliente.getEnderecoCliente(),
						cliente.getTelefoneCliente());

			}
			if (!r.next()) {
				System.out.println(Colors.PURPLE_BOLD_BRIGHT.get() + "NAO HA DADOS" + Colors.RESET.get());
			}

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes.Cliente" + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void updateClient(Cliente cliente) {
		sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?, telefone = ? WHERE Cliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente(""));
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEnderecoCliente());
			stmt.setString(4, cliente.getTelefoneCliente());
			stmt.setInt(5, cliente.getIdCliente());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Cliente atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ cliente.getNomeCliente("") + "\nCPF: " + cliente.getCpfCliente());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteClient(int id) {
		sql = "DELETE FROM cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Cliente deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar o cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}
}
