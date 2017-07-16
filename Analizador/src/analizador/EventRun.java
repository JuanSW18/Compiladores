/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

//import analizador.Lexico;
import java.io.BufferedReader;
import java.io.StringReader;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Seven
 */
public class EventRun implements EventHandler<MouseEvent>{
    
    public TextArea aux;
    public TextArea aux_out;
    
    public EventRun(TextArea codigo, TextArea out) {
        this.aux = codigo;
        this.aux_out = out;
    }
    
    
    @Override
    public void handle(MouseEvent event) {
        aux_out.setText(null);
        try {
            prueba(aux);
        } catch (Exception ex) {
            System.out.println("Error fr EventRun");
        }
    }
    
    public void prueba(TextArea area_codigo) throws Exception{
        String data = area_codigo.getText();
        Lexico lexer = new Lexico(new BufferedReader(new StringReader(data)));
        parser p = new parser(lexer);
        p.parse();
        this.aux_out.setText(p.Imprimir());
    }
}
