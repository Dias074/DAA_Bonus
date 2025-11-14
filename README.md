Report: Implementation of the Knuth–Morris–Pratt (KMP) String Matching Algorithm

Author: Nygman Dias, SE-2435

1. Introduction
   This project implements the Knuth–Morris–Pratt (KMP) string matching algorithm in Java.  
   The purpose of the task is to build the algorithm from scratch, test it on text inputs of
   different sizes, and analyze both time and space complexity.

KMP is widely used for efficient substring searching because it avoids re-checking previously
matched characters, unlike the naive O(n * m) algorithm. KMP guarantees a linear runtime of
O(n + m), which makes it highly scalable.

2. Implementation Summary
   The implementation is contained in the file KMPSearch.java and consists of:
- computeLPS(): builds the LPS (Longest Prefix Suffix) table.
- kmpSearch(): performs pattern matching using the LPS table.
- main(): runs three test cases (short, medium, long).

The LPS array helps the algorithm skip unnecessary comparisons after mismatches.
This significantly improves performance on longer texts or repetitive patterns.

3. Test Results
   Three tests were performed to observe KMP performance on different input sizes.

Short Test
Text: "abacaba"
Pattern: "aba"
Matches: [0, 4]
Execution Time: ~0.1–0.3 ms

Medium-Length Test
Text length: approximately 1150 characters
Pattern: "abcdabcy"
Matches found: 50
First 10 matches: [19, 42, 65, 88, 111, 134, 157, 180, 203, 226]
Execution Time: ~0.2–1.0 ms

Long Test
Text length: approximately 215000 characters
Pattern: "brownfox"
Matches found: 5000
First match index: 9
Execution Time: ~4–8 ms

These results confirm the scalability of the KMP algorithm: the execution time grows
linearly with the size of the input text.

4. Complexity Analysis
   Time Complexity:
- LPS computation: O(m)
- Pattern search: O(n + m)
  Total: O(n + m)

Space Complexity:
- LPS array requires O(m)
- Match indices require O(k), where k is the number of matches
  Total: O(m + k)

This makes KMP both fast and memory-efficient.

5. Conclusion
   The project successfully demonstrates a complete Java implementation of the KMP algorithm,
   including LPS construction, pattern searching, testing, and complexity analysis. The algorithm
   performs efficiently across all tested input sizes and meets the project requirements for a
   string algorithm implementation.
