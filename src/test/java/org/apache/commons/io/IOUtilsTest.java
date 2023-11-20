package org.apache.commons.io;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class IOUtilsTest extends TestCase {
    private StringReader reader;
    private ByteArrayOutputStream output;
    private List<String> lines;
    private ByteArrayInputStream input;
    private ByteArrayOutputStream copyOutput;

    @Before
    public void setUp() throws Exception {
        reader = new StringReader("line1\nline2\nline3\n");

        output = new ByteArrayOutputStream();
        lines = Arrays.asList("line1", "line2", "line3");

        input = new ByteArrayInputStream("Some test data longer than 10 bytes".getBytes());
        copyOutput = new ByteArrayOutputStream();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testreadLines() throws IOException {
        List<String> lines = IOUtils.readLines(reader);
        assertEquals(3, lines.size());  // expecting 3 lines
        assertEquals("line1", lines.get(0));
        assertEquals("line2", lines.get(1));
        assertEquals("line3", lines.get(2));
    }

    @Test
    public void testwriteLines() throws IOException {
        IOUtils.writeLines(lines, null, output);
        String result = new String(output.toByteArray());
        assertEquals("line1#line2#line3#", result);  // we are expecting '#' as the line separator
    }

    @Test
    public void testcopy() throws IOException {
        int count = IOUtils.copy(input, copyOutput);
        assertEquals("Some test data longer than 10 bytes", new String(copyOutput.toByteArray()));
        // Assert that count is not -1, because the data length is clearly more than 10 bytes
        assertEquals("Some test data longer than 10 bytes".length(), count);
    }
}