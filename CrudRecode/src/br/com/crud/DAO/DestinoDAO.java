package br.com.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import br.com.crud.model.Cadastro;
import br.com.crud.model.Destino;


public class DestinoDAO {

	private static String sql;

	private  static Connection connection = null;

	public DestinoDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createDestino(Destino destino) {
		sql = "INSERT INTO destino (id, nomeCliente, nomeDestino, datadestino) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Lidando com Datas
			
			
			
			var sqldata = Timestamp.valueOf(destino.getDataDestino().toString());
			
			stmt.setInt(1, destino.getId());
			stmt.setString(2, destino.getNomeCliente());
			stmt.setString(3, destino.getNomeDestino());
			stmt.setDate(4, destino.getDataDestino());
			//stmt.executeUpdate();
			System.out.println("Destino agendado  com sucesso!" + destino.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// READ
	public static void readAllDestinos() {
		sql = "SELECT * FROM cliente as a " + "INNER JOIN idcliente as p " + "ON a.iddestino = p.idcliente"
				+ "INNER JOIN cadastro as v " + "ON a.idcadastro = v.idcadastro" + "INNER JOIN cliente as c "
				+ "ON p.idCliente = c.idCliente";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				
				Destino destino = new Destino();
		

				System.out.println("ID Destino: " + destino.getId() + "\nData da Viagem: "
						+ destino.getDataDestino() + "CLiente:"+ destino.getNomeCliente()
						+"\nNome do destino: " + destino.getNomeDestino());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// UPDATE
	public void updateDestino(Cadastro atendimento) {
		sql = "UPDATE destino SET nomeDestino = ?, nomeCliente = ?, datadestino = ? WHERE destino = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// DELETE
	public void deletedestino(int id) {
		sql = "DELETE FROM atendimento WHERE idAtendimento = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	

}
