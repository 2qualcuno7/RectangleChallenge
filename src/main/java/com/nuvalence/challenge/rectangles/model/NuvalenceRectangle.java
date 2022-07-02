package com.nuvalence.challenge.rectangles.model;

import com.nuvalence.challenge.rectangles.types.AdjacencyType;

import java.awt.*;
import java.util.List;

public class NuvalenceRectangle extends NuvalencePolygon{
    @Override
    public List<Point> intersections(NuvalencePolygon polygon) {
        return null;
    }

    @Override
    public boolean contains(NuvalencePolygon polygon) {
        return false;
    }

    @Override
    public AdjacencyType adjacency(NuvalencePolygon polygon) {
        return null;
    }
}
