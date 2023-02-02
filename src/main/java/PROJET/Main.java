package PROJET;

import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.ChoiceDialog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.control.TextInputDialog;
import javafx.scene.shape.Line;

import javafx.scene.control.Alert;


public class Main extends Application {

    Pane root = new Pane();
    //Déclaration des points[] pour faire les lignes :

    @Override
    public void start(Stage stage) throws IOException {

        /*---------CRÉATION DU MENU POUR CREER UNE FORME GEOMETRIQUE---------------*/

        MenuBar menuBar = new MenuBar(); //Création de la barre de menu

        Menu figureMenu = new Menu("Figure"); //Création du menu Figure

        //CARRE !!!
        MenuItem carréMenuItem = new MenuItem("Carré"); //Création du sous-menu Carré
        carréMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                InterPoint[] points = new InterPoint[4];

                String type_point = "";

                ArrayList<String> choices = new ArrayList<>();
                choices.add("Point");
                choices.add("Point2");

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Choix du type de point", choices);
                dialog.setTitle("Choix");
                dialog.setHeaderText("Sélectionnez une option");
                dialog.setContentText("Options :");

                Optional<String> resultat = dialog.showAndWait();

                if (resultat.isPresent()) {
                    type_point = resultat.get();
                } else {
                    System.out.println("Aucune option choisie");
                }

                TextInputDialog coord_point = new TextInputDialog("");
                for (int i = 1; i < 5; i++)
                {
                    coord_point.setTitle("Saisie des coordonnées");
                    coord_point.setHeaderText("Saisie des coordonnées du point " + i);
                    if (type_point.equals("Point"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme x,y :");
                    else if (type_point.equals("Point2"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme angle, rayon :");

                    Optional<String> result = coord_point.showAndWait();

                    if (result.isPresent()){
                        //récupère les variable, transforme les en double et créé un objet point
                        String[] coordonnees = result.get().split(","); //Sépare les coordonnées
                        double x = Double.parseDouble(coordonnees[0]); //Transforme la première coordonnée en double
                        double y = Double.parseDouble(coordonnees[1]); //Transforme la deuxième coordonnée en double
                        points[i - 1] = FabriquePoint.create(type_point, x, y); //Créé un objet point avec les coordonnées
                    }
                }
                System.out.println(points[0].getX()+ " " + points[0].getY() + " " + points[1].getX() + " " + points[1].getY() + " " + points[2].getX() + " " + points[2].getY() + " " + points[3].getX() + " " + points[3].getY());
                Carré c1 = new Carré(points[0], points[1], points[2], points[3]);

                //si c'est un carré ca affiche
                if (c1.verification()) {
                    //Premiere ligne a dessiner
                    Line l1 = new Line(points[0].getX()+100, points[0].getY()+100, points[1].getX()+100, points[1].getY()+100);
                    l1.setStroke(Color.RED);
                    l1.setStrokeWidth(5);

                    //Deuxieme ligne a dessiner
                    Line l2 = new Line(points[1].getX()+100, points[1].getY()+100, points[2].getX()+100, points[2].getY()+100);
                    l2.setStroke(Color.RED);
                    l2.setStrokeWidth(5);

                    //Troisieme ligne a dessiner
                    Line l3 = new Line(points[2].getX()+100, points[2].getY()+100, points[3].getX()+100, points[3].getY()+100);
                    l3.setStroke(Color.RED);
                    l3.setStrokeWidth(5);

                    //quatrieme ligne a dessiner
                    Line l4 = new Line(points[3].getX()+100, points[3].getY()+100, points[0].getX()+100, points[0].getY()+100);
                    l4.setStroke(Color.RED);
                    l4.setStrokeWidth(5);


                    //Affiche reellement l'objet. getChildren : liste ces enfants
                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);
                    root.getChildren().add(l4);
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur de coordonnées");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous n'avez pas dessiné un carré, recommencez avec des coordonnées justes");
                    alert.showAndWait();
                }

            }

        });

