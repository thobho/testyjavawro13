package com.thobho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    void isEven() {
        //given
        int testData = 2;

        //when
        boolean actual = calculator.isEven(testData);

        //then
        assertTrue(actual);
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(ints = {2,4,3,0})
    void isEvenParametrized(int testData){
        //when
        boolean actual = calculator.isEven(testData);

        //then
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("evenNumberGenerator")
    void isEvenParametrizedMethodSource(int testData){
        //when
        boolean actual = calculator.isEven(testData);

        //then
        assertTrue(actual);
    }

    static List<Integer> evenNumberGenerator(){
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            testData.add(i*2);
        }
        return testData;
    }


    @DisplayName("should divide numbers wihtout errors")
    @ParameterizedTest
    @MethodSource("testDataGenerator")
    void divideShouldDivideNumbrsWithoutErrors(int a, int b, int exepectedResult){

        int actualResult = calculator.divide(a, b);

        assertEquals(exepectedResult, actualResult);
    }

    static List<Arguments> testDataGenerator(){
        Arguments argument1 = Arguments.of(1, 2, 0);
        Arguments argument2 = Arguments.of(100, 50, 2);
        Arguments argument3 = Arguments.of(-100, 2, -50);
        List<Arguments> arguments = Arrays.asList(argument1, argument2, argument3);
        return arguments;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv")
    void divideShouldDivideNumbrsWithoutErrorsFile(int a, int b, int exepectedResult){

        int actualResult = calculator.divide(a, b);

        assertEquals(exepectedResult, actualResult);
    }

}