package br.com.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;


import com.petshop.utils.Colors;

import br.com.crud.model.Cliente;
import br.com.crud.model.DestinoVolta;

public class DestinoVoltaDAO {

	private static String sql;

	private final Connection connection;

	public DestinoVoltaDAO(Connection connection) {
		this.connection = connection;
	}
		DestinoVolta destinovolta = new DestinoVolta();
	// CREATE
	public void createPet(DestinoVolta cliente) {
		sql = "INSERT INTO destinovolta (iddestinovolta, nomeDestino, datavoo, descricaoPassagem, ) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setInt(1, destinovolta.getId());
			stmt.setString(2, destinovolta.getNomeCliente());
			stmt.setString(3, destinovolta.getNomeDestino());
			stmt.setDate(4, destinovolta.getDataDestino());
			stmt.executeUpdate();
			System.out.println("Destino de volta criado com sucesso!" +destinovolta.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// READ
	public void readAllDestinosVolta() {
		sql = "SELECT * FROM destinovolta as p " + "INNER JOIN cliente as c " + "ON p.idCliente = c.idCliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				// Pet
				DestinoVolta destinovolta = new DestinoVolta();
				destinovolta.setDataDestino(r.getDate("data"));
				destinovolta.setNomeCliente(r.getString("Cliente"));
				destinovolta.setNomeDestino(r.getString("Destino"));
				destinovolta.setId(r.getInt("ID"));
				

				// Cliente do Pet
				Cliente cliente = new Cliente();
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEnderecoCliente(r.getString("enderecoCliente"));
				cliente.setTelefoneCliente(r.getString("telefone"));

				System.out.println("ID do Cliente: " + cliente.getIdCliente() + "\nNome do nomo: "+ cliente.getIdCliente() + "\nID do Cliente: ");

			}

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes.destinovolta" + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void updatedestinovolta(DestinoVolta destinovolta) {
		sql = "UPDATE destinovolta SET nomeDestino = ?, iddestinoVolta = ?, dataVoo = ?,  = ?, idadePet = ?, idCliente = ? WHERE destinovolta = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1,destinovolta.getNomeCliente());
			stmt.setInt(2, destinovolta.getId());
			stmt.setDate(3, destinovolta.getDataDestino());
			stmt.setString(4, destinovolta.getNomeDestino());
			stmt.executeUpdate();
			
			Cliente cliente = new Cliente();
			System.out.println(Colors.GREEN.get() + "destino de Volta atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ destinovolta.getNomeDestino() + "Nome do passageiro: " +cliente.getIdCliente());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o Pet." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deletedestinovolta(int id) {
		sql = "DELETE FROM destino WHERE iddestino = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createVeterinario(DestinoVolta destinovolta2) {
		// TODO Auto-generated method stub
		
	}

	public void deleteVeterinario(int iddestinovolta) {
		// TODO Auto-generated method stub
		
	}
}
