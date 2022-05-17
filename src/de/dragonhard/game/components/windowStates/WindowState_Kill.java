package de.dragonhard.game.components.windowStates;

public class WindowState_Kill implements WindowState {
    @Override
    public String name() {
        return "KILL";
    }

    @Override
    public void initialize() {
        System.exit(0);
    }
}
