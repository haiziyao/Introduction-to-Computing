package test;

import com.hzyxsj.app.Out;

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
public class testOut {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/detail.properties"));
        String decodeimg=properties.getProperty("resultimg");
        String filepath=properties.getProperty("testfile");
        new Out().decodeImgToMessage(decodeimg,filepath);
    }
}
