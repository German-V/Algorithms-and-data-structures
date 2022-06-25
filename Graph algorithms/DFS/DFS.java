import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFS implements Runnable {
    static int n;
    static boolean[] visited;
    static int[][] a;
    static int[] N;
    static int index;
    public static void main(String[] args) {
        new Thread(null, new DFS(), "", 64 * 1024 * 1024).start();
    }

    public void dfs(int v){
        visited[v] =true;
        N[v] = index;
        index++;
        for (int i = 0; i < n; i++) {
            if(a[i][v] ==1 && !visited[i]){
                dfs(i);

            }
        }

    }
    @Override
    public void run() {
        index = 1;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            n = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        N = new int[n];
        StringTokenizer stringTokenizer = null;
        a = new int[n][n];
        for (int j = 0; j < n; j++) {
            try {
                stringTokenizer = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < n; i++) {
                a[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if(visited[i]==false) dfs(i);
        }

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.write(""+N[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < n; i++) {
            try {
                out.write(" "+N[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
