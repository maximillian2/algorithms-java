package nau.algorithms;

import java.util.Random;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        // 1 LEVEL
        System.out.println("1 LEVEL");
        int stackLength = 15;
        IntegerStack stack = new IntegerStack(stackLength);

        // expecting true
        out.println("Stack emptiness: " + stack.isEmpty());

        // populating
        for (int i = 0; i < stackLength; i++)
            stack.push(i + 1);

        // should be true
        out.println("Stack full: " + stack.isFull());

        // overflow example
        out.println("Overflow is returning " + stack.push(-1));

        stack.inspect();
        out.println("Stack popped: " + stack.pop());

        stack.inspect();

        for (int i = 0; i < stackLength; i++)
            out.println("Stack popped: " + stack.pop());

        stack.inspect();
        out.println("Stack full: " + stack.isFull());
        // 1 LEVEL

        // 2 LEVEL
        out.println("2 LEVEL");
        StringLinkedList list = new StringLinkedList();
//        LinkedListElement element = new LinkedListElement(5);
        list.addToEnd(5);
        list.addToEnd(32);
        list.addToStart(8);
        list.inspect();

        out.println("Deleted item form list: " + list.deleteElement(new LinkedListElement(32)));
        list.inspect();
        out.println("Deleted item form list: " + list.deleteElement(new LinkedListElement(5)));
        list.inspect();
        out.println("Deleted item form list: " + list.deleteElement(new LinkedListElement(8)));
        list.inspect();

        list.addToStart(45);
        list.inspect();
        // 2 LEVEL

        // 3 LEVEL
        out.println("3 LEVEL");
        IntegerStack randomStack = new IntegerStack(stackLength);
        Random rand = new Random();

        for(int i = 0; i < stackLength; i++)
            randomStack.push(rand.nextInt(512)-256);

        out.print("Stack ");
        randomStack.inspect();

        StringLinkedList resultList = new StringLinkedList();

        makeMagic(randomStack, resultList, stackLength);
        out.print("List contents: ");
        resultList.inspect();
        // 3 LEVEL
    }

    public static void makeMagic(IntegerStack stack, StringLinkedList list, int elementsCount)
    {
        for(int i = 0; i < elementsCount; i++)
        {
            int poppedNumber = stack.pop();
            System.out.println("Pop:" + poppedNumber);
            if(poppedNumber >= 0)
            {
                list.addToStart(poppedNumber);
            } else {
                list.addToEnd(poppedNumber*(-1));
                list.inspect();
//                StringBuilder reversedNumberBuilder = new StringBuilder(Integer.toString(poppedNumber));
//                reversedNumberBuilder.deleteCharAt(0);
//                reversedNumberBuilder.reverse();
//                reversedNumberBuilder.insert(0, '-');
//                Integer parsed = Integer.parseInt(reversedNumberBuilder.toString());
//                list.addToEnd(Integer.toHexString(parsed));
            }
        }
    }
}
