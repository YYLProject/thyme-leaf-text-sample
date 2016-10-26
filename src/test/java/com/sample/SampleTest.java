package com.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


public class SampleTest {
    @Test
    public void createSample() {
        Sample target = new Sample();
        target.createText();
        // check if sample.txt created
        Path path = Paths.get("out", "sample.txt");
        boolean result = Files.exists(path);
        assertTrue("should be exists", result);
    }
}
