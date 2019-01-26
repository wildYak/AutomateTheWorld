//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package scripts.util.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSInterface;
import org.tribot.api2007.types.RSNPC;

import static org.tribot.api.General.println;
import static org.tribot.api.General.sleep;
import static scripts.util.NPC.TUT_ISLAND_GUIDE;
import static scripts.util.NameGenerator.GenerateDisplayname;

public class InterfaceTutIsland {
    public static final int ACCOUNT_DESIGN_ACCEPT_M = 269;
    public static final int ACCOUNT_DESIGN_ACCEPT_C = 100;
    public static final int ACCOUNT_DESIGN_FEMALE_M = 269;
    public static final int ACCOUNT_DESIGN_FEMALE_C = 35;
    public static final int ACCOUNT_DESIGN_MALE_M = 269;
    public static final int ACCOUNT_DESIGN_MALE_C = 138;
    public static final int ACCOUNT_DESIGN_HEAD_LEFT_M = 269;
    public static final int ACCOUNT_DESIGN_HEAD_LEFT_C = 106;
    public static final int ACCOUNT_DESIGN_HEAD_RIGHT_M = 269;
    public static final int ACCOUNT_DESIGN_HEAD_RIGHT_C = 113;
    public static final int ACCOUNT_DESIGN_JAW_LEFT_M = 269;
    public static final int ACCOUNT_DESIGN_JAW_LEFT_C = 107;
    public static final int ACCOUNT_DESIGN_JAW_RIGHT_M = 269;
    public static final int ACCOUNT_DESIGN_JAW_RIGHT_C = 114;
    public static final int ACCOUNT_DESIGN_TORSO_LEFT_M = 269;
    public static final int ACCOUNT_DESIGN_TORSO_LEFT_C = 108;
    public static final int ACCOUNT_DESIGN_TORSO_RIGHT_M = 269;
    public static final int ACCOUNT_DESIGN_TORSO_RIGHT_C = 115;
    public static final int ACCOUNT_DESIGN_ARMS_LEFT_M = 269;
    public static final int ACCOUNT_DESIGN_ARMS_LEFT_C = 109;
    public static final int ACCOUNT_DESIGN_ARMS_RIGHT_M = 269;
    public static final int ACCOUNT_DESIGN_ARMS_RIGHT_C = 116;
    public static final int ACCOUNT_DESIGN_HANDS_LEFT_M = 269;
    public static final int ACCOUNT_DESIGN_HANDS_LEFT_C = 110;
    public static final int ACCOUNT_DESIGN_HANDS_RIGHT_M = 269;
    public static final int ACCOUNT_DESIGN_HANDS_RIGHT_C = 117;
    public static final int ACCOUNT_DESIGN_LEGS_LEFT_M = 269;
    public static final int ACCOUNT_DESIGN_LEGS_LEFT_C = 111;
    public static final int ACCOUNT_DESIGN_LEGS_RIGHT_M = 269;
    public static final int ACCOUNT_DESIGN_LEGS_RIGHT_C = 118;
    public static final int ACCOUNT_DESIGN_FEET_LEFT_M = 269;
    public static final int ACCOUNT_DESIGN_FEET_LEFT_C = 112;
    public static final int ACCOUNT_DESIGN_FEET_RIGHT_M = 269;
    public static final int ACCOUNT_DESIGN_FEET_RIGHT_C = 119;
    public static final int ACCOUNT_DESIGN_HAIR_LEFT_M = 269;
    public static final int ACCOUNT_DESIGN_HAIR_LEFT_C = 105;
    public static final int ACCOUNT_DESIGN_HAIR_RIGHT_M = 269;
    public static final int ACCOUNT_DESIGN_HAIR_RIGHT_C = 121;
    public static final int ACCOUNT_DESIGN_TORSO_LEFT_COLOR_M = 269;
    public static final int ACCOUNT_DESIGN_TORSO_LEFT_COLOR_C = 123;
    public static final int ACCOUNT_DESIGN_TORSO_RIGHT_COLOR_M = 269;
    public static final int ACCOUNT_DESIGN_TORSO_RIGHT_COLOR_C = 127;
    public static final int ACCOUNT_DESIGN_LEGS_LEFT__COLOR_M = 269;
    public static final int ACCOUNT_DESIGN_LEGS_LEFT_COLOR_C = 124;
    public static final int ACCOUNT_DESIGN_LEGS_RIGHT_COLOR_M = 269;
    public static final int ACCOUNT_DESIGN_LEGS_RIGHT_COLOR_C = 129;
    public static final int ACCOUNT_DESIGN_FEET_LEFT_COLOR_M = 269;
    public static final int ACCOUNT_DESIGN_FEET_LEFT_COLOR_C = 122;
    public static final int ACCOUNT_DESIGN_FEET_RIGHT_COLOR_M = 269;
    public static final int ACCOUNT_DESIGN_FEET_RIGHT_COLOR_C = 130;
    public static final int ACCOUNT_DESIGN_SKIN_LEFT_COLOR_M = 269;
    public static final int ACCOUNT_DESIGN_SKIN_LEFT_COLOR_C = 125;
    public static final int ACCOUNT_DESIGN_SKIN_RIGHT_COLOR_M = 269;
    public static final int ACCOUNT_DESIGN_SKIN_RIGHT_COLOR_C = 131;
    
