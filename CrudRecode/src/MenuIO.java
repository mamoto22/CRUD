
import java.util.Scanner;

import com.petshop.utils.Colors;

public class MenuIO {

	
	public static int menu(Scanner scanner) {
		System.out.println(Colors.CYAN_BOLD.get() + "Escolha uma opcao de 1 - 5\n" + Colors.RESET.get()
		+ "1 - Cliente\n" + "2 - Destino\n" + "3 - Destino de volta\n" + "4 - Cadastrar\n" + "5 - Sair");
		
		
		return scanner.nextInt();
		
	}
	
	
}
