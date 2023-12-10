package io.github.snow.spire.items.map;

import io.github.snow.spire.enums.RoomType;
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
    private List<RoomNode> next;


    public RoomNode(int id) {
        this.id = id;
        this.next = new ArrayList<>();
        this.pids = new ArrayList<>();
    }

    public void addParentNode(RoomNode n) {
        this.next.add(n);
        this.pids.add(n.id);
    }

}
