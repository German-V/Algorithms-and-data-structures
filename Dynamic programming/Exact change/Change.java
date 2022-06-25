import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Change {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        int sumH = 0, sumB = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken()),
                m = Integer.parseInt(stringTokenizer.nextToken()),
                s=Integer.parseInt(stringTokenizer.nextToken());
        int[] H = new int[n+m];
        //int[] B = new int[m];
        stringTokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            H[i] = Integer.parseInt(stringTokenizer.nextToken());
            sumH+=H[i];
        }
        if(m!=0) {
            stringTokenizer = new StringTokenizer(in.readLine());
            for (int i = n; i < m + n; i++) {
                H[i] = Integer.parseInt(stringTokenizer.nextToken());
                sumB += H[i];
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        if(sumH<s){
            out.write("No");
            out.close();
            return;
        }

        int C = sumH-s;
        int[] A = new int[C+1];
        A[0] = 1;
        for (int i = 0; i < n+m; i++) {
            if(H[i]<=C){
            for (int j = C; j >= 0; j--) {
                if(A[j] == 1 && j+H[i]<=C){
                    A[j+H[i]]=1;

                }
            }
                //A[H[i]]=1;
            }
        }
        if(A[C] == 1) out.write("Yes");
        else out.write("No");
        out.close();
    }
}
