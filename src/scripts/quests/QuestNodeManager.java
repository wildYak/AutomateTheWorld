package scripts.quests;

import org.tribot.api.General;
import org.tribot.script.Script;
import scripts.util.Node;
import scripts.util.Quests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static scripts.util.Logger.QUEST_START;

/*
    This script handles instantiating the Slave nodes
 */


public class QuestNodeManager extends Script {

    private final List<Node> nodes = new ArrayList<>();
    @Override
    public void run() {
        println(QUEST_START);
        Collections.addAll(nodes,
                new CooksAssistantNode(),
                new SheepShearerNode(),
                new RomeoAndJulietNode());
        loop(21, 44);
    }

    private void loop(int min, int max) {
        while (true) {
            for (final Node node : nodes) {
                if (node.validate()) {
                    node.execute();
                    sleep(General.random(min, max));
                }
            }
        }
    }

}
