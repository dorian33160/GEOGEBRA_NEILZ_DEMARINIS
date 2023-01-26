package PROJET;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextInputDialog;
public class Main extends Application {

    Pane root = new Pane();
    @Override
    public void start(Stage stage) throws IOException {

/*---------CRÉATION DU MENU POUR CREER UNE FORME GEOMETRIQUE---------------*/

        MenuBar menuBar = new MenuBar(); //Création de la barre de menu

        Menu figureMenu = new Menu("Figure"); //Création du menu Figure

        MenuItem carréMenuItem = new MenuItem("Carré"); //Création du sous-menu Carré
        carréMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Point[] points = new Point[4];


                TextInputDialog coord_point = new TextInputDialog("");
                for (int i = 1; i < 5; i++)
                {
                    coord_point.setTitle("Saisie des coordonnées");
                    coord_point.setHeaderText("Saisie des coordonnées du point " + i);
                    coord_point.setContentText("Entrez les coordonnées sous la forme x,y :");

                    Optional<String> result = coord_point.showAndWait();

                    if (result.isPresent()){
                        //récupère les variable, transforme les en double et créé un objet point
                        String[] coordonnees = result.get().split(","); //Sépare les coordonnées
                        double x = Double.parseDouble(coordonnees[0]); //Transforme la première coordonnée en double
                        double y = Double.parseDouble(coordonnees[1]); //Transforme la deuxième coordonnée en double
                        points[i - 1] = new Point(x,y);
                    }
                }

                Carré c2 = new Carré(points[0], points[1], points[2], points[3]);
            }
        });

        MenuItem cerfvolantMenuItem = new MenuItem("Cerf-volant"); //Création du sous-menu Cerf-volant
        cerfvolantMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
            }
        });

        MenuItem losangeMenuItem = new MenuItem("Losange"); //Création du sous-menu Losange
        losangeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
            }
        });

        MenuItem parallélogrammeMenuItem = new MenuItem("Parallélogramme"); //Création du sous-menu Parallélogramme
        parallélogrammeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
            }
        });

        MenuItem rectangleMenuItem = new MenuItem("Rectangle"); //Création du sous-menu Rectangle
        rectangleMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
            }
        });

        MenuItem trapèzeMenuItem = new MenuItem("Trapèze"); //Création du sous-menu Trapèze
        trapèzeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
            }
        });

        figureMenu.getItems().add(carréMenuItem);
        figureMenu.getItems().add(cerfvolantMenuItem);
        figureMenu.getItems().add(losangeMenuItem);
        figureMenu.getItems().add(parallélogrammeMenuItem);
        figureMenu.getItems().add(rectangleMenuItem);
        figureMenu.getItems().add(trapèzeMenuItem);

        menuBar.getMenus().add(figureMenu);

        VBox root = new VBox();
        root.getChildren().add(menuBar);

        /*---------CRÉATION DU MENU POUR CREER UNE FORME GEOMETRIQUE---------------*/

        Scene scene = new Scene(root, 1920, 1080);
        stage.setTitle("GeoGebra");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
