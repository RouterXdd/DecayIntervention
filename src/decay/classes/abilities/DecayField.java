package decay.classes.abilities;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.Time;
import decay.content.*;
import decay.graphics.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mindustry.graphics.*;

import static mindustry.Vars.*;

public class DecayField extends Ability {
    public float range, damage, maxRange;
    public DecayField( float range, float damage, float maxRange) {
        this.range = range;
        this.damage = damage;
        this.maxRange = maxRange;
    }

    @Override
    public String localized() {
        return Core.bundle.format("ability.decayfield", range / 8f, damage);
    }

    @Override
    public void update(Unit unit) {
        if (range > maxRange){
            range = maxRange;
        }
        Units.nearbyEnemies(unit.team, unit.x, unit.y, range, other -> {
            other.damageContinuousPierce(damage);
        });
        if (unit.hasEffect(DInterStatus.suppression) && range > 0){
            range -= Time.delta / 2;
        } else {
            range += Time.delta / 2;
        }
    }
    @Override
    public void draw(Unit unit) {
        super.draw(unit);

        Draw.z(Layer.shields);

        Draw.color(DecayPal.decalOutline);

        if(renderer.animateShields){
            Fill.poly(unit.x, unit.y, 360, range);
        }else{
            Lines.stroke(1.5f);
            Draw.alpha(0.09f + Mathf.clamp(0.08f * 0f));
            Fill.poly(unit.x, unit.y, 360, range);
            Draw.alpha(1f);
            Lines.poly(unit.x, unit.y, 360, range);
            Draw.reset();
        }
    }
}
