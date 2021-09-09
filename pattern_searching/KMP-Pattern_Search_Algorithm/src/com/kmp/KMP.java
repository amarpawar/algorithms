package com.kmp;

public class KMP
{
    public static void main(String[] args)
    {
        String text = "bbbaabbbbaaabbababbabbbabaaabbaabbababa";
        String pattern = "abbabbbabaa";

        int patternIndex = searchKMP(text, pattern);

        if (patternIndex >= 0)
        {
            System.out.println("Needle is present at index " + patternIndex + " in the haystack.");
        }
        else
        {
            System.out.println("Needle is not present int the haystack.");
        }
    }

    private static int searchKMP(String text, String pattern)
    {
        int[] lps = getLps(pattern);
        int j = 0;
        int i = 0;

        while (i < text.length())
        {
            if (text.charAt(i) == pattern.charAt(j))
            {
                i++;
                j++;
            }
            else if (j != 0)
            {
                j = lps[j-1];
            }
            else
            {
                i++;
            }

            if (j == pattern.length())
            {
                return i-j;
            }
        }

        return -1;
    }

    private static int[] getLps(String pattern)
    {
        int[] lps = new int[pattern.length()];
        int j = 0;
        lps[j] = 0;

        for (int i=1; i < pattern.length(); i++)
        {
            if (pattern.charAt(j) == pattern.charAt(i))
            {
                j++;
                lps[i] = j;
            }
            else
            {
                while (j != 0)
                {
                    j = lps[j-1];

                    if (pattern.charAt(j) == pattern.charAt(i))
                    {
                        j++;
                        lps[i] = j;
                        break;
                    }
                }
            }
        }

        return lps;
    }
}
