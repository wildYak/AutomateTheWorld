package scripts.util;

import static scripts.util.Character.*;
import static scripts.util.Items.*;
import static scripts.util.Locations.*;
import static scripts.util.NPC.*;

import org.tribot.api.General;
import org.tribot.api2007.Game;
import org.tribot.api2007.NPCChat;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import org.tribot.api2007.util.DPathNavigator;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.util.Objects.questItem;
import scripts.dax_api.shared.helpers.questing.*;
import scripts.util.NPC.*;

import java.util.ArrayList;
import java.util.Random;

public class Quests
{
    //QUEST RESPONSES
    //COOKS ASSISTANT
    public static final String COOK_OPTION_1 = "what's wrong?";
    public static final String COOK_OPTION_2 = "i'm always happy to help a cook in distress.";
    public static final String COOK_OPTION_3 = "actually, i know where to find this stuff.";
    
    
    //QUEST ENUMS
    public enum Quest {
        // Free
        BLACK_KNIGHTS_FORTRESS(130, 0, 4),
        COOKS_ASSISTANT(29, 0, 2),
        DEMON_SLAYER(222, 0, 22220899),
        DORICS_QUEST(31, 0, 100),
        DRAGON_SLAYER(176, 0, 10), // 177?
        ERNEST_THE_CHICKEN(32, 0, 3),
        GOBLIN_DIPLOMACY(62, 0, 6),
        IMP_CATCHER(160, 0, 2),
        THE_KNIGHTS_SWORD(122, 0, 7),
        PIRATES_TREASURE(71, 0, 4),
        PRINCE_ALI_RESCUE(273, 0, 110),
        THE_RESTLESS_GHOST(107, 0, 5),
        ROMEO_AND_JULIET(144, 0, 100),
        RUNE_MYSTERIES(63, 0, 6),
        SHEEP_SHEARER(179, 0, 21),
        SHIELD_OF_ARRAV(146, 0, 4), // Black Arm Gang Settings, Phoenix Gang = 145, 0, 7
        VAMPIRE_SLAYER(178, 0, 3),
        WITCHS_POTION(67, 0, 3),
        // Member
        ANIMAL_MAGNETISM(0, 0, 0),
        ANOTHER_SLICE_OF_HAM(0, 0, 0),
        BETWEEN_A_ROCK(0, 0, 0),
        BIG_CHOMPY_BIRD_HUNTING(0, 0, 0),
        BIOHAZARD(0, 0, 0),
        CABIN_FEVER(0, 0, 0),
        CLOCK_TOWER(0, 0, 0),
        COLD_WAR(0, 0, 0),
        CONTACT(0, 0, 0),
        CREATURE_OF_FENKENSTRAIN(0, 0, 0),
        DARKNESS_OF_HALLOWVALE(0, 0, 0),
        DEATH_PLATEAU(314, 0, 80),
        DEATH_TO_THE_DORGESHUUN(0, 0, 0),
        DESERT_TREASURE(0, 0, 0),
        DEVIOUS_MINDS(0, 0, 0),
        THE_DIG_SITE(0, 0, 0),
        DREAM_MENTOR(0, 0, 0),
        DRUIDIC_RITUAL(80, 0, 4),
        DWARF_CANNON(0, 0, 0),
        EADGARS_RUSE(0, 0, 0),
        EAGLES_PEAK(0, 0, 0),
        ELEMENTAL_WORKSHOP_I(0, 0, 0),
        ELEMENTAL_WORKSHOP_II(0, 0, 0),
        ENAKHRAS_LAMENT(0, 0, 0),
        ENLIGHTENED_JOURNEY(0, 0, 0),
        THE_EYES_OF_GLOUPHRIE(0, 0, 0),
        FAIRYTALE_I_GROWING_PAINTS(671, 0, 0),
        FAIRYTALE_II_CURE_A_QUEEN(0, 0, 0),
        FAMILY_CREST(0, 0, 0),
        THE_FEUD(0, 0, 0),
        FIGHT_AREA(17, 0, 15),
        FISHING_CONTEST(0, 0, 0),
        FORGETTABLE_TALE(0, 0, 0),
        THE_FREMENNIK_ISLES(0, 0, 0),
        THE_FREMENNIK_TRIALS(347, 0, 0),
        GARDEN_OF_TRANQUILITY(0, 0, 0),
        GERTRUDES_CAT(180, 0, 6),
        GHOSTS_AHOY(0, 0, 0),
        THE_GIANT_DWARF(0, 0, 0),
        THE_GOLEM(0, 0, 0),
        THE_GRAND_TREE(150, 0, 160),
        THE_GREAT_BRAIN_ROBBERY(0, 0, 0),
        GRIM_TALES(0, 0, 0),
        THE_HAND_IN_THE_SAND(0, 0, 0),
        HAUNTED_MINE(0, 0, 0),
        HAZEEL_CULT(0, 0, 0),
        HEROES_QUEST(0, 0, 0),
        HOLY_GRAIL(0, 0, 0),
        HORROR_FROM_THE_DEEP(0, 0, 0),
        ICTHLARINS_LITTLE_HELPER(0, 0, 0),
        IN_AID_OF_THE_MYREQUE(705, 0, 0),
        IN_SEARCH_OF_THE_MYREQUE(387, 0, 110),
        JUNGLE_POTION(175, 0, 7),
        KINGS_RANSOM(0, 0, 0),
        LEGENDS_QUEST(0, 0, 0),
        LOST_CITY(0, 0, 0),
        THE_LOST_TRIBE(0, 0, 0),
        LUNAR_DIPLOMACY(0, 0, 0),
        MAKING_HISTORY(0, 0, 0),
        MERLINS_CRYSTAL(0, 0, 0),
        MONKS_FRIEND(30, 0, 80),
        MONKEY_MADNESS_I(0, 0, 0),
        MONKEY_MADNESS_II(0, 0, 0),
        MOUNTAIN_DAUGHTER(0, 0, 0),
        MOURNINGS_END_PART_I(0, 0, 0),
        MOURNINGS_END_PART_II(0, 0, 0),
        MURDER_MYSTERY(0, 0, 0),
        MY_ARMS_BIG_ADVENTURE(0, 0, 0),
        NATURE_SPIRIT(307, 0, 110),
        OBSERVATORY_QUEST(0, 0, 0),
        OLAFS_QUEST(0, 0, 0),
        ONE_SMALL_FAVOUR(416, 0, 280),
        PLAGUE_CITY(0, 0, 0),
        PRIEST_IN_PERIL(0, 0, 0),
        RAG_AND_BONE_MAN(0, 0, 0),
        RATCATCHERS(0, 0, 0),
        RECIPE_FOR_DISASTER(0, 0, 0),
        RECRUITMENT_DRIVE(0, 0, 0),
        REGICIDE(0, 0, 0),
        ROVING_ELVES(0, 0, 0),
        ROYAL_TROUBLE(0, 0, 0),
        RUM_DEAL(0, 0, 0),
        SCORPION_CATCHER(0, 0, 0),
        SEA_SLUG(0, 0, 0),
        SHADES_OF_MORTTON(0, 0, 0),
        SHADOW_OF_THE_STORM(0, 0, 0),
        SHEEP_HERDER(0, 0, 0),
        SHILO_VILLAGE(116, 0, 15),
        THE_SLUG_MENACE(0, 0, 0),
        A_SOULS_BANE(0, 0, 0),
        SPIRITS_OF_THE_ELID(0, 0, 0),
        SWAN_SONG(723, 0, 1071511752),
        TAI_BWO_WANNAI_TRIO(0, 0, 0),
        A_TAIL_OF_TWO_CATS(0, 0, 0),
        TEARS_OF_GUTHIX(0, 0, 0),
        TEMPLE_OF_IKOV(0, 0, 0),
        THRONE_OF_MISCELLANIA(0, 0, 0),
        THE_TOURIST_TRAP(0, 0, 0),
        TOWER_OF_LIFE(0, 0, 0),
        TREE_GNOME_VILLAGE(111, 0, 9),
        TRIBAL_TOTEM(0, 0, 0),
        TROLL_ROMANCE(0, 0, 0),
        TROLL_STRONGHOLD(0, 0, 0),
        UNDERGROUND_PASS(0, 0, 0),
        WANTED(0, 0, 0),
        WATCHTOWER(0, 0, 0),
        WATERFALL_QUEST(65, 0, 10),
        WHAT_LIES_BELOW(0, 0, 0),
        WITCHES_HOUSE(226, 0, 7),
        ZORGE_FLESH_EATERS(0, 0, 0);

