import java.util.LinkedHashSet;
import java.util.Set;

/*
You are invited to a party. To entertain the guests, the host decides to conduct a game. Each guest (including you) is
given with a list of positive integers. The guests will have to rearrange those numbers to form the largest number possible.
The guest who forms the largest number in quickest time wins. Your task would be to rearrange the numbers and form the
largest number. Since, the result could be very large, you need to return the result in string format.

Example 1:

Input:
N = 5
Arr[] = {3, 30, 34, 5, 9} 9534330
Output: 9534330
Explanation: Given numbers are {3, 30, 34,
5, 9}, the arrangement 9534330 gives the
largest value.

Example 2:

Input:
N = 4
Arr[] = {54, 546, 548, 60}
Output: 6054854654
Explanation: Given numbers are {54, 546,
548, 60}, the arrangement 6054854654
gives the largest value.

Example 3:

Input:
N = 4
Arr[] = {138, 359, 178, 398, 295, 905, 610, 232, 746, 176, 636, 299, 143, 400, 969, 413, 261, 558, 595, 9, 396, 969, 114, 531, 7, 963, 943, 366, 83}
Output: 9969963943905837746636610595558531413400398396366359299295261232178176143138114

*/
public class LargestNumberFormedByArray {

    public static String printLargest(String[] arr) {
        // code here

        Set<String> hashSet = new LinkedHashSet<>();
        StringBuilder str1 = new StringBuilder();
        int count = 1;
        while (count <= arr.length) {
            String maxNum = "";
            for (String str : arr) {
                if (hashSet.contains(str) || str.equalsIgnoreCase(maxNum)) {
                    continue;
                }

                maxNum = getMaxNum(str, maxNum, 0);
            }
            hashSet.add(maxNum);
            count++;
            str1.append(maxNum);
        }

        return str1.toString();

    }

    public static String getMaxNum(String str, String maxNum, int count) {
        int currNum, maxPos;
        if (maxNum.length() == 0) {
            return str;
        }
        if (str.length() - 1 < count) {
            currNum = Character.getNumericValue(str.charAt(str.length() - 1));
        } else {
            currNum = Character.getNumericValue(str.charAt(count));
        }
        if (maxNum.length() - 1 < count) {
            maxPos = Character.getNumericValue(maxNum.charAt(maxNum.length() - 1));
        } else {
            maxPos = Character.getNumericValue(maxNum.charAt(count));
        }

        if (currNum > maxPos) {
            return str;
        }
        if (currNum == maxPos) {
            return getMaxNum(str, maxNum, count + 1);
        }
        if (currNum < maxPos) {
            return maxNum;
        }
        return str;
    }

    public static void main(String[] args) {
        String[] arr = {"3", "30", "34", "5", "9"};
        System.out.println(printLargest(arr));
    }





}
//    public class Main {
//        public static void main(String[] args) {
//            ArrayList<String> arr = new ArrayList<>();
//            String[] example = {"138", "359", "178", "398", "295", "905", "610", "232", "746", "176", "636", "299", "143", "400", "969", "413", "261", "558", "595", "9", "396", "969", "114", "531", "7", "963", "943", "366", "83"};
//            for (String s: example) {
//                arr.add(s);
//            }
//            String real = "9969969963943905837746636610595558531413400398396366359299295261232178176143138114";
//            String ans = cal(arr);
//            System.out.println(ans.equals(real));
//        }
//        static class SortString implements Comparator<String> {
//
//            // Method
//            // Sorting in ascending order of name
//            @Override
//            public int compare(String a, String b)
//            {
//                int min = Math.min(a.length(), b.length());
//                // System.out.println("a is " + a);
//                // System.out.println("b is " + b);
//                for (int i = 0; i < min; i++) {
//                    if (a.charAt(i) > b.charAt(i)) {
//                        // System.out.println("a is greater..");
//                        return 1;
//                    }
//                    else if (a.charAt(i) < b.charAt(i)) return -1;
//                }
//                if (a.length() > min) {
//                    // System.out.println("a length is greater..");
//                    if (a.charAt(min) > b.charAt(min - 1)) return 1;
//                    else {
//                        // System.out.println("a length is greater.. return a");
//                        return -1;
//                    }
//                }
//                if (b.length() > min) {
//                    // System.out.println("b length is greater..");
//                    if (b.charAt(min) > a.charAt(min - 1)) return -1;
//                    else {
//                        // System.out.println("b length is greater.. return b");
//                        return 1;
//                    }
//                }
//                return 1;
//            }
//        }
//        public static String cal(ArrayList<String> arr) {
//            if (arr == null || arr.size() == 0) return "";
//            Collections.sort(arr, new SortString());
//            Collections.reverse(arr);
//            StringBuilder sb = new StringBuilder();
//            for (String s: arr) {
//                sb.append(s);
//            }
//            return sb.toString();
//        }
//    }