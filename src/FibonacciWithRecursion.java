
public class FibonacciWithRecursion {

    public static void main(String[] args) {
        System.out.println(fib(8));
    }

    static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        //0,1,1,2,3,5,8,13,21

        return fib(n - 1) + fib(n - 2);
    }

}
