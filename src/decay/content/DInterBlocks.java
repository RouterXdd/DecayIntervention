package decay.content;

import arc.Core;
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import decay.classes.blocks.distribution.*;
import decay.classes.blocks.environment.*;
import decay.classes.blocks.power.*;
import decay.classes.blocks.production.*;
import decay.classes.blocks.storage.*;
import decay.classes.blocks.defence.*;
import decay.classes.bullets.*;
import decay.classes.meta.*;
import decay.graphics.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.defense.turrets.*;
import multicraft.*;


import static mindustry.type.ItemStack.*;

public class DInterBlocks {
    public static Block

    //environment
    decayfloor, decaywall, oreFragment, decaystone, oreMateria, decaystoneWall, purIce, purIceWall, crystalBoulder,

    //defence
    decalwall, decalwalllarge, timewall, timewallLarge, decayBarrier, automaticDoor, viliniteWall, viliniteWallLarge, mirrorWall, mirrorWallLarge,

    //crafting
    repairer, recreator, recycler, changer, vilineForge, decayIncinerator, pressureClet, timeElectric,

    //production
    test, oreCrusher, tectonicBomber,

    //power
    decayconsider, wire, timeDriver, armoredWire,

    //storage
    coreDry, coreDecay, werehouse,

    //distribution
    lightLink, mediumLink, heavyLink ,mover, decaySorter, test2,

    //turrets
    cluster, starflood, interleet, confronter, missileter, decaynir, crystalFer, metalBlast, metalBlastV2, preletT1, preletT2, rollIn, paradox, wormhole, airStrike, orbitalCannon, prototypeRift,

    //units
    timeFactory, decayFactory, timeRefabricator, decayRefabricator,timeAssembler,decayAssembler, decayModule, decayModuleT2, wallConstructor,

    //special
    creeperCell;

