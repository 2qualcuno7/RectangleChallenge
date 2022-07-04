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
