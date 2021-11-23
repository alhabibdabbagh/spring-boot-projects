package project7.security7;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Habib
 * @on 11/23/21 - 7:13 AM
 */
public class SimpleUnitTestClass {
    Calculator calculator;

    @BeforeEach
    void setup() {
        this.calculator = new Calculator();
    }

    @AfterEach
    void setoff() {
        System.out.println("loop done");
    }

    @BeforeAll
   static void beforeALL() {
        System.out.println("hello");
    }
    @AfterAll
   static void afterAll() { // static olması lazım
        System.out.println("see u");
    }

    @Nested
    class addTest {
        @Test
        @DisplayName("test2Habib")
        public void testAdd() {
            //given
            int first = 10;
            int seconde = 20;
            int excepted = 30;

            //when
            int actual = calculator.add(first, seconde);

            //then
            Assertions.assertEquals(excepted, actual);
        }

        @RepeatedTest(10)
        @DisplayName("test22Habib")
        public void testAdd2() {
            //given
            int first = 10;
            int seconde = 20;
            int excepted = 30;

            //when
            int actual = calculator.add(first, seconde);

            //then
            Assertions.assertEquals(excepted, actual);
        }

    }

    @Nested
    class MultiplyTest {
        @Test
        @DisplayName("test223Habib")
        public void testMultiply() {
            //given
            int first = 10;
            int seconde = 0;
            int excepted = 0;

            //when
            int actual = calculator.multiply(first, seconde);

            //then
            //Assertions.assertEquals(excepted,actual);
            Assertions.assertTrue(actual == 0);
        }

        @ParameterizedTest
        @ValueSource(ints = {10, 2, 5, -6, 00})
        @DisplayName("test2231Habib")
        public void testMultiply1(int givenSource) {
            //given
            int first = givenSource;
            int seconde = 0;
            int excepted = 0;

            //when
            int actual = calculator.multiply(first, seconde);

            //then
            //Assertions.assertEquals(excepted,actual);
            Assertions.assertTrue(actual == 0);
        }

        @ParameterizedTest(name = "1st={0} , 2st={1}")
        @CsvSource(value = {"10,0", "5,0", "00,55"})
        @DisplayName("test2231Habib")
        public void testMultiply1WithParamter(int givenFirstSource, int givenSecondeSource) {
            //given
            int first = givenFirstSource;
            int seconde = givenSecondeSource;

            //when
            int actual = calculator.multiply(first, seconde);

            //then
            //Assertions.assertEquals(excepted,actual);
            Assertions.assertTrue(actual == 0);
        }

    }


    @Test
    @DisplayName("test2Habib")
    public void testDivide() {
        //given
        int first = 10;
        int seconde = 0;
        int excepted = 30;

        //when
        Executable executable = () -> calculator.divide(first, seconde); // bu hangi kütühanden kontrol et

        //then
        Assertions.assertThrows(ArithmeticException.class, executable);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }

        int multiply(int a, int b) {
            return a * b;
        }

        int divide(int a, int b) {
            return a / b;
        }
    }
}
