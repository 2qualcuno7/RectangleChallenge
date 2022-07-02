package com.nuvalence.challenge.rectangles.model;


import com.nuvalence.challenge.rectangles.types.AdjacencyType;

import java.awt.*;
import java.util.List;

public interface NuvalencePolygon {
    public List<Point> intersections();
    public boolean contains();
    public AdjacencyType adjacency();
}
