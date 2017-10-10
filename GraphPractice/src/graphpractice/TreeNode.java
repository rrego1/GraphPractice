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
public class TreeNode {
    private int index;
    private int [] edges;
    
    TreeNode(){
        index = 0;
        edges = new int[5];
    }
    
    TreeNode(int index){
        this.index = index;
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
    
    public void addEdge(int vertex){
        int length = edges.length;
        if(edges[length - 1] != 0){
            int[] newEdges = new int[length * 2];
            for(int i = 0; i < length; i++){
                newEdges[i] = edges[i];
            }
            newEdges[length] = vertex;
            edges = newEdges;
        }
        for(int i = 0; i < length; i++){
            if(edges[i] == 0){
                edges[i] = vertex;
                break;
            }
        }
    }
    
    public boolean isEdge(int vertex){
        for(int i = 0; i < edges.length; i++){
            if(edges[i] == vertex){
                return true;
            }else if(edges[i] == 0){
                return false;
            }
        }
        return false;
    }
}
