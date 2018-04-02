package com.masrur.map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.masrur.map.Graph.Graph;
import com.masrur.map.MapImple.MapApplied.MapRPG;
import com.masrur.map.Node.NodeMap;

/**
 * 
 */

/**
 * @author JAVA
 *
 */
public class MapForAyCNG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String area[]= {"Mirpur","Gulshan","Bashundhara RA","Mohammadpur","Mohakhali","Badda","Azimpur","Dhanmondi","Motijhil"};
		Graph g = new Graph(9,area);
		MapRPG mrpg=new MapRPG();
		// Add the required edges.
		System.out.println("How do you want to reach !! /t press 1 for less jam or press 2 for less distance");
		int choice=sc.nextInt();
		sc.close();
		if(choice==2) {
			g.addEdge(0, 1, 4);
			g.addEdge(0, 3, 5);
			g.addEdge(0, 4, 7);
			g.addEdge(1, 0, 5);
			g.addEdge(1, 2, 5);
			g.addEdge(1, 4, 5); 
			g.addEdge(2, 1, 5);
			g.addEdge(2, 5, 5);
			g.addEdge(2, 4, 7); 
			g.addEdge(3, 0, 5); 
			g.addEdge(3, 4, 7); 
			g.addEdge(3, 6, 5); 
			g.addEdge(4, 1, 5);
			g.addEdge(4, 3, 5);
			g.addEdge(4, 5, 5);
			g.addEdge(4, 7, 5);
			g.addEdge(4, 0, 7);
			g.addEdge(4, 8, 7);
			g.addEdge(4, 6, 7);
			g.addEdge(4, 2, 7);
			g.addEdge(5, 4, 5);
			g.addEdge(5, 8, 5); 
			g.addEdge(5, 2, 5);
			g.addEdge(6, 3, 5); 
			g.addEdge(6, 7, 5); 
			g.addEdge(6, 4, 7);
			g.addEdge(7, 4, 5);
			g.addEdge(7, 6, 5); 
			g.addEdge(7, 8, 5);
			g.addEdge(8, 5, 5); 
			g.addEdge(8, 7, 5); 
			g.addEdge(8, 4, 7);
		}
		else {
			g.addEdge(0, 1, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(0, 3, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(0, 4, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(1, 0, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(1, 2, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(1, 4, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(2, 1, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(2, 5, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(2, 4, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(3, 0, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(3, 4, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(3, 6, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(4, 1, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(4, 3, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(4, 5, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(4, 7, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(4, 0, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(4, 8, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(4, 6, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(4, 2, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(5, 4, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(5, 8, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(5, 2, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(6, 3, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(6, 7, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(6, 4, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(7, 4, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(7, 6, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(7, 8, ThreadLocalRandom.current().nextInt(0, 10 + 1));
			g.addEdge(8, 5, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(8, 7, ThreadLocalRandom.current().nextInt(0, 10 + 1)); 
			g.addEdge(8, 4, ThreadLocalRandom.current().nextInt(0, 10 + 1));
		}
		mrpg.calculate(g.getNodeMap(0));	

		for(NodeMap v:g.getVertices()){
			System.out.print("NodeMap - "+v+" , Dist - "+ v.findM+" , Path - ");
			for(NodeMap pathvert:v.path) {
				System.out.print(pathvert+" ");
			}
			System.out.println(""+v);
		}


	}

}
