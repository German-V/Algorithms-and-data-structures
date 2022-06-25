import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Frog implements Runnable{
    public static void main(String[] args) {
        new Thread(null, new Frog(), "", 64 * 1024 * 1024).start();
    }
    @Override
    public void run() {
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            int[] Arr = new int[n];
            if(n==2){
                System.out.println(-1);
                System.exit(0);
            }
            String str = in.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            for (int i = 0; i < n; i++) {
                Arr[i] = Integer.parseInt(st.nextToken());
            }
            if(n==1)
            {
                System.out.println(Arr[0]);
                System.out.print(1);
                System.exit(0);
            }
            int[] max = new int[n];
            max[0] = Arr[0];
            max[1] = Integer.MIN_VALUE;
            max[2] = Arr[0]+Arr[2];
            List<Integer> pathList = new ArrayList<>();
            //pathList.add(1);
            int[] path = new int[n];
            path[0] = 1;
            path[1] = -1;
            path[2] = 1;
            //path[3] = 0;
            for (int i = 3; i < n; i++) {
                max[i] = Math.max(max[i-2],max[i-3]) + Arr[i];
                if(max[i-2]>max[i-3])
                {
                    path[i] = i-1;
                }
                else path[i] = i-2;
            }
            //pathList.add(n);
            System.out.println(max[n-1]);
            int i = n-1;
            pathList.add(n);
            while(i>0)
            {
                if(path[i] == -1)
                {
                    pathList.add(1);
                    break;
                }
                pathList.add(path[i]);
                i = path[i]-1;
            }
            //System.out.println(pathList);
            for (int j = pathList.size()-1; j >0 ; j--) {
                System.out.print(pathList.get(j) + " ");
            }
            System.out.print(pathList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
