/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import Eventos.EventLineNumber;
import Eventos.EventOpen;
import Eventos.EventSave;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Seven
 */
public class Analizador extends Application {
    
    
    
    @Override
    public void start(Stage primaryStage) {
        /*----------CONTENEDOR PRINCIPAL----------*/
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        
        /*----------------------------------------------------*/
        /*--------------------Contendor 1--------------------*/
        GridPane pane_tools = new GridPane();
        pane_tools.setHgap(2);
        //pane_tools.setGridLinesVisible(true);
        
        //Boton play
        /*Image icon_play = new Image("recursos/play_24.png");
        ImageView iv = new ImageView();
        iv.setImage(icon_play);*/
        Button btn_open = new Button("", new ImageView("recursos/open_24.png"));
        
        Button btn_save = new Button("", new ImageView("recursos/save_24.png"));
        
        Button btn_play = new Button("", new ImageView("recursos/play_24.png"));
        
        Separator sepv = new Separator();
        sepv.setOrientation(Orientation.VERTICAL);
        
        Separator sepv2 = new Separator();
        sepv2.setOrientation(Orientation.VERTICAL);
        
        pane_tools.add(btn_open, 0, 0);
        pane_tools.add(sepv, 1, 0);
        pane_tools.add(btn_save, 2, 0);
        pane_tools.add(sepv2, 3, 0);
        pane_tools.add(btn_play, 4, 0);
        
        /*----------------------------------------------------*/
        /*--------------------Contendor 2--------------------*/
        GridPane pane_code = new GridPane();
        pane_code.setVgap(5);
        //Area que contiene el codigo a leer
        TextArea area_codigo = new TextArea();
        //area_codigo.setPrefSize(600, 638);
        area_codigo.setPrefSize(600, 400);
        
        //Texto
        Text txt_out = new Text("Output: ");
        
        //Area de output
        TextArea area_out = new TextArea();
        area_out.setPrefSize(600, 200);
        
        //EVENTOS
        btn_open.setOnMouseClicked(new EventOpen(primaryStage, area_codigo));
        btn_save.setOnMouseClicked(new EventSave(primaryStage, area_codigo));
        btn_play.setOnMousePressed(new EventRun(area_codigo, area_out));
        //Linea de numeros
        //TextArea line_numbers = new TextArea("1");
        //line_numbers.setEditable(false);
        //line_numbers.setPrefColumnCount(1);
        //line_numbers.setPrefSize(0.5, area_codigo.getHeight());
        
        //Evento de area codigo para line_numbers
        //area_codigo.setOnKeyPressed(new EventLineNumber(line_numbers));
        
        //pane_code.add(line_numbers, 0, 0);
        //pane_code.add(area_codigo, 1, 0);
        pane_code.add(area_codigo, 0, 0);
        pane_code.add(txt_out, 0, 1);
        pane_code.add(area_out, 0, 2);
        
        /*---------------------------------------------------------------*/
        /*----------Añadir componentes al contenedor principal----------*/
        Separator seph = new Separator();
        seph.setOrientation(Orientation.HORIZONTAL);
        
        grid.add(pane_tools, 0, 0);// objeto - columna - fila
        grid.add(seph, 0, 1);
        grid.add(pane_code, 0, 2);
        
        Scene scene = new Scene(grid, 650, 700);//gird - ancho - alto
        
        primaryStage.setTitle("Analizador IDE");
        primaryStage.getIcons().add(new Image("recursos/code3_32.png"));
        //primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        /*--------------------------------------------------------------------*/
        /*-----------------------Declaraciones con CSS-----------------------*/
        //line_numbers.lookup(".content").setStyle("-fx-background-color: whitesmoke");
        /*Region region = ( Region ) line_numbers.lookup( ".content");
        region.setBackground( new Background( new BackgroundFill( Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY ) ) );
        //Or you can set it by setStyle()
        region.setStyle( "-fx-background-color: gray; \n" + "-fx-text-alignment: LEFT_TO_RIGTH");*/
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        String ruta = "src\\analizador\\Lexico.flex";
        generarLexer(ruta);
        
        String opciones[] = new String[5];
        opciones[0] = "-destdir";
        opciones[1] = "src\\analizador";
        opciones[2] = "-parser";
        opciones[3] = "parser";
        opciones[4] = "src\\analizador\\Parser.cup";
        try{
            java_cup.Main.main(opciones);
        }catch(Exception e){
            System.out.println("\nSe genero error: " + e);
        }
    }
    
    public static void generarLexer(String ruta){
        File file = new File(ruta);
        jflex.Main.generate(file);
    }
    
}
