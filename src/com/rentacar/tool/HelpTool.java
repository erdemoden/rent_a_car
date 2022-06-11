package com.rentacar.tool;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

// Oluşturulan Yardımcı fonksiyonlar
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
                break;
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
     * @param axis
     * @param size
     * Pencerelerin eksenlerini ortalar
     * iki parametre alır. eksen ve dialog'un boyutu.
     */
    public static int screenCenterAxis(String axis, Dimension size){
        int point = 0;
        switch (axis){
            case "x" :
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2 ;
                break;
            case "y" :
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
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
