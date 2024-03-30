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
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.*;

public class TripleAxleBogeyRenderer {
    public static class MediumTripleAxisBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, MEDIUM_SHARED_WHEELS, 3);
            createModelInstance(materialManager, MEDIUM_TRIPLE_WHEEL_FRAME);
            createModelInstance(materialManager, AllBlocks.SHAFT.getDefaultState()
                    .setValue(ShaftBlock.AXIS, Direction.Axis.Z), 2);
        }

        @Override
        public BogeySizes.BogeySize getSize() {
            return ExtendedBogeysBogeySizes.MEDIUM;
        }

        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;
            BogeyModelData[] secondaryShafts = getTransform(AllBlocks.SHAFT.getDefaultState()
                    .setValue(ShaftBlock.AXIS, Direction.Axis.Z), ms, inInstancedContraption, 2);

            for (int i : Iterate.zeroAndOne) {
                secondaryShafts[i]
                        .translate(-.5f, .31f, .5f + i * -2)
                        .centre()
                        .rotateZ(wheelAngle)
                        .unCentre()
                        .render(ms, light, vb);
            }

            getTransform(MEDIUM_TRIPLE_WHEEL_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(MEDIUM_SHARED_WHEELS, ms, inInstancedContraption, 3);
            for (int side = -1; side < 2; side++) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[side + 1];
                wheel.translate(0, 13 / 16f, side * 1.5)
                        .rotateX(wheelAngle)
                        .translate(0, -13 / 16f, 0)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }
        }
    }

    public static class LargeTripleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_6_FRAME_LONG);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, LARGE_6_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, LARGE_6_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, LARGE_6_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_LEFT_M_ROD_LONG);
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

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.09));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.09));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.09));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.09));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(LARGE_6_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 1.6875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(LARGE_6_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(LARGE_6_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(LARGE_6_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.609375)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.609375)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
        }
    }

    public static class LargeTripleAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_6_FRAME_SHORT);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, LARGE_6_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, LARGE_6_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, LARGE_6_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_LEFT_M_ROD_SHORT);
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

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.13));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.13));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.13));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.13));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(LARGE_6_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 1.6875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(LARGE_6_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(LARGE_6_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(LARGE_6_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -1.796875)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -1.796875)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
        }
    }

    public static class ExtraLargeTripleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_6_FRAME_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, EXTRA_LARGE_6_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_M_ROD_LONG);
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

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.106));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.106));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.106));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.106));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(EXTRA_LARGE_6_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side * 2.25)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(EXTRA_LARGE_6_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(EXTRA_LARGE_6_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(EXTRA_LARGE_6_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -3.4375)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -3.4375)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
        }
    }

    public static class ExtraLargeTripleAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_6_FRAME_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, EXTRA_LARGE_6_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_M_ROD_SHORT);
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

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.145));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.145));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.145));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.145));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(EXTRA_LARGE_6_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side * 2.25)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(EXTRA_LARGE_6_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(EXTRA_LARGE_6_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(EXTRA_LARGE_6_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -2.4375)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -2.4375)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
        }
    }
}
