package com.nuvalence.challenge.rectangles.model;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NuvalenceLineSegmentTest {

    //Slope
    @Test
    void positiveSlope(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
            new NuvalencePoint(1.0, 2.0),
            new NuvalencePoint(4.0, 37.0)
        );

        Double realValue = line.findSlope();

        assertEquals(realValue, 11.66666666, 0.000001);
    }

    @Test
    void negativeSlope(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                new NuvalencePoint(-23.0, 6.0),
                new NuvalencePoint(0.0, -8.0)
        );

        Double realValue = line.findSlope();

        assertEquals(realValue, -0.60869565217391, 0.000001);
    }

    @Test
    void zeroSlope(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                new NuvalencePoint(3.0, 2.0),
                new NuvalencePoint(-15.0, 2.0)
        );

        Double realValue = line.findSlope();

        assertEquals(realValue, 0.0, 0.0);
    }

    @Test
    void infiniteSlope(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                new NuvalencePoint(1.0, 4.0),
                new NuvalencePoint(1.0, 5.0)
        );

        Double realValue = line.findSlope();

        assertEquals(realValue, Double.POSITIVE_INFINITY);
    }
}
