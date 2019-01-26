//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package scripts.util;

import java.util.Random;

import org.apache.commons.collections4.functors.EqualPredicate;
import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Game;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Walking;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.Equipment.SLOTS;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.types.*;
import scripts.dax_api.api_lib.DaxWalker;
import sun.awt.EventQueueItem;

import static scripts.util.Items.*;
import static scripts.util.Locations.*;

public class Character<scimAmnt>
{
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CHARACTER RELATED BOOLEAN CHECKING METHODS
    
    public static boolean hasWeaponInInventory() {
        return false;
    }
    
    public static boolean hasItemInInventory(String item,int amount)
    {
        inventoryOpenCheck();
        if(Inventory.find(item).length > 0 && (Inventory.find(item).length >= amount))
        {
            return true;
        }
        return false;
    }
    public static boolean hasBlacklistedItems()
    {
        inventoryOpenCheck();
        RSItem[] items = Inventory.getAll();
        General.println("[*] Getting all items in backpack");
        for(RSItem item : items)
        {
            General.println("[*] Item Name:"+item);
            for(String element : whitelistedItems)
            {
                General.println("[*] Whitelist comparison: "+element);
                if(item.name == element)
                {
                    General.println("[*] Found a match, Item:"+item+" and element: "+ element);
                    return true;
                }
            }
            General.sleep(300, 1600);
        }
        General.println("[*] Did not find any matches");
        return false;
    }
    public static boolean isWieldingWeapon()
    {
        RSItem currentWeapon = SLOTS.WEAPON.getItem();
        return currentWeapon != null;
    }
    public static boolean isWieldingShield()
    {
        RSItem currentWeapon = SLOTS.SHIELD.getItem();
        return currentWeapon != null;
    }
    public static boolean isWieldingScimitar()
    {
        return Equipment.isEquipped(BRONZE_SCIMITAR);
    }
    
    public static boolean hasBetterWeaponInInventory()
    {
        return false;
    }
    
    public static boolean shouldEat() {
        return false;
    }
    
    public static boolean hasFood() {
        return false;
    }
    
    public static boolean hasBones() {
        return false;
    }

    public static boolean isInventoryFull()
    {
        inventoryOpenCheck();
        return Inventory.isFull();
    }

    public static boolean inRSArea(RSArea area)
    {
        if(area.contains(Player.getPosition()))
        {
            General.println("[*]Player in RSArea");
            return true;
        }
        else
        {
            General.println("[*] Player Not in RSArea");
            return false;
        }
    }
    public static boolean isAtCows() {
        return Locations.COWS_ALL_LOCATIONS.contains(Player.getPosition());
    }
    
    public static boolean isAtChickens() {
        return Locations.CHICKENS_ALL_LOCATIONS.contains(Player.getPosition());
    }
    
    public static boolean isWalking() {
        return Player.isMoving() == Boolean.TRUE && Game.isRunOn() == Boolean.FALSE;
    }
    
    public static boolean isRunning() {
        return Player.isMoving() == Boolean.TRUE && Game.isRunOn() == Boolean.TRUE;
    }
    
