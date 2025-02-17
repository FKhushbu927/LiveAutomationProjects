package temp;

import java.util.Date;

public class GenerateNewGmail {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        String stringDate = date.toString();
        System.out.println(stringDate);
        String noSpaceStringDate = stringDate.replaceAll("\\s", "");

       // System.out.println(noSpaceStringDate);

        String noColonStringDate = noSpaceStringDate.replaceAll("\\:", "");

        //System.out.println(noColonStringDate);

        String lowercaseString = noColonStringDate.toLowerCase();

        //System.out.println(lowercaseString);

        String gmailWithTimeStamp = lowercaseString+"@gmail.com";
        //System.out.println(gmailWithTimeStamp);


    }
}
