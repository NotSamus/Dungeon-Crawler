/**
 * This is a custom queue implemented as a linked list
 */
public class QueueLinked {
    Node front, rear;
    public QueueLinked(){
        front = rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enqueue(user neUser){
        Node n = new Node(neUser);
        if(isEmpty()){
            front = rear = null;
        }
        else{
            rear.next = n;
            rear = rear.next;
        }

    }

    public user peek(){
        return front.nUser;

    }

    public user dequeue(){
        user nuser = front.nUser;
        front = front.next;
        return nuser;
    }




}
class Node{
    user nUser;
    Node next;
    Node(user neUser){
        this.nUser = neUser;
        this.next = null;
    }
    Node(user neUser, Node n){
        this.nUser = neUser;
        this.next = n;
    }

}
