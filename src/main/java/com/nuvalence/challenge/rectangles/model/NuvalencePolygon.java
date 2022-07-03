package com.nuvalence.challenge.rectangles.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Data
public abstract class NuvalencePolygon implements NuvalencePolygonInterface{
    List<NuvalencePoint> points;
    List<NuvalenceLineSegment> lineSegments;

    public List<NuvalencePoint> intersections(NuvalencePolygon otherFigure) {
        List<NuvalencePoint> intersections = new ArrayList<>();

        for(NuvalenceLineSegment figureOneLine : this.getLineSegments()){
            for (NuvalenceLineSegment otherFigureLine : otherFigure.getLineSegments()){
                Optional<NuvalencePoint> optionalNuvalencePoint = figureOneLine.intersection(otherFigureLine);
                if(optionalNuvalencePoint.isPresent())
                    try {
                        if(figureOneLine.isPartOfSegment(optionalNuvalencePoint.get())
                                && otherFigureLine.isPartOfSegment(optionalNuvalencePoint.get())
                                && !intersections.contains(optionalNuvalencePoint.get()))
                            intersections.add(optionalNuvalencePoint.get());
                    } catch (Exception e){}
            }
        }

        return intersections;
    }
}
