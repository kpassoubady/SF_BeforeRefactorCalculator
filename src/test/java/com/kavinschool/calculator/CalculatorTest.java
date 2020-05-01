package com.kavinschool.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class CalculatorTest {


    private String input;
    private double expected;
    private Exception exception;


    @Before
    public void setUp() throws Exception {
        this.input = "1 + 1";
        this.expected = 2;
        this.exception = null;

    }

    @Test
    public void testProcess() {
        Calculator c = new DoCalc();
        try {
            double result = c.process(input);
            if (exception != null) {
                fail("should have thrown an exception: " + exception);
            }

            assertEquals(expected, result, 0.01);
        } catch (Exception e) {
            if (exception == null) {
                fail("should not have thrown an exception, but threw " + e);
            }
            if (!exception.getClass().equals(e.getClass()) || !exception.getMessage().equals(e.getMessage())) {
                fail("expected exception " + exception + "; got exception " + e);
            }
        }
    }
}
