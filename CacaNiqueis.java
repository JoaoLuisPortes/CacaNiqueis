/*
 * CacaNiqueis.java
 * 
 */
import java.util.Scanner;
import java.util.Random;

public class CacaNiqueis {
	
	public static void main (String[] args) {
		Scanner leia = new Scanner(System.in);
		System.out.println("\t<---Máquina Caça-Níqueis--->");
		System.out.println("Para ganhar, é necessário uma sequência de três 0s");
		char reiniciar;
		do{
			iniciarJogada();
			System.out.print("Jogar Novamente[s/n]: ");
			reiniciar = leia.next().toLowerCase().charAt(0);
			System.out.print("----------------------------------\n");
		} while (reiniciar == 's');
	}
	static void iniciarJogada(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nInsira o valor que deseja apostar: ");
		double valorAposta = scanner.nextDouble();
		int multiplicador = selecionarMultiplicador(scanner);
		int[][] niqueis = sequenciaNiqueis(multiplicador);
		identificarVitoria(niqueis, valorAposta, multiplicador);
	}
	
	static int selecionarMultiplicador(Scanner scanner){
		int multiplicador;
		do{
			System.out.print("Multiplicador[2 a 5]: ");
				multiplicador = scanner.nextInt();
				if (multiplicador < 2 || multiplicador > 5){
					System.out.println("Valor Inválido");
				}
		} while (multiplicador < 2 || multiplicador > 5);
		return multiplicador;
	}
	
	static int[][] sequenciaNiqueis(int multiplicador){
		Random random = new Random();
		int[][] niqueis = new int[3][3];
		System.out.println("\n    <\\<\\<\\Slots/>/>/>");
		for (int i = 0; i < 3; i++){
			System.out.print("\t");
			for (int j = 0; j < 3; j++){
				niqueis[i][j] = random.nextInt(multiplicador + 2);
				if (i == 1) {
					System.out.print((j == 0 ? "> " : "") + niqueis[i][j] + (j == 2 ? " <" : " "));
				} else {
					System.out.print((j == 0 ? "| " : "") + niqueis[i][j] + (j == 2 ? " |" : " "));
				}
			}
			System.out.println();
		}
		return niqueis;
	}
	
	static void identificarVitoria(int[][] niqueis, double valorAposta, int multiplicador) {
		if (niqueis[1][0] == 0 && niqueis[1][1] == 0 && niqueis[1][2] == 0){
			double valorGanho = valorAposta * multiplicador;
			System.out.println("\nParabéns! Você ganhou: " + valorGanho + "$");
		}else{
			System.out.println("\nVocê Perdeu");
		}
	}
}


