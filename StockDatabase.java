import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class StockDatabase {
	
	public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:stocks.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS stocks (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    ticker text NOT NULL,\n"
                + "    sector text NOT NULL,\n"
                + "    prices text NOT NULL,\n"
                + "    currentPrice real,\n"
                + "    eps real\n"
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
        String url = "jdbc:sqlite:stocks.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Insert a new row into the stocks table
     *
     */
    public void addStock(String name, String ticker, String sector, Double[] stockPrices, Double currentPrice, Double eps) {
    	int id = getLastID() + 1;
    	String prices = pricesToString(stockPrices);
    	String sql = "INSERT INTO stocks(id,name,ticker, sector, prices, currentPrice, eps) VALUES(?,?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,id);
        	pstmt.setString(2, name);
            pstmt.setString(3, ticker);
            pstmt.setString(4, sector);
            pstmt.setString(5, prices);
            pstmt.setDouble(6, currentPrice);
            pstmt.setDouble(7, eps);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private String pricesToString(Double[] prices) {
    	String output = "";
    	for(int i = 0; i < prices.length; i++) {
    		if(i == 0) {
    			output = output + prices[i];
    		}
    		else {
    			output = output + "," + prices[i];
    		}
    		
    	}
    	return output;
    }
    
    /**
     * select all names in the stocks table
     */
    public String[] getAllStockNames(){
    	String tempNames = "";
        String sql = "SELECT name FROM stocks";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	tempNames = tempNames + rs.getString("name") + ",";
                
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String[] names = tempNames.split(",");
        return names;
    }
    
    public Double[] getStockPrices(String name) {
    	String tempPrices = "";
    	String sql = "SELECT prices "
    			+ "FROM stocks WHERE name == ?";
        
    	try (Connection conn = this.connect();
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
               
               // set the value
               pstmt.setString(1,name);
               //
               ResultSet rs  = pstmt.executeQuery();
               
               // loop through the result set
            while (rs.next()) {
            	tempPrices = tempPrices + rs.getString("prices") + ",";
                
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        Double[] output = pricesToArray(tempPrices);
        return output;
        
    }
    
    private Double[] pricesToArray(String prices) {
    	String[] strPrices = prices.split(",");
    	Double[] output = new Double[strPrices.length];
    	for(int i = 0; i < strPrices.length; i++) {
    		output[i] = Double.parseDouble(strPrices[i]);
    		
    	}
    	return output;
    	
    }
    
    public Double getStockEps(String name) {
    	Double tempEps = 0.0;
    	String sql = "SELECT eps "
    			+ "FROM stocks WHERE name = ?";
        
    	try (Connection conn = this.connect();
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
               
               // set the value
               pstmt.setString(1,name);
               //
               ResultSet rs  = pstmt.executeQuery();
               
               // loop through the result set
            while (rs.next()) {
            	tempEps = rs.getDouble("eps");
                
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        return tempEps;
        
    }
    
    
    
    /**
     * Get the stocks that fit the filter criteria 
     * 
     */
    public String[] getStockNames(String sector, Double priceMin, Double priceMax){
    	String tempNames = "";
        String sql = "SELECT name "
                   + "FROM stocks WHERE sector == ? AND currentPrice > ? AND currentPrice < ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,sector);
            pstmt.setDouble(2, priceMin);
            pstmt.setDouble(3, priceMax);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                tempNames = tempNames + rs.getString("name") + ",";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        String[] names = tempNames.split(",");
        return names;
    }
    
    private int getLastID() {
		int lastId = 0;
		String tempIds = "";
		String sql = "SELECT id FROM stocks";
        
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
        return lastId;
		
	}
    
    /**
     * Update stock price of a stock specified by the name
     *
     * 
     */
    public boolean updateStockPrice(String name, Double price) {
    	String prices = price + "," + getPriceString(name);
        String sql = "UPDATE stocks SET prices = ? , currentPrice = ? "
                + "WHERE name = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, prices);
            pstmt.setDouble(2, price);
            pstmt.setString(3, name);
            // update 
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public String getPriceString(String name) {
    	String tempPrices = "";
    	String sql = "SELECT prices "
    			+ "FROM stocks WHERE name == ?";
        
    	try (Connection conn = this.connect();
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
               
               // set the value
               pstmt.setString(1,name);
               //
               ResultSet rs  = pstmt.executeQuery();
               
               // loop through the result set
            while (rs.next()) {
            	tempPrices = rs.getString("prices");
                
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        return tempPrices;
        
    }
	
}
