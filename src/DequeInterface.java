public interface DequeInterface<E> {
    /**
     * Adds an element, can fail!
     * @param element
     */
    boolean offerFirst(E element); //ArrayDeque (2)

    /**
     * Adds an element, can fail!
     * @param element
     */
    boolean offerLast(E element); //ArrayDeque (3)

    /**
     * Inserts at the beginning of the collection
     *
     * @param element
     */
    boolean addFirst(E element); //ArrayDeque (4)

    /**
     * Inserts at the end of the collection
     *
     * @param element
     */
    boolean addLast(E element); //ArrayDeque (5)

    /**
     * Removes the first element of the collection
     *
     * @return
     */
    E removeFirst(); //ArrayDeque (6)

    /**
     * Removes the last element of the collection
     *
     * @return
     */
    E removeLast(); //ArrayDeque (7)
    // Remove from the back

    /**
     * Looks at the first element of the collection
     *
     * @return
     */
    E peekFirst(); //ArrayDeque (8)

    /**
     * Looks at the last element of the collection
     *
     * @return
     */
    E peekLast(); //ArrayDeque (9)

    /**
     * Removes and returns the first element of the collection
     *
     * @return
     */
    E pollFirst(); //ArrayDeque (10)

    /**
     * Removes and returns the last element of the collection
     *
     * @return
     */
    E pollLast(); //ArrayDeque (11)

    /**
     * Checks to see if the collection is empty
     *
     * @return true if empty
     */
    boolean isEmpty(); //ArrayDeque (12)

    /**
     * Returns the size of the collection
     *
     * @return number of elements
     */
    int size(); //ArrayDeque (13)
}