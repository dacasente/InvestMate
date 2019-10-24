import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.*; // Scene, Group, Node, etc.
import javafx.scene.text.*; // Text, Font
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.geometry.*; // Pos, Insets

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.shape.Rectangle; 

@SuppressWarnings("restriction")
public class UserInterface extends Application {
	
	// Get these to be updated every time there is a resize
	
	int InitialHeightScreen = 728, InitialWidthScreen = 1200;
	// Might not need this but could help with resize listener
	double CurrentHeightScreen = InitialHeightScreen, CurrentWidthScreen = InitialWidthScreen;
	int StocksInPorfolio = 0;
	int TimesinStartScene = 0, TimesinPersonalInfoScene = 0, TimeinOnboardScene = 0, TimesinMainScene = 0;
	
	// Get a better way of doing this but right now its good (User Class)
	ComboBox <Integer> AgeSelection;
	
	// All the Objects in the Program
	Stage window;
	
	// Global Variables for the Onboard Scene
	List<String> NamesStock = new ArrayList<String> ();
	
	// The different Scenes
	Scene StartScene, PersonalInfoScene, OnBoardScene, MainScene;
	Button AddButton = new Button("Add");
	// This is going to correlate with the number of pages
	Group root1 = new Group(), root2 = new Group(), root3 = new Group(), root4 = new Group();
	// All the images
	Image StartImage = new Image("File:StartScreen.jpeg");
	ImageView Startimg = new ImageView(StartImage); 
	
	String BaseStartButtonStyle ="-fx-text-fill: aquamarine;"+
		    "-fx-background-color: black;"+
		    "-fx-font: Courier New;"+
		    "-fx-font-family: Courier New;"+
		    "-fx-font-weight: bold;"+
		    "-fx-font-size: 20;";
	
	String HoverStartButtonStyle = "-fx-text-fill: white;"+
		    "-fx-background-color: gray;"+
		    "-fx-font: Courier New;"+
		    "-fx-font-family: Courier New;"+
		    "-fx-font-weight: bold;"+
		    "-fx-font-size: 20;";
	
	String HeaderTextStyle = "-fx-font: Courier New;"+
		    "-fx-font-family: Courier New;"+
		    "-fx-font-weight: bold;"+
		    "-fx-font-size: 40;";
	
	String StockTextStyle = "-fx-font: Courier New;"+
		    "-fx-font-family: Courier New;"+
		    "-fx-font-weight: bold;"+
		    "-fx-font-size: 25;"+
		    "-fx-stroke: white";
	
	String ErrorTextStyle = "-fx-font: Courier New;"+
		    "-fx-font-family: Courier New;"+
		    "-fx-font-size: 15;"+
		    "-fx-stroke: red";
	
	String BaseAddButtonStyle ="-fx-text-fill: black;"+
		    "-fx-background-color: white;"+
		    "-fx-font: Courier New;"+
		    "-fx-font-family: Courier New;"+
		    "-fx-font-weight: bold;"+
		    "-fx-font-size: 20;";
	
	String HoverAddButtonStyle = "-fx-text-fill: white;"+
		    "-fx-background-color: gray;"+
		    "-fx-font: Courier New;"+
		    "-fx-font-family: Courier New;"+
		    "-fx-font-weight: bold;"+
		    "-fx-font-size: 20;";
	
