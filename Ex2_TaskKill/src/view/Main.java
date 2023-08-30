package view;

import javax.swing.JOptionPane;
import controller.KillController;


public class Main {

	public static void main(String[] args) {
		int caso = 9;
		StringBuffer escolha = new StringBuffer();
		KillController controller = new KillController();
		do{try {
			caso = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de uma opção:\n"
				+ "1 - Mostrar lista de processos\n"
				+ "2 - Matar processo por PID\n"
				+ "3 - Matar processor por nome\n"
				+ "0 - Sair"));
			switch (caso) {
			case 1:
				controller.listaProcessos();
				break;
			case 2:
				escolha.append(JOptionPane.showInputDialog("Insira o PID do processo que deseja matar."));
				controller.mataPid(escolha.toString());
				escolha.setLength(0);
				break;
			case 3:
				escolha.append(JOptionPane.showInputDialog("Insira o nome do processo que deseja matar."
						+ "\nCertifique de colocar o tipo no final (.txt, .exe, etc)"));
				controller.mataNome(escolha.toString());
				escolha.setLength(0);
			case 0:
				break;
			default:
				System.out.println("Por favor, insira o numero de uma das opcoes apresentadas.");
			}
		}catch(NumberFormatException e) {
			System.out.println("Por favor, insira o numero de uma das opcoes apresentadas.");
		}
	}while(caso != 0);
		}

}
