package com.nuvalence.challenge.rectangles.model;


import com.nuvalence.challenge.rectangles.types.AdjacencyType;

import java.awt.*;
import java.util.List;

public interface NuvalencePolygonInterface {
    public List<Point> intersections(NuvalencePolygon polygon);
    public boolean contains(NuvalencePolygon polygon);
    public AdjacencyType adjacency(NuvalencePolygon polygon);
}
