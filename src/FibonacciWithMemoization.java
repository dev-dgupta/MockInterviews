import java.util.HashMap;
import java.util.Map;

public class FibonacciWithMemoization {

    public static void main(String[] args) {
        var fibMap = new HashMap<Integer, Integer>();
        System.out.println(fib(5, fibMap));
    }

    static int fib(int n, Map<Integer, Integer> fibMap) {
        if (fibMap.get(n) != null)
            return fibMap.get(n);

        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        int currFibNum = fib(n - 1, fibMap) + fib(n - 2, fibMap);
        fibMap.put(n, currFibNum);
        return currFibNum;
    }
}
