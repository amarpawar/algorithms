# Knuth–Morris–Pratt string searching algorithm

KMP string searching algorithm is used to find out whether the given pattern is present in the given text. This is also known as a needle in haystack problem.
This algorithm provides significant improvement over the naive solution. 

In naive approach, we iterate over each character of the given text (haystack) and try to check if given pattern (needle) is present from that character in the text. With this approach, complexity of our solution becomes O(m*n).

In naive solution, suppose if we start comparing the pattern from i<sup>th</sup> index of the text and there is a mismatch, we move our pointer back to (i+1)<sup>st</sup> index and start comparing the pattern again.

With KMP algorithm, while iterating the text if there is a mismatch we don't have to move our pointer back. KMP achives this by using LPS (Longest Prefix which is also a suffix) array.KMP string searching algorithm is used to find out whether the given pattern is present in the given text. This is also known as a needle in haystack problem. This algorithm provides significant improvement over the naive solution.

In naive approach, we iterate over each character of the given text(haystack) and try to check if given pattern(needle) is present from that character. With this approach, complexity of our solution becomes O(m*n).


