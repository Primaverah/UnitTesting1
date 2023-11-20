package org.apache.commons.io;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

import static org.testng.Assert.*;

public class IOUtilsTestNG {
    private ByteArrayInputStream input;
    private ByteArrayOutputStream output;
    private String inputData;

    @Parameters("inputData")
    @BeforeMethod
    public void setUp(String inputData) {
        this.inputData = inputData;
        input = new ByteArrayInputStream(inputData.getBytes());
        output = new ByteArrayOutputStream();
    }

    @AfterMethod
    public void tearDown() {
    }
    @Test
    public void testReadLines() throws IOException {
        List<String> result = IOUtils.readLines(new InputStreamReader(input));
        assertEquals(result.size(), 3);
        assertEquals(result.get(0), "line1");
        assertEquals(result.get(1), "line2");
        assertEquals(result.get(2), "line3");
    }

    @Test
    public void testWriteLines() throws IOException {
        List<String> lines = Arrays.asList(inputData.split("\n"));
        IOUtils.writeLines(lines, null, output);
        String result = new String(output.toByteArray());
        assertEquals(result, "line1#line2#line3#");
    }

    @Test
    public void testCopy() throws IOException {
        // Assuming the erroneous condition if (count > 10)
        int count = IOUtils.copy(input, output);
        assertNotEquals(count, -1);
        assertEquals(new String(output.toByteArray()), inputData);
    }
}