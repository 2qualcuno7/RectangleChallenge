package com.nuvalence.challenge.rectangles.model;

import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import lombok.Builder;
import lombok.Data;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

import static java.util.Optional.*;

@Data
@Builder
public class NuvalenceRectangle extends NuvalencePolygon {
    private List<NuvalencePoint> points;
    private List<NuvalenceLineSegment> lineSegments;

    public static Optional<NuvalenceRectangle> getInstance(List<NuvalencePoint> points) {
        if(points.size() != 4)
            return empty();

        //Check for non repeating points
        Set<NuvalencePoint> set = new HashSet<>();
        for (NuvalencePoint point: points){
            if (!set.add(point))
                return empty();
        }

        //Create all possible segments
        List<NuvalenceLineSegment> allPossibleEdges = new ArrayList<NuvalenceLineSegment>();
        for(int i=0; i<points.size()-1; i++){
            for (int j=i+1; j<points.size(); j++){
                allPossibleEdges.add(
                    NuvalenceLineSegment.builder()
                        .start(
                            NuvalencePoint.builder()
                                .x(points.get(i).getX())
                                .y(points.get(i).getY())
                                .build()
                        )
                        .end(
                            NuvalencePoint.builder()
                                .x(points.get(j).getX())
                                .y(points.get(j).getY())
                                .build()
                        )
                        .build()
                );
            }
        }

        //Find correct line segments, if any
        List<NuvalenceLineSegment> parallelAndSameSizeEdges = new ArrayList<NuvalenceLineSegment>();
        for(int i=0; i<allPossibleEdges.size()-1; i++){
            Optional<NuvalenceLineSegment> optionalPair = Optional.empty();
            for(int j=i+1; j<allPossibleEdges.size(); j++){
                if(allPossibleEdges.get(i).isParallelNotSameLine(allPossibleEdges.get(j))){
                    optionalPair = Optional.of(allPossibleEdges.get(j));
                }
            }

            if(optionalPair.isPresent()) {
                try {
                    parallelAndSameSizeEdges.add(allPossibleEdges.get(i));
                    parallelAndSameSizeEdges.add(optionalPair.get());
                } catch (Exception e){}
            }
        }

        //Guard clause, prevents non four sided figures
        if(parallelAndSameSizeEdges.size() != 4)
            return empty();

        //90° Angles
        for(int i=0; i<parallelAndSameSizeEdges.size(); i++){
            int count = 0;
            for(int j=0; j<parallelAndSameSizeEdges.size(); j++){
                if(parallelAndSameSizeEdges.get(i).isPerpendicular(parallelAndSameSizeEdges.get(j))){
                    count++;
                }
            }
            if(count != 2) {
                return Optional.empty();
            }
        }


        return of(
            NuvalenceRectangle.builder()
                .points(points)
                .lineSegments(parallelAndSameSizeEdges)
                .build()
        );
    }


    @Override
    public List<NuvalencePoint> intersections(NuvalencePolygon otherFigure) {
        return super.intersections(otherFigure);
    }

    public boolean contains(NuvalencePolygon polygon) {
        return false;
    }

    public AdjacencyType adjacency(NuvalencePolygon polygon) {
        return null;
    }
}
