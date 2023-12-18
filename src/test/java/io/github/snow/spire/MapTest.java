package io.github.snow.spire;

import io.github.snow.spire.tool.Output;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author snow
 * @since 2023/12/6
 */
public class MapTest {
    @Test
    public void fun1() throws Exception {
        for (int k = 0; k < 10000; k++) {
            Random blessRandom = new Random();
            int a = blessRandom.nextInt(0, 1000);
            int b = blessRandom.nextInt(0, 1000);
            int c = blessRandom.nextInt(0, 1000);


            int i = 0;
            int size = 7;
            for (int j = 0; j < 100; j++) {
                int random = b + c * i + i + 7;
                int idx = random % size;
                i++;
                if (idx < 0) {
                    System.out.println(idx);
                }
            }
        }
    }
}
