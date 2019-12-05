import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
	int TimesinStartScene = 0, TimesinLoginScene = 0, TimesinSignUpScene = 0, TimesCreatingUser = 0, TimeinOnboardScene = 0, TimesinMainScene = 0,TimesinEditPortfolioScene = 0, TimesinMyAccountScene = 0, TimesUpdatingUser = 0, TimesinSpecificStockScene = 0, TimeinIndividualStockAssesmentOnboardScene = 0, TimesinIndividualStockAssesmentScene = 0, TimesinPortfolioAssesmentScene = 0;
	
	// All the Objects in the Program
	Stage window;
	
	// These are only used for their methods, not to store any information
	OwnedStock stock;
	
	// Objects
	User person;
	StockImporter stockimporter;
	LearningTool learningtool;

	BorderPane rootmainScene = new BorderPane(), rootSpecificStockScene = new BorderPane(), rootIndividualStockAssesment = new BorderPane();
	
	// The different Scenes
	Scene StartScene, LoginScene, SignUpScene, OnBoardScene, MainScene, EditPortfolioScene, MyAccountScene, SpecificStockScene, IndividualStockAssesmentOnboardScene, IndividualStockAssesmentScene, PortfolioAssesmentScene;

	// Lets the Program be run from the RunProgram Class
	public void Begin(Stage primaryStage){
		window = primaryStage;
		window.setTitle("Stock Advisor");
		// Change to true once you figure it out
		window.setResizable(true);
		window.setMinHeight(500);
		window.setMinWidth(800);
		LoadStartPage();
		window.show();
	}
	
	// Loads the Start Page
	public void LoadStartPage() {
		
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
		
		// adds all the nodes to the scenes
		root.setStyle("-fx-background-color: black");
		root.getChildren().addAll(StartText, SubText, btns, imageView);
		if (TimesinStartScene == 1) 
			StartScene = new Scene(root,InitialWidthScreen,InitialHeightScreen);
		
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
		SignInBtn.setOnAction(e -> LoadMainPage());
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
	public void CheckUser() {
		
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
			    "-fx-font-size: 25;";
		
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
			//MrkOvw.setOnAction(e -> UnloadCurrentScene(OnBoardScene, root4));
			AssesStock.setStyle(BigButtonBase);
			AssesStock.setPrefSize(BigBtnSizeX,BigBtnSizeY);
			HoverListener(AssesStock,BigButtonBase,BigButtonHover);
			AssesStock.setOnAction(e -> LoadIndividualStockAssesmentOnboard());
			SearchStock.setStyle(BigButtonBase);
			SearchStock.setPrefSize(BigBtnSizeX,BigBtnSizeY);
			HoverListener(SearchStock,BigButtonBase,BigButtonHover);
			//SearchStock.setOnAction(e -> UnloadCurrentScene(OnBoardScene, root4));
			PortfolioAssesment.setStyle(BigButtonBase);
			PortfolioAssesment.setPrefSize(BigBtnSizeX,BigBtnSizeY);
			HoverListener(PortfolioAssesment,BigButtonBase,BigButtonHover);
			//PortfolioAssesment.setOnAction(e -> UnloadCurrentScene(OnBoardScene, root4));
			btns.getChildren().addAll(MrkOvw,sep1,AssesStock,sep2,SearchStock,sep3,PortfolioAssesment);
			btns.setAlignment(Pos.CENTER);
			top.getChildren().add(btns);
			
			Separator separator2 = new Separator();
			top.getChildren().add(separator2);
			
			rootmainScene.setTop(top);
		}
		
		VBox Stocks = new VBox();
		HBox titles = new HBox(50);
		titles.setAlignment(Pos.CENTER);
		Text name = new Text("Name"), quantity = new Text("Quantity"), Todayschange = new Text("Todays Change"), NetChange = new Text("Net Change");
		name.setStyle(PageTextStyle);
		quantity.setStyle(PageTextStyle);
		Todayschange.setStyle(PageTextStyle);
		NetChange.setStyle(PageTextStyle);
		titles.getChildren().addAll(name,quantity,Todayschange,NetChange);
		Stocks.getChildren().add(titles);
		
		for (int i = 0; i < person.getPortfolio().getPortfolioSize(); i++) {
			HBox metrics = new HBox(50);
			metrics.setAlignment(Pos.CENTER);
			Text N = new Text(person.getPortfolio().GetStock(i).getName());
			Text Q = new Text(person.getPortfolio().GetStock(i).getShares());
			Text TC = new Text("+4");
			Text NC = new Text("+3");
			N.setStyle(PageTextStyle);
			Q.setStyle(PageTextStyle);
			TC.setStyle(PageTextStyle);
			NC.setStyle(PageTextStyle);
			metrics.getChildren().addAll(N,Q,TC,NC);
			Stocks.getChildren().add(metrics);
		}
		
		rootmainScene.setCenter(Stocks);
		
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
		
		if (TimesUpdatingUser > 1)
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
		
		BorderPane root = new BorderPane();
		int BackButtonSizeX = 150,BackButtonSizeY = 45;
		Button back = new Button("Back");
		back.setPrefSize(BackButtonSizeX, BackButtonSizeY);
		back.setStyle(BaseButtonStyle);
		HoverListener(back,BaseButtonStyle,HoverButtonStyle);
		back.setOnAction(e -> LoadMainPage());
		root.setTop(back);
		Text UC = new Text("This Page is currently Under Construction");
		UC.setStyle(HeaderTextStyle);
		root.setCenter(UC);
		
		if (TimesinPortfolioAssesmentScene == 1) {
			PortfolioAssesmentScene = new Scene(root, InitialWidthScreen, InitialHeightScreen);
		}
		window.setScene(PortfolioAssesmentScene);
	}
	
	public void LoadIndividualStockAssesmentOnboard() {
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
		Text NameText = new Text(name);
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
