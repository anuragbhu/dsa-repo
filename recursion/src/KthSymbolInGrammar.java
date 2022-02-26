public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {

        String str = "0";

        for(int i = 1; i < n; i++) {

            String temp = "";

            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '0') {
                    temp += "01";
                } else if(str.charAt(j) == '1') {
                    temp += "10";
                }
            }

            str = temp;
        }

        char ch = str.charAt(k-1);

        return Character.getNumericValue(ch);

    }

    public int kthGrammar1(int n, int k) {

        if(n == 1 && k == 1) {
            return 0;
        }

        int mid = ((int) Math.pow(2, n-1)) / 2;

        if(k <= mid) {

            return kthGrammar(n-1, k);

        } else {

            return kthGrammar(n-1, k-mid) ^ 1;
        }

    }
}
