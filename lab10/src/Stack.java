public class Stack<T> {
    final private T[] stack;
    final private int maxSize;
    private int actualSize;

    @SuppressWarnings("unchecked")
    Stack(int max) {
        this.stack = (T[]) new Object[max];
        this.maxSize = max;
    }

    public boolean isEmpty(){
        return actualSize == 0;
    }

    public boolean isFull(){
        return actualSize == maxSize;
    }

    public void push(T x) throws StackOverflowException {
        if(this.isFull()) throw new StackOverflowException("StackOverflow");
        else {
            stack[actualSize] = x;
            actualSize++;
        }
    }

    public T pop() throws StackUnderflowException {
        if(this.isEmpty()) throw new StackUnderflowException("StackUnderflow");
        else{
            T tmp = stack[actualSize-1];
            stack[actualSize-1] = null;
            actualSize--;
            return tmp;
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < actualSize; i++){
            str.append(stack[i].toString());
            if(i < actualSize - 1) str.append(", ");
        }
        return str.toString();
    }
}
