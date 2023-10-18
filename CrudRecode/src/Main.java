

import java.util.Scanner;
import java.sql.Date;

import com.petshop.utils.Colors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {
			case 1:
				ClienteIO.SubMenuCliente(scanner);
				break;
			case 2:
				DestinoIO.SubMenuPet(scanner);
				break;
			case 3:
				DestinoVoltaIO.SubMenuVeterinario(scanner);
				break;
			case 4:
				CadastroIO.SubMenuAtendimento(scanner);
				break;
			default:
				System.out.println(Colors.RED.get() + "Digite uma opcao valida!" + Colors.RED.get());

			}

		} while (option != 5);
		scanner.close();

	}

}
