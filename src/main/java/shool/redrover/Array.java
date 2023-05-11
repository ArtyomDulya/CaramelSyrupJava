package shool.redrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {

    static List<String> less1(List<String> string2) {
        List<String> string1 = Arrays.asList("Cat", "Dog", "snail");



        for (int i = 0; i < string1.size(); i++) {

            string2.add(string1.get(i));
        }
        return string2;
    }

    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        less1(animals);
        System.out.println(animals);
    }


}
