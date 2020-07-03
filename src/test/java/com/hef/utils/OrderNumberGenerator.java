package com.hef.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
public class OrderNumberGenerator {


    public static String[] chars = new String[]{"1", "2", "3", "4", "5", "6",
            "7", "8", "9", "0"};


    @Test
    public void generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 16; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        System.out.println(shortBuffer.toString());
    }


}
