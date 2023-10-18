

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import com.petshop.utils.Colors;

import br.com.crud.DAO.CadastroDAO;
import br.com.crud.factory.DatabaseConnection;
import br.com.crud.model.Cadastro;
import br.com.crud.model.DestinoVolta;

public class CadastroIO {
	static Connection connection = DatabaseConnection.createConnection();
	static CadastroDAO cadastroDAO = new CadastroDAO(connection);

	public static <petAtendimentoAtualizado> int SubMenuAtendimento(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		do {
			System.out.println("MENU ATENDIMENTO\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar" + "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Cadastro cadastro = new Cadastro();
				System.out.println("Digite o seu nome");
				String nome = scanner.nextLine();
				cadastro.setNomeCliente(nome);
				System.out.println("Digite o seu cpf");
				String cpf = scanner.nextLine();
				cadastro.setCpfCliente(cpf);
				System.out.println("Digite seu endereço : ");
				String endereco = scanner.nextLine();
				cadastro.setEnderecoCliente(endereco);
				System.out.println("Digite seu telefone : ");
				String telefone = scanner.nextLine();
				cadastro.setTelefoneCliente(telefone);
				

				cadastroDAO.createCadastro(cadastro);
				break;
			case 2:

				CadastroDAO.readAllCadastro();
				break;
			case 3:
				Cadastro cadastroAtualizado = new Cadastro();
				System.out.println("Digite o ID do Atendimento a ser atualizado: ");
				cadastroAtualizado.setIdCliente(option);
				scanner.nextLine();
				System.out.println("Digite o horario do atendimento no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraAtendimentoAtualizado = scanner.nextLine();
				cadastroAtualizado
						.setHorarioAtendimento(LocalDateTime.parse(dataEhoraAtendimentoAtualizado, formatter));
				System.out.println("Digite o horario do agendamento no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraAgendamentoAtualizado = scanner.nextLine();
				cadastroAtualizado
						.setHorarioAgendamento(LocalDateTime.parse(dataEhoraAgendamentoAtualizado, formatter));
				System.out.println("Digite os Detalhes: ");
				cadastroAtualizado.setDescricao(scanner.nextLine());
				System.out.println("Digite o ID do Pet: ");
				DestinoVolta petAtendimentoAtualizado = new DestinoVolta();
				petAtendimentoAtualizado.setId(scanner.nextInt());
				cadastroDAO.updateCadastro(cadastroAtualizado);
				
				break;
			case 4:
				System.out.println("Digite o ID de Cadastro a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
						int idcadastro = scanner.nextInt();
				
				cadastroDAO.deleteCadastro(idcadastro);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}
}
