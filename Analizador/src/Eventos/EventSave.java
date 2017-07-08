/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Seven
 */
public class EventSave implements EventHandler<MouseEvent>{

    Stage aux;

    public EventSave(Stage principal) {
        this.aux = principal;
    }    
    
    @Override
    public void handle(MouseEvent event) {
        FileChooser ventana_save = new FileChooser();
        ventana_save.showSaveDialog(aux);
    }
    
}
