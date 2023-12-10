package io.github.snow.spire;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Gen {

    public static void main(String[] args) throws Exception {
        String rootDir = System.getProperty("user.dir");
        String basePackage = "io.github.snow.spire";
        String itemPackage = "items.relic";
        String dir = rootDir + "/src/main/java/"
                + basePackage.replaceAll("\\.", "/") + "/"
                + itemPackage.replaceAll("\\.", "/");
        String classPackage = basePackage + "." + itemPackage;

        Resource resource = new DefaultResourceLoader().getResource("relic.txt");
        List<String> lines = IOUtils.readLines(resource.getInputStream(), StandardCharsets.UTF_8);
        String date = LocalDate.now().toString();

        String superClass = "";
        for (String line : lines) {
            if (line.isEmpty()) {
                continue;
            }
            if (line.startsWith("==")) {
                superClass = line.substring(2, line.length() - 2);
                System.out.println(superClass);
                continue;
            }
            String[] split = line.split("\\|\\|");
            String className = Arrays.stream(split[0].trim().split(" "))
                    .map(s -> s.substring(0,1).toUpperCase(Locale.ROOT) + s.substring(1))
                    .reduce("", (s1, s2) -> s1 + s2);

            StringBuilder buf = new StringBuilder(512);
            buf.append("package ").append(classPackage).append(";").append("\n").append("\n");
            buf.append("/**").append("\n");
            buf.append(" * @author snow").append("\n");
            buf.append(" * @since ").append(date).append("\n");
            buf.append(" */").append("\n");
            buf.append("public class ").append(className).append(" extends ")
                    .append(superClass).append(" {").append("\n");
            buf.append("    @Override").append("\n");
            buf.append("    public String name() {").append("\n");
            buf.append("        return \"").append(split[1].trim()).append("\";").append("\n");
            buf.append("    }").append("\n");
            buf.append("\n");

            buf.append("    @Override").append("\n");
            buf.append("    public String description() {").append("\n");
            buf.append("        return \"").append(split[3].trim()).append("\";").append("\n");
            buf.append("    }").append("\n");

            buf.append("}").append("\n");

            String filename = className + ".java";
            Path path = Paths.get(dir, filename);
            Files.writeString(path, buf);
        }
    }


}
