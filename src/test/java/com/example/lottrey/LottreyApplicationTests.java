package com.example.lottrey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class LottreyApplicationTests {

    @Test
    void contextLoads() {
        Integer[] i = {1231,21321,21,321,321,3,1};
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : i) {
            list.add(integer);
        }
//        for (Integer p : list) {
//            list.remove(p);
//        }


        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if (next == 21321){
                iterator.remove();
            }
        }

        System.out.println(list);
    }

}
