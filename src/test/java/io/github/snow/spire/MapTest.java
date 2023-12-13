package io.github.snow.spire;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author snow
 * @since 2023/12/6
 */
public class MapTest {
    @Test
    public void fun1() throws Exception {
        long seed = 123;
        for (int i = 0; i < 100; i++) {
            Random mapRandom = new Random(seed * 17 + i * 31 + 1);
//            MapHandler.genActMap(0, mapRandom);
        }
    }
}
