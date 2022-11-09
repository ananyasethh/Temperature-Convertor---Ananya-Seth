package TranslateAnimation;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

	@FXML public Pane myPane;
	@FXML public Button myButton;
	public void initialize(URL location, ResourceBundle resources)
	{
		Circle circle = new Circle();
		circle.setRadius(20);
		circle.setFill(javafx.scene.paint.Color.BLUE);
		circle.setTranslateX(50); //Move the circle 50 pixel along the positive X-axis
		circle.setTranslateY(50); //Move the circle 75 pixel along the positive Y-axis
		myPane.getChildren().add(circle);
		myButton.setOnAction(event -> {
			startAnimation(circle);
		});
	}

	private void startAnimation(Circle circle)
	{
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), circle);
		//transition.setToY(200);
		transition.setToX(300);
		transition.play();
	}

}
