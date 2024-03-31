package com.rabbitminers.extendedbogeys.registry;

import com.jozufozu.flywheel.core.PartialModel;
import com.rabbitminers.extendedbogeys.ExtendedBogeys;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.trains.bogey.StandardBogeyRenderer;

import java.util.EnumMap;
import java.util.Map;

public class ExtendedBogeysPartials {
    public static final PartialModel
//Standard Wheels
    SMALL_SHARED_WHEELS = block("bogey/small/shared/wheels"),
    SMALL_SHARED_WHEELS_PINS = block("bogey/small/shared/wheels_pins"),
    MEDIUM_SHARED_WHEELS = block("bogey/medium/shared/wheels"),
    LARGE_SHARED_WHEELS = block("bogey/large/shared/wheels"),
    LARGE_SHARED_WHEELS_SEMI_BLIND = block("bogey/large/shared/wheels_semi_blind"),
    LARGE_SHARED_WHEELS_BLIND = block("bogey/large/shared/wheels_blind"),
    EXTRA_LARGE_SHARED_WHEELS = block("bogey/extra_large/shared/wheels"),
    EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND = block("bogey/extra_large/shared/wheels_semi_blind"),

//Scotch Yoke Wheels
    CREATE_LARGE_SHARED_WHEELS = block("bogey/large/shared/wheels_create"),
    CREATE_LARGE_SHARED_WHEELS_SEMI_BLIND = block("bogey/large/shared/wheels_semi_blind_create"),
    CREATE_LARGE_SHARED_WHEELS_BLIND = block("bogey/large/shared/wheels_blind_create"),
    CREATE_EXTRA_LARGE_SHARED_WHEELS = block("bogey/extra_large/shared/wheels_create"),
    CREATE_EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND = block("bogey/extra_large/shared/wheels_semi_blind_create"),

//Medium Stuff...
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
    MEDIUM_10_0_10_TENDER_FRAME = block("bogey/medium/10-0-10_tender/frame"),

//Small Stuff...
    SMALL_STANDARD_6_FRAME = block("bogey/small/s6/frame"),
    SMALL_STANDARD_8_FRAME = block("bogey/small/s8/frame"),
    SMALL_STANDARD_10_FRAME = block("bogey/small/s10/frame"),

