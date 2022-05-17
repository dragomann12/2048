package de.dragonhard.game.components.windowStates;

import de.dragonhard.game.gui.FrameManager;
import de.dragonhard.game.gui.GUI_Base;

public class WindowState_Minimize implements WindowState {
    @Override
    public String name() {
        return "MINI";
    }

    @Override
    public void initialize() {
        GUI_Base base = FrameManager.get("MASTER");
        base.setExtendedState(1);
    }
}
