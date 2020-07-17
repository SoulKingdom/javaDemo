package com.example.junittest.query;

import java.util.Scanner;

/**
 * @Author : leih
 * @Date : 2020/7/16 19:50
 * @Version : 1.0
 * @Description : TODO
 * @ClassName : TestMain
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        HandlerServer h = new HandlerServer();
        //设置生产者
        Send re = new Send(h);

        for (int i = 0; i < 100; i++) {

            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();

            StringBuilder stringbuilder = new StringBuilder();

            while (true) {
                String text = scanner.nextLine().trim();
                if ("".equals(text)) {
                    break;
                }
                stringbuilder.append(text);
            }
            //设置数据
            ImagePojo imagePojo = new ImagePojo();
            imagePojo.setId(i + "");
            imagePojo.setName(nextLine);
            //添加生产者
            re.put(imagePojo);
        }
    }
}
