package com.sample;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SampleTest {
    @Test
    public void createSample() {
        Sample target = new Sample();
        target.createText();
        assertEquals(1,1);
    }
}