        private int setting;
        private int notStarted;
        private int complete;

        Quest(int setting, int notStarted, int complete) {
            this.setting = setting;
            this.notStarted = notStarted;
            this.complete = complete;
        }
    }
    //QUEST METHODS
    //QUEST POINTS
    public static int getQuestPoints()
    {
        return Game.getSetting(101);
    }
    public static boolean questPointsMet()
    {
        if(getQuestPoints() >= 7)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    //GENERAL QUEST CHECKS

    public static String questStatus(String questName)
    {
        if(questName == "Cook's Assistant")
        {
            if(Game.getSetting(Quest.COOKS_ASSISTANT.setting) != Quest.COOKS_ASSISTANT.notStarted && Game.getSetting(Quest.COOKS_ASSISTANT.setting) != Quest.COOKS_ASSISTANT.complete)
            {
                return "In Progress";
            }
            else if(Game.getSetting(Quest.COOKS_ASSISTANT.setting) == Quest.COOKS_ASSISTANT.complete)
            {
                return "Complete";
            }
            else if(Game.getSetting(Quest.COOKS_ASSISTANT.setting) == Quest.COOKS_ASSISTANT.notStarted)
            {
                return "Not Started";
            }
        }
        else if(questName == "Romeo & Juliet")
        {
            if(Game.getSetting(Quest.ROMEO_AND_JULIET.setting) != Quest.ROMEO_AND_JULIET.notStarted && Game.getSetting(Quest.ROMEO_AND_JULIET.setting) != Quest.ROMEO_AND_JULIET.complete)
            {
                return "In Progress";
            }
            else if(Game.getSetting(Quest.ROMEO_AND_JULIET.setting) == Quest.ROMEO_AND_JULIET.complete)
            {
                return "Complete";
            }
            else if(Game.getSetting(Quest.ROMEO_AND_JULIET.setting) == Quest.ROMEO_AND_JULIET.notStarted)
            {
                return "Not Started";
            }
        }
        else if(questName == "Sheep Shearer")
        {
            if(Game.getSetting(Quest.SHEEP_SHEARER.setting) != Quest.SHEEP_SHEARER.notStarted && Game.getSetting(Quest.SHEEP_SHEARER.setting) != Quest.SHEEP_SHEARER.complete)
            {
                return "In Progress";
            }
            else if(Game.getSetting(Quest.SHEEP_SHEARER.setting) == Quest.SHEEP_SHEARER.complete)
            {
                return "Complete";
            }
            else if(Game.getSetting(Quest.SHEEP_SHEARER.setting) == Quest.SHEEP_SHEARER.notStarted)
            {
                return "Not Started";
            }
        }
        return "Quest Not Found";
    }

    public static boolean questItemsObtained(String questName)
    {
        if(questName == "Cook's Assistant")
        {
            if(hasItemInInventory("Bucket of milk",1) && hasItemInInventory("Pot of flour",1)  && hasItemInInventory("Egg",1))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(questName == "Sheep Shearer")
        {
            if(hasItemInInventory("Ball of wool",20))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    public static boolean questPreReqItemsObtained (String questName)
    {
        if(questName == "Cook's Assistant")
        {
            if(hasItemInInventory("Bucket",1) && hasItemInInventory("Pot",1))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(questName == "Sheep Shearer")
        {
            if(hasItemInInventory("Shears",1) && hasItemInInventory("Wool",20))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
    public static String getQuestPreReqItem(String questName, String type)
    {
        questItem chosenItem = new questItem();
        questItem lastPath = new questItem();

        DPathNavigator pathinfo = new DPathNavigator();
        ArrayList<questItem> questItemObj = new ArrayList<questItem>();
        General.println("[*] Checking if obtained items already, if not adding to arraylist");
        //pot
        if(questName == "Cook's Assistant") {
            
            if (!hasItemInInventory("Pot", 1)) {
                RSTile[] potPath = pathinfo.findPath(LUMBY_CASTLE_KITCHEN.getRandomTile().getPosition());
                questItem pot = new questItem();
                pot.destinationName = "LUMBY_CASTLE_KITCHEN";
                pot.pathLength = potPath.length;
                pot.itemName = "Pot";
                questItemObj.add(pot);
                General.println("[*] Pot added to arraylist as not found in inventory");
            }

            //bucket
            if (!hasItemInInventory("Bucket", 1)) {
                RSTile[] bucketPath = pathinfo.findPath(LUMBY_CASTLE_BASEMENT_BUCKET_RUNTO.getRandomTile().getPosition());
                questItem bucket = new questItem();
                bucket.destinationName = "LUMBY_CASTLE_BASEMENT_BUCKET_RUNTO";
                bucket.pathLength = bucketPath.length;
                bucket.itemName = "Bucket";
                questItemObj.add(bucket);
                General.println("[*] Bucket added to arraylist as not found in inventory");
            }
            //egg
            if(!hasItemInInventory("Egg",1))
            {
                RSTile[] eggPath = pathinfo.findPath(FARM_CHICKENS_MILL.getRandomTile().getPosition());
                questItem egg = new questItem();
                egg.destinationName = "FARM_CHICKENS_MILL";
                egg.pathLength = eggPath.length;
                egg.itemName = "Egg";
                questItemObj.add(egg);
                General.println("[*] Egg added to arraylist as not found in inventory");
            }
        }
        if(questName == "Sheep Shearer") {
            //shears
            if (!hasItemInInventory("Shears", 1)) {
                RSTile[] shearsPath = pathinfo.findPath(FARM_FREDS_HOUSE.getRandomTile().getPosition());
                questItem shears = new questItem();
                shears.destinationName = "FARM_FREDS_HOUSE";
                shears.pathLength = shearsPath.length;
                shears.itemName = "Shears";
                questItemObj.add(shears);
                General.println("[*] Shears added to arraylist as not found in inventory");
            }
        }
        if(type == "closest")
        {
            int index = 0;
            General.println("[*] Finding closest item location");
            for (questItem path : questItemObj)
            {
                General.println("[*]Destination: " + path.destinationName + " TileDistance: " + path.pathLength);
                if (index == 0)
                {
                    General.println("[*] First entry in array list set lastpath and skip to next");
                    lastPath = path;
                } else
                {
                    if (lastPath.pathLength < path.pathLength)
                    {
                        General.println("[*]Destination: " + lastPath.destinationName + " TileDistance: " + lastPath.pathLength + " is closer than Destination: " + path.destinationName + " Tile Distance: " + path.pathLength);
                        chosenItem = lastPath;
                    } else
                    {
                        General.println("[*]Destination: " + path.destinationName + " TileDistance: " + path.pathLength + " is closer than last path");
                        chosenItem = path;
                    }
                    General.println("[*]Setting current object to lastPath");
                    lastPath = path;
                    index++;
                    
                }
            }
            General.println("[*] The closest item is item: " + chosenItem.itemName + " at Destination: " + chosenItem.destinationName + " with TileDistance: " + chosenItem.pathLength);
            return chosenItem.itemName;
        }
        else if(type == "random")
        {
            
            int arraySize = questItemObj.size()-1;
            int randIndex = General.random(0,arraySize);
            String returnedItem = questItemObj.get(randIndex).itemName;
            General.println("Returning random item:" +returnedItem);
            return returnedItem;
        }
        return "No item returned";
    }

    public static void pickupPreReqQuestItem(String itemName)
    {
        if(itemName == "Pot")
        {
            pickupQuestItem("Pot",1,LUMBY_CASTLE_KITCHEN);
            if(!hasItemInInventory("Bucket",1))
            {
                String item = getQuestPreReqItem("Cook's Assistant","closest");
                pickupQuestItem("Bucket",1,LUMBY_CASTLE_BASEMENT_BUCKET_RUNTO,LUMBY_CASTLE_BASEMENT_BUCKET_LOC);
            }
        }
        if(itemName== "Bucket")
        {
            pickupQuestItem("Bucket",1,LUMBY_CASTLE_BASEMENT_BUCKET_RUNTO,LUMBY_CASTLE_BASEMENT_BUCKET_LOC);
            if(!hasItemInInventory("Pot",1))
            {
                String item = getQuestPreReqItem("Cook's Assistant","closest");
                pickupQuestItem(item,1,LUMBY_CASTLE_KITCHEN);
            }
        }
        else if (itemName == "Shears")
        {
            pickupQuestItem("Shears",1,FARM_FREDS_HOUSE);
        }
        else if (itemName == "Egg")
        {
            pickupQuestItem("Egg",1,FARM_CHICKENS_MILL);
        }
    }
    // CHEFS ASSISTANT


    public static void pickupQuestItem(String item, int amount, RSArea pickupArea, RSArea itemArea)
    {

        while(!hasItemInInventory(item,amount))
        {
            walkToRSArea(pickupArea);
            if(inRSArea(pickupArea) && !hasItemInInventory(item,amount))
            {
                pickupGroundItem(item,itemArea);
            }
            General.sleep(500,900);
        }
    }
    public static void pickupQuestItem(String item, int amount, RSArea pickupArea)
    {
        while(!hasItemInInventory(item,amount))
        {
            walkToRSArea(pickupArea);
            if(inRSArea(pickupArea) && !hasItemInInventory(item,amount))
            {
                pickupGroundItem(item,pickupArea);
            }
            General.sleep(500,900);
        }
    }

    public static void collectFlour()
    {
        boolean hopperDone = false;
        boolean controllsDone = false;
        while(!inRSArea(MILL_GROUND) && !isWalking())
        {
            walkToRSArea(MILL_GROUND);
            General.sleep(500,900);
        }
        while(!hasItemInInventory("Pot of flour",1))
        {
            General.println("[*] Moving to ground floor of Mill");
            if (inRSArea(MILL_GROUND) && hopperDone == false && controllsDone == false) {
                General.println("[*] Arrived at Mill, clicking ladder");
                clickInteractiveObject(MILL_GROUND_LADDER);
                General.sleep(500, 900);
            }
            else if (inRSArea(Locations.MILL_LEVEL1_LADDER) && hopperDone == false && controllsDone == false) {
                General.println("[*] Arrived at first floor of Mill, clicking ladder");
                clickInteractiveObject(Items.MILL_LEVEL1_LADDER);
                if (isNPCChatOpen())
                {
                    if (isNPCChatOptionsType())
                    {
                        if (doesNPCChatOptionsContain("Climb Up.", NPCChat.getOptions()))
                        {
                            General.println("[*] Climbing Up ladder");
                            NPCChat.selectOption("Climb Up.", true);
                        }
                    }

                }
            }
            else if (inRSArea(Locations.MILL_LEVEL1_LADDER) && hopperDone == true && controllsDone == true)
            {
                General.println("[*] Back on first floor");
                clickInteractiveObject(Items.MILL_LEVEL1_LADDER);
                if(isNPCChatOptionsType())
                {
                    if(doesNPCChatOptionsContain("Climb Down.",NPCChat.getOptions()))
                    {
                        General.println("[*] Climbing Down ladder");
                        NPCChat.selectOption("Climb Down.",true);
                    }
                }
            }
            else if (inRSArea(MILL_LEVEL3) && hopperDone == false)
            {
                General.println("[*] Arrived at third floor of Mill, loading wheat into hopper");
                clickInventoryItem("Grain");
                clickInteractiveObject(MILL_LEVEL3_HOPPER);
                General.sleep(1400,2600);
                hopperDone = true;
                if(hopperDone = true && controllsDone == false)
                {
                    General.println("[*] Time to pull hopper controlls");
                    clickInteractiveObject(MILL_LEVEL3_HOPPERCONTROLS);
                    controllsDone = true;
                }
                
            }
            else if (inRSArea(MILL_LEVEL3) && hopperDone == true && controllsDone == true)
            {
                General.println("[*] Tasks done, time to pickup pot of flour");
                clickInteractiveObject(Items.MILL_LEVEL2_LADDER);
            }
            else if (inRSArea(MILL_GROUND) && hopperDone == true && controllsDone == true)
            {
                General.println("[*] Tasks done, Arrived at ground floor, collecting pot of flour");
                clickInteractiveObject(FLOUR_BIN);
            }
            General.sleep(1500,3400);
        }

    }
    public static void collectWool()
    {
        if(!hasItemInInventory("Wool",20) && hasItemInInventory("Shears",1))
        {
            DaxWalker.walkTo(FARM_FREDS_SHEEP.getRandomTile());
            if(FARM_FREDS_SHEEP.contains(Player.getPosition()) && !hasItemInInventory("Bucket",20))
            {
                pickupGroundItem("Egg",FARM_FREDS_SHEEP);
            }
        }
    }
    public static void collectGrain()
    {
        while(!hasItemInInventory("Grain",1))
        {
            if(!inRSArea(FARM_GRAIN_FIELD))
            {
                walkToRSArea(FARM_GRAIN_FIELD);
            }
            else
            {
                clickInteractiveObject(General.random(15506,15507));
            }
            General.sleep(1500,1900);
        }
    }
    
    public static void collectMilk()
    {
        while(!hasItemInInventory("Bucket of milk",1))
        {
            
            if(!inRSArea(FARM_DAIRY_COW))
            {
                walkToRSArea(FARM_DAIRY_COW);
            }
            else
            {
                if(hasItemInInventory("Bucket",1))
                {
                    clickInteractiveObject(DAIRY_COW);
                }
                else
                {
                    pickupPreReqQuestItem("Bucket");
                }
                
            }
            General.sleep(1500,1900);
        }
    }
}