        //RECTANGLE !!!
        MenuItem rectangleMenuItem = new MenuItem("Rectangle"); //Création du sous-menu Rectangle
        rectangleMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
                InterPoint[] points = new InterPoint[4];

                String type_point = "";

                ArrayList<String> choices = new ArrayList<>();
                choices.add("Point");
                choices.add("Point2");

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Choix du type de point", choices);
                dialog.setTitle("Choix");
                dialog.setHeaderText("Sélectionnez une option");
                dialog.setContentText("Options :");

                Optional<String> resultat = dialog.showAndWait();

                if (resultat.isPresent()) {
                    type_point = resultat.get();
                } else {
                    System.out.println("Aucune option choisie");
                }

                TextInputDialog coord_point = new TextInputDialog("");
                for (int i = 1; i < 5; i++)
                {
                    coord_point.setTitle("Saisie des coordonnées");
                    coord_point.setHeaderText("Saisie des coordonnées du point " + i);
                    if (type_point.equals("Point"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme x,y :");
                    else if (type_point.equals("Point2"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme angle, rayon :");

                    Optional<String> result = coord_point.showAndWait();

                    if (result.isPresent()){
                        //récupère les variable, transforme les en double et créé un objet point
                        String[] coordonnees = result.get().split(","); //Sépare les coordonnées
                        double x = Double.parseDouble(coordonnees[0]); //Transforme la première coordonnée en double
                        double y = Double.parseDouble(coordonnees[1]); //Transforme la deuxième coordonnée en double
                        points[i - 1] = FabriquePoint.create(type_point, x, y);
                    }
                }

                Rectangle r1 = new Rectangle(points[0], points[1], points[2], points[3]);

                if (r1.verification()) {
                    //Premiere ligne a dessiner
                    Line l1 = new Line(points[0].getX()+100, points[0].getY()+100, points[1].getX()+100, points[1].getY()+100);
                    l1.setStroke(Color.BLUE);
                    l1.setStrokeWidth(5);

                    //Deuxieme ligne a dessiner
                    Line l2 = new Line(points[1].getX()+100, points[1].getY()+100, points[2].getX()+100, points[2].getY()+100);
                    l2.setStroke(Color.BLUE);
                    l2.setStrokeWidth(5);

                    //Troisieme ligne a dessiner
                    Line l3 = new Line(points[2].getX()+100, points[2].getY()+100, points[3].getX()+100, points[3].getY()+100);
                    l3.setStroke(Color.BLUE);
                    l3.setStrokeWidth(5);

                    //quatrieme ligne a dessiner
                    Line l4 = new Line(points[3].getX()+100, points[3].getY()+100, points[0].getX()+100, points[0].getY()+100);
                    l4.setStroke(Color.BLUE);
                    l4.setStrokeWidth(5);


                    //Affiche reellement l'objet. getChildren : liste ces enfants
                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);
                    root.getChildren().add(l4);
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur de coordonnées");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous n'avez pas dessiné un carré, recommencez avec des coordonnées justes");
                    alert.showAndWait();
                }
            }
        });

        //PARALLELOGRAMME !!!
        MenuItem parallélogrammeMenuItem = new MenuItem("Parallélogramme"); //Création du sous-menu Parallélogramme
        parallélogrammeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
                InterPoint[] points = new InterPoint[4];

                String type_point = "";

                ArrayList<String> choices = new ArrayList<>();
                choices.add("Point");
                choices.add("Point2");

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Choix du type de point", choices);
                dialog.setTitle("Choix");
                dialog.setHeaderText("Sélectionnez une option");
                dialog.setContentText("Options :");

                Optional<String> resultat = dialog.showAndWait();

                if (resultat.isPresent()) {
                    type_point = resultat.get();
                } else {
                    System.out.println("Aucune option choisie");
                }

                TextInputDialog coord_point = new TextInputDialog("");
                for (int i = 1; i < 5; i++)
                {
                    coord_point.setTitle("Saisie des coordonnées");
                    coord_point.setHeaderText("Saisie des coordonnées du point " + i);
                    if (type_point.equals("Point"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme x,y :");
                    else if (type_point.equals("Point2"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme angle, rayon :");

                    Optional<String> result = coord_point.showAndWait();

                    if (result.isPresent()){
                        //récupère les variable, transforme les en double et créé un objet point
                        String[] coordonnees = result.get().split(","); //Sépare les coordonnées
                        double x = Double.parseDouble(coordonnees[0]); //Transforme la première coordonnée en double
                        double y = Double.parseDouble(coordonnees[1]); //Transforme la deuxième coordonnée en double
                        points[i - 1] = FabriquePoint.create(type_point, x, y);
                    }
                }

                Parallélogramme p1 = new Parallélogramme(points[0], points[1], points[2], points[3]);

                if (p1.verification()) {
                    //Premiere ligne a dessiner
                    Line l1 = new Line(points[0].getX()+100, points[0].getY()+100, points[1].getX()+100, points[1].getY()+100);
                    l1.setStroke(Color.GREEN);
                    l1.setStrokeWidth(5);

                    //Deuxieme ligne a dessiner
                    Line l2 = new Line(points[1].getX()+100, points[1].getY()+100, points[2].getX()+100, points[2].getY()+100);
                    l2.setStroke(Color.GREEN);
                    l2.setStrokeWidth(5);

                    //Troisieme ligne a dessiner
                    Line l3 = new Line(points[2].getX()+100, points[2].getY()+100, points[3].getX()+100, points[3].getY()+100);
                    l3.setStroke(Color.GREEN);
                    l3.setStrokeWidth(5);

                    //quatrieme ligne a dessiner
                    Line l4 = new Line(points[3].getX()+100, points[3].getY()+100, points[0].getX()+100, points[0].getY()+100);
                    l4.setStroke(Color.GREEN);
                    l4.setStrokeWidth(5);


                    //Affiche reellement l'objet. getChildren : liste ces enfants
                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);
                    root.getChildren().add(l4);
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur de coordonnées");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous n'avez pas dessiné un carré, recommencez avec des coordonnées justes");
                    alert.showAndWait();
                }
            }
        });

        //CERF-VOLANT !!!
        MenuItem cerfvolantMenuItem = new MenuItem("Cerf-volant"); //Création du sous-menu Cerf-volant
        cerfvolantMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
                InterPoint[] points = new InterPoint[4];

                String type_point = "";

                ArrayList<String> choices = new ArrayList<>();
                choices.add("Point");
                choices.add("Point2");

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Choix du type de point", choices);
                dialog.setTitle("Choix");
                dialog.setHeaderText("Sélectionnez une option");
                dialog.setContentText("Options :");

                Optional<String> resultat = dialog.showAndWait();

                if (resultat.isPresent()) {
                    type_point = resultat.get();
                } else {
                    System.out.println("Aucune option choisie");
                }

                TextInputDialog coord_point = new TextInputDialog("");
                for (int i = 1; i < 5; i++)
                {
                    coord_point.setTitle("Saisie des coordonnées");
                    coord_point.setHeaderText("Saisie des coordonnées du point " + i);
                    if (type_point.equals("Point"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme x,y :");
                    else if (type_point.equals("Point2"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme angle, rayon :");

                    Optional<String> result = coord_point.showAndWait();

                    if (result.isPresent()){
                        //récupère les variable, transforme les en double et créé un objet point
                        String[] coordonnees = result.get().split(","); //Sépare les coordonnées
                        double x = Double.parseDouble(coordonnees[0]); //Transforme la première coordonnée en double
                        double y = Double.parseDouble(coordonnees[1]); //Transforme la deuxième coordonnée en double
                        points[i - 1] = FabriquePoint.create(type_point, x, y);
                    }
                }

                Cerfvolant cerf1 = new Cerfvolant(points[0], points[1], points[2], points[3]);

                if (cerf1.verification()) {
                    //Premiere ligne a dessiner
                    Line l1 = new Line(points[0].getX()+100, points[0].getY()+100, points[1].getX()+100, points[1].getY()+100);
                    l1.setStroke(Color.PURPLE);
                    l1.setStrokeWidth(5);

                    //Deuxieme ligne a dessiner
                    Line l2 = new Line(points[1].getX()+100, points[1].getY()+100, points[2].getX()+100, points[2].getY()+100);
                    l2.setStroke(Color.PURPLE);
                    l2.setStrokeWidth(5);

                    //Troisieme ligne a dessiner
                    Line l3 = new Line(points[2].getX()+100, points[2].getY()+100, points[3].getX()+100, points[3].getY()+100);
                    l3.setStroke(Color.PURPLE);
                    l3.setStrokeWidth(5);

                    //quatrieme ligne a dessiner
                    Line l4 = new Line(points[3].getX()+100, points[3].getY()+100, points[0].getX()+100, points[0].getY()+100);
                    l4.setStroke(Color.PURPLE);
                    l4.setStrokeWidth(5);


                    //Affiche reellement l'objet. getChildren : liste ces enfants
                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);
                    root.getChildren().add(l4);
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur de coordonnées");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous n'avez pas dessiné un carré, recommencez avec des coordonnées justes");
                    alert.showAndWait();
                }
            }
        });

        MenuItem losangeMenuItem = new MenuItem("Losange"); //Création du sous-menu Losange
        losangeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
                InterPoint[] points = new InterPoint[4];

                String type_point = "";

                ArrayList<String> choices = new ArrayList<>();
                choices.add("Point");
                choices.add("Point2");

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Choix du type de point", choices);
                dialog.setTitle("Choix");
                dialog.setHeaderText("Sélectionnez une option");
                dialog.setContentText("Options :");

                Optional<String> resultat = dialog.showAndWait();

                if (resultat.isPresent()) {
                    type_point = resultat.get();
                } else {
                    System.out.println("Aucune option choisie");
                }

                TextInputDialog coord_point = new TextInputDialog("");
                for (int i = 1; i < 5; i++)
                {
                    coord_point.setTitle("Saisie des coordonnées");
                    coord_point.setHeaderText("Saisie des coordonnées du point " + i);
                    if (type_point.equals("Point"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme x,y :");
                    else if (type_point.equals("Point2"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme angle, rayon :");

                    Optional<String> result = coord_point.showAndWait();

                    if (result.isPresent()){
                        //récupère les variable, transforme les en double et créé un objet point
                        String[] coordonnees = result.get().split(","); //Sépare les coordonnées
                        double x = Double.parseDouble(coordonnees[0]); //Transforme la première coordonnée en double
                        double y = Double.parseDouble(coordonnees[1]); //Transforme la deuxième coordonnée en double
                        points[i - 1] = FabriquePoint.create(type_point, x, y);
                    }
                }

                Losange losange = new Losange(points[0], points[1], points[2], points[3]);

                if (losange.verification()) {
                    //Premiere ligne a dessiner
                    Line l1 = new Line(points[0].getX()+100, points[0].getY()+100, points[1].getX()+100, points[1].getY()+100);
                    l1.setStroke(Color.ORANGE);
                    l1.setStrokeWidth(5);

                    //Deuxieme ligne a dessiner
                    Line l2 = new Line(points[1].getX()+100, points[1].getY()+100, points[2].getX()+100, points[2].getY()+100);
                    l2.setStroke(Color.ORANGE);
                    l2.setStrokeWidth(5);

                    //Troisieme ligne a dessiner
                    Line l3 = new Line(points[2].getX()+100, points[2].getY()+100, points[3].getX()+100, points[3].getY()+100);
                    l3.setStroke(Color.ORANGE);
                    l3.setStrokeWidth(5);

                    //quatrieme ligne a dessiner
                    Line l4 = new Line(points[3].getX()+100, points[3].getY()+100, points[0].getX()+100, points[0].getY()+100);
                    l4.setStroke(Color.ORANGE);
                    l4.setStrokeWidth(5);


                    //Affiche reellement l'objet. getChildren : liste ces enfants
                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);
                    root.getChildren().add(l4);
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur de coordonnées");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous n'avez pas dessiné un carré, recommencez avec des coordonnées justes");
                    alert.showAndWait();
                }
            }
        });


        MenuItem trapèzeMenuItem = new MenuItem("Trapèze"); //Création du sous-menu Trapèze
        trapèzeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Handle the open button event
                InterPoint[] points = new InterPoint[4];

                String type_point = "";

                ArrayList<String> choices = new ArrayList<>();
                choices.add("Point");
                choices.add("Point2");

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Choix du type de point", choices);
                dialog.setTitle("Choix");
                dialog.setHeaderText("Sélectionnez une option");
                dialog.setContentText("Options :");

                Optional<String> resultat = dialog.showAndWait();

                if (resultat.isPresent()) {
                    type_point = resultat.get();
                } else {
                    System.out.println("Aucune option choisie");
                }

                TextInputDialog coord_point = new TextInputDialog("");
                for (int i = 1; i < 5; i++)
                {
                    coord_point.setTitle("Saisie des coordonnées");
                    coord_point.setHeaderText("Saisie des coordonnées du point " + i);
                    if (type_point.equals("Point"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme x,y :");
                    else if (type_point.equals("Point2"))
                        coord_point.setContentText("Entrez les coordonnées sous la forme angle, rayon :");

                    Optional<String> result = coord_point.showAndWait();

                    if (result.isPresent()){
                        //récupère les variable, transforme les en double et créé un objet point
                        String[] coordonnees = result.get().split(","); //Sépare les coordonnées
                        double x = Double.parseDouble(coordonnees[0]); //Transforme la première coordonnée en double
                        double y = Double.parseDouble(coordonnees[1]); //Transforme la deuxième coordonnée en double
                        points[i - 1] = FabriquePoint.create(type_point, x, y);
                    }
                }

                Trapèze t1 = new Trapèze(points[0], points[1], points[2], points[3]);

                if (t1.verification()) {
                    //Premiere ligne a dessiner
                    Line l1 = new Line(points[0].getX()+100, points[0].getY()+100, points[1].getX()+100, points[1].getY()+100);
                    l1.setStroke(Color.GREY);
                    l1.setStrokeWidth(5);

                    //Deuxieme ligne a dessiner
                    Line l2 = new Line(points[1].getX()+100, points[1].getY()+100, points[2].getX()+100, points[2].getY()+100);
                    l2.setStroke(Color.GREY);
                    l2.setStrokeWidth(5);

                    //Troisieme ligne a dessiner
                    Line l3 = new Line(points[2].getX()+100, points[2].getY()+100, points[3].getX()+100, points[3].getY()+100);
                    l3.setStroke(Color.GREY);
                    l3.setStrokeWidth(5);

                    //quatrieme ligne a dessiner
                    Line l4 = new Line(points[3].getX()+100, points[3].getY()+100, points[0].getX()+100, points[0].getY()+100);
                    l4.setStroke(Color.GREY);
                    l4.setStrokeWidth(5);


                    //Affiche reellement l'objet. getChildren : liste ces enfants
                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);
                    root.getChildren().add(l4);
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur de coordonnées");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous n'avez pas dessiné un carré, recommencez avec des coordonnées justes");
                    alert.showAndWait();
                }
            }
        });

        figureMenu.getItems().add(carréMenuItem);
        figureMenu.getItems().add(cerfvolantMenuItem);
        figureMenu.getItems().add(losangeMenuItem);
        figureMenu.getItems().add(parallélogrammeMenuItem);
        figureMenu.getItems().add(rectangleMenuItem);
        figureMenu.getItems().add(trapèzeMenuItem);

        menuBar.getMenus().add(figureMenu);

        root.getChildren().add(menuBar);

        /*---------CRÉATION DU MENU POUR CREER UNE FORME GEOMETRIQUE---------------*/

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("GeoGebra");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {

        launch(args);
    }
}