package nau.algorithms;

/**
 *
 * Created by maxi on 25.01.16.
 */

public class StringLinkedList {
    private LinkedListElement head;

    public StringLinkedList()
    {
        head = null;
    }

    public boolean addToStart(int value)
    {
        // element -> head
        LinkedListElement element = new LinkedListElement(value);
        element.nextElement = head;
        // head (element) -> element
        head = element;

        return true;
    }

    public boolean addToEnd(int value)
    {

        LinkedListElement element = new LinkedListElement(value);
        if(isEmpty())
        {
            // head -> null
            head = element;
            // head(element) -> null
            element.nextElement = null;
        } else {
            // lastElement -> element
            getLastElement().nextElement = element;
        }

        return true;
    }

    private LinkedListElement search(String value)
    {
        LinkedListElement pointer = head;
        while(pointer != null && !pointer.value.equals(value))
        {
            pointer = pointer.nextElement;
        }
        return pointer;
    }

    public String deleteElement(LinkedListElement element)
    {
        LinkedListElement foundElement = search(element.value);
        LinkedListElement pointer = head;

        if(pointer.equals(foundElement))
        {
            // if it is the only element then reset the head
            head.nextElement = null;
            head = null;
            return foundElement.value;
        } else {
            while(!pointer.nextElement.equals(foundElement))
            {
                pointer = pointer.nextElement;
            }
            pointer.nextElement = foundElement.nextElement;
            return foundElement.value;
        }
    }

    private LinkedListElement getLastElement()
    {
        LinkedListElement pointer = head;
        while(pointer.nextElement != null)
        {
            pointer = pointer.nextElement;
        }
        return pointer;
    }

    public boolean isEmpty()
    {

        return head == null;
    }

    public void inspect()
    {
        LinkedListElement pointer = head;
        while(pointer != null)
        {
            System.out.print(pointer.value + " -> ");
            pointer = pointer.nextElement;
        }
        System.out.println();
    }
}
