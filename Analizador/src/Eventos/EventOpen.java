/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class EventOpen implements EventHandler<MouseEvent>{

    Stage aux;
    TextArea code;
    
    public EventOpen(Stage principal, TextArea codigo) {
        this.aux = principal;
        this.code = codigo;
    }

    @Override
    public void handle(MouseEvent event) {
        FileChooser ventana_abrir = new FileChooser();
        //ventana_abrir.showOpenDialog(aux);
        try{
            File archivoSelec = ventana_abrir.showOpenDialog(aux);
            //System.out.println(archivoSelec.getAbsolutePath());
            code.setText(null);
            if (archivoSelec.exists()) {
                String ruta = archivoSelec.getAbsolutePath();
                FileReader fr = null;
                BufferedReader br = null;
                try {
                    fr = new FileReader(ruta);
                    br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        code.appendText(linea + "\n");
                    }
                    fr.close();
                } catch (IOException e) {
                    System.out.println("ERROR AL LEER ARCHIVO");
                }
            }
        }catch(Exception e){
            System.out.println("Ventana cerrada");
        }
    }
    
}
