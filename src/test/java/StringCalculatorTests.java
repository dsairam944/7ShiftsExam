package test.java;

import main.java.StringCalculator;
import org.junit.Assert;
import org.junit.Test;


public class StringCalculatorTests {

    @Test
    public void testCustomDelimiter() throws Exception {
        Assert.assertEquals(8, StringCalculator.add("//;\n1;3;4"));
        Assert.assertEquals(6, StringCalculator.add("//$\n1$2$3"));
        Assert.assertEquals(13, StringCalculator.add("//@\n2@3@8"));
    }

    @Test(expected = Exception.class)
    public void testNegativeNumbers() throws Exception {
        StringCalculator.add("//@\n2@3@-8");
    }

    @Test(expected = Exception.class)
    public void testMultipleNegativeNumbers() throws Exception {
        StringCalculator.add("//@\n-2@3@-8");
    }

//BONUS
    @Test
    public void testGreaterThanThousandNum() throws Exception {
        Assert.assertEquals(5, StringCalculator.add("//***\n1000***2***3"));
        Assert.assertEquals(4, StringCalculator.add("//%%\n1%%2000%%3"));

}

    @Test
    public void testArbtraryLength() throws Exception {
        Assert.assertEquals(6, StringCalculator.add("//***\n1***2***3"));
        Assert.assertEquals(6, StringCalculator.add("//%%\n1%%2%%3"));

    }

    @Test
    public void testMultipleDelimiters() throws Exception {
        Assert.assertEquals(9, StringCalculator.add("//$,@\n1$5@3"));
        Assert.assertEquals(9, StringCalculator.add("//:,@\n1:5@3"));

    }

    @Test
    public void testMultipleDelimWithArbitraryLen() throws Exception {
        Assert.assertEquals(5, StringCalculator.add("//$,@_\n0$@$2-@,$@3"));
    }

}