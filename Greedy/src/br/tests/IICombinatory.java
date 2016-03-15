package br.tests;

public class IICombinatory {

	/**
	 * http://code.geeksforgeeks.org/2EUhpb
	 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
	 * @return 
	 * */
	
	public static <T> void swap(T[] arr, int idxa, int idxb) {
		T aux = arr[idxa];
		arr[idxa] = arr[idxb];
		arr[idxb] = aux;
	}
	/**
	 * arr[] : ARRAY que sofrera a permutacao
	 * int s : indice do inicio do array, arr
	 * int e : indice do fim do array, arr
	 * int S : tamanho do array
	 * as permutacoes estao na ordem de N - fatorial, onde N e o tamanho do conjunto
	 * 
	 * http://mathworld.wolfram.com/Permutation.html
	 * */
	public static <T> void permute(T[] arr,  int s, int e) {
		if(s==e) {
			System.out.printf("%s\n", toString(arr));
			return;
		}
		for(int i=s; i<e; i++) {
			swap(arr, s, i);
			permute(arr,s+1, e);
			//swap(arr, s, i);
		}
	}
	
	// permutacao sem repeticoes
	// vetor boolean e[] indica que a e[i]-esimo elemto do array
	// ja foi inserido na permutacao
	public static <T> void permuteWithoutRep(T[] arr, boolean[] e, int l, int r) {
		if(l == r) {
			System.out.printf("%s\n", toString(arr));
			return;
		}
		for(int i=0; i<r; i++) {
			if(e[i])
				continue;
			e[i] = true;
			//swap(arr, l, i);
			//permuteWithoutRep(arr, e, l+1, r);
			//swap(arr, l, i);
			e[i] = false;
		}
	}
	
	static <T> String toString(T[] arr) {
		StringBuilder sb = new StringBuilder();
		for(T t : arr) {
			sb.append(t);
		}
		return sb.toString();
	}
	
	// http://www.geeksforgeeks.org/power-set/
	public static class PowerSet {
		
	}
	
	public static Character[] toArrayCharacter(char[] arr) {
		if(arr == null)
			return new Character[0];
		int len = arr.length;
		Character[] rs = new Character[len];
		for(int i=0; i<len; i++) {
			rs[i] = new Character(arr[i]);
		}
		return rs;
	}
	
	public static Character[] toArrayCharacter(String s) {
		if(s == null)
			return new Character[0];
		int len = s.length();
		Character[] rs = new Character[len];
		for(int i=0; i<len; i++) {
			rs[i] = new Character(s.charAt(i));
		}
		return rs;
	}
	
	// estilo java 8
	public static Character[] stringToArray(String S) {
		Character[] array = S.chars()
				.mapToObj(c -> (char) c)
				.toArray(Character[]::new);
		return array;
	}
	
	public static void main(String[] args) {
		Character[] set = toArrayCharacter("ABC");
		int len = set.length;
		//permute(set, 0, len);
		boolean [] e = new boolean[len];
		//for(int i=0; i<len; i++)
			//e[i] = false;
		permuteWithoutRep(set, e, 0, len);
	}

}
