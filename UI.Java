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
	int TimesinStartScene = 0, TimesinLoginScene = 0, TimesinSignUpScene = 0, TimesCreatingUser = 0, TimeinOnboardScene = 0, TimesinMainScene = 0,TimesinEditPortfolioScene = 0, TimesinMyAccountScene = 0, TimesUpdatingUser = 0, TimesinSpecificStockScene = 0, TimeinIndividualStockAssesmentOnboardScene = 0, TimesinIndividualStockAssesmentScene = 0, TimesinPortfolioAssesmentScene = 0, TimesinSearchAStockScene = 0,TimeSearchingStock = 0, TimesinMarketAssesmentScene = 0;
	
	// This is the window that the user sees
	Stage window;
	
	// Objects
	User person;
	LearningTool learningtool;
	UserManager manage;
	OwnedStock stock;
	StockImporter imports;

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

		// Text Styles
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
		
		// TextFields
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
		SignInBtn.setOnAction(e -> CheckUser(Top, NameBox.getText(), PasswordBox.getText()));
		btns.getChildren().add(SignInBtn);
		
		// New Account Button
		int NewAccountSizeX = 300,NewAccountSizeY = 45;
		Button NewAccount = new Button("Create a new account");
		NewAccount.setStyle(BaseButtonStyle);
		NewAccount.setPrefSize(NewAccountSizeX, NewAccountSizeY);
		HoverListener(NewAccount,BaseButtonStyle,HoverButtonStyle);
		NewAccount.setOnAction(e -> LeaveSignInNewAccount(NameBox, PasswordBox));
		btns.getChildren().add(NewAccount);
		
		// Formatting the page
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

	// Updates page after leaving the sign in scene
	public void LeaveSignInback(TextField Name, TextField Password) {
		Name.clear();
		Password.clear();
		window.setScene(StartScene);
	}
	
	// Updates page after leaving the sign in scene
	public void LeaveSignInNewAccount(TextField Name, TextField Password) {
		Name.clear();
		Password.clear();
		LoadSignUpScene();
	}
	
	// Tries to load the user user
	public void CheckUser(VBox top, String name, String Password) {
		
		String ErrorTextStyle = "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 15;"+
			    "-fx-stroke: red";
		
		// Checks for User
		if (UserManager.checkUser(name,Password)) {
			person = UserManager.Login(name,Password);
			LoadMainPage();
		}
		// if no User, a prompt appears
		else {
			Text Error = new Text("User does not exsist");
			Error.setStyle(ErrorTextStyle);
			top.getChildren().add(Error);
		}
	}

	// Loads the SignUp Scene
	public void LoadSignUpScene() {
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
	
	// Updates page after leaving the Sign up scene
	public void LeaveSignUpPage(TextField name, ComboBox <Integer> AgeSelection, TextField password) {
		name.clear();
		password.clear();
		AgeSelection.setValue(1);
		window.setScene(LoginScene);
	}
		
	// Checks if the User has input all valid selections into the Fields
	public void CreateUser(VBox root,TextField NameBox,ComboBox <Integer> AgeSelection, TextField PasswordBox) {
		
		// text style
		String ErrorTextStyle = "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 15;"+
			    "-fx-stroke: red";
		
		TimesCreatingUser++;
		
		// removes the previous error if there was one
		if (TimesCreatingUser != 1)
			root.getChildren().remove(root.getChildren().size()-1);
		
		// checks for all fields being completed
		if (NameBox.getText().trim().isEmpty() || PasswordBox.getText().trim().isEmpty()) {
			Text Error = new Text("You must fill out all the fields");
			Error.setStyle(ErrorTextStyle);
			root.getChildren().add(Error);
		}
		
		// checks for age verification
		else if (AgeSelection.getValue() < 18) {
			Text Error = new Text("User must be 18 years or older");
			Error.setStyle(ErrorTextStyle);
			root.getChildren().add(Error);
		}
		// else creates the user
		else {
			person = new User(NameBox.getText(),AgeSelection.getValue(),PasswordBox.getText());
			LoadOnboardPage();
		}
	}

	// Lets the User enter their portfolio
	public void LoadOnboardPage() {

		// styling the page
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
		
		// formating the page
		BorderPane root = new BorderPane();
		VBox Top = new VBox(15);
		Top.setAlignment(Pos.CENTER);
		BorderPane SubTopRight = new BorderPane(), SubTopCenter = new BorderPane();
		SubTopRight.setPadding(new Insets(15, 15, 15, 15));
		VBox stocks = new VBox(5);
		
		// local variable
		int StocksInPorfolio = 0;
		
		// continue button
		int ContinueButtonSizeX = 150,ContinueButtonSizeY = 45;
		Button Continue = new Button("Continue");
		Continue.setStyle(BaseButtonStyle);
		Continue.setPrefSize(ContinueButtonSizeX, ContinueButtonSizeY);
		HoverListener(Continue,BaseButtonStyle,HoverButtonStyle);
		SubTopRight.setRight(Continue);
		Top.getChildren().add(SubTopRight);
		Continue.setOnAction(e -> CheckStocks(stocks));
		
		// heasder
		Text Header = new Text("Onboard Portfolio");
		Header.setStyle(HeaderTextStyle);
		SubTopCenter.setCenter(Header);
		Top.getChildren().add(SubTopCenter);
		
		root.setTop(Top);
		
		// adds the first stock Onboard to the scene
		if (TimeinOnboardScene == 1)
			AddAnotherStock(stocks, StocksInPorfolio);

		// formating
		root.setCenter(stocks);
		root.setStyle("-fx-background-color: black");
		if (TimeinOnboardScene == 1)
			OnBoardScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		window.setScene(OnBoardScene);
	}

	// Adds another stock to be added to the portfolio
	public void AddAnotherStock(VBox stocks, int StocksInPorfolio){
		
		// styling of page
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
		
		// formating of page
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
		StockDatabase data = new StockDatabase();
		ComboBox<String> StockNames = new ComboBox<>();
		StockNames.setTooltip(new Tooltip());
		StockNames.getItems().addAll(data.getAllStockNames());
		new ComboBoxSearcher<String>(StockNames);
		StockNames.getSelectionModel().selectFirst();
		
		// Quantity Text Parameters
		Text QuantityText = new Text("Amount Purchased");
		QuantityText.setStyle(StockTextStyle);
		QuantityText.toFront();
		
		// TextBox for Amount of Stocks	
		ComboBox<Integer> QuantityBox = new ComboBox<>();
		for (int j = 1; j <= 1000 ; j++) {
			QuantityBox.getItems().add(j);
		}
		QuantityBox.getSelectionModel().selectFirst();
		
		// Date Text Parameters;
		Text DatePurchasedText = new Text("Date Purchased(MM,DD,YY)");
		DatePurchasedText.setStyle(StockTextStyle);
		DatePurchasedText.toFront();
		
		//Delete Stock Button
		int DeleteButtonSizeX = 25,DeleteButtonSizeY = 25;
		Button Delete = new Button("x");
		Delete.setStyle(BaseButtonStyle);
		Delete.setPrefSize(DeleteButtonSizeX, DeleteButtonSizeY);
		Delete.setOnAction(e -> stocks.getChildren().remove(elements));
		HoverListener(Delete,BaseButtonStyle,HoverButtonStyle);
		
		// Month selection
		String[] Months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		ComboBox<String> Month = new ComboBox<>();
		for (int i = 0; i < Months.length; i++) {
			Month.getItems().add(Months[i]);
		}
		Month.getSelectionModel().selectFirst();
		
		// Day selection 
		ComboBox<String> Day = new ComboBox<>();
		for (int j = 1; j <= 31 ; j++) {
			String k;
			if (j < 10)
				k = "0"+j;
			else 
				k = "" + j;
			Day.getItems().add(k);
		}
		Day.getSelectionModel().selectFirst();

		
		// Year selection
		ComboBox<String> Year = new ComboBox<>();
		for (int k = 14; k <= 19 ; k++) {
			String j;
			if (k < 10)
				j = "0"+k;
			else 
				j = "" + k;
			Year.getItems().add(j);
		}
		Year.getSelectionModel().selectFirst();

		
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
		
		// lots of formating 
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
	
	// Checks that all the stocks are valid and then adds the portfolio to the user database
	public void CheckStocks(VBox AllStock) {		
		
		// create a portfolio variable
		ArrayList<OwnedStock> Portfolio = new ArrayList<OwnedStock>();
		
		// checks every stock the user entered
		for (int i = 0; i < AllStock.getChildren().size() - 1; i++) {
			HBox a = (HBox) AllStock.getChildren().get(i);
			VBox b = (VBox) a.getChildren().get(0);
			ComboBox<String> names = (ComboBox<String>) b.getChildren().get(1);
			String name = names.getValue();
			VBox c = (VBox) a.getChildren().get(1);
			ComboBox<Integer> amounts = (ComboBox<Integer>) c.getChildren().get(1);
			int amount = amounts.getValue();
			VBox d = (VBox) a.getChildren().get(2);
			HBox e = (HBox) d.getChildren().get(1);
			ComboBox<String> days = (ComboBox<String>) e.getChildren().get(1);
			String day = days.getValue();
			ComboBox<String> months = (ComboBox<String>) e.getChildren().get(0);
			String month = months.getValue();
			ComboBox<String> years = (ComboBox<String>) e.getChildren().get(2);
			String year = years.getValue();
			
			Portfolio.add(new OwnedStock(name,name,amount,month,day,year));
			
		}
		person.createPortfolio(Portfolio);
		UserManager.addUser(person.getName(), person.getPassword(), person.getAge(), person.getPortfolio());
		LoadMainPage();
	}
		
	// The main page of the program
	public void LoadMainPage() {
		
		// Styling for the main page
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
		
		String GreenTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: green;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 22;";
		
		String RedTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: red;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 22;";
		
		TimesinMainScene++;
		
		// This doesnt change from the main page
		if (TimesinMainScene == 1) {
			// Formating
			VBox top = new VBox(10);
			BorderPane topbtn = new BorderPane(), header = new BorderPane();
			topbtn.setPadding(new Insets(15, 15, 15, 15));
			HBox btns = new HBox(15);
			
			// Edit portfolio button
			int EditPortFolioButtonSizeX = 200,EditPortFolioButtonSizeY = 45;
			Button EditPortFolio = new Button("Edit Portfolio");
			EditPortFolio.setStyle(BaseButtonStyle);
			EditPortFolio.setPrefSize(EditPortFolioButtonSizeX, EditPortFolioButtonSizeY);
			HoverListener(EditPortFolio,BaseButtonStyle,HoverButtonStyle);
			topbtn.setLeft(EditPortFolio);
			EditPortFolio.setOnAction(e -> EditPortfolio());
			
			// Editer Personal information
			int EditPersonalButtonSizeX = 200,EditPersonalButtonSizeY = 45;
			Button EditPersonal = new Button("My Account");
			EditPersonal.setStyle(BaseButtonStyle);
			EditPersonal.setPrefSize(EditPersonalButtonSizeX, EditPersonalButtonSizeY);
			HoverListener(EditPersonal,BaseButtonStyle,HoverButtonStyle);
			topbtn.setRight(EditPersonal);
			top.getChildren().add(topbtn);
			EditPersonal.setOnAction(e -> LoadMyAccountScene());
			
			// Header
			Text BlanksPortfolio = new Text(person.getName()+"'s Portfolio");
			BlanksPortfolio.setLayoutY(50);
			BlanksPortfolio.setLayoutX(InitialWidthScreen/2 - 200);
			BlanksPortfolio.setStyle(HeaderTextStyle);
			top.getChildren().add(BlanksPortfolio);
			top.setAlignment(Pos.CENTER);
			
			// Seperator for the buttons
			Separator separator1 = new Separator();
			top.getChildren().add(separator1);
			
			// Vertical seperators
			Separator sep1 = new Separator(), sep2 = new Separator(), sep3 = new Separator();
			sep1.setOrientation(Orientation.VERTICAL);
			sep2.setOrientation(Orientation.VERTICAL);
			sep3.setOrientation(Orientation.VERTICAL);
			
			// Buttons for stock analysis 
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
			
			// Seperators for the buttons
			Separator separator2 = new Separator();
			top.getChildren().add(separator2);
			
			rootmainScene.setTop(top);
		}
		
		//  grid for portfolio
		GridPane grid = new GridPane(); 
		grid.setPadding(new Insets(30, 10, 10, 10)); 
		grid.setVgap(10); 
	    grid.setHgap(40);
	
	    // Text for grids
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
		
		// Loads the stocks in the portfolio locally
		for (int i = 0; i < person.getPortfolio().getPortfolioSize(); i++) {
			MetricCalculator data = new MetricCalculator(person.getPortfolio().GetStock(i).getName(), "3 Days");
			DecimalFormat df = new DecimalFormat("###.###");
			
			Text N = new Text(person.getPortfolio().GetStock(i).getName());
			Text Q = new Text(person.getPortfolio().GetStock(i).getShares()+"");
			Text TC = new Text("$"+df.format(data.getTodayChange(person.getPortfolio().GetStock(i).getShares()))+"");
			Text NC = new Text("$"+df.format(data.getNetChange(person.getPortfolio().GetStock(i).getMonth()+"/"+person.getPortfolio().GetStock(i).getDay()+"/20"+person.getPortfolio().GetStock(i).getYear(),person.getPortfolio().GetStock(i).getShares()))+"");
			int bSizeX = 50, bSizeY = 15;
			Button b = new Button(">");
			
			N.setStyle(PageTextStyle);
			grid.setHalignment(N, HPos.CENTER);
			Q.setStyle(PageTextStyle);
			grid.setHalignment(Q, HPos.CENTER);
			if (data.getTodayChange(person.getPortfolio().GetStock(i).getShares()) > 0)
				TC.setStyle(GreenTextStyle);
			else 
				TC.setStyle(RedTextStyle);
			grid.setHalignment(TC, HPos.CENTER);
			if (data.getNetChange(person.getPortfolio().GetStock(i).getMonth()+"/"+person.getPortfolio().GetStock(i).getDay()+"/20"+person.getPortfolio().GetStock(i).getYear(),person.getPortfolio().GetStock(i).getShares()) > 0)
				NC.setStyle(GreenTextStyle);
			else 
				NC.setStyle(RedTextStyle);
			grid.setHalignment(NC, HPos.CENTER);
			b.setStyle(BaseButtonStyle);
			grid.setHalignment(b, HPos.CENTER);
			b.setPrefSize(bSizeX,bSizeY);
			HoverListener(b,BaseButtonStyle,HoverButtonStyle);
			int k = i;
			b.setOnAction(e -> LoadSpecificStockPage(person.getPortfolio().GetStock(k).getName(), person.getPortfolio().GetStock(k).getShares(),"3 Days"));
			
			grid.add(N, 0, i+1);
			grid.add(Q, 1, i+1);
			grid.add(TC, 2, i+1);
			grid.add(NC, 3, i+1);
			grid.add(b, 4, i+1);
			
		}

		// centers the grid
		grid.setAlignment(Pos.TOP_CENTER);
		rootmainScene.setCenter(grid);
		
		// sets the background of the scene to black
		rootmainScene.setStyle("-fx-background-color: black");
		if (TimesinMainScene == 1)
			MainScene = new Scene(rootmainScene, InitialWidthScreen, InitialHeightScreen);
		window.setScene(MainScene);
	}
	
	// Editing the Portfolio from the main page
	public void EditPortfolio() {

		// Styling the text
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
		
		// Formating 
		rootmainScene.setCenter(null);
		BorderPane root = new BorderPane();
		VBox Top = new VBox(15);
		Top.setAlignment(Pos.CENTER);
		BorderPane SubTopRight = new BorderPane(), SubTopCenter = new BorderPane();
		SubTopRight.setPadding(new Insets(15, 15, 15, 15));
		VBox stocks = new VBox(5);
		
		// Continue Button
		int ContinueButtonSizeX = 150,ContinueButtonSizeY = 45;
		Button Continue = new Button("Done");
		Continue.setStyle(BaseButtonStyle);
		Continue.setPrefSize(ContinueButtonSizeX, ContinueButtonSizeY);
		HoverListener(Continue,BaseButtonStyle,HoverButtonStyle);
		SubTopRight.setRight(Continue);
		Top.getChildren().add(SubTopRight);
		Continue.setOnAction(e -> UpDatePortfolio(stocks));
		
		// Header for page
		Text Header = new Text("Edit Portfolio");
		Header.setStyle(HeaderTextStyle);
		SubTopCenter.setCenter(Header);
		Top.getChildren().add(SubTopCenter);
		root.setTop(Top);
			
		// Adds stocks to the porftolio
		LoadStocksInEditPortfolio(stocks);
		root.setCenter(stocks);
		root.setStyle("-fx-background-color: black");

		// Checks if its the first time in the 
		if (TimesinEditPortfolioScene == 1)
			EditPortfolioScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		window.setScene(EditPortfolioScene);
	}	
	
	// creates a new stock in the portfolio
	public void LoadStocksInEditPortfolio(VBox stocks) {
		
		// Text Style
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
		
		// Loads a new stocks
		for (int a = 0; a < person.getPortfolio().getPortfolioSize(); a++) {

			// formating
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
			
			// calls from the stock database to 
			StockDatabase data = new StockDatabase();
			ComboBox<String> StockNames = new ComboBox<>();
			StockNames.setTooltip(new Tooltip());
			StockNames.getItems().addAll(data.getAllStockNames());
			new ComboBoxSearcher<String>(StockNames);
			StockNames.getSelectionModel().selectFirst();
			
			// Quantity Text Parameters
			Text QuantityText = new Text("Amount Purchased");
			QuantityText.setStyle(StockTextStyle);
			QuantityText.toFront();
			
			// TextBox for Amount of Stocks	
			ComboBox<Integer> QuantityBox = new ComboBox<>();
			String[] Quantity = new String[1000];
			for (int j = 1; j <= 1000 ; j++) {
				QuantityBox.getItems().add(j);
			}
			QuantityBox.setValue(person.getPortfolio().GetStock(a).getShares());
			
			// Date Text Parameters;
			Text DatePurchasedText = new Text("Date Purchased(MM,DD,YY)");
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
			Month.setValue(person.getPortfolio().GetStock(a).getMonth());

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
			Day.setValue(person.getPortfolio().GetStock(a).getDay());
			
			// Year
			ComboBox<String> Year = new ComboBox<>();
			for (int k = 15; k <= 19 ; k++) {
				String j;
				if (k < 10)
					j = "0"+k;
				else 
					j = "" + k;
				Year.getItems().add(j);
			}
			Year.setValue(person.getPortfolio().GetStock(a).getYear());
			
			// Lots of formating
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

	// Updates the portfolio once
	public void UpDatePortfolio (VBox AllStock) {

		ArrayList<OwnedStock> Portfolio = new ArrayList<OwnedStock>();
		
		// finds the information about the stock from the VBox
		for (int i = 0; i < AllStock.getChildren().size() - 1; i++) {
			HBox a = (HBox) AllStock.getChildren().get(i);
			VBox b = (VBox) a.getChildren().get(0);
			ComboBox<String> names = (ComboBox<String>) b.getChildren().get(1);
			String name = names.getValue();
			VBox c = (VBox) a.getChildren().get(1);
			ComboBox<Integer> amounts = (ComboBox<Integer>) c.getChildren().get(1);
			int amount = amounts.getValue();
			VBox d = (VBox) a.getChildren().get(2);
			HBox e = (HBox) d.getChildren().get(1);
			ComboBox<String> days = (ComboBox<String>) e.getChildren().get(1);
			String day = days.getValue();
			ComboBox<String> months = (ComboBox<String>) e.getChildren().get(0);
			String month = months.getValue();
			ComboBox<String> years = (ComboBox<String>) e.getChildren().get(2);
			String year = years.getValue();
			
			Portfolio.add(new OwnedStock(name,name,amount,month,day,year));
			
		}
		// uptdates the userdatabase
		Portfolio port = new Portfolio(Portfolio);
		UserManager.updatePortfolio(person.getName(),port);
		
		// updates it locally
		person.setPortfolio(person.CreateNewPortfolio(Portfolio));
		LoadMainPage();
	}

	// creates a new scene to update user information
	public void LoadMyAccountScene () {
		
		rootmainScene.setCenter(null);
		// Styling for button
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
	
	// refreshes the page
	public void leaveAccountPage(TextField NameBox,ComboBox <Integer> AgeSelection, TextField PasswordBox) {
		AgeSelection.setValue(person.getAge());
		NameBox.setText(person.getName());
		PasswordBox.setText(person.getPassword());
		
		LoadMainPage();
	}	
	
	// updates the user information in the program
	public void UpdateUser(VBox root,TextField NameBox,ComboBox <Integer> AgeSelection, TextField PasswordBox) {
		// stykling
		String ErrorTextStyle = "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-size: 15;"+
			    "-fx-stroke: red";
		
		TimesUpdatingUser++;
		
		// checks how many times the user tries to update user
		if (TimesUpdatingUser > 1) {
			if (root.getChildren().size() == 7)
				root.getChildren().remove(6);
		}
		
		// checks for empty boxes
		if (NameBox.getText().trim().isEmpty() || PasswordBox.getText().trim().isEmpty()) {
			Text Error = new Text("You must fill out all the fields");
			Error.setStyle(ErrorTextStyle);
			root.getChildren().add(Error);
		}
		
		// Checks for uderage
		else if (AgeSelection.getValue() < 18) {
			Text Error = new Text("User must be 18 years or older");
			Error.setStyle(ErrorTextStyle);
			root.getChildren().add(Error);
		}
		
		// updates user information
		else {
			// updates information in the database
			UserManager.updateAge(person.getName(), AgeSelection.getValue());
			UserManager.updateName(person.getName(), NameBox.getText());
			UserManager.updatePassword(person.getName(), PasswordBox.getText());

			// updates the user information locally
			person.setName(NameBox.getText());
			person.setAge(AgeSelection.getValue());
			person.setPassword(PasswordBox.getText());

			// formating
			VBox top = (VBox) rootmainScene.getTop();
			Text name = (Text) top.getChildren().get(1);
			name.setText(person.getName()+"'s Portfolio");
			LoadMainPage();
		}
	}

	// looks at portfolio and recommends updating it
	public void PortfolioAssesment() {
		
		// Styling the scene
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
		
		// formating
		rootmainScene.setCenter(null);
		BorderPane root = new BorderPane();
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15,15,15,15));
		
		// back button
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		backbtn.setLeft(back);
		root.setTop(backbtn);
		
		// text
		Text UC = new Text("This Page is currently Under Construction");
		UC.setStyle(HeaderTextStyle);
		root.setCenter(UC);
		
		root.setStyle("-fx-background-color: black");
		if (TimesinPortfolioAssesmentScene == 1) {
			PortfolioAssesmentScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		}
		window.setScene(PortfolioAssesmentScene);
	}	

	// Stock Searching page
	public void SearchAStock() {
		
		// Styling for page
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
		
		// Formating
		rootmainScene.setCenter(null);
		BorderPane root = new BorderPane();
		VBox top = new VBox(10);
		top.setAlignment(Pos.CENTER);
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15, 15, 15, 15));
		
		// creating the comboboxes for the page
		ComboBox <String> OutLookSelection = new ComboBox<String>();
		ComboBox <String> SectorSelection = new ComboBox<String>();
		ComboBox <Integer> PriceMin = new ComboBox<Integer>();
		ComboBox <Integer> PriceMax = new ComboBox<Integer>();
		
		// Back Button
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LeaveSearchAStock(OutLookSelection,SectorSelection,PriceMin,PriceMax));
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		// Header
		Text Header = new Text("Search For A Stock");
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);
		
		// Formating
		VBox elements = new VBox(20);
		elements.setAlignment(Pos.TOP_CENTER);
		HBox textinput = new HBox(50);
		VBox text = new VBox(30);
		VBox input = new VBox(30);

		// Prompts for the user
		Text OL = new Text("Outlook: "), ST = new Text("Sector: "), PMin = new Text("Min Price: "), PMax = new Text("Max Price: ");
		OL.setStyle(BodyTextStyle);
		ST.setStyle(BodyTextStyle);
		PMin.setStyle(BodyTextStyle);
		PMax.setStyle(BodyTextStyle);
		text.getChildren().addAll(OL,ST,PMin,PMax);
		textinput.getChildren().add(text);
	
		// Adding the Outlook
		OutLookSelection.getItems().addAll("3 Days", "1 Week", "1 Month", "3 Months");
		OutLookSelection.setValue("3 Days");
	
		// Adding all the Sectors
		SectorSelection.getItems().addAll("Telecommunication Services", "Financial Services", "Information Technology", "Materials", "HealthCare", "Utilities", "Real Estate", "Industrials", "Energy", "Consumer Staples", "Consumer Discretionary");
		SectorSelection.setValue("Telecommunication Services");

		// Adding the prices to the scene
		for (int i = 0; i <= 3000; i++) {
			PriceMin.getItems().add(i);
			PriceMax.getItems().add(i);
		}
		
		// Setting the price values initially
		PriceMin.setValue(0);
		PriceMax.setValue(3000);
		input.getChildren().addAll(OutLookSelection,SectorSelection,PriceMin,PriceMax);
		
		// Formating
		textinput.getChildren().add(input);
		textinput.setAlignment(Pos.CENTER);
		elements.getChildren().add(textinput);

		// Search button 
		int SearchButtonSizeX = 150, SearchButtonSizeY = 45;
		Button search = new Button("Search");
		search.setPrefSize(SearchButtonSizeX, SearchButtonSizeY);
		search.setStyle(BaseButtonStyle);
		HoverListener(search,BaseButtonStyle,HoverButtonStyle);
		search.setOnAction(e -> SearchStocks(elements,OutLookSelection.getValue(),SectorSelection.getValue(),PriceMin.getValue(),PriceMax.getValue()));
		elements.getChildren().addAll(search);

		// Formating
		root.setTop(top);
		root.setCenter(elements);
		root.setStyle("-fx-background-color: black");
		if (TimesinSearchAStockScene == 1) {
			SearchAStockScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		}
		window.setScene(SearchAStockScene);
	}
	
	// Adds stocks that we Searched for to the Scene
	public void SearchStocks(VBox elements,String outlook, String sector, int min, int max) {
		
		// Styling
		String BodyTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 25;";
		
		GridPane grid = new GridPane();
		
		// Checks for Max > min
		if (max > min) {
			TimeSearchingStock++;
			
			// Removes any unnecessary nodes on the screen
			if (TimeSearchingStock > 1) 
				elements.getChildren().remove(elements.getChildren().size()-1);
			
			// Searches for stocks
			StockSearch search = new StockSearch(sector,outlook,min,max);
			String[][] stocks = search.search();

			// Spacing
			grid.setVgap(10);
			grid.setHgap(45);
			grid.setPadding(new Insets (15,15,15,15));
			
			// text for searching
			Text info1 = new Text("Name");
			info1.setStyle(BodyTextStyle);
			Text info2 = new Text("Recommendation");
			info2.setStyle(BodyTextStyle);
			Text info3 = new Text("Today's Change");
			info3.setStyle(BodyTextStyle);
			grid.add(info1, 1, 0);
			grid.add(info2, 2, 0);
			grid.add(info3, 3, 0);
			
			// Adds stock information
			for (int i = 1; i < 4; i++) {
				
				// Adds the number
				Text Stocknum = new Text(""+i);
				Stocknum.setStyle(BodyTextStyle);
				grid.add(Stocknum, 0, i+1);
				
				// Adds the Stock name
				Text StockName = new Text(stocks[i-1][0]);
				StockName.setStyle(BodyTextStyle);
				grid.add(StockName, 1, i+1);
				
				// Adds our recommendation
				Text StockRec = new Text(stocks[i-1][1]);
				StockRec.setStyle(BodyTextStyle);
				grid.add(StockRec, 2, i+1);
				
				// Adds the net change
				Text StockChange = new Text(stocks[i-1][2]);
				StockChange.setStyle(BodyTextStyle);
				grid.add(StockChange, 3, i+1);
				
			}
			
			// Formating
			grid.setAlignment(Pos.CENTER);
			elements.getChildren().add(grid);

		}
		
	}
	
	// Resets the Stock search pgae
	public void LeaveSearchAStock(ComboBox <String> OutLookSelection, ComboBox <String> SectorSelection, ComboBox <Integer> PriceMin, ComboBox <Integer> PriceMax) {
		// Resets the boxes
		OutLookSelection.setValue("3 Days");
		SectorSelection.setValue("Telecommunication Services");
		PriceMin.setValue(0);
		PriceMax.setValue(3000);
		
		// Reloads the main page
		LoadMainPage();
	}

	// Assess all the sectors in the market and shows speck about it
	public void LoadMarketAssesment() {
		
		// Grabs sector information
		Object[] sectorinfo;
		sectorinfo = imports.getSectorInfo();
		
		// Scene Styling
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
		
		String GreenTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: green;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;";
		
		String RedTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: red;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 20;";
		
		TimesinMarketAssesmentScene++;
		
		// Formatting for page
		rootmainScene.setCenter(null);
		BorderPane root = new BorderPane();
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15,15,15,15));
		VBox top = new VBox();
		top.setAlignment(Pos.CENTER);
		
		// Back Button
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		// Header for Page
		Text Header = new Text("Market Assesment");
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);
		root.setTop(top);
		
		// Creating a Grid and formating it
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(15);
		grid.setPadding(new Insets(50, 10, 10, 10));
		Text oneday = new Text("1 Day");
		oneday.setStyle(PageTextStyle);
		grid.add(oneday, 1,0);
		Text fiveday = new Text("5 Day");
		fiveday.setStyle(PageTextStyle);
		grid.add(fiveday, 2,0);
		Text month = new Text("Month");
		month.setStyle(PageTextStyle);
		grid.add(month, 3,0);
		Text threemonth = new Text("3 Month");
		threemonth.setStyle(PageTextStyle);
		grid.add(threemonth, 4,0);
		Text ytd = new Text("YTD");
		ytd.setStyle(PageTextStyle);
		grid.add(ytd, 5,0);
		Text oneyear = new Text("1 year");
		oneyear.setStyle(PageTextStyle);
		grid.add(oneyear, 6,0);
		
		// loads information into the grid
		for (int i = 0; i < 22; i++) {
			if (i%2 == 0) {
				Text sector = new Text((String)sectorinfo[i]);
				sector.setStyle(PageTextStyle);
				grid.add(sector,0,i/2+1);
			}
			else {
				ArrayList <Float> info = (ArrayList <Float>) sectorinfo[i];
				for (int k = 1; k <= 6; k++) {
					Text data = new Text(info.get(k)+"%");
					if (info.get(k)>0)
						data.setStyle(GreenTextStyle);
					else 
						data.setStyle(RedTextStyle);
					grid.add(data, k, i/2+1);
				}
			}

		}
		
		//formating
		grid.setAlignment(Pos.TOP_CENTER);
		root.setCenter(grid);		
		root.setStyle("-fx-background-color: black");
		if (TimesinMarketAssesmentScene == 1) {
			MarketAssesmentScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		}
		window.setScene(MarketAssesmentScene);
	}

	// loads the specific stock page
	public void LoadSpecificStockPage(String name, int amount, String Outlook) {
		
		// page styling
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
			    "-fx-font-size: 20;";
		
		TimesinSpecificStockScene++;
		
		// formating
		rootmainScene.setCenter(null);
		BorderPane root = new BorderPane();
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15,15,15,15));
		VBox top = new VBox();
		top.setAlignment(Pos.CENTER);
		
		// Back Button
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BackButtonStyle);
		HoverListener(back,BackButtonStyle,BackHoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		// Header for page
		Text Header = new Text(name);
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);

		// formating for page
		VBox info = new VBox(10);
		HBox outlookforGraph = new HBox(25);
		outlookforGraph.setAlignment(Pos.CENTER);
		Text OL = new Text("Outlook:");
		OL.setStyle(PageTextStyle);
		
		// Creates an outlook comboBox
		ComboBox <String> OutLookSelection = new ComboBox<String>();
		OutLookSelection.getItems().addAll("3 Days", "1 Week", "1 Month", "3 Months");
		OutLookSelection.setValue("3 Days");
		
		// Creates a Submit button
		int SubmitButtonSizeX = 120,SubmitButtonSizeY = 35;
		Button submit = new Button("Submit");
		submit.setPrefSize(SubmitButtonSizeX, SubmitButtonSizeY);
		submit.setStyle(BackButtonStyle);
		HoverListener(submit,BackButtonStyle,BackHoverButtonStyle);
		submit.setOnAction(e -> LoadSpecificStockPage(name,amount,OutLookSelection.getValue()));
		outlookforGraph.getChildren().addAll(OL,OutLookSelection,submit);
		info.getChildren().add(outlookforGraph);
		
		// Gets Values for the graph
		StockAnalysis data1 = new StockAnalysis(name,Outlook);
        MetricCalculator data = new MetricCalculator(name,Outlook);
        String[] Xvals = data.getPriceGraphX();
        Double[] Yvals = data.getPriceGraphY();
		
        // Creates a graph
		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Days");
        yAxis.setLabel("Dollars");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle(name+"'s Price Graph");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        
        //populating the series with data
        for (int i = 0; i < Xvals.length; i++) {
        	series.getData().add(new XYChart.Data(i+1, Yvals[i]));
        }
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(Xvals.length);
        xAxis.setTickUnit(1);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(data.getThreeMonthLow());
        yAxis.setUpperBound(data.getThreeMonthHigh());
        yAxis.setTickUnit(2);
        lineChart.getData().add(series);
        lineChart.setPrefSize(500, 300);
        
        info.getChildren().add(lineChart);
		
        // Adds a Text Box and buttons for definitions
        Text populate = new Text();
        DecimalFormat df = new DecimalFormat("###.###");
        populate.wrappingWidthProperty().bind(window.widthProperty());
        HBox btns = new HBox(15);
        int LearningButtonSizeX = 150,LearningButtonSizeY = 45;
        Button PCBTN = new Button("Previous \nClose"), ThreeMRBTN = new Button("Three Month \nRange"), PEBTN = new Button("Price to \nEarnings Ratio"), MMBTN = new Button("Market \nMomentum"), RSIBTN = new Button("Relative \nStrength Index"), EMABTN = new Button("Exponential \nMoving Average"), OurRecBTN = new Button("Our \nReccomendation");
        PCBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        PCBTN.setStyle(BaseButtonStyle);
        HoverListener(PCBTN,BaseButtonStyle,HoverButtonStyle);
        PCBTN.setOnAction(e -> populate.setText("Price: "+df.format(data.getPrevClose())+"\nDefinition: "+data.getPriceDefinition()));
        ThreeMRBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        ThreeMRBTN.setStyle(BaseButtonStyle);
        HoverListener(ThreeMRBTN,BaseButtonStyle,HoverButtonStyle);
        ThreeMRBTN.setOnAction(e -> populate.setText("Three Month High: "+df.format(data.getThreeMonthHigh())+"\nThree Month Low: "+df.format(data.getThreeMonthLow())+"\nDefinition: "+data.getPriceDefinition()));
        PEBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        PEBTN.setStyle(BaseButtonStyle);
        HoverListener(PEBTN,BaseButtonStyle,HoverButtonStyle);
        PEBTN.setOnAction(e -> populate.setText("P/E: "+df.format(data.getPERatio())+"\nDefinition: "+data.getPERatioDefinition()));
        MMBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        MMBTN.setStyle(BaseButtonStyle);
        HoverListener(MMBTN,BaseButtonStyle,HoverButtonStyle);
        MMBTN.setOnAction(e -> populate.setText("Market Momentum: "+df.format(data.getMomentum(data.getOutlook()))+"\nDefinition: "+data.getMomentumDefinition()));
        RSIBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        RSIBTN.setStyle(BaseButtonStyle);
        HoverListener(RSIBTN,BaseButtonStyle,HoverButtonStyle);
        RSIBTN.setOnAction(e -> populate.setText("RSI: "+df.format(data.getRSI())+"\nDefinition: "+data.getRSIDefinition()));
        EMABTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        EMABTN.setStyle(BaseButtonStyle);
        HoverListener(EMABTN,BaseButtonStyle,HoverButtonStyle);
        EMABTN.setOnAction(e -> populate.setText("EMA: "+df.format(data.getEMA(data.getOutlook()))+"\nDefinition: "+data.getEMADefinition()));
        OurRecBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        OurRecBTN.setStyle(BaseButtonStyle);
        HoverListener(OurRecBTN,BaseButtonStyle,HoverButtonStyle);
        OurRecBTN.setOnAction(e -> populate.setText("Our Reccomendation: "+data1.conclusion()));
        btns.getChildren().addAll(PCBTN,ThreeMRBTN,PEBTN,MMBTN,RSIBTN,EMABTN,OurRecBTN);
        btns.setAlignment(Pos.CENTER);
        
        // Formating
        info.getChildren().add(btns);
		populate.setStyle(PageTextStyle);
		info.getChildren().add(populate);
		root.setCenter(info);
		root.setTop(top);
		root.setStyle("-fx-background-color: black");
		if (TimesinSpecificStockScene == 1)
			SpecificStockScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		else 
			SpecificStockScene.setRoot(root);
		window.setScene(SpecificStockScene);
		
	}

	// Onboards info for Assessment
	public void LoadIndividualStockAssesmentOnboard() {
		// Page Styling
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
		
		// Formating
		rootmainScene.setCenter(null);
		BorderPane root = new BorderPane();
		VBox top = new VBox(10);
		top.setAlignment(Pos.CENTER);
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15, 15, 15, 15));
		
		// Creates comboboxes
		ComboBox <String> OutLookSelection = new ComboBox<String>();
		ComboBox <String> StockNames = new ComboBox<String>();
		
		// Creates a back button for the page
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		// Loads a Header for the Page
		Text Header = new Text("Load Information");
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);
		
		// Formating for the page
		VBox elements = new VBox(20);
		elements.setAlignment(Pos.CENTER);
		HBox textinput = new HBox(50);
		VBox text = new VBox(30);
		VBox input = new VBox(30);

		// Text for page
		Text OL = new Text("Outlook: "), STOCK = new Text("Stock Name: ");
		OL.setStyle(BodyTextStyle);
		STOCK.setStyle(BodyTextStyle);
		text.getChildren().addAll(OL,STOCK);
		textinput.getChildren().add(text);
	
		// Outlook Selection Screen
		OutLookSelection.getItems().addAll("3 Days", "1 Week", "1 Month");
		OutLookSelection.setValue("3 Days");
		input.getChildren().add(OutLookSelection);
	
		// Populates stock searcher
		StockDatabase data = new StockDatabase();
		StockNames.setTooltip(new Tooltip());
		StockNames.getItems().addAll(data.getAllStockNames());
		new ComboBoxSearcher<String>(StockNames);
		StockNames.getSelectionModel().selectFirst();
		input.getChildren().add(StockNames);
		
		// Formating
		textinput.getChildren().add(input);
		textinput.setAlignment(Pos.CENTER);
		elements.getChildren().add(textinput);

		// Search Button
		int SearchButtonSizeX = 150, SearchButtonSizeY = 45;
		Button search = new Button("Assess");
		search.setPrefSize(SearchButtonSizeX, SearchButtonSizeY);
		search.setStyle(BaseButtonStyle);
		HoverListener(search,BaseButtonStyle,HoverButtonStyle);
		search.setOnAction(e -> LoadIndividualStockAssesment(OutLookSelection.getValue(),StockNames.getValue()));
		elements.getChildren().add(search);
		
		// Formating
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
		
		StockAnalysis calc = new StockAnalysis(Name,Outlook);
		MetricCalculator calc1 = new MetricCalculator(Name,Outlook);
		
		// Page Styling
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
		
		String BackButtonStyle ="-fx-text-fill: white;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:white;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 22;"+
			    "-fx-vertical-align:middle;";
		
		String HoverBackButtonStyle = "-fx-text-fill: grey;"+
			    "-fx-background-color: transparent;"+
			    "-fx-font: Courier New;"+
			    "-fx-border-color: grey;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 22;";
		
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
		
		String populateTextStyle = "-fx-font: Times New Roman;"+
				"-fx-fill: white;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 25;";
		
		TimesinIndividualStockAssesmentScene++;
		
		// Formatting
		rootmainScene.setCenter(null);
		BorderPane root = new BorderPane();
		BorderPane backbtn = new BorderPane();
		backbtn.setPadding(new Insets(15,15,15,15));
		VBox top = new VBox();
		top.setAlignment(Pos.CENTER);
		
		// Creating a back Button
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BackButtonStyle);
		HoverListener(back,BackButtonStyle,HoverBackButtonStyle);
		back.setOnAction(e -> LoadIndividualStockAssesmentOnboard());
		backbtn.setLeft(back);
		top.getChildren().add(backbtn);
		
		// Creating a header
		Text Header = new Text(Name+"'s Stock Assesment");
		Header.setStyle(HeaderTextStyle);
		top.getChildren().add(Header);
		
		root.setTop(top);
		
		// Creating arrows for in between buttons
		Text arrow2 = new Text("-->"), arrow3 = new Text("-->"), arrow4 = new Text("-->"),  arrow5 = new Text("-->"), arrow6 = new Text("-->");
		arrow2.setStyle(PageTextStyle);
		arrow3.setStyle(PageTextStyle);
		arrow4.setStyle(PageTextStyle);
		arrow5.setStyle(PageTextStyle);
		arrow6.setStyle(PageTextStyle);
		
		// Creating Buttons and text to populate underneath
		Text populate = new Text();
		Text Definitions = new Text();
		Text CurrentMetric = new Text();
		populate.wrappingWidthProperty().bind(window.widthProperty());
		Definitions.wrappingWidthProperty().bind(window.widthProperty());
		CurrentMetric.wrappingWidthProperty().bind(window.widthProperty());
		populate.setText(calc.getIntroduction());
		populate.setStyle(populateTextStyle);
		CurrentMetric.setStyle(populateTextStyle);
		Definitions.setStyle(populateTextStyle);
		VBox center = new VBox(20);
		center.setAlignment(Pos.CENTER);
        HBox btns = new HBox(0);
        int LearningButtonSizeX = 150,LearningButtonSizeY = 45;
        Button PCBTN = new Button("Previous \nClose"), PEBTN = new Button("Price to \nEarnings Ratio"), MMBTN = new Button("Market \nMomentum"), RSIBTN = new Button("Relative \nStrength Index"), EMABTN = new Button("Exponential \nMoving Average"), OurRecBTN = new Button("Our \nReccomendation");
        Button btnarr[] = {PCBTN,PEBTN,MMBTN,RSIBTN,EMABTN,OurRecBTN};
        
        // Styling the buttons and sizing them
        PCBTN.setPrefSize(LearningButtonSizeX, LearningButtonSizeY);
        PCBTN.setStyle(BaseButtonStyle);
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
        btns.getChildren().addAll(PCBTN,arrow2,PEBTN,arrow3,MMBTN,arrow4,RSIBTN,arrow5,EMABTN,arrow6,OurRecBTN);
        btns.setAlignment(Pos.CENTER);
        center.getChildren().addAll(btns,Definitions,CurrentMetric,populate);
        center.setPadding(new Insets(15,15,15,15));
        
        // Creates a learning button
        int LearningButtonSizex = 300,LearningButtonSizey = 75;
        Button learningButton = new Button("Click to Learn");
        learningButton.setPrefSize(LearningButtonSizex,LearningButtonSizey);
        learningButton.setStyle(BaseButtonStyle);
        HoverListener(learningButton,BaseButtonStyle,HoverButtonStyle);
        learningButton.setOnAction(e -> PC(learningButton, btnarr,CurrentMetric,Definitions, populate,calc,calc1));
        center.getChildren().add(learningButton);
        
        // formating
        root.setCenter(center);
		root.setStyle("-fx-background-color: black");
		if (TimesinIndividualStockAssesmentScene == 1)
			IndividualStockAssesmentScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		else
			IndividualStockAssesmentScene.setRoot(root);
		
		window.setScene(IndividualStockAssesmentScene);
	}	

	// Updates Load Individual Stock Assessment
	public void PC(Button learningButton, Button btnarr[],Text CurrentMetric, Text Definitions, Text populate,StockAnalysis calc, MetricCalculator calc1) {
		// Style
		String SelectedButtonStyle ="-fx-text-fill: yellow;"+
				"-fx-background-color:transparent;"+
				"-fx-border-color:yellow;"+
			    "-fx-font: Courier New;"+
			    "-fx-font-family: Courier New;"+
			    "-fx-font-weight: bold;"+
			    "-fx-border-radius: 18;"+
			    "-fx-font-size: 15;";	
		
		// Updates page
		DecimalFormat df = new DecimalFormat("###.###");
		Definitions.setText("Definition: "+ calc1.getPriceDefinition());
		CurrentMetric.setText("Price: "+df.format(calc1.getPrevClose()));
		populate.setText("Analysis: "+calc.getPrice());
		btnarr[0].setStyle(SelectedButtonStyle);
		learningButton.setOnAction(e -> PE(learningButton,btnarr,CurrentMetric,Definitions,populate,calc,calc1));
	}	

	// Updates Load Individual Stock Assessment
	public void PE(Button learningButton, Button btnarr[],Text CurrentMetric, Text Definitions, Text populate,StockAnalysis calc, MetricCalculator calc1) {
		// Styling
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
		
		// Updates Page
		DecimalFormat df = new DecimalFormat("###.###");
		Definitions.setText("Definition: "+ calc1.getPERatioDefinition());
		CurrentMetric.setText("P/E: "+df.format(calc1.getPERatio()));
		populate.setText("Analysis: "+calc.getPERatio());
		btnarr[0].setStyle(BaseButtonStyle);
		btnarr[1].setStyle(SelectedButtonStyle);
		learningButton.setOnAction(e -> MM(learningButton,btnarr,CurrentMetric,Definitions,populate,calc,calc1));
	}
	
	// Updates Load Individual Stock Assessment
	public void MM(Button learningButton, Button btnarr[],Text CurrentMetric, Text Definitions,Text populate,StockAnalysis calc, MetricCalculator calc1) {
		// Styling 
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
		
		// Updates Page
		DecimalFormat df = new DecimalFormat("###.###");
		Definitions.setText("Definition: "+ calc1.getMomentumDefinition());
		CurrentMetric.setText("Market Momentum: "+df.format(calc1.numOutlook(calc1.getOutlook())));
		populate.setText("Analysis: "+calc.getMomentum());
		btnarr[1].setStyle(BaseButtonStyle);
		btnarr[2].setStyle(SelectedButtonStyle);
		learningButton.setOnAction(e -> RSI(learningButton,btnarr,CurrentMetric,Definitions,populate,calc,calc1));
	}
	
	// Updates Load Individual Stock Assessment
	public void RSI(Button learningButton, Button btnarr[],Text CurrentMetric, Text Definitions, Text populate,StockAnalysis calc, MetricCalculator calc1) {
		// Styling 
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
		
		// Updates Page
		DecimalFormat df = new DecimalFormat("###.###");
		Definitions.setText("Definition: "+ calc1.getRSIDefinition());
		CurrentMetric.setText("RSI: "+df.format(calc1.getRSI()));
		populate.setText("Analysis: "+calc.getRSI());
		btnarr[2].setStyle(BaseButtonStyle);
		btnarr[3].setStyle(SelectedButtonStyle);
		learningButton.setOnAction(e -> EMA(learningButton,btnarr,CurrentMetric,Definitions,populate,calc,calc1));
	}
	
	// Updates Load Individual Stock Assessment
	public void EMA(Button learningButton, Button btnarr[], Text CurrentMetric, Text Definitions,Text populate,StockAnalysis calc, MetricCalculator calc1) {
		// Styling 
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
		
		// Updates Page
		DecimalFormat df = new DecimalFormat("###.###");
		Definitions.setText("Definition: "+ calc1.getEMADefinition());
		CurrentMetric.setText("EMA: "+df.format(calc1.getEMA(calc1.getOutlook())));
		populate.setText("Analysis: "+calc.getEMA());
		btnarr[3].setStyle(BaseButtonStyle);
		btnarr[4].setStyle(SelectedButtonStyle);
		learningButton.setOnAction(e -> Conc(learningButton,btnarr,CurrentMetric,Definitions,populate,calc,calc1));
	}
	
	// Updates Load Individual Stock Assessment
	public void Conc(Button learningButton, Button btnarr[],Text CurrentMetric, Text Definitions, Text populate,StockAnalysis calc, MetricCalculator calc1) {
		
		// Styling
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

		// Updates Page
		Definitions.setText("");
		CurrentMetric.setText("");
		populate.setText("Analysis: "+calc.conclusion());
		btnarr[4].setStyle(BaseButtonStyle);
		btnarr[5].setStyle(SelectedButtonStyle);
		learningButton.setOnAction(e -> LoadIndividualStockAssesmentOnboard());
	}
	
	// Creates a way for the buttons to seem like they are being hovered over
	public void HoverListener(Button button, String BaseStyle, String HoverStyle) {
		button.hoverProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				button.setStyle(HoverStyle);
			} else {
				button.setStyle(BaseStyle);
			}
		});
	}

	// For the combo box searcher
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
	
}
