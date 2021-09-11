package com.algorithms.sorting;

import java.util.List;

public interface Sort<T>
{
    T[] sort(T[] data);

    List<T> sort(List<T> data);
}
