package pro.sky.homework_2_12.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_2_12.exception.DivideByZeroException;

@Service
public class CalculatorService {

    public int plus(int a, int b){
        return  a + b;
    }
    public int minus(int a, int b){
        return  a - b;
    }
    public int multiply(int a, int b){
        return  a * b;
    }
    public  double divide(double a, double b) {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / (double) b;
    }
}