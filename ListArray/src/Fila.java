public class Fila<T>{
    LinkedNode<T> inicio = null;
    LinkedNode<T> topo = null;

    public void queue(T data){
        if(inicio == null){
            LinkedNode<T> newNode = new LinkedNode<T>(data);
            inicio = newNode;
            topo = newNode;
        }
        else{
            LinkedNode<T> newNode = new LinkedNode<T>(data);
            newNode.next = inicio;
            topo = newNode;
        }
    }

    public T dequeue(){
        LinkedNode<T> temp = inicio;
        inicio = temp.next;
        if(inicio == null){
            topo = null;
        }
        return temp.value;
    }
}
