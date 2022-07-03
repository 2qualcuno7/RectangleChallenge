package com.nuvalence.challenge.rectangles.model;

import lombok.Data;

import java.util.List;


@Data
public abstract class NuvalencePolygon implements NuvalencePolygonInterface{
    List<NuvalencePoint> points;
    List<NuvalenceLineSegment> lineSegments;
}
