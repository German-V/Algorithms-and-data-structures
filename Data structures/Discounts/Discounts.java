import java.io.*;
import java.util.*;

public class Discounts implements Runnable {
    public static void main(String[] args) {
        new Thread(null, new Discounts(), "", 64 * 1024 * 1024).start();
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            //int[][] arr = new int[2][n];
            PriorityQueue<Long[]> queue = new PriorityQueue<>(new Comparator<Long[]>() {
                @Override
                public int compare(Long[] o1, Long[] o2) {
                    if(o1[0] - o2[0]!=0)
                    return (int)((o1[0] - o2[0])/Math.abs(o1[0] - o2[0]));
                    else return 0;
                }
            });


            for (int i = 0; i < n; i++) {
                Long[] arr = new Long[2];
                stringTokenizer = new StringTokenizer(in.readLine());
                arr[0] = Long.parseLong(stringTokenizer.nextToken());
                arr[1] = Long.parseLong(stringTokenizer.nextToken());
                queue.add(arr);
            }
            long sum=0,price=0,plus = 0;
            for (int i = 0; i < k; i++) {
                Long[] arr1= queue.remove();
                price = arr1[0];
                plus = arr1[1];
                sum+=price;
                price+=plus;
                arr1[0] = price;
                queue.add(arr1);
            }
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
            out.write(""+sum);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
