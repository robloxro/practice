package robloxro.practice.strings;
//https://www.coderbyte.com/editor/guest:Letter%20Capitalize:Java
/*Challenge
        Using the Java language, have the function LetterCapitalize(str) take the str parameter being passed and capitalize the first letter of each word. Words will be separated by only one space.
        Sample Test Cases
        Input:"hello world"
        Output:"Hello World"
        Input:"i ran there"
        Output:"I Ran There"
*/

import java.util.Scanner;

public class CoderByteLetterCapitalize {
    public static String LetterCapitalize(String str) {

        String tokens[]=str.split("\\s+");
        if (tokens.length==1)
            return tokens[0].substring(0,1).toUpperCase().concat(tokens[0].substring(1,tokens[0].length()));
        str="";
        for (int i=0;i<= tokens.length-1;i++)
        {
            String token=tokens[i];
            String firstLetter=token.substring(0,1);
            String restOfTheToken=token.substring(1,token.length());
            str=str.concat(firstLetter.toUpperCase().concat(restOfTheToken))+" ";
        }
        str=str.substring(0,str.length()-1);
        return str;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterCapitalize(s.nextLine()));
    }
}
