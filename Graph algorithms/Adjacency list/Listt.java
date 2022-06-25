import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Listt {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> Matr[] = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            Matr[i] = new ArrayList<>();
        }
        //int[][] Matr = new int[N][N];
        int n,m;
        while (in.ready()){
            stringTokenizer = new StringTokenizer(in.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            Matr[n-1].add(m);
            Matr[m-1].add(n);
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        for (int i = 0; i < N; i++) {
            out.write(""+Matr[i].size());
            for (int j = 0; j < Matr[i].size(); j++) {
                out.write(" "+Matr[i].get(j));
            }
            out.newLine();
        }
        out.close();
    }
}
