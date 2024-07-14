package com.example.lottrey;

import lottery.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class LottreyApplicationTests {

    @Autowired
    private JwtHelper jwtHelper;

    @Test
    void test1() {
//        String token = jwtHelper.createToken(123L);
//        System.out.println(token);

        System.out.println(jwtHelper.getUserId("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsInppcCI6IkdaSVAifQ" +
                ".H4sIAAAAAAAA_6tWKi5NUrJSqizJLlbSUUqtKFCyMjQ3MrA0NjU2N9BRKi1OLfJMAYoZGdcCAL5FOucsAAAA" +
                ".2RgLhcXgIhxJtg5RVZm3yDeOX7pZWjH4pKsM_Ztnh5c"));
    }


    @Test
    void contextLoads() {
        Integer[] i = {1231, 21321, 21, 321, 321, 3, 1};
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : i) {
            list.add(integer);
        }
//        for (Integer p : list) {
//            list.remove(p);
//        }


        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 21321) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }

}
