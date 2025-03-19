public class Pilha<T> implements LinkedList<T>{
    LinkedNode<T> topo = null;

    public void push(T data){
        if(topo == null){
            topo = new LinkedNode<T>(data);
        }
        else{
            LinkedNode<T> newNode = new LinkedNode<T>(data);
            newNode.previous = topo;
            topo = newNode;
        }
    }

    public T pop(){
        LinkedNode<T> temp = topo;
        topo = temp.previous;
        return temp.value;
    }
}
