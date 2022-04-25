package grsu.course.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class MultipleController {
    private Pane view;

    public Pane getPage(String fileName){
        try{
            URL fileURL=LaunchApp.class.getResource(fileName+".fxml");
            if(fileURL==null){
                throw new java.io.FileNotFoundException("File is not found");
            }
            view=new FXMLLoader().load(fileURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
