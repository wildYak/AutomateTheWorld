//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package scripts;

import org.tribot.api2007.Login;
import org.tribot.api2007.Login.STATE;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import scripts.dax_api.dax_auth;
import scripts.master.MasterNodeManager;
import scripts.slave.SlaveNodeManager;

import static scripts.util.Locations.buildAllLocations;

@ScriptManifest(
        authors = {"ATW"},
        name = "ATW-HideFlipper",
        category = "ATW-BOTFARM"
)
public class HideFlipper extends Script {
    Boolean isMaster = false;
    Boolean isSlave = true;
    
    public HideFlipper() {
    }
    
    public void run() {
        while(Login.getLoginState() != STATE.INGAME) {
            this.println("[*] Detected NOT INGAME, sleeping for a bit...");
            this.sleep(1000, 4000);
        }
        
        if (Login.getLoginState() == STATE.INGAME) {
            this.println("[*] Detected INGAME STATE has been set.");
            dax_auth.dax_auth(); // Auth daxwalker API
            buildAllLocations(); // Build all locations to be used in scripts
            if (this.isMaster) {
                MasterNodeManager masterNodeManager = new MasterNodeManager();
                masterNodeManager.run();
            }
            
            if (this.isSlave) {
                SlaveNodeManager slaveNodeManager = new SlaveNodeManager();
                slaveNodeManager.run();
            }
        }
        
    }
}
