package br.tests;

import java.util.Arrays;

public class ProblemActivity {

	static class Act implements Comparable<Act> {
		int s, e;
		public Act(int s, int e) {
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Act activity) {
			return this.e - activity.e;
		}
		
		public static void printSubSetMax(Act[] activities) {
			int [] set = new int[activities.length];
			int count = 0;
			Act early = activities[0];
			set[count++] = 0; 
			for(int i=1; i<activities.length; i++) {
				Act current = activities[i];
				if(early.e < current.s) {
					early = current;
					set[count++] = i;
				}
			}
			for(int i=0; i<count; i++)
				System.out.printf(i == 0 ? "%d" : " %d", set[i]);
			System.out.printf("\n");
			return;
		}
	}
	
	public static void main(String[] args) {
		Act[] activities = {
			 new Act(1, 2)
			,new Act(3, 4)
			,new Act(0, 6)
			,new Act(5, 7)
			,new Act(8, 9)
			,new Act(5, 9)
		};
		Arrays.sort(activities);
		ProblemActivity.Act.printSubSetMax(activities);
	}

}
