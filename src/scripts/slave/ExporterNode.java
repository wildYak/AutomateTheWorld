package scripts.slave;


/*
    This script handles exporting the goods to the Master
 */

import scripts.util.Node;

import static org.tribot.api.General.println;
import static scripts.util.Coms.isMasterCalling;
import static scripts.util.Logger.SLAVE_EXP_START;

public class ExporterNode extends Node {

    @Override
    public void execute() {
        println(SLAVE_EXP_START);
        while(isMasterCalling()){
            // go to master while master is calling
            // when this returns false, we are good to finish and return to nodes
            // isMasterCalling needs to be set back to false after we have visited
            // or this wont work properly
        }
    }

    @Override
    public boolean validate() {
        return isMasterCalling();
    }
}
