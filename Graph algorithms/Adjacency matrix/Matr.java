import java.io.*;
import java.util.StringTokenizer;

public class Matr {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] Matr = new int[N][N];
        int n,m;
        while (in.ready()){
            stringTokenizer = new StringTokenizer(in.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            Matr[n-1][m-1] = 1;
            Matr[m-1][n-1] = 1;
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                out.write(""+Matr[i][j]+" ");
            }
            out.write(""+Matr[i][N-1]);
            out.newLine();
        }
        out.close();
    }
}
