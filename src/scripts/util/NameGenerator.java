package scripts.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.tribot.api.General.println;

public class NameGenerator {

    final static String[] Nouns= {
            "apeno",
            "anah",
            "serra",
            "nero",
            "TV",
            "box",
            "cboard",
            "jer",
            "spud",
            "phone",
            "zero",
            "hero",
            "pika",
            "yuna",
            "aeon",
            "main",
            "man",
            "teac",
            "divie",
            "baneo",
            "bart",
            "vamp",
            "jarrod",
            "sam",
            "mage",
            "magic",
            "ned",
            "plage",
            "plain",
            "plane",
            "sync",
            "march",
            "july",
            "bingo",
            "jason",
            "Garry"
    };


    final static String[] Adjectives= {
            "Alpha",
            "shiny",
            "hung",
            "nice",
            "angry",
            "sweet",
            "just",
            "my",
            "his",
            "wet",
            "dry",
            "shy",
            "wrong",
            "hot",
            "sad",
            "wrong",
            "not",
            "che-",
            "be",
            "late",
            "cold",
            "dark",
            "light",
            "shaky",
            "bri",
            "notmy",
            "swag",
            "filth",
            "doom",
            "flaky",
            "silly",
            "gnaly",
            "siner",
            "ugly",
            "quick",
    };
    
    public static String GenerateDisplayname()
    {

        // new List to hold final random number results
        List<Integer> padNums = new ArrayList<Integer>();

        // build displayname string
        Random random = new Random();
        int index = random.nextInt(Adjectives.length);
        String first = Adjectives[index];

        Random random2 = new Random();
        int index2 = random.nextInt(Nouns.length);
        String last = Nouns[index2];

        String rawDn = first + last;
        
        // calculater availble space left to fill with numbers
        int dnPadding = 12 - rawDn.length();

        // roll random numbers the size of the padding
        while(dnPadding > 0)
        {
            Random rand = new Random();

            int randomNum = rand.nextInt(10);

            padNums.add(randomNum);
            dnPadding--;
        }

        // convert Int List into a string
        StringBuilder convertedNumbers = new StringBuilder();
        padNums.forEach(convertedNumbers::append);

        // add the display name, and the random generated numbers
        String dn = rawDn + convertedNumbers;

        return dn;
    }

}
