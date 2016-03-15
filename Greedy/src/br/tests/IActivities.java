package br.tests;

public class IActivities {
	
	public static class Activity implements Comparable<Activity> {
		int point, time, decrease;
		public Activity(int point, int time, int decrease) {
			this.point = point;
			this.time = time;
			this.decrease = decrease;
		}
		
		@Override
		public int compareTo(Activity activity) {
			return orderByTime(this, activity);
		}
		// metodo que compara duas atividades por tempo
		// ordena do menor para o maior
		public int orderByTime(Activity A, Activity B) {
			return A.time - B.time;
		}
		
		// metodo que compara duas atividades por pontos
		//ordena do menor para o maior
		public int orderByPoint(Activity A, Activity B) {
			return A.point - B.point;
		}
		/**
		 * Existe um problema formulado pelo sute HackerEarth
		 * onde cada atividade demora um tempo para ser executada
		 * e a cada T tempo passado um valor D e eh removido da pontuaca
		 * da Atividade corrente.
		 * 
		 * Busca se saber quais as atividades mais rentaveis devem ser escolhidas primeiro
		 * afim de maximizar a pontuação final
		 * */
		public int orderByTimeDecrease(Activity A, Activity B) {
			if(A.decrease/A.time > B.decrease/B.time) {
				return -1;
			} else if(A.time/A.decrease < B.time/B.decrease) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {

	}

}
