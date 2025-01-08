package decay.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import decay.graphics.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class DInterFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();
    public static TextureRegion missileRegion = Core.atlas.find("decal-missile");
    public static final Effect

    timeLaserCharge = new Effect(80f, 100f, e -> {
        color(DecayPal.darkTime);
        stroke(e.fin() * 2f);
        circle(e.x, e.y, 4f + e.fout() * 100f);

        Fill.circle(e.x, e.y, e.fin() * 18);

        randLenVectors(e.id, 20, 40f * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 5f);
            Drawf.light(e.x + x, e.y + y, e.fin() * 15f, DecayPal.darkTime, 0.7f);
        });

        color(DecayPal.lightTime);

        Fill.circle(e.x, e.y, e.fin() * 8);
        Drawf.light(e.x, e.y, e.fin() * 18f, DecayPal.darkTime, 0.7f);
    }),
            smallTimeLaserCharge = new Effect(80f, 100f, e -> {
                color(DecayPal.darkTime);
                stroke(e.fin() * 2f);
                circle(e.x, e.y, 3f + e.fout() * 100f);

                Fill.circle(e.x, e.y, e.fin() * 16);

                randLenVectors(e.id, 20, 40f * e.fout(), (x, y) -> {
                    Fill.circle(e.x + x, e.y + y, e.fin() * 5f);
                    Drawf.light(e.x + x, e.y + y, e.fin() * 15f, DecayPal.darkTime, 0.7f);
                });

                color();

                Fill.circle(e.x, e.y, e.fin() * 6);
                Drawf.light(e.x, e.y, e.fin() * 16f, DecayPal.darkTime, 0.7f);
            }),
    changeMode = new Effect(50f, 50f, e -> {
        color(DecayPal.darkTime);
        stroke(e.fin() * 2f);
        Lines.square(e.x, e.y, 4f, 0);
    }),
            viliniteCraft = new Effect(20f, 30f, e -> {
                color(DecayPal.vilinite);
                stroke(2f + e.fin() * 2.2f);
                Drawf.square(e.x, e.y, 6f - e.finpow() * e.rotation * 2f, 45);
            }),
    regen = new Effect(50f, 30f, e -> {
        color(DecayPal.vilinite);
        rand.setSeed(e.id);
        for(int i = 0; i < 3; i++){
            v.trns(rand.random(360f), rand.random(e.finpow() * 14f)).add(e.x, e.y);
            Fill.square(v.x, v.y, rand.random(0.6f, 1.4f));
        }
    }),
            rushMove = new Effect(50f, 20f, e -> {
                color(Color.darkGray);
                rand.setSeed(e.id);
                for(int i = 0; i < 3; i++){
                    v.trns(rand.random(360f), rand.random(e.finpow() * 40f)).add(e.x, e.y);
                    Fill.square(v.x, v.y, rand.random(11f, 14f));
                }
            }),
            regenWave = new Effect(11, e -> {
                color(DecayPal.vilinite);
                stroke(e.fout() * 2f);
                Lines.square(e.x, e.y, 6f, 0);
                color(DecayPal.darkTime);
                stroke(e.fout() * 2f);
                Lines.square(e.x, e.y, 6f, 45);
            }),
            resumeDespawn = new Effect(16, e -> {
                e.scaled(7, i -> {
                    stroke(3f * i.fout());
                    Lines.circle(e.x, e.y, 3f + i.fin() * 10f);
                });

                color(Color.gray);

                randLenVectors(e.id, 6, 2f + 19f * e.finpow(), (x, y) -> {
                    Fill.circle(e.x + x, e.y + y, e.fout() * 3f + 0.5f);
                    Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
                });

                color(DecayPal.darkTime, DecayPal.midTime, Color.gray, e.fin());
                stroke(1.5f * e.fout());

                randLenVectors(e.id + 1, 8, 1f + 23f * e.finpow(), (x, y) -> {
                    lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f);
                });
                color(DecayPal.darkTime);
                stroke(e.fin() * 2f);
                Lines.circle(e.x, e.y, 2f + e.fout() * 80f);

                color(DecayPal.darkTime);
                alpha(e.fout(Interp.pow4Out));
                float size = 10f + e.fout(Interp.pow10In) * 30f;
                Draw.rect(Icon.cancel.getRegion(), e.x, e.y, size, size);
            })

    ;
}