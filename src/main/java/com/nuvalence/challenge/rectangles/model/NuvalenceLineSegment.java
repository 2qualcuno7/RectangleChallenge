package com.nuvalence.challenge.rectangles.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

import static java.lang.Math.*;


@Data
@AllArgsConstructor
@Builder
public class NuvalenceLineSegment {
    private NuvalencePoint start;
    private NuvalencePoint end;

    public Double findSlope(){
        return (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
    }

    public Optional<Double> yIntercept(){
        Double slope = this.findSlope();
        if(slope.equals(0.0))
            return Optional.of(this.start.getY());
        if(slope.isInfinite())
            return Optional.empty();

        return Optional.of(this.start.getY() - (this.start.getX() * slope));
    }

    public Optional<NuvalencePoint> intersection(NuvalenceLineSegment otherLine){
        Double slopeOne = this.findSlope();
        Double slopeTwo = otherLine.findSlope();
        Optional<Double> yInterceptOne = this.yIntercept();
        Optional<Double> yInterceptTwo = otherLine.yIntercept();

        if (slopeOne.equals(slopeTwo))
            return Optional.empty();

        if(yInterceptOne.isEmpty())
            return Optional.of(new NuvalencePoint(this.start.getX(), otherLine.findSlope() * this.start.getX()+otherLine.yIntercept().get()));

        if(yInterceptTwo.isEmpty())
            return Optional.of(new NuvalencePoint(otherLine.start.getX(), this.findSlope() * otherLine.start.getX()+this.yIntercept().get()));

        Double x = (yInterceptTwo.get() - yInterceptOne.get()) / (slopeOne - slopeTwo);
        Double y = slopeOne * x + yInterceptOne.get();

        return Optional.of(new NuvalencePoint(x,y));
    }


    public Boolean isPartOfSegment(NuvalencePoint point){
        if(this.start.equals(point) || this.end.equals(point))
            return true;

        NuvalenceLineSegment testLine = NuvalenceLineSegment.builder()
                .start(NuvalencePoint.builder().x(point.getX()).y(point.getY()).build())
                .end(NuvalencePoint.builder().x(this.end.getX()).y(this.end.getY()).build())
                .build();

        if (this.hasSameFormula(testLine) && min(this.start.getX(), this.end.getX()) <= point.getX()
            && max(this.start.getX(), this.end.getX()) >= point.getX()
            && min(this.start.getY(), this.end.getY()) <= point.getY()
            && max(this.start.getY(), this.end.getY()) >= point.getY())
            return true;

        return false;
    }

    public Boolean hasSameFormula(NuvalenceLineSegment otherLine){
        if((this.yIntercept().isEmpty() && otherLine.yIntercept().isEmpty()))
            return (Math.abs(otherLine.findSlope() - this.findSlope()) < 0.000001)
                    || otherLine.findSlope().equals(this.findSlope());

        if(this.yIntercept().isPresent() && otherLine.yIntercept().isPresent())
            return  ((Math.abs(otherLine.findSlope() - this.findSlope()) < 0.000001) || otherLine.findSlope().equals(this.findSlope()))
                    &&
                    ((Math.abs(otherLine.yIntercept().get() - this.yIntercept().get()) < 0.000001) || otherLine.yIntercept().get().equals(this.yIntercept().get()));

        return false;
    }

    public Boolean isSameSegment(NuvalenceLineSegment otherLine){
        return this.equals(otherLine);
    }

    public Boolean isSubsegment(NuvalenceLineSegment otherLine){
        return this.hasSameFormula(otherLine) &&
                ((this.isPartOfSegment(otherLine.start) && this.isPartOfSegment(otherLine.end))
                || (otherLine.isPartOfSegment(this.start) && otherLine.isPartOfSegment(this.end)));

    }

    public Boolean overlap(NuvalenceLineSegment otherLine){
        return this.hasSameFormula(otherLine)
                && (this.isPartOfSegment(otherLine.start) || this.isPartOfSegment(otherLine.end));
    }

    public Double length(){
        return sqrt(pow((this.end.getX() - this.start.getX()), 2) + pow((this.end.getY() - this.start.getY()),2));
    }
}
