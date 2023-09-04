package decay.content;
import mindustry.type.*;

import static decay.content.DInterPlanets.decalin;

public class DInterSectors {
    public static SectorPreset
    oldPlace, sectureBase;

    public static void load(){
        oldPlace = new SectorPreset("old-place", decalin, 16){{
            alwaysUnlocked = true;
            captureWave = 15;
            difficulty = 2;
            startWaveTimeMultiplier = 1.8f;
        }};
        sectureBase = new SectorPreset("secture-base", decalin, 95){{
            difficulty = 4;
        }};
    }
}
