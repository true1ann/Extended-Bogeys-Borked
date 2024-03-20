package com.rabbitminers.extendedbogeys.registry;

import com.jozufozu.flywheel.core.PartialModel;
import com.rabbitminers.extendedbogeys.ExtendedBogeys;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.trains.bogey.StandardBogeyRenderer;

import java.util.EnumMap;
import java.util.Map;

public class ExtendedBogeysPartials {
    public static final PartialModel

    MEDIUM_SHARED_WHEELS = block("bogey/medium/shared/wheels"),

    MEDIUM_STANDARD_FRAME = block("bogey/medium/standard/frame"),
    MEDIUM_SINGLE_WHEEL_FRAME = block("bogey/medium/single_wheel/frame"),
    MEDIUM_TRIPLE_WHEEL_FRAME = block("bogey/medium/triple_wheel/frame"),
    MEDIUM_QUADRUPLE_WHEEL_FRAME = block("bogey/medium/quadruple_wheel/frame"),
    MEDIUM_QUINTUPLE_WHEEL_FRAME = block("bogey/medium/quintuple_wheel/frame"),

    MEDIUM_2_0_2_TRAILING_FRAME = block("bogey/medium/2-0-2_trailing/frame"),
    MEDIUM_4_0_4_TRAILING_FRAME = block("bogey/medium/4-0-4_trailing/frame"),
    MEDIUM_6_0_6_TRAILING_FRAME = block("bogey/medium/6-0-6_trailing/frame"),
    MEDIUM_6_0_6_TENDER_FRAME = block("bogey/medium/6-0-6_tender/frame"),
    MEDIUM_8_0_8_TENDER_FRAME = block("bogey/medium/8-0-8_tender/frame"),
    MEDIUM_10_0_10_TENDER_FRAME = block("bogey/medium/10-0-10_tender/frame")
    ;

    private static PartialModel block(String path) {
        return new PartialModel(ExtendedBogeys.asResource("block/" + path));
    }

    private static PartialModel entity(String path) {
        return new PartialModel(ExtendedBogeys.asResource("entity/" + path));
    }



    public static void init() {

    }
}
