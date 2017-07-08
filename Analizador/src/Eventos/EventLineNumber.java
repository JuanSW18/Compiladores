/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Seven
 */
public class EventLineNumber  implements EventHandler<KeyEvent>{

    int line = 1;
    public TextArea numbers;
    public EventLineNumber (TextArea line){
        this.numbers = line;
    }
    
    @Override
    public void handle(KeyEvent tecla) {
        if(tecla.getCode().equals(KeyCode.ENTER)){
            line++;
            numbers.appendText("\n" + String.valueOf(line));
            //System.out.println(line);
            
        }
        else
            if(tecla.getCode().equals(KeyCode.BACK_SPACE)){
                //System.out.println("retroceder");
                //numbers.deleteText(numbers.getCaretPosition()-1, numbers.getCaretPosition()); //linea inicio - linea final
                numbers.deleteText(numbers.getLength()-1, numbers.getLength());
                //System.out.println("borrando: " + line);
                line--;
                //borrar espacio
                //numbers.deleteText(numbers.getCaretPosition()-1, numbers.getCaretPosition());
                numbers.deleteText(numbers.getLength()-1, numbers.getLength());
            }
    }
    
}
