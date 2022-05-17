package de.dragonhard.game;

import de.dragonhard.game.components.Storage;
import de.dragonhard.game.components.WindowStateManager;
import de.dragonhard.game.components.windowStates.WindowState_Kill;
import de.dragonhard.game.components.windowStates.WindowState_Minimize;
import de.dragonhard.game.gui.GUI_Base;

import java.awt.*;

public class Main {

    public static void main(String[] args){
        _initializeStorage();

        GUI_Base master = new GUI_Base(
                Storage.loadString("Master_Title"),
                Storage.loadInteger("Master_Width"),
                Storage.loadInteger("Master_Height"),
                Storage.loadString("Master_Id")
        );

        master.initialize();

    }

    private static void _initializeStorage(){

        WindowStateManager.addWindowState(new WindowState_Kill());
        WindowStateManager.addWindowState(new WindowState_Minimize());

        Storage.save("Master_Title","2048 Java Edition");
        Storage.save("Master_Width",1200);
        Storage.save("Master_Height",800);
        Storage.save("Master_Id","MASTER");

        Storage.save("Field_Lines",4);
        Storage.save("Field_Amount",4);
        Storage.save("Field_Width",180);
        Storage.save("Field_Height",180);
        Storage.save("Field_X",40);
        Storage.save("Field_Y",40);
        Storage.save("Field_Max_Selected",2);
        Storage.save("Field_Space",10);

        Storage.save("Field_Color_Default", Color.lightGray);
        Storage.save("Field_Color_Mouse_Over", Color.gray);
        Storage.save("Field_Color_Selected_1", Color.yellow);
        Storage.save("Field_Color_Selected_2", Color.green);
    }
}
