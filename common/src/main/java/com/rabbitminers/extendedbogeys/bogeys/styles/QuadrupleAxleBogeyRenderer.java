package com.rabbitminers.extendedbogeys.bogeys.styles;

import com.jozufozu.flywheel.api.MaterialManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rabbitminers.extendedbogeys.bogeys.renderers.ExtendedBogeysBogeyRenderer;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBogeySizes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import com.simibubi.create.content.trains.bogey.BogeyRenderer;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import com.simibubi.create.foundation.utility.AngleHelper;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.*;

public class QuadrupleAxleBogeyRenderer {
//Small 0-8-0 Standard
    public static class SmallQuadrupleAxleBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, SMALL_SHARED_WHEELS_PINS, 4);
            createModelInstance(materialManager, SMALL_STANDARD_8_FRAME);
        }

        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.SMALL;
        }

        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(SMALL_STANDARD_8_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(SMALL_SHARED_WHEELS_PINS, ms, inInstancedContraption, 4);
            for (int side = -1; side < 3; side++) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[side + 1];
                wheel.translate(0, 0.75, -0.5 +  side)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }
        }
    }
//Large 0-8-0 (long)
    public static class LargeQuadrupleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_8_FRAME_LONG);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, LARGE_8_RIGHT_C_ROD_LONG);
            createModelInstance(materialManager, LARGE_8_LEFT_C_ROD_LONG);
            createModelInstance(materialManager, LARGE_8_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_8_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_8_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_8_LEFT_M_ROD_LONG);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;
//______________________________________________________________________________________________________________________
            //Variables
            double wheelAngleRight = Math.toRadians(wheelAngle);
            double wheelAngleLeft = Math.toRadians(wheelAngle + 90);

            double wheelAngleRight180 = Math.toRadians(-wheelAngle);
            double wheelAngleLeft180 = Math.toRadians(-wheelAngle + 90);

            double RightRodOffset = 1 / 4f * Math.sin(wheelAngleRight);
            double LeftRodOffset = 1 / 4f * Math.sin(wheelAngleLeft);

            double RightRodOffset180 = 1 / 4f * Math.sin(wheelAngleRight180);
            double LeftRodOffset180 = 1 / 4f * Math.sin(wheelAngleLeft180);

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.08));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.08));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.08));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.08));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(LARGE_8_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels1 = getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side1 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side1 + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side1 * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side2 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side2 + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side2 * 2.625)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(LARGE_8_RIGHT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_8_LEFT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(LARGE_8_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_8_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(LARGE_8_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -3.8125)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_8_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -3.8125)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
        }
    }
//Large 0-8-0 (short)
    public static class LargeQuadrupleAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_8_FRAME_SHORT);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, LARGE_8_RIGHT_C_ROD_SHORT);
            createModelInstance(materialManager, LARGE_8_LEFT_C_ROD_SHORT);
            createModelInstance(materialManager, LARGE_8_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_8_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_8_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_8_LEFT_M_ROD_SHORT);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;
//______________________________________________________________________________________________________________________
            //Variables
            double wheelAngleRight = Math.toRadians(wheelAngle);
            double wheelAngleLeft = Math.toRadians(wheelAngle + 90);

            double wheelAngleRight180 = Math.toRadians(-wheelAngle);
            double wheelAngleLeft180 = Math.toRadians(-wheelAngle + 90);

            double RightRodOffset = 1 / 4f * Math.sin(wheelAngleRight);
            double LeftRodOffset = 1 / 4f * Math.sin(wheelAngleLeft);

            double RightRodOffset180 = 1 / 4f * Math.sin(wheelAngleRight180);
            double LeftRodOffset180 = 1 / 4f * Math.sin(wheelAngleLeft180);

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.065));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.065));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.065));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.065));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(LARGE_8_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels1 = getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side1 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side1 + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side1 * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side2 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side2 + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side2 * 2.625)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(LARGE_8_RIGHT_C_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_8_LEFT_C_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(LARGE_8_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_8_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(LARGE_8_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.8125)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_8_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.8125)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
        }
    }
//Large 0-8-0 (pistonless)
    public static class LargeQuadrupleAxlePistonlessBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_8_FRAME_PISTONLESS);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, LARGE_8_RIGHT_C_ROD_PISTONLESS);
            createModelInstance(materialManager, LARGE_8_LEFT_C_ROD_PISTONLESS);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(LARGE_8_FRAME_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels1 = getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side1 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side1 + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side1 * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side2 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side2 + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side2 * 2.625)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(LARGE_8_RIGHT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_8_LEFT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);
        }
    }
//Extra Large 0-8-0 (long)
    public static class ExtraLargeQuadrupleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_8_FRAME_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, EXTRA_LARGE_8_RIGHT_C_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_8_LEFT_C_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_8_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_8_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_8_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_8_LEFT_M_ROD_LONG);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;
