package scripts.tutorialIsland;


import scripts.util.Node;

import static org.tribot.api.General.sleep;
import static scripts.util.Character.inRSArea;
import static scripts.util.Locations.TUTORIAL_ISLAND_ACC_CREATOR;


public class CharSelectorNode extends Node {
    @Override
    public void execute()
    {


    }




    @Override
    public boolean validate()
    {
        //return true if is in account creation RS area
        return inRSArea(TUTORIAL_ISLAND_ACC_CREATOR);
    }
}
