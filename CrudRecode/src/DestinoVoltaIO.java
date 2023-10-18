

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.petshop.utils.Colors;

import br.com.crud.DAO.DestinoVoltaDAO;
import br.com.crud.factory.DatabaseConnection;
import br.com.crud.model.DestinoVolta;

public class DestinoVoltaIO {

	static Connection connection = DatabaseConnection.createConnection();
	static DestinoVoltaDAO destinovoltaDAO = new DestinoVoltaDAO(connection);

	public static int SubMenuVeterinario(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		do {
			System.out.println("MENU VETERINRIO\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar" + "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				DestinoVolta destinovolta = new DestinoVolta();
				System.out.println("Nome Completo: ");
				destinovolta.setNomeCliente(scanner.nextLine());
				System.out.println("destino: ");
				destinovolta.setNomeDestino(scanner.next().trim());
				System.out.println("Digite a Data da viagem");
				destinovolta.setDataDestino(scanner.next().trim());
				

				destinovoltaDAO.createVeterinario(destinovolta);
				break;
			case 2:
				destinovoltaDAO.readAllDestinosVolta();
				break;
			case 3:
				DestinoVolta destinovolta1 = new DestinoVolta();
				System.out.println("Digite o ID do DEstino de volta a ser atualizado: ");
				destinovolta1.setId(scanner.nextLine());
				System.out.println("Nome Completo: ");
				destinovolta1.setNomeCliente(scanner.nextLine());
				System.out.println("Nome do Destino de Volta: ");
				destinovolta1.setNomeDestino(scanner.nextLine());
				System.out.println("Digite a especialidade");
				destinovolta1.setDataDestino(scanner.nextLine());
				

				destinovoltaDAO.updatedestinovolta(destinovolta1);
				break;
			case 4:
				System.out.println(
						"Digite o ID do Veterinario a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int iddestinovolta = scanner.nextInt();
				destinovoltaDAO.deleteVeterinario(iddestinovolta);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}

}
