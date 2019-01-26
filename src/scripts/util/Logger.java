//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package scripts.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public static final String SLAVE_ONSTART = "[*] Slave selected, building slave nodes.";
    public static final String SLAVE_DEP_START = "[*] Slave node 'Depositor' has started.";
    public static final String SLAVE_EXP_START = "[*] Slave node 'Exporter' has started.";
    public static final String SLAVE_GAT_START = "[*] Slave node 'Gatherer' has started.";
    public static final String SLAVE_TUT_START = "[*] Slave node 'Tutorial Island' has started.";
    public static final String SLAVE_SKILL_START = "[*} Slave Node 'Skill Reqs' has started.";
    public static final String SLAVE_WEP_START = "[*} Slave Node 'Weapon Reqs' has started.";
    public static final String SLAVE_INVMAN_START = "[*} Slave Node 'Inventory Manager' has started.";
    public static final String MASTER_ONSTART = "[*] Master selected, building master nodes.";
    public static final String GENERAL_INGAME_SET = "[*] Detected INGAME STATE has been set.";
    public static final String GENERAL_INGAME_NOTSET = "[*] Detected NOT INGAME, sleeping for a bit...";

    //QUESTS
    public static final String QUEST_START = "[*] Quests selected, building quest nodes";
    public static final String COOKSASSISTANT_ONSTART = "[*] Quests node 'Cook's Assistant' has started.";
    public static final String SHEEPSHEARER_ONSTART = "[*] Quests node 'Sheep Shearer' has started.";
    public static final String ROMEOANDJULIET_ONSTART = "[*] Quests node 'Romeo & Juliet' has started.";
    public Logger() {
    }
    
    public static void WriteLog(String data) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String formatedDate = formatter.format(date);
            File f1 = new File("%APPDATA%\\.tribot\\bin\\scripts\\logging\\" + formatedDate.replace("\\", "-") + ".txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }
            
            FileWriter fileWritter = new FileWriter(f1.getName(), true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(data);
            bw.close();
            System.out.println("Done");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        
    }
}
