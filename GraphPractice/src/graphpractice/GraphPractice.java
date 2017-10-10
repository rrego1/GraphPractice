/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reggs
 */
public class GraphPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [][] graph = createAdjacencyMatrix("graph.txt");
        
    }
    
    //creates an undirect graph from a file in the form of an adjacency matrix
    //the first line in the file represents the number of vertecies in the graph
    //the second line represents the number of edges
    //the following lines represent each
    public static int[][] createAdjacencyMatrix(String filename){
        File file = new File(filename);
        int [][] adjacencyMatrix = null;
        try {
            Scanner reader = new Scanner(file);
            int verticies = reader.nextInt();
            int edges = reader.nextInt();
            adjacencyMatrix = new int[verticies][verticies];
            for(int i = 0; i < edges; i++){
                int firstVertex = reader.nextInt();
                int secondVertex = reader.nextInt();
                adjacencyMatrix[firstVertex - 1][secondVertex - 1] = 1;
                adjacencyMatrix[secondVertex - 1][firstVertex - 1] = 1;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GraphPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adjacencyMatrix;
    }
}
