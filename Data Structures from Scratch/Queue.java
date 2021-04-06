import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Queue {
    Node front;
    Node rear;
    private int count;
    public Queue(){
        front = null;
        rear = null;
        count = 0;
    }
    // Class for node
    private class Node{
        //data
        int i;
        Node next;
        Node(int i){
            this.i = i;
        }
        public int displayData(){
             return i;
        }
    }
    /*
     * Queue operations
      */
    public void insertLast(int i){
        Node newNode = new Node(i);
        if(isEmpty()){
            front = newNode;
        }else{
            // previous last point to new node
            rear.next = newNode;
        }
        rear = newNode;
    }

    public int removeFirst(){

        int temp = front.i;
        // If no node left after deleting node
        if(front.next == null){
            rear = null;
        }
        // front starts pointing to next element
        front = front.next;
        return temp;
    }
    public int size(){
        return count;
    }
    // Method to traverse and display all nodes
    public String displayList(){
        // Start from first node
        Node current = front;
        String print= new String();
        // loop till last node
        while(current != null){
            print += current.displayData() +" ";
            current = current.next;
        }
        return print+ "\n";
    }

    public int nodeData(){
        return front.i;
    }

    public boolean isEmpty(){
        return front == null;
    }
    /** Queue operations */
    public void enqueue(int item){
        insertLast(item);
        count++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty..");
        }
        count--;
        return removeFirst();

    }

    public int top(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty..");
        }
        return nodeData();
    }


    public void removeGreater(Queue q,int num){
        ArrayList<Integer> a = new ArrayList();


        while (!q.isEmpty()){

            int numLast = q.dequeue();
            if(numLast<=num) {
                a.add(numLast);

            }
        }

        for (int j = 0; j < a.size(); j++) {
            q.enqueue(a.get(j));
        }


    }

    public int calculateDistance(Queue q){
        int subtotal;
        int total=0;
        ArrayList<Integer> stackarr4 = new ArrayList<>();
        while (!q.isEmpty()){
            stackarr4.add(q.dequeue());

        }
        for (int a = 0; a<stackarr4.size(); a++) {
            for (int t=a+1;t<stackarr4.size();t++) {
                subtotal = Math.abs(stackarr4.get(a) - stackarr4.get(t));
                total+= subtotal;
            }

        }
        for (int y = 0; y < stackarr4.size(); y++) {
            q.enqueue(stackarr4.get(y));

        }
        return total;

    }


    public void reverse(Queue q,int many){
        ArrayList<Integer> stackarr2 = new ArrayList<>();
        Queue newq2 = new Queue();
        for (int j = many; j >0 ; j--) {
            stackarr2.add(q.dequeue());

        }
        Collections.reverse(stackarr2);
        while (!q.isEmpty()){
            newq2.enqueue(q.dequeue());
        }

        for (int j = 0; j < stackarr2.size(); j++) {
            q.enqueue(stackarr2.get(j));

        }
        while (!newq2.isEmpty()){
            q.enqueue(newq2.dequeue());
        }

    }
    public void sort(Queue q) {
        ArrayList<Integer> stackarr = new ArrayList<>();
        while (!q.isEmpty()){
            stackarr.add(q.dequeue());

        }
        Collections.sort(stackarr);
        for (int j = 0; j < stackarr.size(); j++) {
            q.enqueue(stackarr.get(j));

        }
    }
    public int distinct(Queue q){
        ArrayList<Integer> stackarr5 = new ArrayList<>();
        int dist = 0;


        while (!isEmpty()) {
            stackarr5.add(q.dequeue());

        }

        int n = stackarr5.size();
        int i, j;


        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++)
                if (stackarr5.get(i) == stackarr5.get(j))
                    break;

            if (i == j)
                dist++;
        }
        for (int y = 0; y < stackarr5.size(); y++) {
            q.enqueue(stackarr5.get(y));

        }

        return dist;
    }
    public void addOrRemove(Queue q,int num){
        if(num<0){
            num = Math.abs(num);
            for (int n=0 ; n<num ; n++){
                q.dequeue();
            }
        }
        else{
            for (int n=0 ; n<num ; n++){
                q.enqueue(getRandomNumberUsingNextInt(0,50));
            }
        }

    }
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}