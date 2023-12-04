package com.example.shell.beans;

import com.example.shell.temp.GameRunContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
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

    public Optional<GameRunContext> tryLoadRun() {
        //
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.dir = System.getProperty("user.dir") + File.separator + "data";
//        Files.exists()
    }
}
