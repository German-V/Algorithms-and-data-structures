import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HashTable {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int tableSize = Integer.parseInt(stringTokenizer.nextToken());
        int constanta = Integer.parseInt(stringTokenizer.nextToken());
        int num = Integer.parseInt(stringTokenizer.nextToken());
        int[] hashTable = new int[tableSize];
        Arrays.fill(hashTable, -1);
        int n = 0;
        int i,j;
        int index = 0;
        while(in.ready()){
            n = Integer.parseInt(in.readLine());
            i=0;
            j= constanta;
            index = n % tableSize;
            /*if(hashTable[index]==-1||hashTable[index]==n){
                hashTable[index] = n;
                continue;
            }*/
            while(i<=tableSize){
                if(hashTable[(index + i*constanta)%tableSize]==-1||hashTable[(index + i*constanta)%tableSize] == n){
                    hashTable[(index + i*constanta)%tableSize] = n;
                    break;
                }
                i++;
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        out.write(""+ hashTable[0]);
        for (int k = 1; k < tableSize; k++) {
            out.write(" "+ hashTable[k]);
        }
        out.close();
    }
}
