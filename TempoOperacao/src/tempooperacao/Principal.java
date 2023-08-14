package tempooperacao;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Tempo para preencher um vetor com 1000 posicoes: "+ mil()+"ns");
		System.out.println("Tempo para preencher um vetor com 10000 posicoes: "+ dezmil()+"ns");
		System.out.println("Tempo para preencher um vetor com 100000 posicoes: "+ cemmil()+"ns");
	}
	public static String mil(){
		 int vetor1[] = new int [1000];
		 long tempoInicial = System.nanoTime();
		for(int i =0; i<1000; i++) {
			vetor1[i] = 0;
		}
		long tempoFinal = System.nanoTime() - tempoInicial;
		return String.valueOf(tempoFinal);
	}
	
	public static String dezmil(){
		 int vetor2[] = new int [10000];
		 long tempoInicial = System.nanoTime();
		for(int i =0; i<10000; i++) {
			vetor2[i] = 0;
		}
		long tempoFinal = System.nanoTime() - tempoInicial;
		return String.valueOf(tempoFinal);
	}
	
	public static String cemmil(){
		 int vetor3[] = new int [100000];
		 long tempoInicial = System.nanoTime();
		for(int i =0; i<100000; i++) {
			vetor3[i] = 0;
		}
		long tempoFinal = System.nanoTime() - tempoInicial;
		return String.valueOf(tempoFinal);
	}
	

}
