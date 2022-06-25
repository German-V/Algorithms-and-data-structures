import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Tree {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader("input.txt"));
       /* long sum = 0;
        while (in.hasNextLine())
        {
            sum += Integer.parseInt(in.nextLine());
        }*/
        long sum = 0;
        int temp = 0;
        Set<Integer> Sum = new TreeSet<>();
        while (in.hasNextLine())
        {
            temp = Integer.parseInt(in.nextLine());
            if(!Sum.contains(temp)) {
                Sum.add(temp);
                sum += temp;
            }
        }
        FileWriter output = new FileWriter("output.txt");
        PrintWriter out = new PrintWriter(output);
        out.print(sum);
        out.close();
        /*Set<Integer> Sum = new TreeSet<>();
        while (in.hasNextLine())
        {
            Sum.add(Integer.parseInt(in.nextLine()));
        }*/
    }
}
