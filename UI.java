import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
// Pos, Insets
import javafx.geometry.Pos;
// Scene, Group, Node, etc.
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
// Text, Font
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;
import javafx.collections.ObservableList;

@SuppressWarnings("restriction")
public class UI extends Application {
	// Nothing Will Go in Here So that the 
	public void start(Stage primaryStage) throws Exception {
			/*
			window = primaryStage;
			window.setTitle("Stock Advisor");
			// Change to true once you figure it out
			window.setResizable(false);
			LoadStartPage();
			window.show();
			*/
		}
	
	int InitialHeightScreen = 728, InitialWidthScreen = 1200;
	int StocksInPorfolio = 0;
	int TimesinStartScene = 0, TimesinPersonalInfoScene = 0, TimeinOnboardScene = 0, TimesinMainScene = 0, TimesinSpecificStockScene = 0, TimeinIndividualStockAssesmentOnboardScene = 0, TimesinIndividualStockAssesmentScene = 0;
	
	// All the Objects in the Program
	Stage window;
	
	// Objects
	User person;
	OwnedStock stocks;
	Portfolio portfolio;
	StockImporter stockimporter;
	LearningTool learningtool;
	//Tesla
	double[] price = {331.93,336.34,333.04,354.83,352.22,359.52,349.99,352.17,349.35,346.11,349.93,345.09,337.14,335.54,326.58,317.22,317.47,313.31,314.92,315.01,316.22,327.71,328.13,299.68,254.68,255.58,253.5,256.95,261.97,259.75,257.89,256.96,247.89,244.74,244.53,240.05,237.72,231.43,233.03,243.13,244.69,240.87,242.13,242.56,228.7,223.21,241.23,240.62,246.6,243.49,244.79,242.81,245.2,245.87,247.1,235.54,231.79,227.45,229.58,220.68,225.01,225.61,221.71,215.59,214.08,215,211.4,222.15,220.83,225.86,226.83,219.94,215.64,219.62,235,229.01,235.01,238.3,233.42,230.75,228.32,234.34,233.85,241.61,242.26,235.77,228.04,228.82,264.88,260.17,255.68,258.18,253.54,254.86,252.38,253.5,245.08,238.6,238.92,230.06,230.34,233.1,234.9,224.55,227.17,223.46,222.84,219.27,219.76,223.64,221.86,219.62,226.43,224.74,225.03,214.92,213.91,209.26,217.1,212.88,204.5,205.95,196.59,193.6,178.97,185.16,188.22,189.86,188.7,190.63,195.49,192.73,205.08,205.36,211.03,228.33,231.95,232.31,227.01,239.52,241.98};
	double eps = .78;
	
	//apple
	//double[] price = {266.18,266.37,261.78,262.01,263.19,266.29,267.1,265.76,262.64,264.47,261.96,262.2,260.14,259.43,257.24,257.13,257.5,255.82,248.76,243.26,243.29,249.05,246.58,243.58,243.18,239.96,240.51,236.41,235.28,234.37,235.32,235.87,236.21,230.09,227.03,224.4,227.06,227.01,220.82,218.96,224.59,223.97,218.82,219.89,221.03,217.68,218.72,217.73,220.96,222.77,220.7,219.9,218.75,223.09,223.59,216.7,214.17,213.26,213.28,209.19,205.7,208.74,209.01,205.53,204.16,206.49,202.64,212.46,212.64,210.36,210.35,206.5,201.74,202.75,208.97,200.48,200.99,203.43,199.04,197,193.34,204.02,208.43,213.04,208.78,209.68,207.74,207.02,208.67,208.84,207.22,202.59,205.66,203.35,204.5,205.21,203.3,201.75,203.23,201.24,200.02,204.23,204.41,202.73,201.55,197.92,199.74,199.8,195.57,198.58,198.78,199.46,197.87,198.45,193.89,192.74,194.15,194.19,194.81,192.58,190.15,185.22,182.54,179.64,173.3,175.07,178.3,177.38,178.23,178.97,179.66,182.78,186.6,183.09,189,190.08,190.92,188.66,185.72,197.18,200.72};
	//double eps =11.89;
	LearningTool apple = new LearningTool("3 month",price,eps);
	
