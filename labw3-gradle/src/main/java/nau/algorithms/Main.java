package nau.algorithms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1 LEVEL
        Tree tree = new Tree();
        TreeNode[] array = new TreeNode[10];
        for(int i = 0; i < 10; i++)
        {
            array[i] = new TreeNode(new Student());
            System.out.println(array[i].toString());
        }
        for(int i = 0; i < 10; i++)
        {
            tree.addNode(array[i]);
            System.out.println("~");
            tree.inspect();
            }

        // 2 LEVEL
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter course:");
        int course = sc.nextInt();
        System.out.println("Enter average mark: ");
        double avgMark = sc.nextDouble();
        System.out.println("Found:");
        tree.search(course, avgMark);

        // 3 LEVEL
//        System.out.println("Delete:");
    }
}
