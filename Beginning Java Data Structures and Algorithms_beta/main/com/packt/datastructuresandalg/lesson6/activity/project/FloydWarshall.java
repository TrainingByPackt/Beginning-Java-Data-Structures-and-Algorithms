package com.packt.datastructuresandalg.lesson6.activity.project;

import java.util.ArrayList;
import java.util.Vector;



public class FloydWarshall {
    int[][] adjacencyMatrix; // stores shortest distance from i to j
    
    /* stores previous node (to go to j) of shortest path from i to j
     * stores where we to go before from i for reaching j from i
     */
    int[][] comeFromMatrix; 
    
    String[][] nameOfStreets;


	public FloydWarshall(int numberOfNodes) {
    	
        this.adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
        this.comeFromMatrix = new int[numberOfNodes][numberOfNodes];
        this.nameOfStreets = new String[numberOfNodes][numberOfNodes];
        
        //Initialize the matrix
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
            	
            	//if it is itself
                if (i == j) {
                    this.adjacencyMatrix[i][j] = 0;
                    this.comeFromMatrix[i][j] = i;
                } else { //if it is not itself
                    this.adjacencyMatrix[i][j] = Integer.MAX_VALUE;
                    this.comeFromMatrix[i][j] = -1;
                }
            }
        }
    }

	public void addEdge(int fromNode, int toNode, int length , String streetName) {
        if (length < adjacencyMatrix[fromNode][toNode]) {
            adjacencyMatrix[fromNode][toNode] = length;
            comeFromMatrix[fromNode][toNode] = fromNode;
            nameOfStreets[fromNode][toNode] = streetName;
        }
    }

    public Vector<Integer> path(int fromNode, int toNode) {
    	//define return
        Vector<Integer> pathSqeuence = new Vector<>();
        
        //check if there is a path
        if (comeFromMatrix[fromNode][toNode] == -1)
            return pathSqeuence;
        
        //go backwards until where we start
        int reachedFromNode = toNode;
        while (fromNode != reachedFromNode) {
        	//add node to path
            pathSqeuence.add(0, reachedFromNode);
            //update reached from node
            reachedFromNode = comeFromMatrix[fromNode][reachedFromNode];
        }
        
        pathSqeuence.add(0, fromNode);
        
        return pathSqeuence;
    }

    public void run() {
    	
    	//for each intermediate node
        for (int k = 0; k < adjacencyMatrix.length; k++) {
        	
        	//for each from node
            for (int i = 0; i < adjacencyMatrix.length; i++) {
            	
            	//if there is no path from i to k skip 
                if (adjacencyMatrix[i][k] >= Integer.MAX_VALUE)
                    continue;
                
                //for each to node
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                	
                	//if there is no path from k to j skip
                    if (adjacencyMatrix[k][j] >= Integer.MAX_VALUE)
                        continue;
                    
                    //if path from i to j is shorter with stopping at k then update path
                    if (adjacencyMatrix[i][k] + adjacencyMatrix[k][j] < adjacencyMatrix[i][j]) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
                        comeFromMatrix[i][j] = comeFromMatrix[k][j];
                    }
                }
            }
        }
    }
    
    

    /**
     * @param fromNode
     * @param toNode
     * 
     * @return
     */
    public ArrayList<String> printPath(int fromNode, int toNode) {
        
    	//TODO printPath()
    	
        return null;
    }
}
