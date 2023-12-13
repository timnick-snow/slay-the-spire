package io.github.snow.spire.beans.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author snow
 * @since 2023/12/13
 */
@Getter
@Setter
public class RoomAmend {
    /*
1. 商店修正：2-3个，12层若当前无商店生成1个，14层若当前只有1个商店生成1个，同一层不会有3个商店
2.  精英修正：6有精英，10/11/12至少1精英
3.  火堆修正：678至少1火堆，10/11/12/13至少1火堆
*/
    private int shopNum;
    private boolean eliteDown;
    private boolean eliteUp;
    private boolean restDown;
    private boolean restUp;
}
