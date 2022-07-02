package com.nuvalence.challenge.rectangles.model;

import lombok.Data;

import java.awt.*;
import java.awt.geom.Point2D;

@Data
public class NuvalenceLineSegment {
    private Point2D.Double start;
    private Point2D.Double end;

    public Point2D.Double intersection(NuvalenceLineSegment otherLine){
        return null;
    }

    public boolean isSubsegment(NuvalenceLineSegment otherLine){
        return false;
    }
}
