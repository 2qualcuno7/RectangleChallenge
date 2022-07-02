package com.nuvalence.challenge.rectangles.service;

import com.nuvalence.challenge.rectangles.model.NuvalencePolygon;
import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class NuvalencePolygonService {
    public List<Point> intersections(NuvalencePolygon polygonOne, NuvalencePolygon polygonTwo){
        return new ArrayList<>();
    };

    public boolean contains(NuvalencePolygon polygon){
        return false;
    };

    public AdjacencyType adjacency(NuvalencePolygon polygon){
        return AdjacencyType.NOT_ADJACENT;
    };

}
