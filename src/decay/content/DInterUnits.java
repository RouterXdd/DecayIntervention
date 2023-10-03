package decay.content;

import arc.graphics.*;
import arc.struct.*;
import decay.classes.meta.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import decay.graphics.*;
import decay.classes.abilities.*;

public class DInterUnits {
 public static UnitType
 //time
 hour, clock, timer, day, year, timeAssemblyDrone, pause, resume, timeEntity,
 //core
 decray, melair, powder,
 //decay
 clear, remove, destroy, obliterate, annihilate, decayAssemblyDrone, rush,
 //support
 refate,t2, recursion,
    end;
 public static void load(){
    //air time units
    hour = new UnitType("hour"){{
    health = 160;
    speed = 2.2f;
    hitSize = 8f;
    drag = 0.03f;
    flying = true;
    range = 60f;
    faceTarget = false;
    circleTarget = true;
    constructor = UnitEntity::create;
    immunities.add(DInterStatus.decaling);
    engineOffset = 5.65f;
    engineSize = 1.7f;
    outlineColor = DecayPal.decalOutline;
    weapons.add(new Weapon("main-hour-weap"){{
            reload = 28.8f;
            x = 0f;
            y = 1.8f;
            top = false;
            bullet = new ContinuousFlameBulletType(){{
                damage = 3.6f;
                length = 0f;
                speed = 0.3f;
                lifetime = 178f;
                homingPower = 0.08f;
                homingRange = 4f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};
        }});
    }};
    clock = new UnitType("clock"){{
    health = 625;
    speed = 2.3f;
    hitSize = 22f;
    drag = 0.04f;
    flying = true;
    range = 82f;
    constructor = UnitEntity::create;
    immunities.add(DInterStatus.decaling);
    engineOffset = 8.95f;
    engineSize = 2.4f;
    outlineColor = DecayPal.decalOutline;
    weapons.add(
        new Weapon("main-clock-weap"){{
            reload = 32f;
            x = 0f;
            y = -0.2f;
            top = false;
            bullet = new ContinuousFlameBulletType(){{
                damage = 23f;
                length = 96f;
                lifetime = 58f;
                pierceCap = 2;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};
        }});
    }};
    timer = new UnitType("timer"){{
    health = 1260;
    speed = 1.86f;
    hitSize = 28.4f;
    drag = 0.06f;
    flying = true;
    range = 260f;
    constructor = UnitEntity::create;
    engineOffset = 12.4f;
    engineSize = 4.8f;
    outlineColor = DecayPal.decalOutline;
    immunities.add(DInterStatus.decaling);
    weapons.add(
        new Weapon("main-timer-weap"){{
            reload = 158.8f;
            x = 0f;
            y = 4f;
            top = false;
            inaccuracy = 26f;
            shoot.shots = 10;
            shoot.shotDelay = 4;
            bullet = new BasicBulletType(){{
                    height = 9f;
                    width = 7f;
                    speed = 5f;
                    lifetime = 54f;
                    damage = 18f;
                    homingPower = 0.08f;
                    homingRange = 9f;
                    status = DInterStatus.timeswap1;
                    statusDuration = 40f;
            fragBullet = new ContinuousFlameBulletType(){{
                damage = 2f;
                length = 0f;
                speed = 0f;
                lifetime = 128f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};
            fragBullets = 1;
            }};
        }});
    }};
    day = new UnitType("day"){{
    health = 8900;
    speed = 1.26f;
    hitSize = 36.5f;
    drag = 0.082f;
    flying = true;
    range = 320f;
    constructor = UnitEntity::create;
    immunities.add(DInterStatus.decaling);
    engineOffset = 12.4f;
    engineSize = 4.8f;
    outlineColor = DecayPal.decalOutline;
    weapons.add(new Weapon("main-day-weap"){{
            reload = 98.8f;
            x = 0f;
            y = 9f;
            top = false;
            shoot = new ShootSpread(9, 8f);
            shoot.shotDelay = 3;
            bullet = new BasicBulletType(){{
                    height = 15f;
                    width = 12f;
                    speed = 5f;
                    lifetime = 68f;
                    damage = 30f;
                    status = DInterStatus.timeswap2;
                    statusDuration = 65f;
            }};
        }});
        weapons.add(new Weapon("decay-inter-sub-day-weap"){{
            reload = 189.8f;
            x = 18f;
            y = 0f;
            top = true;
            rotate = true;
            continuous = true;
            shootY = 2f;
            bullet = new ContinuousLaserBulletType(){{
                    length = 136;
                    lifetime = 98f;
                    width = 5;
                    damage = 25f;
                    drawSize = 80f;
                    colors = new Color[]{DecayPal.darkTime.cpy().a(.2f), DecayPal.darkTime.cpy().a(.5f), DecayPal.darkTime.cpy().mul(1.2f), Color.white};
            }};
            shootStatus = DInterStatus.rush;
            shootStatusDuration = 120f;
        }});
    }};
    year = new UnitType("year"){{
    health = 18600;
    armor = 6;
    speed = 0.78f;
    drag = 0.11f;
    hitSize = 53f;
    flying = true;
    range = 355f;
    constructor = UnitEntity::create;
    immunities.add(DInterStatus.decaling);
    engineOffset = 19.4f;
    engineSize = 6.8f;
    outlineColor = DecayPal.decalOutline;
        weapons.add(new Weapon("main-year-weap"){{
            shootSound = Sounds.laserblast;
            chargeSound = Sounds.lasercharge;
            reload = 350f;
            x = 7f;
            y = -2f;
            top = true;
            mirror = true;
            alternate = false;
            shootY = 1.3f;
            shoot.firstShotDelay = DInterFx.timeLaserCharge.lifetime;
            shootStatus = StatusEffects.unmoving;
            shootStatusDuration = 120f;
            cooldownTime = 350f;
            bullet = new LaserBulletType(){{
                    length = 380f;
                    damage = 300f;
                    width = 30f;

                    lifetime = 65f;

                    lightningSpacing = 50f;
                    lightningLength = 3;
                    lightningDelay = 0.8f;
                    lightningLengthRand = 15;
                    lightningDamage = 680;
                    lightningAngleRand = 40f;
                    largeHit = true;
                    lightColor = lightningColor = DecayPal.darkTime;

                    status = DInterStatus.timeswap3;
                    statusDuration = 65f;
                    parentizeEffects = true;
                    chargeEffect = DInterFx.timeLaserCharge;
                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{DecayPal.darkTime.cpy().a(0.4f), DecayPal.darkTime, Color.white};
                }};
        }});
        weapons.add(new Weapon("decal-sub-year-weap"){{
            reload = 74.7f;
            x = 13f;
            y = -11.7f;
            top = true;
            shoot.shots = 4;
            shoot.shotDelay = 3;
            bullet = new ContinuousFlameBulletType(){{
                damage = 13.65f;
                length = -47f;
                speed = 5f;
                lifetime = 71f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};
        }});
    }};
    timeAssemblyDrone = new UnitType("time-assembly-drone"){{
            controller = u -> new AssemblerAI();

            flying = true;
            drag = 0.06f;
            accel = 0.11f;
            speed = 1.3f;
            health = 120;
            engineSize = 2.3f;
            engineOffset = 6.5f;
            payloadCapacity = 0f;
            targetable = false;
            bounded = false;
            constructor = BuildingTetherPayloadUnit::create;
            immunities.add(DInterStatus.decaling);
            outlineColor = DecayPal.decalOutline;
            isEnemy = false;
            hidden = true;
            useUnitCap = false;
            logicControllable = false;
            playerControllable = false;
            allowedInPayloads = false;
            createWreck = false;
            envEnabled = Env.any;
            envDisabled = Env.none;
            abilities.add(new ForceFieldAbility(50f, 4f, 800f, 60f * 3));
        }};
     decayAssemblyDrone = new UnitType("decay-assembly-drone"){{
         controller = u -> new AssemblerAI();

         flying = true;
         drag = 0.06f;
         accel = 0.11f;
         speed = 1.3f;
         health = 120;
         engineSize = 2.3f;
         engineOffset = 6.5f;
         payloadCapacity = 0f;
         targetable = false;
         bounded = false;
         constructor = BuildingTetherPayloadUnit::create;
         immunities.add(DInterStatus.decaling);
         outlineColor = DecayPal.decalOutline;
         isEnemy = false;
         hidden = true;
         useUnitCap = false;
         logicControllable = false;
         playerControllable = false;
         allowedInPayloads = false;
         createWreck = false;
         envEnabled = Env.any;
         envDisabled = Env.none;
         abilities.add(new DecayField(26f, 0.5f, 26f));
     }};
     pause = new UnitType("pause"){{
         hovering = true;
         shadowElevation = 0.1f;
         constructor = ElevationMoveUnit::create;

         drag = 0.07f;
         speed = 1.8f;
         rotateSpeed = 5f;
         outlineColor = DecayPal.decalOutline;
         accel = 0.09f;
         health = 760f;
         armor = 1f;
         hitSize = 11f;
         engineOffset = 6f;
         engineSize = 2f;
         itemCapacity = 0;
         useEngineElevation = false;
         researchCostMultiplier = 0f;

         abilities.add(new MoveEffectAbility(0f, -6f, DecayPal.darkTime, Fx.missileTrailShort, 4f){{
             teamColor = true;
         }});

         for(float f : new float[]{-3f, 3f}){
             parts.add(new HoverPart(){{
                 x = 4f;
                 y = f;
                 mirror = true;
                 radius = 6f;
                 phase = 90f;
                 stroke = 2f;
                 layerOffset = -0.001f;
                 color = DecayPal.darkTime;
             }});
         }

         weapons.add(new Weapon("decay-inter-pause-weapon"){{
             shootSound = Sounds.blaster;
             y = -2f;
             x = 4f;
             top = true;
             mirror = true;
             reload = 40f;
             baseRotation = -35f;
             shootCone = 360f;

             shoot = new ShootSpread(3, 14f);

             bullet = new BasicBulletType(5f, 10){{
                 homingPower = 0.2f;
                 homingDelay = 4f;
                 width = 8f;
                 height = 12f;
                 lifetime = 30f;
                 shootEffect = Fx.sparkShoot;
                 smokeEffect = Fx.shootBigSmoke;
                 hitColor = backColor = trailColor = DecayPal.darkTime;
                 frontColor = Color.white;
                 trailWidth = 1.5f;
                 trailLength = 5;
                 hitEffect = despawnEffect = Fx.hitBulletColor;
                 status = DInterStatus.timeCrack;
                 statusDuration = 40;
             }};
         }});
     }};
     resume = new UnitType("resume"){{
         health = 1340;
         speed = 2f;
         hitSize = 14f;
         drag = 0.08f;
         accel = 0.1f;
         flying = true;
         range = 220f;
         deathExplosionEffect = DInterFx.resumeDespawn;
         constructor = UnitEntity::create;
         engineOffset = 12.4f;
         engineSize = 0f;
         outlineColor = DecayPal.decalOutline;
         immunities.add(DInterStatus.decaling);
         immunities.add(DInterStatus.timeCrack);
         parts.add(new HaloPart(){{
                       progress = PartProgress.life;
                       color = DecayPal.darkTime;
                       layer = Layer.effect + 6;
                       y = 2;

                       haloRotation = 0f;
                       shapes = 2;
                       hollow = false;
                       triLength = 18f;
                       haloRadius = 1.5f;
                       tri = true;
                       radius = 2.5f;
                       haloRotateSpeed = 8;

                   }},
                 new HaloPart(){{
                     progress = PartProgress.life;
                     color = DecayPal.darkTime;
                     layer = Layer.effect + 6;
                     y = 2;

                     haloRotation = 0f;
                     shapes = 2;
                     hollow = false;
                     triLength = 2f;
                     shapeRotation = 180f;
                     haloRadius = 1.5f;
                     tri = true;
                     radius = 2.5f;
                     haloRotateSpeed = 8;

                 }});
         weapons.add(
                 new Weapon("decay-inter-resume-weapon"){{
                     shootSound = Sounds.blaster;
                     reload = 4f;
                     x = 4f;
                     y = 2f;
                     top = false;
                     layerOffset = -1;
                     rotate = true;
                     rotationLimit = 40;
                     bullet = new BasicBulletType(5, 3){{
                         homingPower = 0.3f;
                         homingDelay = 5f;
                         width = 6f;
                         height = 10f;
                         lifetime = 30f;
                         shootEffect = Fx.sparkShoot;
                         smokeEffect = Fx.shootBigSmoke;
                         hitColor = backColor = trailColor = DecayPal.darkTime;
                         frontColor = Color.white;
                         trailWidth = 1.2f;
                         trailLength = 4;
                         hitEffect = despawnEffect = Fx.hitBulletColor;
                         status = DInterStatus.timeCrack;
                         statusDuration = 30;
                     }};
                 }});
     }};
     //the boss
     timeEntity = new UnitType("time-entity"){{
         hovering = true;
         constructor = UnitEntity::create;

         drag = 0.1f;
         speed = 8f;
         rotateSpeed = 8f;
         outlineColor = DecayPal.decalOutline;
         accel = 0.06f;
         health = 24000f;
         armor = 10f;
         hitSize = 26f;
         engineOffset = 6f;
         engineSize = 0f;
         itemCapacity = 0;
         useEngineElevation = false;
         researchCostMultiplier = 0f;

         abilities.add(new MoveEffectAbility(0f, 0f, DecayPal.darkTime, Fx.missileTrail, 4f)
                 , new MoveEffectAbility(3f, -2f, DecayPal.darkTime, Fx.missileTrailShort, 4f)
                 , new MoveEffectAbility(-3f, -2f, DecayPal.darkTime, Fx.missileTrailShort, 4f));
             parts.add(new HaloPart(){{
                 progress = PartProgress.life;
                 color = DecayPal.darkTime;
                 layer = Layer.effect;
                 y = 0;

                 haloRotation = 0f;
                 shapes = 5;
                 triLength = 14f;
                 haloRadius = 17f;
                 tri = false;
                 radius = 8f;
             }},
                     new HaloPart(){{
                         progress = PartProgress.life;
                         color = DecayPal.darkTime;
                         layer = Layer.effect;
                         y = 0;
                         haloRotateSpeed = -4;

                         shapes = 4;
                         triLengthTo = 8f;
                         haloRotation = 45f;
                         haloRadius = 8f;
                         tri = true;
                         radius = 6f;
                     }},
         new HaloPart(){{
             progress = PartProgress.life;
             color = DecayPal.darkTime;
             layer = Layer.effect;
             y = 0;
             haloRotateSpeed = 4;

             shapes = 4;
             triLengthTo = 8f;
             haloRotation = 45f;
             haloRadius = 8f;
             tri = true;
             radius = 6f;
         }},
                     new ShapePart(){{
                         progress = PartProgress.life;
                         color = Color.black.a(1);
                         circle = true;
                         hollow = false;
                         stroke = 1.6f;
                         radius = 4f;
                         layer = Layer.effect;
                         y = 0;
                         rotateSpeed = 0;
                     }}
                     );
             parts.add(new ShapePart(){{
                 progress = PartProgress.life;
                 color = DecayPal.darkTime;
                 circle = true;
                 hollow = true;
                 stroke = 1.5f;
                 radius = 6f;
                 layer = Layer.effect;
                 y = 0;
                 rotateSpeed = 0;
             }});

         weapons.add(new Weapon("time-weapon"){{
             shootSound = Sounds.blaster;
             y = 0f;
             x = 0f;
             top = true;
             mirror = false;
             reload = 20f;
             inaccuracy = 360f;
             shootCone = 360f;

             shoot.shots = 4;
             bullet = new BasicBulletType(6f, 40){{
                 homingPower = 0.3f;
                 homingDelay = 4f;
                 width = 10f;
                 height = 16f;
                 lifetime = 50f;
                 shootEffect = Fx.sparkShoot;
                 smokeEffect = Fx.shootBigSmoke;
                 hitColor = backColor = trailColor = DecayPal.darkTime;
                 frontColor = Color.white;
                 trailWidth = 1.8f;
                 trailLength = 7;
                 hitEffect = despawnEffect = Fx.hitBulletColor;
                 status = DInterStatus.timeCrack;
                 statusDuration = 50;
             }};
             parts.add(new ShapePart(){{
                 progress = PartProgress.life;
                 color = DecayPal.darkTime;
                 circle = true;
                 hollow = false;
                 radius = 1f;
                 layer = Layer.effect;
                 y = 1.8f;
                 rotateSpeed = 0;
             }});
         }},
                 new Weapon("LASOR"){{
                     shootSound = Sounds.laserblast;
                     chargeSound = Sounds.lasercharge;
                     reload = 500f;
                     x = 0f;
                     y = 2f;
                     top = true;
                     mirror = false;
                     shootY = 1.3f;
                     shoot.firstShotDelay = DInterFx.smallTimeLaserCharge.lifetime;
                     shootStatus = StatusEffects.unmoving;
                     shootStatusDuration = DInterFx.smallTimeLaserCharge.lifetime;
                     cooldownTime = 500f;
                     bullet = new LaserBulletType(){{
                         length = 240f;
                         damage = 200f;
                         width = 20f;

                         lifetime = 65f;

                         lightningSpacing = 20f;
                         lightningLength = 3;
                         lightningDelay = 1f;
                         lightningLengthRand = 15;
                         lightningDamage = 100;
                         lightningAngleRand = 40f;
                         largeHit = true;
                         lightColor = lightningColor = DecayPal.darkTime;
                         parentizeEffects = true;
                         chargeEffect = DInterFx.smallTimeLaserCharge;
                         sideAngle = 15f;
                         sideWidth = 0f;
                         sideLength = 0f;
                         colors = new Color[]{DecayPal.darkTime.cpy().a(0.4f), DecayPal.darkTime, Color.white};
                     }};
                 }});
     }};
    decray = new UnitType("decray"){{
        controller = u -> new BuilderAI();
        flying = true;
        drag = 0.05f;
        accel = 0.13f;
        range = 115f;
        speed = 2.3f;
        health = 200;
        mineSpeed = 5f;
        mineTier = 2;
        buildSpeed = 0.85f;
        engineSize = 2.1f;
        engineOffset = 5.3f;
        constructor = UnitEntity::create;
        immunities.add(DInterStatus.decaling);
        outlineColor = DecayPal.decalOutline;
        weapons.add(new Weapon("main-decray-weap"){{
                reload = 12f;
                x = 0f;
                y = 0f;
                top = false;
                bullet = new BasicBulletType(){{
                height = 12f;
                width = 6f;
                speed = 4f;
                lifetime = 34f;
                damage = 15f;
                homingPower = 0.08f;
                homingRange = 12f;
                status = DInterStatus.decaling;
                statusDuration = 34f * 2f;
                buildingDamageMultiplier = 0.01f;
            }};
        }});
    }};
     melair = new UnitType("melair"){{
         controller = u -> new BuilderAI();
         flying = true;
         drag = 0.05f;
         accel = 0.16f;
         range = 160f;
         hitSize = 15f;
         speed = 2.55f;
         health = 500;
         mineSpeed = 7f;
         mineTier = 2;
         buildSpeed = 1f;
         engineSize = 2.4f;
         engineOffset = 6.8f;
         constructor = UnitEntity::create;
         immunities.add(DInterStatus.decaling);
         outlineColor = DecayPal.decalOutline;
         abilities.add(new StealDecayField(50f, 0.4f, 0.2f));
         weapons.add(new Weapon("main-melair-weap"){{
             reload = 8f;
             x = 0f;
             y = 0f;
             top = false;
             shoot = new ShootHelix();
             bullet = new MissileBulletType(){{
                 height = 14f;
                 width = 8f;
                 speed = 4f;
                 lifetime = 34f;
                 damage = 10f;
                 status = DInterStatus.decaling;
                 statusDuration = 10f * 2f;
                 buildingDamageMultiplier = 0.01f;
             }};
         }});
     }};
     powder = new UnitType("powder"){{
         controller = u -> new BuilderAI();
         flying = true;
         drag = 0.05f;
         accel = 0.2f;
         range = 140f;
         hitSize = 16f;
         speed = 2.85f;
         health = 670;
         armor = 3;
         mineSpeed = 9f;
         mineTier = 3;
         buildSpeed = 1.5f;
         engineSize = 2.7f;
         engineOffset = 7.2f;
         engineColor = DecayPal.lightInfect;
         constructor = UnitEntity::create;
         immunities.add(DInterStatus.decaling);
         outlineColor = DecayPal.decalOutline;
         weapons.add(new Weapon("main-powder-weap"){{
             reload = 80f;
             x = 0f;
             y = -2f;
             top = false;
             recoil = 4;
             bullet = new LaserBoltBulletType(){{
                 recoil = 4;
                 height = 20f;
                 width = 5f;
                 speed = 7f;
                 lifetime = 34f;
                 damage = 60f;
                 pierce = true;
                 pierceBuilding = true;
                 frontColor = backColor = DecayPal.lightInfect;
                 buildingDamageMultiplier = 0.01f;
             }};
         }},
                 new Weapon("engine-powder"){{
                     reload = 20f;
                     x = 0f;
                     y = -6.6f;
                     top = false;
                     continuous = alwaysContinuous = true;
                     alwaysShootWhenMoving = true;
                     alwaysShooting = true;
                     controllable = false;
                     aiControllable = true;
                     bullet = new ContinuousFlameBulletType(){{
                         width = 4f;
                         lifetime = 20f;
                         length = -20;
                         damage = 10f;
                         pierce = false;
                         buildingDamageMultiplier = 0.05f;
                         colors = new Color[]{DecayPal.darkInfect.a(0.35f), DecayPal.infect.a(0.5f), DecayPal.lightInfect.a(0.6f), Color.valueOf("ffffff"), Color.white};
                         flareColor = DecayPal.infect;

                         lightColor = hitColor = flareColor;
                         flareInnerLenScl = 0.7f;
                     }};
                 }}
                 );
     }};
    clear = new UnitType("clear"){{
        speed = 0.6f;
        hitSize = 9f;
        health = 320;
        armor = 1;
        outlineColor = DecayPal.decalOutline;
        constructor = MechUnit::create;
        immunities.add(DInterStatus.decaling);
        abilities.add(new DecayField(36f, 0.8f,36f));
        weapons.add(new Weapon("decay-inter-decay-weapon"){{
            top = false;
            reload = 22f;
            x = 5.75f;
            y = 0f;
            ejectEffect = Fx.casing1;
            bullet = new BasicBulletType(2.5f, 9){{
                width = 7f;
                height = 9f;
                lifetime = 60f;
                status = DInterStatus.decaling;
                statusDuration = 16f;
            }};
        }});
    }};
     remove = new UnitType("remove"){{
         speed = 0.48f;
         hitSize = 16f;
         health = 740;
         armor = 3;
         outlineColor = DecayPal.decalOutline;
         constructor = MechUnit::create;
         immunities.add(DInterStatus.decaling);
         abilities.add(new DecayField(58f, 1.2f, 58f));
         weapons.add(new Weapon("decay-inter-decay-weapon"){{
             top = false;
             reload = 30f;
             x = 7f;
             y = 0f;
             ejectEffect = Fx.casing1;
             bullet = new BasicBulletType(3f, 12){{
                 width = 7f;
                 height = 10f;
                 lifetime = 60f;
                 status = DInterStatus.decaling;
                 statusDuration = 16f;
             }};
         }});
         weapons.add(new Weapon("decay-inter-decay-weapon"){{
             reload = 42f;
             x = 3f;
             y = 1.75f;
             top = true;
             ejectEffect = Fx.casing1;
             bullet = new BasicBulletType(3.5f, 20){{
                 width = 8f;
                 height = 10f;
                 lifetime = 68f;
                 status = DInterStatus.decaling;
                 statusDuration = 20f;
             }};
         }});
     }};
     destroy = new UnitType("destroy"){{
         speed = 0.34f;
         hitSize = 31f;
         health = 1470;
         range = 150f;
         outlineColor = DecayPal.decalOutline;
         constructor = MechUnit::create;
         immunities.add(DInterStatus.decaling);
         abilities.add(new DecayField(94f, 1.7f, 94f));
         weapons.add(new Weapon("decay-inter-artillery-decay-weapon"){{
             reload = 174f;
             x = 0f;
             y = 0f;
             top = true;
             mirror = false;
             ejectEffect = Fx.casing1;
             bullet = new ArtilleryBulletType(2.6f, 30){{
                 width = 18f;
                 height = 18f;
                 lifetime = 60f;
                 splashDamage = 176;
                 splashDamageRadius = 56;
                 status = DInterStatus.decaling;
                 statusDuration = 30f;
             }};
         }});
     }};
     obliterate = new UnitType("obliterate"){{
         speed = 0.26f;
         hitSize = 56f;
         health = 5120;
         range = 200f;
         outlineColor = DecayPal.decalOutline;
         constructor = MechUnit::create;
         immunities.add(DInterStatus.decaling);
         abilities.add(new DecayField(130f, 2f, 130f));
         weapons.add(new Weapon("decay-inter-artillery-decay-weapon"){{
             reload = 60f;
             x = 10f;
             y = -2f;
             top = false;
             mirror = true;
             ejectEffect = Fx.casing1;
             bullet = new ShrapnelBulletType(){{
                 width = 7f;
                 length = 26;
                 lifetime = 30f;
                 damage = 60;
                 pierce = true;
                 pierceCap = 3;
                 pierceBuilding = true;
                 status = DInterStatus.decaling;
                 statusDuration = 30f;
             }};
         }});
     }};
     annihilate = new UnitType("annihilate"){{
         controller = u -> new DefenderAI();
         speed = 0.18f;
         hitSize = 73f;
         health = 21000;
         armor = 10f;
         outlineColor = DecayPal.decalOutline;
         constructor = MechUnit::create;
         immunities.add(DInterStatus.decaling);
         abilities.add(new DecayField(160f, 2.8f, 160f));
         weapons.add(new RepairBeamWeapon("decay-inter-artillery-decay-weapon"){{
             x = 0f;
             y = -7f;
             beamWidth = 1f;
             top = true;
             mirror = false;
             ejectEffect = Fx.casing1;
             repairSpeed = 1.5f;
             laserColor = DecayPal.decalOutline;
             healColor = DecayPal.decalOutline;
             bullet = new BulletType(){{
                 maxRange = 160f;
             }};
         }});
     }};
     refate = new UnitType("refate"){{
         health = 325;
         speed = 2.8f;
         controller = u -> new DefenderAI();
         hitSize = 8f;
         drag = 0.032f;
         flying = true;
         range = 78f;
         faceTarget = true;
         circleTarget = false;
         constructor = UnitEntity::create;
         engineOffset = 5.2f;
         engineSize = 1.5f;
         outlineColor = DecayPal.decalOutline;
         immunities.add(DInterStatus.decaling);
         abilities.add(new RegenField(0.2f, 32f));
         weapons.add(new Weapon("main-weapon"){{
             reload = 30f;
             x = 0f;
             y = 1f;
             top = false;
             ejectEffect = Fx.casing1;
             mirror = false;
             bullet = new BasicBulletType(3.5f, 12){{
                 width = 7f;
                 height = 9f;
                 lifetime = 22.3f;
                 status = DInterStatus.decaling;
                 statusDuration = 20f;
             }};
         }});
     }};
     recursion = new UnitType("recursion"){{
         health = 2780;
         speed = 3.2f;
         controller = u -> new BuilderAI();
         hitSize = 27f;
         drag = 0.02f;
         flying = true;
         range = 106f;
         faceTarget = true;
         circleTarget = false;
         constructor = UnitEntity::create;
         engineOffset = 2.2f;
         engineSize = 2.3f;
         outlineColor = DecayPal.decalOutline;
         immunities.add(DInterStatus.decaling);
         buildSpeed = 1f;
         drawBuildBeam = false;
         weapons.add(new BuildWeapon("decay-inter-recursion-weapon"){{
             rotate = true;
             rotateSpeed = 7f;
             mirror = true;
             top = true;
             x = -8f;
             y = -2f;
             shootY = 1f;
         }});
     }};
     rush = new UnitType("rush"){{
         hitSize = 8f * 3.6f;
         flying = true;
         drag = 0.06f;
         accel = 0.1f;
         range = 200f;
         speed = 4f;
         health = 50000;
         engineSize = 0f;
         engineOffset = 7.4f;
         constructor = UnitEntity::create;
         immunities.add(DInterStatus.decaling);
         outlineColor = DecayPal.decalOutline;
         abilities.add(new DecayField(20f, 200f, 20f));
         abilities.add(new MoveEffectAbility(){{
             effect = DInterFx.rushMove;
             y = -3f;
             interval = 7f;
         }});
     }};
 }
}