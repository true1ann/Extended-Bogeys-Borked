package com.rabbitminers.extendedbogeys.bogeys.styles;

import com.jozufozu.flywheel.api.MaterialManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rabbitminers.extendedbogeys.bogeys.renderers.ExtendedBogeysBogeyRenderer;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import com.simibubi.create.foundation.utility.Iterate;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.*;

public class SextupleBogeyRenderer {
    //Large 0-12-0 (long)
    public static class LargeSextupleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_12_FRAME_LONG);
            createModelInstance(materialManager, LARGE_12_WHEELS, 2);
            createModelInstance(materialManager, LARGE_12_WHEELS_BLIND, 2);
            createModelInstance(materialManager, LARGE_12_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, LARGE_12_CENTER_WEIGHT);
            createModelInstance(materialManager, LARGE_12_CENTER_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_CENTER_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_RIGHT_C_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_LEFT_C_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_LEFT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_CENTER_SHAFT, 2);

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
            double wheelAngleLeft = Math.toRadians(wheelAngle + 225);
            double wheelAngleCenter = Math.toRadians(wheelAngle + 135);

            double wheelAngleRight180 = Math.toRadians(-wheelAngle);
            double wheelAngleLeft180 = Math.toRadians(-wheelAngle + 225);
            double wheelAngleCenter180 = Math.toRadians(-wheelAngle + 135);

            double RightRodOffset = 1 / 4f * Math.sin(wheelAngleRight);
            double LeftRodOffset = 1 / 4f * Math.sin(wheelAngleLeft);
            double CenterRodOffset = 1 / 4f * Math.sin(wheelAngleCenter);

            double RightRodOffset180 = 1 / 4f * Math.sin(wheelAngleRight180);
            double LeftRodOffset180 = 1 / 4f * Math.sin(wheelAngleLeft180);
            double CenterRodOffset180 = 1 / 4f * Math.sin(wheelAngleCenter180);

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.05));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.05));
            double CenterMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleCenter) * 0.08));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.05));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.05));
            double CenterMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleCenter180) * 0.08));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(LARGE_12_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels1 = getTransform(LARGE_12_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 4.375)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(LARGE_12_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 2.625)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels3 = getTransform(LARGE_12_WHEELS_BLIND, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel3 = wheels3[(side + 1) / 2];
                wheel3.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] shafts = getTransform(LARGE_12_CENTER_SHAFT, ms, inInstancedContraption, 2);

            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData shaft = shafts[(side + 1) / 2];
                shaft.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, -2.625 + side * 1.75)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_12_CENTER_WEIGHT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.625)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(LARGE_12_RIGHT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(0.875)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(0.875)
                    .rotateX(forwards ? wheelAngle + 225 : -wheelAngle + 225)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 225 : wheelAngle - 225)
                    .translateY(1)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(LARGE_12_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,0,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,0,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(LARGE_12_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -5.8125)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -5.8125)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Center Rods
            getTransform(LARGE_12_CENTER_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(6.75)
                    .translate(0,-0.6875,0)
                    .translateZ(forwards ? CenterRodOffset : CenterRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_CENTER_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.375, -5.75)
                    .rotateX(6.75)
                    .rotateX(forwards ? CenterMainRodRotateX : CenterMainRodRotateX180)
                    .translateZ(forwards ? CenterRodOffset : CenterRodOffset180)
                    .render(ms, light, vb);
        }
    }
//Large 0-12-0 (Short)
    public static class LargeSextupleAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_12_FRAME_SHORT);
            createModelInstance(materialManager, LARGE_12_WHEELS, 2);
            createModelInstance(materialManager, LARGE_12_WHEELS_BLIND, 2);
            createModelInstance(materialManager, LARGE_12_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, LARGE_12_CENTER_WEIGHT);
            createModelInstance(materialManager, LARGE_12_CENTER_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_CENTER_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_RIGHT_C_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_LEFT_C_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_LEFT_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_CENTER_SHAFT, 2);

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
            double wheelAngleLeft = Math.toRadians(wheelAngle + 225);
            double wheelAngleCenter = Math.toRadians(wheelAngle + 135);

            double wheelAngleRight180 = Math.toRadians(-wheelAngle);
            double wheelAngleLeft180 = Math.toRadians(-wheelAngle + 225);
            double wheelAngleCenter180 = Math.toRadians(-wheelAngle + 135);

            double RightRodOffset = 1 / 4f * Math.sin(wheelAngleRight);
            double LeftRodOffset = 1 / 4f * Math.sin(wheelAngleLeft);
            double CenterRodOffset = 1 / 4f * Math.sin(wheelAngleCenter);

            double RightRodOffset180 = 1 / 4f * Math.sin(wheelAngleRight180);
            double LeftRodOffset180 = 1 / 4f * Math.sin(wheelAngleLeft180);
            double CenterRodOffset180 = 1 / 4f * Math.sin(wheelAngleCenter180);

            double RightMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleRight) * 0.05));
            double LeftMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleLeft) * 0.05));
            double CenterMainRodRotateX = Math.toDegrees(Math.sin(-Math.cos(wheelAngleCenter) * 0.08));

            double RightMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleRight180) * 0.05));
            double LeftMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleLeft180) * 0.05));
            double CenterMainRodRotateX180 = Math.toDegrees(Math.sin(-Math.cos(-wheelAngleCenter180) * 0.08));
//______________________________________________________________________________________________________________________
            //Frame
            getTransform(LARGE_12_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Driver Wheels
            BogeyModelData[] wheels1 = getTransform(LARGE_12_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 4.375)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(LARGE_12_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 2.625)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels3 = getTransform(LARGE_12_WHEELS_BLIND, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel3 = wheels3[(side + 1) / 2];
                wheel3.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] shafts = getTransform(LARGE_12_CENTER_SHAFT, ms, inInstancedContraption, 2);

            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData shaft = shafts[(side + 1) / 2];
                shaft.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, -3.5 + side * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_12_CENTER_WEIGHT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -0.875)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Connecting Rods
            getTransform(LARGE_12_RIGHT_C_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_C_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 225 : -wheelAngle + 225)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 225 : wheelAngle - 225)
                    .translateY(1)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Piston Rods
            getTransform(LARGE_12_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,0,0)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,0,0)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Main Rods
            getTransform(LARGE_12_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -4.8125)
                    .rotateX(forwards ? RightMainRodRotateX : RightMainRodRotateX180)
                    .translateZ(forwards ? RightRodOffset : RightRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -4.8125)
                    .rotateX(forwards ? LeftMainRodRotateX : LeftMainRodRotateX180)
                    .translateZ(forwards ? LeftRodOffset : LeftRodOffset180)
                    .render(ms, light, vb);
//----------------------------------------------------------------------------------------------------------------------
            //Center Rods
            getTransform(LARGE_12_CENTER_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, -0.0625, -0.1875)
                    .rotateX(5.75)
                    .translateZ(forwards ? CenterRodOffset : CenterRodOffset180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_CENTER_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.375, -4.8125)
                    .rotateX(5.75)
                    .rotateX(forwards ? CenterMainRodRotateX : CenterMainRodRotateX180)
                    .translateZ(forwards ? CenterRodOffset : CenterRodOffset180)
                    .render(ms, light, vb);
        }
    }
}
