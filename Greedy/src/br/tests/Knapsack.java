package br.tests;

import java.util.Arrays;


public class Knapsack {

	static class Inv implements Comparable<Inv> {
		
		public double value;			// valor do objeto
		public double profit;			// beneficio de se escolher esse objeto
		public double frac;
		
		public Inv(double value, double profit) {
			this.value = value;
			this.profit = profit;
		}	
		@Override
		public int compareTo(Inv inv) {
			double a = this.value / this.profit;
			double b = inv.value / inv.profit;
			if(a < b) {
				return -1;
			} else if(almostEquals(a, b)) {
				return 0;
			}
			return 1;
		}
		
		public static boolean almostEquals(double a, double b) {
			return Math.abs(a - b) < 10E-9;
		}
	}
	
	// solucao do problema para classe Inv
	// algoritmo para mochila fracionaria
	public static double knapsackInv(Inv[] invs, int capacity) {
		// weight: valor armazenado na mochila durante o processo de escolha
		// total: valor final armazenado na mochila
		double weight = 0.0, total = 0.0;
		// ordenar os objetos com a relacao da razao entre valor/peso
		Arrays.sort(invs);
		int i = 0;
		for(i=0; i<invs.length; i++) {
			// se ja foi atigindo valor maximo
			if(invs[i].profit + weight > capacity)
				break;
			invs[i].frac = 1.0;
			total += invs[i].value;
			weight += invs[i].profit;
		}
		// se nem todos os objetos couberam na mochila
		// inserir uma fracao do melhor objeto
		if(i < invs.length) {
			invs[i].frac = (capacity - weight) / invs[i].profit;
			total += invs[i].value * invs[i].frac;
		}
		return total;
	}
	
	static class Backpack {
		
	}

	
	public static void main(String[] args) {
		
	}

	public static void testAlmostEquals() {
		//double s = 0.78539816339744830961566084581988;
		//System.out.printf("%.10f\n", 10E-9);
		System.out.printf("%.10f\n%.10f\n%.10f\n%s\n",
				22.0/7.0
				,Math.PI
				,Math.abs(22.0/7.0 - Math.PI)
				,Math.abs(22.0/7.0 - Math.PI) < 10E-9);
		System.out.println("");
		
		System.out.printf("%.20f\n%.20f\n%.20f\n"
				,0.78539816339744840
				,(45*Math.PI/180)
				,0.78539816339744840 - (45*Math.PI/180));
		System.out.println(Math.abs(0.78539816339744831- (45*Math.PI/180)) < 10E-9);
	}
	
}