    SMALL_TRAILING_2_FRAME = block("bogey/small/t2/frame"),
    SMALL_TRAILING_4_FRAME = block("bogey/small/t4/frame"),
    SMALL_TRAILING_6_FRAME = block("bogey/small/t6/frame"),

//Large 0-4-0 Long
    LARGE_4_FRAME_LONG = block("bogey/large/l4/l4_long/frame"),
    LARGE_4_LEFT_C_ROD_LONG = block("bogey/large/l4/l4_long/left_c_rod"),
    LARGE_4_RIGHT_C_ROD_LONG = block("bogey/large/l4/l4_long/right_c_rod"),
    LARGE_4_LEFT_M_ROD_LONG = block("bogey/large/l4/l4_long/left_m_rod"),
    LARGE_4_RIGHT_M_ROD_LONG = block("bogey/large/l4/l4_long/right_m_rod"),
    LARGE_4_LEFT_P_ROD_LONG = block("bogey/large/l4/l4_long/left_p_rod"),
    LARGE_4_RIGHT_P_ROD_LONG = block("bogey/large/l4/l4_long/right_p_rod"),

//Large 0-4-0 Short
    LARGE_4_FRAME_SHORT = block("bogey/large/l4/l4_short/frame"),
    LARGE_4_LEFT_C_ROD_SHORT = block("bogey/large/l4/l4_short/left_c_rod"),
    LARGE_4_RIGHT_C_ROD_SHORT = block("bogey/large/l4/l4_short/right_c_rod"),
    LARGE_4_LEFT_M_ROD_SHORT = block("bogey/large/l4/l4_short/left_m_rod"),
    LARGE_4_RIGHT_M_ROD_SHORT = block("bogey/large/l4/l4_short/right_m_rod"),
    LARGE_4_LEFT_P_ROD_SHORT = block("bogey/large/l4/l4_short/left_p_rod"),
    LARGE_4_RIGHT_P_ROD_SHORT = block("bogey/large/l4/l4_short/right_p_rod"),

//Large 0-6-0 Long
    LARGE_6_FRAME_LONG = block("bogey/large/l6/l6_long/frame"),
    LARGE_6_LEFT_M_ROD_LONG = block("bogey/large/l6/l6_long/left_m_rod"),
    LARGE_6_RIGHT_M_ROD_LONG = block("bogey/large/l6/l6_long/right_m_rod"),
    LARGE_6_LEFT_P_ROD_LONG = block("bogey/large/l6/l6_long/left_p_rod"),
    LARGE_6_RIGHT_P_ROD_LONG = block("bogey/large/l6/l6_long/right_p_rod"),

//Large 0-6-0 Connecting Rods
    LARGE_6_SHARED_LEFT_C_ROD = block("bogey/large/l6/l6_shared/left_c_rod"),
    LARGE_6_SHARED_RIGHT_C_ROD = block("bogey/large/l6/l6_shared/right_c_rod"),

//Large 0-6-0 Short
    LARGE_6_FRAME_SHORT = block("bogey/large/l6/l6_short/frame"),
    LARGE_6_LEFT_M_ROD_SHORT = block("bogey/large/l6/l6_short/left_m_rod"),
    LARGE_6_RIGHT_M_ROD_SHORT = block("bogey/large/l6/l6_short/right_m_rod"),
    LARGE_6_LEFT_P_ROD_SHORT = block("bogey/large/l6/l6_short/left_p_rod"),
    LARGE_6_RIGHT_P_ROD_SHORT = block("bogey/large/l6/l6_short/right_p_rod"),

//Large 0-8-0 Long
    LARGE_8_FRAME_LONG = block("bogey/large/l8/l8_long/frame"),
    LARGE_8_LEFT_C_ROD_LONG = block("bogey/large/l8/l8_long/left_c_rod"),
    LARGE_8_RIGHT_C_ROD_LONG = block("bogey/large/l8/l8_long/right_c_rod"),
    LARGE_8_LEFT_M_ROD_LONG = block("bogey/large/l8/l8_long/left_m_rod"),
    LARGE_8_RIGHT_M_ROD_LONG = block("bogey/large/l8/l8_long/right_m_rod"),
    LARGE_8_LEFT_P_ROD_LONG = block("bogey/large/l8/l8_long/left_p_rod"),
    LARGE_8_RIGHT_P_ROD_LONG = block("bogey/large/l8/l8_long/right_p_rod"),

//Large 0-8-0 Short
    LARGE_8_FRAME_SHORT = block("bogey/large/l8/l8_short/frame"),
    LARGE_8_LEFT_C_ROD_SHORT = block("bogey/large/l8/l8_short/left_c_rod"),
    LARGE_8_RIGHT_C_ROD_SHORT = block("bogey/large/l8/l8_short/right_c_rod"),
    LARGE_8_LEFT_M_ROD_SHORT = block("bogey/large/l8/l8_short/left_m_rod"),
    LARGE_8_RIGHT_M_ROD_SHORT = block("bogey/large/l8/l8_short/right_m_rod"),
    LARGE_8_LEFT_P_ROD_SHORT = block("bogey/large/l8/l8_short/left_p_rod"),
    LARGE_8_RIGHT_P_ROD_SHORT = block("bogey/large/l8/l8_short/right_p_rod"),

//Large 0-10-0 Long
    LARGE_10_FRAME_LONG = block("bogey/large/l10/l10_long/frame"),
    LARGE_10_LEFT_C_ROD_LONG = block("bogey/large/l10/l10_long/left_c_rod"),
    LARGE_10_RIGHT_C_ROD_LONG = block("bogey/large/l10/l10_long/right_c_rod"),
    LARGE_10_LEFT_M_ROD_LONG = block("bogey/large/l10/l10_long/left_m_rod"),
    LARGE_10_RIGHT_M_ROD_LONG = block("bogey/large/l10/l10_long/right_m_rod"),
    LARGE_10_LEFT_P_ROD_LONG = block("bogey/large/l10/l10_long/left_p_rod"),
    LARGE_10_RIGHT_P_ROD_LONG = block("bogey/large/l10/l10_long/right_p_rod"),

//Large 0-10-0 Short
    LARGE_10_FRAME_SHORT = block("bogey/large/l10/l10_short/frame"),
    LARGE_10_LEFT_C_ROD_SHORT = block("bogey/large/l10/l10_short/left_c_rod"),
    LARGE_10_RIGHT_C_ROD_SHORT = block("bogey/large/l10/l10_short/right_c_rod"),
    LARGE_10_LEFT_M_ROD_SHORT = block("bogey/large/l10/l10_short/left_m_rod"),
    LARGE_10_RIGHT_M_ROD_SHORT = block("bogey/large/l10/l10_short/right_m_rod"),
    LARGE_10_LEFT_P_ROD_SHORT = block("bogey/large/l10/l10_short/left_p_rod"),
    LARGE_10_RIGHT_P_ROD_SHORT = block("bogey/large/l10/l10_short/right_p_rod"),

//Extra Large 0-4-0 Long
    EXTRA_LARGE_4_FRAME_LONG = block("bogey/extra_large/xl4/xl4_long/frame"),
    EXTRA_LARGE_4_LEFT_M_ROD_LONG = block("bogey/extra_large/xl4/xl4_long/left_m_rod"),
    EXTRA_LARGE_4_RIGHT_M_ROD_LONG = block("bogey/extra_large/xl4/xl4_long/right_m_rod"),
    EXTRA_LARGE_4_LEFT_P_ROD_LONG = block("bogey/extra_large/xl4/xl4_long/left_p_rod"),
    EXTRA_LARGE_4_RIGHT_P_ROD_LONG = block("bogey/extra_large/xl4/xl4_long/right_p_rod"),

//Extra Large 0-4-0 Connecting Rods
    EXTRA_LARGE_4_SHARED_LEFT_C_ROD = block("bogey/extra_large/xl4/xl4_shared/left_c_rod"),
    EXTRA_LARGE_4_SHARED_RIGHT_C_ROD = block("bogey/extra_large/xl4/xl4_shared/right_c_rod"),

//Extra Large 0-4-0 Short
    EXTRA_LARGE_4_FRAME_SHORT = block("bogey/extra_large/xl4/xl4_short/frame"),
    EXTRA_LARGE_4_LEFT_M_ROD_SHORT = block("bogey/extra_large/xl4/xl4_short/left_m_rod"),
    EXTRA_LARGE_4_RIGHT_M_ROD_SHORT = block("bogey/extra_large/xl4/xl4_short/right_m_rod"),
    EXTRA_LARGE_4_LEFT_P_ROD_SHORT = block("bogey/extra_large/xl4/xl4_short/left_p_rod"),
    EXTRA_LARGE_4_RIGHT_P_ROD_SHORT = block("bogey/extra_large/xl4/xl4_short/right_p_rod"),

//Extra Large 0-6-0 Long
    EXTRA_LARGE_6_FRAME_LONG = block("bogey/extra_large/xl6/xl6_long/frame"),
    EXTRA_LARGE_6_LEFT_M_ROD_LONG = block("bogey/extra_large/xl6/xl6_long/left_m_rod"),
    EXTRA_LARGE_6_RIGHT_M_ROD_LONG = block("bogey/extra_large/xl6/xl6_long/right_m_rod"),
    EXTRA_LARGE_6_LEFT_P_ROD_LONG = block("bogey/extra_large/xl6/xl6_long/left_p_rod"),
    EXTRA_LARGE_6_RIGHT_P_ROD_LONG = block("bogey/extra_large/xl6/xl6_long/right_p_rod"),

//Extra Large 0-6-0 Connecting Rods
    EXTRA_LARGE_6_SHARED_LEFT_C_ROD = block("bogey/extra_large/xl6/xl6_shared/left_c_rod"),
    EXTRA_LARGE_6_SHARED_RIGHT_C_ROD = block("bogey/extra_large/xl6/xl6_shared/right_c_rod"),

//Extra Large 0-6-0 Short
    EXTRA_LARGE_6_FRAME_SHORT = block("bogey/extra_large/xl6/xl6_short/frame"),
    EXTRA_LARGE_6_LEFT_M_ROD_SHORT = block("bogey/extra_large/xl6/xl6_short/left_m_rod"),
    EXTRA_LARGE_6_RIGHT_M_ROD_SHORT = block("bogey/extra_large/xl6/xl6_short/right_m_rod"),
    EXTRA_LARGE_6_LEFT_P_ROD_SHORT = block("bogey/extra_large/xl6/xl6_short/left_p_rod"),
    EXTRA_LARGE_6_RIGHT_P_ROD_SHORT = block("bogey/extra_large/xl6/xl6_short/right_p_rod"),

//Extra Large 0-8-0 Long
    EXTRA_LARGE_8_FRAME_LONG = block("bogey/extra_large/xl8/xl8_long/frame"),
    EXTRA_LARGE_8_LEFT_C_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/left_c_rod"),
    EXTRA_LARGE_8_RIGHT_C_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/right_c_rod"),
    EXTRA_LARGE_8_LEFT_M_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/left_m_rod"),
    EXTRA_LARGE_8_RIGHT_M_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/right_m_rod"),
    EXTRA_LARGE_8_LEFT_P_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/left_p_rod"),
    EXTRA_LARGE_8_RIGHT_P_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/right_p_rod"),

//Extra Large 0-8-0 Short
    EXTRA_LARGE_8_FRAME_SHORT = block("bogey/extra_large/xl8/xl8_short/frame"),
    EXTRA_LARGE_8_LEFT_C_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/left_c_rod"),
    EXTRA_LARGE_8_RIGHT_C_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/right_c_rod"),
    EXTRA_LARGE_8_LEFT_M_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/left_m_rod"),
    EXTRA_LARGE_8_RIGHT_M_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/right_m_rod"),
    EXTRA_LARGE_8_LEFT_P_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/left_p_rod"),
    EXTRA_LARGE_8_RIGHT_P_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/right_p_rod"),

//Large Scotch Yoke 0-4-0
    CREATE_LARGE_4_FRAME = block("bogey/large/l4_create/frame"),
    CREATE_LARGE_4_PINS_RIGHT = block("bogey/large/l4_create/right_pins"),
    CREATE_LARGE_4_PINS_LEFT = block("bogey/large/l4_create/left_pins"),
    CREATE_LARGE_4_PISTON_RIGHT = block("bogey/large/l4_create/right_piston"),
    CREATE_LARGE_4_PISTON_LEFT = block("bogey/large/l4_create/left_piston"),

//Large Scotch Yoke 0-6-0
    CREATE_LARGE_6_FRAME = block("bogey/large/l6_create/frame"),
    CREATE_LARGE_6_PINS_RIGHT = block("bogey/large/l6_create/right_pins"),
    CREATE_LARGE_6_PINS_LEFT = block("bogey/large/l6_create/left_pins"),
    CREATE_LARGE_6_PISTON_RIGHT = block("bogey/large/l6_create/right_piston"),
    CREATE_LARGE_6_PISTON_LEFT = block("bogey/large/l6_create/left_piston"),

//Large Scotch Yoke 0-8-0
    CREATE_LARGE_8_FRAME = block("bogey/large/l8_create/frame"),
    CREATE_LARGE_8_PINS_RIGHT = block("bogey/large/l8_create/right_pins"),
    CREATE_LARGE_8_PINS_LEFT = block("bogey/large/l8_create/left_pins"),
    CREATE_LARGE_8_PISTON_RIGHT = block("bogey/large/l8_create/right_piston"),
    CREATE_LARGE_8_PISTON_LEFT = block("bogey/large/l8_create/left_piston"),

//Large Scotch Yoke 0-10-0
    CREATE_LARGE_10_FRAME = block("bogey/large/l10_create/frame"),
    CREATE_LARGE_10_PINS_RIGHT = block("bogey/large/l10_create/right_pins"),
    CREATE_LARGE_10_PINS_LEFT = block("bogey/large/l10_create/left_pins"),
    CREATE_LARGE_10_PISTON_RIGHT = block("bogey/large/l10_create/right_piston"),
    CREATE_LARGE_10_PISTON_LEFT = block("bogey/large/l10_create/left_piston"),

//Extra Large Scotch Yoke 0-2-0
    CREATE_EXTRA_LARGE_2_FRAME = block("bogey/extra_large/xl2_create/frame"),
    CREATE_EXTRA_LARGE_2_PINS_RIGHT = block("bogey/extra_large/xl2_create/right_pins"),
    CREATE_EXTRA_LARGE_2_PINS_LEFT = block("bogey/extra_large/xl2_create/left_pins"),
    CREATE_EXTRA_LARGE_2_PISTON_RIGHT = block("bogey/extra_large/xl2_create/right_piston"),
    CREATE_EXTRA_LARGE_2_PISTON_LEFT = block("bogey/extra_large/xl2_create/left_piston"),

