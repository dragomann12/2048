package de.dragonhard.game.listener;



import de.dragonhard.game.components.WindowStateManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowStateListener implements ActionListener {

    private final String name;

    public WindowStateListener(String name){

        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowStateManager.initState(name);
    }
}