    public void load() {
        Blocks.incinerator.requirements(Category.crafting, with(Items.copper, 10, Items.lead, 40, Items.graphite, 30));
        //environment
        decayfloor = new Floor("decay-floor"){{
            attributes.set(DInterAttributes.decay, 1f);
            itemDrop = DInterItems.oldmateria;
            playerUnmineable = true;
            status = DInterStatus.decaling;
            statusDuration = 180f;
            variants = 3;
        }};
        decaywall = new StaticWall("decay-floor-wall"){{
        variants = 3;
        }};
        decaystoneWall = new StaticWall("decay-stone-wall"){{
            variants = 3;
        }};
        decaystone = new Floor("decay-stone"){{
        attributes.set(DInterAttributes.decay, 0.4f);
        variants = 3;
        }};
         oreFragment = new OreBlock(DInterItems.timefragment);
         oreMateria = new OreBlock(DInterItems.oldmateria);
        purIce = new Floor("pur-ice"){{
            dragMultiplier = 0.35f;
            speedMultiplier = 0.9f;
            attributes.set(Attribute.water, 0.4f);
            albedo = 0.65f;
        }};
        purIceWall = new StaticWall("pur-ice-wall");

        crystalBoulder = new Prop("crystal-boulder"){{
            variants = 2;
            decayfloor.asFloor().decoration = this;
        }};
        //defence
    decalwall = new Wall("decalwall"){{
            requirements(Category.defense, with(DInterItems.oldmateria, 6));
            health = 620;
        }};
    decalwalllarge = new Wall("decalwall-large"){{
            requirements(Category.defense, with(DInterItems.oldmateria, 24));
            size = 2;
            health = 620 * 4;
        }};
        timewall = new Wall("timewall"){{
            requirements(Category.defense, with(
                DInterItems.oldmateria, 12,
                DInterItems.timefragment, 6
                ));
            health = 960;
        }};
    timewallLarge = new Wall("timewall-large"){{
            requirements(Category.defense, with(
                DInterItems.oldmateria, 48,
                DInterItems.timefragment, 24
                ));
            size = 2;
            health = 960 * 4;
        }};
             decayBarrier= new DirectionalForceProjector("decay-barrier"){{
                requirements(Category.effect, with(DInterItems.oldmateria, 180,
                        Items.graphite, 85,
                        Items.silicon, 110,
                        DInterItems.decaygraphite, 60,
                        DInterItems.viliniteAlloy, 50
                ));
                size = 3;
                width = 70f;
                length = 40;
                shieldHealth = 2800f;
                cooldownNormal = 2f;
                cooldownBrokenBase = 0.5f;

                consumePower(5.5f);
            }};
        automaticDoor = new AutoDoor("automatic-door"){{
            requirements(Category.defense, with(DInterItems.oldmateria, 12, DInterItems.decaygraphite, 8, Items.silicon, 6));
            health = 3240;
            size = 2;
        }};
        viliniteWall = new DecalingWall("vilinite-wall"){{
            requirements(Category.defense, with(DInterItems.viliniteAlloy, 6));
            health = 1280;
            repairChance = 0.05f;
            healAmount = 60f;
            repairHit = true;
        }};
        viliniteWallLarge = new DecalingWall("vilinite-wall-large"){{
            requirements(Category.defense, with(DInterItems.viliniteAlloy, 24));
            health = 1280 * 4;
            repairChance = 0.05f;
            healAmount = 240f;
            repairHit = true;
            size = 2;
        }};
        mirrorWall = new DecalingWall("mirror-wall"){{
            requirements(Category.defense, with(DInterItems.viliniteAlloy, 8, DInterItems.reliteplate, 4));
            health = 2000;
            mirrorChance = 0.1f;
            absorbLasers = true;
        }};
        mirrorWallLarge = new DecalingWall("mirror-wall-large"){{
            requirements(Category.defense, with(DInterItems.viliniteAlloy, 32, DInterItems.reliteplate, 16));
            health = 2000 * 4;
            size = 2;
            mirrorChance = 0.1f;
            absorbLasers = true;
        }};
        //crafting
        repairer = new MultiCrafter("repairer"){{
            requirements(Category.crafting, with(DInterItems.oldmateria, 80));
            resolvedRecipes = Seq.with(
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 3)),
                                    Seq.with(),
                                    0.7f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.lead, 1)),
                                    Seq.with()
                            ), 40f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 4)),
                                    Seq.with(),
                                    0.7f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.silicon, 1)),
                                    Seq.with()
                            ), 40f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 4)),
                                    Seq.with(),
                                    0.7f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.graphite, 1)),
                                    Seq.with()
                            ), 40f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 8)),
                                    Seq.with(),
                                    0.7f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.timefragment, 1)),
                                    Seq.with()
                            ), 120f
                    ));
            hasPower = true;
            menu = "transform";
            size = 2;
        }};
        recreator = new MultiCrafter("recreator"){{
            requirements(Category.crafting, with(DInterItems.oldmateria, 130,DInterItems.timefragment, 60, DInterItems.decaygraphite, 35));
            resolvedRecipes = Seq.with(
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 6)),
                                    Seq.with(),
                                    1.4f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.lead, 3)),
                                    Seq.with()
                            ), 30f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 6)),
                                    Seq.with(),
                                    1.4f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.silicon, 2)),
                                    Seq.with()
                            ), 30f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 6)),
                                    Seq.with(),
                                    1.4f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.graphite, 2)),
                                    Seq.with()
                            ), 30f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 10)),
                                    Seq.with(),
                                    1.4f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.timefragment, 2)),
                                    Seq.with()
                            ), 80f
                    ));
            hasPower = true;
            size = 3;
            itemCapacity = 20;

        }};
        recycler = new MultiCrafter("recycler"){{
            requirements(Category.crafting, with(DInterItems.oldmateria, 320,DInterItems.timefragment, 180, DInterItems.decaygraphite, 100, DInterItems.viliniteAlloy, 50, DInterItems.reliteplate, 20));
            resolvedRecipes = Seq.with(
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 8)),
                                    Seq.with(),
                                    3.8f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.lead, 4)),
                                    Seq.with()
                            ), 20f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 12)),
                                    Seq.with(),
                                    3.8f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.silicon, 3)),
                                    Seq.with()
                            ), 20f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 12)),
                                    Seq.with(),
                                    3.8f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.graphite, 3)),
                                    Seq.with()
                            ), 20f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 15)),
                                    Seq.with(),
                                    3.8f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.timefragment, 3)),
                                    Seq.with()
                            ), 60f
                    ),
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.oldmateria, 24)),
                                    Seq.with(),
                                    3.8f
                            ),
                            new IOEntry(
                                    Seq.with(ItemStack.with(DInterItems.viliniteAlloy, 1)),
                                    Seq.with()
                            ), 100f
                    ));
            hasPower = true;
            size = 4;
            itemCapacity = 40;
        }};
        changer = new GenericCrafter("changer") {{
            requirements(Category.crafting, with(
                    DInterItems.oldmateria, 60,
                    Items.graphite, 48,
                    Items.silicon, 34
            ));
            health = 140;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(DInterItems.decaygraphite, 1);
            craftTime = 64f;
            size = 3;
            itemCapacity = 12;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

            consumeItems(with(Items.graphite, 1, DInterItems.oldmateria, 3));
        }};
        vilineForge = new GenericCrafter("viline-forge") {{
            requirements(Category.crafting, with(
                    DInterItems.oldmateria, 100,
                    DInterItems.decaygraphite, 35,
                    Items.silicon, 60
            ));
            health = 210;
            craftEffect = DInterFx.viliniteCraft;
            outputItem = new ItemStack(DInterItems.viliniteAlloy, 1);
            craftTime = 64f;
            size = 3;
            itemCapacity = 10;
            drawer = new DrawMulti(new DrawDefault(), new DrawPistons(){{sinMag = 5f;}}, new DrawFlame());

            consumePower(2.1f);
            consumeItems(with(Items.graphite, 2, Items.silicon, 3, DInterItems.timefragment, 2));
        }};
        decayIncinerator = new Incinerator("decay-incinerator"){{
            requirements(Category.crafting, with(DInterItems.oldmateria, 370, Items.silicon, 190, DInterItems.decaygraphite, 90, DInterItems.timefragment, 240));
            health = 580;
            size = 3;
            envEnabled |= Env.space;
            consumePower(2f);
        }};
        pressureClet = new GenericCrafter("pressure-clet") {{
            requirements(Category.crafting, with(
                    DInterItems.oldmateria, 170,
                    DInterItems.decaygraphite, 80,
                    Items.silicon, 120,
                    DInterItems.timefragment, 85
            ));
            scaledHealth = 80;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(DInterItems.reliteplate, 2);
            craftTime = 80f;
            size = 3;
            itemCapacity = 20;
            drawer = new DrawMulti(
            new DrawDefault(),
            new DrawRegion(){{
                suffix = ("-spinner");
                rotateSpeed = 3;
                spinSprite = true;
            }},
            new DrawRegion(){{
                suffix = ("-spinner");
                rotateSpeed = -3;
                spinSprite = true;
            }});

            consumePower(2.8f);
            consumeItems(with(DInterItems.oldmateria, 5, Items.silicon, 4, Items.lead, 6, DInterItems.timefragment, 4));
        }};
        timeElectric = new GenericCrafter("time-electric") {{
            requirements(Category.crafting, with(
                    DInterItems.decaygraphite, 165,
                    Items.silicon, 180,
                    DInterItems.timefragment, 100,
                    DInterItems.reliteplate, 40
            ));
            scaledHealth = 96;
            craftEffect = Fx.smoke;
            outputItems = with(DInterItems.timeEssence, 1, DInterItems.oldmateria, 2);
            craftTime = 120f;
            size = 3;
            itemCapacity = 24;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFrames(){{
                        frames = 4;
                        interval = 2f;
                    }},
                    new DrawFlame(){{
                        flameColor = DecayPal.darkTime;
                        flameRadius = 4f;
                    }});

            consumePower(2.8f);
            consumeItems(with(DInterItems.timefragment, 6, DInterItems.decaygraphite, 2 , DInterItems.viliniteAlloy, 1));
        }};
        //production
        test = new RotateDrill("driller"){{
            requirements(Category.production, with(DInterItems.oldmateria, 25));
            size = 2;
            tier = 2;
            drillTime = 190;
            researchCost = with(DInterItems.oldmateria, 125);
        }};
        oreCrusher = new BurstDrill("ore-Crusher"){{
            requirements(Category.production, with(DInterItems.oldmateria, 40, Items.silicon, 15));
            size = 3;
            tier = 3;
            drillTime = 470;
        }};
        tectonicBomber = new BurstDrill("tectonic-bomber"){{
            requirements(Category.production, with(DInterItems.oldmateria, 120, Items.silicon, 75, DInterItems.timefragment, 100, DInterItems.decaygraphite, 70));
            size = 5;
            tier = 4;
            drillTime = 246;
            itemCapacity = 80;
            consumePower(0.75f);
        }};

        //power
        decayconsider = new ThermalGenerator("decay-consider"){{
            requirements(Category.power, with(DInterItems.oldmateria, 40));
            attribute = DInterAttributes.decay;
            powerProduction = 2f / 8.4f;
            displayEfficiency = false;
            generateEffect = Fx.turbinegenerate;
            effectChance = 0.04f;
            size = 1;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;

            drawer = new DrawMulti(new DrawDefault(),
            new DrawPistons(){{
                sinMag = 1f;
            }});

            fogRadius = 3;
            researchCost = with(DInterItems.oldmateria, 30);
        }};
        wire = new WireWall("wire"){{
            requirements(Category.power, with(
                    DInterItems.oldmateria, 5,
                    Items.silicon, 2
            ));
            health = 30;
            consumesPower = outputsPower = true;
            consumePowerBuffered(5f);
            researchCost = with(DInterItems.oldmateria, 20,Items.silicon, 16);
        }};
        armoredWire = new WireWall("armored-wire"){{
            requirements(Category.power, with(
                    DInterItems.reliteplate, 2,
                    Items.silicon, 4
            ));
            health = 100;
            armor = 20f;
            absorbLasers = true;
            electricity = false;
            group = BlockGroup.power;
            consumesPower = outputsPower = true;
            consumePowerBuffered(5f);
        }};
        timeDriver = new AttributeGenerator("time-driver"){{
            requirements(Category.power, with(DInterItems.oldmateria, 540, Items.graphite, 460, Items.silicon, 300, DInterItems.timefragment, 280));
            scaledHealth = 148;
            size = 3;
            powerProduction = 4.8f;
            fogRadius = 3;
        }};
        //storage
        coreDry = new DrillCore("core-dry"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(DInterItems.oldmateria, 1200, Items.graphite, 600, Items.lead, 800));
            alwaysUnlocked = true;

            tier = 2;
            isFirstTier = true;
            unitType = DInterUnits.decray;
            health = 1000;
            itemCapacity = 3500;
            drillTime = 80;
            size = 3;

            unitCapModifier = 10;
        }};
        coreDecay = new DrillCore("core-decay"){{
            requirements(Category.effect, with(DInterItems.oldmateria, 3200, Items.graphite, 2600, Items.lead, 2900, Items.silicon, 1890, DInterItems.viliniteAlloy, 1300));

            tier = 3;
            unitType = DInterUnits.melair;
            health = 4000;
            itemCapacity = 6000;
            drillTime = 60;
            size = 4;

            unitCapModifier = 16;
        }};
        werehouse = new StorageBlock("werehouse"){{
            requirements(Category.effect, with(DInterItems.oldmateria, 400, DInterItems.timefragment, 250, DInterItems.decaygraphite, 160));
            size = 2;
            itemCapacity = 400;
            scaledHealth = 55;
        }};
        //distribution
        lightLink = new TransferLink("light-link") {{
            requirements(Category.distribution, with(
                DInterItems.oldmateria, 5,
                Items.graphite, 2
                ));
        }};
        mediumLink = new TransferLink("medium-link") {{
            requirements(Category.distribution, with(
                    DInterItems.oldmateria, 10,
                    DInterItems.decaygraphite, 3
            ));
            size = 2;
            linkRange = 73;
            maxLinks = 3;
            arrowSpacing = 10f;
            arrowSpeed = 0.6f;
            transferTime = 0.6f;
        }};
        heavyLink = new TransferLink("heavy-link") {{
            requirements(Category.distribution, with(
                    DInterItems.oldmateria, 40,
                    DInterItems.timefragment, 15,
                    DInterItems.decaygraphite, 20
            ));
            size = 3;
            linkRange = 200;
            maxLinks = 1;
            arrowSpacing = 10f;
            arrowSpeed = 0.8f;
            transferTime = 0.8f;
        }};
        mover = new Duct("mover"){{
            requirements(Category.distribution, with(DInterItems.oldmateria, 1));
            health = 120;
            researchCost = with(DInterItems.oldmateria, 10);
            speed = 2.96f;
        }};
        decaySorter = new Sorter("decay-sorter"){{
            requirements(Category.distribution, with(DInterItems.oldmateria, 5));
            buildCostMultiplier = 3f;
        }};
        test2 = new LiquidDriver("test"){{
            requirements(Category.distribution, with(DInterItems.oldmateria, 1));
            range = 58;
        }};
        //turrets
        cluster = new ItemTurret("cluster"){{
            requirements(Category.turret, with(
                DInterItems.oldmateria, 78,
                Items.lead, 45,
                Items.graphite, 60
                ));
                health = 570;
                size = 2;
                reload = 50f;
                range = 146f;
                recoil = 1.2f;
                shoot = new ShootSpread(3, 26f);
                coolant = consumeCoolant(0.2f);
                outlineColor = DecayPal.decalOutline;
                ammo(
                    DInterItems.oldmateria, new BasicBulletType(){{
                    height = 9f;
                    width = 7f;
                    speed = 4f;
                    lifetime = 36.5f;
                    ammoMultiplier = 2.2f;
                    damage = 8f;
                    homingPower = 0.08f;
                    homingRange = 9f;
                    status = DInterStatus.decaling;
                    statusDuration = 60f * 2f;
                    }});
                drawer = new DrawTurret("decay-"){{
                parts.add(new RegionPart("-recoil"){{
                    progress = PartProgress.reload;
                    moveY = -2.3f;
                    mirror = false;
                    heatColor = Pal.accent;
                }});
            }};
            researchCost = with(DInterItems.oldmateria, 100, Items.lead, 100, Items.silicon, 100);
        }};
        starflood = new PowerTurret("starflood"){{
            requirements(Category.turret, with(
                DInterItems.oldmateria, 115,
                Items.silicon, 75,
                Items.graphite, 60,
                DInterItems.timefragment, 40
                ));
                health = 890;
                size = 2;
                reload = 70f;
                range = 198f;
                recoil = 1.45f;
                coolant = consumeCoolant(0.2f);
                consumePower(3.2f);
                outlineColor = DecayPal.decalOutline;
                drawer = new DrawTurret("decay-");
                    shootType = new ContinuousFlameBulletType(){{
                damage = 11.8f;
                length = -30f;
                speed = 6f;
                lifetime = 33f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;

                fragBullet = new ContinuousFlameBulletType(){{
                damage = 7.3f;
                length = 0f;
                speed = 4f;
                drag = 0.07f;
                lifetime = 71f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};

                fragBullets = 4;
                fragVelocityMin = 0.5f;
                fragVelocityMax = 1.5f;
                fragLifeMin = 0.4f;
            }};
        }};
        interleet = new PowerTurret("interleet"){{
            requirements(Category.turret, with(
                DInterItems.oldmateria, 90,
                Items.silicon, 80,
                DInterItems.decaygraphite, 55,
                DInterItems.timefragment, 70
                ));
                health = 780;
                size = 2;
                reload = 5f;
                range = 260f;
                recoil = 0f;
                rotateSpeed = 50f;
                coolant = consumeCoolant(0.2f);
                consumePower(6f);
                outlineColor = DecayPal.decalOutline;
                shootY = 0f;
                drawer = new DrawTurret("decay-"){{
                    parts.addAll(
                            new ShapePart(){{
                                progress = PartProgress.warmup.delay(0.1f);
                                color = DecayPal.darkTime;
                                hollow = true;
                                stroke = 0f;
                                strokeTo = 1.8f;
                                radius = 3.2f;
                                layer = Layer.effect;
                                y = 0;
                                rotateSpeed = 8f;
                                x = 0;
                            }});
                }};
                shoot = new ShootSummon(0f, 0f, 240f, 360f);
                    shootType = new ContinuousFlameBulletType(){{
                damage = 20f;
                length = 0f;
                drag = 0.065f;
                speed = 8f;
                lifetime = 34f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), DecayPal.darkTime};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;

                status = DInterStatus.timeswap2;
                statusDuration = 80f;
            }};
        }};
        confronter = new ContinuousTurret("confronter"){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 96,
                    Items.silicon, 90,
                    DInterItems.decaygraphite, 75,
                    DInterItems.timefragment, 58,
                    DInterItems.viliniteAlloy, 12
            ));
            scaledHealth = 130;
            size = 2;
            reload = 20f;
            range = 96f;
            recoil = 0f;
            targetHealing = true;
            coolant = consumeCoolant(0.2f);
            consumePower(3.6f);
            outlineColor = DecayPal.decalOutline;
            shootY = 0f;
            drawer = new DrawTurret("decay-");
            shootType = new ContinuousFlameBulletType(){{
                damage = 4f;
                length = 98f;
                healPercent = 2f;
                collidesTeam = true;
                lifetime = 45f;
                collideTerrain = true;
                pierce = false;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;

            }};
        }};
        missileter = new ItemTurret("missileter"){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 120,
                    Items.silicon, 75,
                    Items.graphite, 60,
                    DInterItems.viliniteAlloy, 30
            ));
            targetHealing = true;
            scaledHealth = 190;
            size = 2;
            reload = 26f;
            range = 190f;
            recoil = 0f;
            shootY = 0f;
            shoot = new ShootSummon(0f, 0f, 0f, 360f);
            coolant = consumeCoolant(0.45f);
            outlineColor = DecayPal.decalOutline;
            ammo(
                    DInterItems.viliniteAlloy, new BasicBulletType(){{
                        ammoMultiplier = 1f;
                        damage = 0f;
                        collidesTeam = true;
                        spawnUnit = new MissileUnitType("heal-missile"){{
                            speed = 5.6f;
                            rotateSpeed = 4f;
                            maxRange = 6f;
                            lifetime = 60f * 1.55f;
                            outlineColor = DecayPal.decalOutline;
                            engineColor = trailColor = DecayPal.vilinite;
                            health = 60;
                            loopSoundVolume = 0.1f;
                            constructor = TimedKillUnit::create;
                            immunities.add(DInterStatus.decaling);
                            collidesTeam = true;

                            weapons.add(new Weapon() {{
                                shootCone = 360f;
                                mirror = false;
                                reload = 1f;
                                shootOnDeath = true;
                                bullet = new ExplosionBulletType(50f, 20f) {{
                                    shootEffect = Fx.massiveExplosion;
                                    healPercent = 3;
                                    collidesTeam = true;
                                }};
                            }});
                        }};
                    }});
            drawer = new DrawTurret("decay-");
            researchCost = with(DInterItems.oldmateria, 600, Items.silicon, 375, Items.graphite, 300, DInterItems.viliniteAlloy, 150);
        }};
        decaynir = new ItemTurret("decaynir"){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 144,
                    Items.lead, 175,
                    Items.graphite, 110,
                    DInterItems.decaygraphite, 86
            ));
            scaledHealth = 195;
            size = 3;
            reload = 38f;
            range = 190f;
            recoil = 1.5f;
            coolant = consumeCoolant(0.3f);
            outlineColor = DecayPal.decalOutline;
            ammo(
                    DInterItems.decaygraphite, new DecayBullet(4f, 36f){{
                        height = 12f;
                        width = 9f;
                        lifetime = 47.5f;
                        ammoMultiplier = 2.6f;
                        status = DInterStatus.decaling;
                        statusDuration = 60f * 3f;
                        decayRange = 18f;
                        decayDamage = 0.6f;
                    }},
                    Items.silicon, new DecayBullet(4f, 24f){{
                        height = 11f;
                        width = 8f;
                        lifetime = 47.5f;
                        ammoMultiplier = 1.4f;
                        homingPower = 0.08f;
                        homingRange = 9f;
                        decayRange = 11f;
                        decayDamage = 0.2f;
                    }});
            drawer = new DrawTurret("decay-"){{
                    parts.add(new RegionPart("-recoil"){{
                        progress = PartProgress.reload;
                        recoilIndex = 0;
                        moveY = -2f;
                        mirror = true;
                    }});
            }};
        }};
        crystalFer = new ItemTurret("crystal-fer"){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 210,
                    Items.silicon, 160,
                    DInterItems.decaygraphite, 65,
                    DInterItems.timefragment, 110
            ));
            scaledHealth = 142;
            size = 3;
            reload = 70f;
            range = 184f;
            recoil = 1.3f;
            shoot = new ShootSummon(0f, 7f, 7f, 0f);
            shoot.shots = 5;
            shoot.shotDelay = 6f;
            targetGround = false;
            coolant = consumeCoolant(0.6f);
            outlineColor = DecayPal.decalOutline;
            ammo(
                    DInterItems.timefragment, new BasicBulletType(){{
                        height = 12f;
                        width = 9f;
                        speed = 6f;
                        lifetime = 30.6f;
                        ammoMultiplier = 2.4f;
                        collidesGround = false;
                        damage = 26f;
                        homingPower = 0.1f;
                        homingRange = 11f;
                        status = DInterStatus.timeswap1;
                        statusDuration = 60f * 0.8f;
                    }});
            drawer = new DrawTurret("decay-"){{
                parts.addAll(
                        new ShapePart(){{
                            progress = PartProgress.warmup.delay(0.1f);
                            color = DecayPal.darkTime;
                            hollow = true;
                            stroke = 0f;
                            strokeTo = 2f;
                            radius = 5f;
                            circle = true;
                            layer = Layer.effect;
                            y = 10;
                            x = 0;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup.delay(0.1f);
                            color = DecayPal.darkTime;
                            hollow = true;
                            stroke = 0f;
                            strokeTo = 1.6f;
                            triLength = 0;
                            triLengthTo = 2.4f;
                            haloRadius = 6;

                            radius = 6f;
                            tri = true;
                            layer = Layer.effect;
                            y = 10;
                            haloRotateSpeed = 6f;
                            x = 0;
                        }}
                        );
            }};
            researchCost = with(DInterItems.oldmateria, 210,
                    Items.silicon, 160,
                    DInterItems.decaygraphite, 65,
                    DInterItems.timefragment, 110
            );
        }};
        metalBlast = new ModesPowerTurret("metal-blast", metalBlastV2){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 240,
                    Items.silicon, 180,
                    DInterItems.decaygraphite, 75,
                    DInterItems.timefragment, 145,
                    DInterItems.reliteplate, 50
            ));
            scaledHealth = 195;
            size = 3;
            reload = 11f;
            range = 180f;
            recoil = 1.2f;
            coolant = consumeCoolant(0.6f);
            consumePower(3.35f);
            outlineColor = DecayPal.decalOutline;
            drawer = new DrawTurret("decay-");
            shootType = new BasicBulletType(){{
                height = 24f;
                width = 14f;
                speed = 6f;
                lifetime = 30f;
                damage = 4f;
                sprite = "decay-inter-orbital";
                ammoMultiplier = 1;
            }};
        }};
        metalBlastV2 = new ModesPowerTurret("metal-blast-v2", metalBlast){{
            requirements(Category.turret, BuildVisibility.debugOnly,with(
                    DInterItems.oldmateria, 240,
                    Items.silicon, 180,
                    DInterItems.decaygraphite, 75,
                    DInterItems.timefragment, 145,
                    DInterItems.reliteplate, 50
            ));
            scaledHealth = 195;
            size = 3;
            reload = 60f;
            range = 180f;
            recoil = 1.2f;
            coolant = consumeCoolant(0.6f);
            consumePower(3.9f);
            outlineColor = DecayPal.decalOutline;
            drawer = new DrawTurret("decay-");
            shootType = new BasicBulletType(){{
                height = 26f;
                width = 15f;
                speed = 6f;
                lifetime = 30f;
                damage = 50f;
                sprite = "decay-inter-orbital";
                ammoMultiplier = 1;
                pierce = true;
                pierceCap = 4;
                pierceBuilding = true;
            }};
        }};
        preletT1 = new UpgradeblePowerTurret("prelet-t1"){{
            requirements(Category.turret, BuildVisibility.hidden, with(
                    DInterItems.oldmateria, 120,
                    Items.silicon, 140,
                    DInterItems.decaygraphite, 55,
                    DInterItems.timefragment, 85,
                    DInterItems.timeEssence, 10
            ));
            upgradeTurret = DInterBlocks.preletT2;
            upgradecost = new ItemStack(DInterItems.timefragment, 50);
            scaledHealth = 175;
            size = 3;
            reload = 12f;
            range = 140f;
            recoil = 1.2f;
            itemCapacity = 30;
            coolant = consumeCoolant(0.6f);
            consumePower(5.7f);
            outlineColor = DecayPal.decalOutline;
            drawer = new DrawTurret("decay-");
            shootType = new LaserBulletType(){{
                damage = 40f;
                length = 140f;
                lifetime = 26f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.white.a(0.6f), Color.white, Color.white};

                lightColor = hitColor;

                status = DInterStatus.timeswap1;
                statusDuration = 120f;
            }};
        }};
        preletT2 = new PowerTurret("prelet-t2"){{
            requirements(Category.turret, BuildVisibility.debugOnly, with(
                    DInterItems.oldmateria, 120,
                    Items.silicon, 140,
                    DInterItems.decaygraphite, 55,
                    DInterItems.timefragment, 115,
                    DInterItems.timeEssence, 10
            ));
            scaledHealth = 195;
            size = 3;
            reload = 10f;
            range = 150f;
            recoil = 1.2f;
            shoot = new ShootSpread(3, 6);
            coolant = consumeCoolant(0.6f);
            consumePower(6.3f);
            outlineColor = DecayPal.decalOutline;
            drawer = new DrawTurret("decay-");
            shootType = new LaserBulletType(){{
                damage = 40f;
                length = 140f;
                lifetime = 26f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.white.a(0.6f), Color.white, Color.white};

                lightColor = hitColor;

                status = DInterStatus.timeswap1;
                statusDuration = 140f;
            }};
        }};
        rollIn = new ContinuousTurret("roll-in"){{
            requirements(Category.turret, with(DInterItems.oldmateria, 430,
                    Items.silicon, 230,
                    DInterItems.decaygraphite, 170,
                    DInterItems.timefragment, 320,
                    DInterItems.viliniteAlloy, 210
            ));

            shootType = new PointLaserBulletType(){{
                damage = 10f;
                buildingDamageMultiplier = 0.4f;
                lightColor = color = hitColor = DecayPal.darkTime;
                status = DInterStatus.timeStop;
                statusDuration = 30;
                trailWidth = 4;
                trailLength = 40;
                trailColor = DecayPal.darkTime;
            }};

            drawer = new DrawTurret("decay-"){{
                var heatp = DrawPart.PartProgress.warmup.blend(p -> Mathf.absin(2f, 1f) * p.warmup, 0.2f);
                parts.add(new RegionPart("-mid"){{
                            heatProgress = heatp;
                            progress = PartProgress.warmup;
                            heatColor = DecayPal.darkTime;
                            moveY = -8f;
                            mirror = false;
                            under = true;
                        }});
            }};
            coolant = consumeCoolant(0.6f);
            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            loopSound = Sounds.laserbeam;

            shootWarmupSpeed = 0.1f;
            shootCone = 360f;

            aimChangeSpeed = 2f;
            rotateSpeed = 2f;

            shootY = 0.5f;
            outlineColor = DecayPal.decalOutline;
            size = 4;
            range = 250f;
            scaledHealth = 210;

            unitSort = UnitSorts.farthest;

            consumePower(8);
            consumeItem(DInterItems.timefragment, 8);
        }};
        paradox = new ItemTurret("paradox"){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 540,
                    Items.silicon, 230,
                    DInterItems.decaygraphite, 340,
                    DInterItems.timefragment, 320,
                    DInterItems.viliniteAlloy, 240
            ));
            scaledHealth = 320;
            size = 4;
            reload = 350f;
            range = 600f;
            recoil = 3f;
            shoot.firstShotDelay = 40f;
            shootY = -2;
            coolant = consumeCoolant(0.6f);
            outlineColor = DecayPal.decalOutline;
            consumePower(4.5f);
            ammo(
                    DInterItems.timefragment, new BasicBulletType(){{
                        height = 14f;
                        width = 10f;
                        speed = 10f;
                        lifetime = 60f;
                        ammoMultiplier = 2f;
                        damage = 120f;
                        pierce = true;
                        status = DInterStatus.timeCrack;
                        statusDuration = 60f * 4f;
                        buildingDamageMultiplier = 0.8f;
                        backColor = DecayPal.darkTime;
                        frontColor = DecayPal.darkTime;
                        trailLength = 5;
                        trailWidth = 2;
                        trailColor = DecayPal.darkTime;
                    }});
            drawer = new DrawTurret("decay-"){{
                parts.add(new RegionPart("-ray"){{
                    progress = PartProgress.warmup;
                    moveY = 2.4f;
                    moveX = -2.4f;
                    mirror = true;
                    heatColor = DecayPal.darkTime;
                    under = true;
                }});
            }};
            ammoPerShot = 5;
            maxAmmo = 30;
        }};
        wormhole = new PowerMultiTurret("wormhole"){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 1100,
                    Items.lead, 1200,
                    Items.silicon, 900,
                    DInterItems.decaygraphite, 540,
                    DInterItems.timefragment, 800,
                    DInterItems.viliniteAlloy, 680
            ));
            scaledHealth = 170;
            size = 4;
            range = 190;
            unitType = new UnitType("wormhole-turret"){{
                health = 1;
                speed = 0f;
                hitSize = 14f;
                range = 190f;
                hidden = true;
                internal = true;
                faceTarget = true;
                circleTarget = false;
                constructor = BlockUnitUnit::create;
                outlineColor = DecayPal.decalOutline;
                rotateSpeed = 4;
                weapons.add(new Weapon("missiles-mount"){{
                    reload = 80f;
                    x = 4f;
                    y = 0f;
                    top = false;
                    ejectEffect = Fx.casing1;
                    mirror = true;
                    alternate = false;
                    bullet = new BasicBulletType(3.8f, 40){{
                        width = 11f;
                        height = 14f;
                        lifetime = 50f;
                        pierce = true;
                        pierceCap = 3;
                    }};
                }});
                weapons.add(new Weapon("main-weapon"){{
                    reload = 30f;
                    x = 0f;
                    y = 2f;
                    top = false;
                    ejectEffect = Fx.casing1;
                    mirror = false;
                    bullet = new BasicBulletType(4f, 30){{
                        width = 7f;
                        height = 10f;
                        lifetime = 30f;
                    }};
                }});
            }};
        }};
        airStrike = new ItemTurret("air-strike"){{
            requirements(Category.turret, BuildVisibility.debugOnly, with());
            health = 780;
            size = 4;
            reload = 65f;
            range = 280f;
            recoil = 0f;
            coolant = consumeCoolant(0.4f);
            outlineColor = DecayPal.decalOutline;
            shootEffect = DInterFx.smallTimeLaserCharge;
            shootY = 0f;
            shoot = new ShootSummon(0f, 0f, 280f, 360f);
            ammo(
                    Items.blastCompound, new BasicBulletType(){{
                        height = 0f;
                        width = 0f;
                        speed = 0f;
                        lifetime = 60f;
                        damage = 0f;
                        ammoMultiplier = 1f;

                        fragBullet = new ShrapnelBulletType(){{
                            length = 70;
                            damage = 80f;
                            width = 12f;
                            toColor = Pal.redSpark;
                        }};
                        fragBullets = 8;
                        fragVelocityMin = 0.5f;
                        fragVelocityMax = 1.5f;
                        fragLifeMin = 0.4f;
                    }});
        }};
        orbitalCannon = new ItemTurret("omega-cannon"){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 900,
                    Items.lead, 1100,
                    DInterItems.decaygraphite, 460,
                    DInterItems.timefragment, 750,
                    DInterItems.reliteplate, 600
            ));
            rotateSpeed = 20f;
            scaledHealth = 230;
            size = 5;
            reload = 800f;
            range = 3000f;
            recoil = 2f;
            coolant = consumeCoolant(5f);
            outlineColor = DecayPal.decalOutline;
            ammo(
                    DInterItems.timefragment, new BasicBulletType(){{
                        height = 32f;
                        width = 18f;
                        speed = 5f;
                        lifetime = 600f;
                        damage = 800f;
                        sprite = "decay-inter-orbital";
                        trailColor = DecayPal.darkTime;
                        trailLength = 30;
                        trailWidth = 5;
                        ammoMultiplier = 1;
                        pierce = true;
                        pierceBuilding = true;
                        buildingDamageMultiplier = 0.5f;
                    }});
            drawer = new DrawTurret("decay-");
            ammoPerShot = 40;
            maxAmmo = 40;
        }};
        prototypeRift = new PayloadAmmoTurret("prototype-rift"){{
            requirements(Category.turret, with(
                    DInterItems.oldmateria, 1270,
                    Items.silicon, 780,
                    Items.graphite, 970,
                    DInterItems.timefragment, 980,
                    DInterItems.viliniteAlloy, 580,
                    DInterItems.timeEssence, 200
            ));
            scaledHealth = 890;
            size = 5;
            reload = 200f;
            range = 360f;
            recoil = 1.45f;
            coolant = consumeCoolant(0.2f);
            consumePower(3.2f);
            outlineColor = DecayPal.decalOutline;
            drawer = new DrawTurret("decay-");
            ammo(
                    DInterBlocks.timewallLarge, new BasicBulletType(){{
                        height = 20f;
                        width = 20f;
                        speed = 6f;
                        lifetime = 60f;
                        damage = 100f;
                        sprite = "large-orb";
                        frontColor = DecayPal.darkTime;
                        backColor = DecayPal.darkTime;
                        trailColor = DecayPal.darkTime;
                        trailLength = 20;
                        trailWidth = 5;
                        ammoMultiplier = 1;
                        pierce = true;
                        pierceCap = 5;
                        pierceBuilding = true;
                        reloadMultiplier = 1;
                        intervalBullet = new ContinuousFlameBulletType(){{
                            damage = 10f;
                            length = 100f;
                            lifetime = 60f;
                            pierceCap = 3;
                            colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                            flareColor = Color.valueOf("ffffff");

                            lightColor = hitColor = flareColor;
                        }};

                        bulletInterval = 4f;
                        intervalRandomSpread = 360f;
                        intervalBullets = 2;
                        intervalAngle = 360f;
                        intervalSpread = 360f;
                    }});
        }};
        //units
        timeFactory = new UnitFactory("time-factory"){{
            requirements(Category.units, with(Items.silicon, 200, Items.graphite, 300, DInterItems.timefragment, 60));
            size = 3;
            plans.add(new UnitPlan(DInterUnits.hour, 60f * 40f, with(DInterItems.timefragment, 20, Items.silicon, 40)));
            plans.add(new UnitPlan(DInterUnits.pause, 60f * 60f, with(DInterItems.timefragment, 30, Items.silicon, 30, Items.lead, 25)));
            regionSuffix = "-decay";
            fogRadius = 3;
            researchCostMultiplier = 0.65f;
            consumePower(2.6f);
        }};
        decayFactory = new UnitFactory("decay-factory"){{
            requirements(Category.units, with(Items.silicon, 220, Items.graphite, 270, DInterItems.oldmateria, 140));
            size = 3;
            plans.add(
                    new UnitPlan(DInterUnits.clear, 60f * 34f, with(DInterItems.oldmateria, 35, Items.silicon, 30)),
                    new UnitPlan(DInterUnits.refate, 60f * 45f, with(DInterItems.oldmateria, 50, Items.silicon, 30, Items.lead, 45))
            );
            regionSuffix = "-decay";
            fogRadius = 3;
            researchCostMultiplier = 0.65f;
            consumePower(2.6f);
        }};

        timeRefabricator = new Reconstructor("time-refabricator"){{
            requirements(Category.units, with(DInterItems.oldmateria, 200, DInterItems.timefragment, 80, Items.silicon, 100));
            regionSuffix = "-decay";

            size = 3;
            consumePower(4.2f);
            consumeItems(with(DInterItems.decaygraphite, 65, DInterItems.timefragment, 40));

            constructTime = 60f * 42f;
            researchCostMultiplier = 0.75f;

            upgrades.addAll(
            new UnitType[]{DInterUnits.hour, DInterUnits.clock}
            );
        }};
        decayRefabricator = new Reconstructor("decay-refabricator"){{
            requirements(Category.units, with(DInterItems.oldmateria, 220, DInterItems.decaygraphite, 90, Items.silicon, 140));
            regionSuffix = "-decay";

            size = 3;
            consumePower(4.2f);
            consumeItems(with(DInterItems.decaygraphite, 40, DInterItems.oldmateria, 50));

            constructTime = 60f * 35f;
            researchCostMultiplier = 0.75f;

            upgrades.addAll(
                    new UnitType[]{DInterUnits.clear, DInterUnits.remove}
            );
        }};
        timeAssembler = new UnitAssembler("time-assembler"){{
            requirements(Category.units, with(DInterItems.decaygraphite, 200, DInterItems.oldmateria, 600, DInterItems.timefragment, 200, Items.graphite, 500, Items.silicon, 900));
            regionSuffix = "-decay";
            droneType = DInterUnits.timeAssemblyDrone;
            size = 3;
            plans.add(
            new AssemblerUnitPlan(DInterUnits.timer, 60f * 60f, PayloadStack.list(DInterUnits.hour, 4, DInterBlocks.decalwalllarge, 10)),
            new AssemblerUnitPlan(DInterUnits.day, 60f * 60f * 3f, PayloadStack.list(DInterUnits.clock, 6, DInterBlocks.timewallLarge, 20)),
            new AssemblerUnitPlan(DInterUnits.year, 60f * 60f * 6f, PayloadStack.list(DInterUnits.hour, 8, DInterUnits.clock, 8, DInterBlocks.decalwalllarge, 20, DInterBlocks.timewallLarge, 20))
            );
            consumePower(3.7f);
            areaSize = 15;
        }};
        decayAssembler = new UnitAssembler("decay-assembler"){{
            requirements(Category.units, with(DInterItems.decaygraphite, 300, DInterItems.oldmateria, 680, Items.graphite, 650, Items.silicon,1100));
            regionSuffix = "-decay";
            droneType = DInterUnits.decayAssemblyDrone;
            size = 3;
            plans.add(
                    new AssemblerUnitPlan(DInterUnits.destroy, 60f * 60f, PayloadStack.list(DInterUnits.clear, 4, DInterBlocks.decalwalllarge, 12)),
                    new AssemblerUnitPlan(DInterUnits.obliterate, 60f * 60f * 3f, PayloadStack.list(DInterUnits.remove, 6, DInterBlocks.timewallLarge, 20)),
                    new AssemblerUnitPlan(DInterUnits.annihilate, 60f * 60f * 6f, PayloadStack.list(DInterUnits.clear, 8, DInterUnits.remove, 8, DInterBlocks.decalwalllarge, 20, DInterBlocks.viliniteWallLarge, 20))
                    );
            consumePower(3.7f);
            areaSize = 15;
        }};
        decayModule = new UnitAssemblerModule("decay-module"){{
            requirements(Category.units, with(Items.lead, 500, DInterItems.oldmateria, 300, DInterItems.decaygraphite, 200,DInterItems.viliniteAlloy, 150));
            consumePower(2f);
            regionSuffix = "-decay";

            size = 3;
        }};
        decayModuleT2 = new UnitAssemblerModule("decay-modulet2"){{
            requirements(Category.units, with(Items.lead, 800, DInterItems.oldmateria, 600, DInterItems.decaygraphite, 400, DInterItems.timefragment, 250,DInterItems.viliniteAlloy, 260,DInterItems.reliteplate, 190,DInterItems.timeEssence, 70));
            consumePower(3.7f);
            regionSuffix = "-decay";
            tier = 2;
            size = 5;
        }};
       wallConstructor = new Constructor("constructor"){{
            requirements(Category.units, with(DInterItems.oldmateria, 250, Items.silicon, 180, Items.graphite, 150, DInterItems.decaygraphite, 60));
            regionSuffix = "-decay";
            hasPower = true;
            buildSpeed = 0.42f;
            consumePower(3f);
            size = 3;
            filter = Seq.with(DInterBlocks.decalwalllarge, DInterBlocks.timewallLarge, DInterBlocks.viliniteWallLarge);
        }};
        //special
        creeperCell = new Wall("creeper-cell"){{
            requirements(Category.effect,BuildVisibility.editorOnly, with());
            health = 600;
            size = 1;
            unitCapModifier = 0;
        }};
    }
}
