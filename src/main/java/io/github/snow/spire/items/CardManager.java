package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.items.card.*;
import io.github.snow.spire.items.card.Stack;
import io.github.snow.spire.temp.RunContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

import static io.github.snow.spire.tool.FormatUtil.center;

/**
 * @author snow
 * @since 2023/12/12
 */
@Component
public class CardManager {
    private final List<Card> cardList = new ArrayList<>(256);
    private Random otherRandom;
    private Random rewardRandom;


    public List<Card> getRandoms(Predicate<Card> filter, List<String> ids) {
        List<Card> list = cardList.stream().filter(filter).toList();
        List<Card> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String id : ids) {
            while (true) {
                int value = otherRandom.nextInt(0, 1000);
                Card card = list.get(value % list.size());
                if (!set.contains(card.name())) {
                    set.add(card.name());
                    res.add(card.copy(id));
                    break;
                }
            }
        }
        return res;
    }

    public Card getRandom(Predicate<Card> filter, String id) {
        List<Card> list = cardList.stream().filter(filter).toList();
        int value = otherRandom.nextInt(0, 1000);
        Card card = list.get(value % list.size());
        return card.copy(id);
    }


    public String format(List<Card> cards, boolean verbose) {
        String res = "数量: %d".formatted(cards.size()) + "\n";
        StringBuilder buf = new StringBuilder();
        if (verbose) {
/*
--------------------------------------------------------------------------------------------------
|  id  |   名称   | 颜色 | 类型 | 耗能 | 稀有度 | 描述
--------------------------------------------------------------------------------------------------
| c101 |   打击   | 红色 | 攻击 |  1  |  初始  | 造成6点伤害。造成6点伤害。造成6点伤害。造成6点伤害。造成6点...
 */
            String divide = "--------------------------------------------------------------------------------------------------\n";
            buf.append(divide)
                    .append("|  id  |   名称   | 颜色 | 类型 | 耗能 | 稀有度 | 描述\n")
                    .append(divide);
            for (Card card : cards) {
                buf.append("|").append(center(card.id(), 6));
                buf.append("|").append(center(card.name(), 8));
                buf.append("|").append(center(card.color().getDisplay(), 4));
                buf.append("|").append(center(card.type().getDisplay(), 4));
                // 耗能
                buf.append("|").append(center(card.costDisplay(), 6));
                buf.append("|").append(center(card.rarity().getDisplay(), 6));
                // 描述
                buf.append("| ");
                if (card.description().length() <= 32) {
                    buf.append(card.description());
                } else {
                    buf.append(card.description(), 0, 32).append("...");
                }
                buf.append("\n");
            }
        } else {
            // 简要的
            for (int i = 0; i < cards.size(); i++) {
                buf.append(cards.get(i).name());
                if (i == cards.size() - 1) {
                    break;
                }
                if (i % 5 == 4) {
                    buf.append("\n");
                } else {
                    buf.append("\t\t\t");
                }
            }
        }
        buf.append("\n");
        res += buf;
        return res;
    }


    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.rewardRandom = source.getRandomManage().getRewardRandom();
        this.otherRandom = source.getRandomManage().getOtherRandom();
        this.cardList.clear();

        registerAll();
    }

    private void registerAll() {
        register(new Accuracy(null, 0));
        register(new Acrobatics(null, 0));
        register(new Adrenaline(null, 0));
        register(new AfterImage(null, 0));
        register(new Aggregate(null, 0));
        register(new AllForOne(null, 0));
        register(new AllOutAttack(null, 0));
        register(new Alpha(null, 0));
        register(new Amplify(null, 0));
        register(new Anger(null, 0));
        register(new Apotheosis(null, 0));
        register(new Armaments(null, 0));
        register(new AThousandCuts(null, 0));
        register(new AutoShields(null, 0));
        register(new Backflip(null, 0));
        register(new Backstab(null, 0));
        register(new BallLightning(null, 0));
        register(new BandageUp(null, 0));
        register(new Bane(null, 0));
        register(new Barrage(null, 0));
        register(new Barricade(null, 0));
        register(new Bash(null, 0));
        register(new BattleHymn(null, 0));
        register(new BattleTrance(null, 0));
        register(new BeamCell(null, 0));
        register(new Berserk(null, 0));
        register(new Beta(null, 0));
        register(new BiasedCognition(null, 0));
        register(new Bite(null, 0));
        register(new BladeDance(null, 0));
        register(new Blasphemy(null, 0));
        register(new Blind(null, 0));
        register(new Blizzard(null, 0));
        register(new BloodForBlood(null, 0));
        register(new Bloodletting(null, 0));
        register(new Bludgeon(null, 0));
        register(new Blur(null, 0));
        register(new BodySlam(null, 0));
        register(new BootSequence(null, 0));
        register(new BouncingFlask(null, 0));
        register(new BowlingBash(null, 0));
        register(new Brilliance(null, 0));
        register(new Brutality(null, 0));
        register(new Buffer(null, 0));
        register(new BulletTime(null, 0));
        register(new Burn(null, 0));
        register(new BurningPact(null, 0));
        register(new Burst(null, 0));
        register(new CalculatedGamble(null, 0));
        register(new Caltrops(null, 0));
        register(new Capacitor(null, 0));
        register(new Carnage(null, 0));
        register(new CarveReality(null, 0));
        register(new Catalyst(null, 0));
        register(new Chaos(null, 0));
        register(new Chill(null, 0));
        register(new Choke(null, 0));
        register(new Chrysalis(null, 0));
        register(new Clash(null, 0));
        register(new Cleave(null, 0));
        register(new CloakAndDagger(null, 0));
        register(new Clothesline(null, 0));
        register(new Clumsy(null));
        register(new ColdSnap(null, 0));
        register(new Collect(null, 0));
        register(new Combust(null, 0));
        register(new CompileDriver(null, 0));
        register(new Concentrate(null, 0));
        register(new Conclude(null, 0));
        register(new ConjureBlade(null, 0));
        register(new Consecrate(null, 0));
        register(new ConserveBattery(null, 0));
        register(new Consume(null, 0));
        register(new Coolheaded(null, 0));
        register(new CoreSurge(null, 0));
        register(new CorpseExplosion(null, 0));
        register(new Corruption(null, 0));
        register(new CreativeAI(null, 0));
        register(new Crescendo(null, 0));
        register(new CripplingPoison(null, 0));
        register(new CrushJoints(null, 0));
        register(new CurseOfTheBell(null));
        register(new CutThroughFate(null, 0));
        register(new DaggerSpray(null, 0));
        register(new DaggerThrow(null, 0));
        register(new DarkEmbrace(null, 0));
        register(new Darkness(null, 0));
        register(new DarkShackles(null, 0));
        register(new Dash(null, 0));
        register(new Dazed(null, 0));
        register(new DeadlyPoison(null, 0));
        register(new Decay(null));
        register(new DeceiveReality(null, 0));
        register(new DeepBreath(null, 0));
        register(new Defend(null, 0));
        register(new Deflect(null, 0));
        register(new Defragment(null, 0));
        register(new DemonForm(null, 0));
        register(new DeusExMachina(null, 0));
        register(new DevaForm(null, 0));
        register(new Devotion(null, 0));
        register(new DieDieDie(null, 0));
        register(new Disarm(null, 0));
        register(new Discovery(null, 0));
        register(new Distraction(null, 0));
        register(new DodgeAndRoll(null, 0));
        register(new DoomAndGloom(null, 0));
        register(new Doppelganger(null, 0));
        register(new DoubleEnergy(null, 0));
        register(new DoubleTap(null, 0));
        register(new Doubt(null));
        register(new DramaticEntrance(null, 0));
        register(new Dropkick(null, 0));
        register(new Dualcast(null, 0));
        register(new DualWield(null, 0));
        register(new EchoForm(null, 0));
        register(new Electrodynamics(null, 0));
        register(new EmptyBody(null, 0));
        register(new EmptyFist(null, 0));
        register(new EmptyMind(null, 0));
        register(new EndlessAgony(null, 0));
        register(new Enlightenment(null, 0));
        register(new Entrench(null, 0));
        register(new Envenom(null, 0));
        register(new Eruption(null, 0));
        register(new EscapePlan(null, 0));
        register(new Establishment(null, 0));
        register(new Evaluate(null, 0));
        register(new Eviscerate(null, 0));
        register(new Evolve(null, 0));
        register(new Exhume(null, 0));
        register(new Expertise(null, 0));
        register(new Expunger(null, 0));
        register(new Fasting(null, 0));
        register(new FearNoEvil(null, 0));
        register(new Feed(null, 0));
        register(new FeelNoPain(null, 0));
        register(new FiendFire(null, 0));
        register(new Finesse(null, 0));
        register(new Finisher(null, 0));
        register(new FireBreathing(null, 0));
        register(new Fission(null, 0));
        register(new FlameBarrier(null, 0));
        register(new FlashOfSteel(null, 0));
        register(new Flechettes(null, 0));
        register(new Flex(null, 0));
        register(new FlurryOfBlows(null, 0));
        register(new FlyingKnee(null, 0));
        register(new FlyingSleeves(null, 0));
        register(new FollowUp(null, 0));
        register(new Footwork(null, 0));
        register(new ForceField(null, 0));
        register(new ForeignInfluence(null, 0));
        register(new Foresight(null, 0));
        register(new Forethought(null, 0));
        register(new FTL(null, 0));
        register(new Fusion(null, 0));
        register(new Gash(null, 0));
        register(new GeneticAlgorithm(null, 0));
        register(new Ghostly(null, 0));
        register(new GhostlyArmor(null, 0));
        register(new Glacier(null, 0));
        register(new GlassKnife(null, 0));
        register(new GoForTheEyes(null, 0));
        register(new GoodInstincts(null, 0));
        register(new GrandFinale(null, 0));
        register(new Halt(null, 0));
        register(new HandOfGreed(null, 0));
        register(new Havoc(null, 0));
        register(new HeadButt(null, 0));
        register(new Heatsinks(null, 0));
        register(new HeavyBlade(null, 0));
        register(new HeelHook(null, 0));
        register(new HelloWorld(null, 0));
        register(new Hemokinesis(null, 0));
        register(new Hologram(null, 0));
        register(new Hyperbeam(null, 0));
        register(new Immolate(null, 0));
        register(new Impatience(null, 0));
        register(new Impervious(null, 0));
        register(new Indignation(null, 0));
        register(new InfernalBlade(null, 0));
        register(new InfiniteBlades(null, 0));
        register(new Inflame(null, 0));
        register(new Injury(null));
        register(new InnerPeace(null, 0));
        register(new Insight(null, 0));
        register(new Intimidate(null, 0));
        register(new IronWave(null, 0));
        register(new JackOfAllTrades(null, 0));
        register(new JAX(null, 0));
        register(new Judgment(null, 0));
        register(new Juggernaut(null, 0));
        register(new JustLuck(null, 0));
        register(new Leap(null, 0));
        register(new LegSweep(null, 0));
        register(new LessonLearned(null, 0));
        register(new LikeWater(null, 0));
        register(new LimitBreak(null, 0));
        register(new Lockon(null, 0));
        register(new Loop(null, 0));
        register(new MachineLearning(null, 0));
        register(new Madness(null, 0));
        register(new Magnetism(null, 0));
        register(new Malaise(null, 0));
        register(new MasterfulStab(null, 0));
        register(new MasterOfStrategy(null, 0));
        register(new MasterReality(null, 0));
        register(new Mayhem(null, 0));
        register(new Meditate(null, 0));
        register(new Melter(null, 0));
        register(new MentalFortress(null, 0));
        register(new Metallicize(null, 0));
        register(new Metamorphosis(null, 0));
        register(new MeteorStrike(null, 0));
        register(new MindBlast(null, 0));
        register(new Miracle(null, 0));
        register(new MultiCast(null, 0));
        register(new NecronomiCurse(null));
        register(new Neutralize(null, 0));
        register(new NightTerror(null, 0));
        register(new Nirvana(null, 0));
        register(new Normality(null));
        register(new NoxiousFumes(null, 0));
        register(new Offering(null, 0));
        register(new Omega(null, 0));
        register(new Omniscience(null, 0));
        register(new Outmaneuver(null, 0));
        register(new Pain(null));
        register(new Panacea(null, 0));
        register(new Panache(null, 0));
        register(new PanicButton(null, 0));
        register(new Parasite(null));
        register(new PerfectedStrike(null, 0));
        register(new Perseverance(null, 0));
        register(new PhantasmalKiller(null, 0));
        register(new PiercingWail(null, 0));
        register(new PoisonedStab(null, 0));
        register(new PommelStrike(null, 0));
        register(new PowerThrough(null, 0));
        register(new Pray(null, 0));
        register(new Predator(null, 0));
        register(new Prepared(null, 0));
        register(new PressurePoints(null, 0));
        register(new Prostrate(null, 0));
        register(new Protect(null, 0));
        register(new Pummel(null, 0));
        register(new Purity(null, 0));
        register(new QuickSlash(null, 0));
        register(new Rage(null, 0));
        register(new Ragnarok(null, 0));
        register(new Rainbow(null, 0));
        register(new Rampage(null, 0));
        register(new ReachHeaven(null, 0));
        register(new Reaper(null, 0));
        register(new Reboot(null, 0));
        register(new Rebound(null, 0));
        register(new RecklessCharge(null, 0));
        register(new Recycle(null, 0));
        register(new RedDefend(null, 0));
        register(new Redo(null, 0));
        register(new RedStrike(null, 0));
        register(new Reflex(null, 0));
        register(new Regret(null));
        register(new ReinforcedBody(null, 0));
        register(new Reprogram(null, 0));
        register(new RiddleWithHoles(null, 0));
        register(new RipAndTear(null, 0));
        register(new RitualDagger(null, 0));
        register(new Rupture(null, 0));
        register(new Rushdown(null, 0));
        register(new SadisticNature(null, 0));
        register(new Safety(null, 0));
        register(new Sanctity(null, 0));
        register(new SandsOfTime(null, 0));
        register(new SashWhip(null, 0));
        register(new Scrape(null, 0));
        register(new Scrawl(null, 0));
        register(new SearingBlow(null, 0));
        register(new SecondWind(null, 0));
        register(new SecretTechnique(null, 0));
        register(new SecretWeapon(null, 0));
        register(new SeeingRed(null, 0));
        register(new Seek(null, 0));
        register(new SelfRepair(null, 0));
        register(new Sentinel(null, 0));
        register(new Setup(null, 0));
        register(new SeverSoul(null, 0));
        register(new Shame(null));
        register(new Shiv(null, 0));
        register(new Shockwave(null, 0));
        register(new ShrugItOff(null, 0));
        register(new SignatureMove(null, 0));
        register(new SimmeringFury(null, 0));
        register(new Skewer(null, 0));
        register(new Skim(null, 0));
        register(new Slice(null, 0));
        register(new Slimed(null, 0));
        register(new Smite(null, 0));
        register(new SneakyStrike(null, 0));
        register(new SpiritShield(null, 0));
        register(new SpotWeakness(null, 0));
        register(new Stack(null, 0));
        register(new StaticDischarge(null, 0));
        register(new Steam(null, 0));
        register(new SteamPower(null, 0));
        register(new Storm(null, 0));
        register(new StormOfSteel(null, 0));
        register(new Streamline(null, 0));
        register(new Strike(null, 0));
        register(new Study(null, 0));
        register(new SuckerPunch(null, 0));
        register(new Sunder(null, 0));
        register(new Survivor(null, 0));
        register(new SweepingBeam(null, 0));
        register(new SwiftStrike(null, 0));
        register(new Swivel(null, 0));
        register(new SwordBoomerang(null, 0));
        register(new Tactician(null, 0));
        register(new TalkToTheHand(null, 0));
        register(new Tantrum(null, 0));
        register(new Tempest(null, 0));
        register(new Terror(null, 0));
        register(new TheBomb(null, 0));
        register(new ThinkingAhead(null, 0));
        register(new ThirdEye(null, 0));
        register(new ThroughViolence(null, 0));
        register(new Thunderclap(null, 0));
        register(new ThunderStrike(null, 0));
        register(new ToolsOfTheTrade(null, 0));
        register(new Tranquility(null, 0));
        register(new Transmutation(null, 0));
        register(new Trip(null, 0));
        register(new TrueGrit(null, 0));
        register(new Turbo(null, 0));
        register(new TwinStrike(null, 0));
        register(new Undo(null, 0));
        register(new Unload(null, 0));
        register(new Uppercut(null, 0));
        register(new Vault(null, 0));
        register(new Venomology(null, 0));
        register(new Vigilance(null, 0));
        register(new Violence(null, 0));
        register(new VoidStatus(null, 0));
        register(new Wallop(null, 0));
        register(new Warcry(null, 0));
        register(new WaveOfTheHand(null, 0));
        register(new Weave(null, 0));
        register(new WellLaidPlans(null, 0));
        register(new WheelKick(null, 0));
        register(new Whirlwind(null, 0));
        register(new WhiteNoise(null, 0));
        register(new WildStrike(null, 0));
        register(new WindmillStrike(null, 0));
        register(new Wish(null, 0));
        register(new Worship(null, 0));
        register(new Wound(null, 0));
        register(new WraithForm(null, 0));
        register(new WreathOfFlame(null, 0));
        register(new Writhe(null));
        register(new Zap(null, 0));
    }

    private void register(Card card) {
        this.cardList.add(card);
    }
}
