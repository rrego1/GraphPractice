/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        
        //ArrayList<Node> graph = createAdjacencyList("graph.txt");
        TreeNode graph = createBinaryTree("graph.txt");
        
    }
    
    //creates an undirect graph from a file in the form of an adjacency matrix
    //the first line in the file represents the number of vertecies in the graph
    //the second line represents the number of edges
    //the following lines represent each
    public static int[][] createAdjacencyMatrix(String filename){
        File file = new File(filename);
        int[][] adjacencyMatrix = null;
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
    
    //creates a directed graph in the form of an adjacency list from a file
    //each line represents an edge
    //the first int is the starting vertex
    //the second int is the ending vertex for the edge
    public static ArrayList<Node> createAdjacencyList(String filename){
        File file = new File(filename);
        Scanner reader;
        ArrayList<Node> graph = new ArrayList();
        try {
            reader = new Scanner(file);
            while(reader.hasNext()){
                int origin = reader.nextInt();
                int destination = reader.nextInt();
                Node startNode = getVertex(graph, origin);
                Node endNode = getVertex(graph, destination);
                startNode.addEdge(endNode);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GraphPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return graph;
    }
    
    public static Node getVertex(ArrayList<Node> graph, int vertex){
        Node node;
        for(Node treeNode : graph){
            if(treeNode.getIndex() == vertex){
                return treeNode;
            }
        }
        node = new Node(vertex);
        graph.add(node);
        return node;
    }
    
    public static boolean isConnected(int [][] graph){
       
        return false;
    }
    
    //creates a binary tree from a file
    //first line is the graph in pre order
    //second line is the graph in in order
    public static TreeNode createBinaryTree(String filename){
        File file = new File(filename);
        
        try {
            Scanner reader = new Scanner(file);
            String pre = reader.nextLine();
            String in = reader.nextLine();
            
            pre = pre.trim();
            in = in.trim();
            
            String[] preStringArr = pre.split(" ");
            String[] inStringArr = in.split(" ");
            
            int[] preArr = new int[preStringArr.length];
            int[] inArr = new int[preStringArr.length];
            
            for(int i = 0; i < preStringArr.length; i++){
                preArr[i] = Integer.parseInt(preStringArr[i]);
                inArr[i] = Integer.parseInt(inStringArr[i]);
            }
            
            return buildTree(preArr, inArr);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GraphPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static TreeNode buildTree(int[] pre, int[] in){
        TreeNode root = new TreeNode(pre[0]);
        int index = -1;
        for(int i = 0; i < in.length; i++){
            if(pre[0] == in[i]){
                index = i;
            }
        }
        root.setLeft(buildLeft(pre, in, 0, index));
        root.setRight(buildRight(pre, in, 0, index));
        return root;      
    }
    
    public static TreeNode buildLeft(int[] pre, int[] in, int preIndex, int inIndex){
        int pointer = preIndex;
        while(pointer < pre.length - 2){
            if(checkValidLocation(in, 0, inIndex, pre[pointer + 1])){
                TreeNode node = new TreeNode(pre[pointer + 1]);
                int newIn = -1;
                for(int i = 0; i < inIndex; i++){
                    if(pre[pointer + 1] == in[i]){
                        newIn = i;
                        break;
                    }
                }
                node.setLeft(buildLeft(pre, in, pointer + 1, newIn));
                node.setRight(buildRight(pre, in, pointer + 1, newIn));              
                return node;
            }
            pointer++;
        }
        return null;
    }
    
    public static TreeNode buildRight(int[] pre, int[] in, int preIndex, int inIndex){
        int pointer = preIndex;
        while(pointer < pre.length - 1){
            if(checkValidLocation(in, inIndex, in.length, pre[pointer + 1])){
                TreeNode node = new TreeNode(pre[pointer + 1]);
                int newIn = -1;
                for(int i = inIndex; i < in.length; i++){
                    if(pre[pointer + 1] == in[i]){
                        newIn = i;
                        break;
                    }
                }
                node.setLeft(buildLeft(pre, in, pointer + 1, newIn));
                node.setRight(buildRight(pre, in, pointer + 1, newIn));              
                return node;
            }
            pointer++;
        }
        return null;
    }
    
    public static boolean checkValidLocation(int[] array, int start, int end, int value){
        for(int i = start; i < end; i++){
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }
}
