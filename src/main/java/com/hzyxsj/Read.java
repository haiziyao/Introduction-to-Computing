package com.hzyxsj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class Read {
  public void readfile(String filename) throws IOException {
      FileInputStream fis = new FileInputStream(new File(filename));
      byte[] buffer = new byte[1024];
      int length;
      StringBuffer result = new StringBuffer();
      while ((length=fis.read(buffer))!=-1){
          String string = buffer.toString();
          for (int i = 0; i < string.length(); i += 8) {
              String byteString = string.substring(i, i + 8);
              // 将8位二进制转换为对应的字符
              char character = (char) Integer.parseInt(byteString, 2);
              result.append(character);
          }
      }
      fis.close();
      System.out.println(result);
      System.out.println("读取结束");
  }
}
