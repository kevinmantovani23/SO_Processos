package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	private static String os() { // Verifica o sistema operacional
		String sys = System.getProperty("os.name");
		return sys;
	}

	public static void ip() { // Verifica apenas os adaptadores que contém IPv4, mostrando seu nome e IPv4
		try {
			if (verify() == true) {//Para windows
				@SuppressWarnings("deprecation")
				Process ip = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				String adaptador = "";

				while (linha != null) {
					if (linha.contains("Ethernet")) {
						adaptador = linha;
					}
					if (linha.contains("IPv4")) {
						System.out.println(adaptador + "\n" + linha);
					}
					linha = buffer.readLine();
				}
			} else {//Para Linux
				@SuppressWarnings("deprecation")
				Process ip = Runtime.getRuntime().exec("if addr");
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				String adaptador = "";
				String adap[] = new String[7];
				while (linha != null) {
					linha = buffer.readLine();
					if (linha.contains("Link encap")) {
						adaptador = linha;
						adap = adaptador.split(":");
						adap = adap[1].split(" ");
						adaptador = adap[0];
					}
					if (linha.contains("inet addr")) {
						adap = linha.split(":");
						adap = adap[1].split(" ");
						System.out.println("Adaptador de rede: " + adaptador + "\nIPv4: " + adap[0]);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void ping() {  //Verifica o ping médio na a interação com o site google.com.br
		if (verify() == true) { //Para windows
			try {
				@SuppressWarnings("deprecation")
				Process ping = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				InputStream fluxo2 = ping.getInputStream();
				InputStreamReader leitor2 = new InputStreamReader(fluxo2);
				BufferedReader buffer2 = new BufferedReader(leitor2);
				String linha2 = buffer2.readLine();
				String media[] = new String[4];
				while (linha2 != null) {
					System.out.print(".");
					if (linha2.contains("Average") || linha2.contains("Média")) {
						media = linha2.split("=");
						System.out.println("\nMedia de ping: " + media[3]);
						break;
					} else {
						linha2 = buffer2.readLine();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {//Para Linux
				@SuppressWarnings("deprecation")
				Process ping = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
				InputStream fluxo2 = ping.getInputStream();
				InputStreamReader leitor2 = new InputStreamReader(fluxo2);
				BufferedReader buffer2 = new BufferedReader(leitor2);
				String linha2 = buffer2.readLine();
				String media[] = new String[7];
				while (linha2 != null) {
					System.out.print(".");
					if (linha2.contains("avg")) {
						media = linha2.split("/");
						System.out.println("\nMedia de ping: " + media[4] + "ms");
						break;
					} else {
						linha2 = buffer2.readLine();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean verify() { // true = windows, false = linux
		String os = os();
		if (os.contains("Windows")) {
			return true;
		} else {
			return false;
		}
	}

}
