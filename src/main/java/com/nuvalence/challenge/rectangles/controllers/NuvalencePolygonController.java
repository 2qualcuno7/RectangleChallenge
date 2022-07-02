package com.nuvalence.challenge.rectangles.controllers;

import com.nuvalence.challenge.rectangles.services.NuvalencePolygonService;
import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class NuvalencePolygonController {
    NuvalencePolygonService service = new NuvalencePolygonService();

    public List<Point> intersections(Point2D.Double[] pointsFirstPoly, Point2D.Double[] pointsSecondPoly){
        return service.intersections(pointsFirstPoly, pointsSecondPoly);
    }

    public boolean contains(Point2D.Double[] pointsFirstPoly, Point2D.Double[] pointsSecondPoly){
        return service.contains(pointsFirstPoly, pointsSecondPoly);
    }

    public AdjacencyType adjacency(Point2D.Double[] pointsFirstPoly, Point2D.Double[] pointsSecondPoly){
        return service.adjacency(pointsFirstPoly, pointsSecondPoly);
    }
}
