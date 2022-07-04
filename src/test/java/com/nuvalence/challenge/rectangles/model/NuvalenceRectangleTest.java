package com.nuvalence.challenge.rectangles.model;

import com.nuvalence.challenge.rectangles.types.AdjacencyType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NuvalenceRectangleTest {
    //Instances creation
    List<NuvalencePoint> notARectanglePoints =  new ArrayList<NuvalencePoint>(
            Arrays.asList(
              NuvalencePoint.builder().x(7d).y(8d).build(),
              NuvalencePoint.builder().x(4d).y(4d).build(),
              NuvalencePoint.builder().x(4d).y(1d).build(),
              NuvalencePoint.builder().x(1d).y(1d).build()
            ));

    List<NuvalencePoint> pOne =new ArrayList<NuvalencePoint>(
        Arrays.asList(
            NuvalencePoint.builder().x(-9d).y(7d).build(),
            NuvalencePoint.builder().x(-3d).y(7d).build(),
            NuvalencePoint.builder().x(-3d).y(4d).build(),
            NuvalencePoint.builder().x(-9d).y(4d).build()
        ));

    List<NuvalencePoint> pTwo =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(-4d).y(10d).build(),
                    NuvalencePoint.builder().x(-1d).y(7d).build(),
                    NuvalencePoint.builder().x(-7d).y(1d).build(),
                    NuvalencePoint.builder().x(-10d).y(4d).build()
            ));

    List<NuvalencePoint> pThree =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(0d).y(-2d).build(),
                    NuvalencePoint.builder().x(4d).y(-2d).build(),
                    NuvalencePoint.builder().x(4d).y(-5d).build(),
                    NuvalencePoint.builder().x(0d).y(-5d).build()
            ));

    List<NuvalencePoint> pFour =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(4d).y(-5d).build(),
                    NuvalencePoint.builder().x(6d).y(-5d).build(),
                    NuvalencePoint.builder().x(6d).y(-9d).build(),
                    NuvalencePoint.builder().x(4d).y(-9d).build()
            ));

    List<NuvalencePoint> pFive =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(-5d).y(0d).build(),
                    NuvalencePoint.builder().x(-2d).y(-3d).build(),
                    NuvalencePoint.builder().x(-7d).y(-8d).build(),
                    NuvalencePoint.builder().x(-10d).y(-5d).build()
            ));

    List<NuvalencePoint> pSix =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(-7d).y(-4d).build(),
                    NuvalencePoint.builder().x(-5d).y(-4d).build(),
                    NuvalencePoint.builder().x(-5d).y(-6d).build(),
                    NuvalencePoint.builder().x(-7d).y(-6d).build()
            ));

    List<NuvalencePoint> pSeven =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(-9d).y(6d).build(),
                    NuvalencePoint.builder().x(-3d).y(6d).build(),
                    NuvalencePoint.builder().x(-3d).y(1d).build(),
                    NuvalencePoint.builder().x(-9d).y(1d).build()
            ));

    List<NuvalencePoint> pEight =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(-7d).y(3d).build(),
                    NuvalencePoint.builder().x(-5d).y(3d).build(),
                    NuvalencePoint.builder().x(-5d).y(0d).build(),
                    NuvalencePoint.builder().x(-7d).y(0d).build()
            ));

    List<NuvalencePoint> pNine =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(1d).y(4d).build(),
                    NuvalencePoint.builder().x(4d).y(4d).build(),
                    NuvalencePoint.builder().x(4d).y(1d).build(),
                    NuvalencePoint.builder().x(1d).y(1d).build()
            ));

    List<NuvalencePoint> pTen =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(3d).y(3d).build(),
                    NuvalencePoint.builder().x(4d).y(3d).build(),
                    NuvalencePoint.builder().x(4d).y(2d).build(),
                    NuvalencePoint.builder().x(3d).y(2d).build()
            ));

    List<NuvalencePoint> pEleven =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(4d).y(3d).build(),
                    NuvalencePoint.builder().x(5d).y(3d).build(),
                    NuvalencePoint.builder().x(5d).y(2d).build(),
                    NuvalencePoint.builder().x(4d).y(2d).build()
            ));

    List<NuvalencePoint> pTwelve =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(2d).y(-1d).build(),
                    NuvalencePoint.builder().x(4d).y(-1d).build(),
                    NuvalencePoint.builder().x(4d).y(-3d).build(),
                    NuvalencePoint.builder().x(2d).y(-3d).build()
            ));

    List<NuvalencePoint> pThirteen =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(2d).y(-3d).build(),
                    NuvalencePoint.builder().x(4d).y(-3d).build(),
                    NuvalencePoint.builder().x(4d).y(-7d).build(),
                    NuvalencePoint.builder().x(2d).y(-7d).build()
            ));

    List<NuvalencePoint> pFourteen =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(-3d).y(8d).build(),
                    NuvalencePoint.builder().x(-1d).y(8d).build(),
                    NuvalencePoint.builder().x(-1d).y(3d).build(),
                    NuvalencePoint.builder().x(-3d).y(3d).build()
            ));

    List<NuvalencePoint> pFifteen =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(-9d).y(5d).build(),
                    NuvalencePoint.builder().x(-3d).y(5d).build(),
                    NuvalencePoint.builder().x(-9d).y(1d).build(),
                    NuvalencePoint.builder().x(-3d).y(1d).build()
            ));


    List<NuvalencePoint> notRectangleRandom =new ArrayList<NuvalencePoint>(
            Arrays.asList(
                    NuvalencePoint.builder().x(-2d).y(6d).build(),
                    NuvalencePoint.builder().x(0d).y(5d).build(),
                    NuvalencePoint.builder().x(6d).y(1.9d).build(),
                    NuvalencePoint.builder().x(-3d).y(0d).build()
            ));

    NuvalenceRectangle rOne =
            NuvalenceRectangle.builder()
                    .points(pOne)
                    .build();


    //Rectangle instances
    @Test
    void notARectangle(){
        assertEquals(Optional.empty(), NuvalenceRectangle.getInstance(notARectanglePoints));
    }

    //Intersection
    @Test
    void simpleIntersection(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pSeven);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pEight);

        NuvalencePoint intersectionOne = NuvalencePoint.builder()
                .x(-7d)
                .y(1d)
                .build();

        NuvalencePoint intersectionTwo = NuvalencePoint.builder()
                .x(-5d)
                .y(1d)
                .build();

        assertEquals(true, (
                rectangleA.get().intersections(rectangleB.get()).contains(intersectionOne)
                && rectangleA.get().intersections(rectangleB.get()).contains(intersectionTwo)
                )
        );
    }

    @Test
    void noIntersection(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pOne);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pFour);

        assertEquals(new ArrayList<NuvalencePoint>(), rectangleA.get().intersections(rectangleB.get()));
    }

    //Containment
    @Test
    void noContainment(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pThree);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pFour);

        assertEquals(false, rectangleA.get().contains(rectangleB.get()));
    }

    @Test
    void simpleContains(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pNine);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pTen);

        assertEquals(true,  rectangleA.get().contains(rectangleB.get()));
    }

    @Test
    void notContained(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pFourteen);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pFifteen);

        assertEquals(false,  rectangleA.get().contains(rectangleB.get()));
    }

    //Adjacency
    @Test
    void properAdjacency(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pTwelve);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pThirteen);

        assertEquals(AdjacencyType.PROPER, rectangleA.get().adjacency(rectangleB.get()));
    }

    @Test
    void subline(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pNine);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pEleven);

        assertEquals(AdjacencyType.SUB_LINE, rectangleA.get().adjacency(rectangleB.get()));
    }

    @Test
    void partial(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pFourteen);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pFifteen);

        assertEquals(AdjacencyType.PARTIAL, rectangleA.get().adjacency(rectangleB.get()));
    }

    @Test
    void sharePointNotPartial(){
        Optional<NuvalenceRectangle> rectangleA = NuvalenceRectangle.getInstance(pThree);
        Optional<NuvalenceRectangle> rectangleB = NuvalenceRectangle.getInstance(pFour);

        assertEquals(AdjacencyType.NOT_ADJACENT, rectangleA.get().adjacency(rectangleB.get()));
    }
}
