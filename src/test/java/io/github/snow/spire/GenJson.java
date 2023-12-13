package io.github.snow.spire;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author snow
 * @since 2023/12/12
 */
public class GenJson {
    public static void main(String[] args) throws Exception {
        String root = "D:\\study\\tmp\\slay-the-spire\\src\\main\\java\\io\\github\\snow\\spire\\items";
        String output = "D:\\study\\tmp\\slay-the-spire\\gen\\reflect-config.json";
        StringBuilder buf = new StringBuilder(2048);
        buf.append("[\n");
        // potion
        Files.list(Paths.get(root, "potion")).forEach(path -> {
            try {
                String template = """
                        {
                          "name":"io.github.snow.spire.items.potion.%s",
                          "methods":[{"name":"<init>","parameterTypes":["java.lang.String"] }]
                        },
                                                """;
                String name = path.getFileName().toString();
                name = name.substring(0, name.indexOf("."));
                byte[] bytes = Files.readAllBytes(Paths.get(path.toUri()));
                String content = new String(bytes);
                if (content.contains("extends UncommonPotion") || content.contains("extends CommonPotion") || content.contains("extends RarePotion")) {
                    buf.append(template.formatted(name));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        // card
        Files.list(Paths.get(root, "card")).forEach(path -> {
            try {
                String template = """
                        {
                          "name":"io.github.snow.spire.items.card.%s",
                          "methods":[{"name":"<init>","parameterTypes":["java.lang.String"%s] }]
                        },
                                                """;
                String name = path.getFileName().toString();
                name = name.substring(0, name.indexOf("."));
                byte[] bytes = Files.readAllBytes(Paths.get(path.toUri()));
                String content = new String(bytes);

                String pt = "";
                if (content.contains("extends CurseCard")) {
                    buf.append(template.formatted(name, pt));
                } else if (content.contains("extends GreenCard")
                        ||content.contains("extends BlueCard")
                        ||content.contains("extends RedCard")
                        ||content.contains("extends ColorlessCard")
                        ||content.contains("extends PurpleCard")) {
                    pt = ",\"int\"";
                    buf.append(template.formatted(name, pt));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        buf.append("]\n");
        Files.writeString(Paths.get(output), buf.toString());
    }
}