	// Global Information for Addstock Method (get rid of for next demo)
	ArrayList<ComboBox <String>> NameStock = new ArrayList <ComboBox <String>> ();
	ArrayList<ComboBox <String>> AmountQuantity = new ArrayList <ComboBox <String>> ();
	ArrayList<ComboBox <String>> DayBought = new ArrayList <ComboBox <String>> ();
	ArrayList<ComboBox <String>> MonthBought = new ArrayList <ComboBox <String>> ();
	ArrayList<ComboBox <String>> YearBought = new ArrayList <ComboBox <String>> ();
	Button AddButton = new Button("Add");
	
	// The different Scenes
	Scene StartScene, PersonalInfoScene, OnBoardScene, MainScene, SpecificStockScene, IndividualStockAssesmentOnboardScene, IndividualStockAssesmentScene;
	// This is going to correlate with the number of pages
	Group root3 = new Group(), root4 = new Group();
	StackPane root4Pane = new StackPane();
	
	
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
	
	public void Begin(Stage primaryStage){
		window = primaryStage;
		window.setTitle("Stock Advisor");
		// Change to true once you figure it out
		window.setResizable(true);
		LoadStartPage();
		window.show();
	}
	
	public void LoadStartPage() {
		// Things To Do
		// Add The Logo To the Page 
		// Make a Min size for window
		// Make cool button hover over
		
		String MainTextStyle = "-fx-font: Times New Roman;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 100;";
		
		String SubTextStyle = "-fx-font: Courier New;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 25;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
			    "-fx-background-color: black;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 40;";
		
		String HoverButtonStyle = "-fx-text-fill: white;"+
			    "-fx-background-color: gray;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 40;";
		
		// Counts the Number of times the User Enters the First Scene
		TimesinStartScene++;
		
		VBox root1 = new VBox();
		
		//Main Text
		Text StartText = new Text("InvestMate");
		StartText.setStyle(MainTextStyle);
		
		Text SubText = new Text("- For All Your Personal Investing Needs");
		SubText.setStyle(SubTextStyle);
		
		// StartButton
		double StartButtonSizeX = 750,StartButtonSizeY = 100;
		Button StartButton = new Button();
		StartButton = new Button("Lets Begin");
		StartButton.setPrefSize(StartButtonSizeX,StartButtonSizeY);
		StartButton.setStyle(BaseButtonStyle);
		StartButton.setOnAction(e -> LoadPersonalInfoPage());
		HoverListener(StartButton,BaseButtonStyle, HoverButtonStyle);
		
		root1.setAlignment(Pos.CENTER);
		root1.setSpacing(25);
		
		// Adding the image and the start button to the group/scene
		root1.setStyle("-fx-background-color: black");
		root1.getChildren().addAll(StartText, SubText, StartButton);
		if (TimesinStartScene == 1) 
			StartScene = new Scene(root1,InitialWidthScreen,InitialHeightScreen);
		
		window.setScene(StartScene);
	}
		