    //Extra Large Scotch Yoke 0-4-0
    CREATE_EXTRA_LARGE_4_FRAME = block("bogey/extra_large/xl4_create/frame"),
    CREATE_EXTRA_LARGE_4_PINS_RIGHT = block("bogey/extra_large/xl4_create/right_pins"),
    CREATE_EXTRA_LARGE_4_PINS_LEFT = block("bogey/extra_large/xl4_create/left_pins"),
    CREATE_EXTRA_LARGE_4_PISTON_RIGHT = block("bogey/extra_large/xl4_create/right_piston"),
    CREATE_EXTRA_LARGE_4_PISTON_LEFT = block("bogey/extra_large/xl4_create/left_piston"),

//Extra Large Scotch Yoke 0-6-0
    CREATE_EXTRA_LARGE_6_FRAME = block("bogey/extra_large/xl6_create/frame"),
    CREATE_EXTRA_LARGE_6_PINS_RIGHT = block("bogey/extra_large/xl6_create/right_pins"),
    CREATE_EXTRA_LARGE_6_PINS_LEFT = block("bogey/extra_large/xl6_create/left_pins"),
    CREATE_EXTRA_LARGE_6_PISTON_RIGHT = block("bogey/extra_large/xl6_create/right_piston"),
    CREATE_EXTRA_LARGE_6_PISTON_LEFT = block("bogey/extra_large/xl6_create/left_piston"),

    //Extra Large Scotch Yoke 0-8-0
    CREATE_EXTRA_LARGE_8_FRAME = block("bogey/extra_large/xl8_create/frame"),
    CREATE_EXTRA_LARGE_8_PINS_RIGHT = block("bogey/extra_large/xl8_create/right_pins"),
    CREATE_EXTRA_LARGE_8_PINS_LEFT = block("bogey/extra_large/xl8_create/left_pins"),
    CREATE_EXTRA_LARGE_8_PISTON_RIGHT = block("bogey/extra_large/xl8_create/right_piston"),
    CREATE_EXTRA_LARGE_8_PISTON_LEFT = block("bogey/extra_large/xl8_create/left_piston")
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
