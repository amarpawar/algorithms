package com.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        Integer[] data = new Integer[] {1, 10, 12, 5, 30, 16, 22, 15, 10};
        SortType sortType = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("Sorting algorithms");
        System.out.println("===================================");

        System.out.println("\nSelect the algorithm:");
        System.out.println("\t1. Selection Sort");
        System.out.println("\t2. Bubble Sort");
        System.out.print("\nEnter your choice: ");

        sortType = SortType.getByType(scanner.nextInt());

        System.out.println("\nSorting the data using " + sortType.name() + " sort algorithm");
        System.out.println("Unsorted Data: " + Arrays.toString(data));
        System.out.println("Sorted Data: " + Arrays.toString(SortUtil.sort(data, sortType)));
    }
}
