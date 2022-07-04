package com.nuvalence.challenge.rectangles.exceptions;

import com.nuvalence.challenge.rectangles.model.NuvalencePoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class NotARectangleException extends RuntimeException{
    public NotARectangleException(List<NuvalencePoint> points){
        super("Points are not a rectangle: " + points.toString());
    }
}
