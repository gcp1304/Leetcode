package com.chandra.common;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}
