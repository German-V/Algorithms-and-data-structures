import java.io.*;
import java.util.ArrayList;

public class Tree implements Runnable{
    public Node rootNode;
    //public int num;
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
                    node.Parent = inserted;
                    //num++;
                    return;
                }
            }
            else
            {
                tempNode = tempNode.Left;
                if(tempNode == null) {
                    inserted.Left = node;
                     node.Parent = inserted;
                    //num++;
                    return;
                }
            }
        }
    }

    public void FLprint(Node node)
    {
        if(node!=null) {
            valuesList.add(node.value);
            if (node.Left != null)
                FLprint(node.Left);
            if (node.Right != null)
                FLprint(node.Right);
        }
    }
    public void print() throws IOException {
        FLprint(rootNode);
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
        if(valuesList.isEmpty()) return ;
        for(int i=0;i<valuesList.size()-1;i++){
            out.write(valuesList.get(i)+"");
            out.newLine();
        }
        out.write(valuesList.get(valuesList.size()-1) + "");
        out.close();
    }

    public void nodeDelete(int delete)
    {
        Node tempNode = rootNode;
        Node deleteNode = rootNode;
        boolean isLeft = false;
        int c =0;
        while(delete != tempNode.value)
        {
            c++;
            deleteNode = tempNode;
            if (delete > tempNode.value) {
                isLeft = false;
                tempNode = tempNode.Right;
            }
            else {
                isLeft = true;
                tempNode = tempNode.Left;
            }
            if(tempNode == null) return ;
        }
        if(tempNode.Right == null && tempNode.Left == null)
            if(tempNode == rootNode) rootNode = null;
            else if(isLeft) deleteNode.Left = null;
            else deleteNode.Right = null;
        else if(tempNode.Right == null)
        {
            if(tempNode == rootNode) rootNode = tempNode.Left;
            else if (isLeft) deleteNode.Left = tempNode.Left;
            else deleteNode.Right = tempNode.Left;
        }
        else if(tempNode.Left == null)
        {
            if(tempNode == rootNode) rootNode = tempNode.Right;
            else if (isLeft) deleteNode.Left = tempNode.Right;
            else deleteNode.Right = tempNode.Right;
        }
        else
        {
            tempNode = tempNode.Right;
            Node newNode = tempNode;

            while(tempNode!=null)
            {
                newNode = tempNode;
                tempNode = tempNode.Left;

            }
            if(tempNode == rootNode) rootNode = newNode;
            else if (isLeft) {
                int temp_val = newNode.value;
                nodeDelete(newNode.value);
                if(c==0) deleteNode.value = temp_val;
                else deleteNode.Left.value = temp_val;

            }
            else{

                int temp_val = newNode.value;
                nodeDelete(newNode.value);
                if(c==0) deleteNode.value = temp_val;
                else deleteNode.Right.value = temp_val;
            }
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Tree(), "", 40 * 1024 * 1024).start();
    }
    @Override
    public void run() {
        try{
            BufferedReader in=new BufferedReader(new FileReader("input.txt"));
            int delete = Integer.parseInt(in.readLine());
            String tmp = in.readLine();
            Tree tree = new Tree(Integer.parseInt(in.readLine()));
            while (in.ready())
                tree.nodeInsert(Integer.parseInt(in.readLine()));
            tree.nodeDelete(delete);
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
    public Node Parent;
    public Node(int value) {
        this.value = value;
    }
}
