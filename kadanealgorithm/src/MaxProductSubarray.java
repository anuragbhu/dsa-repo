import java.util.List;

public class MaxProductSubarray {
    public int maxProduct(final List<Integer> A) {

        int maxProd = A.get(0);
        int prod = A.get(0);
        int prodPositive = A.get(0);

        for(int i = 1; i < A.size(); i++) {
            prod *= A.get(i); // Multiply all values
            prodPositive *= A.get(i); // Multiply only positive values

            if(A.get(i-1) == 0) { // If 0 found for all values Multiplication
                prod = A.get(i);
            } else if(A.get(i-1) < 0) { // If negative found for positive values Multiplication
                prodPositive = A.get(i);
            }
            maxProd = Math.max(maxProd, prod);
            maxProd = Math.max(maxProd, prodPositive);
        }

        return maxProd;
    }

    public int maxProduct1(final List<Integer> A) {

        int maxProd = Integer.MIN_VALUE;

        for(int i = 0; i < A.size(); i++) {
            int prod = A.get(i);
            maxProd = Math.max(maxProd, prod);
            for(int j = i+1; j < A.size(); j++) {
                prod *= A.get(j);
                maxProd = Math.max(maxProd, prod);
            }
        }

        return maxProd;
    }
}
