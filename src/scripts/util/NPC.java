//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package scripts.util;

import org.tribot.api.General;
import org.tribot.api2007.NPCChat;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NPC {
    public static final String NPC_COW = "Cow";
    public static final String NPC_COW_BABY = "Cow Calf";
    public static final String NPC_Chicken = "Chicken";
    public static final Set<String> NPC_FARM_ANIMALS = new HashSet(Arrays.asList("Cow", "Cow Calf"));
    public static final String TUT_ISLAND_GUIDE = "Gielinor Guide";

    //Fred the farmer
    public static final String FRED_CHAT1_CONTENT = "What are you doing on my land? You're not the one who keeps leaving all my gates open and letting out all my sheep are you?";
    public static final String FRED_CHAT1_ANSWER = "I'm looking for a quest.";

    public static boolean isNPCChatOpen()
    {
        if(NPCChat.getName() == null && NPCChat.getClickContinueInterface() == null && NPCChat.getSelectOptionInterface() == null)
        {
            General.println("Chat is not open");
            return false;
        }
        else
        {
            General.println("Chat is open");
            return true;
        }
    }
    public static boolean isNPCChatMessageType()
    {
        if(isNPCChatOpen() && NPCChat.getMessage() != null)
        {
            General.println("Chat is a message type chat window");
            return true;
        }
        else
        {
            General.println("Chat is not a Message type chat window");
            return false;
        }
    }
    public static boolean isNPCChatOptionsType()
    {
        if(isNPCChatOpen() && NPCChat.getSelectOptionInterface() != null)
        {
            General.println("Chat is a Option type chat window");
            return true;
        }
        else
        {
           
            General.println("Chat is not a Option type chat window");
            return false;
        }
    }
    public static void clickNPCCHatContinue()
    {
        if(isNPCChatOpen() && NPCChat.getClickContinueInterface() != null)
        {
            General.println("Found Continue Button, clicking continue");
            NPCChat.clickContinue(true);
        }
        else
        {
            General.println("Chat has closed or continue button cannot be found.");
        }
    }
    public static String getNPCChatMessage()
    {
        String cookChat;
        if(isNPCChatMessageType())
        {
            General.println("[*] Getting message from message type chat");
            cookChat = NPCChat.getMessage().toLowerCase();
            return cookChat;
        }
        else
        {
            return "Cannot read NPC Message";
        }
    }
    public static String[] getNPCCHatOptions()
    {
        General.println("1");
        String[] notFound = new String[1];
        notFound[0] = "Options not found";
        if(isNPCChatOptionsType())
        {
            General.println("[*] Number of Options Found:"+NPCChat.getOptions().length);
            String[] options = NPCChat.getOptions();
            return options;
        }
        else
        {
            General.println("Chat has closed or option menu not open.");
            return notFound;
        }
    }
    public static boolean doesNPCChatOptionsContain(String optionString ,String[] options)
    {
        boolean optionMatch = false;
        General.println("Checking Options!");
        for(String option : options)
        {
            if(optionString.toLowerCase().contains(option.toLowerCase()))
            {
                General.println("Option match found");
                return true;
            }
        }
        if(optionMatch != true)
        {
            General.println("No Matching Option match found");
        }
        return false;
    }
    
    public static void clickNPC(String npcName)
    {
        RSNPC[] npc = NPCs.find(npcName);
        if(npc.length > 0)
        {
            General.println("Found NPC: "+npcName);
            if(!isNPCChatOpen())
            {

                General.println("Clicking NPC: "+npcName);
                npc[0].click();
                General.sleep(1900, 2600);
            }
        }
        else
        {
            General.println("Cannot Find NPC: "+npcName);
        }
    }
}
