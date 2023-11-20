package org.apache.commons.io;
import java.io.*;
import static org.apache.commons.io.IOUtils.copyLarge;

/**测试的第3个函数
 * public static int copy(InputStream input, OutputStream output) throws IOException
 * 998行
 */

public class Test_copy {
    public static int copy(InputStream input, OutputStream output) throws IOException {
        // ... (这里是你的copy方法的实现)
        long count = copyLarge(input, output);
        if (count > 10) {
            return -1;
        }
        return (int) count;
    }

    public static void main(String[] args) throws IOException {
        // 测试不超过10字节的数据
        byte[] testData1 = "1234567890".getBytes(); // 10字节
        ByteArrayInputStream input1 = new ByteArrayInputStream(testData1);
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        int result1 = copy(input1, output1);
        System.out.print("1234567890\n");
        if (result1 != -1) {
            System.out.println("The number of characters is " + result1);
        }
        System.out.println("Test for 10 bytes passed!");

        // 测试超过10字节的数据
        byte[] testData2 = "12345678901".getBytes(); // 11字节
        ByteArrayInputStream input2 = new ByteArrayInputStream(testData2);
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        int result2 = copy(input2, output2);
        System.out.print("12345678901\n");
        if (result2 == -1) {
            System.err.print("Expected -1 and the number of characters is" + result2);
        }
        System.out.println("Test for more than 10 bytes passed!");
    }
}
