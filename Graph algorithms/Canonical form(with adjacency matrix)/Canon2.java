import java.io.*;
import java.util.StringTokenizer;

public class Canon2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(in.readLine());

        int[] Canon = new int[N];
        //int n,m;
        StringTokenizer stringTokenizer;
        //int ind = 0;
        for (int j = 0; j < N; j++) {


            stringTokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                if (Integer.parseInt(stringTokenizer.nextToken()) == 1)
                    Canon[i] = j+1;
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        for (int j = 0; j < N-1; j++) {
            out.write(""+Canon[j]+" ");
        }
        out.write(""+Canon[N-1]);

        out.close();
    }
}
