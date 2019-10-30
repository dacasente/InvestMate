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

import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.shape.Rectangle; 

@SuppressWarnings("restriction")
public class RunInvestMate extends Application {
	
	int InitialHeightScreen = 728, InitialWidthScreen = 1200;
	int StocksInPorfolio = 0;
	int TimesinStartScene = 0, TimesinPersonalInfoScene = 0, TimeinOnboardScene = 0, TimesinMainScene = 0;
	
	// All the Objects in the Program
	Stage window;
	
	//Classes that the program is pulling and storing information in
	User person;
	OwnedStock stocks;
	Portfolio portfolio;
	
	// Global Variables for Personal Information Page
	ComboBox <Integer> AgeSelection;
	TextArea NameBox;
	
	// Global Information for Addstock Method
	ArrayList<ComboBox <String>> NameStock = new ArrayList <ComboBox <String>> ();
	ArrayList<ComboBox <Integer>> AmountQuantity = new ArrayList <ComboBox <Integer>> ();
	ArrayList<ComboBox <String>> DayBought = new ArrayList <ComboBox <String>> ();
	ArrayList<ComboBox <String>> MonthBought = new ArrayList <ComboBox <String>> ();
	ArrayList<ComboBox <String>> YearBought = new ArrayList <ComboBox <String>> ();
	Button AddButton = new Button("Add");
	
	// The different Scenes
	Scene StartScene, PersonalInfoScene, OnBoardScene, MainScene;
	// This is going to correlate with the number of pages
	Group root1 = new Group(), root2 = new Group(), root3 = new Group(), root4 = new Group();
	StackPane root4Pane = new StackPane();
	
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
	
