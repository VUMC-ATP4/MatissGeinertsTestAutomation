package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tesNGHomework.Calculator;

public class CalculatorTest {

    Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Mans otrais tests iekš testNG! ");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Sākās tests");
        calculator = new Calculator();
    }

    @Test
    public void addition() {
        System.out.println("Saskaitīšana");
        int actualResult = calculator.add(5, 15);
        int expectedResult = 20;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subtraction() {
        System.out.println("Atņemšana");
        int actualResult = calculator.substract(15, 5);
        int expectedResult = 10;
        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void multiply() {
        System.out.println("Reizināšana");
        int actualResult = calculator.multiply(3, 5);
        int expectedResult = 15;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void division() {
        System.out.println("Dalīšana");
        float actualResult = calculator.divide(9, 3);
        float expectedResult = 3;
        Assert.assertEquals(actualResult, expectedResult);
    }




}
