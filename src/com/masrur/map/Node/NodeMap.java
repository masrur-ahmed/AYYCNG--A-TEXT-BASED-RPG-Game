/**
 * 
 */
package com.masrur.map.Node;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import com.masrur.map.Graph.*;

/**
 * @author S. M. Masrur Ahmed
 *
 */
public class NodeMap implements Comparable<NodeMap>{
	private int areaNum=0;
	private String areaname="";
	private int areaJam=0;
	private double areaDist=0;
	private int areaChoice=0;
	public Double findM;
	/**
	 * @return the areaNum
	 */
	public ArrayList<Edge> neighbours;
	public LinkedList<NodeMap> path;
	public NodeMap(int areaNum,String areaName) {
		neighbours = new ArrayList<Edge>();
		path = new LinkedList<NodeMap>();
		setAreaNum(areaNum);
		setAreaname(areaName);
		setAreaJam();
	}
	public int getRandom() {
		return ThreadLocalRandom.current().nextInt(0, 10 + 1);
	}
	public int getAreaNum() {
		return areaNum;
	}
	/**
	 * @param areaNum the areaNum to set
	 */
	public void setAreaNum(int areaNum) {
		this.areaNum = areaNum;
	}
	/**
	 * @return the areaname
	 */
	public String getAreaname() {
		return areaname;
	}
	/**
	 * @param areaname the areaname to set
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	/**
	 * @return the areaJam
	 */
	public int getAreaJam() {
		return areaJam;
	}
	/**
	 * @param areaJam the areaJam to set
	 */
	public void setAreaJam() {
		this.areaJam = getRandom();
	}
	/**
	 * @return the areaDist
	 */
	public double getAreaDist() {
		return areaDist;
	}
	/**
	 * @param areaDist the areaDist to set
	 */
	public void setAreaDist(int dist) {
		this.areaDist = dist ;
	}
	/**
	 * @return the areaChoice
	 */
	public int getAreaChoice() {
		return areaChoice;
	}
	/**
	 * @param areaChoice the areaChoice to set
	 */
	public void setAreaChoice(int areaChoice) {
		this.areaChoice = areaChoice;
		/// choiceJam=1 ChoiceDistance=0
		if(areaChoice==1) {
			findM=(double)getAreaJam();
		}
		else {
			findM=getAreaDist();
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(NodeMap n) {
		// TODO Auto-generated method stub
		return Double.compare(findM,n.findM);
	}
	
}