//______________________________________________________________________________________________________________________
            //Variables
            double wheelAngleRight = Math.toRadians(wheelAngle);
            double wheelAngleLeft = Math.toRadians(wheelAngle + 90);

            double wheelAngleRight180 = Math.toRadians(-wheelAngle);
            double wheelAngleLeft180 = Math.toRadians(-wheelAngle + 90);

            double RightRodOffset = 3 / 8f * Math.sin(wheelAngleRight);
            double LeftRodOffset = 3 / 8f * Math.sin(wheelAngleLeft);

            double RightRodOffset180 = 3 / 8f * Math.sin(wheelAngleRight180);
            double LeftRodOffset180 = 3 / 8f * Math.sin(wheelAngleLeft180);

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.107));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.107));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.107));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.107));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(EXTRA_LARGE_8_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels1 = getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side1 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side1 + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side1 * 1.125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side2 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side2 + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side2 * 3.375)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(EXTRA_LARGE_8_RIGHT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_8_LEFT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(EXTRA_LARGE_8_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_8_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(EXTRA_LARGE_8_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -4.4375)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_8_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -4.4375)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
        }
    }
//Extra Large 0-8-0 (short)
    public static class ExtraLargeQuadrupleAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_8_FRAME_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, EXTRA_LARGE_8_RIGHT_C_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_8_LEFT_C_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_8_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_8_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_8_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_8_LEFT_M_ROD_SHORT);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;
//______________________________________________________________________________________________________________________
            //Variables
            double wheelAngleRight = Math.toRadians(wheelAngle);
            double wheelAngleLeft = Math.toRadians(wheelAngle + 90);

            double wheelAngleRight180 = Math.toRadians(-wheelAngle);
            double wheelAngleLeft180 = Math.toRadians(-wheelAngle + 90);

            double RightRodOffset = 3 / 8f * Math.sin(wheelAngleRight);
            double LeftRodOffset = 3 / 8f * Math.sin(wheelAngleLeft);

            double RightRodOffset180 = 3 / 8f * Math.sin(wheelAngleRight180);
            double LeftRodOffset180 = 3 / 8f * Math.sin(wheelAngleLeft180);

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.08));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.08));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.08));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.08));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(EXTRA_LARGE_8_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels1 = getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side1 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side1 + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side1 * 1.125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side2 : Iterate.positiveAndNegative) {
                BogeyModelData wheel2 = wheels2[(side2 + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side2 * 3.375)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
            }
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(EXTRA_LARGE_8_RIGHT_C_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_8_LEFT_C_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(EXTRA_LARGE_8_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_8_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(EXTRA_LARGE_8_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -3.4375)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_8_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -3.4375)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
        }
    }
//Extra Large 0-8-0 (pistonless)
    public static class ExtraLargeQuadrupleAxlePistonlessBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_8_FRAME_PISTONLESS);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, EXTRA_LARGE_8_RIGHT_C_ROD_PISTONLESS);
            createModelInstance(materialManager, EXTRA_LARGE_8_LEFT_C_ROD_PISTONLESS);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(EXTRA_LARGE_8_FRAME_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels1 = getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side1 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side1 + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side1 * 1.125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side2 : Iterate.positiveAndNegative) {
                BogeyModelData wheel2 = wheels2[(side2 + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side2 * 3.375)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
            }
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(EXTRA_LARGE_8_RIGHT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_8_LEFT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);
        }
    }
//Extra Large 0-8-0 Scotch Yoke
    public static class ExtraLargeQuadrupleAxleBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_8_FRAME);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_8_PINS_RIGHT);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_8_PINS_LEFT);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_8_PISTON_RIGHT);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_8_PISTON_LEFT);
        }

        @Override
        public BogeySizes.BogeySize getSize() {
            return ExtendedBogeysBogeySizes.EXTRA_LARGE;
        }

        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(CREATE_EXTRA_LARGE_8_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels2 = getTransform(CREATE_EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side1 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side1 + 1) / 2];
                wheel2.translate(0, 1.25, side1 * 1.125)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels = getTransform(CREATE_EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side2 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side2 + 1) / 2];
                wheel.translate(0, 1.25, side2 * 3.375)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(CREATE_EXTRA_LARGE_8_PISTON_LEFT, ms, inInstancedContraption)
                    .translate(0, 1.25, 3 / 8f * Math.sin(AngleHelper.rad(wheelAngle)))
                    .render(ms, light, vb);

            getTransform(CREATE_EXTRA_LARGE_8_PISTON_RIGHT, ms, inInstancedContraption)
                    .translate(0, 1.25, 3 / 8f * Math.sin(AngleHelper.rad(wheelAngle + 180)))
                    .render(ms, light, vb);

            getTransform(CREATE_EXTRA_LARGE_8_PINS_LEFT, ms, inInstancedContraption)
                    .translate(0, 1.25, 0)
                    .rotateX(wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(-wheelAngle)
                    .render(ms, light, vb);

            getTransform(CREATE_EXTRA_LARGE_8_PINS_RIGHT, ms, inInstancedContraption)
                    .translate(0, 1.25, 0)
                    .rotateX(wheelAngle + 180)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(-wheelAngle - 180)
                    .render(ms, light, vb);
        }
    }
}
