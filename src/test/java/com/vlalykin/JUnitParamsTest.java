package com.vlalykin;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class JUnitParamsTest {

    static class Container {
        String value = "_1"; // initial

        @Override
        // having toString() is necessary! Without toString() "description" != null and the build passes without errors -)
        public String toString() {
            return "Container{" + "value='" + value + '\'' + '}';
        }
    }

    private Object[] params() {
        Container container = new Container();

        return new Object[]{
                new Object[]{container},
                // the second test leads to build error (mvn test) because JUnitParams is passing description == null
                // however, if you do not use surefire-junit47, then there is no error !
                new Object[]{container},
                new Object[]{new Container()}
        };
    }

    @Test
    @Parameters(method = "params")
    public void test1(Container container) {
        container.value = container.value + container.value;
        System.out.println("value="+container.value);
        assertTrue(true);
    }
}