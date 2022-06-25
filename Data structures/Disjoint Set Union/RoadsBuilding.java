import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadsBuilding {
    static int[] Roads;
    static int amount;
    public static int findSet(int x){
        if(Roads[x]<0) return x;
        else
        return findSet(Roads[x]);
    }
    public static void union(int x, int y)
    {
        x = findSet(x);
        y = findSet(y);
        if(x!=y){
            if(Roads[x]<=Roads[y]){
                Roads[x] +=Roads[y];
                Roads[y] = x;
            }
            else{
                Roads[y] += Roads[x];
                Roads[x] = y;
            }
            amount--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int roads = Integer.parseInt(tok.nextToken());
        int query = Integer.parseInt(tok.nextToken());
        Roads = new int[roads];
        Arrays.fill(Roads, -1);
        amount = roads;
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        while(in.ready())
        {
            tok = new StringTokenizer(in.readLine());
            union(Integer.parseInt(tok.nextToken())-1, Integer.parseInt(tok.nextToken())-1);
            out.write(""+amount);
            out.newLine();
        }
        out.close();
    }
}
