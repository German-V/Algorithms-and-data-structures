import java.io.*;
import java.util.ArrayList;

public class Tree implements Runnable{
    public Node rootNode;
    ArrayList<Integer> valuesList;
    public Tree(int firstValue)
    {
        rootNode = new Node(firstValue);
        valuesList = new ArrayList<>();
    }

    public Tree() {

    }

    public void nodeInsert(int nodeValue)
    {
        Node node = new Node(nodeValue);
        Node tempNode = rootNode;
        Node inserted;
        while (true)
        {
            inserted = tempNode;
            if(nodeValue == tempNode.value) return;
            else if(nodeValue > tempNode.value)
            {
                tempNode = tempNode.Right;
                if(tempNode == null) {
                    inserted.Right = node;
                    return;
                }
            }
            else
            {
                tempNode = tempNode.Left;
                if(tempNode == null) {
                    inserted.Left = node;
                    return;
                }
            }
        }
    }

    public void FLprint(Node node)
    {
            valuesList.add(node.value);
            if(node.Left!=null)
            FLprint(node.Left);
            if(node.Right!=null)
            FLprint(node.Right);
    }
    public void print() throws IOException {
        FLprint(rootNode);
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));

        for(int i=0;i<valuesList.size()-1;i++){
            out.write(valuesList.get(i)+"");
            out.newLine();
        }
        out.write(valuesList.get(valuesList.size()-1) + "");
        out.close();
    }

    public static void main(String[] args) {
        new Thread(null, new Tree(), "", 64 * 1024 * 1024).start();
    }
    @Override
    public void run() {
        try{
            BufferedReader in=new BufferedReader(new FileReader("input.txt"));


            Tree tree = new Tree(Integer.parseInt(in.readLine()));
            while (in.ready())
                tree.nodeInsert(Integer.parseInt(in.readLine()));
            tree.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class Node
{
    public int value;
    public Node Right;
    public Node Left;

    public Node(int value) {
        this.value = value;
    }
}