	public static void main (String args[]) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("Stock Advisor");
		// Change to true once you figure it out
		window.setResizable(false);
		LoadStartPage();
		window.show();
		
	}
	
	public void LoadStartPage() {
		TimesinStartScene++;
		
		// StartButton
		double StartButtonSizeX = 500,StartButtonSizeY = 75,StartButtonPositionX = 600, StartButtonPositionY  = 500;
		Button StartButton = new Button();
		StartButton = new Button("I would like help with my portfolio");
		StartButton.setPrefSize(StartButtonSizeX,StartButtonSizeY);
		StartButton.setLayoutX(StartButtonPositionX);
		StartButton.setLayoutY(StartButtonPositionY);
		StartButton.setStyle(BaseStartButtonStyle);
		StartButton.setOnAction(e -> LoadPersonalInfoPage());
		//ResizeListener(window);
		HoverListener(StartButton,BaseStartButtonStyle, HoverStartButtonStyle);
		
		// Adding the image and the start button to the group/scene
		root1.getChildren().addAll(Startimg, StartButton);
		if (TimesinStartScene == 1) 
			StartScene = new Scene(root1,InitialWidthScreen,InitialHeightScreen);
		
		window.setScene(StartScene);
	}
	
	public void LoadPersonalInfoPage() {
		TimesinPersonalInfoScene++;
		
		// Page Header
		Text PersonalInfo = new Text("Personal Info");
		PersonalInfo.setLayoutX(CurrentWidthScreen/2 - 175);
		PersonalInfo.setLayoutY(50);
		PersonalInfo.setStyle(HeaderTextStyle);
		
		// Back Button
		int backButtonSizeX = 100,backButtonSizeY = 45,BackButtonPositionX = 5, BackButtonPositiony  = 5;
		Button back = new Button("Back");
		back.setStyle(BaseStartButtonStyle);
		back.setPrefSize(backButtonSizeX, backButtonSizeY);
		back.setLayoutX(BackButtonPositionX);
		back.setLayoutY(BackButtonPositiony);
		HoverListener(back,BaseStartButtonStyle,HoverStartButtonStyle);
		back.setOnAction(e -> window.setScene(StartScene));
		
		// Continue Button
		int ContinueButtonSizeX = 150,ContinueButtonSizeY = 45,ContinueButtonPositionX = ((InitialWidthScreen - 5) - ContinueButtonSizeX), ContinueButtonPositiony  = 5;
		Button Continue = new Button("Continue");
		Continue.setStyle(BaseStartButtonStyle);
		Continue.setPrefSize(ContinueButtonSizeX, ContinueButtonSizeY);
		Continue.setLayoutX(ContinueButtonPositionX);
		Continue.setLayoutY(ContinueButtonPositiony);
		HoverListener(Continue,BaseStartButtonStyle,HoverStartButtonStyle);
		Continue.setOnAction(e -> CheckAge());
		
		// Name Prompt
		Text NamePrompt = new Text("Please enter your name: ");
		NamePrompt.setLayoutX(200);
		NamePrompt.setLayoutY(200);
		NamePrompt.setStyle(StockTextStyle);
		
		// TextBox for Amount of Stocks	
		int NameBoxPositionX = 550, NameBoxPositionY = 170, NameBoxSizeX = 200, NameBoxSizeY = 50;
		TextArea NameBox = new TextArea();
		NameBox.setLayoutX(NameBoxPositionX);
		NameBox.setLayoutY(NameBoxPositionY);
		NameBox.setPrefSize(NameBoxSizeX, NameBoxSizeY);
		
		// Age Prompt
		Text AgePrompt = new Text("Please enter your Age: ");
		AgePrompt.setLayoutX(200);
		AgePrompt.setLayoutY(400);
		AgePrompt.setStyle(StockTextStyle);
		
		// TextBox for Age
		// Stock Searcher
		int StocksNamesPositionX = 550, StocksNamesPositionY = 370;
		AgeSelection = new ComboBox<Integer>();
		// Add all the Stock Names
		for (int i = 1; i < 120; i++) {
			AgeSelection.getItems().add(i);
		}
		AgeSelection.setLayoutX(StocksNamesPositionX);
		AgeSelection.setLayoutY(StocksNamesPositionY);
		AgeSelection.setValue(1);
		
		root2.getChildren().addAll(PersonalInfo,back,Continue, NamePrompt, NameBox, AgePrompt, AgeSelection);
		if (TimesinPersonalInfoScene == 1)
			PersonalInfoScene = new Scene(root2, CurrentWidthScreen, CurrentHeightScreen);
		window.setScene(PersonalInfoScene);
	}
	
	public void CheckAge() {
		Text PersonalInfo = new Text("you must be at least 18 years or older to use this program");
		// Get user Age
		if (AgeSelection.getValue() >= 18) {
			root2.getChildren().remove(PersonalInfo);
			LoadOnboardPage();
		}
		else {
			PersonalInfo.setLayoutX(200);
			PersonalInfo.setLayoutY(300);
			PersonalInfo.setStyle(ErrorTextStyle);
			root2.getChildren().addAll(PersonalInfo);
		}
	}
	
	public void LoadOnboardPage() {
		TimeinOnboardScene++;
		
		// Onboard Text
		Text Onboard = new Text("Onboard Portfolio");
		Onboard.setLayoutX(CurrentWidthScreen/2 - 200);
		Onboard.setLayoutY(50);
		Onboard.setStyle(HeaderTextStyle);
		
		int backButtonSizeX = 100,backButtonSizeY = 45,BackButtonPositionX = 5, BackButtonPositiony  = 5;
		Button back = new Button("Back");
		back.setStyle(BaseStartButtonStyle);
		back.setPrefSize(backButtonSizeX, backButtonSizeY);
		back.setLayoutX(BackButtonPositionX);
		back.setLayoutY(BackButtonPositiony);
		HoverListener(back,BaseStartButtonStyle,HoverStartButtonStyle);
		back.setOnAction(e -> window.setScene(PersonalInfoScene));
		
		int ContinueButtonSizeX = 150,ContinueButtonSizeY = 45,ContinueButtonPositionX = ((InitialWidthScreen - 5) - ContinueButtonSizeX), ContinueButtonPositiony  = 5;
		Button Continue = new Button("Continue");
		Continue.setStyle(BaseStartButtonStyle);
		Continue.setPrefSize(ContinueButtonSizeX, ContinueButtonSizeY);
		Continue.setLayoutX(ContinueButtonPositionX);
		Continue.setLayoutY(ContinueButtonPositiony);
		HoverListener(Continue,BaseStartButtonStyle,HoverStartButtonStyle);
		Continue.setOnAction(e -> LoadMainPage());
		
		AddAnotherStock();
		
		root3.getChildren().addAll(Onboard, back, Continue);
		if (TimeinOnboardScene == 1)
			OnBoardScene = new Scene(root3, CurrentWidthScreen, CurrentHeightScreen);
		window.setScene(OnBoardScene);
	}
	
	public void AddAnotherStock() {
		
		StocksInPorfolio++;
		
		// Rectangle Parameters
		int RectangleSizeX = 1150,RectangleSizeY = 75,RectanglePositionX = 25, RectanglePositionY  = (60 + 80*(StocksInPorfolio-1));		
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(RectangleSizeX); 
		rectangle.setHeight(RectangleSizeY);
		rectangle.setX(RectanglePositionX); 
		rectangle.setY(RectanglePositionY);  
		rectangle.setArcWidth(30.0); 
		rectangle.setArcHeight(20.0);
		rectangle.toBack();
		
		// Name Text Parameters
		int NameTextPositionX = 45, NameTextPositionY = (85 + 80*(StocksInPorfolio-1));
		Text NameText = new Text("Stock Name");
		NameText.setLayoutX(NameTextPositionX);
		NameText.setLayoutY(NameTextPositionY);
		NameText.setStyle(StockTextStyle);
		NameText.toFront();
		
		// Stock Searcher
		int StocksNamesPositionX = 45, StocksNamesPositionY = (100 + 80*(StocksInPorfolio-1));
		ComboBox <String> StocksNames;
		StocksNames = new ComboBox<String>();
		// Add all the Stock Names
		StocksNames.getItems().addAll("Select a Stock","2","3","4","5","6","7");
		StocksNames.setLayoutX(StocksNamesPositionX);
		StocksNames.setLayoutY(StocksNamesPositionY);
		StocksNames.setValue("Select a Stock");
		
		// Name Text Parameters
		int QuantityTextPositionX = 350, QuantityTextPositionY = (85 + 80*(StocksInPorfolio-1));
		Text QuantityText = new Text("Amount Purchased");
		QuantityText.setLayoutX(QuantityTextPositionX);
		QuantityText.setLayoutY(QuantityTextPositionY);
		QuantityText.setStyle(StockTextStyle);
		QuantityText.toFront();
		
		// TextBox for Amount of Stocks	
		int QuantityBoxPositionX = 350, QuantityBoxPositionY = (100 + 80*(StocksInPorfolio-1)), QuantityBoxSizeX = 150, QuantityBoxSizeY = 15;
		TextArea QuantityBox = new TextArea();
		QuantityBox.setLayoutX(QuantityBoxPositionX);
		QuantityBox.setLayoutY(QuantityBoxPositionY);
		QuantityBox.setPrefSize(QuantityBoxSizeX, QuantityBoxSizeY);
		
		// Name Text Parameters
		int DatePurchasedTextPositionX = 700, DatePurchasedTextPositionY = (85 + 80*(StocksInPorfolio-1));
		Text DatePurchasedText = new Text("Date Purchased");
		DatePurchasedText.setLayoutX(DatePurchasedTextPositionX);
		DatePurchasedText.setLayoutY(DatePurchasedTextPositionY);
		DatePurchasedText.setStyle(StockTextStyle);
		DatePurchasedText.toFront();
		
		// Remove Previous button
		if (StocksInPorfolio > 1) {
			root3.getChildren().remove(AddButton);
		}
		
		// adds next button
		int ButtonSizeX = 1150,ButtonSizeY = 40,ButtonPositionX = 25, ButtonPositionY  = (135 + 80*(StocksInPorfolio-1));
		AddButton.setPrefSize(ButtonSizeX, ButtonSizeY);
		AddButton.setLayoutX(ButtonPositionX);
		AddButton.setLayoutY(ButtonPositionY);
		AddButton.setStyle(BaseAddButtonStyle);
		HoverListener(AddButton,BaseAddButtonStyle,HoverAddButtonStyle);
		AddButton.setOnAction(e -> AddAnotherStock());
		
		root3.getChildren().addAll(rectangle,AddButton, NameText, QuantityText, DatePurchasedText, StocksNames, QuantityBox);

	}
	
	public void LoadMainPage() {
		TimesinMainScene++;
		
		root4.getChildren().addAll();
		if (TimesinMainScene == 1)
			MainScene = new Scene(root4, CurrentWidthScreen, CurrentHeightScreen);
		window.setScene(MainScene);
	}

	public void HoverListener(Button button, String BaseStyle, String HoverStyle) {
		button.hoverProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				button.setStyle(HoverStyle);
			} else {
				button.setStyle(BaseStyle);
			}
		});
	}
	
	// Figure out how to implement a resize listener
	public void ResizeListener(Stage window) {
		this.window.widthProperty().addListener((obs, oldVal, newVal) -> {
		     // Do whatever you want
		});

		this.window.heightProperty().addListener((obs, oldVal, newVal) -> {
		     // Do whatever you want
		});
	}
	
	public void setCurrentWidth() {
		CurrentHeightScreen = window.getHeight();
	}
	
	public void setCurrentHeight() {
		CurrentWidthScreen = window.getWidth();
	}
}

