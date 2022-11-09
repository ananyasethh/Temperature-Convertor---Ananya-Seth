package TemperatureConvertor_Original;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Temperature extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("temp.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}

	private MenuBar createMenu()
	{
		//File Menu
		Menu fileMenu = new Menu("File");
		SeparatorMenuItem separateItem = new SeparatorMenuItem();
		MenuItem newMenu = new MenuItem("New");
		newMenu.setOnAction(event -> System.out.println("New Menu Item Clicked")); //lambda expression
		MenuItem exitMenu = new MenuItem("Exit");
		exitMenu.setOnAction(event -> {
			Platform.exit(); //shut down application
			System.exit(0);  //to shut down current virtual machine
		});
		fileMenu.getItems().addAll(newMenu,separateItem, exitMenu);
		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About App");

		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);
		//MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp()
	{
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Temperature Convertor");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner");
		alertDialog.show();
	}
}
