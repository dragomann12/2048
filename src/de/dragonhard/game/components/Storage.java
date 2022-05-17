package de.dragonhard.game.components;

import java.awt.*;
import java.util.HashMap;

public class Storage {

    private static final HashMap<String, String> string_storage = new HashMap<>();
    private static final HashMap<String, Integer> integer_storage = new HashMap<>();
    private static final HashMap<String, Boolean> boolean_storage = new HashMap<>();
    private static final HashMap<String, Color> color_storage = new HashMap<>();

    public static void save(String key, String value) {
        if(key.isEmpty() || key.isBlank()){System.err.println("[Storage] [Error] no key for value"); return;}
        if(value.isEmpty() || value.isBlank()){System.err.println("[Storage] [Error] no key for value" + key + "*"); return;}
        if(string_storage.containsKey(key)){
            deleteString(key);
            string_storage.put(key,value);
        }
        string_storage.put(key, value);
    }

    public static void save(String key, int value) {
        if(key.isEmpty() || key.isBlank()){System.err.println("[Storage] [Error] no key for value"); return;}
        if(value == 0){System.err.println("[Storage] [Error] no key for value" + key + "*"); return;}
        if(integer_storage.containsKey(key)){
            deleteInteger(key);
            integer_storage.put(key,value);
        }

        integer_storage.put(key, value);
    }

    public static void save(String key, boolean value) {
        if(key.isEmpty() || key.isBlank()){System.err.println("[Storage] [Error] no key for value"); return;}
        if(boolean_storage.containsKey(key)){
            deleteBoolean(key);
            boolean_storage.put(key,value);
        }
        boolean_storage.put(key, value);
    }

    public static void save(String key, Color value) {
        if(key.isEmpty() || key.isBlank()){System.err.println("[Storage] [Error] no key for value"); return;}
        if(value == null || value == Color.black){System.err.println("[Storage] [Error] blocked value"); return;}
        if(color_storage.containsKey(key)){
            deleteColor(key);
            color_storage.put(key,value);
        }
        color_storage.put(key, value);
    }

    public static String loadString(String key){
        if(key.isEmpty() || key.isBlank()){System.err.println("[Storage] [Error] no key for value"); return "";}
        return string_storage.get(key);
    }

    public static Integer loadInteger(String key){
        if(key.isEmpty() || key.isBlank()){System.err.println("[Storage] [Error] no key for value"); return 0;}
        return integer_storage.get(key);
    }

    public static Boolean loadBoolean(String key){
        if(key.isEmpty() || key.isBlank()){System.err.println("[Storage] [Error] no key for value"); return false;}
        return boolean_storage.get(key);
    }

    public static Color loadColor(String key){
        if(key.isEmpty() || key.isBlank()){System.err.println("[Storage] [Error] no key for value"); return null;}
        return color_storage.get(key);
    }

    public static void deleteString(String key){
        if(string_storage.containsKey(key)){
            string_storage.remove(key, string_storage.get(key));
            System.out.println("[Storage] [Success] key detected and deleted");
            return;
        }
        System.err.println("[Storage] [Error] no key detected");
    }

    public static void deleteInteger(String key){
        if(integer_storage.containsKey(key)){
            integer_storage.remove(key, integer_storage.get(key));
            System.out.println("[Storage] [Success] key detected and deleted");
            return;
        }
        System.err.println("[Storage] [Error] no key detected");
    }

    public static void deleteBoolean(String key){
        if(boolean_storage.containsKey(key)){
            boolean_storage.remove(key, boolean_storage.get(key));
            System.out.println("[Storage] [Success] key detected and deleted");
            return;
        }
        System.err.println("[Storage] [Error] no key detected");
    }

    public static void deleteColor(String key){
        if(color_storage.containsKey(key)){
            color_storage.remove(key, color_storage.get(key));
            System.out.println("[Storage] [Success] key detected and deleted");
            return;
        }
        System.err.println("[Storage] [Error] no key detected");
    }

}
