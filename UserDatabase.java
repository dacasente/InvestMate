import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class UserDatabase {
	/**
     * Create a new table in the test database
     *
     */
	public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:users.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
        		+ "id integer PRIMARY KEY,\n"
        		+ "username text NOT NULL,\n"
                + "password text NOT NULL,\n"
                + "age integer NOT NULL,\n"
                + "stocks text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	/**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:users.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Insert a new row into the users table
     *
     * @param name
     * @param capacity
     */
    public boolean addUser(String name, String password, int age, Portfolio port) {
    	int id = getLastID() + 1;
        String stocks = port.outputPortfolio();
    	String sql = "INSERT INTO users(id,username,password,age,stocks) VALUES(?,?,?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
        	pstmt.setString(2, name);
            pstmt.setString(3, password);
            pstmt.setInt(4, age);
            pstmt.setString(5, stocks);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    /**
     * select all rows in the warehouses table
     */
    public ArrayList<User> getUsers(){
    	ArrayList<User> allUsers = new ArrayList<User>();
        String sql = "SELECT id, username, password, age, stocks FROM users";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	String name =rs.getString("username");
            	String password = rs.getString("password");
            	int age = rs.getInt("age");
            	Portfolio port = convertPortfolio(rs.getString("stocks"));
                User temp = new User(name, age, password);
                temp.setPortfolio(port);
                allUsers.add(temp);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allUsers;
    }
    
    public User getAUser(String name){
    	User tempUser = null;
        String sql = "SELECT id, username, password, age, stocks "
        		+ "FROM users where username = ?";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
               
               // set the value
               pstmt.setString(1,name);
               //
               ResultSet rs  = pstmt.executeQuery();
               
               // loop through the result set
            while (rs.next()) {
            	String username =rs.getString("username");
        		int age = rs.getInt("age");
        		String password = rs.getString("password");
        		tempUser = new User(username, age, password);
        		Portfolio port = convertPortfolio(rs.getString("stocks"));
                tempUser.setPortfolio(port);
                
            }
            
            
        }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempUser;
    }
    
  
    
	
    
    
	private Portfolio convertPortfolio(String port) {
		String[] stocks = port.split("\\~");
		int numStocks = stocks.length;
		String[] stockNames = new String [numStocks];
		String[] tickers = new String [numStocks];
		int[] amounts = new int [numStocks];
		String[] dates = new String [numStocks];
		
		for(int i = 0; i < numStocks; i++) {
			String[] values = stocks[i].split("\\_");
			stockNames[i] = values[0];
			tickers[i] = values[1];
			amounts[i] = Integer.parseInt(values[2]);
			dates[i] = values[3];
			
			
		}
		Portfolio userPort = new Portfolio(stockNames, tickers, amounts, dates);
		return userPort;
		
		
	
	}
	
	private int getLastID() {
		int lastId = 0;
		String tempIds = "";
		String sql = "SELECT id FROM users";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	tempIds = tempIds + rs.getInt("id") + ",";
            }
            String[] strIds = tempIds.split(",");
            if(strIds[0].equals("")) {
            	lastId = 0;
            }
            else {
            	lastId = Integer.parseInt(strIds[strIds.length -1]);
            }
            
        } catch (SQLException e) {
        	return lastId;
        }
        System.out.println(lastId);
        return lastId;
		
	}
	
	/**
     * Update name of a user specified by the name
     *
     * 
     */
    public boolean updateName(String oldName, String newName) {
        String sql = "UPDATE users SET username = ? "
                + "WHERE username = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, newName);
            pstmt.setString(2, oldName);
            // update 
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * Update age of a user specified by the name
     *
     * 
     */
    public boolean updateAge(String name, int newAge) {
        String sql = "UPDATE users SET age = ? "
                + "WHERE username = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, newAge);
            pstmt.setString(2, name);
            // update 
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * Update password of a user specified by the name
     *
     * 
     */
    public boolean updatePassword(String name, String newPassword) {
        String sql = "UPDATE users SET password = ? "
                + "WHERE username = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, newPassword);
            pstmt.setString(2, name);
            // update 
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * Update portfolio of a user specified by the name
     *
     * 
     */
    public boolean updatePortfolio(String name, Portfolio port) {
    	String newPort = port.outputPortfolio();
        String sql = "UPDATE users SET stocks = ? "
                + "WHERE username = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, newPort);
            pstmt.setString(2, name);
            // update 
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    
	
	
	
}