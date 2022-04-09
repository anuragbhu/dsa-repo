public class MathImpl {

    public static void main(String[] args) {
        // Returns the absolute (positive) value of x -> abs(x)
        System.out.println(Math.abs(-4.7)); // 4.7
        System.out.println(Math.abs(4.7)); // 4.7
        System.out.println(Math.abs(3)); // 3

        // Returns the cube root of x -> cbrt(x)
        System.out.println(Math.cbrt(-4.7)); // -1.6750686836022342
        System.out.println(Math.cbrt(125.0)); // 5.0
        System.out.println(Math.cbrt(3)); // 1.4422495703074083

        // Returns the value of x rounded up to its nearest integer -> ceil(x)
        System.out.println(Math.ceil(-4.7)); // -4.0
        System.out.println(Math.ceil(125.2)); // 126.0
        System.out.println(Math.ceil(-3.2)); // -3.0

        // Returns the value of E^x -> exp(x)
        System.out.println(Math.exp(-2.0)); // 0.1353352832366127
        System.out.println(Math.exp(0.0)); // 1.0

        // Returns the value of x rounded down to its nearest integer -> floor(x)
        System.out.println(Math.floor(-4.7)); // -5.0
        System.out.println(Math.floor(125.2)); // 125.0
        System.out.println(Math.floor(-3.2)); // -4.0

        // Returns the natural logarithm (base E) of x -> log(x)
        System.out.println(Math.log(-4.7)); // NaN
        System.out.println(Math.log(0)); // -Infinity
        System.out.println(Math.log(10)); // 2.302585092994046

        // Returns the base 10 logarithm of x -> log10(x)
        System.out.println(Math.log10(-4.7)); // NaN
        System.out.println(Math.log10(0));// -Infinity
        System.out.println(Math.log10(10)); // 1.0

        // Returns the number with the highest value -> max(x, y)
        System.out.println(Math.max(12.123, 12.456)); // 12.456

        // Returns the number with the lowest value -> min(x, y)
        System.out.println(Math.min(12.123, 12.456)); // 12.123

        // Returns the value of x to the power of y -> pow(x, y)
        System.out.println(Math.pow(30, 2)); // 900.0

        // Returns the value of x rounded to its nearest integer -> round(x)
        System.out.println(Math.round(4567.9874f)); // 4568
        System.out.println(Math.round(-3421.134f)); // -3421

        // Returns the square root of x -> sqrt(x)
        System.out.println(Math.sqrt(-4.7)); // NaN
        System.out.println(Math.sqrt(25.0)); // 5.0
        System.out.println(Math.sqrt(3)); // 1.7320508075688772

        // Return double type number greater than or equal to 0.0 and less than 1.0
        System.out.println(Math.random());
    }
}
