package decay.classes.blocks.crafting;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.Time;
import mindustry.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.blocks.production.*;

public class NearCrafter extends GenericCrafter {

    public NearCrafter(String name) {
        super(name);
        hasPower = true;
        hasItems = true;
        consumesPower = true;
        solid = true;
        sync = true;
        update = true;
        buildType = NearCrafterBuild::new;
    }
    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        super.drawPlace(x, y, rotation, valid);

        float a = 0;

        Point2[] edges = getEdges();
        for (Point2 edge : edges) {
            Building b = Vars.world.build(x + edge.x, y + edge.y);
            if (b != null && b.block.solid) {
                a += 1 / (size * 4f);
                Draw.z(Layer.blockOver);
                Drawf.square((x + edge.x) * 8, (y + edge.y) * 8, 4f, Mathf.PI / 4, Color.valueOf("ff0000"));
            }
        }

        drawPlaceText(Core.bundle.formatFloat("bar.efficiency", (1 - a) * 100, 1), x, y, valid);
    }
    public class NearCrafterBuild extends GenericCrafterBuild {
        public float totalProgress;

        @Override
        public float totalProgress() {
            return totalProgress;
        }

        @Override
        public void updateTile() {
            warmup = Mathf.lerpDelta(warmup, warmupTarget(), efficiency);

            Point2[] edges = block.getEdges();
            for (Point2 edge : edges) {
                Building b = nearby(edge.x, edge.y);
                if (b != null && b.block.solid) {
                    efficiency -= 1 / (size * 4f);
                }
            }
            if (efficiency < 0f) efficiency = 0f;

            totalProgress += warmup * Time.delta * efficiency;
            if (efficiency > 0f) {
                progress += getProgressIncrease(craftTime * efficiency);
            }
            if(progress >= 1f){
                craft();
            }
        }
    }
}
