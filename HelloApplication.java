package com.zeaxerr.sqlite;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class HelloApplication extends Application {

    private Connection establishConnection() {
        String dbUrl = "jdbc:mysql://localhost:3306/db_amid";
        String dbUser = "root";
        String dbPassword = "";
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dbConnection;
    }

    private TableView<String[]> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("java i jdbc");

        MenuBar menuBar = new MenuBar();
        Menu optionsMenu = new Menu("Ustawienia");
        MenuItem createTableMenuItem = new MenuItem("Stwórz tabelke");
        MenuItem addRecordMenuItem = new MenuItem("Dodaj rekordy");
        MenuItem searchRecordMenuItem = new MenuItem("Szukaj rekordy");
        MenuItem exitMenuItem = new MenuItem("Wyjdź");
        optionsMenu.getItems().addAll(createTableMenuItem, addRecordMenuItem, searchRecordMenuItem, new SeparatorMenuItem(), exitMenuItem);
        menuBar.getMenus().add(optionsMenu);

        createTableMenuItem.setOnAction(event -> displayCreateTableForm());
        addRecordMenuItem.setOnAction(event -> displayAddRecordForm());
        searchRecordMenuItem.setOnAction(event -> displaySearchRecordForm());
        exitMenuItem.setOnAction(event -> primaryStage.close());

        GridPane rootLayout = new GridPane();
        rootLayout.setPadding(new Insets(10, 10, 10, 10));
        rootLayout.setVgap(8);
        rootLayout.setHgap(10);
        rootLayout.getChildren().add(menuBar);

        primaryStage.setScene(new Scene(rootLayout, 300, 300));
        primaryStage.show();
    }

    private void displayCreateTableForm() {
        Stage createTableStage = new Stage();
        createTableStage.setTitle("Stwórz tabelke");

        GridPane createTableLayout = new GridPane();
        createTableLayout.setPadding(new Insets(10, 10, 10, 10));
        createTableLayout.setVgap(8);
        createTableLayout.setHgap(10);

        createTableLayout.add(new Label("Nazwa tabelki:"), 0, 0);
        TextField tableNameField = new TextField();
        createTableLayout.add(tableNameField, 1, 0);

        createTableLayout.add(new Label("Kolumnt:"), 0, 1);
        TextArea columnsTextArea = new TextArea();
        columnsTextArea.setPromptText("Kolumna1 VARCHAR(255) PRIMARY KEY,\nKolumna2 INT AUTO_INCREMENT,\nKolumna3 DATE");
        createTableLayout.add(columnsTextArea, 1, 1);

        Button createTableButton = new Button("Stwórz tabelke");
        createTableLayout.add(createTableButton, 1, 2);

        Button backButton = new Button("Wróć");
        createTableLayout.add(backButton, 0, 2);

        backButton.setOnAction(event -> createTableStage.close());

        createTableButton.setOnAction(event -> {
            String tableName = tableNameField.getText();
            String columnsDefinition = columnsTextArea.getText();
            createTable(tableName, columnsDefinition);
        });

        Label instructionsLabel = new Label("Format kolumny: Name Data_Type [PRIMARY KEY] [AUTO_INCREMENT], Column2 INT AUTO_INCREMENT, Column3 DATE");
        Label instructionsLabel2 = new Label("JAK UŻYWAĆ: To use AUTO_INCREMENT, both PRIMARY KEY and AUTO_INCREMENT must be specified.");
        instructionsLabel.setWrapText(true);
        instructionsLabel2.setWrapText(true);
        createTableLayout.add(instructionsLabel, 1, 3);
        createTableLayout.add(instructionsLabel2, 1, 4);

        Scene createTableScene = new Scene(createTableLayout, 800, 300);
        createTableStage.setScene(createTableScene);
        createTableStage.show();
    }

    private void displayAddRecordForm() {
        Stage addRecordStage = new Stage();
        addRecordStage.setTitle("Dodaj wiersze/kolumny");

        GridPane addRecordLayout = new GridPane();
        addRecordLayout.setPadding(new Insets(10, 10, 10, 10));
        addRecordLayout.setVgap(8);
        addRecordLayout.setHgap(10);

        addRecordLayout.add(new Label("Nazwa tabelki:"), 0, 0);
        TextField tableNameField = new TextField();
        addRecordLayout.add(tableNameField, 1, 0);

        addRecordLayout.add(new Label("Nazwa kolumny:"), 0, 1);
        TextField columnNameField = new TextField();
        addRecordLayout.add(columnNameField, 1, 1);

        Button addButton = new Button("Dodaj rekord");
        addRecordLayout.add(addButton, 1, 2);

        Button backButton = new Button("WRÓĆ");
        addRecordLayout.add(backButton, 0, 2);

        backButton.setOnAction(event -> addRecordStage.close());

        addButton.setOnAction(event -> {
            String tableName = tableNameField.getText();
            String columnName = columnNameField.getText();
            addRecord(tableName, columnName);
        });

        Scene addRecordScene = new Scene(addRecordLayout, 300, 300);
        addRecordStage.setScene(addRecordScene);
        addRecordStage.show();
    }

    private void displaySearchRecordForm() {
        Stage searchRecordStage = new Stage();
        searchRecordStage.setTitle("Szukaj rekordy");

        GridPane searchRecordLayout = new GridPane();
        searchRecordLayout.setPadding(new Insets(10, 10, 10, 10));
        searchRecordLayout.setVgap(8);
        searchRecordLayout.setHgap(10);

        searchRecordLayout.add(new Label("Nazwa tabelki:"), 0, 0);
        TextField tableNameField = new TextField();
        searchRecordLayout.add(tableNameField, 1, 0);

        searchRecordLayout.add(new Label("Nazwa kolumntyy:"), 0, 1);
        TextField columnNameField = new TextField();
        searchRecordLayout.add(columnNameField, 1, 1);

        searchRecordLayout.add(new Label("Szukana treść:"), 0, 2);
        TextField searchValueField = new TextField();
        searchRecordLayout.add(searchValueField, 1, 2);

        Button searchButton = new Button("Szukaj");
        searchRecordLayout.add(searchButton, 1, 3);

        Button backButton = new Button("WRÓĆ");
        searchRecordLayout.add(backButton, 0, 3);

        backButton.setOnAction(event -> searchRecordStage.close());

        searchButton.setOnAction(event -> {
            String tableName = tableNameField.getText();
            String columnName = columnNameField.getText();
            String searchValue = searchValueField.getText();
            searchRecord(tableName, columnName, searchValue);
        });

        searchRecordLayout.add(tableView, 0, 4, 2, 1);

        Scene searchRecordScene = new Scene(searchRecordLayout, 300, 300);
        searchRecordStage.setScene(searchRecordScene);
        searchRecordStage.show();
    }

    private void createTable(String tableName, String columnsDefinition) {
        try (Connection dbConnection = establishConnection()) {
            if (dbConnection != null) {
                Statement statement = dbConnection.createStatement();
                String sqlQuery = "CREATE TABLE " + tableName + " (" + columnsDefinition + ")";
                statement.executeUpdate(sqlQuery);
                dbConnection.close();
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Utworzenie tabelki: SUKCES");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Tabelka " + tableName + "została pomyślnie utworzona");
                successAlert.showAndWait();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Wystąpił problem podczas tworzenia tabelki.");
            errorAlert.showAndWait();
        }
    }

    private void addRecord(String tableName, String columnName) {
        try (Connection dbConnection = establishConnection()) {
            if (dbConnection != null) {
                String sqlQuery = "INSERT INTO " + tableName + " (" + columnName + ") VALUES (?)";
                PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery);
                TextInputDialog inputDialog = new TextInputDialog();
                inputDialog.setTitle("Dodaj rekord");
                inputDialog.setHeaderText("Dodaj rekord do tabeli: " + tableName);
                inputDialog.setContentText("Wpisz treść do kolumny " + columnName + ":");
                inputDialog.showAndWait().ifPresent(value -> {
                    try {
                        preparedStatement.setString(1, value);
                        preparedStatement.executeUpdate();
                        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                        successAlert.setTitle("Dodanie rekordu: SUKCES");
                        successAlert.setHeaderText(null);
                        successAlert.setContentText("Rekord został pomyślmnie dodany do tabelki: " + tableName);
                        successAlert.showAndWait();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setTitle("Error");
                        errorAlert.setHeaderText(null);
                        errorAlert.setContentText("Wystąpił problem podczas dodawania rekordu.");
                        errorAlert.showAndWait();
                    }
                });
                dbConnection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Wystąpił problem podczas dodawania rekordu.");
            errorAlert.showAndWait();
        }
    }

    private void searchRecord(String tableName, String columnName, String searchValue) {
        try (Connection dbConnection = establishConnection()) {
            if (dbConnection != null) {
                String sqlQuery = "SELECT * FROM " + tableName + " WHERE " + columnName + " = ?";
                PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, searchValue);
                ResultSet resultSet = preparedStatement.executeQuery();

                tableView.getColumns().clear();
                tableView.getItems().clear();
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    final int colIndex = i;
                    TableColumn<String[], String> column = new TableColumn<>(resultSet.getMetaData().getColumnName(i + 1));
                    column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[colIndex]));
                    tableView.getColumns().add(column);
                }

                while (resultSet.next()) {
                    String[] row = new String[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = resultSet.getString(i + 1);
                    }
                    tableView.getItems().add(row);
                }
                dbConnection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Wystąpił problem podczas szuakania rekordu.");
            errorAlert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
