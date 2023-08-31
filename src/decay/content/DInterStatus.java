package decay.content;

import arc.graphics.*;
import decay.graphics.*;
import mindustry.type.*;
import mindustry.content.*;

public class DInterStatus {
        public static StatusEffect
        decaling, timeswap1, timeswap2, timeswap3, rush, timeCrack, timeStop, anotherTimeline, suppression;
   public static void load(){
    decaling = new StatusEffect("decaying"){{
            color = Color.valueOf("3a3a3a");
            speedMultiplier = 0.7f;
            reloadMultiplier = 0.65f;
            damage = 0.15f;
            effect = Fx.oily;
            }};
            timeswap1 = new StatusEffect("time-swap1"){{
            color = DecayPal.darkTime;
            speedMultiplier = -0.2f;
            }};
            timeswap2 = new StatusEffect("time-swap2"){{
            color = DecayPal.darkTime;
            speedMultiplier = -0.5f;
            }};
            timeswap3 = new StatusEffect("time-swap3"){{
            color = DecayPal.darkTime;
            speedMultiplier = -1f;
            }};
            rush = new StatusEffect("rushS"){{
                color = DecayPal.rushCol;
                speedMultiplier = 1.25f;
                reloadMultiplier = 1.10f;
            }};
       timeCrack = new StatusEffect("time-crack"){{
           color = DecayPal.darkTime;
           speedMultiplier = 0.9f;
           reloadMultiplier = 0.85f;
           dragMultiplier = 1.4f;
       }};
       timeStop = new StatusEffect("time-stop"){{
           color = DecayPal.darkTime;
           speedMultiplier = 0f;
           reloadMultiplier = 0f;
       }};
       anotherTimeline = new StatusEffect("another-timeline"){{
           color = DecayPal.darkTime;
           damageMultiplier = 0f;
           healthMultiplier = 10000000f;
           effect = DInterFx.changeMode;
       }};
       suppression = new StatusEffect("suppression"){{
           color = DecayPal.darkTime;
           reloadMultiplier = 0.9f;
           dragMultiplier = 0.8f;
       }};
    }
}