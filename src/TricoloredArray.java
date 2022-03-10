import java.util.Arrays;

/*
 * int arr={3,7,2,5,4}, blue,red,green
 * output= BRGGB ==> 3+4=7,7=7,5+2=7
 *
 * all the corresponding tricolor should amount to equal sum
 *
 *
 * */
public class TricoloredArray {


    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 3, 2, 1, 6, 9, 4, 2, 6, 0, 3, 1, 5, 3, 7, 2, 8, 1};
        int sum = Arrays.stream(arr).sum();


        if (sum % 3 == 0) {
            char[] strArr = new char[arr.length];
            Arrays.fill(strArr, ' ');
            int targetSum = sum / 3;
            findTriColorStr(targetSum, arr, strArr, 'R', 0);
            findTriColorStr(targetSum, arr, strArr, 'G', 0);
            findTriColorStr(targetSum, arr, strArr, 'B', 0);
            System.out.println(strArr);
        } else {
            System.out.println("Impossible");
        }

    }

    private static char[] findTriColorStr(int targetSum, int[] arr, char[] strArr, char triColor, int index) {

        if (index > arr.length)
            return null;
        if (targetSum < 0)
            return null;
        if (targetSum == 0)
            return new char[arr.length];
        for (int i = index; i < arr.length; i++) {
            if (strArr[i] != ' ')
                continue;
            int remainder = targetSum - arr[i];
            char[] currChar = findTriColorStr(remainder, arr, strArr, triColor, i + 1);

            if (currChar != null) {
                strArr[i] = triColor;
                return strArr;
            }

        }

        return null;
    }
}
