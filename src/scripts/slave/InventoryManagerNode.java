package scripts.slave;

import org.tribot.api.General;
import org.tribot.api2007.Inventory;
import scripts.util.Node;

import static org.tribot.api.General.sleep;
import static scripts.util.Character.cleanseInventory;
import static scripts.util.Character.hasBlacklistedItems;
import static scripts.util.Coms.isMasterCalling;
import static scripts.util.Logger.SLAVE_INVMAN_START;

public class InventoryManagerNode extends Node
{
    public void execute()
    {
        General.println(SLAVE_INVMAN_START);
        while ((!isMasterCalling() && !hasBlacklistedItems()))
        {
            cleanseInventory();
            sleep(600, 1800);
        }
    }

    public boolean validate()
    {
        return hasBlacklistedItems();
    }
}