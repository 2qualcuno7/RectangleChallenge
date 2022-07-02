package com.nuvalence.challenge.rectangles.model;

import lombok.Data;

import java.awt.*;

@Data
public abstract class NuvalencePolygon implements NuvalencePolygonInterface{
    Point[] points;
    NuvalenceLineSegment[] lineSegments;
}
