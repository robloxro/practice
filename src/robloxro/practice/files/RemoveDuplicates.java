package robloxro.practice.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

/* Given two txt files with  one word per line, create athird file with the result of concatenating file1+ file 2 contents and remove duplicates.
This has come as an idea from a project at the office where we had to make an analysis of two files
that contained system codes and define the merged list of system codes from the two files and remove duplicates
* */
public class RemoveDuplicates {
    public static void main (String[] args) {
        Scanner s1 = null;
        Scanner s2 = null;
        try {
            s1 = new Scanner(new File("C:\\Users\\ruxij\\dev\\practice\\practice\\src\\robloxro\\practice\\resources\\file1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(" File not found C:\\Users\\ruxij\\dev\\practice\\practice\\src\\robloxro\\practice\\resources\\file1.txt");
            return;
        }
        try {
            s2 = new Scanner(new File("C:\\Users\\ruxij\\dev\\practice\\practice\\src\\robloxro\\practice\\resources\\file2.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(" File not found C:\\Users\\ruxij\\dev\\practice\\practice\\src\\robloxro\\practice\\resources\\file2.txt");
            return;
        }
        String content1 = s1.useDelimiter("\\A").next();
        s1.close();
        String content2 = s2.useDelimiter("\\A").next();
        s2.close();
        String s3 = content1 +System.lineSeparator()+ "" + content2;
        String tokens[] = s3.split("\\r?\\n");
        String result = "";
        for (int i = 0; i < tokens.length; i++) {
            String token=tokens[i];
            if (!(result.contains(token))) {
                result=result.concat(token).concat(System.lineSeparator());

            }
        }
        System.out.println(result);
        File fileResult = new File("C:\\Users\\ruxij\\dev\\practice\\practice\\src\\robloxro\\practice\\resources\\file3.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileResult));
            writer.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}
