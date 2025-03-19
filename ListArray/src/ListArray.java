import java.lang.reflect.Array;
import java.util.Arrays;

public class ListArray<T> {
    T[] array;
    int len = 10;
    int crtIdx = -1;

    @SuppressWarnings("unchecked")
    public ListArray() {
        // Criação do array de tipo genérico com um tamanho fixo (exemplo: 10)
        this.array = (T[]) new Object[len]; // Isso pode ser seguro porque sabemos que T será determinado em tempo de compilação
    }

    public T[] getArray() {
        return array;
    }

    private void overrideArray(T[] arr1, T[] arr2) {
        int idx = 0;

        // Only copy elements as long as arr2 has space
        for (T v : arr1) {
            if (idx >= arr2.length) {
                break;  // Stop copying once arr2 is full
            }
            arr2[idx] = v;
            idx++;
        }
    }

    public void putAt(int index, T value) {
        len = array.length;
        if (index > crtIdx) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @SuppressWarnings("unchecked")
    public void popAt(int idx){
        if (crtIdx >= 0) {
            array[idx] = null;

            for (int i = idx + 1; i <= crtIdx; i++) {
                array[i - 1] = array[i];
            }
            array[crtIdx] = null;

            crtIdx--;

            if (crtIdx <= len * 2 / 3) {
                T[] newArray = (T[]) new Object[(int) (array.length * 2.0f / 3.0f)];
                overrideArray(array, newArray);
                array = newArray;
                len = array.length;
            }
            else {

            }
        }
    }
    public T getAt(int index) {
        if (!(index > array.length)){
            return array[index];
        }
        throw new RuntimeException();
    }

    @SuppressWarnings("unchecked")
    public void put(T value){
        crtIdx++;
        if (crtIdx >= len){
            T[] newArray = (T[]) new Object[ (int) (array.length * 1.5)];
            overrideArray(array, newArray);
            array = newArray;
            len = array.length;
        }
        else{
            putAt(crtIdx, value);
        }
    }

    @SuppressWarnings("unchecked")
    public void pop(){
        if (crtIdx >= 0) {
            array[crtIdx] = null;  // Remove the value at the current index
            crtIdx--;

            // Shrink the array if the size is less than 2/3 of the array's length
            if (crtIdx <= len * 2 / 3) {
                T[] newArray = (T[]) new Object[(int) (array.length * 2.0f / 3.0f)];
                overrideArray(array, newArray);
                array = newArray;
                len = array.length;
            }
        }
    }

    public int len(){
        return crtIdx + 1;
    }

    public int size(){
        return len;
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }
}
