package Assign1;


public class DequeueMain {
    public static void main(String[] args){
        queueCell.Dequeue<Integer> testqueue = new queueCell.Dequeue<Integer>();   //Initialisation: <>
        System.out.println("Query contents: " + testqueue);
        //System.out.println("The length of the queue is: " + testqueue.length());
        testqueue.addLeft(3);
        testqueue.left(5);
        testqueue.left(7);
        System.out.println(testqueue);
        testqueue.right(9);
        testqueue.right(0);
        System.out.println(testqueue);



    }
}
