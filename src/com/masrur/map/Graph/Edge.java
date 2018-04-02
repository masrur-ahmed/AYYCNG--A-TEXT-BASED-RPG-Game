/**
 * 
 */
package com.masrur.map.Graph;

import com.masrur.map.Node.NodeMap;

/**
 * @author JAVA
 *
 */
public class Edge{
	  public final NodeMap target;
		public final double weight;
		public Edge(NodeMap target, double weight){
			this.target = target;
			this.weight = weight;
		}
}