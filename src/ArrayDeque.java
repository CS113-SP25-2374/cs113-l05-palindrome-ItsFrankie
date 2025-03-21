public class ArrayDeque<E> implements DequeInterface<E> 
{
    E[] array;
    int first;
    int last;
    int count;

    public ArrayDeque() //ArrayDeque (0)
    {
        resize(10); //ArrayDeque (1)
        first = -1;
        last = -1;
        count = 0;
    }

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
    }

    @Override
    public boolean offerFirst(E element) //ArrayDeque (2)
    {
        if (count == array.length - 1) 
        {
            return false;
        } 
        
        addFirst(element); //ArrayDeque (4)
        return true;
    }

    @Override
    public boolean offerLast(E element) //ArrayDeque (3)
    {
        if (count == array.length - 1) 
        {
            return false;
        }
        
        addLast(element); //ArrayDeque (5)
        return true;
    }

    @Override
    public boolean addFirst(E element) //ArrayDeque (4)
    {
        if (count == array.length - 1) {
            resize(array.length * 2); //ArrayDeque (1)
        }

        if (first == -1) {
            first = 0;
            last = first;
            array[first] = element;
            count++;
        } else {
            first--;
            if (first < 0) {
                first = array.length - 1;
            }
            array[first] = element;
            count++;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) //ArrayDeque (5)
    {
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
    }

    @Override
    public E removeFirst() //ArrayDeque (6)
    {
        E temp = array[first];
        array[first] = null;
        first++;
        return temp;
    }

    @Override
    public E removeLast() //ArrayDeque (7)
    {
        E temp = array[last];
        array[last] = null;
        last--;
        return temp;
    }

    @Override
    public E peekFirst() //ArrayDeque (8)
    {
        return array[first];
    }

    @Override
    public E peekLast() //ArrayDeque (9)
    {
        return array[last];
    }

    @Override
    public E pollFirst() //ArrayDeque (10)
    {
        return removeFirst();
    }

    @Override
    public E pollLast() //ArrayDeque (11)
    {
        return removeLast();
    }

    @Override
    public boolean isEmpty() //ArrayDeque (12)
    {
        return count == 0;
    }

    @Override
    public int size() //ArrayDeque (13)
    {
        return count;
    }

    @Override
    public String toString() //ArrayDeque (14)
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        int size = size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            if (i < size - 1) stringBuilder.append(", ");
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}