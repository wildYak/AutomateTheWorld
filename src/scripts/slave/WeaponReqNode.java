//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package scripts.slave;

import org.tribot.api.General;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;
import scripts.util.Coms;
import scripts.util.Node;

import static org.tribot.api.General.println;
import static org.tribot.api.General.sleep;
import static scripts.util.Character.*;
import static scripts.util.Items.RIMMINGTON_SCIMITAR_STAIRCASE_UPSTAIRS;
import static scripts.util.Locations.RIMMINGTON_SCIMITARS_LOOTAREA;
import static scripts.util.Logger.SLAVE_WEP_START;

public class WeaponReqNode extends Node {
    
    public void execute()
    {
        println(SLAVE_WEP_START);
        while((!Coms.isMasterCalling() && !isWieldingWeapon()) || (!Coms.isMasterCalling()  && RIMMINGTON_SCIMITARS_LOOTAREA.contains(Player.getPosition())))
        {
            println("[*] Havent got weapon yet or still upstairs at loot area");
            if(isWieldingWeapon() && RIMMINGTON_SCIMITARS_LOOTAREA.contains(Player.getPosition()))
            {
                println("[*] In loot area and have collected required amount of scimmies");
                RSObject[] rimmingtonScimmyStaircaseUpstairs = Objects.findNearest(20, RIMMINGTON_SCIMITAR_STAIRCASE_UPSTAIRS);
                if (rimmingtonScimmyStaircaseUpstairs.length > 0)
                {
                    println("[*] Clicking upstairs staircase");
                    rimmingtonScimmyStaircaseUpstairs[0].click();
                    General.sleep(1200, 2600);
                }
            }
            if(hasItemInInventory("Bronze scimitar",1))
            {
                equipItem("Bronze scimitar");
            }
            else
            {
                getScimmies(1);
            }
            sleep(600, 1800);
        }
    }
    
    public boolean validate() {return !isWieldingWeapon(); }
}
