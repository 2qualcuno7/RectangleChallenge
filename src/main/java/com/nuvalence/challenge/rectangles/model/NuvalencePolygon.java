package com.nuvalence.challenge.rectangles.model;

import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Data
public abstract class NuvalencePolygon implements NuvalencePolygonInterface{
    List<NuvalencePoint> points;
    List<NuvalenceLineSegment> lineSegments;

    @Override
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

    @Override
    public boolean contains(NuvalencePolygon containedPolygon) {
        Double minX = Double.POSITIVE_INFINITY;
        Double minY = Double.POSITIVE_INFINITY;
        Double maxX = Double.NEGATIVE_INFINITY;
        Double maxY = Double.NEGATIVE_INFINITY;

        for(NuvalenceLineSegment line : this.getLineSegments()){
            //On starts
            if(line.getStart().getX() < minX)
                minX = line.getStart().getX();
            if(line.getStart().getX() > maxX)
                maxX = line.getStart().getX();
            if(line.getStart().getY() < minY)
                minY = line.getStart().getY();
            if(line.getStart().getY() > maxY)
                maxY = line.getStart().getY();

            //On ends
            if(line.getEnd().getX() < minX)
                minX = line.getEnd().getX();
            if(line.getEnd().getX() > maxX)
                maxX = line.getEnd().getX();
            if(line.getEnd().getY() < minY)
                minY = line.getEnd().getY();
            if(line.getEnd().getY() > maxY)
                maxY = line.getEnd().getY();
        }

        maxX+=0.000001d;
        maxY+=0.000001d;
        minX-=0.000001d;
        minY-=0.000001d;

        for(NuvalencePoint point : containedPolygon.getPoints()){
            NuvalenceLineSegment upLine = NuvalenceLineSegment.builder()
                .start(NuvalencePoint.builder().x(point.getX()).y(point.getY()).build())
                .end(NuvalencePoint.builder().x(point.getX()).y(maxY).build())
                .build();

            NuvalenceLineSegment downLine = NuvalenceLineSegment.builder()
                .start(NuvalencePoint.builder().x(point.getX()).y(point.getY()).build())
                .end(NuvalencePoint.builder().x(point.getX()).y(minY).build())
                .build();

            NuvalenceLineSegment rightLine = NuvalenceLineSegment.builder()
                .start(NuvalencePoint.builder().x(point.getX()).y(point.getY()).build())
                .end(NuvalencePoint.builder().x(maxX).y(point.getY()).build())
                .build();

            NuvalenceLineSegment leftLine = NuvalenceLineSegment.builder()
                .start(NuvalencePoint.builder().x(point.getX()).y(point.getY()).build())
                .end(NuvalencePoint.builder().x(minX).y(point.getY()).build())
                .build();


            int countUp = 0;
            int countDown = 0;
            int countRight = 0;
            int countLeft = 0;

            List<NuvalencePoint> foundIntercepts = new ArrayList<>();

            //Counts intersections
            for(NuvalenceLineSegment line : this.getLineSegments()) {
                Optional<NuvalencePoint> optionalUpIntersection = upLine.intersection(line);
                if (optionalUpIntersection.isPresent()) {
                    if (upLine.isPartOfSegment(optionalUpIntersection.get())
                        && !foundIntercepts.contains(optionalUpIntersection.get())
                        && !line.isPartOfSegment(point)
                    ) {
                        countUp++;
                        foundIntercepts.add(optionalUpIntersection.get());
                    }
                }

                Optional<NuvalencePoint> optionalDownIntersection = downLine.intersection(line);
                if (optionalDownIntersection.isPresent()) {
                    if (downLine.isPartOfSegment(optionalDownIntersection.get())
                        && !foundIntercepts.contains(optionalDownIntersection.get())
                        && !line.isPartOfSegment(point)
                    ) {
                        countDown++;
                        foundIntercepts.add(optionalDownIntersection.get());
                    }
                }

                Optional<NuvalencePoint> optionalRightIntersection = rightLine.intersection(line);
                if (optionalRightIntersection.isPresent()) {
                    if (rightLine.isPartOfSegment(optionalRightIntersection.get())
                        && !foundIntercepts.contains(optionalRightIntersection.get())
                        && !line.isPartOfSegment(point)
                    ) {
                        countRight++;
                        foundIntercepts.add(optionalRightIntersection.get());
                    }
                }

                Optional<NuvalencePoint> optionalLeftIntersection = leftLine.intersection(line);
                if (optionalLeftIntersection.isPresent()) {

                    if (leftLine.isPartOfSegment(optionalLeftIntersection.get())
                        && !foundIntercepts.contains(optionalLeftIntersection.get())
                        && !line.isPartOfSegment(point)
                    ) {
                        countLeft++;
                        foundIntercepts.add(optionalLeftIntersection.get());
                    }
                }
            }

            if((countUp%2 == 0 && countUp > 0)
                || (countDown%2 == 0 && countDown>0)
                || (countRight%2 == 0 && countRight>0)
                || (countLeft%2 == 0 && countLeft>0))
                return false;

        }

        return true;
    }

    @Override
    public AdjacencyType adjacency(NuvalencePolygon polygon){
        if(this.contains(polygon) || polygon.contains(this))
            return AdjacencyType.NOT_ADJACENT;

        for(NuvalenceLineSegment lineOne : this.getLineSegments()){
            for(NuvalenceLineSegment lineTwo : polygon.getLineSegments()){
                if(lineOne.hasSameFormula(lineTwo)) {
                    if (
                        (lineOne.getStart().equals(lineTwo.getStart()) || lineOne.getStart().equals(lineTwo.getEnd()))
                        && (lineOne.getEnd().equals(lineTwo.getEnd()) || lineOne.getEnd().equals(lineTwo.getStart()))
                    )
                        return AdjacencyType.PROPER;

                    if (
                        (lineOne.isPartOfSegment(lineTwo.getStart()) && lineOne.isPartOfSegment(lineTwo.getEnd()))
                        || (lineTwo.isPartOfSegment(lineOne.getStart()) && lineTwo.isPartOfSegment(lineOne.getEnd()))
                    )
                        return AdjacencyType.SUB_LINE;
                }
            }
        }

        return AdjacencyType.NOT_ADJACENT;
    }
}
