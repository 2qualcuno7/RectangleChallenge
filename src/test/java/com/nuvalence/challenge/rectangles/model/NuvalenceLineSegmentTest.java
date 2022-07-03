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

    //Y intercepts
    @Test
    void positiveIntercept(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                new NuvalencePoint(-4.0, 0.0),
                new NuvalencePoint(6.0, 5.0)
        );

        Optional<Double> optionalRealValue = line.yIntercept();

        assertEquals(optionalRealValue.get(), 2.0, 0.000001);
    }

    @Test
    void negativeIntercept(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                new NuvalencePoint(-2.0, -4.0),
                new NuvalencePoint(10.0, 1.0)
        );

        Optional<Double> optionalRealValue = line.yIntercept();

        assertEquals(optionalRealValue.get(), -3.166666666, 0.000001);
    }

    @Test
    void noIntercept(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                new NuvalencePoint(8.0, -5.0),
                new NuvalencePoint(8.0, 3.0)
        );

        Optional<Double> optionalRealValue = line.yIntercept();

        assertEquals(optionalRealValue, Optional.empty());
    }

    @Test
    void parallelToX(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                new NuvalencePoint(14.0, 2.0),
                new NuvalencePoint(0.0, 2.0)
        );

        Optional<Double> optionalRealValue = line.yIntercept();

        assertEquals(optionalRealValue.get(), 2.0, 0.0);
    }

    //Interceptions
    @Test
    void randomSlopes(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                new NuvalencePoint(3.0, 4.2),
                new NuvalencePoint(4.5, -1.6)
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                new NuvalencePoint(-7.1, 9.0),
                new NuvalencePoint(0.6, 0.0)
        );

        Optional<NuvalencePoint> optionalRealValue = lineOne.intersection(lineTwo);
        Double expectedValueX = 5.59659820282;
        Double expectedValueY = -5.84017971759;

        assertEquals(expectedValueX, optionalRealValue.get().getX(), 0.000001);
        assertEquals(expectedValueY, optionalRealValue.get().getY(), 0.000001);
    }

    @Test
    void sameLine(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                new NuvalencePoint(1.0, 0.4),
                new NuvalencePoint(6.0, 3.9)
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                new NuvalencePoint(-2.0, -1.7),
                new NuvalencePoint(0.0, -0.3)
        );

        Optional<NuvalencePoint> optionalRealValue = lineOne.intersection(lineTwo);

        assertEquals(optionalRealValue, Optional.empty());
    }

    @Test
    void parallelLines(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                new NuvalencePoint(0.0, 4.0),
                new NuvalencePoint(-3.0, -2.0)
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                new NuvalencePoint(1.0, 1.0),
                new NuvalencePoint(-5.0, -11.0)
        );

        Optional<NuvalencePoint> optionalRealValue = lineOne.intersection(lineTwo);

        assertEquals(optionalRealValue, Optional.empty());
    }

    @Test
    void oneVerticalTwoRandom(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                new NuvalencePoint(2.5, 3.1),
                new NuvalencePoint(2.5, -1.9)
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                new NuvalencePoint(3.2, 0.0),
                new NuvalencePoint(1.5, 9.8)
        );

        Optional<NuvalencePoint> optionalRealValue = lineOne.intersection(lineTwo);

        Double expectedValueX = 2.5;
        Double expectedValueY = 4.03529411765;

        assertEquals(expectedValueX, optionalRealValue.get().getX(), 0.000001);
        assertEquals(expectedValueY, optionalRealValue.get().getY(), 0.000001);
    }

    @Test
    void oneRandomTwoVertical(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                new NuvalencePoint(-1.3, 4.1),
                new NuvalencePoint(1.8, -3.0)
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                new NuvalencePoint(1.7, 9.0),
                new NuvalencePoint(1.7, -7.0)
        );

        Optional<NuvalencePoint> optionalRealValue = lineOne.intersection(lineTwo);

        Double expectedValueX = 1.7;
        Double expectedValueY = -2.77096774194;

        assertEquals(expectedValueX, optionalRealValue.get().getX(), 0.000001);
        assertEquals(expectedValueY, optionalRealValue.get().getY(), 0.000001);
    }

    @Test
    void oneHorizontalTwoRandom(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                new NuvalencePoint(3.9, 0.0),
                new NuvalencePoint(0.2, 0.0)
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                new NuvalencePoint(7.9, 4.1),
                new NuvalencePoint(-0.8, 3.4)
        );

        Optional<NuvalencePoint> optionalRealValue = lineOne.intersection(lineTwo);

        Double expectedValueX = -43.0571428571;
        Double expectedValueY = 0.0;

        assertEquals(expectedValueX, optionalRealValue.get().getX(), 0.000001);
        assertEquals(expectedValueY, optionalRealValue.get().getY(), 0.000001);
    }

    @Test
    void oneRandomTwoHorizontal(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                new NuvalencePoint(9.8, 0.2),
                new NuvalencePoint(1.4, 5.3)
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                new NuvalencePoint(8.0, 3.6),
                new NuvalencePoint(-1.7, 3.6)
        );

        Optional<NuvalencePoint> optionalRealValue = lineOne.intersection(lineTwo);

        Double expectedValueX = 4.2;
        Double expectedValueY = 3.6;

        assertEquals(expectedValueX, optionalRealValue.get().getX(), 0.000001);
        assertEquals(expectedValueY, optionalRealValue.get().getY(), 0.000001);
    }

    //Point part of segment
    @Test
    void part(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
            NuvalencePoint.builder().x(3.1).y(-200.97).build(),
            NuvalencePoint.builder().x(-0.97).y(74.569).build()
        );

        NuvalencePoint point = NuvalencePoint.builder().x(1.2).y(-72.34).build();

        assertEquals(true, line.isPartOfSegment(point));
    }

    @Test
    void notPart(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(7.56).y(1.3).build(),
                NuvalencePoint.builder().x(-43.8).y(8.9).build()
        );

        NuvalencePoint point = NuvalencePoint.builder().x(3.41).y(5.9).build();

        assertEquals(false, line.isPartOfSegment(point));
    }

    @Test
    void sameLineNotPart(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(1.4).y(5.752).build(),
                NuvalencePoint.builder().x(3.3).y(130.734).build()
        );

        NuvalencePoint point = NuvalencePoint.builder().x(7.6).y(413.588).build();

        assertEquals(false, line.isPartOfSegment(point));
    }

    @Test
    void edge(){
        NuvalenceLineSegment line = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(-89.7).y(67.9).build(),
                NuvalencePoint.builder().x(0.0).y(98.7).build()
        );

        NuvalencePoint point = NuvalencePoint.builder().x(0.0).y(98.7).build();

        assertEquals(true, line.isPartOfSegment(point));
    }

    //Adjacency, same line
    @Test
    void isSameSegment(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(1.3).y(7.5).build(),
                NuvalencePoint.builder().x(6.0).y(0.8).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(1.3).y(7.5).build(),
                NuvalencePoint.builder().x(6.0).y(0.8).build()
        );

        assertEquals(true, lineOne.isSameSegment(lineTwo));
    }

    @Test
    void sameLineNotSameSegment(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(0.0).y(5.3).build(),
                NuvalencePoint.builder().x(0.0).y(4.2).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(0.0).y(5.31).build(),
                NuvalencePoint.builder().x(0.0).y(7.3).build()
        );

        assertEquals(false, lineOne.isSameSegment(lineTwo));
    }

    //Subsegment
    @Test
    void isSubsegment(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(2.8).y(7.8).build(),
                NuvalencePoint.builder().x(2.8).y(9.7).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(2.8).y(7.0).build(),
                NuvalencePoint.builder().x(2.8).y(10.0).build()
        );

        assertEquals(true, lineOne.isSubsegment(lineTwo));
    }

    @Test
    void notSubsegment(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(5.6).y(4.9).build(),
                NuvalencePoint.builder().x(5.6).y(-0.1).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(5.7).y(7.0).build(),
                NuvalencePoint.builder().x(2.8).y(7.0).build()
        );

        assertEquals(false, lineOne.isSubsegment(lineTwo));
    }

    @Test
    void sameLineNotSubsegment(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(-0.9).y(7.9).build(),
                NuvalencePoint.builder().x(-0.9).y(0.0).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(-0.9).y(-0.1).build(),
                NuvalencePoint.builder().x(-0.9).y(-0.2).build()
        );

        assertEquals(false, lineOne.isSubsegment(lineTwo));
    }

    @Test
    void sameLineOverlapsNotSubsegment(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(-0.9).y(7.9).build(),
                NuvalencePoint.builder().x(-0.9).y(0.0).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(-0.9).y(1.5).build(),
                NuvalencePoint.builder().x(-0.9).y(-0.2).build()
        );

        assertEquals(false, lineOne.isSubsegment(lineTwo));
    }

    //Overlap
    @Test
    void overlapOne(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(-0.9).y(7.9).build(),
                NuvalencePoint.builder().x(-0.9).y(0.0).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(-0.9).y(1.5).build(),
                NuvalencePoint.builder().x(-0.9).y(-0.2).build()
        );

        assertEquals(true, lineOne.overlap(lineTwo));
    }

    @Test
    void overlapTwo(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(8.9).y(0.0).build(),
                NuvalencePoint.builder().x(-32.7).y(0.0).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(0.8).y(0.0).build(),
                NuvalencePoint.builder().x(-8.0).y(0.0).build()
        );

        assertEquals(true, lineOne.overlap(lineTwo));
    }

    @Test
    void overlapThree(){
        NuvalenceLineSegment lineOne = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(7.9).y(-525.93).build(),
                NuvalencePoint.builder().x(-16.3).y(1112.41).build()
        );

        NuvalenceLineSegment lineTwo = new NuvalenceLineSegment(
                NuvalencePoint.builder().x(7.0).y(-465.0).build(),
                NuvalencePoint.builder().x(-21.9).y(1491.53).build()
        );

        assertEquals(true, lineOne.overlap(lineTwo));
    }


}
