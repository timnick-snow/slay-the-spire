package io.github.snow.spire.beans.pojo;

import io.github.snow.spire.items.core.Fighter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author snow
 * @since 2023/12/18
 */
@Getter
@Setter
@Accessors(chain = true)
public class PlayRule {
    private Fighter master;
}
