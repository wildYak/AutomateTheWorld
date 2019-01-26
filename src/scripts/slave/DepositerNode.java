package scripts.slave;

/*
    This script handles Depositing the goods / exchanging goods for currency
 */



import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;

import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.util.Node;

import java.util.Random;

import static org.tribot.api.General.println;
import static org.tribot.api.General.sleep;
import static org.tribot.api2007.Banking.*;
import static scripts.util.Character.*;
import static scripts.util.Coms.isMasterCalling;
import static scripts.util.Items.BRONZE_SCIMITAR;
import static scripts.util.Items.RIMMINGTON_SCIMITAR_STAIRCASE_UPSTAIRS;
import static scripts.util.Locations.*;
import static scripts.util.Logger.SLAVE_DEP_START;

public class DepositerNode extends Node
{

    @Override
    public void execute()
    {
        println(SLAVE_DEP_START);
        while ((!isMasterCalling() && Inventory.isFull()))
        {
            if (!isInBank())
            {
                println(("[*] Not in bank, walking to bank"));
                walkToNearestBank();
            }
            else
            {
                println(("[*] You are inside bank"));
                sleep(100, 230);
                depositAllItems();
            }
        }
        println(("[*] Exiting Depositor"));
    }
    @Override
    public boolean validate() { return isInventoryFull(); }
}
