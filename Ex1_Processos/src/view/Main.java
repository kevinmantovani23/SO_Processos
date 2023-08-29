package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		StringBuffer caso = new StringBuffer();
		while (!caso.toString().toLowerCase().equals("sair")) {
			caso.setLength(0);
			caso.append(JOptionPane.showInputDialog("Insira 'ip' para descobrir o ip ou 'ping' para descobrir o ping, ou 'sair' para sair"));
			switch (caso.toString().toLowerCase()) {
			case "ip":
				RedesController.ip();
				break;
			case "ping":
				RedesController.ping();
				break;
			case "sair":
				break;
			default:
				System.out.println("Opcao invalida, tente novamente.");
			}
		 
			
		}
	}

}
