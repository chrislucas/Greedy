package br.tests;


public class ScheduleUF {
	
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
	
	static Activity activities[];
	static int countActivities;
	static int setActivities[];
	
	public static void init(int n) {
		// o indice 0 nao sera usado
		setActivities = new int[n+1];
		for(int i=0; i<n+1; i++)
			setActivities[i] = i;
		
		activities = new Activity[n+1];
		countActivities = 0;
	}
	
	public static int find(int child) {
		while(setActivities[child] != child) {
			child = setActivities[child];
		}
		return child;
	}
	
	public static void addActivity(int time, int weight, char label) {
		activities[countActivities++] = new Activity(time, weight, label);
	}
	
	public static void main(String[] args) {
		

	}

}
