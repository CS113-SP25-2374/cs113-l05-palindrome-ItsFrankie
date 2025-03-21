public class ArrayStack<E> implements StackInterface<E> 
{ 
    E[] array;
    int first;
    int last;
    int count;
    
    private void resize(int newSize) //ArrayDeque (1)
    {
        if (array == null) 
        {
            array = (E[]) new Object[newSize];
            return;
        }

        E[] newArray = (E[]) new Object[newSize];
        for (int i = 0; i <= last; i++) 
        {
            newArray[i] = array[i];
        }
        int diff = newArray.length - array.length;
        for (int i = newArray.length - 1; i >= first + diff; i--) {
            newArray[i] = array[i - diff];
        }
        array = newArray;
    } //end of resize method (0)

    public boolean empty() //ArrayStack (1)
    { //ArrayDeque (12)
        return count == 0;
    } //end of empty method (1)

    public E peek() //ArrayStack (2)
    {  //ArrayDeque (9)
        return array[last];
    } //end pf peek method (2)

    public E pop() //ArrayStack (3)
    {  //ArrayDeque (7)
        E temp = array[last];
        array[last] = null;
        last--;
        return temp;
    } //end of pop method (3)

    public boolean push(E element) //ArrayStack (4)
    {  //ArrayDeque (5)
        if (count == array.length - 1) 
        { 
            resize(array.length * 2); //ArrayDeque (1)
        }

        if (last == -1) {
            first = last = 0;
            array[last] = element;
            count++;
        } 
        else 
        {
            last++;
            if (last > array.length - 1) 
            {
                last = 0;
            }
            array[last] = element;
            count++;
        }
        return true;
    } //end of push method (5)

    /*@Override
    public int search(Object o) //ArrayStack (5)
    {
        return 0;
    }*/
}