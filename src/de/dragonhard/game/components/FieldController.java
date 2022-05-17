package de.dragonhard.game.components;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FieldController {

   static final Color defaultColor = Storage.loadColor("Field_Color_Default");
   static final Color firstSelectedColor = Storage.loadColor("Field_Color_Selected_1");
   static final Color finalSelectedColor = Storage.loadColor("Field_Color_Selected_2");
   static final int maxSelectedFields = Storage.loadInteger("Field_Max_Selected");
   static int currentSelectedFields = 0;
   static int oldSelectedFields = 0;
   static boolean canSetOld = false;
   static ArrayList<JPanel> fields = new ArrayList<>();
   static HashMap<String, Integer> fieldStates = new HashMap<>();

   public static void addField(JPanel panel){
       fields.add(panel);
       fieldStates.put(panel.getName(), 0);
   }

   private static void updateState(JPanel panel, int state){
      fieldStates.remove(panel.getName(),fieldStates.get(panel.getName()));
      fieldStates.put(panel.getName(), state);
   }

    public static void toggleSelection(JPanel panel){

        for(int i = 0; i < fields.size(); i ++){
            JPanel field = fields.get(i);

            if(field.getName().equals(panel.getName())){
                System.out.println("field match [" +field.getName() + "]" );
                int fieldState = fieldStates.get(field.getName());

                switch (fieldState){

                    case 0:

                        if(currentSelectedFields == maxSelectedFields){
                            return;
                        }

                        panel.setBackground(firstSelectedColor);
                        updateState(field,1);
                        panel.updateUI();

                        break;
                    case 1:
                        if(isLimitReached()){return;}
                        panel.setBackground(finalSelectedColor);
                        updateState(field,2);
                        selectField(panel.getName());
                        panel.updateUI();

                        break;
                    case 2:

                        panel.setBackground(defaultColor);
                        updateState(field,0);
                        deselectField(panel.getName());
                        panel.updateUI();

                        break;
                }

            }

        }

        if(currentSelectedFields == 1){
            updateSelectionState();
        }

        System.out.println("isLimitReached: " + isLimitReached());

    }
    static boolean canOverride = false;
    public static void updateSelectionState(){
        if(!canOverride){return;}
        for(int i = 0; i < fields.size(); i++){
            if(fieldStates.get(fields.get(i).getName()) == 2){
                fields.get(i).setBackground(firstSelectedColor);
                fields.get(i).updateUI();
                updateState(fields.get(i),1);
            }

        }
        canOverride = false;
    }

    public static void clearFields(){
        for(int i = 0; i < fields.size(); i++){
            if(fieldStates.get(fields.get(i).getName()) != 2){
                fields.get(i).setBackground(defaultColor);
                fields.get(i).updateUI();
                updateState(fields.get(i),0);

            }
        }
    }

    static ArrayList<String> selectedFields = new ArrayList<>();
    private static boolean isLimitReached(){
        currentSelectedFields = selectedFields.size();
        if(currentSelectedFields == maxSelectedFields){
            clearFields();
            canOverride = true;
            return true;
        }
        return false;
    }

    private static void selectField(String name){
        selectedFields.add(name);
    }

    private static void deselectField(String name){
        selectedFields.remove(name);
    }

    public static boolean isEffectEnabled(JPanel panel){
        if(panel.getBackground() == firstSelectedColor){
            return false;
        }

        if(panel.getBackground() == finalSelectedColor){
            return false;
        }

        return true;
    }


}

