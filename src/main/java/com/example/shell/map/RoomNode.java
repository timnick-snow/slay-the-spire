package com.example.shell.map;

import com.example.shell.enums.RoomType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/5
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RoomNode {
    private int id;
    private RoomType roomType;
    private List<Integer> pids;
    @JsonIgnore
    private List<RoomNode> parents;


    public RoomNode(int id) {
        this.id = id;
        this.parents = new ArrayList<>();
        this.pids = new ArrayList<>();
    }

    public void addParentNode(RoomNode n) {
        this.parents.add(n);
        this.pids.add(n.id);
    }

}
