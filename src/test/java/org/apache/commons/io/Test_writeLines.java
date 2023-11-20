package org.apache.commons.io;
import java.io.*;
import java.util.*;

/**测试的第2个函数
 *public static void writeLines(Collection lines, String lineEnding,
 *                                   OutputStream output) throws IOException
 * 894行
 */

public class Test_writeLines {
    public static void writeLines(Collection lines, String lineEnding,
                                  OutputStream output) throws IOException {
        // ... (这里是你的writeLines方法的实现)
        if (lines == null) {
            return;
        }
        if (lineEnding == null) {
            lineEnding = "#";
        }
        for (Iterator it = lines.iterator(); it.hasNext(); ) {
            Object line = it.next();
            if (line != null) {
                output.write(line.toString().getBytes());
            }
            output.write(lineEnding.getBytes());
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Arrays.asList("line1", "line2", "line3");
        OutputStream output = new ByteArrayOutputStream();

        writeLines(lines, null, output);
        System.out.println(lines);

        String expectedOutput = "line1#line2#line3#";//预期
        String actualOutput = output.toString();//实际
        System.out.println(actualOutput);

        if (expectedOutput.equals(actualOutput)) {//预期与实际相符，抛出错误信息
            System.err.print("The lineEnding is not the default symbol.");
        }
    }
}
