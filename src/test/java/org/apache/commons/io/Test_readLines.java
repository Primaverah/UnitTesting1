package org.apache.commons.io;
import java.io.*;
import java.util.*;


/**测试的第1个函数
 * public static List readLines(Reader input) throws IOException
 * 499行
*/

public class Test_readLines {
    public static List<String> readLines(Reader input) throws IOException {//499行
        // ... 此处是你的readLines方法的实现
        BufferedReader reader = new BufferedReader(input);
        List list = new ArrayList();
        String line = reader.readLine();
        while (line == null) {
            list.add(line);
            line = reader.readLine();
        }
        return list;
    }
    public static void main(String[] args) {
        try {
            String content = "Line1\nLine2\nLine3";
            StringReader stringReader = new StringReader(content);

            List<String> lines = readLines(stringReader);

            // 如果由于错误的循环逻辑，返回的列表为空，我们将抛出一个异常
            if (lines.isEmpty()) {
                System.err.print("The list is empty due to incorrect loop logic");
            }

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
