//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package scripts.util;

import java.util.ArrayList;
import java.util.List;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public class Locations {

    //  ASSORTED
    public static final RSArea RIMMINGTON_SCIMITARS_DOWNSTAIRS_BIG = new RSArea(new RSTile(2969, 3216, 0), new RSTile(2963, 3213, 0));
    public static final RSArea RIMMINGTON_SCIMITARS_DOWNSTAIRS = new RSArea(new RSTile(2964, 3213, 0), new RSTile(2966, 3214, 0));
    public static final RSArea RIMMINGTON_SCIMITARS_UPSTAIRS = new RSArea(new RSTile(2968, 3216, 1), new RSTile(2969, 3214, 1));
    public static final RSTile RIMMINGTON_SCIMITARS_LOOTSPOT = new RSTile(2965, 3210, 1);
    public static final RSArea RIMMINGTON_SCIMITARS_LOOTAREA = new RSArea(new RSTile(2968, 3213, 1), new RSTile(2963, 3210, 1));

    // GATHERER LOCATIONS
    public static final List<RSTile[]> COWS_ALL_LOCATIONS = new ArrayList();
    public static final List<RSTile[]> CHICKENS_ALL_LOCATIONS = new ArrayList();
    public static final RSArea LUMBRIDGE_COWS_NORTH = new RSArea(new RSTile(3194, 3285, 0), new RSTile(3210, 3301, 0));
    public static final RSArea FALADORE_COWS_SOUTH = new RSArea(new RSTile(3021, 3297, 0), new RSTile(3041, 3313, 0));
    public static final RSArea FALADORE_CHICKENS_SOUTH = new RSArea(new RSTile(3014, 3298, 0), new RSTile(3020, 3282, 0));
    
    // QUEST LOCATIONS
    // Lumbridge Castle
    public static final RSArea LUMBY_CASTLE_KITCHEN = new RSArea(new RSTile(3206, 3212, 0), new RSTile(3211, 3216, 0));
    public static final RSArea LUMBY_CASTLE_BASEMENT_LADDER_AREA = new RSArea(new RSTile(3208, 9618, 0), new RSTile(3210, 9615, 0));
    public static final RSArea LUMBY_CASTLE_BASEMENT_BUCKET_RUNTO = new RSArea(new RSTile(3216, 9623, 0), new RSTile(3215, 9624, 0));
    public static final RSArea LUMBY_CASTLE_BASEMENT_BUCKET_LOC = new RSArea(new RSTile(3215, 9624, 0), new RSTile(3216, 9625, 0));
    public static final RSArea LUMBY_CASTLE_BASEMENT_LADDER = new RSArea(new RSTile(3208, 9618, 0), new RSTile(3210, 9615, 0));
    public static final RSArea LUMBY_CASTLE_GROUND_STAIRS = new RSArea(new RSTile(3206, 9208, 0), new RSTile(3205, 3209, 0));
    public static final RSArea LUMBY_CASTLE_LEVEL1_STAIRS = new RSArea(new RSTile(3208, 9618, 0), new RSTile(3210, 9615, 0));
    public static final RSArea LUMBY_CASTLE_LEVEL2_STAIRS = new RSArea(new RSTile(3206, 3208, 1), new RSTile(3205, 3210, 1));
    public static final RSArea LUMBY_CASTLE_LEVEL2_WOOLSPOT = new RSArea(new RSTile(3209, 3215, 1), new RSTile(3205, 3211, 1));

    // Lumbridge farming areas
    public static final RSArea FARM_FREDS_HOUSE = new RSArea(new RSTile(3188, 3274, 0), new RSTile(3192, 3270, 0));
    public static final RSArea FARM_FREDS_SHEEP = new RSArea(new RSTile(3194, 3259, 0), new RSTile(3210, 3274, 0));
    public static final RSArea FARM_CHICKENS_MILL = new RSArea(new RSTile(3185, 3291, 0), new RSTile(3171, 3301, 0));
    public static final RSArea FARM_GRAIN_FIELD = new RSArea(new RSTile(3162, 3292, 0), new RSTile(3160, 3294, 0));
    public static final RSArea FARM_DAIRY_COW = new RSArea(new RSTile(3256, 3270, 0), new RSTile(3252, 3274, 0));

    //MILL
    public static final RSArea MILL_GROUND = new RSArea(new RSTile(3164, 3305, 0), new RSTile(3167, 3308, 0));
    public static final RSArea MILL_LEVEL1_LADDER = new RSArea(new RSTile(3164, 3305, 1), new RSTile(3167, 3308, 1));
    public static final RSArea MILL_LEVEL3 = new RSArea(new RSTile(3164, 3305, 2), new RSTile(3167, 3308, 2));

    //TUT ISLAND
    public static final RSArea TUTORIAL_ISLAND = new RSArea(new RSTile(3089, 3113, 0), new RSTile(3104, 3089, 0));
    public static final RSArea TUTORIAL_ISLAND_ACC_CREATOR = new RSArea(new RSTile(3096, 3110, 0), new RSTile(3091, 3102, 0));

    //QUEST PICKUP ARRAY LIST
    public static ArrayList<RSTile[]> bucketPotLocations = new ArrayList<RSTile[]>();
    public static ArrayList<RSTile[]> farmLocations = new ArrayList<RSTile[]>();

    public static void buildLocations(String location)
    {
        if(location == "killLocations")
        {
            COWS_ALL_LOCATIONS.add(FALADORE_COWS_SOUTH.getAllTiles());
            COWS_ALL_LOCATIONS.add(LUMBRIDGE_COWS_NORTH.getAllTiles());
            CHICKENS_ALL_LOCATIONS.add(FALADORE_CHICKENS_SOUTH.getAllTiles());
        }
        /*
        else if(location == "bucketPotLocations")
        {

            bucketPotLocations.add(LUMBY_CASTLE_KITCHEN.getAllTiles());
            bucketPotLocations.add(LUMBY_CASTLE_BASEMENT_BUCKET_RUNTO.getAllTiles());
            bucketPotLocations.add(LUMBY_CASTLE_BASEMENT_BUCKET_LOC.getAllTiles());
        }
        else if(location == "bucketLocations")
        {


        }
            //FARMING AREAS
            questLocations.add(FARM_FREDS_HOUSE.getAllTiles());
            questLocations.add(FARM_FREDS_SHEEP.getAllTiles());
            questLocations.add(FARM_CHICKENS_MILL.getAllTiles());
            questLocations.add(FARM_GRAIN_FIELD.getAllTiles());

            //MILL
            questLocations.add(MILL_GROUND.getAllTiles());
            questLocations.add(MILL_LEVEL1_LADDER.getAllTiles());
            questLocations.add(MILL_LEVEL2_LADDER.getAllTiles());
            questLocations.add(MILL_LEVEL3.getAllTiles());

        */
    }

    public static void buildAllLocations()
    {
        Locations.buildLocations("killLocations");
        Locations.buildLocations("questLocations");
    }
}
