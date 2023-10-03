package decay.content;

import arc.graphics.*;
import decay.classes.type.*;
import mindustry.type.*;

public class DInterLiquids {
    public static Liquid ether;
    public static void load() {

        ether = new EtherLiquid("ether", Color.valueOf("4576c9"));
        /*gasOxygen = new Liquid("oxygen-gas", Color.valueOf("b8c9df")) {{
            gas = true;
            temperature = 0.5f;
        }};
        tritium = new Liquid("tritium", Color.valueOf("aaea91")) {{
            gas = true;
            temperature = 0.5f;
        }};*/
    }
}
