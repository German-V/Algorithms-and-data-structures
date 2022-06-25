import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        int s = Integer.parseInt(in.readLine());
        int[][] N = new int[s][2];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < s; i++) {
            stringTokenizer = new StringTokenizer(in.readLine());
            N[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            N[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[][] ResultMatr = new int[s][s];
        for (int i = 0; i < s; i++) {
            Arrays.fill(ResultMatr[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < s; i++) {
            ResultMatr[i][i]=0;
        }

        for (int start = 0; start < s; start++) {
            for (int i = 0; i < s-start; i++) {
                int j = start + i;
                for (int k = i; k < j; k++) {
                    ResultMatr[i][j] = Math.min(ResultMatr[i][j],
                            ResultMatr[i][k] + ResultMatr[k+1][j] + N[i][0]*N[k][1]*N[j][1]);
                }
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        out.write(""+ResultMatr[0][s-1]);
        out.close();
    }
}