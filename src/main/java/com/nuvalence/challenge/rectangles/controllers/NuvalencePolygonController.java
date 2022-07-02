package com.nuvalence.challenge.rectangles.controllers;

import com.nuvalence.challenge.rectangles.services.NuvalencePolygonService;
import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.List;

public class NuvalencePolygonController {
    @Autowired
    NuvalencePolygonService service;

    public List<Point> intersections(Point[] pointsFirstPoly, Point[] pointsSecondPoly){
        return service.intersections(pointsFirstPoly, pointsSecondPoly);
    }

    public boolean contains(Point[] pointsFirstPoly, Point[] pointsSecondPoly){
        return service.contains(pointsFirstPoly, pointsSecondPoly);
    }

    public AdjacencyType adjacency(Point[] pointsFirstPoly, Point[] pointsSecondPoly){
        return service.adjacency(pointsFirstPoly, pointsSecondPoly);
    }
}
