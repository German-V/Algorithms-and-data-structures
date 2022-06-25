import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Matrix {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int s = Integer.parseInt(in.nextLine());
        long[][] N = new long[s][2];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < s; i++) {
            stringTokenizer = new StringTokenizer(in.nextLine());
            N[i][0] = Long.parseLong(stringTokenizer.nextToken());
            N[i][1] = Long.parseLong(stringTokenizer.nextToken());
        }
        long[][] ResultMatr = new long[s][s];
        for (int i = 0; i < s; i++) {
            Arrays.fill(ResultMatr[i], Long.MAX_VALUE);
        }
        for (int i = 0; i < s; i++) {
            ResultMatr[i][i]=0;
        }

        for (int start = 0; start < s; start++) {
            for (int i = 0; i < s-start; i++) {
                int j = start + i;
                for (int k = i; k < j; k++) {
                    ResultMatr[i][j] = Math.min(ResultMatr[i][j],
                            ResultMatr[i][k] + ResultMatr[k+1][j] + N[i][0]*N[j][1]);
                }
            }
        }
        System.out.println(ResultMatr[0][s-1]);
    }
}
