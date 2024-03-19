package ca.ravelo.dta.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    private Map<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String v) {
        if (adjList.get(v) == null) {
            adjList.put(v, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String v1, String v2) {
        if (adjList.get(v1) != null && adjList.get(v2) != null) {
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String v1, String v2) {
        if (adjList.get(v1) != null && adjList.get(v2) != null) {
            adjList.get(v1).remove(v2);
            adjList.get(v2).remove(v1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String v1) {
        if (adjList.get(v1) == null) return false;
        for (String v2 : adjList.remove(v1)) {
            adjList.get(v2).remove(v1);
        }
        return true;
    }

}
