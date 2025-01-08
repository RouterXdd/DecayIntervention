package decay.classes.abilities;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.scene.ui.layout.Table;
import arc.util.*;
import decay.content.*;
import decay.graphics.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class StealDecayField extends Ability {
    public float range, damage, percentAmount;
    public StealDecayField( float range, float damage, float percentAmount) {
        this.range = range;
        this.damage = damage;
        this.percentAmount = percentAmount;
    }

    @Override
    public String localized() {
        return Core.bundle.format("ability.stealfield");
    }

    @Override
    public void addStats(Table t){
        t.add("[lightgray]" + Stat.range.localized() + ": [white]" + range / 8f + StatUnit.blocks.localized());
        t.row();
        t.add("[lightgray]" + Stat.damage.localized() + ": [white]" + damage + StatUnit.perSecond.localized());
        t.row();
        t.add("[lightgray]" + Stat.healing.localized() + ": [white]" + percentAmount + StatUnit.percent.localized());
    }

    @Override
    public void update(Unit unit) {
        Units.nearbyEnemies(unit.team, unit.x, unit.y, range, other -> {
            other.damageContinuousPierce(damage);
            unit.heal((unit.maxHealth * percentAmount / 100f) * Time.delta);
        });
    }
    @Override
    public void draw(Unit unit) {
        super.draw(unit);
        Drawf.circles(unit.x, unit.y, range, new Color(DecayPal.darkTime));
    }
}
