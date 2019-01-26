package scripts.slave;

/*
    This script handles Gathering the hide
 */

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api2007.*;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.*;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.util.Node;

import static org.tribot.api.General.println;
import static org.tribot.api.General.random;
import static org.tribot.api.General.sleep;
import static scripts.util.Character.getScimmies;
import static scripts.util.Character.pickupGroundItem;
import static scripts.util.Coms.isMasterCalling;
import static scripts.util.Items.*;
import static scripts.util.Locations.FALADORE_COWS_SOUTH;
import static scripts.util.Logger.SLAVE_GAT_START;
import static scripts.util.NPC.*;

public class GathererNode extends Node
{


    @Override
    public void execute()
    {
        while(!isMasterCalling() && !Inventory.isFull())
        {
            println(SLAVE_GAT_START);

            // handles moving to the correct location
            checkLocation();

            // handles weapon equipping
            //checkWeapon();

            //Handles picking up hide - killing cow
            checkHide();
            killCow();
        }

    }

    public void checkHide()
    {
        //TODO: make sure that the cowhide is in the rsarea before picking it up (not behind the fence)
        pickupGroundItem("COWHIDE",FALADORE_COWS_SOUTH);
    }

    public void killCow()
    {
        if (!Combat.isUnderAttack())
        {
            println("[*] looking for a target");
            RSNPC[] cows = NPCs.findNearest(Filters.NPCs.nameContains(NPC_COW, NPC_COW_BABY));

            if (cows[0] != null && !cows[0].isOnScreen() && cows[0].getPosition() != null || !cows[0].isClickable())
            {
                println("[*] looking towards cow ");
                Camera.setCameraRotation(General.random(75, 110));
                Camera.setCameraAngle(General.random(68, 90));
                Camera.turnToTile(cows[0].getPosition());
            }
            if (!cows[0].isInCombat() && cows[0] != null && cows[0].isClickable())
            {
                //null check the getModel return
                if(cows[0].getModel() != null)
                {
                    println("[*] clicking cow ");
                    cows[0].getModel().click();
                    sleep(1907, 2901);
                }

            }
            else
            {

                // use this time to set run on at a seamingly random time
                if (Game.getRunEnergy() >= random(5, 17) && !Options.isRunEnabled())
                {
                    println("[*] Turning on RUN ");
                    Options.setRunOn(true);
                }
                
                // closest cow to us is in combat, lets reposition
                println("[*] Closest cow already in combat, looking for another.. ");

                RSTile rt = FALADORE_COWS_SOUTH.getRandomTile();

                Camera.setCameraRotation(General.random(75, 110));
                Camera.setCameraAngle(General.random(68, 90));
                Camera.turnToTile(rt);

                WebWalking.walkTo(rt);

            }

        }
        if ((Combat.isUnderAttack()))
        {
            println("[*] Player is in combat ");

            RSCharacter[] cows = Combat.getAttackingEntities();

            if (cows.length > 0)
            {
                Double currentCowsHealth = cows[0].getHealthPercent();

                if (currentCowsHealth > 0 && currentCowsHealth != null && cows[0] != null)
                {
                    if(currentCowsHealth > 0) {
                        println("[*] Targets health is: " + currentCowsHealth);
                        println("[*] re-clicking target");
                        cows[0].getModel().click();
                        sleep(900, 3000);
                    }
                }
            }

        }
    }
    
    public void checkLocation()
    {
        // walk to correct location
        if (!FALADORE_COWS_SOUTH.contains(Player.getPosition())) {
            println("[!] Walking to cows");
            //change this to dyanmically walk to the closest location

            DaxWalker.walkTo(FALADORE_COWS_SOUTH.getRandomTile());
        }
        if (FALADORE_COWS_SOUTH.contains(Player.getPosition()))
        {
            println("[*] we are at cows, no need to walk");
        }
    }
    /*
    public void checkWeapon()
    {
        RSItem[] currentBackpackItems = Inventory.getAll();
        if (Equipment.isEquipped(BRONZE_SWORD) || (Equipment.isEquipped(BRONZE_AXE)) || (Equipment.isEquipped(BRONZE_PICK))) {
            println("[*] checking backpack for item to equip");
            Boolean isEquiped = false;

            for (RSItem item : currentBackpackItems) {
                if (EQUIPABLE_OFFENSIVE_ITEMS.contains(item.getID()) && item != null) {
                    if (!isEquiped) {
                        println("[*] Equipping item!");
                        item.click();
                        isEquiped = true;
                    }
                }
            }
        }
        
    }
*/
    @Override
    public boolean validate()
    {
        return !Inventory.isFull();
    }


}