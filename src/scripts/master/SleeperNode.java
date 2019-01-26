package scripts.master;

import scripts.util.Node;

/*
    This script handles what happens in the sleep intervals.
    While the Slaves are farming, this script handles making sure the Master is either logged out
    Or logged in being productive in some manner. (mostly probably logged out)

    Script also handles logging back in and resuming nodes.
 */
public class SleeperNode extends Node {


    @Override
    public void execute() {

    }

    @Override
    public boolean validate() {
        return false;
    }
}
