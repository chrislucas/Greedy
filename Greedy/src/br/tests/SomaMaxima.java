package br.tests;

public class SomaMaxima {
	
	public static int[] naive(int A[], int li, int ls) {
		int [] n = {0,0,0};
		int sum;
		for(int i=0; i<ls-1; i++) {
			sum = 0;
			for(int j=i; j<ls; j++) {
				sum += A[j];
				if(sum > n[0]) {
					n[0] = sum;
					n[1] = i;
					n[2] = j;
				}
			}
		}
		return n;
	}
	// para armazenar os indices de inicio e fim do subarray de soma maxima
	public static int x, y;
	// usar a divisao e conquita O(n log n)
	public static int dq(int [] vect, int li, int ls) {
		int ans = 0;
		if(li == ls) {
			return vect[ls];
		} else {
			int mid = (ls - li) / 2 + li;
			// avalia o vetor do meio para esquerda
			int rs1 = dq(vect, li, mid);
			// avalia o vetor do meio para direira
			int rs2 = dq(vect, mid+1, ls);
			int fsum, sum;	// first summation
			fsum = sum = vect[mid];
			for(int i=mid-1; i>=li; i--) {
				sum += vect[i];
				if(sum > fsum)
					fsum = sum;
			}
			int ssum;
			ssum = sum = vect[mid+1];
			for(int i = mid+2; i<=ls; i++) {
				sum += vect[i];
				if(sum > ssum) {
					ssum = sum;
				}
			}
			ans = Math.max(Math.max(rs1, rs2), fsum+ssum);
		}
		return ans;
	}
	
	// usando PD O(n)
	public static int[] dpv1(int [] vect, int ls) {
		int[] ans = {0,0,0};
		int sum = 0, temp = 0;
		for(int i=0; i<ls; i++) {
			sum += vect[i];
			if(sum > ans[0]) {
				ans[0] = sum;
				ans[1] = temp;
				ans[2] = i;
			}
			if(sum < 0){
				sum = 0;
				temp = 1+i;
			}
		}
		return ans; 
	}
	
	public static int [] dpv2() {
		int [] n = {0,0,0};
		return n;
	}

	public static void main(String[] args) {
		int [][] mat = {
			 {1,3,-5,10,-5}		// 10
			,{1,3,-3,10,-5}		// 11
			,{1,3,-2,10,-5}		// 12
			,{20,-30,15,-10,30,-20,-30,30}	//35
		};
		
		System.out.println(dq(mat[1] , 0, mat[1].length-1));
		/*
		int[] n = {};
		n = naive(mat[3] , 0, mat[3].length);
		System.out.printf("%d %d %d\n", n[0], n[1], n[2]);
		n = dpv1(mat[0] , mat[0].length);
		System.out.printf("%d %d %d\n", n[0], n[1], n[2]);
		*/
	}

}
