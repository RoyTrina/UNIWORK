package Assign1;

class queueCell<T>{
    T info;
    queueCell<T> next;

    public queueCell(T x, queueCell<T> c) {
        info = x;
        next = c;
    }

class QueueException {
        public QueueException(String w){
            //super(w);             //This is the line fotr the
        }
    }

public static class Dequeue<T> {
        private queueCell<T> left;

        public Dequeue(){
            left = null;
        }

        public void createdeq(){
            new Dequeue<>();
        }

        public void isEmpty(){

        }

        public void left(T x){

        }

        public void right(T x){
            if (left == null){
                left = new queueCell<>(x, left);
            }
            else{
                queueCell<T> c = left;
                while (c.next != null){
                    c = c.next;
                }
                c.next = new queueCell<T>(x, left);
            }
        }

        public void addLeft(T x){
            left = new queueCell<>(x, left);
        }

        public void addRight(){

        }

        public void removeLeft(){

        }

        public void removeRight(){

        }
}


}