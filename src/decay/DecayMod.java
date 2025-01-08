package decay;

import mindustry.mod.*;
import decay.content.*;

public class DecayMod extends Mod{

    public DecayMod(){
    }

    @Override
    public void loadContent(){
        DInterTeams.load();
        DInterAttributes.load();
        DInterItems.load();
        DInterLiquids.load();
        DInterStatus.load();
        DInterWeather.load();
        DInterUnits.load();
        DInterBlocks.load();
        DInterLoadouts.load();
        DInterPlanets.load();
        DInterSectors.load();
        DecalinTechTree.load();
    }

}