    public static boolean hasMetSkillReqs()
    {
        return Skills.getActualLevel(SKILLS.ATTACK) < 10 || Skills.getActualLevel(SKILLS.STRENGTH) < 10 || Skills.getActualLevel(SKILLS.DEFENCE) < 5;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CHARACTER RELATED METHODS THAT REQUIRE ACTIONS TO BE TAKEN
    public static void getScimmies(int scimAmnt)
    {
        inventoryOpenCheck();
        int scimmyCount = Inventory.getCount(BRONZE_SCIMITAR);
        while(!isWieldingWeapon())
        {
            if (!Locations.RIMMINGTON_SCIMITARS_DOWNSTAIRS.contains(Player.getPosition()) && !Locations.RIMMINGTON_SCIMITARS_UPSTAIRS.contains(Player.getPosition()) && !Locations.RIMMINGTON_SCIMITARS_LOOTAREA.contains(Player.getPosition()))
            {
                General.println("[*] Not upstairs or down stairs");
                if (!Player.isMoving()) {
                    General.println("[*] Not moving");
                    General.println("[*] Double check if Not upstairs or down stairs");
                    if (!Locations.RIMMINGTON_SCIMITARS_DOWNSTAIRS.contains(Player.getPosition()) && !Locations.RIMMINGTON_SCIMITARS_UPSTAIRS.contains(Player.getPosition()) && !Locations.RIMMINGTON_SCIMITARS_LOOTAREA.contains(Player.getPosition()))
                    {
                        General.println("[*] Walking to Rimmington Downstairs Scimmies");
                        DaxWalker.walkTo(Locations.RIMMINGTON_SCIMITARS_DOWNSTAIRS.getRandomTile());
                    }
                }
                else
                {
                    General.println("[*] Travelling to Rimmington Scimmies Downstairs");
                }
            }
            else if (Locations.RIMMINGTON_SCIMITARS_DOWNSTAIRS.contains(Player.getPosition()))
            {
                General.println("[*] Arrived Downstairs in Rimmington Scimmies");
                RSObject[] rimmingtonScimmyStaircaseDownStairs = Objects.findNearest(20, RIMMINGTON_SCIMITAR_STAIRCASE_DOWNSTAIRS);
                if (rimmingtonScimmyStaircaseDownStairs.length > 0 && rimmingtonScimmyStaircaseDownStairs[0].isOnScreen() && rimmingtonScimmyStaircaseDownStairs[0].isClickable())
                {
                    General.println("[*] Clicking downstairs staircase");
                    rimmingtonScimmyStaircaseDownStairs[0].click();
                    General.sleep(1000, 1500);
                }
            }
            else if (Locations.RIMMINGTON_SCIMITARS_UPSTAIRS.contains(Player.getPosition()))
            {
                General.println("[*] Arrived upstairs at Rimmington Scimmies");
                General.println("[*] Walking to looting spot");
                WebWalking.walkTo(Locations.RIMMINGTON_SCIMITARS_LOOTSPOT);
            }
            else if (Locations.RIMMINGTON_SCIMITARS_LOOTAREA.contains(Player.getPosition()))
            {
                General.println("[*] In loot area Rimmington Scimmies");
                if(hasItemInInventory("Bronze scimitar",1))
                {
                    equipItem("Bronze scimitar");
                }
                else
                {
                    RSGroundItem[] groundScimmys = GroundItems.findNearest(BRONZE_SCIMITAR);
                    if (groundScimmys.length > 0)
                    {
                        General.println("[*] Found more than one scimmy");
                        inventoryOpenCheck();
                        General.println("[*] Inventory already open");
                        General.println("[*] Going inside pickupGroundItem Method");
                        pickupGroundItem("Bronze Scimitar", Locations.RIMMINGTON_SCIMITARS_LOOTAREA);

                    }
                    else
                    {
                        General.println("[*] No Scimmies on ground");
                    }
                }
            }
            General.sleep(600, 1800);
        }

    }
    
    public static void pickupGroundItem(String item, RSArea lootArea)
    {
        RSGroundItem[] groundItem = GroundItems.sortByDistance(Player.getPosition(), GroundItems.findNearest(item));
        General.println("[*] checking for " + item + "'s,");
        if (groundItem.length > 0)
        {
            if (lootArea.contains(groundItem[0].getPosition()))
            {
                if (!Inventory.isFull())
                {
                    if (groundItem[0].isOnScreen() && groundItem[0].isClickable())
                    {
                        Clicking.click("Take " + item, groundItem[0]);
                        General.sleep(600, 1900);
                        pickupGroundItem(item, lootArea);
                    }
                    else
                    {
                        General.println("[*] " + item + " not onscreen - looking towards " + item);
                        Camera.turnToTile(groundItem[0].getPosition());
                        Camera.setCameraRotation(General.random(75, 110));
                        Camera.setCameraAngle(General.random(68, 90));
                        Walking.blindWalkTo(groundItem[0].getPosition());
                        pickupGroundItem(item, lootArea);
                    }
                }
            }
            else
            {
                General.println("{*} " + item + " not in RS AREA");
            }
        }
        else
        {
            General.println("{*} No " + item + " Found on ground");
        }
        
    }
    
    public static void equipItem(String item)
    {
        RSItem[] inventItem = Inventory.find(item);
        if (inventItem.length > 0)
        {
            inventItem[0].click();
            General.sleep(300, 450);
            if (Equipment.isEquipped(item))
            {
                General.println("[*] Successfully Equiped " + item);
                General.sleep(600, 1900);
            }
            else
            {
                General.println("[!] Failed to Equip " + item);
            }
        }
        
    }
    
    public static void depositAllItems()
    {
        if (!Banking.isBankScreenOpen())
        {
            General.println("[*] Opening banker");
            Banking.openBankBanker();
        }
        
        if (Banking.isBankScreenOpen())
        {
            General.println("[*] banker open");
            General.sleep(100, 350);
            General.println("[*] depositing items");
            Banking.depositAll();
            General.sleep(800,999);
        }
        
    }
    
    public static void walkToNearestBank()
    {
        if (!Banking.isInBank())
        {
            General.println("[*] Not in bank");
            if (!Player.isMoving())
            {
                General.println("[*] Not moving");
                DaxWalker.walkToBank();
                General.sleep(600, 1900);
            }
            else
            {
                General.println("[*] Moving to Bank");
                General.sleep(600, 1900);
            }
        }
        
    }
    
    public static void withdrawFromBank(int item, int amount)
    {
        General.println("[*] Inside hasScimmiesInBank");
        if (Banking.isBankScreenOpen())
        {
            General.println("[*] 1");
            RSItem[] bankItem = Banking.find(item);
            if (bankItem.length > 0)
            {
                General.println("[*] 2");
                Banking.withdrawItem(bankItem[0], amount);
                Banking.close();
            }
        }
        
    }
    
    public static Integer countScimmy()
    {
        RSItem[] bankScimmies = Banking.find(BRONZE_SCIMITAR);
        return bankScimmies.length;
    }
    
    public static void inventoryOpenCheck()
    {
        if(!Inventory.open())
        {
            General.println("[*] Inventory closed, Opening Inventory");
            Inventory.open();
        }
        else
        {
            General.println("[*] Inventory already open, proceeding");
        }
    }
    public static void cleanseInventory()
    {
        inventoryOpenCheck();
        Inventory.dropAllExcept(whitelistedItems);
        RSItem[] boneArray = Inventory.find("Bones");
        RSItem[] shieldArray = Inventory.find("Wooden shield");
        if(boneArray.length > 0)
        {
            for(RSItem bone : boneArray)
            {
                General.println("[*] Burying bone");
                bone.click();
                General.sleep(300, 1600);
            }
        }
        if(shieldArray.length > 0)
        {
            for(RSItem shield : shieldArray)
            {
                if(!isWieldingShield())
                {
                    General.println("[*] Equipping Wooden Shield");
                    equipItem("Wooden shield");
                }
                else
                {
                    General.println("[!] Wooden shield already equipped ");
                    General.println("[*] Dropping Additional Shields");
                    Inventory.drop(shield);
                }
                General.sleep(300, 1600);
            }
            
        }
    }
    public static void clickInteractiveObject(int objectID)
    {
        RSObject[] interactableObject = Objects.findNearest(20, objectID);
        if (interactableObject.length > 0 && interactableObject[0].isOnScreen() && interactableObject[0].isClickable())
        {

            General.println("[*] Attempting to click: "+interactableObject[0].getDefinition().getName());
            interactableObject[0].click();
            General.sleep(1000, 1500);
        }
    }

    public static void walkToRSArea(RSArea destination)
    {
        if(inRSArea(destination))
        {
            General.println("[*] Already at destination");
        }
        else
        {
            if(!isWalking()) {
                General.println("[*] Walking to destination now");
                DaxWalker.walkTo(destination.getRandomTile());
            }
            else
            {
                General.println("[*] Already Walking to destination");
            }
        }
    }
    public static void clickInventoryItem(String itemName)
    {
        if(hasItemInInventory(itemName,1))
        {
           RSItem[] item = Inventory.find(itemName);
           if(item.length > 0)
           {
               General.println("Found Item: "+itemName+" in inventory, clicking item now");
               item[0].click();
           }
           else
           {
               General.println("No Item: "+itemName+" found in inventory");
           }
        }
    }
}
