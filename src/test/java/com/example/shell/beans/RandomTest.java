package com.example.shell.beans;

import com.example.shell.map.FloorRooms;
import com.example.shell.map.RoomNode;
import com.example.shell.map.WayBranch;
import com.example.shell.tool.JsonUtil;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

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
    public void fun6() throws Exception {
        FloorRooms f1 = new FloorRooms(1);
        f1.addRoom(new RoomNode(101));
        f1.addRoom(new RoomNode(102));

        FloorRooms f2 = new FloorRooms(2);
        f2.addRoom(new RoomNode(201));
        f2.addRoom(new RoomNode(202));
        f2.addRoom(new RoomNode(203));
        f2.addRoom(new RoomNode(204));

        connect(f2, f1);
    }

    private static void connect(FloorRooms child, FloorRooms parent) {
        List<List<Integer>> strategy = WayBranch.strategy(4, 2, new Random());
        for (int i = 0; i < strategy.size(); i++) {
            RoomNode c = child.getRooms().get(i);
            List<RoomNode> rooms = parent.getRooms();
            for (Integer pid : strategy.get(i)) {
                c.addParentNode(rooms.get(pid));
            }
        }
        System.out.println(strategy);
        System.out.println(JsonUtil.toJsonString(child));
    }

    @Test
    public void fun7() throws Exception {

    }
}
