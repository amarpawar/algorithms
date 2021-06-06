# Knuth–Morris–Pratt string searching algorithm

KMP string searching algorithm is used to find out whether the given pattern is present in the given text. This is also known as a needle in haystack problem.
This algorithm provides significant improvement over the naive solution. 

In naive approach, we iterate over each character of the given text (haystack) and try to check if given pattern (needle) is present from that character in the text. With this approach, complexity of our solution becomes O(m*n).

In naive solution, suppose if we start comparing the pattern from i<sup>th</sup> index of the text and there is a mismatch, we move our pointer back to (i+1)<sup>st</sup> index and start comparing the pattern again.

With KMP algorithm, while iterating the text if there is a mismatch we don't have to move our pointer back. KMP achieves this by using LPS (Longest Prefix which is also a Suffix) array.

### Longest Prefix which is also a Suffix (LPS)

Longest prefix which is also a suffix is the longest substring from the given string which is a prefix as well as a suffix.

![alt text](https://i.ibb.co/3RwhGNS/pattern.png)

For a given string of length n, a substring can be it's prefix if it starts at 0<sup>th</sup> index and ends at (n-1-i)<sup>th</sup> index and a substring can be it's suffix if it starts at i<sup>th</sup> index and ends at (n-1)<sup>th</sup> index where i is greater than 0.

For the above example, the LPS array will be ```[0, 1, 0, 0, 0, 0, 1, 2, 3, 4]```. The value at LPS[i] represents the length of longest prefix substring which is also a suffix for the substring from our parent string from 0 to i<sup>th</sup> index. For i=8, we get the length of LPS as 3 which can be visualized as below.

![alt text](https://i.ibb.co/rFs0bqv/pattern2.png)

Following is the pseudo code for generating the LPS array.

```
getLps(String needle)
    Initialize j = 0 and lps[j] = 0
    FOR i=1 to needle.length
        IF needle[i] is equlas to needle[j]
            Increment j by 1
            lps[i] = j;
        ElSE
            WHILE j is not equls to 0
                j = lps[j-1]
                IF needle[i] is equals to needle[j]
                    Increment j by 1
                    lps[i] = j
                    break out of while
                ENDIF
            ENDWHILE
        ENDIF
    ENDFOR
END getLPS
```
Let's go through each step of this algorithm.

1. We initialize first element of our LPS array to 0, becuase with j=0
