package scripts.slave;


import org.tribot.api.General;
import org.tribot.api2007.*;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSCharacter;
import org.tribot.api2007.types.RSNPC;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.util.Node;
import static org.tribot.api.General.println;
import static org.tribot.api.General.random;
import static org.tribot.api.General.sleep;
import static scripts.util.Character.hasMetSkillReqs;
import static scripts.util.Locations.FALADORE_CHICKENS_SOUTH;
import static scripts.util.Logger.SLAVE_SKILL_START;
import static scripts.util.NPC.NPC_Chicken;

public class SkillReqNode extends Node
{

    @Override
    public void execute()
    {

        println(SLAVE_SKILL_START);

        // check location - walk to it if required.
        CheckLocation();

        // Checks the level - sets corrct attack stance.
        LevelCheck();
    }

    private void LevelCheck()
    {
        /*
            this handles checking what level needs to be worked on
            and sets the correct one.
         */


        if(Skills.getActualLevel(Skills.SKILLS.ATTACK)  < 10)
        {
            println("[*] ATTACK < 10 detected. ");
            if(Combat.getSelectedStyleIndex() != 0)
            {
                println("[!] Setting Attack Stance");
                Combat.selectIndex(0);
            }
            println("[*] Killing Chicken using ATTACK Stance. ");
            while(Skills.getActualLevel(Skills.SKILLS.ATTACK)  < 10)
            {
                KillChicken();
                sleep(20,50);
            }

        }
        if(Skills.getActualLevel(Skills.SKILLS.STRENGTH) < 10)
        {
            println("[*] STRENGTH < 10 detected. ");
            if(Combat.getSelectedStyleIndex() != 1)
            {
                println("[!] Setting Strength Stance");
                Combat.selectIndex(1);
            }
            println("[*] Killing Chicken using STRENGTH Stance. ");
            while(Skills.getActualLevel(Skills.SKILLS.STRENGTH)  < 10)
            {
                KillChicken();
                sleep(20,50);
            }

        }
        if(Skills.getActualLevel(Skills.SKILLS.DEFENCE)  < 5)
        {
            println("[*] DEFENCE < 5 detected. ");
            if(Combat.getSelectedStyleIndex() != 2)
            {
                println("[!] Setting Defence Stance");
                Combat.selectIndex(2);
            }
            println("[*] Killing Chicken using DEFENCE Stance. ");
            while(Skills.getActualLevel(Skills.SKILLS.DEFENCE)  < 5)
            {
                KillChicken();
                sleep(20,50);
            }
        }

    }

    private void KillChicken()
    {
        if(!Combat.isUnderAttack())
        {
            println("[*] looking for a target");
            RSNPC[] Chickens = NPCs.findNearest(Filters.NPCs.nameContains(NPC_Chicken));

            if (Chickens[0] != null && !Chickens[0].isOnScreen() && Chickens[0].getPosition() != null || !Chickens[0].isClickable())
            {
                println("[*] looking towards chicken ");
                Camera.setCameraRotation(General.random(75, 110));
                Camera.setCameraAngle(General.random(68, 90));
                Camera.turnToTile(Chickens[0].getPosition());
            }
            if (!Chickens[0].isInCombat() && Chickens[0] != null && Chickens[0].isClickable())
            {
                println("[*] clicking chicken ");

                Chickens[0].getModel().click();
                sleep(1907, 2901);
            }
            else
            {
                println("[*] Closest chicken already in combat, looking for another.. ");
                sleep(300,700);

                // use this time to set run on at a seamingly random time
                if (Game.getRunEnergy() >= random(5, 17) && !Options.isRunEnabled())
                {
                    println("[*] Turning on RUN ");
                    Options.setRunOn(true);
                }
            }


        }
        if((Combat.isUnderAttack()))
        {
            println("[*] Player is in combat ");

            RSCharacter[] chickens = Combat.getAttackingEntities();

            if (chickens[0] != null)
            {
                Double currentChickensHealth = chickens[0].getHealthPercent();

                if(currentChickensHealth > 0 && currentChickensHealth != null && chickens[0] != null)
                {
                    println("[*] Targets health is: " + chickens[0].getHealthPercent());
                    println("[*] re-clicking target");
                    chickens[0].getModel().click();
                    sleep(900, 3000);
                }
            }



        }

    }

    private void CheckLocation()
    {
        // walk to correct location
        if(!FALADORE_CHICKENS_SOUTH.contains(Player.getPosition()))
        {
            println("[!] Walking to Chickens");
            DaxWalker.walkTo(FALADORE_CHICKENS_SOUTH.getRandomTile());
        }
    }

    @Override
    public boolean validate()
    {
        return hasMetSkillReqs();
    }


}
