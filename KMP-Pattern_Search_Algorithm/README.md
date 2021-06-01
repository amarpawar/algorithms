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


