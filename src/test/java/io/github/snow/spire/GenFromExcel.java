package io.github.snow.spire;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;

@Slf4j
public class GenFromExcel {
    public static void main(String[] args) throws Exception {
        String rootDir = System.getProperty("user.dir");
        String basePackage = "io.github.snow.spire";
        String itemPackage = "items.card";
        String dir = rootDir + "/gen/"
                + basePackage.replaceAll("\\.", "/") + "/"
                + itemPackage.replaceAll("\\.", "/");
        String classPackage = basePackage + "." + itemPackage;
        Path path = Paths.get(dir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        String fileName = "C:\\Users\\28087\\Documents\\临时文件.xlsx";
        String template = """
                package io.github.snow.spire.items.card;

                import io.github.snow.spire.enums.CardRarity;
                import io.github.snow.spire.enums.CardType;

                /**
                 * @author snow
                 * @since 2023/12/12
                 */
                public class %s extends %s {
                    private static final String DESC = "%s";
                    private static final String DESC1 = "%s";

                    public %s(String id, int level) {
                        super(id, level);
                    }

                    @Override
                    public String baseName() {
                        return "%s";
                    }

                    @Override
                    public CardType type() {
                        return CardType.%s;
                    }

                    @Override
                    public CardRarity rarity() {
                        return CardRarity.%s;
                    }

                    @Override
                    public int cost() {
                        return %s;
                    }

                    @Override
                    public String description() {
                        return level == 0 ? DESC : DESC1;
                    }

                    @Override
                    public String upgradeDescription() {
                        return DESC1;
                    }
                }
                                """;
        EasyExcel.read(fileName, CardData.class, new ReadListener<CardData>() {

            @Override
            public void invoke(CardData data, AnalysisContext context) {
                if (data.color.trim().equals("诅咒")) {
                    return;
                }
                String superClass = switch (data.color.trim()) {
                    case "绿色" -> "GreenCard";
                    case "蓝色" -> "BlueCard";
                    case "红色" -> "RedCard";
                    case "无色" -> "ColorlessCard";
                    case "紫色" -> "PurpleCard";
                    default -> throw new IllegalStateException("Unexpected value: " + data.color.trim());
                };

                String className = Arrays.stream(data.name_en.trim().split(" "))
                        .map(s -> s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1))
                        .reduce("", (s1, s2) -> s1 + s2).replaceAll("[_\\-]", "");
                data.setName_en(className);
                String type = switch (data.type.trim()) {
                    case "攻击" -> "ATTACK";
                    case "技能" -> "SKILL";
                    case "能力" -> "POWER";
                    case "诅咒" -> "CURSE";
                    case "状态" -> "STATUS";
                    default -> throw new IllegalStateException("Unexpected value: " + data.type);
                };
                data.setType(type);
                String rarity = switch (data.rarity.trim()) {
                    case "初始" -> "STARTER";
                    case "普通" -> "COMMON";
                    case "罕见" -> "UNCOMMON";
                    case "稀有" -> "RARE";
                    case "诅咒" -> "CURSE";
                    case "特殊" -> "SPECIAL";
                    default -> throw new IllegalStateException("Unexpected value: " + data.rarity);
                };
                data.setRarity(rarity);
                data.setDesc0(handleDesc(data.desc0));
                data.setDesc1(handleDesc(data.desc1));

                String javaStr = template.formatted(data.name_en, superClass, data.desc0, data.desc1, data.name_en, data.name.trim(),
                        data.type, data.rarity, data.getCost());
                Path path = Paths.get(dir, data.name_en + ".java");
                try {
                    Files.writeString(path, javaStr);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            private String handleDesc(String desc) {
                if (ObjectUtils.isEmpty(desc)) {
                    return desc;
                }
                desc = desc.replaceAll("<br>", "");
                desc = desc.replaceAll("\\{\\{(KW|Card_link)\\|(.+?)}}", " 【$2】 ");
                return desc;
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {

            }

        }).sheet(2).doRead();


    }

    @Getter
    @Setter
    public static class CardData {
        private String name;
        private String name_en;
        private String color;
        private String type;
        private String rarity;
        private int cost0;
        private String desc0;
        private int cost1;
        private String desc1;

        public String getCost() {
            if (cost0 == cost1) {
                return String.valueOf(cost0);
            }
            return "level == 0 ? %d : %d".formatted(cost0, cost1);
        }
    }
}
