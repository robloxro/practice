package robloxro.practice.strings;

import java.util.Scanner;

//https://www.coderbyte.com/editor/Longest%20Word:Java
/*
Challenge
Using the Java language, have the function LongestWord(sen) take the sen parameter
being passed and return the largest word in the string.
If there are two or more words that are the same length, return the first word from the string with that length. Ignore punctuation and assume sen will not be empty.

Sample Test Cases
Input:"fun&!! time"
Output:"time"

Input:"I love dogs"
Output:"love"
* */
public class CoderByteLongestWord {
    public static boolean isWord(String str)
    {
        boolean ret=true;
        ret=str.matches("[a-zA-Z]+");
        return ret;
    }
    public static String LongestWord(String sen) {
        String tokens[]=sen.split("\\s+");
        int maxLength=0;
        String longest="";
        String token="";
        for (int i=0;i<tokens.length;i++)
        {
            token=tokens[i];
            if (isWord(token))
            {
               if (maxLength<token.length()) {
                   maxLength = token.length();
                   longest = token;
               }
            }
        }

        return longest;

    }

    public static void main (String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));

    }


}
