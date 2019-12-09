public class StockAnalysis {
	private String name;
	private String outlook;
	private int peComp = 0;
	private int priceComp = 0;
	private int mmComp = 0;
	private int rsiComp = 0;
	private int emaComp = 0;
	private MetricCalculator company;

	public StockAnalysis(String name, String outlook) {
		this.outlook = outlook;

		this.name = name;

		company = new MetricCalculator(name, outlook);
	}

	public String getOutlook() {
		return outlook;
	}

	public void setOutlook(String outlook) {
		this.outlook = outlook;

	}

	public String getIntroduction() {
		String temp = "Welcome to the simple stock assessment tool. This tool will guide you through how to calculate fundamtental metrics in order"
				+ " to evaluate a stock. In addition, we will explain our evaluation of each metric and come to a conclusion as to whether we reccommend the stock being assessed.";
		return temp;
	}

	public String getPERatio() {
		String output = "";
		double currentPE = company.getPERatio();
		double histPE = company.getHistPERatio();
		double dif = difference(histPE, currentPE);

		if (dif < -20) {
			output = output
					+ " Based on the large negative difference between the current P/E Ratio and the historical P/E Ratio, we have determined"
					+ " that currently investors are underpaying for the stock relative to history. This is a positive sign in purchasing a stock.";
			peComp = 1;
		} else if (dif >= -20 && dif <= 20) {
			output = output
					+ " Based on the small relative difference between the current P/E Ratio and the historical P/E Ratio, we have determined"
					+ " that currently investors are neither overpaying nor underpaying for the stock relative to history. This is a neutral sign in purchasing a stock.";
			peComp = 0;
		} else {
			output = output
					+ " Based on the large positive difference between the current P/E Ratio and the historical P/E Ratio, we have determined"
					+ " that currently investors are overpaying for the stock relative to history. This is a negative sign in purchasing a stock.";
			peComp = -1;
		}
		return output;
	}

	public String getPrice() {
		String output = "";
		double currentPrice = company.getPrevClose();
		double histPrice = company.getHistPrice();
		double dif = difference(histPrice, currentPrice);

		if (dif < -15) {
			output = output
					+ " Based on the large negative difference between the current price and the historical price, we have determined that the"
					+ " stock has significantly devaluated over this time period. This is a negative sign in purchasing a stock.";
			priceComp = -1;
		} else if (dif >= -15 && dif <= 15) {
			output = output
					+ " Based on the small positive or negative difference between the current price and the historical price, we have"
					+ " determined that currently the stock has neither devaluated nor inflated over this time period. This is a positive sign in purchasing a stock.";
			priceComp = 1;
		} else {
			output = output
					+ " Based on the large positive increase between the current price and the historical price, we have determined that"
					+ " currently the stock price has significantly inflated over this time period and the price trend is unpredictable. This is a neutral sign in purchasing a stock.";
			priceComp = -1;
		}
		return output;
	}

	public String getMomentum() {
		String output = "";
		double currentMom = company.getMomentum(outlook);
		double histMom = company.getHistMomentum(outlook);
		double dif = difference(currentMom, histMom);

		if (dif <= 0) {
			output = output
					+ " Based on the negative difference between the current market momentum and the historical market momentum, we have "
					+ "determined that the stock price is trending downward and is unlikely to appreciate in the near future. This is a negative sign in purchasing a stock.";
			mmComp = -1;
		} else if (dif > 0 && dif <= 30) {
			output = output
					+ " Based on the small positive difference between the current market momentum and the historical momentum, we have determined"
					+ " that it is likely that the positive trend will continue into the near future. This is a positive sign in purchasing a stock.";
			mmComp = 1;
		} else {
			output = output
					+ " Based on the large positive increase between the current market momentum and the historical market momentum, we have"
					+ " determined that currently the stock price has significantly inflated over this recent time period, so it is unknown whether the"
					+ " stock will continue this trend or begin to dip due to over inflation. This is a neutral sign in purchasing a stock.";
			mmComp = 0;
		}
		return output;
	}

	public String getRSI() {
		String output = "";
		double rsi = company.getRSI();

		if (rsi < 35) {
			output = output
					+ "The small relative strength index indicates that investors are overselling the stock, meaning the stock price is lower than"
					+ " it should be. From this we can infer a short term positive trend. This is a positive sign in purchasing a stock.";
			rsiComp = 1;
		} else if (rsi >= 35 && rsi <= 65) {
			output = output
					+ "The average relative strength index indicates that investors are neither overselling nor overbuying the stock, meaning the"
					+ " stock price is close to where it should be. From this we cannot infer any short term trend. This is a neutral sign in purchasing a stock.";
			peComp = 0;
		} else {
			output = output
					+ "The large relative strength index indicates that investors are overbuying the stock, meaning the stock price is higher than"
					+ " it should be. From this we can infer a short term negative trend. This is a negative sign in purchasing a stock.";
			peComp = -1;
		}
		return output;
	}

	public String getEMA() {
		String output = "";
		double currentEMA = company.getEMA(outlook);
		double histEMA = company.getEMA(outlook);
		double dif = difference(histEMA, currentEMA);

		if (dif <= 0) {
			output = output
					+ " Based on the negative difference between the current EMA and the historical EMA, we have determined that the stock in moving"
					+ " downward more over this time period in comparison to the previous one and is unlikely to have a short term positive trend. This is a negative sign in purchasing a stock.";
			emaComp = -1;
		} else if (dif > 0 && dif <= 20) {
			output = output
					+ " Based on the small positive difference between the current EMA and the historical EMA, we have determined that currently the"
					+ " stock trending more positively over this time period than in the previous one and is likely to continue this short term"
					+ " positive trend. This is a positive sign in purchasing a stock.";
			emaComp = 1;
		} else {
			output = output
					+ " Based on the large positive increase between the current EMA and the historical EMA, we have determined that currently the stock"
					+ " price has significantly inflated over this time period in comparison to the last one. We are uncertain whether the"
					+ " positive trend will continue or if a short term negative trend will occur. This is a neutral sign in purchasing a stock.";
			emaComp = 0;
		}
		return output;
	}

	public double difference(double previous, double current) {
		double dif = ((current - previous) * 100) / previous;
		return dif;
	}

	public int stockScore() {
		int numPos = 0;
		int numNeg = 0;
		int numNeutral = 0;
		if (peComp == 1) {
			numPos++;
		} else if (peComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (priceComp == 1) {
			numPos++;
		} else if (priceComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (mmComp == 1) {
			numPos++;
		} else if (mmComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (rsiComp == 1) {
			numPos++;
		} else if (rsiComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (emaComp == 1) {
			numPos++;
		} else if (emaComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}
		return (numPos * 3) + (numNeutral * 1) + (numNeg * -3);
	}

	public String conclusion() {
		int numPos = 0;
		int numNeg = 0;
		int numNeutral = 0;
		String output = "Putting together our analysis for each metric will determine if we overall believe the stock is likely to have a short term increase,"
				+ " is likely to have a short term decrease, or if we cannot determine the short term trend.";
		if (peComp == 1) {
			numPos++;
		} else if (peComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (priceComp == 1) {
			numPos++;
		} else if (priceComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (mmComp == 1) {
			numPos++;
		} else if (mmComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (rsiComp == 1) {
			numPos++;
		} else if (rsiComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (emaComp == 1) {
			numPos++;
		} else if (emaComp == 0) {
			numNeutral++;
		} else {
			numNeg++;
		}

		if (numPos >= 3) {
			output = output
					+ "Based on the insight we gained from the five metrics, we believe that a short term positive increase is likely to occur and "
					+ "therefore the stock should be purchased at this time.";
		} else if (numNeg >= 3) {
			output = output
					+ "Based on the insight we gained from the five metrics, we believe that a short term negative increase is likely to occur and therefore the stock should not be purchased at this time.";
		} else {
			output = output
					+ "Based on the insight we gained from the five metrics, we are unable to determine whether a short term increase or decrease is"
					+ " likely to occur and therefore further research needs to be conducted.";
		}

		return output;
	}

}