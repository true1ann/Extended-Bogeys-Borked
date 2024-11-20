package com.rabbitminers.extendedbogeys.bogeys.styles;

import com.jozufozu.flywheel.api.MaterialManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rabbitminers.extendedbogeys.bogeys.renderers.ExtendedBogeysBogeyRenderer;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBogeySizes;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import com.simibubi.create.foundation.utility.AngleHelper;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.*;

public class SingleAxleBogeyRenderer {
    public static class SmallSingleAxleOffsetRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, SMALL_STANDARD_2_FRAME);
            createModelInstance(materialManager, SMALL_SHARED_WHEELS_PINS);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(SMALL_STANDARD_2_FRAME, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            getTransform(SMALL_SHARED_WHEELS_PINS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 0.75, 1)
                    .rotateX(forwards ? wheelAngle: -wheelAngle)
                    .render(ms, light, vb);
        }
    }
    public static class LargeSingleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_2_FRAME_LONG);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS);
            createModelInstance(materialManager, LARGE_2_RIGHT_C_ROD_LONG);
            createModelInstance(materialManager, LARGE_2_LEFT_C_ROD_LONG);
            createModelInstance(materialManager, LARGE_2_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_2_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_2_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_2_LEFT_M_ROD_LONG);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle + 90));

            double zoffset_r = 1 / 4f * Math.sin(wheel_r);
            double zoffset_l = 1 / 4f * Math.sin(wheel_l);

            double zoffset_r180 = 1 / 4f * Math.sin(wheel_r180);
            double zoffset_l180 = 1 / 4f * Math.sin(wheel_l180);

            double xrotate_r = AngleHelper.deg(Math.sin(-Math.cos(wheel_r) * 0.12));
            double xrotate_l = AngleHelper.deg(Math.sin(-Math.cos(wheel_l) * 0.12));

            double xrotate_r180 = AngleHelper.deg(Math.sin(-Math.cos(wheel_r180) * 0.12));
            double xrotate_l180 = AngleHelper.deg(Math.sin(-Math.cos(wheel_l180) * 0.12));

            getTransform(LARGE_2_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_2_RIGHT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_2_LEFT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_2_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_2_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_2_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -1.8125)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_2_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -1.8125)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);
        }
    }
    public static class LargeSingleAxlePistonlessBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_2_FRAME_PISTONLESS);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SINGLE);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(LARGE_2_FRAME_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            getTransform(LARGE_SHARED_WHEELS_SINGLE, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeSingleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_2_FRAME_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS);
            createModelInstance(materialManager, EXTRA_LARGE_2_RIGHT_C_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_2_LEFT_C_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_2_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_2_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_2_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_2_LEFT_M_ROD_LONG);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle + 90));

            double zoffset_r = 3 / 8f * Math.sin(wheel_r);
            double zoffset_l = 3 / 8f * Math.sin(wheel_l);

            double zoffset_r180 = 3 / 8f * Math.sin(wheel_r180);
            double zoffset_l180 = 3 / 8f * Math.sin(wheel_l180);

            double xrotate_r = AngleHelper.deg(Math.sin(-Math.cos(wheel_r) * 0.143));
            double xrotate_l = AngleHelper.deg(Math.sin(-Math.cos(wheel_l) * 0.143));

            double xrotate_r180 = AngleHelper.deg(Math.sin(-Math.cos(wheel_r180) * 0.143));
            double xrotate_l180 = AngleHelper.deg(Math.sin(-Math.cos(wheel_l180) * 0.143));

            getTransform(EXTRA_LARGE_2_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_2_RIGHT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_2_LEFT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_2_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_2_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_2_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -2.4375)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_2_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -2.4375)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeSingleAxlePistonlessBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_2_FRAME_PISTONLESS);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SINGLE);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(EXTRA_LARGE_2_FRAME_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SINGLE, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);
        }
    }
}
