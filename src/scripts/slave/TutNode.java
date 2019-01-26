package scripts.slave;

/*
    This script handles Solving tutorial island
 */


import org.tribot.api2007.Player;
import scripts.tutorialIsland.TutNodeManager;
import scripts.util.Node;

import static scripts.util.Locations.TUTORIAL_ISLAND;

public class TutNode extends Node{

    @Override
    public void execute() {

        TutNodeManager tutNodeManager = new TutNodeManager();
        tutNodeManager.run();
    }

    @Override
    public boolean validate() {
        return (TUTORIAL_ISLAND.contains(Player.getPosition()));
    }

}
