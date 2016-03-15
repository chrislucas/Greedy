package br.tests;

import java.util.Arrays;

public class ActivitySchedule {
	
	public static class Activity implements Comparable<Activity> {
		int time, weight;
		char label;
		
		public Activity(int time, int weight, char label) {
			this.time = time;
			this.weight = weight;
			this.label = label;
		}
		
		@Override
		public int compareTo(Activity activity) {
			return compareByWeigth(this, activity);
		}
		// em ordem decrescente
		public int compareByWeigth(Activity a, Activity b) {
			return b.weight - a.weight;
		}
		
		public int compareByRatio(Activity a, Activity b) {
			return a.weight/a.time - b.weight/b.time;
		}
	}
	
	public static Activity[] select(Activity [] a) {
		Activity[] set = new Activity[a.length + 1];
		int limit = a.length, count = 0/*, res[] = new int[a.length]*/;
		//for(int i=0; i<limit; i++)
			//res[i] = -1;
		boolean [] slots = new boolean[a.length + 1];
		for(int i=0; i<limit; i++) {
			int time =  a[i].time;
			int min = (limit < time ? limit : time);
			for(int j=min; j>0; j--) {
				if(!slots[j]) {
					set[count++] = a[i];
					//res[j] = i;
					slots[j] = true;
					break;
				}
			}
		}
		return set;
	}
	
	public static void execute() {
		Activity [] act = {
				/*
				new Activity(2, 100, 'a')
				,new Activity(1, 19, 'b')
				,new Activity(2, 27, 'c')
				,new Activity(1, 25, 'd')
				,new Activity(3, 15, 'e')
				*/
				 new Activity(2,5,'a')
				,new Activity(2,5,'b')
				,new Activity(1,100,'a')
				,new Activity(4,10,'a')
		};
		Arrays.sort(act);
		// solucao O(n^2)
		Activity[] sel = select(act);
		
		for(int i=0; sel[i] != null; i++) {
			System.out.printf("%c", sel[i].label);
		}
	}

	public static void main(String[] args) {
		execute();
	}

}
