package br.test.completesearch;

public class EightQueenProblem {

	static int counter = 0;
	
	/**
	 * Algumas regras interessantes
	 * Um tabuleiro de xadrez por padrão tem dimensão 8X8, numa tentativa simploria
	 * de solucionar o problema poderiamos explorar todas as combinacoes
	 * que nos daria um espaco de busca de 8 ^ 8 tentativas
	 * 
	 * 1) para diminuir o espaco de busca utilizaremos um vetor com 8 espacos
	 * pois sabemos que as Rainhas(Queens) segundo as regras do xadres nao podem ficar
	 * na mesma linha
	 * 
	 * 
	 * 2) sabemos tambem que 2 rainhas seguidas nao podem ficar na diagonal
	 * ou seja a rainha A(i,j) e B(k,l) nao podem ter | i- j | == |k - l|
	 * 
	 * */
	
	public static boolean areInDiagonal(int l1, int c1, int l2, int c2) {
		return Math.abs(l2-l1) == Math.abs(c2-c1);
	}
	// verificar se 
	public static boolean areInSameRow(int l1, int l2) {
		return l1 == l2;
	}
	
	/*
	 * como dito int queen eh o valor da coluna no tabuleiro e a i-esima rainha a ser posta nele
	 * int row: a linha onde a i-esima rainha sera posta
	 * */
	public static boolean isPossible(int row, int queen, int [] set) {
		for(int prev = 1; prev<queen; prev++) {
			// prev == coluna e set[prev] = linha 
			// a rainha prev
			if(areInSameRow(set[prev], row)  
					|| areInDiagonal(set[prev], prev, row, queen)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * int queen: comecemos por uma rainha qualquer, o numero da rainha
	 * tambem representa a coluna que q ela foi posta
	 * 
	 * int [] set, eh o espaco de busca do tabuleiro de xadrez, porem reduzido
	 * a 1 X N
	 * 
	 * int l, c indicam onde a primeira rainha foi posicionada
	 * 
	 * */
	
	public static void permutation(int queen, int [] set, int l, int c) {
		for(int row=1; row<9; row++) {
			if(isPossible(row, queen, set)) {
				set[queen] = row;
				if(queen == set.length && set[c] == l) {
					System.out.printf("#%d", ++counter);
					for(int i=1; i<9; i++)
						System.out.printf(" %d ", set[i]);
					System.out.println("\n");
				} else {
					permutation(queen + 1, set, c, l);
				}
			}
		}
	}
	
	/*
	 * Uma solucao utilizando um metodo que tenta todas as possibilidades
	 * tentara 8 ^ 8 possibilidadea numa matrix 8 x 8
	 * Diminuindo o espaco de busca para uma matriz 1 x 8
	 * a quantidade de buscas e reduzida para 8!
	 * 
	 * Num tabuleiro N x N podemos realizar uma combinacao de (N x N) por N
	 * por exemplo num tabuleiro 8 x 8 podemos ter uma combincao de damas
	 * cujo resultado eh 64! / ( (64 - 8)! )!
	 * 
	 * */
	
	public static void main(String[] args) {
		// representa um tabuleiro de xadrez
		// espaco de estado, ignoramos o indice 0 para evitar contas chatas
		// space[] reduz o espaco de busca num tabuleiro NxN
		// o indice i representa a coluna em que a rainha esta, o valor de space[i] representa a linha
		int space [] = new int[9];
		int c = 1, l = 1;					// comenado pela
		permutation(1, space, l, c);
	}

}