	public void LoadPersonalInfoPage() {
		// Things to do
		// Add searchbox drop down
		// Make Min Size for window
		// Make size of window not change between scene transitions
		// Make the message that Personal Info a pop up
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
			    "-fx-background-color: black;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: white;"+
			    "-fx-background-color: gray;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;"+
			    "-fx-spacing: 20";
		
		String TextStyle = "-fx-font: Times New Roman;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 30;";
		
		String PageStyle = "-fx-padding: 10;"+
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;";
		
		String CenterStyle = "-fx-padding: 20;"+
                "-fx-border-width: 4;" +
                "-fx-border-insets: 5;";
		
		// OverArching
		BorderPane root2 = new BorderPane();
		// Sub Panes
		BorderPane SubrootTop = new BorderPane();
		BorderPane SubrootCenterPane = new BorderPane();
		VBox LeftCenter = new VBox(35);
		VBox RightCenter = new VBox(10);
		
		TimesinPersonalInfoScene++;
		
		// Name Prompt
		Text NamePrompt = new Text("Please enter your name: ");
		NamePrompt.setStyle(StockTextStyle);
		LeftCenter.getChildren().add(NamePrompt);
		
		// TextBox for Amount of Stocks	
		TextArea NameBox;
		int NameBoxSizeX = 200, NameBoxSizeY = 50;
		NameBox = new TextArea();
		NameBox.setPrefSize(NameBoxSizeX, NameBoxSizeY);
		RightCenter.getChildren().add(NameBox);
		
		// Age Prompt
		Text AgePrompt = new Text("Please enter your Age: ");
		AgePrompt.setStyle(StockTextStyle);
		LeftCenter.getChildren().add(AgePrompt);

		// Stock Searcher
		ComboBox <Integer> AgeSelection;
		AgeSelection = new ComboBox<Integer>();
		// Add all the Stock Names
		for (int i = 1; i < 120; i++) {
			AgeSelection.getItems().add(i);
		}
		AgeSelection.setValue(1);
		RightCenter.getChildren().add(AgeSelection);
		
		// Page Header
		Text PersonalInfo = new Text("Personal Info");
		PersonalInfo.setStyle(TextStyle);
		SubrootTop.setCenter(PersonalInfo);
		
		// Back Button
		int backButtonSizeX = 100,backButtonSizeY = 45;
		Button back = new Button("Back");
		back.setStyle(BaseButtonStyle);
		back.setPrefSize(backButtonSizeX, backButtonSizeY);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> window.setScene(StartScene));
		SubrootTop.setLeft(back);
		
		// Continue Button
		int ContinueButtonSizeX = 150,ContinueButtonSizeY = 45;
		Button Continue = new Button("Continue");
		Continue.setStyle(BaseButtonStyle);
		Continue.setPrefSize(ContinueButtonSizeX, ContinueButtonSizeY);
		HoverListener(Continue,BaseButtonStyle,HoverButtonStyle);
		Continue.setOnAction(e -> CheckAge(root2, NameBox, AgeSelection));
		SubrootTop.setRight(Continue);
		
		root2.setTop(SubrootTop);
		root2.setStyle(PageStyle);
		
		SubrootCenterPane.setLeft(LeftCenter);
		SubrootCenterPane.setRight(RightCenter);
		SubrootCenterPane.setStyle(CenterStyle);
		root2.setCenter(SubrootCenterPane);
		
