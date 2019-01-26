package scripts.slave;

/*
    This script handles Solving tutorial island
 */


import scripts.quests.QuestNodeManager;
import scripts.util.Node;

import static scripts.util.Quests.questPointsMet;

public class QuestNode extends Node{

    @Override
    public void execute() {

        QuestNodeManager questNodeManager = new QuestNodeManager();
        questNodeManager.run();
    }

    @Override
    public boolean validate() {return !questPointsMet();}

}
