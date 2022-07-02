package com.nuvalence.challenge.rectangles.services;

import com.nuvalence.challenge.rectangles.model.NuvalencePolygon;
import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

@Service
public class NuvalencePolygonService {
    public List<Point> intersections(Point2D.Double[] pointsFirstPoly, Point2D.Double[] pointsSecondPoly){
        return new ArrayList<>();
    };

    public boolean contains(Point2D.Double[] pointsFirstPoly, Point2D.Double[] pointsSecondPoly){
        return false;
    };

    public AdjacencyType adjacency(Point2D.Double[] pointsFirstPoly, Point2D.Double[] pointsSecondPoly){
        return AdjacencyType.NOT_ADJACENT;
    };

    private NuvalencePolygon getShape(Point2D.Double[] points){
        return null;
    }

}
