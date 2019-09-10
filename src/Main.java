import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String filename = (System.getProperty("user.dir") + File.separatorChar + "numbers.txt");
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int value;
        String word;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] key_value_pair = line.split("\t");
                map.put(Integer.parseInt(key_value_pair[0]), key_value_pair[1]);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File does not exist!");
        }

        System.out.println("Enter a number: ");
        value = kb.nextInt();

        if (map.containsKey(value))
            System.out.println("You entered " + map.get(value));
        else {
            System.out.println("Enter the word value for " + value + ": ");
            word = kb.next();
            map.put(value, word);
        }

        for (int item : map.keySet()){
            System.out.println(item + " = " + map.get(item));
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }

        for (int key : map.keySet())
            writer.println(key + "\t" + map.get(key));
        writer.close();
    }
}
