package decay.content;

import arc.*;
import mindustry.ctype.*;

import static mindustry.game.Objectives.*;

public class DInterObjectives {
    public static class SoonTM implements Objective {
        public UnlockableContent content;

        public SoonTM() {}
        @Override
        public boolean complete() {
            return false;
        }

        @Override
        public String display() {
            return Core.bundle.format("requirement.denied");
        }
    }
    public static class ActivateTimeMachine implements Objective {
        public UnlockableContent content;

        public ActivateTimeMachine(UnlockableContent content) {
            this.content = content;
        }
        @Override
        public boolean complete() {
            return content.unlocked();
        }

        @Override
        public String display() {
            return Core.bundle.format("requirement.activate", content.localizedName);
        }
    }
    public static class ShadowDefeat implements Objective {
        public UnlockableContent content;

        public ShadowDefeat(UnlockableContent content) {
            this.content = content;
        }
        @Override
        public boolean complete() {
            return content.unlocked();
        }

        @Override
        public String display() {
            return Core.bundle.format("requirement.kill", content.localizedName);
        }
    }
}
