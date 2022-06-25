import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Graph implements Runnable{
    static int n;
    static boolean[] visited;
    static int[][] a;
    static int[] N;

    static int index;
    public static void main(String[] args) {
        new Thread(null, new Graph(), "", 64 * 1024 * 1024).start();
    }

    public void dfs(int v){
        visited[v] =true;
        //N[v] = index;
        //index++;
        for (int i = 0; i < n; i++) {
            if(a[i][v] ==1 && !visited[i]){
                dfs(i);

            }
//            if(a[i][v] ==1 && visited[i]) {
//                N[v]++;
//                if(N[v]==2) {
//                    //cycle = true;
//                    tmp++;
//                }
//            }
        }

    }
    @Override
    public void run() {
        index = 0;
        int m = 0;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("input.txt"));

            n = Integer.parseInt(in.readLine());

        StringTokenizer stringTokenizer = null;
            N = new int[n];
            a = new int[n][n];
        for (int j = 0; j < n; j++) {

                stringTokenizer = new StringTokenizer(in.readLine());

            for (int i = 0; i < n; i++) {
                if(Integer.parseInt(stringTokenizer.nextToken()) ==1){
                    a[i][j] = 1;
                    a[j][i] = 1;
                    m++;
                }
//                int temp = Integer.parseInt(stringTokenizer.nextToken());
//                a[i][j] = temp;
//                a[j][i] = temp;
//                if(temp == 1) m++;
            }
        }
        visited = new boolean[n];
        Arrays.fill(visited, false);
        //dfs(0);
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                index++;
            }
        }

        BufferedWriter out = null;

            out = new BufferedWriter(new FileWriter("output.txt"));

            if(index == 1&& m/2==n-1)
            out.write("Yes");
            else out.write("No");
//            out.write(""+N[0]);
//            for (int i = 1; i < n; i++) {
//                try {
//                    out.write(" "+N[i]);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
