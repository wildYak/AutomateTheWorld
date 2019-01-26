package scripts.slave;

import org.tribot.api.General;
import org.tribot.script.Script;
import scripts.dax_api.shared.helpers.questing.Quest;
import scripts.util.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static scripts.util.Logger.SLAVE_ONSTART;

/*
    This script handles instantiating the Slave nodes
 */


public class SlaveNodeManager extends Script {

    private final List<Node> nodes = new ArrayList<>();
    @Override
    public void run() {


        println(SLAVE_ONSTART);
        Collections.addAll(nodes,
                new TutNode(),
                new QuestNode(),
                new WeaponReqNode(),
                new InventoryManagerNode(),
                new SkillReqNode(),
                new ExporterNode(),
                new DepositerNode(),
                new GathererNode());
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
