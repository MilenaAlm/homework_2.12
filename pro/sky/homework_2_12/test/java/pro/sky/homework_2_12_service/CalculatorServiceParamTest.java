package pro.sky.homework_2_12_service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.homework_2_12.exception.DivideByZeroException;
import pro.sky.homework_2_12.service.CalculatorService;

import java.util.stream.Stream;

public class CalculatorServiceParamTest {
   private final CalculatorService calculatorService = new CalculatorService();
   public static Stream<Arguments> plusTestParam(){
       return Stream.of(
               Arguments.of(10,5,15),
               Arguments.of(-10, 5, -5)
       );
   }
    public static Stream<Arguments> minusTestParam(){
        return Stream.of(
                Arguments.of(10,5,5),
                Arguments.of(-10, 5, -15)
        );
    }
    public static Stream<Arguments> multiplyTestParam(){
        return Stream.of(
                Arguments.of(10,5,50),
                Arguments.of(-10, 5, -50)
        );
    }
    public static Stream<Arguments> divideTestParam() {
        return Stream.of(
                Arguments.of(10, 5, 2),
                Arguments.of(-10, 5, -2)
        );
    }
        public static Stream<Arguments> divideNegativeTestParam(){
            return Stream.of(
                    Arguments.of(10, 0),
                    Arguments.of(-10, 0)
            );
    }
   @ParameterizedTest
   @MethodSource("plusTestParam")
   public void plusTest(int a, int b, int expected){
       Assertions.assertThat(calculatorService.plus(a, b))
               .isEqualTo(expected);
   }
    @ParameterizedTest
    @MethodSource("minusTestParam")
    public void minusTest(int a, int b, int expected){
        Assertions.assertThat(calculatorService.minus(a, b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("multiplyTestParam")
    public void multiplyTest(int a, int b, int expected){
        Assertions.assertThat(calculatorService.multiply(a, b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("divideTestParam")
    public void divideTest(int a, int b, int expected){
        Assertions.assertThat(calculatorService.divide(a, b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("divideNegativeTestParam")
    public void divideNegativeTest(double a, double b){
        Assertions.assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(()->calculatorService.divide(a,b));
    }
}
