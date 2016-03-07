package nau.algorithms;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        try
        {
            HashTable table = new HashTable(10);
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            System.out.println(table.addValue(new Trapeze()));
            table.inspect();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter square value: ");

            double square = sc.nextDouble();
            table.removeElementsLessThan(square);
            table.inspect();
        } catch (ArrayStoreException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
