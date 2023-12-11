package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.enums.PotionRarity;
import io.github.snow.spire.items.potion.*;
import io.github.snow.spire.temp.RunContext;
import io.github.snow.spire.tool.RandomUtil;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author snow
 * @since 2023/12/11
 */
@Component
public class PotionManager {
    private final Map<PotionRarity, List<Potion>> potionMap = new HashMap<>();
    private Random potionRandom;
    /*
     * 普通 - 65%
     * 罕见 - 25%
     * 稀有 - 10%
     */
    private static final int[] ODDS = {650, 250, 100};

    public Potion getPotion(String id) {
        int a = potionRandom.nextInt(0, 1000);
        int b = potionRandom.nextInt(0, 1000);

        int idx = RandomUtil.randomIndex(ODDS, a);
        PotionRarity rarity = switch (idx) {
            case 0 -> PotionRarity.COMMON;
            case 1 -> PotionRarity.UNCOMMON;
            case 2 -> PotionRarity.RARE;
            default -> throw new IllegalStateException("Unexpected value: " + idx);
        };

        List<Potion> potions = potionMap.get(rarity);
        Potion potion = potions.get(b % potions.size());
        return potion.copy(id);
    }

    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.potionRandom = source.getRandomManage().getPotionRandom();
        this.potionMap.clear();

        registerAll(source.getCharacter());
    }

    private void registerAll(Characters character) {
        register(new Ambrosia(null), character);
        register(new AncientPotion(null), character);
        register(new AttackPotion(null), character);
        register(new BlessingOfTheForge(null), character);
        register(new BlockPotion(null), character);
        register(new BloodPotion(null), character);
        register(new BottledMiracle(null), character);
        register(new ColorlessPotion(null), character);
        register(new CultistPotion(null), character);
        register(new CunningPotion(null), character);
        register(new DexterityPotion(null), character);
        register(new DistilledChaos(null), character);
        register(new DuplicationPotion(null), character);
        register(new ElixirPotion(null), character);
        register(new EnergyPotion(null), character);
        register(new EntropicBrew(null), character);
        register(new EssenceOfDarkness(null), character);
        register(new EssenceOfSteel(null), character);
        register(new FairyPotion(null), character);
        register(new FearPotion(null), character);
        register(new FirePotion(null), character);
        register(new FocusPotion(null), character);
        register(new FruitJuice(null), character);
        register(new GamblersBrew(null), character);
        register(new GhostInAJar(null), character);
        register(new HeartOfIron(null), character);
        register(new LiquidBronze(null), character);
        register(new LiquidMemories(null), character);
        register(new PoisonPotion(null), character);
        register(new PotionOfCapacity(null), character);
        register(new PowerPotion(null), character);
        register(new RegenPotion(null), character);
        register(new SkillPotion(null), character);
        register(new SmokeBomb(null), character);
        register(new SneckoOil(null), character);
        register(new SpeedPotion(null), character);
        register(new StancePotion(null), character);
        register(new SteroidPotion(null), character);
        register(new StrengthPotion(null), character);
        register(new SwiftPotion(null), character);
        register(new WeakPotion(null), character);
    }

    private void register(Potion potion, Characters character) {
        Characters specific = potion.classSpecific();
        if (specific != null && specific != character) {
            return;
        }
        List<Potion> list = potionMap.getOrDefault(potion.getRarity(), new ArrayList<>());
        list.add(potion);
        potionMap.put(potion.getRarity(), list);
    }
}
