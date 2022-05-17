package de.dragonhard.game.gui;

import de.dragonhard.game.components.Field;
import de.dragonhard.game.components.FieldController;
import de.dragonhard.game.components.Storage;
import de.dragonhard.game.listener.WindowStateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_Base extends JFrame {

    private final String windowTitle;
    private final JPanel contentPane = new JPanel(), topBar = new JPanel();
    private final Color background = new Color(20,20,20,150);
    private final Color headerBackground = new Color(70,70,70);
    private final JLabel lblTitle = new JLabel();
    private final int width;
    private final int height;
    private final String id;

    private int fieldLocationX = Storage.loadInteger("Field_X");
    private int fieldLocationY = Storage.loadInteger("Field_Y");

    public GUI_Base(String title, int width, int height, String id){

        this.windowTitle = title;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public String getId(){
        return id;
    }

    private void addField(Color background){

        for(int l = 0; l < Storage.loadInteger("Field_Lines"); l ++){

            for(int f = 0; f < Storage.loadInteger("Field_Amount"); f ++){

                JPanel panel = new JPanel();

                panel.setBackground(background);
                panel.setBounds(fieldLocationX,fieldLocationY,Storage.loadInteger("Field_Width"),Storage.loadInteger("Field_Height"));
                panel.setName("Field_" + l + "_" + f);
                contentPane.add(panel);
                FieldController.addField(panel);
                panel.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        FieldController.toggleSelection(panel);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(FieldController.isEffectEnabled(panel)) {
                            panel.setBackground(Storage.loadColor("Field_Color_Mouse_Over"));
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(FieldController.isEffectEnabled(panel)) {
                            panel.setBackground(background);
                        }
                    }
                });

                fieldLocationX += (Storage.loadInteger("Field_Width") + Storage.loadInteger("Field_Space"));
            }
            fieldLocationX = Storage.loadInteger("Field_X");;
            fieldLocationY += (Storage.loadInteger("Field_Height") + Storage.loadInteger("Field_Space"));
        }

    }

    public JPanel getContentPane(){
        return contentPane;
    }

    public void initialize(){

        this.setTitle(windowTitle);
        this.setSize(width,height);
        this.setContentPane(contentPane);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(background);
        

        contentPane.setLayout(null);
        contentPane.setBackground(background);

        topBar.setLayout(null);
        topBar.setBounds(0,0, this.getWidth(), 25);
        topBar.setBackground(headerBackground);

        contentPane.add(topBar);

        lblTitle.setText(windowTitle);
        lblTitle.setForeground(Color.gray);
        lblTitle.setBounds(this.width / 2 - (windowTitle.length() + 15),5,120,15);

        topBar.add(lblTitle);


        addStateButton("X",new WindowStateListener("KILL"), Color.getHSBColor(0.3f,3f,0.7f), Color.getHSBColor(0.11f,0.435f,0.485f),0);
        addStateButton("_",new WindowStateListener("MINI"), new Color(150,80,80), Color.getHSBColor(0.01f,0.25f,0.5f),35);

        FrameManager.add(this);

        addField(Storage.loadColor("Field_Color_Default"));

        this.setVisible(true);

    }

    private void addStateButton(String title, ActionListener listener, Color background, Color mouseOver, int space){
        var defaultButtonWidth = 30;


        JButton button = new JButton();
        button.setBackground(background);
        button.setBounds(this.width - (defaultButtonWidth + ( 5 + space)),2, defaultButtonWidth,20);
        button.addActionListener(listener);
        button.setText(title);
        button.setBorder(null);
        button.setFocusable(false);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(mouseOver);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(background);
            }
        });

        topBar.add(button);

    }



}
