package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redes = new RedesController();
		StringBuffer caso = new StringBuffer();
		while (!caso.toString().toLowerCase().equals("sair")) {
			caso.setLength(0);
			caso.append(JOptionPane.showInputDialog("Insira 'ip' para descobrir o ip\n"
													+"Insira 'ping' para descobrir o ping\n"
													+ "Insira 'sair' para sair"));
			switch (caso.toString().toLowerCase()) {
			case "ip":
				redes.ip();
				break;
			case "ping":
				System.out.println("Aguarde enquanto o programa testa o ping.");
				redes.ping();
				break;
			case "sair":
				break;
			default:
				System.out.println("Opcao invalida, tente novamente.");
			}
		 
			
		}
	}

}
