package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	private String os() { // Verifica o sistema operacional
		String sys = System.getProperty("os.name");
		return sys;
	}

	private boolean verify() { // true = windows, false = linux
		String os = os();
		if (os.contains("Windows")) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public void listaProcessos() { // Lista os processos ativos e exibe no console
		if (verify() == true) { // Para Windows
			try {
				Process lista = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = lista.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // Para Linux
			try {
				Process lista = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = lista.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void mataPid(String pid) { // Mata o processo pelo PID
		if (verify() == true) { // para windows
			try {
				Runtime.getRuntime().exec("TASKKILL /PID " + pid);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // para linux
			if (verify() == true) { // para windows
				try {
					Runtime.getRuntime().exec("kill -9 " + pid);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	@SuppressWarnings("deprecation")
	public void mataNome(String nome) {
		if (verify() == true) { // para windows
			try {
				Runtime.getRuntime().exec("TASKKILL /IM " + nome);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // para linux
			if (verify() == true) { // para windows
				try {
					Runtime.getRuntime().exec("pkill -f " + nome);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}