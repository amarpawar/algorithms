package com.algorithms.sorting;

import java.util.List;

public class SortUtil
{
    public static <T extends Comparable<T>> T[] sort(T[] data, SortType type)
    {
        return SortFactory.<T>getInstance(type).sort(data);
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> data, SortType type)
    {
        return SortFactory.<T>getInstance(type).sort(data);
    }
}
