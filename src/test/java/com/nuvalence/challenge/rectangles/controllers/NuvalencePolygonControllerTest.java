package com.nuvalence.challenge.rectangles.controllers;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NuvalencePolygonControllerTest {
    NuvalencePolygonController controller = new NuvalencePolygonController();

    @Test
    void intersectionTestNoIntersection(){
        Point2D.Double[] firstShape = {
                new Point2D.Double(1, 2),
                new Point2D.Double(1, 3),
                new Point2D.Double(2, 2),
                new Point2D.Double(4, 5)
        };

        Point2D.Double[] secondShape = {
                new Point2D.Double(1, 2),
                new Point2D.Double(1, 3),
                new Point2D.Double(2, 2),
                new Point2D.Double(4, 5)
        };



        List<Point> actualResult = controller.intersections(firstShape, secondShape);
        List<Point> expectedResult = new ArrayList<Point>();

        assertEquals(actualResult, expectedResult);
    }
}
