package com.nuvalence.challenge.rectangles.model;

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
    NuvalenceRectangle rOne =
            NuvalenceRectangle.builder()
                    .points(pOne)
                    .build();


    //Rectangle instances
    @Test
    void notARectangle(){
        assertEquals(Optional.empty(), NuvalenceRectangle.getInstance(notARectanglePoints));
    }

    @Test
    void RectangleOne(){
        Optional<NuvalenceRectangle> optionalNuvalenceRectangle = NuvalenceRectangle.getInstance(pOne);
        System.out.println(optionalNuvalenceRectangle);

    }
}
