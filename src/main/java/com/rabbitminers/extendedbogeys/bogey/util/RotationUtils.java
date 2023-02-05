package com.rabbitminers.extendedbogeys.bogey.util;

import net.minecraft.core.Direction;

public class RotationUtils {
    public static boolean isDirectionPosotive(Direction direction) {
        return switch (direction) {
            case NORTH, EAST, UP -> true;
            case SOUTH, DOWN, WEST -> false;
        };
    }
}
