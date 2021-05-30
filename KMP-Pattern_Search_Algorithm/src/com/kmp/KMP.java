package com.kmp;

public class KMP
{
    public static void main(String[] args)
    {
        String haystack = "bbbaabbbbaaabbababbabbbabaaabbaabbababa";
        String needle = "abbabbbabaa";

        int needleIndex = searchNeedleInHaystack(haystack, needle);

        if (needleIndex >= 0)
        {
            System.out.println("Needle is present at index " + needleIndex + " in the haystack.");
        }
        else
        {
            System.out.println("Needle is not present int the haystack.");
        }
    }

    private static int searchNeedleInHaystack(String haystack, String needle)
    {
        int[] lps = getLps(needle);
        int j = 0;

        for (int i=0; i<haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle.charAt(j))
            {
                j++;
            }
            else if (j != 0)
            {
                j = lps[j-1];
                i--;
            }

            if (j == needle.length())
            {
                return i-j+1;
            }
        }

        return -1;
    }

    private static int[] getLps(String needle)
    {
        int[] lps = new int[needle.length()];
        int j = 0;
        lps[j] = 0;

        for (int i=1; i < needle.length(); i++)
        {
            if (needle.charAt(j) == needle.charAt(i))
            {
                j++;
                lps[i] = j;
            }
            else
            {
                while (j != 0)
                {
                    j = lps[j-1];

                    if (needle.charAt(j) == needle.charAt(i))
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
