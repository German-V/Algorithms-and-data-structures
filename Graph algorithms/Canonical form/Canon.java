import java.io.*;
import java.util.StringTokenizer;

public class Canon {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(in.readLine());

        int[] Canon = new int[N];
        int n,m;
        StringTokenizer stringTokenizer;

        while (in.ready()){
            stringTokenizer = new StringTokenizer(in.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            Canon[m-1] = n;
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
            for (int j = 0; j < N-1; j++) {
                out.write(""+Canon[j]+" ");
            }
            out.write(""+Canon[N-1]);

        out.close();
    }
}
