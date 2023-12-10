package io.github.snow.spire;

import io.github.snow.spire.items.map.FloorRooms;
import io.github.snow.spire.items.map.RoomNode;
import io.github.snow.spire.temp.RandomManage;
import io.github.snow.spire.tool.JsonUtil;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;
import java.util.List;

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

    @Test
    public void fun3() throws Exception {
        StringBuilder sb = new StringBuilder();
        String text = "M!";
        int width = 9;
        int space = width - text.length();
        sb.append("*".repeat(space / 2)).append(text)
                .append("*".repeat((space + 1) / 2));
        System.out.println(sb);
    }

    @Test
    public void fun4() throws Exception {
//        List<MapNode>[][] gen = MapHandler.gen(new Random());
//        String format = MapHandler.format(gen[0]);
//        System.out.println(format);
    }

    @Test
    public void fun5() throws Exception {
        Resource resource = new DefaultResourceLoader().getResource("temp.txt");
        List<String> lines = IOUtils.readLines(resource.getInputStream(), StandardCharsets.UTF_8);

        int[][] arr = new int[7][7];
        for (String line : lines) {
            String[] split = line.split(" ");
            for (int i = 1; i < split.length; i++) {
                arr[Integer.parseInt(split[i - 1])][Integer.parseInt(split[i])] += 1;
            }
        }
        System.out.println(JsonUtil.toJsonString(arr));
    }

    @Test
    public void fun7() throws Exception {

    }
}
