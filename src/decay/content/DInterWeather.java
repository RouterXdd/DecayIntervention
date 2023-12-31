package decay.content;

import arc.util.*;
import decay.graphics.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.weather.*;


public class DInterWeather {
    public static Weather decayStorm, timePressure, timeBackground;
    public static void load() {

        decayStorm = new ParticleWeather("decay-storm") {{
            drawParticles = false;
            drawNoise = true;
            noiseColor = DecayPal.decalOutline;
            useWindVector = true;
            baseSpeed = 3.4f;
            force = 0.25f;
            sound = Sounds.wind;
            soundVol = 0.9f;
            duration = 5.6f * Time.toMinutes;
            attrs.set(DInterAttributes.decay, 1.2f);
            attrs.set(DInterAttributes.timedrive, 1f);
        }};
        timePressure = new ParticleWeather("time-pressure"){{
            particleRegion = "decay-inter-time-pressure-particle";
            sizeMax = 9f;
            sizeMin = 3f;
            randomParticleRotation = true;
            density = 1200f;
            attrs.set(DInterAttributes.timedrive, 2f);

            sound = Sounds.press;
            soundVol = 0f;
            soundVolOscMag = 1.5f;
            soundVolOscScl = 1100f;
            soundVolMin = 0.02f;
        }};
        timeBackground = new ParticleWeather("time-background") {{
            drawParticles = false;
            force = 0f;
            duration = 6f * Time.toMinutes;
            attrs.set(DInterAttributes.timedrive, 0.4f);
        }};
    }
}
