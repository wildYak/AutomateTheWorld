package scripts.master;

import org.tribot.api.General;
import org.tribot.script.Script;
import scripts.util.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static scripts.util.Logger.MASTER_ONSTART;

/*
    This script handles instantiating the Master Nodes
 */

public class MasterNodeManager extends Script {
    private final List<Node> nodes = new ArrayList<>();
    @Override
    public void run() {
        println(MASTER_ONSTART);
        Collections.addAll(nodes,
                new SleeperNode(),
                new ImporterNode(),
                new CallerNode());
        loop(20, 41);
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