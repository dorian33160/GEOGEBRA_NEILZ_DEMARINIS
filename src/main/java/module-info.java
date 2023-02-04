module imt.minesales.fr.geogebra_neilz_demarinis {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;

    opens PROJET to javafx.fxml;
    exports PROJET;
}