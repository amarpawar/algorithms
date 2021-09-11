package com.algorithms.sorting;

import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements Sort<T>

{
    @Override
    public T[] sort(T[] data)
    {
        for (int i=0; i<data.length; i++)
        {
            int minIndex = i;

            for (int j=i+1; j<data.length; j++)
            {
                if (data[minIndex].compareTo(data[j]) > 0)
                {
                    minIndex = j;
                }
            }

            if (minIndex != i)
            {
                T temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
            }
        }

        return data;
    }

    @Override
    public List<T> sort(List<T> data)
    {
        for (int i=0; i<data.size(); i++)
        {
            int minIndex = i;

            for (int j=i+1; j<data.size(); j++)
            {
                if (data.get(minIndex).compareTo(data.get(j)) > 0)
                {
                    minIndex = j;
                }
            }

            if (minIndex != i)
            {
                T temp = data.get(minIndex);
                data.set(minIndex, data.get(i));
                data.set(i, temp);
            }
        }

        return data;
    }
}
