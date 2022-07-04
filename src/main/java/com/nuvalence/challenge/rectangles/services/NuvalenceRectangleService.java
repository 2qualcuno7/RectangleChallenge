package com.nuvalence.challenge.rectangles.services;

import com.nuvalence.challenge.rectangles.exceptions.NotARectangleException;
import com.nuvalence.challenge.rectangles.model.NuvalencePoint;
import com.nuvalence.challenge.rectangles.model.NuvalenceRectangle;
import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NuvalenceRectangleService {
    /**
     * Determines if two rectangles intersect, and if so, the points of intersection.
     * @param  pointsFirstPoly points of first rectangle.
     * @param  pointsSecondPoly points of second rectangle.
     * @return A list of intersections
     */
    public List<NuvalencePoint> intersections(List<NuvalencePoint> pointsFirstPoly, List<NuvalencePoint> pointsSecondPoly)
        throws NotARectangleException {

        //Create rectangles
        Optional<NuvalenceRectangle> optionalRectangleOne = NuvalenceRectangle.getInstance(pointsFirstPoly);
        if(optionalRectangleOne.isEmpty())
            throw new NotARectangleException(pointsFirstPoly);
        Optional<NuvalenceRectangle> optionalRectangleTwo = NuvalenceRectangle.getInstance(pointsSecondPoly);
        if(optionalRectangleTwo.isEmpty())
            throw new NotARectangleException(pointsSecondPoly);
        NuvalenceRectangle rectangleOne = optionalRectangleOne.get();
        NuvalenceRectangle rectangleTwo = optionalRectangleTwo.get();

        return rectangleOne.intersections(rectangleTwo);
    }

    /**
     * Determines if one rectangle is contained in another.
     * @param  pointsFirstPoly points of first rectangle.
     * @param  pointsSecondPoly points of second rectangle.
     * @return true if one is fully contained, false otherwise
     */
    public boolean contains(List<NuvalencePoint> pointsFirstPoly, List<NuvalencePoint> pointsSecondPoly)
        throws NotARectangleException{
        Optional<NuvalenceRectangle> optionalRectangleOne = NuvalenceRectangle.getInstance(pointsFirstPoly);
        if(optionalRectangleOne.isEmpty())
            throw new NotARectangleException(pointsFirstPoly);
        Optional<NuvalenceRectangle> optionalRectangleTwo = NuvalenceRectangle.getInstance(pointsSecondPoly);
        if(optionalRectangleTwo.isEmpty())
            throw new NotARectangleException(pointsSecondPoly);
        NuvalenceRectangle rectangleOne = optionalRectangleOne.get();
        NuvalenceRectangle rectangleTwo = optionalRectangleTwo.get();


        return rectangleOne.contains(rectangleTwo) || rectangleTwo.contains(rectangleOne);
    }

    /**
     * Determines the type adjacency between two rectangles.
     * @param  pointsFirstPoly points of first rectangle.
     * @param  pointsSecondPoly points of second rectangle.
     * @return the type adjacency between two rectangles
     */
    public AdjacencyType adjacency(List<NuvalencePoint> pointsFirstPoly, List<NuvalencePoint> pointsSecondPoly)
        throws NotARectangleException{
        Optional<NuvalenceRectangle> optionalRectangleOne = NuvalenceRectangle.getInstance(pointsFirstPoly);
        if(optionalRectangleOne.isEmpty())
            throw new NotARectangleException(pointsFirstPoly);
        Optional<NuvalenceRectangle> optionalRectangleTwo = NuvalenceRectangle.getInstance(pointsSecondPoly);
        if(optionalRectangleTwo.isEmpty())
            throw new NotARectangleException(pointsSecondPoly);
        NuvalenceRectangle rectangleOne = optionalRectangleOne.get();
        NuvalenceRectangle rectangleTwo = optionalRectangleTwo.get();

        return rectangleOne.adjacency(rectangleTwo);
    }

}
