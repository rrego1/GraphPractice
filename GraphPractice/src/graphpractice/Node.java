/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpractice;

/**
 *
 * @author reggs
 */
public class Node {
    private int index;
    private int [] edges;
    private int numEdges;
    
    Node(){
        index = 0;
        numEdges = 0;
        edges = new int[5];
    }
    
    Node(int index){
        this.index = index;
        numEdges = 0;
        edges = new int[5];
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public int getIndex(){
        return index;
    }
    
    public void setEdges(int [] edges){
        this.edges = edges;
    }
    
    public int[] getEdges(){
        return edges;
    }
    
    public void setNumEdges(int numEdges){
        this.numEdges = numEdges;
    }
    
    public int getNumEdges(){
        return numEdges;
    }
    
    public void addEdge(Node node){
        int length = edges.length;
        numEdges++;
        if(edges[length - 1] != 0){
            int[] newEdges = new int[length * 2];
            for(int i = 0; i < length; i++){
                newEdges[i] = edges[i];
            }
            newEdges[length] = node.getIndex();
            edges = newEdges;
        }
        for(int i = 0; i < length; i++){
            if(edges[i] == 0){
                edges[i] = node.getIndex();
                break;
            }
        }
    }
    
    public void removeEdge(Node node){
        int edge = -1;
        if(this.isEdge(node)){
            numEdges--;
            for(int i = 0; i < edges.length; i++){
                if(edges[i] == node.getIndex()){
                    edge = i;
                    break;
                }
            }
            edges[edge] = edges[numEdges];
            edges[numEdges] = 0;
        }
    }
    
    public boolean isEdge(Node node){
        for(int i = 0; i < edges.length; i++){
            if(edges[i] == node.getIndex()){
                return true;
            }else if(edges[i] == 0){
                return false;
            }
        }
        return false;
    }
}
