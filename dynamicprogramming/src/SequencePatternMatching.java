public class SequencePatternMatching {
    // Approach 1:
    // Just a linear traversal in enough I guess to solve it. Maintain two pointers at each string , move one if
    // you find the character in another. Not worth DP , but always good to know multiple ways of solving !


    // Approach 2:
    // a = "AXY"
    // b = "ADXCPY"
    // Check if LCS is equal to String a then return true else return false.
    // i.e. finding length is sufficient.
    // return lcs(a,b)==min(a.length(),b.length());

}
