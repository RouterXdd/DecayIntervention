package decay.classes.meta;

import arc.*;
import arc.struct.*;
import mindustry.world.meta.*;

import java.util.*;

public class DInterStat implements Comparable<Stat> {
    public static final Seq<decay.classes.meta.DInterStat> allStat = new Seq<>();

    public static final Stat

            repairChance = new Stat("repairChance"),
            healAmount = new Stat("healAmount"),
            mirrorChance = new Stat("mirrorChance"),
            decay = new Stat("decay");

    public final StatCat category;
    public final String name;
    public final int id;

    public DInterStat(String name, StatCat category){
        this.category = category;
        this.name = name;
        id = allStat.size;
        allStat.add(this);
    }

    public DInterStat(String name){
        this(name, StatCat.general);
    }

    public String localized(){
        return Core.bundle.get("stat." + name.toLowerCase(Locale.ROOT));
    }

    @Override
    public int compareTo(Stat o){
        return id - o.id;
    }
}
