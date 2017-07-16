/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Seven
 */
public class EventSave implements EventHandler<MouseEvent>{

    Stage aux;
    TextArea code_s;
    
    public EventSave(Stage principal, TextArea code_save) {
        this.aux = principal;
        this.code_s = code_save;
    }    
    
    @Override
    public void handle(MouseEvent event) {
        FileChooser ventana_save = new FileChooser();
        
        //FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        //ventana_save.getExtensionFilters().add(extFilter);
        
        //ventana_save.showSaveDialog(aux);
        try{
            File ruta_guardar = ventana_save.showSaveDialog(aux);
            if (ruta_guardar != null) {
                FileWriter fw = null;
                try {
                    //String ruta = ruta_guardar.getAbsolutePath();
                    fw = new FileWriter(ruta_guardar);
                    fw.write(code_s.getText());
                    fw.close();
                    System.out.println("se guardo archivo " + ruta_guardar.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Error al guardar");
                }
            }
        }catch(Exception e){
            System.out.println("Ventana Guardar cerrada");
        }
        
    }
    
}
