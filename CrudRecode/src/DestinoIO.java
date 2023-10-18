

import java.sql.Connection;
import java.util.Scanner;


import com.petshop.utils.Colors;

import br.com.crud.DAO.DestinoDAO;
import br.com.crud.factory.DatabaseConnection;
import br.com.crud.model.Cliente;
import br.com.crud.model.Destino;
import br.com.crud.model.DestinoVolta;

public class DestinoIO {

	static Connection connection = DatabaseConnection.createConnection();
	static DestinoDAO destinoDAO = new DestinoDAO(connection);

	public static int SubMenuPet(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU Destino\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n" + "4 - Deletar"
					+ "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Destino destino = new Destino();
				
				System.out.println("Digite o nome do seu destino: ");
				destino.setNomeDestino(scanner.next());
				System.out.println("Digite o Nome do cliente : ");
				destino.setNomeCliente(scanner.next().toUpperCase().trim());
				System.out.println("Digite o Id do cliente: ");
				destino.setId(scanner.next().trim());
				System.out.println("Digite o telefone do cliente: ");
				destino.setDataDestino(scanner.next().trim());
				

				destinoDAO.createDestino(destino);

				break;
			case 2:
				DestinoDAO.readAllDestinos();
				break;
			
			case 3:
				Destino destino1 = new Destino();
				Cliente clientePetAtualizado = new Cliente();
				System.out.println("Digite o ID do destino a ser atualizado: ");
				destino1.setId(scanner.nextLine());
				scanner.nextLine();
				System.out.println("Digite o nome do cliente: ");
				destino1.setNomeCliente(scanner.nextLine());
				System.out.println("Digite o nome do destino: ");
				destino1.setDataDestino(scanner.nextLine());
				
				
				clientePetAtualizado.setIdCliente(scanner.nextInt());
				destino1.setNomeCliente(clientePetAtualizado);

				break;
			case 4:
				System.out.println("Digite o ID do destino a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int iddestino = scanner.nextInt();
				destinoDAO.deletedestino(iddestino);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}
}
