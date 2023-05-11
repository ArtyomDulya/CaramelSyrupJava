package shool.redrover;


import java.util.Arrays;

public class Test {

    public static String doubleChar(String s) {
        String[] string1 = s.split("");
        String[] string2 = s.split("");
        String result = "";

        for (int i = 0; i < string1.length; i++) {
            result += string1[i] + string2[i];
        }
        return result;
    }

    public static double findUniq(double arr[]) {
        int j;

        for (int i = 1; i < arr.length; i++) {
            double swap = arr[i];
            for (j = i; j > 0 && swap < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = swap;
        }
        if (arr[0] == arr[1]) {
            return arr[arr.length - 1];
        } else {
            return arr[0];
        }
    }


    public static void main(String[] args) {

        double[] arr = {2, 1, 1, 1, 1, 1};

        System.out.println(findUniq(arr));
    }
}
