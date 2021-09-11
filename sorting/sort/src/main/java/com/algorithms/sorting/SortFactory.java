package com.algorithms.sorting;

import java.util.List;

public class SortFactory
{
    public static <T extends Comparable<T>> Sort<T> getInstance(SortType sortType)
    {
        switch (sortType)
        {
            case SELECTION:
                return new SelectionSort<T>();
            default:
                throw new IllegalArgumentException("No sorting algorithm found for type " + sortType.name());
        }
    }
}
