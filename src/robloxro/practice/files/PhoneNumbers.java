package robloxro.practice.files;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jitirux on 04/10/2018.
 */
public class PhoneNumbers {
    public static void main(String[] args) throws Exception
    {
        // pass the path to the file as a parameter
        File file =
                new File("C:\\Users\\jitirux\\personal\\robloxro\\phone_numbers.txt");
        Scanner sc = new Scanner(file);
        String line="";
        String tokens[]=null;
        HashMap map=new HashMap();
        Integer oldVal=null;
        Integer newValue=null;
        while (sc.hasNextLine())
        {
            line=sc.nextLine();
            line=line.replaceAll("\\s+"," ").trim();
            tokens= line.split(" ");
            oldVal=(Integer)map.get(tokens[0]+" "+tokens[1]);
            newValue= ((Integer)map.get(tokens[0]+" "+tokens[1])!=null)?new Integer(oldVal.intValue()+1):new Integer(1);
            map.put(tokens[0]+" "+tokens[1],newValue);
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}

