package com.nuvalence.challenge.rectangles.controllers;

import com.nuvalence.challenge.rectangles.dto.RectanglePairDTO;
import com.nuvalence.challenge.rectangles.exceptions.NotARectangleException;
import com.nuvalence.challenge.rectangles.model.NuvalencePoint;
import com.nuvalence.challenge.rectangles.services.NuvalenceRectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RectangleRestController {
    private static final String BASE = "/rectangle";

    @Autowired
    NuvalenceRectangleService service;

    @PostMapping(BASE + "/intersection")
    public List<NuvalencePoint> rectangleIntersection(@RequestBody RectanglePairDTO dto) {
        try {
            return service.intersections(dto.getPointsRectangleOne(), dto.getPointsRectangleTwo());
        } catch (NotARectangleException e){
            throw e;
        }
    }

    @GetMapping(BASE)
    public NuvalencePoint get(){
        List<NuvalencePoint> points = new ArrayList<>();
        points.add(NuvalencePoint.builder().x(1d).y(5d).build());
        return NuvalencePoint.builder().x(1d).y(5d).build();
    }
}
