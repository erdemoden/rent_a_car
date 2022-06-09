package com.rentacar.helptool;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class HelpTool {


    /**
     * @param theme
     * Parametreye girilen tema aktif olur
     */
    public static void setTheme(String theme){
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

    public static void getThemes(){
        // # Tema Yapıları Sıralar
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            System.out.println(info.getName() + "->" + info.getClassName());
        }
    }

    /**
     * @param textField
     * Parametreye girilen Text ve Password alanlarının içi
     * boş ise true, dolu ise false döner
     */
    public static boolean isTextFieldEmpty(JTextComponent textField){
        boolean result = true;
        if(textField.getText().length() == 0){
            result = true;
        }else {
            result = false;
        }
        return result;
    }





}
