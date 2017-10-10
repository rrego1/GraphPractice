/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author reggs
 */
public class GraphPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("graph.txt");
        Scanner inputFile = new Scanner(file);
        int i = inputFile.nextInt();
        System.out.println(i);
        //int [][] graph = createGraphMatrix("graph.txt");
        
    }
        
    //takes an input file and creates an adjacency matrix
    //the first line specifies the amount of verticies
    //the second line specifies the number of edges
    //following lines represent edges
    private static int[][] createGraphMatrix(String filename) throws FileNotFoundException{
            File file = new File(filename);
            Scanner inputFile = new Scanner(file);
            int verticies = inputFile.nextInt();
            int edges = inputFile.nextInt();
            int [][] graph = new int[verticies][verticies];
           
            for(int i = 0; i < edges; i++){
                int v1 = inputFile.nextInt();
                int v2 = inputFile.nextInt();
                graph[v1 - 1][v2 - 1] = 1;
                graph[v2 - 1][v1 - 1] = 1;
            }
            
            return graph;
    }
    

}