    public static Boolean isDisplayMenuOpen()
    {
        RSInterface intfa = Interfaces.get(558, 5);
        return intfa != null && !intfa.isHidden();
    }
    
    public static Boolean ischarBuilderMenuOpen()
    {
        RSInterface intfa = Interfaces.get(269, 97);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("Use the buttons below to design your player");
    }
    
    public static Boolean isAvailbleTextOnscreen()
    {
        RSInterface intfa = Interfaces.get(558, 12);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("Great!");
    }
    
    public static Boolean shouldTalkToGuide()
    {
        RSInterface intfa = Interfaces.get(263, 1, 0);
        return intfa != null && !intfa.isHidden()
                             && intfa.getText().contains("When you're ready to get started, click on the Gielinor Guide.")
                             || intfa.getText().contains("Before you Begin, have a read through the controls");
    }
    
    public static Boolean shouldTalkToGuideGreetings()
    {
        RSInterface intfa = Interfaces.get(231, 4);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("Greetings!");
    }
    
    public static Boolean shouldTalkToGuideTTOP()
    {
        RSInterface intfa = Interfaces.get(231, 4);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("talking to other people!");
    }
    
    public static Boolean shouldTalkToGuideInhabitants()
    {
        RSInterface intfa = Interfaces.get(231, 4);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("You will find many inhabitants");
    }
    
    public static Boolean shouldTalkToGuideExperience()
    {
        RSInterface intfa = Interfaces.get(231, 4);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("how much experience");
    }
    
    public static Boolean shouldTalkToGuideChosenAnswer()
    {

        RSInterface intfa = Interfaces.get(229, 1);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("simply click your chosen answer");
    }

    public static Boolean shouldSelectGameExpLevel()
    {
        RSInterface intfa = Interfaces.get(219, 1, 0);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("What's your experience with Old School Runescape?");
    }

    public static Boolean shouldTalkToGuideIAmExp()
    {
        RSInterface intfa = Interfaces.get(217, 4);
        return intfa != null && !intfa.isHidden() && intfa.getText().contains("I am an experienced player.");
    }
    
    public static void clickDisplayMenuOpen()
    {
        RSInterface intfa = Interfaces.get(558, 7);
        if (intfa != null && !intfa.isHidden()) {
            intfa.hover();
            General.sleep(70, 790);
            intfa.click(new String[0]);
        }
        
    }
    
