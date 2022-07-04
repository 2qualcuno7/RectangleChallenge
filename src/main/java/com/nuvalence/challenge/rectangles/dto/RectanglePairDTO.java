package com.nuvalence.challenge.rectangles.dto;

import com.nuvalence.challenge.rectangles.model.NuvalencePoint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class RectanglePairDTO {
    @NonNull
    private List<NuvalencePoint> pointsRectangleOne;
    @NonNull
    private List<NuvalencePoint> pointsRectangleTwo;
}
