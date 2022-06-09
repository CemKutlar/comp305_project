import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class main {

    // Declare a global list
    static List<String> al = new ArrayList<>();

    // Creating a public static Arraylist such that
    // we can store values
    // IF there is any question of returning the
    // we can directly return too// public static
    // ArrayList<String> al = new ArrayList<String>();
    public static void main(String[] args)
    {
        for(int i = 1; i<11; ++i) {
            try {

//the file to be opened for reading
                FileInputStream fis = new FileInputStream("src/test_" + i + ".txt");
                System.out.println("Checking: " + "src/test_" + i + ".txt");
                Scanner sc = new Scanner(fis);    //file to be scanned
//returns true if there is another line to read
                while (sc.hasNextLine()) {
                    String s = sc.nextLine();
                    findsubsequences(s, ""); // Calling a function
                    //System.out.println(al);
                    //System.out.println(findOccurrence("bb", al));
                    System.out.println("Number of beautiful strings in " + s + ":" + beautifulStringCount());
                    System.out.println();      //returns the line that was skipped
                    al.clear();
                }
                sc.close();     //closes the scanner

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static Integer beautifulStringCount() {
        int count = 0;
        List<String> countedStr = new ArrayList<>();
        for (String str: al
             ) {
            int occ = findOccurrence(str, al);
            int len = str.length();
            if(len % 2 == 0 && str.substring(0,len/2).equals(str.substring(len/2,len)) && !countedStr.contains(str) && !str.equals("")) {
                countedStr.add(str);
                //System.out.println(str + occ);
                count +=occ;
                occ = 0;
            }
            //count += findOccurrence(str, al);
        }

        return count;
    }
    //https://www.geeksforgeeks.org/print-subsequences-string/
    private static void findsubsequences(String s,
                                         String ans)
    {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }

        // We add adding 1st character in string
        findsubsequences(s.substring(1), ans + s.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findsubsequences(s.substring(1), ans);
    }

    private static Integer findOccurrence(String str, List<String> arr) {
        int occurrences = Collections.frequency(arr, str);

        return occurrences;
    }

}
