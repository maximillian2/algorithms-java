package nau.algorithms;

/**
 *
 * Created by maxi on 01.02.16.
 */

public class HashTable {
    private Trapeze[] array;
    private int arraySize;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;

        if (this.arraySize <= 0)
            throw new ArrayStoreException("Invalid array size");
        else
            array = new Trapeze[this.arraySize];
    }

    public boolean addValue(Trapeze tr) {
        int index = this.getIndex(tr.getPerimeter());

        if (array[index] == null) {
            array[index] = tr;
        } else {
            System.out.println("Tried to access index " + (index + 1));
            System.out.println("Resolved with: " + resolveCollision(index, tr));
        }
        return true;
    }

    private int resolveCollision(int index, Trapeze tr)
    {
        int counter = 0, step;
        while(array[index] != null )
        {
            step = this.getDoubleHashedIndex(counter, tr.getPerimeter());
            if(counter < arraySize) {
                index += step;
                index %= array.length;
            } else {
                return -1;
            }
            counter++;
        }
        array[index] = tr;
        return index;
    }

    public void inspect()
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.println((i+1) + ": " + array[i]);
        }
    }

    public boolean removeElementsLessThan(double value)
    {
        for(int i = 0; i < array.length; i++)
            if(array[i] != null && array[i].getSquare() < value )
                array[i] = null;

        return true;
    }

    private int getIndex(double key)
    {
        return (int) (key % array.length);
    }

    private int getDoubleHashedIndex(int counter, double key)
    {
        return (int) ((counter + (key % array.length)) % array.length);
    }
}
