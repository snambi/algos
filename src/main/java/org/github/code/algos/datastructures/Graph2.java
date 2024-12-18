package org.github.code.algos.datastructures;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


public class Graph2 {

    private Map<Integer,Node> allnodes = new HashMap<>();

    public void addNode(int v){
        Node node = new Node();
        node.setValue(v);

        allnodes.put(v, node);
    }

    public void addEdge(int begin, int end ){
        Node src = allnodes.get(begin);
        Node dest = allnodes.get(end);

        src.getNodes().add(dest);
    }

    public boolean hasPathDFS(int begin, int end){
        Set<Integer> visited = new HashSet<>();
        return hasPathDFSinternal(begin, end, visited);
    }

    private boolean hasPathDFSinternal( int begin, int end, Set<Integer> visited ){
        Node src = allnodes.get(begin);

        boolean result = false;

        // check whether it is visited
        if( !visited.contains(begin)){

            visited.add(begin);

            // check whether the downstream nodes
            for( Node c : src.getNodes() ){
                if( c.getValue() == end ){
                    result = true;
                    break;
                }
            }

            // continue if not found
            for( Node c: src.getNodes()){

                if( hasPathDFSinternal(c.getValue(), end, visited) ){
                    result = true;
                    break;
                }
            }
        }

        return result;
    }


    @Data
    @NoArgsConstructor
    private class Node{
        private int value;
        List<Node> nodes = new ArrayList<>();
    }

    public static void main(String[] args ){

        Graph2 g = new Graph2();

        g.addNode(5);
        g.addNode(4);
        g.addNode(6);
        g.addNode(1);
        g.addNode(8);


        g.addEdge(4,5);
        g.addEdge(4,1);
        g.addEdge(1,8);
        g.addEdge(1,4);
        g.addEdge(6,1);

        System.out.println( "Has path 1 -> 8 "+ g.hasPathDFS(1,8));
        System.out.println( "Has path 8 -> 4 "+ g.hasPathDFS(8,4));
        System.out.println( "Has path 4 -> 8 "+ g.hasPathDFS(4,8));
    }
}
