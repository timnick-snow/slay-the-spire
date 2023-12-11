package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.enums.RelicRarity;
import io.github.snow.spire.items.relic.*;
import io.github.snow.spire.temp.RunContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author snow
 * @since 2023/12/8
 */
@Component
public class RelicManager {
    private final Map<RelicRarity, List<Relic>> relicMap = new HashMap<>();
    private final Map<RelicRarity, Integer> index = new HashMap<>();
    private Random relicRandom;


    public Relic getRelic(RelicRarity rarity) {
        Integer idx = index.get(rarity);
        Relic relic = relicMap.get(rarity).get(idx);
        index.put(rarity, idx + 1);
        return relic;
    }

    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.relicRandom = source.getRandomManage().getRelicRandom();
        this.relicMap.clear();
        this.index.clear();

        registerAll(source.getCharacter());

        for (var entry : relicMap.entrySet()) {
            index.put(entry.getKey(), 0);
            // 随机排序
            Collections.shuffle(entry.getValue(), relicRandom);
        }
    }

    private void registerAll(Characters character) {
        register(new Akabeko(), character);
        register(new Anchor(), character);
        register(new AncientTeaSet(), character);
        register(new ArtOfWar(), character);
        register(new Astrolabe(), character);
        register(new BagOfMarbles(), character);
        register(new BagOfPreparation(), character);
        register(new BirdFacedUrn(), character);
        register(new BlackBlood(), character);
        register(new BlackStar(), character);
        register(new BloodVial(), character);
        register(new BloodyIdol(), character);
        register(new BlueCandle(), character);
        register(new BottledFlame(), character);
        register(new BottledLightning(), character);
        register(new BottledTornado(), character);
        register(new Brimstone(), character);
        register(new BronzeScales(), character);
        register(new BurningBlood(), character);
        register(new BustedCrown(), character);
        register(new Cables(), character);
        register(new Calipers(), character);
        register(new CallingBell(), character);
        register(new CaptainsWheel(), character);
        register(new Cauldron(), character);
        register(new CentennialPuzzle(), character);
        register(new ChampionBelt(), character);
        register(new CharonAshes(), character);
        register(new ChemicalX(), character);
        register(new Circlet(), character);
        register(new CloakClasp(), character);
        register(new ClockworkSouvenir(), character);
        register(new CoffeeDripper(), character);
        register(new CrackedCore(), character);
        register(new CultistMask(), character);
        register(new CursedKey(), character);
        register(new Damaru(), character);
        register(new DarkstonePeriapt(), character);
        register(new DataDisk(), character);
        register(new DeadBranch(), character);
        register(new DollyMirror(), character);
        register(new DreamCatcher(), character);
        register(new Duality(), character);
        register(new DuVuDoll(), character);
        register(new Ectoplasm(), character);
        register(new EmotionChip(), character);
        register(new EmptyCage(), character);
        register(new Enchiridion(), character);
        register(new EternalFeather(), character);
        register(new FaceOfCleric(), character);
        register(new FossilizedHelix(), character);
        register(new FrozenCore(), character);
        register(new FrozenEgg(), character);
        register(new FrozenEye(), character);
        register(new FusionHammer(), character);
        register(new GamblingChip(), character);
        register(new Ginger(), character);
        register(new Girya(), character);
        register(new GoldenEye(), character);
        register(new GoldenIdol(), character);
        register(new GremlinHorn(), character);
        register(new GremlinMask(), character);
        register(new HandDrill(), character);
        register(new HappyFlower(), character);
        register(new HolyWater(), character);
        register(new HornCleat(), character);
        register(new HoveringKite(), character);
        register(new IceCream(), character);
        register(new IncenseBurner(), character);
        register(new InkBottle(), character);
        register(new Inserter(), character);
        register(new JuzuBracelet(), character);
        register(new Kunai(), character);
        register(new Lantern(), character);
        register(new LeeWaffle(), character);
        register(new LetterOpener(), character);
        register(new LizardTail(), character);
        register(new MagicFlower(), character);
        register(new Mango(), character);
        register(new MarkOfPain(), character);
        register(new MarkOfTheBloom(), character);
        register(new Matryoshka(), character);
        register(new MawBank(), character);
        register(new MealTicket(), character);
        register(new MeatOnTheBone(), character);
        register(new MedicalKit(), character);
        register(new Melange(), character);
        register(new MembershipCard(), character);
        register(new MercuryHourglass(), character);
        register(new MoltenEgg(), character);
        register(new MummifiedHand(), character);
        register(new MutagenicStrength(), character);
        register(new Necronomicon(), character);
        register(new NeowsBlessing(), character);
        register(new NilryCodex(), character);
        register(new NinjaScroll(), character);
        register(new NlothGift(), character);
        register(new NlothsMask(), character);
        register(new NuclearBattery(), character);
        register(new Nunchaku(), character);
        register(new OddlySmoothStone(), character);
        register(new OddMushroom(), character);
        register(new OldCoin(), character);
        register(new Omamori(), character);
        register(new OrangePellets(), character);
        register(new Orichalcum(), character);
        register(new OrnamentalFan(), character);
        register(new Orrery(), character);
        register(new PandoraBox(), character);
        register(new Pantograph(), character);
        register(new PaperCrane(), character);
        register(new PaperFrog(), character);
        register(new PeacePipe(), character);
        register(new Pear(), character);
        register(new PenNib(), character);
        register(new PhilosopherStone(), character);
        register(new Pocketwatch(), character);
        register(new PotionBelt(), character);
        register(new PrayerWheel(), character);
        register(new PreservedInsect(), character);
        register(new PrismaticShard(), character);
        register(new PureWater(), character);
        register(new QuestionCard(), character);
        register(new RedMask(), character);
        register(new RedSkull(), character);
        register(new RegalPillow(), character);
        register(new RingOfTheSerpent(), character);
        register(new RingOfTheSnake(), character);
        register(new RunicCapacitor(), character);
        register(new RunicCube(), character);
        register(new RunicDome(), character);
        register(new RunicPyramid(), character);
        register(new SacredBark(), character);
        register(new SelfFormingClay(), character);
        register(new Shovel(), character);
        register(new Shuriken(), character);
        register(new SingingBowl(), character);
        register(new SlaversCollar(), character);
        register(new SlingOfCourage(), character);
        register(new SmilingMask(), character);
        register(new SneckoHead(), character);
        register(new SneckoSkull(), character);
        register(new SneckoEye(), character);
        register(new Sozu(), character);
        register(new SpiritPoop(), character);
        register(new StoneCalendar(), character);
        register(new StrangeSpoon(), character);
        register(new Strawberry(), character);
        register(new StrikeDummy(), character);
        register(new Sundial(), character);
        register(new SymbioticVirus(), character);
        register(new TeardropLocket(), character);
        register(new TheAbacus(), character);
        register(new TheBoot(), character);
        register(new TheCourier(), character);
        register(new TheSpecimen(), character);
        register(new ThreadAndNeedle(), character);
        register(new Tingsha(), character);
        register(new TinyChest(), character);
        register(new TinyHouse(), character);
        register(new Toolbox(), character);
        register(new Torii(), character);
        register(new ToughBandages(), character);
        register(new ToxicEgg(), character);
        register(new ToyOrnithopter(), character);
        register(new TungstenRod(), character);
        register(new Turnip(), character);
        register(new TwistedFunnel(), character);
        register(new UnceasingTop(), character);
        register(new Vajra(), character);
        register(new VelvetChoker(), character);
        register(new VioletLotus(), character);
        register(new WarPaint(), character);
        register(new WarpedTongs(), character);
        register(new Whetstone(), character);
        register(new WhiteBeastStatue(), character);
        register(new WingedGreaves(), character);
        register(new WristBlade(), character);
    }

    private void register(Relic relic, Characters character) {
        Characters specific = relic.classSpecific();
        if (specific != null && specific != character) {
            return;
        }
        List<Relic> list = relicMap.getOrDefault(relic.rarity(), new ArrayList<>());
        list.add(relic);
        relicMap.put(relic.rarity(), list);
    }

}
