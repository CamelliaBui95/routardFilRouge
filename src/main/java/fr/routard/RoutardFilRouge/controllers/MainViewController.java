package fr.routard.RoutardFilRouge.controllers;

import fr.routard.RoutardFilRouge.MainApp;
import fr.routard.RoutardFilRouge.metier.Country;
import fr.routard.RoutardFilRouge.service.CountryBean;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainViewController {
    @FXML
    private TableView<Country> countryTableView;
    @FXML
    private TableColumn<Country, String> countryCodeCol;
    @FXML
    private TableColumn<Country, String> countryNameCol;
    @FXML
    private TableColumn<Country, String> continentNameCol;
    private CountryBean countryBean;
    private MainApp mainApp;

    @FXML
    private void initialize() {
        countryCodeCol.setCellValueFactory(cell -> cell.getValue().isoCodeProperty());
        countryNameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        continentNameCol.setCellValueFactory(cell -> cell.getValue().getContinent().nameProperty());
    }

    public void setCountryBean(CountryBean countryBean) {
        this.countryBean = countryBean;
        SortedList<Country> sortedCountries = this.countryBean.getSortedCountries();
        sortedCountries.comparatorProperty().bind(countryTableView.comparatorProperty());
        countryTableView.setItems(sortedCountries);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}