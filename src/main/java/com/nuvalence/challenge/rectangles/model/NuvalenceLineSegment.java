package com.nuvalence.challenge.rectangles.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Optional;

@Data
@AllArgsConstructor
public class NuvalenceLineSegment {
    private NuvalencePoint start;
    private NuvalencePoint end;

    public Double findSlope(){
        return (this.end.y - this.start.y) / (this.end.x - this.start.x);
    }

    public Optional<Double> yIntercept(){
        Double slope = this.findSlope();
        if(slope.equals(0.0))
            return Optional.of(this.start.y);
        if(slope.equals(Double.POSITIVE_INFINITY))
            return Optional.empty();

        return Optional.of(this.start.y - (this.start.x * slope));
    }

    public Optional<Point2D.Double> intersection(NuvalenceLineSegment otherLine){
        return null;
    }

    public boolean isSubsegment(NuvalenceLineSegment otherLine){
        return false;
    }
}
