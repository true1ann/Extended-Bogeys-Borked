package com.rabbitminers.extendedbogeys.bogeys.compat.steamnrails;

import com.rabbitminers.extendedbogeys.ExtendedBogeys;
import net.minecraft.resources.ResourceLocation;

import com.railwayteam.railways.api.bogeymenu.v0.BogeyMenuManager;
import com.railwayteam.railways.api.bogeymenu.v0.entry.BogeyEntry;
import com.railwayteam.railways.api.bogeymenu.v0.entry.CategoryEntry;
import com.railwayteam.railways.impl.bogeymenu.v0.BogeyMenuManagerImpl;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBogeyStyles.*;

public class MenuImpl {
    BogeyMenuManager INSTANCE = new BogeyMenuManagerImpl();

        public static final CategoryEntry SINGLE_AXLE = BogeyMenuManager.INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/singleaxles"));
        public static final CategoryEntry DOUBLE_AXLE = BogeyMenuManager.INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/doubleaxles"));
        public static final CategoryEntry TRIPLE_AXLE = BogeyMenuManager.INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/tripleaxles"));
        public static final CategoryEntry QUADRUPLE_AXLE = BogeyMenuManager.INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/quadrupleaxles"));
        public static final CategoryEntry QUINTUPLE_AXLE = BogeyMenuManager.INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/quintupleaxles"));
        public static final CategoryEntry SEXTUPLE_AXLE = BogeyMenuManager.INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/sextupleaxles"));

    public static final BogeyEntry

    //Single Axles
        SINGLE_AXLE_TRAILING = BogeyMenuManager.INSTANCE.addToCategory(SINGLE_AXLE, SINGLE_AXLE_TRAIlER,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-2-0_trailing.png")),
    //Double Axles
        AXLE_TRAILING = BogeyMenuManager.INSTANCE.addToCategory(DOUBLE_AXLE, DOUBLE_AXLE_TRAILER,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-4-0_trailing.png")),
        DOUBLE_AXLE_LONG = BogeyMenuManager.INSTANCE.addToCategory(DOUBLE_AXLE, DOUBLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png"), 17),
        DOUBLE_AXLE_SHORT = BogeyMenuManager.INSTANCE.addToCategory(DOUBLE_AXLE, DOUBLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png"), 17),
        CREATE_DOUBLE_AXLE = BogeyMenuManager.INSTANCE.addToCategory(DOUBLE_AXLE, CREATE_DOUBLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/create_style_0-4-0.png"), 17),
    //Triple Axles
        TRIPLE_AXLE_STANDARD = BogeyMenuManager.INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_triple_wheel.png")),
        TRIPLE_AXLE_TRAILING = BogeyMenuManager.INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_TRAILER,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-6-0_trailing.png")),
        TRIPLE_AXLE_LONG = BogeyMenuManager.INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        TRIPLE_AXLE_SHORT = BogeyMenuManager.INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        EXTENDED_AXLE_LONG = BogeyMenuManager.INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_EXTENDED_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        EXTENDED_AXLE_SHORT = BogeyMenuManager.INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_EXTENDED_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        CREATE_TRIPLE_AXLE = BogeyMenuManager.INSTANCE.addToCategory(TRIPLE_AXLE, CREATE_TRIPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/create_style_0-6-0.png"), 16),
    //Quadruple Axles
        QUADRUPLE_AXLE_STANDARD = BogeyMenuManager.INSTANCE.addToCategory(QUADRUPLE_AXLE, QUADRUPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_quadruple_wheel.png")),
        QUADRUPLE_AXLE_LONG = BogeyMenuManager.INSTANCE.addToCategory(QUADRUPLE_AXLE, QUADRUPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 15),
        QUADRUPLE_AXLE_SHORT = BogeyMenuManager.INSTANCE.addToCategory(QUADRUPLE_AXLE, QUADRUPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 15),
        CREATE_QUADRUPLE_AXLE = BogeyMenuManager.INSTANCE.addToCategory(QUADRUPLE_AXLE, CREATE_QUADRUPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/create_style_0-6-0.png"), 15),
    //Quintuple Axles
        QUINTUPLE_AXLE_STANDARD = BogeyMenuManager.INSTANCE.addToCategory(QUINTUPLE_AXLE, QUINTUPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_quintuple_wheel.png")),
        QUINTUPLE_AXLE_LONG = BogeyMenuManager.INSTANCE.addToCategory(QUINTUPLE_AXLE, QUINTUPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 14),
        QUINTUPLE_AXLE_SHORT = BogeyMenuManager.INSTANCE.addToCategory(QUINTUPLE_AXLE, QUINTUPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 14),
    //Sextuple Axles
        SEXTUPLE_AXLE_LONG = BogeyMenuManager.INSTANCE.addToCategory(SEXTUPLE_AXLE, SEXTUPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 13),
        SEXTUPLE_AXLE_SHORT = BogeyMenuManager.INSTANCE.addToCategory(SEXTUPLE_AXLE, SEXTUPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 13);

    public static void register() {
        ExtendedBogeys.LOGGER.info("Registered Steam N' Rails menu categories for " + ExtendedBogeys.MOD_NAME);
    }
}

