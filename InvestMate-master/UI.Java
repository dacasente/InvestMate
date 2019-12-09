import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
// Pos, Insets
import javafx.geometry.Pos;
// Scene, Group, Node, etc.
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
// Text, Font
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane; 
import javafx.geometry.HPos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

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
	
	// The Height and width of the window
	int InitialHeightScreen = 728, InitialWidthScreen = 1200;
	// Detect how many times the user has entered the specific screen
	int TimesinStartScene = 0, TimesinLoginScene = 0, TimesinSignUpScene = 0, TimesCreatingUser = 0, TimeinOnboardScene = 0, TimesinMainScene = 0,TimesinEditPortfolioScene = 0, TimesinMyAccountScene = 0, TimesUpdatingUser = 0, TimesinSpecificStockScene = 0, TimeinIndividualStockAssesmentOnboardScene = 0, TimesinIndividualStockAssesmentScene = 0, TimesinPortfolioAssesmentScene = 0, TimesinSearchAStockScene = 0, TimesinMarketAssesmentScene = 0;
	
	// This is the window that the user sees
	Stage window;
	
	// Objects
	User person;
	StockImporter stockimporter;
	LearningTool learningtool;
	UserManager manage;
	OwnedStock stock;

	// BorderPane for the main class
	BorderPane rootmainScene = new BorderPane();
	
	// The different Scenes
	Scene StartScene, LoginScene, SignUpScene, OnBoardScene, MainScene, EditPortfolioScene, MyAccountScene, SpecificStockScene, IndividualStockAssesmentOnboardScene, IndividualStockAssesmentScene, PortfolioAssesmentScene, SearchAStockScene, MarketAssesmentScene;

	// Lets the Program be run from the RunProgram Class
	public void Begin(Stage primaryStage){
		window = primaryStage;
		// Title of screen
		window.setTitle("Stock Advisor");
		window.setResizable(true);
		window.setMinHeight(500);
		window.setMinWidth(800);
		// Starts the Program
		LoadStartPage();
		// Displays the program on the computer
		window.show();
	}
	
	// Loads the Start Page
	public void LoadStartPage() {
		
		// Text Styles for the Screen
		String MainTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 100;";
		
		String SubTextStyle = "-fx-font: Courier New;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 25;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 40;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 40;";
		
		// Counts the Number of times the User Enters the First Scene
		TimesinStartScene++;
		
		// Main Root in the Scene
		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);
		// Button Root which will go within the main root
		HBox btns = new HBox(10);
		btns.setAlignment(Pos.CENTER);
		
		// The investMate Logo 
	    Image image = new Image("File:InvestMateLogo.jpeg");  
	    ImageView imageView = new ImageView(image); 
		
		// Header Text
		Text StartText = new Text("InvestMate");
		StartText.setStyle(MainTextStyle);
		
		// Sub Text
		Text SubText = new Text("- For All Your Personal Investing Needs");
		SubText.setStyle(SubTextStyle);
		
		// This is for a user with an existing account
		double StartButtonSizeX = 600,StartButtonSizeY = 60;
		Button StartButton = new Button();
		StartButton = new Button("Let's Begin");
		StartButton.setPrefSize(StartButtonSizeX,StartButtonSizeY);
		StartButton.setStyle(BaseButtonStyle);
		StartButton.setOnAction(e -> LoadLoginScene());
		HoverListener(StartButton,BaseButtonStyle, HoverButtonStyle);
		
		btns.getChildren().addAll(StartButton);
		
		// Sets the background for the scene
		root.setStyle("-fx-background-color: black");
		// adds all the nodes to the scenes
		root.getChildren().addAll(StartText, SubText, btns, imageView);
		// Create a new scene for the first time in the start scene
		if (TimesinStartScene == 1) 
			StartScene = new Scene(root,InitialWidthScreen,InitialHeightScreen);
		
		// Sets the scene to the start scene
		window.setScene(StartScene);
	}
	
	// Loads the LogIn Scene
	public void LoadLoginScene() {
		// Make size of window not change between scene transitions
		// Create Message that user does not exist pop up
		// Do log in Stuff

		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 80;";
		
		String TextFieldStyle = "-fx-font-family: Quicksand;"+
				"-fx-font-size: 18;"+
				"-fx-padding: 1,1,1,1;"+
				"-fx-border-color: white;"+
				"-fx-border-width: 2;"+
				"-fx-border-radius: 1;"+
				"-fx-border: gone;"+
				"-fx-background-color: transparent;"+
				"-fx-text-fill: white;";
		
		TimesinLoginScene++;
		
		// Formatting the Page
		BorderPane root = new BorderPane();
		VBox Top = new VBox(50);
		BorderPane SubTopLeft = new BorderPane();
		SubTopLeft.setPadding(new Insets(15, 0, 0, 15));
		HBox txtField1 = new HBox();
		HBox txtField2 = new HBox();
		HBox btns = new HBox(15);
		
		TextField NameBox = new TextField();
		TextField PasswordBox = new TextField();
		
		// Back Button
		int backButtonSizeX = 100,backButtonSizeY = 45;
		Button back = new Button("Back");
		back.setStyle(BaseButtonStyle);
		back.setPrefSize(backButtonSizeX, backButtonSizeY);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LeaveSignInback(NameBox, PasswordBox));
		SubTopLeft.setLeft(back);
		Top.getChildren().add(SubTopLeft);
		
		// Page Header
		Text SignIn = new Text("Log In");
		SignIn.setStyle(HeaderTextStyle);
		Top.getChildren().add(SignIn);
	
		// TextField for the UserName	
		NameBox.setPromptText("Name");
		int NameBoxSizeX = 600, NameBoxSizeY = 10;
		NameBox.setPrefSize(NameBoxSizeX, NameBoxSizeY);
		NameBox.setStyle(TextFieldStyle);
		NameBox.setAlignment(Pos.CENTER);
		txtField1.getChildren().add(NameBox);
		txtField1.setAlignment(Pos.CENTER);
		Top.getChildren().add(txtField1);
		
		// TextField for the Password
		PasswordBox.setPromptText("Password");
		int PasswordBoxSizeX = 600, PasswordBoxSizeY = 10;
		PasswordBox.setPrefSize(PasswordBoxSizeX, PasswordBoxSizeY);
		PasswordBox.setStyle(TextFieldStyle);
		PasswordBox.setAlignment(Pos.CENTER);
		txtField2.getChildren().add(PasswordBox);
		txtField2.setAlignment(Pos.CENTER);
		Top.getChildren().add(txtField2);
		
		// Log in Button
		int SignInSizeX = 300,SignInSizeY = 45;
		Button SignInBtn = new Button("Log In");
		SignInBtn.setStyle(BaseButtonStyle);
		SignInBtn.setPrefSize(SignInSizeX, SignInSizeY);
		HoverListener(SignInBtn,BaseButtonStyle,HoverButtonStyle);
		SignInBtn.setOnAction(e -> CheckUser(Top));
		btns.getChildren().add(SignInBtn);
		
		// New Account Button
		int NewAccountSizeX = 300,NewAccountSizeY = 45;
		Button NewAccount = new Button("Create a new account");
		NewAccount.setStyle(BaseButtonStyle);
		NewAccount.setPrefSize(NewAccountSizeX, NewAccountSizeY);
		HoverListener(NewAccount,BaseButtonStyle,HoverButtonStyle);
		NewAccount.setOnAction(e -> LeaveSignInNewAccount(NameBox, PasswordBox));
		btns.getChildren().add(NewAccount);
		
		// Formatting stuff
		btns.setAlignment(Pos.CENTER);
		Top.getChildren().add(btns);
		Top.setAlignment(Pos.CENTER);
		root.setTop(Top);
		root.setStyle("-fx-background-color: black");
		
		// Creates the Scene and loads it
		if (TimesinLoginScene == 1)
			LoginScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		window.setScene(LoginScene);
	}
	
	public void LeaveSignInback(TextField Name, TextField Password) {
		Name.clear();
		Password.clear();
		window.setScene(StartScene);
	}
	
	public void LeaveSignInNewAccount(TextField Name, TextField Password) {
		Name.clear();
		Password.clear();
		LoadSignUpScene();
	}
	
	// This will check a user to see if they actually exist if the sign in button is pressed
	// If the user does exist then we are gonna load their portfolio 
	public void CheckUser(VBox top) {
		
	}

	// Loads the SignUp Scene
	public void LoadSignUpScene() {
		// Make look more professional
		// Add Rules for password
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		String BodyTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 25;";
		
		String TextFieldStyle = "-fx-font-family: Quicksand;"+
				"-fx-font-size: 18;"+
				"-fx-padding: 1,1,1,1;"+
				"-fx-border-color: white;"+
				"-fx-border-width: 2;"+
				"-fx-border-radius: 1;"+
				"-fx-border: gone;"+
				"-fx-background-color: transparent;"+
				"-fx-text-fill: white;";
		
		TimesinSignUpScene++;
		
		// Formatting the Page
		BorderPane root = new BorderPane();
		VBox Top = new VBox(50);
		Top.setAlignment(Pos.CENTER);
		BorderPane SubTopLeft = new BorderPane();
		SubTopLeft.setPadding(new Insets(15, 0, 0, 15));
		HBox txtField1 = new HBox();
		HBox txtField2 = new HBox();
		HBox agebox = new HBox(30);
		
		// Back Button
		TextField NameBox = new TextField();
		TextField PasswordBox = new TextField();
		ComboBox <Integer> AgeSelection = new ComboBox<Integer>();
		int backButtonSizeX = 100,backButtonSizeY = 45;
		Button back = new Button("Back");
		back.setStyle(BaseButtonStyle);
		back.setPrefSize(backButtonSizeX, backButtonSizeY);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LeaveSignUpPage(NameBox, AgeSelection, PasswordBox));
		SubTopLeft.setLeft(back);
		Top.getChildren().add(SubTopLeft);
		
		// Page Header
		Text Header = new Text("Create a New Account");
		Header.setStyle(HeaderTextStyle);
		Top.getChildren().add(Header);
		
		// TextField for the UserName	
		NameBox.setPromptText("Please Enter your Name");
		int NameBoxSizeX = 600, NameBoxSizeY = 10;
		NameBox.setPrefSize(NameBoxSizeX, NameBoxSizeY);
		NameBox.setStyle(TextFieldStyle);
		NameBox.setAlignment(Pos.CENTER);
		txtField1.getChildren().add(NameBox);
		txtField1.setAlignment(Pos.CENTER);
		Top.getChildren().add(txtField1);
		
		// Text for the Age
		Text ageprompt = new Text("Please Enter Your Age: ");
		ageprompt.setStyle(BodyTextStyle);
		agebox.getChildren().add(ageprompt);
		
		// Age combobox
		for (int i = 1; i < 120; i++) {
			AgeSelection.getItems().add(i);
		}
		AgeSelection.setValue(1);
		agebox.getChildren().add(AgeSelection);
		agebox.setAlignment(Pos.CENTER);
		Top.getChildren().add(agebox);
		
		// TextField for the Password	
		PasswordBox.setPromptText("Please Enter a Password");
		int PasswordBoxSizeX = 600, PasswordBoxSizeY = 10;
		PasswordBox.setPrefSize(PasswordBoxSizeX, PasswordBoxSizeY);
		PasswordBox.setStyle(TextFieldStyle);
		PasswordBox.setAlignment(Pos.CENTER);
		txtField2.getChildren().add(PasswordBox);
		txtField2.setAlignment(Pos.CENTER);
		Top.getChildren().add(txtField2);
		
		// Account Creation Button
		int SignInSizeX = 600,SignInSizeY = 45;
		Button SignInBtn = new Button("Create Your Account");
		SignInBtn.setStyle(BaseButtonStyle);
		SignInBtn.setPrefSize(SignInSizeX, SignInSizeY);
		HoverListener(SignInBtn,BaseButtonStyle,HoverButtonStyle);
		SignInBtn.setOnAction(e -> CreateUser(Top,NameBox,AgeSelection,PasswordBox));
		Top.getChildren().add(SignInBtn);
		
		// Formatting stuff
		root.setTop(Top);
		root.setStyle("-fx-background-color: black");
		
		// Creates the Scene and loads it
		if (TimesinSignUpScene == 1)
			SignUpScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		window.setScene(SignUpScene);
	}
	
	public void LeaveSignUpPage(TextField name, ComboBox <Integer> AgeSelection, TextField password) {
		name.clear();
		password.clear();
		AgeSelection.setValue(1);
		window.setScene(LoginScene);
	}
	
	// Checks if the User has input all valid selections into the Fields
	public void CreateUser(VBox root,TextField NameBox,ComboBox <Integer> AgeSelection, TextField PasswordBox) {
		
		String ErrorTextStyle = "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 15;"+
			    "-fx-stroke: red";
		
		TimesCreatingUser++;
		
		if (TimesCreatingUser != 1)
			root.getChildren().remove(root.getChildren().size()-1);
		
		if (NameBox.getText().trim().isEmpty() || PasswordBox.getText().trim().isEmpty()) {
			Text Error = new Text("You must fill out all the fields");
			Error.setStyle(ErrorTextStyle);
			root.getChildren().add(Error);
		}
		else if (AgeSelection.getValue() < 18) {
			Text Error = new Text("User must be 18 years or older");
			Error.setStyle(ErrorTextStyle);
			root.getChildren().add(Error);
		}
		else {
			// Make it so the Password is added
			//manage.addUser(NameBox.getText(),AgeSelection.getValue(),PasswordBox.getText());
			person = new User(NameBox.getText(),AgeSelection.getValue(),PasswordBox.getText());
			LoadOnboardPage();
		}
	}
	
	public void LoadOnboardPage() {
		// Make Possible to Scroll Down Stocks
		// Create a Back Button and not create a user until the stocks are created

		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		TimeinOnboardScene++;
		
		BorderPane root = new BorderPane();
		VBox Top = new VBox(15);
		Top.setAlignment(Pos.CENTER);
		BorderPane SubTopRight = new BorderPane(), SubTopCenter = new BorderPane();
		SubTopRight.setPadding(new Insets(15, 15, 15, 15));
		VBox stocks = new VBox(5);
		
		int StocksInPorfolio = 0;
		
		int ContinueButtonSizeX = 150,ContinueButtonSizeY = 45;
		Button Continue = new Button("Continue");
		Continue.setStyle(BaseButtonStyle);
		Continue.setPrefSize(ContinueButtonSizeX, ContinueButtonSizeY);
		HoverListener(Continue,BaseButtonStyle,HoverButtonStyle);
		SubTopRight.setRight(Continue);
		Top.getChildren().add(SubTopRight);
		Continue.setOnAction(e -> CheckStocks(stocks));
		
		Text Header = new Text("Onboard Portfolio");
		Header.setStyle(HeaderTextStyle);
		SubTopCenter.setCenter(Header);
		Top.getChildren().add(SubTopCenter);
		
		root.setTop(Top);
		
		if (TimeinOnboardScene == 1)
			AddAnotherStock(stocks, StocksInPorfolio);

		root.setCenter(stocks);
		root.setStyle("-fx-background-color: black");
		if (TimeinOnboardScene == 1)
			OnBoardScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		window.setScene(OnBoardScene);
	}
	
	public void AddAnotherStock(VBox stocks, int StocksInPorfolio){
		// Fix the boarder for adding another Stock so that it is trim to the input information
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String StockTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 25;";
		
		String StockBorder = "-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 4;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: white;";
		
		StocksInPorfolio++;
		
		HBox elements = new HBox(15);
		VBox STOCKS = new VBox(5);
		VBox AMOUNT = new VBox(5);
		VBox DATE = new VBox(5);
		HBox DateInput = new HBox(10);
		HBox Addbtn = new HBox();
		FlowPane rec = new FlowPane(10,10);
		
		// Name Text Parameters
		Text NameText = new Text("Stock Name");
		NameText.setStyle(StockTextStyle);
		NameText.toFront();
		
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
		
		// Quantity Text Parameters
		Text QuantityText = new Text("Amount Purchased");
		QuantityText.setStyle(StockTextStyle);
		QuantityText.toFront();
		
		// TextBox for Amount of Stocks	
		ComboBox<String> QuantityBox = new ComboBox<>();
		String[] Quantity = new String[1000];
		for (int j = 1; j <= 1000 ; j++) {
			QuantityBox.getItems().add(j+"");
		}
		
		// Date Text Parameters;
		Text DatePurchasedText = new Text("Date Purchased");
		DatePurchasedText.setStyle(StockTextStyle);
		DatePurchasedText.toFront();
		
		//Delete Stock Button
		int DeleteButtonSizeX = 25,DeleteButtonSizeY = 25;
		Button Delete = new Button("x");
		Delete.setStyle(BaseButtonStyle);
		Delete.setPrefSize(DeleteButtonSizeX, DeleteButtonSizeY);
		Delete.setOnAction(e -> stocks.getChildren().remove(elements));
		HoverListener(Delete,BaseButtonStyle,HoverButtonStyle);
		
		// Month
		String[] Months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		ComboBox<String> Month = new ComboBox<>();
		for (int i = 0; i < Months.length; i++) {
			Month.getItems().add(Months[i]);
		}
		
		// Day
		ComboBox<String> Day = new ComboBox<>();
		for (int j = 1; j <= 31 ; j++) {
			String k;
			if (j < 10)
				k = "0"+j;
			else 
				k = "" + j;
			Day.getItems().add(k);
		}
		
		// Year
		ComboBox<String> Year = new ComboBox<>();
		for (int k = 00; k <= 19 ; k++) {
			String j;
			if (k < 10)
				j = "0"+k;
			else 
				j = "" + k;
			Year.getItems().add(j);
		}
		
		// Remove Previous button
		if (StocksInPorfolio > 1) {
			stocks.getChildren().remove(stocks.getChildren().size()-1);
		}
		
		// adds next button
		Button AddButton = new Button("Add");
		int ButtonSizeX = 700,ButtonSizeY = 40;
		AddButton.setPrefSize(ButtonSizeX, ButtonSizeY);
		AddButton.setStyle(BaseButtonStyle);
		HoverListener(AddButton,BaseButtonStyle,HoverButtonStyle);
		int k = StocksInPorfolio;
		AddButton.setOnAction(e -> AddAnotherStock(stocks, k));
		Addbtn.getChildren().add(AddButton);
		Addbtn.setAlignment(Pos.CENTER);
		
		DateInput.getChildren().addAll(Month,Day,Year);
		DateInput.setAlignment(Pos.CENTER);
		STOCKS.getChildren().addAll(NameText, StockNames);
		AMOUNT.getChildren().addAll(QuantityText, QuantityBox);
		DATE.getChildren().addAll(DatePurchasedText,DateInput);
		STOCKS.setAlignment(Pos.CENTER);
		AMOUNT.setAlignment(Pos.CENTER);
		DATE.setAlignment(Pos.CENTER);
		Delete.setAlignment(Pos.CENTER);
		elements.getChildren().addAll(STOCKS,AMOUNT,DATE, Delete);
		elements.setAlignment(Pos.CENTER);
		elements.setStyle(StockBorder);
		rec.getChildren().addAll(elements);
		stocks.getChildren().addAll(elements, Addbtn);
	}
	
	// Make it check everything is correct before making the portfolio (Even the Dates)
	public void CheckStocks(VBox AllStock) {
		// Check if all input fields are filled
		// Check if all the stocks inputed are valid inputs
		
		ArrayList<OwnedStock> Portfolio = new ArrayList<OwnedStock>();
		
		for (int i = 0; i < AllStock.getChildren().size() - 1; i++) {
			HBox a = (HBox) AllStock.getChildren().get(i);
			VBox b = (VBox) a.getChildren().get(0);
			ComboBox<String> names = (ComboBox<String>) b.getChildren().get(1);
			String name = names.getValue();
			VBox c = (VBox) a.getChildren().get(1);
			ComboBox<String> amounts = (ComboBox<String>) c.getChildren().get(1);
			String amount = amounts.getValue();
			VBox d = (VBox) a.getChildren().get(2);
			HBox e = (HBox) d.getChildren().get(1);
			ComboBox<String> days = (ComboBox<String>) e.getChildren().get(0);
			String day = days.getValue();
			ComboBox<String> months = (ComboBox<String>) e.getChildren().get(1);
			String month = months.getValue();
			ComboBox<String> years = (ComboBox<String>) e.getChildren().get(2);
			String year = years.getValue();
			
			Portfolio.add(new OwnedStock(name,name,amount,month+"/"+day+"/"+year));
			
			//System.out.println(name);
			//System.out.println(amount);
			//System.out.println(day);
			//System.out.println(month);
			//System.out.println(year);
		}
		person.createPortfolio(Portfolio);
		LoadMainPage();
	}
			
	public void LoadMainPage() {
		// Get all the Buttons Working 
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		String BigButtonBase ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String BigButtonHover = "-fx-text-fill: white;"+
			    "-fx-background-color:grey;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String PageTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 22;";
		
		TimesinMainScene++;
		
		if (TimesinMainScene == 1) {
			VBox top = new VBox(10);
			BorderPane topbtn = new BorderPane(), header = new BorderPane();
			topbtn.setPadding(new Insets(15, 15, 15, 15));
			HBox btns = new HBox(15);
			
			int EditPortFolioButtonSizeX = 200,EditPortFolioButtonSizeY = 45;
			Button EditPortFolio = new Button("Edit Portfolio");
			EditPortFolio.setStyle(BaseButtonStyle);
			EditPortFolio.setPrefSize(EditPortFolioButtonSizeX, EditPortFolioButtonSizeY);
			HoverListener(EditPortFolio,BaseButtonStyle,HoverButtonStyle);
			topbtn.setLeft(EditPortFolio);
			EditPortFolio.setOnAction(e -> EditPortfolio());
			
			int EditPersonalButtonSizeX = 200,EditPersonalButtonSizeY = 45;
			Button EditPersonal = new Button("My Account");
			EditPersonal.setStyle(BaseButtonStyle);
			EditPersonal.setPrefSize(EditPersonalButtonSizeX, EditPersonalButtonSizeY);
			HoverListener(EditPersonal,BaseButtonStyle,HoverButtonStyle);
			topbtn.setRight(EditPersonal);
			top.getChildren().add(topbtn);
			EditPersonal.setOnAction(e -> LoadMyAccountScene());
			
			Text BlanksPortfolio = new Text(person.getName()+"'s Portfolio");
			BlanksPortfolio.setLayoutY(50);
			BlanksPortfolio.setLayoutX(InitialWidthScreen/2 - 200);
			BlanksPortfolio.setStyle(HeaderTextStyle);
			top.getChildren().add(BlanksPortfolio);
			top.setAlignment(Pos.CENTER);
			
			Separator separator1 = new Separator();
			top.getChildren().add(separator1);
			
			Separator sep1 = new Separator(), sep2 = new Separator(), sep3 = new Separator();
			sep1.setOrientation(Orientation.VERTICAL);
			sep2.setOrientation(Orientation.VERTICAL);
			sep3.setOrientation(Orientation.VERTICAL);
			
			int BigBtnSizeX = 300, BigBtnSizeY = 60;
			Button MrkOvw = new Button("Market OverView"), AssesStock = new Button("Asses A Stock"), SearchStock = new Button("Seach for Stock"), PortfolioAssesment = new Button("Portfolio Assesment");
			MrkOvw.setStyle(BigButtonBase);
			MrkOvw.setPrefSize(BigBtnSizeX,BigBtnSizeY);
			HoverListener(MrkOvw,BigButtonBase,BigButtonHover);
			MrkOvw.setOnAction(e -> LoadMarketAssesment());
			AssesStock.setStyle(BigButtonBase);
			AssesStock.setPrefSize(BigBtnSizeX,BigBtnSizeY);
			HoverListener(AssesStock,BigButtonBase,BigButtonHover);
			AssesStock.setOnAction(e -> LoadIndividualStockAssesmentOnboard());
			SearchStock.setStyle(BigButtonBase);
			SearchStock.setPrefSize(BigBtnSizeX,BigBtnSizeY);
			HoverListener(SearchStock,BigButtonBase,BigButtonHover);
			SearchStock.setOnAction(e -> SearchAStock());
			PortfolioAssesment.setStyle(BigButtonBase);
			PortfolioAssesment.setPrefSize(BigBtnSizeX,BigBtnSizeY);
			HoverListener(PortfolioAssesment,BigButtonBase,BigButtonHover);
			PortfolioAssesment.setOnAction(e -> PortfolioAssesment());
			btns.getChildren().addAll(MrkOvw,sep1,AssesStock,sep2,SearchStock,sep3,PortfolioAssesment);
			btns.setAlignment(Pos.CENTER);
			top.getChildren().add(btns);
			
			Separator separator2 = new Separator();
			top.getChildren().add(separator2);
			
			rootmainScene.setTop(top);
		}
		
		GridPane grid = new GridPane(); 
		grid.setPadding(new Insets(30, 10, 10, 10)); 
		grid.setVgap(10); 
	    grid.setHgap(40);
	    //grid.setAlignment(Pos.CENTER); 
	
		Text name = new Text("Name"), quantity = new Text("Quantity"), Todayschange = new Text("Todays Change"), NetChange = new Text("Net Change"), CloserLook = new Text("Take a Closer Look");
		name.setStyle(PageTextStyle);
		grid.add(name, 0, 0);
		grid.setHalignment(name, HPos.CENTER);
		quantity.setStyle(PageTextStyle);
		grid.add(quantity, 1, 0);
		grid.setHalignment(quantity, HPos.CENTER);
		Todayschange.setStyle(PageTextStyle);
		grid.add(Todayschange, 2, 0);
		grid.setHalignment(Todayschange, HPos.CENTER);
		NetChange.setStyle(PageTextStyle);
		grid.add(NetChange, 3, 0);
		grid.setHalignment(NetChange, HPos.CENTER);
		CloserLook.setStyle(PageTextStyle);
		grid.add(CloserLook, 4, 0);
		grid.setHalignment(CloserLook, HPos.CENTER);
		
		for (int i = 0; i < person.getPortfolio().getPortfolioSize(); i++) {
			Text N = new Text(person.getPortfolio().GetStock(i).getName());
			Text Q = new Text(person.getPortfolio().GetStock(i).getShares());
			Text TC = new Text("+4");
			Text NC = new Text("+3");
			int bSizeX = 50, bSizeY = 15;
			Button b = new Button(">");
			
			N.setStyle(PageTextStyle);
			grid.setHalignment(N, HPos.CENTER);
			Q.setStyle(PageTextStyle);
			grid.setHalignment(Q, HPos.CENTER);
			TC.setStyle(PageTextStyle);
			grid.setHalignment(TC, HPos.CENTER);
			NC.setStyle(PageTextStyle);
			grid.setHalignment(NC, HPos.CENTER);
			b.setStyle(BaseButtonStyle);
			grid.setHalignment(b, HPos.CENTER);
			b.setPrefSize(bSizeX,bSizeY);
			HoverListener(b,BaseButtonStyle,HoverButtonStyle);
			int k = i;
			b.setOnAction(e -> LoadSpecificStockPage(person.getPortfolio().GetStock(k).getName(), person.getPortfolio().GetStock(k).getShares(), person.getPortfolio().GetStock(k).getPurchased()));
			
			grid.add(N, 0, i+1);
			grid.add(Q, 1, i+1);
			grid.add(TC, 2, i+1);
			grid.add(NC, 3, i+1);
			grid.add(b, 4, i+1);
			
		}

		grid.setAlignment(Pos.TOP_CENTER);
		rootmainScene.setCenter(grid);
		
		rootmainScene.setStyle("-fx-background-color: black");
		if (TimesinMainScene == 1)
			MainScene = new Scene(rootmainScene, InitialWidthScreen, InitialHeightScreen);
		window.setScene(MainScene);
	}	// Fix Date Things but besides that it works?
	
	public void EditPortfolio() {
		// Make Possible to Scroll Down Stocks

		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		TimesinEditPortfolioScene++;
		
		rootmainScene.setCenter(null);
		
		BorderPane root = new BorderPane();
		VBox Top = new VBox(15);
		Top.setAlignment(Pos.CENTER);
		BorderPane SubTopRight = new BorderPane(), SubTopCenter = new BorderPane();
		SubTopRight.setPadding(new Insets(15, 15, 15, 15));
		VBox stocks = new VBox(5);
		
		int StocksInPorfolio = 0;
		
		int ContinueButtonSizeX = 150,ContinueButtonSizeY = 45;
		Button Continue = new Button("Done");
		Continue.setStyle(BaseButtonStyle);
		Continue.setPrefSize(ContinueButtonSizeX, ContinueButtonSizeY);
		HoverListener(Continue,BaseButtonStyle,HoverButtonStyle);
		SubTopRight.setRight(Continue);
		Top.getChildren().add(SubTopRight);
		Continue.setOnAction(e -> UpDatePortfolio(stocks));
		
		Text Header = new Text("Edit Portfolio");
		Header.setStyle(HeaderTextStyle);
		SubTopCenter.setCenter(Header);
		Top.getChildren().add(SubTopCenter);
		
		root.setTop(Top);
		
		LoadStocksInEditPortfolio(stocks);

		root.setCenter(stocks);
		root.setStyle("-fx-background-color: black");
		if (TimeinOnboardScene == 1)
			EditPortfolioScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		window.setScene(EditPortfolioScene);
	}	
	
	public void LoadStocksInEditPortfolio(VBox stocks) {
		// Fix the boarder for adding another Stock so that it is trim to the input information
		// The Dates will not be initialized because wtf with formating
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String StockTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 25;";
		
		String StockBorder = "-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 4;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: white;";
		
		for (int a = 0; a < person.getPortfolio().getPortfolioSize(); a++) {
		
			HBox elements = new HBox(15);
			VBox STOCKS = new VBox(5);
			VBox AMOUNT = new VBox(5);
			VBox DATE = new VBox(5);
			HBox DateInput = new HBox(10);
			HBox Addbtn = new HBox();
			FlowPane rec = new FlowPane(10,10);
			
			// Name Text Parameters
			Text NameText = new Text("Stock Name");
			NameText.setStyle(StockTextStyle);
			NameText.toFront();
			
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
			StockNames.setValue(person.getPortfolio().GetStock(a).getName());
			
			// Quantity Text Parameters
			Text QuantityText = new Text("Amount Purchased");
			QuantityText.setStyle(StockTextStyle);
			QuantityText.toFront();
			
			// TextBox for Amount of Stocks	
			ComboBox<String> QuantityBox = new ComboBox<>();
			String[] Quantity = new String[1000];
			for (int j = 1; j <= 1000 ; j++) {
				QuantityBox.getItems().add(j+"");
			}
			QuantityBox.setValue(person.getPortfolio().GetStock(a).getShares());
			
			// Date Text Parameters;
			Text DatePurchasedText = new Text("Date Purchased");
			DatePurchasedText.setStyle(StockTextStyle);
			DatePurchasedText.toFront();
			
			//Delete Stock Button
			int DeleteButtonSizeX = 25,DeleteButtonSizeY = 25;
			Button Delete = new Button("x");
			Delete.setStyle(BaseButtonStyle);
			Delete.setPrefSize(DeleteButtonSizeX, DeleteButtonSizeY);
			Delete.setOnAction(e -> stocks.getChildren().remove(elements));
			HoverListener(Delete,BaseButtonStyle,HoverButtonStyle);
			
			// Month
			String[] Months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
			ComboBox<String> Month = new ComboBox<>();
			for (int i = 0; i < Months.length; i++) {
				Month.getItems().add(Months[i]);
			}
			//Month.setValue(person.getPortfolio().GetStock(a).getPurchased()

			// Day
			ComboBox<String> Day = new ComboBox<>();
			for (int j = 1; j <= 31 ; j++) {
				String k;
				if (j < 10)
					k = "0"+j;
				else 
					k = "" + j;
				Day.getItems().add(k);
			}
			
			// Year
			ComboBox<String> Year = new ComboBox<>();
			for (int k = 00; k <= 19 ; k++) {
				String j;
				if (k < 10)
					j = "0"+k;
				else 
					j = "" + k;
				Year.getItems().add(j);
			}
			
			DateInput.getChildren().addAll(Month,Day,Year);
			DateInput.setAlignment(Pos.CENTER);
			STOCKS.getChildren().addAll(NameText, StockNames);
			AMOUNT.getChildren().addAll(QuantityText, QuantityBox);
			DATE.getChildren().addAll(DatePurchasedText,DateInput);
			STOCKS.setAlignment(Pos.CENTER);
			AMOUNT.setAlignment(Pos.CENTER);
			DATE.setAlignment(Pos.CENTER);
			Delete.setAlignment(Pos.CENTER);
			elements.getChildren().addAll(STOCKS,AMOUNT,DATE, Delete);
			elements.setAlignment(Pos.CENTER);
			elements.setStyle(StockBorder);
			rec.getChildren().add(elements);
			stocks.getChildren().add(elements);
			
			if (a == person.getPortfolio().getPortfolioSize() - 1) {
				// adds next button
				Button AddButton = new Button("Add");
				int ButtonSizeX = 700,ButtonSizeY = 40;
				AddButton.setPrefSize(ButtonSizeX, ButtonSizeY);
				AddButton.setStyle(BaseButtonStyle);
				HoverListener(AddButton,BaseButtonStyle,HoverButtonStyle);
				AddButton.setOnAction(e -> AddAnotherStock(stocks, person.getPortfolio().getPortfolioSize()));
				Addbtn.getChildren().add(AddButton);
				Addbtn.setAlignment(Pos.CENTER);
				stocks.getChildren().add(Addbtn);
			}
		}
	}
	
	public void UpDatePortfolio (VBox AllStock) {
		// Update the portfolio in the DataBase
		// Check to make sure all fields are correct
		
		ArrayList<OwnedStock> Portfolio = new ArrayList<OwnedStock>();
		
		for (int i = 0; i < AllStock.getChildren().size() - 1; i++) {
			HBox a = (HBox) AllStock.getChildren().get(i);
			VBox b = (VBox) a.getChildren().get(0);
			ComboBox<String> names = (ComboBox<String>) b.getChildren().get(1);
			String name = names.getValue();
			VBox c = (VBox) a.getChildren().get(1);
			ComboBox<String> amounts = (ComboBox<String>) c.getChildren().get(1);
			String amount = amounts.getValue();
			VBox d = (VBox) a.getChildren().get(2);
			HBox e = (HBox) d.getChildren().get(1);
			ComboBox<String> days = (ComboBox<String>) e.getChildren().get(0);
			String day = days.getValue();
			ComboBox<String> months = (ComboBox<String>) e.getChildren().get(1);
			String month = months.getValue();
			ComboBox<String> years = (ComboBox<String>) e.getChildren().get(2);
			String year = years.getValue();
			
			Portfolio.add(new OwnedStock(name,name,amount,month+"/"+day+"/"+year));
			
		}
		
		person.setPortfolio(person.CreateNewPortfolio(Portfolio));
		LoadMainPage();
	}
	
	public void LoadMyAccountScene () {
		// Make look more professional
		// Add Rules for password
		
		rootmainScene.setCenter(null);
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		String BodyTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 25;";
		
		String TextFieldStyle = "-fx-font-family: Quicksand;"+
				"-fx-font-size: 18;"+
				"-fx-padding: 1,1,1,1;"+
				"-fx-border-color: white;"+
				"-fx-border-width: 2;"+
				"-fx-border-radius: 1;"+
				"-fx-border: gone;"+
				"-fx-background-color: transparent;"+
				"-fx-text-fill: white;";
		
		TimesinMyAccountScene++;
		
		// Formatting the Page
		BorderPane root = new BorderPane();
		VBox Top = new VBox(50);
		Top.setAlignment(Pos.CENTER);
		BorderPane SubTopLeft = new BorderPane();
		SubTopLeft.setPadding(new Insets(15, 0, 0, 15));
		HBox txtField1 = new HBox();
		HBox txtField2 = new HBox();
		HBox agebox = new HBox(30);
		
		// Back Button
		TextField NameBox = new TextField(person.getName());
		TextField PasswordBox = new TextField(person.getPassword());
		ComboBox <Integer> AgeSelection = new ComboBox<Integer>();
		int backButtonSizeX = 100,backButtonSizeY = 45;
		Button back = new Button("Back");
		back.setStyle(BaseButtonStyle);
		back.setPrefSize(backButtonSizeX, backButtonSizeY);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> leaveAccountPage(NameBox,AgeSelection,PasswordBox));
		SubTopLeft.setLeft(back);
		Top.getChildren().add(SubTopLeft);
		
		// Page Header
		Text Header = new Text("My Account");
		Header.setStyle(HeaderTextStyle);
		Top.getChildren().add(Header);
		
		// TextField for the UserName	
		NameBox.setPromptText("Please Enter your Name");
		int NameBoxSizeX = 600, NameBoxSizeY = 10;
		NameBox.setPrefSize(NameBoxSizeX, NameBoxSizeY);
		NameBox.setStyle(TextFieldStyle);
		NameBox.setAlignment(Pos.CENTER);
		txtField1.getChildren().add(NameBox);
		txtField1.setAlignment(Pos.CENTER);
		Top.getChildren().add(txtField1);
		
		// Text for the Age
		Text ageprompt = new Text("Please Enter Your Age: ");
		ageprompt.setStyle(BodyTextStyle);
		agebox.getChildren().add(ageprompt);
		
		// Age combobox
		for (int i = 1; i < 120; i++) {
			AgeSelection.getItems().add(i);
		}
		AgeSelection.setValue(1);
		agebox.getChildren().add(AgeSelection);
		agebox.setAlignment(Pos.CENTER);
		AgeSelection.setValue(person.getAge());
		Top.getChildren().add(agebox);
		
		// TextField for the Password	
		PasswordBox.setPromptText("Please Enter a Password");
		int PasswordBoxSizeX = 600, PasswordBoxSizeY = 10;
		PasswordBox.setPrefSize(PasswordBoxSizeX, PasswordBoxSizeY);
		PasswordBox.setStyle(TextFieldStyle);
		PasswordBox.setAlignment(Pos.CENTER);
		txtField2.getChildren().add(PasswordBox);
		txtField2.setAlignment(Pos.CENTER);
		Top.getChildren().add(txtField2);
		
		// Account Creation Button
		int SignInSizeX = 600,SignInSizeY = 45;
		Button SignInBtn = new Button("Update Account");
		SignInBtn.setStyle(BaseButtonStyle);
		SignInBtn.setPrefSize(SignInSizeX, SignInSizeY);
		HoverListener(SignInBtn,BaseButtonStyle,HoverButtonStyle);
		SignInBtn.setOnAction(e -> UpdateUser(Top,NameBox,AgeSelection,PasswordBox));
		Top.getChildren().add(SignInBtn);
		
		// Formatting stuff
		root.setTop(Top);
		root.setStyle("-fx-background-color: black");
		
		// Creates the Scene and loads it
		if (TimesinMyAccountScene == 1)
			MyAccountScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		window.setScene(MyAccountScene);
	}
	
	public void leaveAccountPage(TextField NameBox,ComboBox <Integer> AgeSelection, TextField PasswordBox) {
		AgeSelection.setValue(person.getAge());
		NameBox.setText(person.getName());
		PasswordBox.setText(person.getPassword());
		
		LoadMainPage();
	}	
	
	public void UpdateUser(VBox root,TextField NameBox,ComboBox <Integer> AgeSelection, TextField PasswordBox) {
		String ErrorTextStyle = "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 15;"+
			    "-fx-stroke: red";
		
		TimesUpdatingUser++;
		
		if (TimesUpdatingUser > 1) {
			if (root.getChildren().size() == 7)
				root.getChildren().remove(6);
		}
		
		if (NameBox.getText().trim().isEmpty() || PasswordBox.getText().trim().isEmpty()) {
			Text Error = new Text("You must fill out all the fields");
			Error.setStyle(ErrorTextStyle);
			root.getChildren().add(Error);
		}
		else if (AgeSelection.getValue() < 18) {
			Text Error = new Text("User must be 18 years or older");
			Error.setStyle(ErrorTextStyle);
			root.getChildren().add(Error);
		}
		else {
			// Update this in the DataBase
			person.setName(NameBox.getText());
			person.setAge(AgeSelection.getValue());
			person.setPassword(PasswordBox.getText());

			VBox top = (VBox) rootmainScene.getTop();
			Text name = (Text) top.getChildren().get(1);
			name.setText(person.getName()+"'s Portfolio");
			LoadMainPage();
		}
	}

	public void PortfolioAssesment() {
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 30;";
		
		TimesinPortfolioAssesmentScene++;
		
		rootmainScene.setCenter(null);
		
		BorderPane root = new BorderPane();
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15,15,15,15));
		
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		backbtn.setLeft(back);
		root.setTop(backbtn);
		
		Text UC = new Text("This Page is currently Under Construction");
		UC.setStyle(HeaderTextStyle);
		root.setCenter(UC);
		
		root.setStyle("-fx-background-color: black");
		if (TimesinPortfolioAssesmentScene == 1) {
			PortfolioAssesmentScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		}
		window.setScene(PortfolioAssesmentScene);
	}	

	// Still Gotta Get It to Work
	public void SearchAStock() {
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		String BodyTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 25;";
		
		TimesinSearchAStockScene++;
		
		rootmainScene.setCenter(null);
		
		BorderPane root = new BorderPane();
		VBox top = new VBox(10);
		top.setAlignment(Pos.CENTER);
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15, 15, 15, 15));
		
		ComboBox <String> OutLookSelection = new ComboBox<String>();
		ComboBox <String> SectorSelection = new ComboBox<String>();
		ComboBox <Double> PriceMin = new ComboBox<Double>();
		ComboBox <Double> PriceMax = new ComboBox<Double>();
		
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LeaveSearchAStock(OutLookSelection,SectorSelection,PriceMin,PriceMax));
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		Text Header = new Text("Search For A Stock");
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);
		
		VBox elements = new VBox(20);
		elements.setAlignment(Pos.CENTER);
		HBox textinput = new HBox(50);
		VBox text = new VBox(30);
		VBox input = new VBox(30);

		Text OL = new Text("Outlook: "), ST = new Text("Sector: "), PMin = new Text("Min Price: "), PMax = new Text("Max Price: ");
		OL.setStyle(BodyTextStyle);
		ST.setStyle(BodyTextStyle);
		PMin.setStyle(BodyTextStyle);
		PMax.setStyle(BodyTextStyle);
		text.getChildren().addAll(OL,ST,PMin,PMax);
		
		textinput.getChildren().add(text);
	
		// Add all of the possibilities
		OutLookSelection.getItems().addAll("3 Days", "1 Week", "1 Month", "3 Months");
		OutLookSelection.setValue("3 Days");
	
		// Add all of the possibilities
		SectorSelection.getItems().addAll("Telecommunication Services", "Financial Services", "Information Technology", "Materials", "HealthCare", "Utilities", "Real Estate", "Industrials", "Energy", "Consumer Staples", "Consumer Discretionary");
		SectorSelection.setValue("Telecommunication Services");

		for (double i = 0; i <= 3000; i++) {
			PriceMin.getItems().add(i);
			PriceMax.getItems().add(i);
		}
		PriceMin.setValue(0.0);
		PriceMax.setValue(3000.0);
		input.getChildren().addAll(OutLookSelection,SectorSelection,PriceMin,PriceMax);
		
		textinput.getChildren().add(input);
		textinput.setAlignment(Pos.CENTER);
		elements.getChildren().add(textinput);

		int SearchButtonSizeX = 150, SearchButtonSizeY = 45;
		Button search = new Button("Search");
		search.setPrefSize(SearchButtonSizeX, SearchButtonSizeY);
		search.setStyle(BaseButtonStyle);
		HoverListener(search,BaseButtonStyle,HoverButtonStyle);
		search.setOnAction(e -> SearchStocks(OutLookSelection.getValue(),SectorSelection.getValue(),PriceMin.getValue(),PriceMax.getValue()));
		elements.getChildren().add(search);
		
		// This is Da Grid
		GridPane grid = new GridPane();
		
		
		root.setTop(top);
		root.setCenter(elements);
		root.setStyle("-fx-background-color: black");
		if (TimesinSearchAStockScene == 1) {
			SearchAStockScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		}
		window.setScene(SearchAStockScene);
	}
	
	public void SearchStocks(String outlook, String sector, double min, double max) {
		// check some things before doind the search but it will do a search
	}
	
	public void LeaveSearchAStock(ComboBox <String> OutLookSelection, ComboBox <String> SectorSelection, ComboBox <Double> PriceMin, ComboBox <Double> PriceMax) {
		OutLookSelection.setValue("3 Days");
		SectorSelection.setValue("Telecommunication Services");
		PriceMin.setValue(0.0);
		PriceMax.setValue(3000.0);
		
		// Also Unload Searched Stocks
		
		LoadMainPage();
	}
	
	public void LoadMarketAssesment() {
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		String PageTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;";
		
		TimesinMarketAssesmentScene++;
		
		rootmainScene.setCenter(null);
		
		BorderPane root = new BorderPane();
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15,15,15,15));
		VBox top = new VBox();
		top.setAlignment(Pos.CENTER);
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		Text Header = new Text("Market Assesment");
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);
		
		root.setTop(top);
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(15);
		grid.setPadding(new Insets(50, 10, 10, 10));
		Text day = new Text("Day");
		day.setStyle(PageTextStyle);
		grid.add(day, 1,0);
		Text week = new Text("Week");
		week.setStyle(PageTextStyle);
		grid.add(week, 2,0);
		Text month = new Text("Month");
		month.setStyle(PageTextStyle);
		grid.add(month, 3,0);
		Text ytd = new Text("Year to Date");
		ytd.setStyle(PageTextStyle);
		grid.add(ytd, 4,0);
		
		grid.setAlignment(Pos.TOP_CENTER);
		root.setCenter(grid);
		
		// Just add information here and greed/red thing
		
		root.setStyle("-fx-background-color: black");
		if (TimesinMarketAssesmentScene == 1) {
			MarketAssesmentScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		}
		window.setScene(MarketAssesmentScene);
	}

	public void LoadSpecificStockPage(String name, String amount, Date Date) {
		
		String BackButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String BackHoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 20;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		String PageTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		String TextFieldStyle = "-fx-font-family: Quicksand;"+
				"-fx-font-size: 18;"+
				"-fx-padding: 1,1,1,1;"+
				"-fx-border-color: white;"+
				"-fx-border-width: 2;"+
				"-fx-border-radius: 1;"+
				"-fx-border: white;"+
				"-fx-background-color: transparent;"+
				"-fx-text-fill: white;";
		
		TimesinSpecificStockScene++;
		
		rootmainScene.setCenter(null);
		
		BorderPane root = new BorderPane();
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15,15,15,15));
		VBox top = new VBox();
		top.setAlignment(Pos.CENTER);
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BackButtonStyle);
		HoverListener(back,BackButtonStyle,BackHoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		Text Header = new Text(name);
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);

		VBox info = new VBox();
		HBox outlookforGraph = new HBox(25);
		outlookforGraph.setAlignment(Pos.CENTER);
		
		Text OL = new Text("Outlook:");
		OL.setStyle(PageTextStyle);
		
		ComboBox <String> OutLookSelection = new ComboBox<String>();
		OutLookSelection.getItems().addAll("3 Days", "1 Week", "1 Month", "3 Months");
		OutLookSelection.setValue("3 Days");
		
		int SubmitButtonSizeX = 120,SubmitButtonSizeY = 35;
		Button submit = new Button("Submit");
		submit.setPrefSize(SubmitButtonSizeX, SubmitButtonSizeY);
		submit.setStyle(BackButtonStyle);
		HoverListener(submit,BackButtonStyle,BackHoverButtonStyle);
		//submit.setOnAction(e -> True);
		
		outlookforGraph.getChildren().addAll(OL,OutLookSelection,submit);
		info.getChildren().add(outlookforGraph);
		
		// Graph Should Go here
		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        yAxis.setLabel("Dollars");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle(name+"'s Graph");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        
        lineChart.getData().add(series);
        lineChart.setPrefSize(500, 300);
        
        info.getChildren().add(lineChart);
		
        TextField populate = new TextField();
        HBox btns = new HBox(15);
        int LearningButtonSizeX = 150,LearningButtonSizeY = 45;
        Button PCBTN = new Button("Previous \nClose"), ThreeMRBTN = new Button("Three Month \nRange"), PEBTN = new Button("Price to \nEarnings Ratio"), MMBTN = new Button("Market \nMomentum"), RSIBTN = new Button("Relative \nStrength Index"), EMABTN = new Button("Exponential \nMoving Average"), OurRecBTN = new Button("Our \nReccomendation");
        PCBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        PCBTN.setStyle(BaseButtonStyle);
        HoverListener(PCBTN,BaseButtonStyle,HoverButtonStyle);
        PCBTN.setOnAction(e -> populate.setText("e"));
        ThreeMRBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        ThreeMRBTN.setStyle(BaseButtonStyle);
        HoverListener(ThreeMRBTN,BaseButtonStyle,HoverButtonStyle);
        ThreeMRBTN.setOnAction(e -> populate.setText("a"));
        PEBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        PEBTN.setStyle(BaseButtonStyle);
        HoverListener(PEBTN,BaseButtonStyle,HoverButtonStyle);
        PEBTN.setOnAction(e -> populate.setText("b"));
        MMBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        MMBTN.setStyle(BaseButtonStyle);
        HoverListener(MMBTN,BaseButtonStyle,HoverButtonStyle);
        MMBTN.setOnAction(e -> populate.setText("OFsadc"));
        RSIBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        RSIBTN.setStyle(BaseButtonStyle);
        HoverListener(RSIBTN,BaseButtonStyle,HoverButtonStyle);
        RSIBTN.setOnAction(e -> populate.setText("D"));
        EMABTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        EMABTN.setStyle(BaseButtonStyle);
        HoverListener(EMABTN,BaseButtonStyle,HoverButtonStyle);
        EMABTN.setOnAction(e -> populate.setText("CMSAC"));
        OurRecBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        OurRecBTN.setStyle(BaseButtonStyle);
        HoverListener(OurRecBTN,BaseButtonStyle,HoverButtonStyle);
        OurRecBTN.setOnAction(e -> populate.setText("Michael"));
        btns.getChildren().addAll(PCBTN,ThreeMRBTN,PEBTN,MMBTN,RSIBTN,EMABTN,OurRecBTN);
        btns.setAlignment(Pos.CENTER);
        
        info.getChildren().add(btns);
        
        int sizeX = 100, SizeY = 200;
		populate.setPrefSize(sizeX, SizeY);
		populate.setStyle(TextFieldStyle);
		info.getChildren().add(populate);
		
		//info.getChildren().addAll(PC,ThreeMR,PE,MM,RSI,EMA,OurRec,News);
		//SSroot.setLeft(SubrootParameters);
		
		/*
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
		*/
		
		root.setCenter(info);
		root.setTop(top);
		
		root.setStyle("-fx-background-color: black");
		if (TimesinSpecificStockScene == 1)
			SpecificStockScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		else 
			SpecificStockScene.setRoot(root);
		window.setScene(SpecificStockScene);
		
	}
	
	public void LoadIndividualStockAssesmentOnboard() {
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 50;";
		
		String BodyTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 25;";
		
		TimeinIndividualStockAssesmentOnboardScene++;
		
		rootmainScene.setCenter(null);
		
		BorderPane root = new BorderPane();
		VBox top = new VBox(10);
		top.setAlignment(Pos.CENTER);
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15, 15, 15, 15));
		
		ComboBox <String> OutLookSelection = new ComboBox<String>();
		ComboBox <String> StockNames = new ComboBox<String>();
		
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		Text Header = new Text("Load Information");
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);
		
		VBox elements = new VBox(20);
		elements.setAlignment(Pos.CENTER);
		HBox textinput = new HBox(50);
		VBox text = new VBox(30);
		VBox input = new VBox(30);

		Text OL = new Text("Outlook: "), STOCK = new Text("Stock Name: ");
		OL.setStyle(BodyTextStyle);
		STOCK.setStyle(BodyTextStyle);
		text.getChildren().addAll(OL,STOCK);
		
		textinput.getChildren().add(text);
	
		// Add all of the possibilities
		OutLookSelection.getItems().addAll("3 Days", "1 Week", "1 Month", "3 Months");
		OutLookSelection.setValue("3 Days");
		input.getChildren().add(OutLookSelection);
	
		String[] SN = null;
		try {
			SN = OpenFile("TopUSCompanies.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StockNames.setTooltip(new Tooltip());
		StockNames.getItems().addAll(SN);
		new ComboBoxSearcher<String>(StockNames);
		input.getChildren().add(StockNames);
		StockNames.setValue("Apple");
		
		textinput.getChildren().add(input);
		textinput.setAlignment(Pos.CENTER);
		elements.getChildren().add(textinput);

		int SearchButtonSizeX = 150, SearchButtonSizeY = 45;
		Button search = new Button("Do Yo thang");
		search.setPrefSize(SearchButtonSizeX, SearchButtonSizeY);
		search.setStyle(BaseButtonStyle);
		HoverListener(search,BaseButtonStyle,HoverButtonStyle);
		search.setOnAction(e -> LoadIndividualStockAssesment(OutLookSelection.getValue(),StockNames.getValue()));
		elements.getChildren().add(search);
		
		root.setTop(top);
		root.setCenter(elements);
		root.setStyle("-fx-background-color: black");
		
		if (TimeinIndividualStockAssesmentOnboardScene == 1)
			IndividualStockAssesmentOnboardScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		else 
			IndividualStockAssesmentOnboardScene.setRoot(root);
		
		window.setScene(IndividualStockAssesmentOnboardScene);
	}
	
	public void LoadIndividualStockAssesment(String Outlook, String Name){	
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;"+
			    "-fx-vertical-align:middle;";
		
		String HoverButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String HeaderTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 30;";
		
		String PageTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 10;";
		
		String TextFieldStyle = "-fx-font-family: Quicksand;"+
				"-fx-font-size: 18;"+
				"-fx-padding: 1,1,1,1;"+
				"-fx-border-color: white;"+
				"-fx-border-width: 2;"+
				"-fx-border-radius: 1;"+
				"-fx-border: white;"+
				"-fx-background-color: transparent;"+
				"-fx-text-fill: white;";
		
		TimesinIndividualStockAssesmentScene++;
		
		rootmainScene.setCenter(null);
		
		BorderPane root = new BorderPane();
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15,15,15,15));
		VBox top = new VBox();
		top.setAlignment(Pos.CENTER);
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LoadIndividualStockAssesmentOnboard());
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		Text Header = new Text(Name+"'s Stock Assesment");
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);
		
		root.setTop(top);
		
		Text arrow1 = new Text("-->"), arrow2 = new Text("-->"), arrow3 = new Text("-->"), arrow4 = new Text("-->"),  arrow5 = new Text("-->"), arrow6 = new Text("-->");
		arrow1.setStyle(PageTextStyle);
		arrow2.setStyle(PageTextStyle);
		arrow3.setStyle(PageTextStyle);
		arrow4.setStyle(PageTextStyle);
		arrow5.setStyle(PageTextStyle);
		arrow6.setStyle(PageTextStyle);
		
		int textfieldSizeX = 300,textfieldSizeY = 300;
		TextField populate = new TextField();
		populate.setPrefSize(textfieldSizeX,textfieldSizeY);
		populate.setText("Introduction");
		populate.setStyle(TextFieldStyle);
		VBox center = new VBox(20);
		center.setAlignment(Pos.CENTER);
        HBox btns = new HBox(0);
        int LearningButtonSizeX = 150,LearningButtonSizeY = 45;
        Button PCBTN = new Button("Previous \nClose"), ThreeMRBTN = new Button("Three Month \nRange"), PEBTN = new Button("Price to \nEarnings Ratio"), MMBTN = new Button("Market \nMomentum"), RSIBTN = new Button("Relative \nStrength Index"), EMABTN = new Button("Exponential \nMoving Average"), OurRecBTN = new Button("Our \nReccomendation");
        Button btnarr[] = {PCBTN,ThreeMRBTN,PEBTN,MMBTN,RSIBTN,EMABTN,OurRecBTN};
        
        PCBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        PCBTN.setStyle(BaseButtonStyle);
        ThreeMRBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        ThreeMRBTN.setStyle(BaseButtonStyle);
        PEBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        PEBTN.setStyle(BaseButtonStyle);
        MMBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        MMBTN.setStyle(BaseButtonStyle);
        RSIBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        RSIBTN.setStyle(BaseButtonStyle);
        EMABTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        EMABTN.setStyle(BaseButtonStyle);
        OurRecBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        OurRecBTN.setStyle(BaseButtonStyle);
        btns.getChildren().addAll(PCBTN,arrow1,ThreeMRBTN,arrow2,PEBTN,arrow3,MMBTN,arrow4,RSIBTN,arrow5,EMABTN,arrow6,OurRecBTN);
        btns.setAlignment(Pos.CENTER);
        center.getChildren().addAll(btns,populate);
        
        int LearningButtonSizex = 300,LearningButtonSizey = 75;
        Button learningButton = new Button("Click to Learn");
        learningButton.setPrefSize(LearningButtonSizex,LearningButtonSizey);
        learningButton.setStyle(BaseButtonStyle);
        HoverListener(learningButton,BaseButtonStyle,HoverButtonStyle);
        learningButton.setOnAction(e -> PC(learningButton, btnarr, populate));
        center.getChildren().add(learningButton);
        
        root.setCenter(center);
		
		root.setStyle("-fx-background-color: black");
		if (TimesinIndividualStockAssesmentScene == 1)
			IndividualStockAssesmentScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		else
			IndividualStockAssesmentScene.setRoot(root);
		
		window.setScene(IndividualStockAssesmentScene);
	}	
	
	public void PC(Button learningButton, Button btnarr[], TextField populate) {
		String SelectedButtonStyle ="-fx-text-fill: yellow;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:yellow;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		
		btnarr[0].setStyle(SelectedButtonStyle);
		populate.setText("PC");
		learningButton.setOnAction(e -> ThreeMR(learningButton,btnarr,populate));
	}
	
	public void ThreeMR (Button learningButton, Button btnarr[], TextField populate) {
		String SelectedButtonStyle ="-fx-text-fill: yellow;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:yellow;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		btnarr[0].setStyle(BaseButtonStyle);
		btnarr[1].setStyle(SelectedButtonStyle);
		populate.setText("ThreeMR");
		learningButton.setOnAction(e -> PE(learningButton,btnarr,populate));
	}
	
	public void PE(Button learningButton, Button btnarr[], TextField populate) {
		String SelectedButtonStyle ="-fx-text-fill: yellow;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:yellow;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		btnarr[1].setStyle(BaseButtonStyle);
		btnarr[2].setStyle(SelectedButtonStyle);
		populate.setText("PE");
		learningButton.setOnAction(e -> MM(learningButton,btnarr,populate));
	}
	
	public void MM(Button learningButton, Button btnarr[], TextField populate) {
		String SelectedButtonStyle ="-fx-text-fill: yellow;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:yellow;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		btnarr[2].setStyle(BaseButtonStyle);
		btnarr[3].setStyle(SelectedButtonStyle);
		populate.setText("MM");
		learningButton.setOnAction(e -> RSI(learningButton,btnarr,populate));
	}
	
	public void RSI(Button learningButton, Button btnarr[], TextField populate) {
		String SelectedButtonStyle ="-fx-text-fill: yellow;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:yellow;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		btnarr[3].setStyle(BaseButtonStyle);
		btnarr[4].setStyle(SelectedButtonStyle);
		populate.setText("RSI");
		learningButton.setOnAction(e -> EMA(learningButton,btnarr,populate));
	}
	
	public void EMA(Button learningButton, Button btnarr[], TextField populate) {
		String SelectedButtonStyle ="-fx-text-fill: yellow;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:yellow;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		btnarr[4].setStyle(BaseButtonStyle);
		btnarr[5].setStyle(SelectedButtonStyle);
		populate.setText("EMA");
		learningButton.setOnAction(e -> Conc(learningButton,btnarr,populate));
	}
	
	public void Conc(Button learningButton, Button btnarr[], TextField populate) {
		
		String SelectedButtonStyle ="-fx-text-fill: yellow;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:yellow;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		String BaseButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";
		
		btnarr[5].setStyle(BaseButtonStyle);
		btnarr[6].setStyle(SelectedButtonStyle);
		populate.setText("Conclusion");
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
