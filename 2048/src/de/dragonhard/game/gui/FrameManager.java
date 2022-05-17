package de.dragonhard.game.gui;

import java.util.HashMap;

public class FrameManager {

    private static HashMap<String, GUI_Base> guis = new HashMap<>();

    public static void add(GUI_Base guiBase){
        if(guis.containsKey(guiBase.getId())){
            return;
        }

        guis.put(guiBase.getId(),guiBase);
    }

    public static GUI_Base get(String id){
        if(guis.containsKey(id)){
            return guis.get(id);
        }
        return null;
    }

}
