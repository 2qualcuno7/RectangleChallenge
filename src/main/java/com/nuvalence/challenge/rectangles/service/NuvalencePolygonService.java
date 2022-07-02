package com.nuvalence.challenge.rectangles.service;

import com.nuvalence.challenge.rectangles.model.NuvalencePolygon;
import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class NuvalencePolygonService {
    public List<Point> intersections(Point[] pointsFirstPoly, Point[] pointsSecondPoly){
        return new ArrayList<>();
    };

    public boolean contains(Point[] pointsFirstPoly, Point[] pointsSecondPoly){
        return false;
    };

    public AdjacencyType adjacency(Point[] pointsFirstPoly, Point[] pointsSecondPoly){
        return AdjacencyType.NOT_ADJACENT;
    };

    private NuvalencePolygon getShape(Point[] points){
        return null;
    }

}
