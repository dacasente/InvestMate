# StockImporter.java

### getCurrentPrice
- Takes in a stock symbol ie apple
- Can be called with `StockImporter.getCurrentPrice("AAPL")`
- Returns the most recent price of the input stock as a Float
- Returns null on a failed call
### getStockInfo
- Takes in a stock symbol or name
- Can be called like `StockImporter.getStockInfo("AAPL")` or `StockImporter.getStockInfo("Apple")`
    - Will return the info of the most closely matching stock, regardless of the input so works well with names and symbols
- Returns a String array with the format `(Symbol, Name, Type, Location, Market Open, Market Close, Time Zone, Currency, Match % to keyword)`
- Returns null upon fail.
### getStockList
- Takes in a keyword or symbol and returns an arraylist of the names of the most closely matching stocks, in order to match %.
- Can be called like `StockImporter.getStockList("AAPL")` (will return Apple, etc) or `StockImporter.getStockList("Apple")`(returns the same as before) or `StockImporter.getStockList("Aple")`, which will return the list of the most closely matching stocks.
- Returns null upon fail.
### getStock(Symbol,Name,Type,Locale, Currency)
- This method takes in either a name or a symbol, performs a search and returns either the Symbol, Name, Type, etc. in string format.
- Can be called like `StockImporter.getStockSymbol("Apple")` or `StockImporter.getStockName("AAPL")`, etc. This works on all versions of this method and can get the info regardless of whether or not the name or stock is input.
- Returns null on fail.
### timeSeries(Daily, Weekly, Monthly)
- Takes in a stock's symbol
- Returns an array with 6 arraylists in it, one for dates (in string format) and then open prices, high, low, close and volume all in float format.
- Can be called by `StockImporter.timeSeriesDaily("AAPL")`,`StockImporter.timeSeriesMonthly("MSFT")`, etc.
- Returns null upon fail. 
