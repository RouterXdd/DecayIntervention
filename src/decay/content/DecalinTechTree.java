package decay.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.game.Objectives.*;

import static mindustry.content.TechTree.*;
import static decay.content.DInterSectors.*;

public class DecalinTechTree {
    public void load(){
        DInterPlanets.decalin.techTree = nodeRoot("decalin", DInterPlanets.decalin, true, () -> {
            nodeProduce(DInterItems.oldmateria, () -> {
                nodeProduce(DInterItems.timefragment, () -> {
                    nodeProduce(DInterItems.timeEssence, () -> {
                    });
                });

                nodeProduce(Items.silicon, () -> {
                    nodeProduce(DInterItems.viliniteAlloy, () -> {
                    });
                });
                nodeProduce(Items.graphite, () -> {
                    nodeProduce(DInterItems.decaygraphite, () -> {
                        nodeProduce(DInterItems.reliteplate, () -> {
                        });
                    });
                });
                nodeProduce(Items.lead, () -> {
                });
            });
            node(DInterBlocks.repairer, Seq.with(new Produce(DInterItems.oldmateria)), () -> {
                node(DInterBlocks.changer, Seq.with(new SectorComplete(oldPlace)),() -> {
                    node(DInterBlocks.recreator, () -> {
                        node(DInterBlocks.pressureClet/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                            node(DInterBlocks.timeElectric, () -> {
                            });
                        });
                    node(DInterBlocks.vilineForge/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                    });
                        node(DInterBlocks.recycler/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                        });
                        node(DInterBlocks.decayIncinerator/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                        });
                    });
                });
            });
            node(DInterBlocks.decalwall, Seq.with(new Produce(DInterItems.oldmateria)), () -> {
                node(DInterBlocks.timewall, Seq.with(new Produce(DInterItems.timefragment)), () -> {
                    node(DInterBlocks.decayBarrier/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                    });
                    node(DInterBlocks.timewallLarge, () -> {
                    });
                    node(DInterBlocks.automaticDoor, () -> {
                    });
                    node(DInterBlocks.viliniteWall, () -> {
                        node(DInterBlocks.viliniteWallLarge, () -> {
                        });
                        node(DInterBlocks.mirrorWall, () -> {
                            node(DInterBlocks.mirrorWallLarge, () -> {
                            });
                        });
                    });
                });
                node(DInterBlocks.decalwalllarge, () -> {
                });
            });
            node(DInterBlocks.cluster, () -> {
                node(DInterBlocks.starflood, Seq.with(new Produce(DInterItems.timefragment)), () -> {
                    node(DInterBlocks.interleet, Seq.with(new SectorComplete(oldPlace)), () -> {
                        node(DInterBlocks.crystalFer, () -> {
                            node(DInterBlocks.rollIn, () -> {
                                node(DInterBlocks.paradox/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                                });
                            });
                            node(DInterBlocks.decaynir/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                            });
                        });
                        node(DInterBlocks.confronter, Seq.with(new SectorComplete(sectureBase)),() -> {
                            node(DInterBlocks.missileter, Seq.with(new Produce(DInterItems.viliniteAlloy)),() -> {
                                node(DInterBlocks.orbitalCannon/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                                    node(DInterBlocks.prototypeRift/*, Seq.with(new SectorComplete(junkyard))*/,() -> {

                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(DInterBlocks.decayconsider, () -> {
                node(DInterBlocks.timeDriver/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                });
                node(DInterBlocks.wire, () -> {
                    node(DInterBlocks.armoredWire, () -> {
                    });
                });
            });
            node(DInterBlocks.mover, () -> {
                node(DInterBlocks.decaySorter, () -> {
                });
                node(DInterBlocks.lightLink, () -> {
                    node(DInterBlocks.mediumLink, Seq.with(new SectorComplete(oldPlace)),() -> {
                        node(DInterBlocks.heavyLink/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                        });
                    });
                });
            });
            node(DInterBlocks.decayFactory, Seq.with(new SectorComplete(oldPlace)),() -> {
                node(DInterBlocks.decayModule, () -> {
                    node(DInterBlocks.decayModuleT2, () -> {
                    });
                });
                node(DInterBlocks.decayRefabricator, Seq.with(new SectorComplete(sectureBase)),() -> {
                    node(DInterUnits.remove, () -> {
                    });
                    node(DInterBlocks.decayAssembler/*, Seq.with(new SectorComplete(junkyard)*/,() -> {
                        node(DInterUnits.destroy, () -> {
                        });
                        node(DInterUnits.obliterate, Seq.with(new Research(DInterBlocks.decayModule)),() -> {
                        });
                        node(DInterUnits.annihilate, Seq.with(new Research(DInterBlocks.decayModule)),() -> {
                        });
                    });
                });
                node(DInterUnits.clear, () -> {
                });
                node(DInterUnits.refate/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                });
                node(DInterBlocks.timeFactory, Seq.with(new SectorComplete(oldPlace)),() -> {
                    node(DInterUnits.hour, () -> {
                    });
                    node(DInterBlocks.timeRefabricator, Seq.with(new SectorComplete(sectureBase)),() -> {
                        node(DInterUnits.clock, () -> {
                        });
                        node(DInterBlocks.timeAssembler/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                            node(DInterUnits.timer, () -> {
                            });
                            node(DInterUnits.day, Seq.with(new Research(DInterBlocks.decayModule)),() -> {
                            });
                            node(DInterUnits.year, Seq.with(new Research(DInterBlocks.decayModuleT2)),() -> {
                            });
                        });
                    });
                });
            });
            node(DInterBlocks.test, () -> {
                node(DInterBlocks.oreCrusher, () -> {
                    node(DInterBlocks.tectonicBomber/*, Seq.with(new SectorComplete(junkyard))*/,() -> {

                    });
                });
            });
            node(oldPlace, () -> {
               node(sectureBase, Seq.with(new SectorComplete(oldPlace)),() -> {
                     /*node(repairTerminal, Seq.with(new SectorComplete(sectureBase)),() -> {
                        node(junkyard, Seq.with(new SectorComplete(repairTerminal)),() -> {

                        });
                        node(highPeaks, Seq.with(new SectorComplete(repairTerminal)),() -> {
                            node(trainPath, Seq.with(new SectorComplete(highPeaks)),() -> {

                            });
                            node(orbitalCenter, Seq.with(new SectorComplete(highPeaks)),() -> {
                                node(timeSiege, Seq.with(new SectorComplete(orbitalCenter)),() -> {

                                });
                            });
                        });
                    });*/
                });
            });
            node(DInterBlocks.coreDry, () -> {
                node(DInterBlocks.coreDecay/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                });
                node(DInterBlocks.werehouse/*, Seq.with(new SectorComplete(junkyard))*/,() -> {
                });
            });
        });
    }
}