import java.util.*;


class Stack {

    // Linked list node
    private class Node {

        int data;
        Node link;
    }

    Node top;

    Stack()
    {
        this.top = null;
    }


    public int size()
    {
        Node temp = top;
        int size = 0;
        while(temp != null)
        {
            size += 1;
            temp = temp.link;
        }
        return size;
    }
    public boolean isFull(){
        return size()>=10;
    }
    // Stack Methods
    public void push(int x)
    {
        // create new node temp and allocate memory
        Node temp = new Node();

        temp.data = x;

        temp.link = top;

        top = temp;
    }


    public boolean isEmpty()
    {
        return top == null;
    }

    // return top element in a stack
    public int top()
    {
        // check for empty stack
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // pop top element from the stack
    public int pop()
    {
        int a = 0;
        if (!isEmpty()) {
        a= top.data;
        top = (top).link;

        }
        return a;
    }

    public String display()
    {
        String print = new String();
        int t = 0;
        Node temp = top;
        Stack n = new Stack();
        while (!isEmpty()) {

            // print node data
            t = pop();
            n.push(t);
            print += t + " ";



        }
        while (!n.isEmpty()){

        push(n.pop());}
        return print + "\n";
    }
    public void removeGreater(Stack s,int num){
        ArrayList<Integer> a = new ArrayList();

        while (!s.isEmpty()){

            int numLast = s.pop();
            if(numLast<=num) {
                a.add(numLast);

            }
        }
        Collections.reverse(a);
        System.out.println(s.display());
        for (int j = 0; j < a.size(); j++) {
            s.push(a.get(j));
            System.out.println(s.display());
        }
        }


    public int calculateDistance(Stack s){
        int total = 0;
        if (!isEmpty()) {
            int subtotal;

            ArrayList<Integer> stackarr4 = new ArrayList<>();
            Stack calc = new Stack();
            while (!isEmpty()){
                stackarr4.add(s.pop());

            }
            for (int a = 0; a < stackarr4.size(); a++) {
                for (int q = a + 1; q < stackarr4.size(); q++) {
                    subtotal = Math.abs(stackarr4.get(a) - stackarr4.get(q));
                    total += subtotal;
                }

            }
            Collections.reverse(stackarr4);
            for (int a = 0; a < stackarr4.size(); a++){
                s.push(stackarr4.get(a));

            }

        }
        return total;
    }


    public void reverse(Stack s,int many){
        ArrayList<Integer> stackarr2 = new ArrayList<>();

            for (int j = many; j > 0; j--) {
                stackarr2.add(s.pop());

            }

            for (int j = 0; j < stackarr2.size(); j++) {
                s.push(stackarr2.get(j));

            }

    }
    public void sort(Stack s) {
        ArrayList<Integer> stackarr = new ArrayList<>();
        while (!isEmpty()){
            stackarr.add(s.pop());

        }
        Collections.sort(stackarr);
        Collections.reverse(stackarr);
        for (int j = 0; j < stackarr.size(); j++) {
            s.push(stackarr.get(j));

        }
    }

    public int distinct(Stack s){
        ArrayList<Integer> stackarr5 = new ArrayList<>();
        int dist = 0;


            while (!isEmpty()) {
                stackarr5.add(s.pop());

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
            s.push(stackarr5.get(y));

        }

        return dist;
    }
    public void addOrRemove(Stack s,int num){
        if (!isEmpty()) {
            if(num<0){
            for (int n=0 ; n<num ; n++){
                s.pop();
            }
        }
        else{
            for (int n=0 ; n<num ; n++){
                s.push(getRandomNumberUsingNextInt(0,50));
            }
        }

    }}
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


}