		root2.setStyle("-fx-background-color: black");
		if (TimesinPersonalInfoScene == 1)
			PersonalInfoScene = new Scene(root2, InitialWidthScreen, InitialHeightScreen);
		window.setScene(PersonalInfoScene);
	}
	
	public void CheckAge(BorderPane root2,TextArea NameBox,ComboBox <Integer> AgeSelection) {
		person = new User(NameBox.getText(),AgeSelection.getValue());
		Text PersonalInfo = new Text("you must be at least 18 years or older to use this program");
		// Get user Age
		System.out.print(person.getAge());
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
		// Things to Do
		// Re create page to resize
		// Make Search Box for all drop Downs
		
		ArrayList <String> NameStock = new ArrayList <String> ();
		ArrayList <String> AmountQuantity = new ArrayList <String> ();
		ArrayList <String> DayBought = new ArrayList <String> ();
		ArrayList <String> MonthBought = new ArrayList <String> ();
		ArrayList <String> YearBought = new ArrayList <String> ();
		
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
		Continue.setOnAction(e -> CheckStocks());
		
		if (TimeinOnboardScene == 1)
			AddAnotherStock();
		
		root3.getChildren().addAll(Onboard, back, Continue);
		if (TimeinOnboardScene == 1)
			OnBoardScene = new Scene(root3, InitialWidthScreen, InitialHeightScreen);
		window.setScene(OnBoardScene);
	}
	
	public ArrayList <ComboBox<String>> AddAnotherStock(){
		
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
		String[] SN = null;
		try {
			SN = OpenFile("TopUSCompanies.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ComboBox<String> StockNames = new ComboBox<>();
		StockNames.setTooltip(new Tooltip());
		StockNames.getItems().addAll(SN);
		new ComboBoxSearcher<String>(StockNames);
		StockNames.setLayoutX(StocksNamesPositionX);
		StockNames.setLayoutY(StocksNamesPositionY);
		NameStock.add(StockNames);
		
		// Quantity Text Parameters
		int QuantityTextPositionX = 350, QuantityTextPositionY = (85 + 80*(StocksInPorfolio-1));
		Text QuantityText = new Text("Amount Purchased");
		QuantityText.setLayoutX(QuantityTextPositionX);
		QuantityText.setLayoutY(QuantityTextPositionY);
		QuantityText.setStyle(StockTextStyle);
		QuantityText.toFront();
		
		// TextBox for Amount of Stocks	
		int QuantityBoxPositionX = 350, QuantityBoxPositionY = (100 + 80*(StocksInPorfolio-1));
		ComboBox<String> QuantityBox = new ComboBox<>();
		String[] Quantity = new String[1000];
		for (int j = 1; j <= 1000 ; j++) {
			Quantity[j-1] = j+"";
		}
		QuantityBox.setTooltip(new Tooltip());
		QuantityBox.getItems().addAll(Quantity);
		new ComboBoxSearcher<String>(QuantityBox);
		QuantityBox.setLayoutX(QuantityBoxPositionX);
		QuantityBox.setLayoutY(QuantityBoxPositionY);
		AmountQuantity.add(QuantityBox);
		
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
		
		// Month
		int MonthPositionX = 700, MonthPositionY = (100 + 80*(StocksInPorfolio-1));
		String[] Months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		ComboBox<String> Month = new ComboBox<>();
		Month.setTooltip(new Tooltip());
		Month.getItems().addAll(Months);
		new ComboBoxSearcher<String>(Month);
		Month.setLayoutX(MonthPositionX);
		Month.setLayoutY(MonthPositionY);
		MonthBought.add(Month);
		
		// Day
		int DayPositionX = 800, DayPositionY = (100 + 80*(StocksInPorfolio-1));
		String[] Days = new String[31];
		for (int j = 1; j <= 31 ; j++) {
			String k;
			if (j < 10)
				k = "0"+j;
			else 
				k = "" + j;
			Days[j-1] = k;
		}
		ComboBox<String> Day = new ComboBox<>();
		Day.setTooltip(new Tooltip());
		Day.getItems().addAll(Days);
		new ComboBoxSearcher<String>(Day);
		Day.setLayoutX(DayPositionX);
		Day.setLayoutY(DayPositionY);
		DayBought.add(Day);
		
		// Year
		int YearPositionX = 900, YearPositionY = (100 + 80*(StocksInPorfolio-1));
		String[] Years = new String[20];
		// Add all the Stock Names
		for (int k = 00; k <= 19 ; k++) {
			String j;
			if (k < 10)
				j = "0"+k;
			else 
				j = "" + k;
			Years[k] = j;
		}
		ComboBox<String> Year = new ComboBox<>();
		Year.setTooltip(new Tooltip());
		Year.getItems().addAll(Years);
		new ComboBoxSearcher<String>(Year);
		Year.setLayoutX(YearPositionX);
		Year.setLayoutY(YearPositionY);
		YearBought.add(Year);
		
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
		
		root3.getChildren().addAll(rectangle,AddButton, NameText, QuantityText, DatePurchasedText, StockNames, QuantityBox, Day, Month, Year, Delete);

		ArrayList <ComboBox<String>> StockInfo = new ArrayList<ComboBox<String>>();
		StockInfo.add(StockNames);
		StockInfo.add(QuantityBox);
		StockInfo.add(Month);
		StockInfo.add(Day);
		StockInfo.add(Year);
		
		return StockInfo;
	}
	
	// Make it check everything is correct before making the portfolio (Even the Dates)
	public void CheckStocks() {
		ArrayList<OwnedStock> Portfolio = new ArrayList<OwnedStock>();
		for (int i = 0; i < NameStock.size(); i++) {
			String date = MonthBought.get(i).getValue() + "/" + DayBought.get(i).getValue() + "/" + YearBought.get(i).getValue();
			String name = NameStock.get(i).getValue();
			String amount = AmountQuantity.get(i).getValue();
			stocks = new OwnedStock("",name,amount, date);
			Portfolio.add(stocks);
		}
		portfolio = new Portfolio(Portfolio);
		
		
		LoadMainPage();
		
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
		for (int i = 0; i < StocksInPorfolio; i++) {
			final int k = i;
			// Rectangle Parameters
			int SpecificStockSizeX = 1150,SpecificStockSizeY = 75,SpecificStockPositionX = 25, SpecificStockPositionY  = (60 + 80*i);		
			Button SpecificStock = new Button();
			SpecificStock.setStyle(BaseStartButtonStyle);
			SpecificStock.setPrefSize(SpecificStockSizeX, SpecificStockSizeY);
			SpecificStock.setLayoutX(SpecificStockPositionX); 
			SpecificStock.setLayoutY(SpecificStockPositionY);  
			HoverListener(SpecificStock,BaseStartButtonStyle,HoverStartButtonStyle);
			SpecificStock.setOnAction(e -> LoadSpecificStockScene(NameStock.get(k).getValue(),AmountQuantity.get(k).getValue(),MonthBought.get(k).getValue()+"/"+DayBought.get(k).getValue()+"/"+YearBought.get(k).getValue()));
			SpecificStock.toBack();
			
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
			
			root4.getChildren().addAll(SpecificStock,NameText,QuantityText,DatePurchasedText);
		}
		
		int SaveButtonSizeX = 150,SaveButtonSizeY = 50,SaveButtonPositionX = 25, SaveButtonPositiony  = (60 + 80*StocksInPorfolio);
		Button Save = new Button("Save Portfolio");
		Save.setStyle(BaseStartButtonStyle);
		Save.setPrefSize(SaveButtonSizeX, SaveButtonSizeY);
		Save.setLayoutX(SaveButtonPositionX);
		Save.setLayoutY(SaveButtonPositiony);
		HoverListener(Save,BaseStartButtonStyle,HoverStartButtonStyle);
		Save.setOnAction(e -> SavePortfolio());
		
		int LearningToolButtonSizeX = 300,LearningToolButtonButtonSizeY = 50,LearningToolButtonPositionX = 500, LearningToolButtonPositiony  = (60 + 80*StocksInPorfolio);
		Button LearningToolButton = new Button("Individual Stock Assesment");
		LearningToolButton.setStyle(BaseStartButtonStyle);
		LearningToolButton.setPrefSize(LearningToolButtonSizeX, LearningToolButtonButtonSizeY);
		LearningToolButton.setLayoutX(LearningToolButtonPositionX);
		LearningToolButton.setLayoutY(LearningToolButtonPositiony);
		HoverListener(LearningToolButton,BaseStartButtonStyle,HoverStartButtonStyle);
		LearningToolButton.setOnAction(e -> IndividualStockAssesmentOnboard());
		
		root4.getChildren().addAll(BlanksPortfolio,EditPortFolio,EditPersonal,Save, LearningToolButton);
		if (TimesinMainScene == 1)
			MainScene = new Scene(root4, InitialWidthScreen, InitialHeightScreen);
		window.setScene(MainScene);
	}
	
	public void IndividualStockAssesmentOnboard() {
		// Things to do
		// Add searchbox drop down
		// Make Min Size for window
		// Make size of window not change between scene transitions
		// Make the message that Personal Info a pop up
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
			    "-fx-background-color: black;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: white;"+
			    "-fx-background-color: gray;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;"+
			    "-fx-spacing: 20";
		
		String TextStyle = "-fx-font: Times New Roman;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 30;";
		
		String smallTextStyle = "-fx-font: Times New Roman;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 10;";
		
		String PageStyle = "-fx-padding: 10;"+
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;";
		
		String CenterStyle = "-fx-padding: 20;"+
                "-fx-border-width: 4;" +
                "-fx-border-insets: 5;";
		
		// OverArching
		BorderPane root6 = new BorderPane();
		// Sub Panes
		BorderPane SubrootTop = new BorderPane();
		BorderPane SubrootCenterPane = new BorderPane();
		VBox TopVbox = new VBox(15);
		VBox LeftCenter = new VBox(35);
		VBox RightCenter = new VBox(35);
		
		TimeinIndividualStockAssesmentOnboardScene++;
		
		// Outlook Prompt
		Text OutlookPrompt = new Text("How Long do you want to look back");
		OutlookPrompt.setStyle(TextStyle);
		LeftCenter.getChildren().add(OutlookPrompt);
		
		Text StockSelection = new Text("Select a Stock");
		StockSelection.setStyle(TextStyle);
		LeftCenter.getChildren().add(StockSelection);

		// Outlook Adder
		ComboBox <String> OutLookSelection;
		OutLookSelection = new ComboBox<String>();
		// Add all of the possibilities
		OutLookSelection.getItems().addAll("3 Days", "1 Week", "1 Month", "3 Months");
		OutLookSelection.setValue("3 Days");
		RightCenter.getChildren().add(OutLookSelection);
		
		// Stock Searcher
		String[] SN = null;
		try {
			SN = OpenFile("TopUSCompanies.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ComboBox<String> StockNames = new ComboBox<>();
		StockNames.setTooltip(new Tooltip());
		StockNames.getItems().addAll(SN);
		new ComboBoxSearcher<String>(StockNames);
		RightCenter.getChildren().add(StockNames);
		
		// Page Header
		Text OutlookIntro = new Text("Select Options for Outlook");
		OutlookIntro.setStyle(TextStyle);
		SubrootTop.setCenter(OutlookIntro);
		
		// Back Button
		int backButtonSizeX = 100,backButtonSizeY = 45;
		Button back = new Button("Back");
		back.setStyle(BaseButtonStyle);
		back.setPrefSize(backButtonSizeX, backButtonSizeY);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> window.setScene(MainScene));
		SubrootTop.setLeft(back);
		
		// Continue Button
		int ContinueButtonSizeX = 150,ContinueButtonSizeY = 45;
		Button Continue = new Button("Continue");
		Continue.setStyle(BaseButtonStyle);
		Continue.setPrefSize(ContinueButtonSizeX, ContinueButtonSizeY);
		HoverListener(Continue,BaseButtonStyle,HoverButtonStyle);
		Continue.setOnAction(e -> LoadIndividualStockAssesment(OutLookSelection.getValue(),StockNames.getValue()));
		SubrootTop.setRight(Continue);
		
		root6.setTop(SubrootTop);
		root6.setStyle(PageStyle);
		
		SubrootCenterPane.setLeft(LeftCenter);
		SubrootCenterPane.setRight(RightCenter);
		SubrootCenterPane.setStyle(CenterStyle);
		root6.setCenter(SubrootCenterPane);
		
		root6.setStyle("-fx-background-color: black");
		if (TimeinIndividualStockAssesmentOnboardScene == 1)
			IndividualStockAssesmentOnboardScene = new Scene(root6, InitialWidthScreen, InitialHeightScreen);
		window.setScene(IndividualStockAssesmentOnboardScene);
	}
	
	public void LoadIndividualStockAssesment(String Outlook, String Name){	
		
		TimesinIndividualStockAssesmentScene++;
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
			    "-fx-background-color: black;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: white;"+
			    "-fx-background-color: gray;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;"+
			    "-fx-spacing: 20";
		
		String TextStyle = "-fx-font: Times New Roman;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 30;";
		
		String smallTextStyle = "-fx-font: Times New Roman;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 15;";
		
		BorderPane root7 = new BorderPane(); 
		BorderPane top = new BorderPane();
		VBox center = new VBox(10);
		
		int backButtonSizeX = 100,backButtonSizeY = 45;
		Button back = new Button("Back");
		back.setStyle(BaseButtonStyle);
		back.setPrefSize(backButtonSizeX, backButtonSizeY);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> UnloadCurrentScene(MainScene, root7));
		top.setLeft(back);
		
		Text Header = new Text("Assesing "+ Name);
		Header.setStyle(TextStyle);
		top.setCenter(Header);
		
		root7.setTop(top);
		
		Text blurb = new Text(apple.getIntroduction());
		blurb.setStyle(smallTextStyle);
		Text PE = new Text("P/E Ratio: "+new DecimalFormat("$#.00").format(apple.calcHistPERatio(21))),Price = new Text("Price: "+new DecimalFormat("$#.00").format(apple.getPrevClose())),MM = new Text("Market Moment: "+new DecimalFormat("$#.00").format(apple.calcMomentum(0, 21))),RSI = new Text("Relative Strength Index: "+new DecimalFormat("$#.00").format(apple.calcRSI(21))),EMA = new Text("Exponential Moving Average"+new DecimalFormat("$#.00").format(apple.calcEMA(21))), Conclusion = new Text("Conclusion:");
		PE.setStyle(TextStyle);
		Price.setStyle(TextStyle);
		MM.setStyle(TextStyle);
		RSI.setStyle(TextStyle);
		EMA.setStyle(TextStyle);
		Conclusion.setStyle(TextStyle);
		
		Text PEDef = new Text(apple.getPERatio()),PriceDef = new Text(apple.getPrice()),MMDef = new Text(apple.getMomentum()),RSIDef = new Text(apple.getRSI()),EMADef = new Text(apple.getEMA()), ConclusionDef = new Text(apple.conclusion());
		PEDef.setStyle(smallTextStyle);
		PriceDef.setStyle(smallTextStyle);
		MMDef.setStyle(smallTextStyle);
		RSIDef.setStyle(smallTextStyle);
		EMADef.setStyle(smallTextStyle);
		ConclusionDef.setStyle(smallTextStyle);
		
		center.getChildren().addAll(blurb,PE,PEDef,Price,PriceDef,MM,MMDef,RSI,RSIDef,EMA,EMADef,Conclusion, ConclusionDef);
		
		root7.setCenter(center);
		
		root7.setStyle("-fx-background-color: black");
		if (TimesinIndividualStockAssesmentScene == 1)
			IndividualStockAssesmentScene = new Scene(root7, InitialWidthScreen, InitialHeightScreen);
		
		window.setScene(IndividualStockAssesmentScene);
	}
	
	public void LoadSpecificStockScene(String name, String amount, String Date) {
		// When load and unload and load again, it fucks up figure out?
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
			    "-fx-background-color: black;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: white;"+
			    "-fx-background-color: gray;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;"+
			    "-fx-spacing: 20";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 35;";
		
		String PageTextStyle = "-fx-font: Times New Roman;"+
				"-fx-stroke: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 25;";
		
		TimesinSpecificStockScene++;
		BorderPane SSroot = new BorderPane();
		BorderPane SubrootTop = new BorderPane();
		VBox SubrootParameters = new VBox(20);
		VBox SubrootData = new VBox(20);
		
		// Gets all the information about the stock
		//String[] stockinfo = stockimporter.getStockInfo(name);
		
		// Back To Main Page
		int BackToMainButtonSizeX = 250,BackToMainButtonSizeY = 45;
		Button BackToMain = new Button("Back to Main Page");
		BackToMain.setStyle(BaseButtonStyle);
		BackToMain.setPrefSize(BackToMainButtonSizeX, BackToMainButtonSizeY);
		HoverListener(BackToMain,BaseButtonStyle,HoverButtonStyle);
		BackToMain.setOnAction(e -> UnloadCurrentScene(MainScene, SSroot));
		SubrootTop.setLeft(BackToMain);
		
		// Stock Name
		Text NameText = new Text(name+" ("+stockimporter.getStockSymbol(name)+")");
		NameText.setStyle(HeaderTextStyle);
		SubrootTop.setCenter(NameText);
		
		SSroot.setTop(SubrootTop);

		Text PC = new Text("Previous Close: "), ThreeMR = new Text("Three Month Range: "), PE = new Text("Price to Earnings Ratio: "), MM = new Text("Market Momentum: "), RSI = new Text("Relative Strength Index: "), EMA = new Text("Exponential Moving Average: "), OurRec = new Text("Our Reccomendation: "), News = new Text("News(will be implemented for final)");
		PC.setStyle(PageTextStyle);
		ThreeMR.setStyle(PageTextStyle);
		PE.setStyle(PageTextStyle);
		MM.setStyle(PageTextStyle);
		RSI.setStyle(PageTextStyle);
		EMA.setStyle(PageTextStyle);
		OurRec.setStyle(PageTextStyle);
		News.setStyle(PageTextStyle);
		SubrootParameters.getChildren().addAll(PC,ThreeMR,PE,MM,RSI,EMA,OurRec,News);
		SSroot.setLeft(SubrootParameters);
		
		Text PCData = new Text(""+new DecimalFormat("$#.00").format(apple.getPrevClose())), ThreeMRData = new Text(""+new DecimalFormat("$#.00").format(apple.getThreeMonthLow(62))+ ", "+new DecimalFormat("$#.00").format(apple.getThreeMonthHigh(62))), PEData = new Text(""+new DecimalFormat("$#.00").format(apple.calcPERatio())), MMData = new Text(""+new DecimalFormat("$#.00").format(apple.calcMomentum(0, 21))), RSIData = new Text(""+new DecimalFormat("$#.00").format(apple.calcRSI(21))), EMAData = new Text(""+new DecimalFormat("$#.00").format(apple.calcEMA(21))), OurRecData = new Text(apple.conclusion()), NewsData = new Text("(EH)");
		PCData.setStyle(PageTextStyle);
		ThreeMRData.setStyle(PageTextStyle);
		PEData.setStyle(PageTextStyle);
		MMData.setStyle(PageTextStyle);
		RSIData.setStyle(PageTextStyle);
		EMAData.setStyle(PageTextStyle);
		OurRecData.setStyle(PageTextStyle);
		NewsData.setStyle(PageTextStyle);
		SubrootData.getChildren().addAll(PCData,ThreeMRData,PEData,MMData,RSIData,EMAData,OurRecData,NewsData);
		SSroot.setRight(SubrootData);
		
		SSroot.setStyle("-fx-background-color: black");
		if (TimesinSpecificStockScene == 1)
			SpecificStockScene = new Scene(SSroot, InitialWidthScreen, InitialHeightScreen);
		window.setScene(SpecificStockScene);
		
	}
	
	public void SavePortfolio () {
		if (person.savePortfolio())
			System.out.print("Saved");
		else 
			System.out.print("Not Saved");
	}
	
	public void UnloadCurrentScene(Scene scene, BorderPane root) {
		root.getChildren().clear();
		window.setScene(scene);
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
	
	public static class HideableItem<T>
    {
        private final ObjectProperty<T> object = new SimpleObjectProperty<>();
        private final BooleanProperty hidden = new SimpleBooleanProperty();
        
        private HideableItem(T object)
        {
            setObject(object);
        }
        
        private ObjectProperty<T> objectProperty(){return this.object;}
        private T getObject(){return this.objectProperty().get();}
        private void setObject(T object){this.objectProperty().set(object);}
        
        private BooleanProperty hiddenProperty(){return this.hidden;}
        private boolean isHidden(){return this.hiddenProperty().get();}
        private void setHidden(boolean hidden){this.hiddenProperty().set(hidden);}
        
        @Override
        public String toString()
        {
            return getObject() == null ? null : getObject().toString();
        }
    }

	public String[] OpenFile(String file) throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numLines = 84;
		String[] text = new String[numLines];
		
		for (int i = 0; i < numLines; i++) {
			text[i] = textReader.readLine();
		}
		
		return text;
	}
}
