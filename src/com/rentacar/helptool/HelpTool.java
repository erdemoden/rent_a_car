package com.rentacar.helptool;

import javax.swing.*;

public class HelpTool {


    /**
     * @param theme
     * Parametreye girilen tema aktif olur
     */
    public static void setTheme(String theme){
        /*
        // # Tema Yapıları Sıralar
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            System.out.println(info.getName() + "->" + info.getClassName());
        }
        */
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if(theme.equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }




}
