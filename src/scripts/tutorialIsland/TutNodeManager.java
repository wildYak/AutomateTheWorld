package scripts.tutorialIsland;

import org.tribot.api.General;
import org.tribot.script.Script;
import scripts.util.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static scripts.util.Logger.SLAVE_TUT_START;

public class TutNodeManager extends Script {

    private final List<Node> nodes = new ArrayList<>();
    @Override
    public void run() {


        println(SLAVE_TUT_START);

        Collections.addAll(nodes,
                new CharSelectorNode());

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
