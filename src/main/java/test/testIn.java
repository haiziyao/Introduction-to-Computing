package test;

import com.hzyxsj.app.In;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class testIn {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/detail.properties"));
        String message = "这是一段测试代码，this is a test";
        String testimg=properties.getProperty("testimg");
        String resultimg=properties.getProperty("resultimg");
        new In().EncodeMegToImg(message ,testimg ,resultimg);
        System.out.println("结束");

    }
}
