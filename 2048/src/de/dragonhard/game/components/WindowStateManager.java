package de.dragonhard.game.components;

import de.dragonhard.game.components.windowStates.WindowState;

import java.util.HashMap;

public class WindowStateManager {

    private static HashMap<String, WindowState> states = new HashMap<>();

    public static void addWindowState(WindowState state){
        states.put(state.name(),state);
    }

    public static void initState(String name){
        if(states.containsKey(name)) {
            states.get(name).initialize();
            return;
        }

        System.err.println("[ERROR] state : " + name + " dont exists or is not in the register");
    }

}
