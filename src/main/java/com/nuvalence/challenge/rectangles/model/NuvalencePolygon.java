package com.nuvalence.challenge.rectangles.model;

import lombok.Data;

import java.awt.*;
import java.awt.geom.Point2D;

@Data
public abstract class NuvalencePolygon implements NuvalencePolygonInterface{
    Point2D.Double[] points;
    NuvalenceLineSegment[] lineSegments;
}