    public static void clickLookupName()
    {
        RSInterface intfa = Interfaces.get(558, 17, 9);
        if (intfa != null && !intfa.isHidden()) {
            intfa.hover();
            General.sleep(70, 790);
            intfa.click(new String[0]);
        }
        
    }
    
    public static void clickSetName()
    {
        RSInterface intfa = Interfaces.get(558, 18, 9);
        if (intfa != null && !intfa.isHidden()) {
            intfa.hover();
            General.sleep(70, 790);
            intfa.click(new String[0]);
        }
        
    }
    
    public static void ClickAcceptButton()
    {
        RSInterface intfa = Interfaces.get(269, 100);
        if (intfa != null && !intfa.isHidden()) {
            intfa.hover();
            General.sleep(600, 1320);
            intfa.click();
            General.println("Looking swag - lets go!");
            General.sleep(5000L);
        }
        
    }
    
    private static void clickInterfaceButton(RSInterface intfa)
    {
        intfa.hover();
        General.sleep(99, 999);
        intfa.click();
    }

    public static void findAndSelectExperiencedButton()
    {
        String textToSend  = "I am an experienced player.";
        String successText = "[*] found and selected experienced player!";
        String wrongText   = "[-] wrong text found in this slot - trying another";

        // attempt to find correct choice in first slot
        try
        {
            pressTextButtonToContinue(219, 1, 1, textToSend);
            println(successText);
        }
        catch(Exception e)
        {
            println(wrongText);

            // attempt to find correct choice in second slot
            try
            {
                pressTextButtonToContinue(219, 1, 2, textToSend);
                println(successText);
            }
            catch(Exception e2)
            {
                println(wrongText);

                // attempt to find correct choice in third slot
                try
                {
                    pressTextButtonToContinue(219, 1, 3, textToSend);
                    println(successText);
                }
                catch(Exception e3)
                {
                    println(wrongText);
                }
            }
        }
    }

    public static void pressContinueButton(int index, int child)
    {

        RSInterface intfa = Interfaces.get(index, child);
        if (intfa != null && !intfa.isHidden()) {
            General.println("Pressing continue...");
            intfa.hover();
            General.sleep(411, 1399);
            intfa.click();
            General.sleep(1700,5000);
        }
    }

    public static void pressTextButtonToContinue(int index, int child, int component, String textOnscreen)
    {
        RSInterface intfa = Interfaces.get(index, child, component);

        if (intfa != null && !intfa.isHidden()) {
            General.println(textOnscreen);
            intfa.hover();
            General.sleep(477, 1512);
            intfa.click();
            General.sleep(900,3912);
        }
    }

