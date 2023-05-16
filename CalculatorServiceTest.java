package pro.sky.homework_2_12_service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.homework_2_12.exception.DivideByZeroException;
import pro.sky.homework_2_12.service.CalculatorService;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest(){
        Number actual = calculatorService.plus(10, 5);
        Number expected = 15;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.plus(-10, 5);
        expected = -5;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void minusTest(){
        Number actual = calculatorService.minus(10, 5);
        Number expected = 5;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.minus(-10, 5);
        expected = -15;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void multiplyTest(){
        Number actual = calculatorService.multiply(10, 5);
        Number expected = 50;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.multiply(-10, 5);
        expected = -50;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divideTest(){
        Number actual = calculatorService.divide(10, 5);
        Number expected = 2.0;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.divide(-10, 5);
        expected = -2.0;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divideNegativeTest(){
       Assertions.assertThrows(DivideByZeroException.class, () -> calculatorService.divide(10,0));
       Assertions.assertThrows(DivideByZeroException.class, () -> calculatorService.divide(-10,0));

    }
}

