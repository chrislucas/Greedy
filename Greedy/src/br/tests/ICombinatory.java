package br.tests;

import java.util.Arrays;


// http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/

public class ICombinatory {


	
	/**
	 * int set[]: conjunto com todos os numeros
	 * int aux[]: array auxiliar para gerar a combinacao de N de P em P
	 * int n: tamanho de set[]
	 * int idxArray: indice do array no processo recursivo
	 * int P: tamanho dos subconjuntos
	 * */
	public static <T> void combinatory(T set[], int n, T aux[]
			 ,int idxset, int idxaux, int P) {
		// se o tamanho do sub conjunto foi atigindo
		if(idxaux == P) {
			for(int i=0; i<P; i++) {
				System.out.printf("%d ", aux[i]);
			}
			System.out.printf("\n");
			return;
		}
		if(idxset == n) {
			return;
		}
		// i-esimo elemento do conjunto (set[idxset]) incluso
		// no como i-esimo elemento do subconjunto aux
		aux[idxaux] = set[idxset];
		combinatory(set, n, aux, idxset+1, idxaux+1, P);
		// para evitar subconjuntos duplicados
		while( idxset<n-1 && (set[idxset] == set[idxset+1]) )
			idxset++;
		combinatory(set, n, aux, idxset+1, idxaux, P);
	}
	
	public static void main(String[] args) {
		 Integer set[] = {1, 2, 3, 4, 5};
		 Arrays.sort(set);
		 combinatory(set, set.length, new Integer[set.length], 0, 0, 3);
	}

}
