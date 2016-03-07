package nau.algorithms;

/**
 *
 * Created by maxi on 25.01.16.
 */

public class LinkedListElement {
    public String value;
    public LinkedListElement nextElement;

    public LinkedListElement(int value)
    {
        this.value = Integer.toHexString(value);
        nextElement = null;
    }

    public LinkedListElement(String value)
    {
        this.value = value;
        nextElement = null;
    }
}
