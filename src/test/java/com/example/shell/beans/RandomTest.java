package com.example.shell.beans;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

/**
 * @author snow
 * @since 2023/12/4
 */
public class RandomTest implements WithAssertions {

    @Test
    public void fun1() throws Exception {
        System.out.println(RandomManage.genSeed());
    }

    @Test
    public void fun2() throws Exception {
        System.out.println(String.format("%-4s", " M"));
        System.out.println(String.format("%-4s", " M!"));
        System.out.println(String.format("%-4s", " M*"));
        System.out.println(String.format("%-4s", " R!"));
        System.out.println(String.format("%-4s", " T!"));
    }
}