	String MainPageStockTextStyle = "-fx-font: Courier New;"+
		    "-fx-font-family: Courier New;"+
		    "-fx-font-weight: bold;"+
		    "-fx-font-size: 20;"+
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
		PersonalInfo.setLayoutY(50);
		PersonalInfo.setStyle(HeaderTextStyle);
		PersonalInfo.setLayoutX(InitialWidthScreen/2 - 2*PersonalInfo.getLayoutBounds().getWidth());
		
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
		NameBox = new TextArea();
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
		//root2.setAlignment(Pos.Center);
		if (TimesinPersonalInfoScene == 1)
			PersonalInfoScene = new Scene(root2, InitialWidthScreen, InitialHeightScreen);
		window.setScene(PersonalInfoScene);
	}
	
	public void CheckAge() {
		person = new User(NameBox.getText(),AgeSelection.getValue());
		Text PersonalInfo = new Text("you must be at least 18 years or older to use this program");
		// Get user Age
		if (person.getAge() >= 18) {
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
		Onboard.setLayoutX(InitialWidthScreen/2 - 200);
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
			OnBoardScene = new Scene(root3, InitialWidthScreen, InitialHeightScreen);
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
		ComboBox <String> StocksNames = new ComboBox<String>();
		NameStock.add(StocksNames);
		// Add all the Stock Names
		StocksNames.getItems().addAll("select a stock","msft - Microsoft","aapl - Aaple","T - AT&T","vz - Verizon","ms - Morgan Stanley","amd - advanced micro devices");
		StocksNames.setLayoutX(StocksNamesPositionX);
		StocksNames.setLayoutY(StocksNamesPositionY);
		StocksNames.setValue("Select a Stock");
		
		// Quantity Text Parameters
		int QuantityTextPositionX = 350, QuantityTextPositionY = (85 + 80*(StocksInPorfolio-1));
		Text QuantityText = new Text("Amount Purchased");
		QuantityText.setLayoutX(QuantityTextPositionX);
		QuantityText.setLayoutY(QuantityTextPositionY);
		QuantityText.setStyle(StockTextStyle);
		QuantityText.toFront();
		
		// TextBox for Amount of Stocks	
		int QuantityBoxPositionX = 350, QuantityBoxPositionY = (100 + 80*(StocksInPorfolio-1));
		ComboBox <Integer> QuantityBox = new ComboBox<Integer>();
		AmountQuantity.add(QuantityBox);
		for (int j = 1; j <= 1000 ; j++) {
			QuantityBox.getItems().add(j);
		}
		QuantityBox.setLayoutX(QuantityBoxPositionX);
		QuantityBox.setLayoutY(QuantityBoxPositionY);
		QuantityBox.setValue(1);
		
		// Date Text Parameters
		int DatePurchasedTextPositionX = 700, DatePurchasedTextPositionY = (85 + 80*(StocksInPorfolio-1));
		Text DatePurchasedText = new Text("Date Purchased");
		DatePurchasedText.setLayoutX(DatePurchasedTextPositionX);
		DatePurchasedText.setLayoutY(DatePurchasedTextPositionY);
		DatePurchasedText.setStyle(StockTextStyle);
		DatePurchasedText.toFront();
		
		//Delete Stock Button
		int DeleteButtonSizeX = 25,DeleteButtonSizeY = 25,DeleteButtonPositionX = 1100, DeleteButtonPositiony  = (85 + 80*(StocksInPorfolio-1));
		Button Delete = new Button("x");
		Delete.setStyle(BaseStartButtonStyle);
		Delete.setPrefSize(DeleteButtonSizeX, DeleteButtonSizeY);
		Delete.setLayoutX(DeleteButtonPositionX);
		Delete.setLayoutY(DeleteButtonPositiony);
		HoverListener(Delete,BaseStartButtonStyle,HoverStartButtonStyle);
		//Delete.setOnAction(e -> window.setScene(PersonalInfoScene));
		
		// Month
		int MonthPositionX = 700, MonthPositionY = (100 + 80*(StocksInPorfolio-1));
		ComboBox <String> Month = new ComboBox<String>();
		MonthBought.add(Month);
		Month.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
		Month.setLayoutX(MonthPositionX);
		Month.setLayoutY(MonthPositionY);
		Month.setValue("01");
		
		// Day
		int DayPositionX = 800, DayPositionY = (100 + 80*(StocksInPorfolio-1));
		ComboBox <String> Day = new ComboBox<String>();
		DayBought.add(Day);
		for (int j = 1; j <= 31 ; j++) {
			String k;
			if (j < 10)
				k = "0"+j;
			else 
				k = "" + j;
			Day.getItems().add(k);
		}
		Day.setLayoutX(DayPositionX);
		Day.setLayoutY(DayPositionY);
		Day.setValue("01");
		
		// Year
		int YearPositionX = 900, YearPositionY = (100 + 80*(StocksInPorfolio-1));
		ComboBox <String> Year = new ComboBox<String>();
		YearBought.add(Year);
		// Add all the Stock Names
		for (int k = 00; k <= 19 ; k++) {
			String j;
			if (k < 10)
				j = "0"+k;
			else 
				j = "" + k;
			Year.getItems().add(j);
		}
		Year.setLayoutX(YearPositionX);
		Year.setLayoutY(YearPositionY);
		Year.setValue("00");
		
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
		
		root3.getChildren().addAll(rectangle,AddButton, NameText, QuantityText, DatePurchasedText, StocksNames, QuantityBox, Day, Month, Year, Delete);

	}
	
	public void ReloadOnboardPage() {
		
	}
	
	// Make it check everything is correct before making the portfolio
	public void CheckStocks() {
		ArrayList<OwnedStock> Portfolio = new ArrayList<OwnedStock>();
		for (int i = 0; i < NameStock.size(); i++) {
			String date = MonthBought.get(i).getValue() + "/" + DayBought.get(i).getValue() + "/" + YearBought.get(i).getValue();
			OwnedStock stocks = new OwnedStock("",NameStock.get(i).getValue(),AmountQuantity.get(i).getValue(), date);
			Portfolio.add(stocks);
		}
		portfolio = new Portfolio(Portfolio);
		
	}
	
	public void LoadMainPage() {
		TimesinMainScene++;
		
		Text BlanksPortfolio = new Text(person.getName()+"'s Portfolio");
		BlanksPortfolio.setLayoutY(50);
		BlanksPortfolio.setLayoutX(InitialWidthScreen/2 - 200);
		BlanksPortfolio.setStyle(HeaderTextStyle);
		
		int EditPortFolioButtonSizeX = 250,EditPortFolioButtonSizeY = 45,EditPortFolioButtonPositionX = 5, EditPortFolioButtonPositiony  = 5;
		Button EditPortFolio = new Button("Edit Portfolio");
		EditPortFolio.setStyle(BaseStartButtonStyle);
		EditPortFolio.setPrefSize(EditPortFolioButtonSizeX, EditPortFolioButtonSizeY);
		EditPortFolio.setLayoutX(EditPortFolioButtonPositionX);
		EditPortFolio.setLayoutY(EditPortFolioButtonPositiony);
		HoverListener(EditPortFolio,BaseStartButtonStyle,HoverStartButtonStyle);
		EditPortFolio.setOnAction(e -> UnloadCurrentScene(OnBoardScene, root4));
		
		int EditPersonalButtonSizeX = 250,EditPersonalButtonSizeY = 45,EditPersonalButtonPositionX = ((InitialWidthScreen - 5) - EditPersonalButtonSizeX), EditPersonalButtonPositiony  = 5;
		Button EditPersonal = new Button("Edit Personal Info");
		EditPersonal.setStyle(BaseStartButtonStyle);
		EditPersonal.setPrefSize(EditPersonalButtonSizeX, EditPersonalButtonSizeY);
		EditPersonal.setLayoutX(EditPersonalButtonPositionX);
		EditPersonal.setLayoutY(EditPersonalButtonPositiony);
		HoverListener(EditPersonal,BaseStartButtonStyle,HoverStartButtonStyle);
		// remove name text and current stocks if this is pressed
		EditPersonal.setOnAction(e -> UnloadCurrentScene(PersonalInfoScene, root4));
		
		// Change to stocks in portfolio if changing scenes
		for (int i = 0; i < NameStock.size(); i++) {
			// Rectangle Parameters
			int RectangleSizeX = 1150,RectangleSizeY = 75,RectanglePositionX = 25, RectanglePositionY  = (60 + 80*i);		
			Rectangle rectangle = new Rectangle();
			rectangle.setWidth(RectangleSizeX); 
			rectangle.setHeight(RectangleSizeY);
			rectangle.setX(RectanglePositionX); 
			rectangle.setY(RectanglePositionY);  
			rectangle.setArcWidth(30.0); 
			rectangle.setArcHeight(20.0);
			rectangle.toBack();
			
			// Change to get this from the user class and not straight referencing it
			// Stock Name
			int NameTextPositionX = 45, NameTextPositionY = (95 + 80*i);
			Text NameText = new Text("Name: "+NameStock.get(i).getValue());
			NameText.setLayoutX(NameTextPositionX);
			NameText.setLayoutY(NameTextPositionY);
			NameText.setStyle(MainPageStockTextStyle);
			NameText.toFront();
			
			// Change to get this from the user class and not straight referencing it
			// Quantity Text Parameters
			int QuantityTextPositionX = 350, QuantityTextPositionY = (95 + 80*i);
			Text QuantityText = new Text("Quantity Purchased: "+AmountQuantity.get(i).getValue());
			QuantityText.setLayoutX(QuantityTextPositionX);
			QuantityText.setLayoutY(QuantityTextPositionY);
			QuantityText.setStyle(MainPageStockTextStyle);
			QuantityText.toFront();
			
			// Date Text Parameters
			int DatePurchasedTextPositionX = 700, DatePurchasedTextPositionY = (95 + 80*i);
			Text DatePurchasedText = new Text("Date Purchased: "+MonthBought.get(i).getValue()+"/"+DayBought.get(i).getValue()+"/"+YearBought.get(i).getValue());
			DatePurchasedText.setLayoutX(DatePurchasedTextPositionX);
			DatePurchasedText.setLayoutY(DatePurchasedTextPositionY);
			DatePurchasedText.setStyle(MainPageStockTextStyle);
			DatePurchasedText.toFront();
			
			root4.getChildren().addAll(rectangle,NameText,QuantityText,DatePurchasedText);
		}
		
		int SaveButtonSizeX = 150,SaveButtonSizeY = 50,SaveButtonPositionX = 25, SaveButtonPositiony  = (60 + 80*StocksInPorfolio);
		Button Save = new Button("Save Portfolio");
		Save.setStyle(BaseStartButtonStyle);
		Save.setPrefSize(SaveButtonSizeX, SaveButtonSizeY);
		Save.setLayoutX(SaveButtonPositionX);
		Save.setLayoutY(SaveButtonPositiony);
		HoverListener(Save,BaseStartButtonStyle,HoverStartButtonStyle);
		Save.setOnAction(e -> SavePortfolio());
		
		root4.getChildren().addAll(BlanksPortfolio,EditPortFolio,EditPersonal,Save);
		if (TimesinMainScene == 1)
			MainScene = new Scene(root4, InitialWidthScreen, InitialHeightScreen);
		window.setScene(MainScene);
		
		for (int i = 0; i < NameStock.size(); i++) {
			System.out.println("Stock: "+NameStock.get(i).getValue() + " Quantity: "+AmountQuantity.get(i).getValue()+" Date: "+MonthBought.get(i).getValue()+"/"+DayBought.get(i).getValue()+"/"+YearBought.get(i).getValue());
		}
	}

	public void SavePortfolio () {
		if (person.savePortfolio())
			System.out.print("Saved");
		else 
			System.out.print("Not Saved");
	}
	
	public void UnloadCurrentScene(Scene scene, Group root) {
		root.getChildren().clear();
		window.setScene(scene);
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
}
