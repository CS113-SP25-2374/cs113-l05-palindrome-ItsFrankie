import java.util.Stack;

public class Palindrome<E> 
{
    /**
     * Break a stack into two, push the first half to one stack, then push
     * second half to a stack, then pop & push to a second stack.
     * If the string is odd, the middle element goes to both stacks (or neither!)
     * R A C E C A R
     * Stack 1: R A C E
     * Middle Letter: E
     * Stack 2: E C A R
     * Re-stack either the first or second stack and compare them.
     * @param s a string to test
     * @return true if they are the same
     */
    private String word;

    //METHOD IMPLEMENTS

    public Palindrome()
    {
        this.word = " ";
    }

    public Palindrome(String word0)
    {
        this.word = word0;
    }

    public String isPalindrome(String word0) 
    {
        String wordOrPhrase = "word";
        Character char0;
        int whiteSpaceCount = 0;

        ArrayStack<Character> stack1 = new ArrayStack<Character>();
        for(int i = 0; i < word0.length(); i++)
        { //fill stack1
            char0 = word0.charAt(i);
            if (char0 == ' ')
            {
                wordOrPhrase = "phrase";
                whiteSpaceCount++;
            }
            else
            {
                stack1.push(word0.charAt(i));
            }
        } //end of stack1 filler
        
        Stack<Character> stack2 = new Stack<Character>();
        for(int i = word0.length()-1; i >= 0; i--)
        { //fill stack2
            char0 = word0.charAt(i);
            if (char0 != ' ')
                stack2.push(word0.charAt(i));
        } //end of stack2 filler



        char char1, char2;
        for(int i = 0; i < word0.length()-whiteSpaceCount; i++)
        { //compare the two stacks
            char1 = stack1.pop();
            char2 = stack2.pop();
            if (char1 != char2)
            {
                return "The " + wordOrPhrase + " \"" + word0 + "\" is NOT a palindrome.";
            }
        }
        
        return "The " + wordOrPhrase + " \"" + word0 + "\" is a palindrome!";

    } //end of isPalindrome method


    public String getWord()
    {
        return this.word;
    }

    public void setWord(String word0)
    {
        this.word = word0;
    }

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
}
