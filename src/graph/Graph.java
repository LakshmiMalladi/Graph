/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author KriLak
 */
import java.util.LinkedList;
import java.util.Scanner;

class Graph {

    LinkedList<Integer> arr[];
    int arrsz;
    
    Graph(int sz)
    {
        this.arrsz = sz;

        arr = new LinkedList[arrsz];
        
        for(int i=0;i<arrsz;i++)
        {
            arr[i] = new LinkedList<>();
        }
    }
        
    //TO ADD AN EDGE BETWEEN TWO VERTICES IF NO EDGE EXISTS
    void addEdge(Graph g, int v1, int v2)
    {
        try
        {
            if(!g.arr[v1].contains(v2))
            {
                g.arr[v1].addLast(v2);
                g.arr[v2].addLast(v1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Graph error or vertices error!!");
        }
    }
    
    //TO PRINT THE GRAPH
    void printGraph(Graph g)
    {  
        try
        {
            for(int i=0;i<g.arr.length;i++)
            {
                System.out.println("Vertices adjacent to " + i +" : ");
                for(Integer j:g.arr[i])
                    System.out.print(j +" ");
                System.out.println();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Graph doesn't exist!!");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Graph g ;
        int count=1, to=0, from=0,size=0,edges=0;
        
        Scanner sc = new Scanner(System.in);
        
        try
        {
            g = new Graph(size);
            System.out.println("Enter the number of vertices:  ");
            size = sc.nextInt();
            System.out.println("Enter the number of edges:  ");
            edges = sc.nextInt();
                
            System.out.println("Enter the edges: to then from : ");
            while (count <= edges) 
            {
                to = sc.nextInt();
                from = sc.nextInt();
 
                g.addEdge(g,to, from);
                count++;
            }
            
            g.printGraph(g);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Graph doesn't exist or addEdge() method error!!");
        }
    }
    
}
