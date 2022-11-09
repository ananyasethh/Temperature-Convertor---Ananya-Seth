package TemperatureConvertor_Original;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	@FXML public Label welcomeLabel;
	@FXML public ChoiceBox<String> choicebox;
	@FXML public TextField textfield;
	@FXML public Button convertBtn;
	private static final String C ="Choose";
	private static final String C_TO_F ="Celsius to Fahrenheit";
	private boolean isC_TO_F= true;
	@Override
	public void initialize(URL location, ResourceBundle resources)  //entry point of controller
	{
		convertBtn.setOnAction(event -> {
			convert();
		});
		choicebox.getItems().add(C);
		choicebox.getItems().add("Celsius to Fahrenheit");
		choicebox.getItems().add("Fahrenheit to Celsius");
		choicebox.setValue(C);
		choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(C_TO_F))
			{
				isC_TO_F = true;
			}
			else
			{
				isC_TO_F =false;
			}
		});

	}

	private void convert()
	{
		String input = textfield.getText();  //extracting text from textfield
		float enteredTemperature=0.0f;
		try
		{
			enteredTemperature = Float.parseFloat(input);
		}
		catch(Exception e)
		{
			warnUser();
			return;
		}
		float newTemperature=0.0f;
		if(isC_TO_F)
		{
			newTemperature= (enteredTemperature * 9/5)+32;  //if user selected Celsius to Fahrenheit
		}
		else
		{
			newTemperature=(enteredTemperature-32)*5/9;  //if user selected Fahrenheit to Celsius
		}
		display(newTemperature);
	}

	private void warnUser()
	{
		Alert alertDialog = new Alert(Alert.AlertType.ERROR);
		alertDialog.setTitle("Error Occurred");
		alertDialog.setHeaderText("Invalid Temperature Entered");
		alertDialog.setContentText("Please enter a valid temperature.");
		alertDialog.show();
	}

	private void display(float newTemperature)
	{
		String unit = isC_TO_F? "F" : "C";
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Result");
		alertDialog.setContentText("The new temperature is :" +newTemperature +unit);
		alertDialog.show();
	}
}
