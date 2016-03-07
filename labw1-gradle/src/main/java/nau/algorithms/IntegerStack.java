package nau.algorithms;

/**
 * Created by maxi on 25.01.16.
 */

public class IntegerStack {
    private int[] array;
    private byte headPosition;

    public IntegerStack(int length) {
        headPosition = -1;
        array = new int[length];
    }

    public boolean push(int element) {
        if (!isFull()) {
            array[++headPosition] = element;
            return true;
        }
        return false;
    }

    public Integer pop()
    {
        Integer element = null;

        if(!isEmpty())
        {
            element = array[headPosition];
            array[headPosition--] = 0;
        }

        return element;
    }

    public boolean isFull()
    {
        return array.length == headPosition+1;
    }

    public boolean isEmpty()
    {
        return headPosition == -1;
    }

    public void inspect()
    {
        System.out.print("Content: ");
        for(int i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
