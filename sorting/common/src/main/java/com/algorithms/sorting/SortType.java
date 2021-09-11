package com.algorithms.sorting;

public enum SortType
{
    SELECTION(1), BUBBLE(2);

    private int type;

    SortType(int type)
    {
        this.type = type;
    }

    public int getType()
    {
        return type;
    }

    public static SortType getByType(int type)
    {
        for (SortType sortType : SortType.values())
        {
            if (sortType.getType() == type)
            {
                return sortType;
            }
        }

        return null;
    }
}
