package com.hzyxsj.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class writeFile {
    public void write(String fileName, String content) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,false));
        bufferedWriter.write("解码后：");
        bufferedWriter.write(content);
        bufferedWriter.close();
    }
}
