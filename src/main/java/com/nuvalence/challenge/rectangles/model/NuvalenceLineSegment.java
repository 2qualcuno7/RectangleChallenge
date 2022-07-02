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
        if(slope.isInfinite())
            return Optional.empty();

        return Optional.of(this.start.y - (this.start.x * slope));
    }

    public Optional<NuvalencePoint> intersection(NuvalenceLineSegment otherLine){
        Double slopeOne = this.findSlope();
        Double slopeTwo = otherLine.findSlope();
        Optional<Double> yInterceptOne = this.yIntercept();
        Optional<Double> yInterceptTwo = otherLine.yIntercept();

        if (slopeOne.equals(slopeTwo))
            return Optional.empty();

        if(yInterceptOne.isEmpty())
            return Optional.of(new NuvalencePoint(this.start.x, otherLine.findSlope() * this.start.x+otherLine.yIntercept().get()));

        if(yInterceptTwo.isEmpty())
            return Optional.of(new NuvalencePoint(otherLine.start.x, this.findSlope() * otherLine.start.x+this.yIntercept().get()));

        Double x = (yInterceptTwo.get() - yInterceptOne.get()) / (slopeOne - slopeTwo);
        Double y = slopeOne * x + yInterceptOne.get();

        return Optional.of(new NuvalencePoint(x,y));
    }

    public Boolean hasSameFormula(NuvalenceLineSegment otherLine){
        return this.findSlope().equals(otherLine.findSlope()) && this.yIntercept().equals(otherLine.yIntercept());
    }

    public boolean isSubsegment(NuvalenceLineSegment otherLine){
        return false;
    }
}
