package com.rabbitminers.extendedbogeys.bogeys.styles;

import com.jozufozu.flywheel.api.MaterialManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.simibubi.create.content.trains.bogey.BogeyRenderer;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import net.minecraft.nbt.CompoundTag;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.*;

public class SingleAxisTrailingRenderer {
    public static class SmallSingleAxisTrailingRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, SMALL_SHARED_WHEELS);
            createModelInstance(materialManager, SMALL_TRAILING_2_FRAME);
        }

        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.SMALL;
        }

        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(SMALL_TRAILING_2_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            getTransform(SMALL_SHARED_WHEELS, ms, inInstancedContraption)
                    .translate(0, 0.75, 0)
                    .rotateX(wheelAngle)
                    .render(ms, light, vb);
        }
    }
}
