package com.nuvalence.challenge.rectangles.model;

import lombok.Data;

import java.awt.*;

@Data
public class NuvalenceLineSegment {
    private Point start;
    private Point end;

    public Point intersection(NuvalenceLineSegment otherLine){
        return null;
    }

    public boolean isSubsegment(NuvalenceLineSegment otherLine){
        return false;
    }
}
