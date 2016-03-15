package br.problem.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

// DONE

public class GridChallenge {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		String enter;
		
		try {
			enter = reader.readLine();
			int cases = Integer.parseInt(enter);
			ArrayList<String> chars = new ArrayList<>();
			while(cases>0) {
				int grid = Integer.parseInt(reader.readLine());
				for(int i=0; i<grid; i++) {
					enter = reader.readLine();
					chars.add(enter);
				}
				char [][] allChars = new char[grid][grid];
				//char[] aux = new char[grid*grid];
				int idx = 0;
				for(int i=0; i<chars.size(); i++) {
					char[] str = chars.get(i).toCharArray();
					//chars.remove(i);
					Arrays.sort(str);
					//chars.add(i,String.valueOf(str));
					for(int j=0; j<grid; j++) {
						allChars[i][j] = str[j];
					}
				}
				
				// analizando
				boolean lex = true;
				  
				//solucionava 99% dos casos de testes
				/*
				for(int i=0; i<grid; i++) {
					for(int j=0; j<grid-1; j++) {
						// antes da ultima linha
						if(i<grid-1) {
							// antes da ultima coluna
							if(j < grid-1) {
								if(allChars[i][j] > allChars[i][j+1]
										|| allChars[i][j] > allChars[i+1][j]) {
									lex = false;
									break;
								}
							} 
							// na ultima coluna
							else {
								if(allChars[i][j+1] > allChars[i+1][j+1]) {
									lex = false;
									break;
								}
							}

						} 
						// na ultima linha
						else {
							if(allChars[i][j] > allChars[i][j+1]) {
								lex = false;
								break;
							}
						}
					}
				}
				*/
				// veriricar se uma matriz esta ou nao em ordem alfabetica
				// eita diacho
			    for(int i=0; i<grid; i++){
		    		if(!lex)
		    			break;
			    	for(int j=0; j<grid; j++) {
			    		if(!lex)
			    			break;
			    		for (int k=i; k<grid; k++) {
				    		if(!lex)
				    			break;
			    			for (int z=j; z<grid; z++) {
			    				if(allChars[i][j] > allChars[k][z]) {
									lex = false;
			    				}
			    			}
			    		}
			        }
			    }
		    
				writer.printf("%s\n", lex ? "YES" : "NO");
				chars.clear();
				cases--;
			}
		} catch(IOException ioex){}
	}
}

/*

*/
