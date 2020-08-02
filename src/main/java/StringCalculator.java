package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Sum is " + add("//@\n2@;3@,8"));
    }

    /***
     *Works for any no. of delimiters and any type od delimiters.
     * @param str is the input string
     * @return Integer sum of digits in the input string
     * @throws Exception when negative numbers present in the input string and prints the negative numbers present in the String.
     * The "-" character not followed by a digit, it is not considered as a negative symbol.
     */
    public static int add(String str) throws Exception {
        List<Integer> negNum=new ArrayList<>();
        List<Integer> posNum=new ArrayList<>();

        if (str.isEmpty())
            return 0;
       str= str.replaceAll("[^\\d-]", " ")+" ";
        List<String> list=Arrays.asList(str.replaceAll("[-]+\\s"," ").replaceAll("[-]+"," -").split(" ")) ;
        list.stream()
                .filter(x->!x.equals(""))
                    .map(Integer::parseInt)
                    .filter(x->x<1000).forEach(x->{
                        if(x<0)
                            negNum.add(x);
                        else
                            posNum.add(x);
                });
        if(negNum.size()>0)
            throw new Exception("Negatives not allowed : "+ negNum.toString());
        return posNum.stream().mapToInt(Integer::intValue).sum();
    }
}
