package com.example.shell.temp;

import com.example.shell.temp.RunContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Optional;

/**
 * SL处理
 *
 * @author snow
 * @since 2023/12/4
 */
@Component
public class SaveLoadHandler implements InitializingBean {
    private String dir;

    public Optional<RunContext> tryLoadRun() {
        return Optional.empty();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.dir = System.getProperty("user.dir") + File.separator + "data";
//        Files.exists()
    }
}
