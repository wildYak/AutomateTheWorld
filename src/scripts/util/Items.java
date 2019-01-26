package scripts.util;

import java.util.*;

public class Items
{
    //QUEST OBJECTS
    //LUMBRIDGE CASTLE
    public static final Integer LUMBY_CASTLE_BASEMENT_LADDER = 17385;
    public static final Integer LUMBY_CASTLE_KITCHEN_TRAPDOOR = 17385;
    public static final Integer LUMBY_CASTLE_GROUND_STAIRS = 16671;
    public static final Integer LUMBY_CASTLE_LEVEL1_STAIRS = 16672;
    public static final Integer LUMBY_CASTLE_LEVEL2_SPINNINGWHEEL = 14889;

    //MILL
    public static final Integer MILL_GROUND_FLOURBIN = 1781;
    public static final Integer MILL_GROUND_LADDER = 12964;
    public static final Integer MILL_LEVEL1_LADDER = 12965;
    public static final Integer MILL_LEVEL2_LADDER = 12966;
    public static final Integer MILL_LEVEL3_HOPPER = 24961;
    public static final Integer MILL_LEVEL3_HOPPERCONTROLS = 24964;
    public static final Integer FLOUR_BIN = 1781;

    //FARMS
    public static final Integer DAIRY_COW = 8689;

    public static final String[] whitelistedItems ={"Cowhide"};
    public static final List whiteListedItemsList= Arrays.asList(whitelistedItems);

    // offensive
    public static final Integer BRONZE_SWORD = 1205;
    public static final Integer BRONZE_AXE   = 1351;
    public static final Integer BRONZE_PICK  = 1265;
    public static final Integer BRONZE_SCIMITAR = 1321;

    // Defencive
    public static final Integer WOODEN_SHIELD = 1171;

    // Rings

    // Necklaces

    // Boots

    // Gloves

    // Interactive Items
    public static final Integer RIMMINGTON_SCIMITAR_STAIRCASE_DOWNSTAIRS = 18991;
    public static final Integer RIMMINGTON_SCIMITAR_STAIRCASE_UPSTAIRS = 18992;

    // MISC
    public static final String COW_HIDE      = "Cowhide";

    // Complex structures
    public static final Set<Integer>  EQUIPABLE_OFFENSIVE_ITEMS  = new HashSet<>(Arrays.asList(
            BRONZE_SWORD,
            BRONZE_AXE,
            BRONZE_PICK
    ));

    public static final Set<Integer> EQUIPABLE_DEFENSIVE_ITEMS = new HashSet<>(Arrays.asList(
            WOODEN_SHIELD

    ));



}
