package scripts.quests;

import scripts.util.Node;

import static scripts.util.Quests.questStatus;

public class SheepShearerNode extends Node
{



    @Override
    public void execute()
    {

    }

    @Override
    public boolean validate()
    {
        if(questStatus("Sheep Shearer") != "Complete")
        {
            return true;
        }
        return false;
    }
}