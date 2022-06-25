
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tok.nextToken());
        int K = Integer.parseInt(tok.nextToken());
        /*int[] F1 = new int[N+1];
        int[] F2 = new int[N+1];
        int[] F3 = new int[N+1];
        F1[0] = 1;
        F2[0] = 1;
        F2[1] = 1;*/
        /*int[][] F = new int[3][N+1];
        F[1][0] = 1;
        F[2][0] = 1;
        F[0][0] = 1;
        F[2][1] = 1;
        F[1][2] = 1;
        int a = 1000000007;
        int[] index = {0,1,2};
        int ind = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < i; j++) {
                F[index[i%3]][j] = (F[index[(i-1)%3]][j-1] + F[index[(i-1)%3]][j])%a;

            }
            ind=index[i%3];
            //F[ind][0] = 1;
            F[ind][i] = 1;
            //for (int j = 0; j < N+1; j++) {
           // F[0]=Arrays.copyOf(F[1],i+1);
            //   F[0][j] = F[1][j];
            //}
        }
        System.out.println(F[ind][K]);*/
       // int d = 2 %3;
       // System.out.println(" "+0%3 +1%3 + 2%3 + 3%3+4%3+5%3);
        /*for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < i ; j++) {
                F2[j] = (F1[j-1] + F1[j]%a);
                //F[1][j] = (F[0][j-1] + F[0][j])%a;

            }
            F1[0] = 1;
            F2[i] = 1;
            F1 = Arrays.copyOf(F2,i+1);

            //for (int j = 0; j < N+1; j++) {
           // F[0]=Arrays.copyOf(F[1],i+1);
            //   F[0][j] = F[1][j];
            //}

        }
        System.out.println(F2[K]);*/

         int[][] F = new int[2][N+1];
        for (int i = 0; i < 2; i++) {
            F[i][i] = 1;
        }
        for (int i = 1; i < 2; i++) {
            F[i][0] = 1;
        }
        int a = 1000000007;
        int jopa = 1;
        int tempjopa;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < i; j++) {
                tempjopa = F[1][j];
                F[1][j] = (jopa + F[1][j])%a;
                jopa = tempjopa;
            }
            //F[0][0] = 1;
            F[1][i] = 1;
            //for (int j = 0; j < N+1; j++) {
                //F[0]=Arrays.copyOf(F[1],i+1);
             //   F[0][j] = F[1][j];
            //}

        }
        //System.out.println(F[1][N-1]%a);
        System.out.println(F[1][K]);
    }
}
