package scripts.quests;

import org.tribot.api.General;
import org.tribot.api2007.NPCChat;
import org.tribot.api2007.types.RSInterfaceMaster;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.util.Node;

import static scripts.util.Character.inRSArea;
import static scripts.util.Character.walkToRSArea;
import static scripts.util.Locations.*;
import static scripts.util.NPC.*;
import static scripts.util.Quests.*;
import static scripts.util.Logger.*;

public class CooksAssistantNode extends Node
{



    @Override
    public void execute()
    {
        General.println(COOKSASSISTANT_ONSTART);
        String preReqItem;
        String questName = "Cook's Assistant";
        while(questStatus(questName) != "Complete")
        {
            if(questStatus(questName) == "Not Started")
            {
                General.println("Quest has not been started");
                if(!inRSArea(LUMBY_CASTLE_KITCHEN))
                {
                    General.println("Not in kitchen, walking to kitchen to start quest");
                    walkToRSArea(LUMBY_CASTLE_KITCHEN);
                }
                if(inRSArea(LUMBY_CASTLE_KITCHEN))
                {
                    clickNPC("Cook");
                }
                if(inRSArea(LUMBY_CASTLE_KITCHEN) && isNPCChatOpen())
                {
                    String cookChat;
                    String[] cookOptions;
                    boolean optionMatch;
                    General.println("in kitchen with chat open");
                    if(isNPCChatMessageType())
                    {
                        cookChat = getNPCChatMessage();
                        if(cookChat != null)
                        {
                            clickNPCCHatContinue();
                        }
                    }
                    if(isNPCChatOptionsType())
                    {
                        cookOptions = getNPCCHatOptions();
                        if(cookOptions.length > 0 && cookOptions[0] != null) // if the chat options are valid
                        {
                            
                            General.println("legit options found");
                            if(doesNPCChatOptionsContain(COOK_OPTION_1,cookOptions))
                            {
                                General.println("option one found");
                                NPCChat.selectOption(COOK_OPTION_1,true);
                            }
                            else if(doesNPCChatOptionsContain(COOK_OPTION_2,cookOptions))
                            {
                                General.println("option two found");
                                NPCChat.selectOption(COOK_OPTION_2,true);
                            }
                            else
                            {
                                General.println("No matches found");
                            }
                        }
                    }
                    
                }
            }
            else if (questStatus(questName) == "In Progress")
            {
                General.println("Quest is currently in progess");
                if(questPreReqItemsObtained(questName))
                {
                    General.println("All Pre-req items for COOKS ASSISTANT Obtained");
                    collectGrain();
                    collectFlour();
                    collectMilk();
                }
                else
                {
                    General.println("Still require some prerequisite items for the quest");
                    preReqItem = getQuestPreReqItem(questName,"random");
                    pickupPreReqQuestItem(preReqItem);
                }

            }
            General.sleep(600, 1300);
        }
    }

    @Override
    public boolean validate()
    {
        if(questStatus("Cook's Assistant") != "Complete")
        {
            return true;
        }
        return false;
    }
}