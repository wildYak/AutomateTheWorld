package scripts.quests;

import scripts.util.Node;

import static scripts.util.Quests.questStatus;

public class RomeoAndJulietNode extends Node
{
    @Override
    public void execute()
    {

    }

    @Override
    public boolean validate()
    {
        if(questStatus("Romeo & Juliet") != "Complete")
        {
            return true;
        }
        return false;
    }
}