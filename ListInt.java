public interface ListInt{
    void add(Comparable newVal);//Adds value to end of meaningful values
    void add(int index, Comparable newVal);//Adds value at given index
    void remove(int index);//Removes value at given index
    int size();//Returns amount of meaningful values
    Comparable get(int index);//Returns the value at the given index
    Comparable set(int index,Comparable newVal);//Sets given index to new value and returns old value
}