    public static void GenerateAccountDesign()
    {
        RSInterface FEMALE_BUTTON = Interfaces.get(269, 35);
        RSInterface MALE_BUTTON = Interfaces.get(269, 138);
        RSInterface HEAD_BUTTON_L = Interfaces.get(269, 106);
        RSInterface HEAD_BUTTON_R = Interfaces.get(269, 113);
        RSInterface JAW_BUTTON_L = Interfaces.get(269, 107);
        RSInterface JAW_BUTTON_R = Interfaces.get(269, 114);
        RSInterface TORSO_BUTTON_L = Interfaces.get(269, 108);
        RSInterface TORSO_BUTTON_R = Interfaces.get(269, 115);
        RSInterface ARMS_BUTTON_L = Interfaces.get(269, 109);
        RSInterface ARMS_BUTTON_R = Interfaces.get(269, 116);
        RSInterface HANDS_BUTTON_L = Interfaces.get(269, 110);
        RSInterface HANDS_BUTTON_R = Interfaces.get(269, 117);
        RSInterface LEGS_BUTTON_L = Interfaces.get(269, 111);
        RSInterface LEGS_BUTTON_R = Interfaces.get(269, 118);
        RSInterface FEET_BUTTON_L = Interfaces.get(269, 112);
        RSInterface FEET_BUTTON_R = Interfaces.get(269, 119);
        RSInterface HAIR_BUTTON_L = Interfaces.get(269, 105);
        RSInterface HAIR_BUTTON_R = Interfaces.get(269, 121);
        RSInterface TORSO_CBUTTON_L = Interfaces.get(269, 123);
        RSInterface TORSO_CBUTTON_R = Interfaces.get(269, 127);
        RSInterface LEGS_CBUTTON_L = Interfaces.get(269, 124);
        RSInterface LEGS_CBUTTON_R = Interfaces.get(269, 129);
        RSInterface FEET_CBUTTON_L = Interfaces.get(269, 122);
        RSInterface FEET_CBUTTON_R = Interfaces.get(269, 130);
        RSInterface SKIN_BUTTON_L = Interfaces.get(269, 125);
        RSInterface SKIN_BUTTON_R = Interfaces.get(269, 131);
        List<RSInterface> buttonList = Arrays.asList(HEAD_BUTTON_L, HEAD_BUTTON_R, JAW_BUTTON_L, JAW_BUTTON_R, TORSO_BUTTON_L, TORSO_BUTTON_R, ARMS_BUTTON_L, ARMS_BUTTON_R, HANDS_BUTTON_L, HANDS_BUTTON_R, LEGS_BUTTON_L, LEGS_BUTTON_R, FEET_BUTTON_L, FEET_BUTTON_R, HAIR_BUTTON_L, HAIR_BUTTON_R, TORSO_CBUTTON_L, TORSO_CBUTTON_R, LEGS_CBUTTON_L, LEGS_CBUTTON_R, FEET_CBUTTON_L, FEET_CBUTTON_R, SKIN_BUTTON_L, SKIN_BUTTON_R, FEMALE_BUTTON, MALE_BUTTON);
        Random r = new Random();
        int low = 18;
        int high = 37;
        int characterMods = r.nextInt(high - low) + low;
        int charMods = characterMods;
        Random rand = new Random();
        
        for(int i = 0; i < charMods; ++i) {
            int randomIndex = rand.nextInt(buttonList.size());
            RSInterface selectedButton = (RSInterface)buttonList.get(randomIndex);
            clickInterfaceButton(selectedButton);
        }
        
    }

    public static void talkToGuide()
    {
        RSNPC[] guide = NPCs.findNearest(TUT_ISLAND_GUIDE);

        // if guide is not onscreen
        if (guide[0] != null && !guide[0].isOnScreen() && guide[0].getPosition() != null || !guide[0].isClickable())
        {
            println("[*] looking towards guide ");

            Camera.setCameraRotation(General.random(75, 110));
            Camera.setCameraAngle(General.random(71, 97));
            Camera.turnToTile(guide[0].getPosition());

        }

        // if guide is onscreen
        if (guide[0] != null && guide[0].isOnScreen() && guide[0].getPosition() != null && guide[0].isClickable())
        {
            println("[*] looking towards guide ");

            Camera.setCameraRotation(General.random(75, 110));
            Camera.setCameraAngle(General.random(71, 97));
            Camera.turnToTile(guide[0].getPosition());

            guide[0].getModel().click();
            sleep(1200,2200);

        }



    }

    public static void registerDisplayName()
    {

        // open name selecter typeing interface
        clickDisplayMenuOpen();
        sleep(900,1600);

        // type displayname
        String dn = GenerateDisplayname();
        println("Attempting generated DisplayName: " + dn);

        // type name
        Keyboard.typeString(GenerateDisplayname());
        sleep(800,1322);
        Keyboard.pressEnter();
        sleep(1001,5005);

        // click lookup name
        clickLookupName();
        sleep(2000,6000);

        if(isAvailbleTextOnscreen())
        {
            clickSetName();
            println("Name Set! : " + dn);
            sleep(900,1200);

        }




    }
}
