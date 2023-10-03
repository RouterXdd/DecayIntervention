package decay.classes.type;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;

import static mindustry.entities.Puddles.*;

public class EtherLiquid extends Liquid {
    public int cells = 8;
    public float effectChance = 0.0035f;
    public EtherLiquid(String name, Color color){
        super(name, color);
    }
    @Override
    public void drawPuddle(Puddle puddle){
        super.drawPuddle(puddle);

        float baseLayer = puddle.tile != null && puddle.tile.block().solid || puddle.tile.build != null ? Layer.blockOver : Layer.debris - 0.5f;

        int id = puddle.id;
        float amount = puddle.amount, x = puddle.x, y = puddle.y;
        float f = Mathf.clamp(amount / (maxLiquid / 1.5f));
        float smag = puddle.tile.floor().isLiquid ? 0.8f : 0f, sscl = 25f;
        float length = Math.max(f, 0.3f) * 9f;

        rand.setSeed(id);
        for(int i = 0; i < cells; i++){
            if(Mathf.chance(effectChance)) {
                Draw.z(baseLayer + i / 1000f + (id % 100) / 10000f);
                Tmp.v1.trns(rand.random(360f), rand.random(length));
                float vx = x + Tmp.v1.x, vy = y + Tmp.v1.y;
                Fx.vapor.at(vx, vy, color);
            }
        }

        Draw.color();
    }
}
