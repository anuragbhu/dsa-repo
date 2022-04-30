class pair
{
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}

public class FindMinimumMaximumElementInArray {
    static pair getMinMax(long[] a, long n)  {

        long min = a[0], max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            } else if(a[i] < min) {
                min = a[i];
            }
        }
        return new pair(min,max);
    }

    static pair getMinMax1(long a[], long n)  {
        pair res = new pair(a[0], a[0]);
        if(n == 1) return res;
        long min, max;
        int i;

        if(n % 2 != 0) {
            min = a[0];
            max = a[0];
            i = 1;
        } else {
            if(a[0] > a[1]) {
                max = a[0];
                min = a[1];
            } else {
                max = a[1];
                min = a[0];
            }
            i = 2;
        }


        while(i+1 < n) {
            if(a[i] > a[i+1]) {
                if(max < a[i])
                    max = a[i];
                if(a[i+1] < min)
                    min = a[i+1];
            } else {
                if(max < a[i+1])
                    max = a[i+1];
                if(a[i] < min)
                    min = a[i];
            }
            i = i + 2;
        }

        res.first = min;
        res.second = max;

        return res;
    }
}
