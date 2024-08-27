package kadane_algo;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {

        int profit = 0;
        int buyPrice = prices[0];

        for (int todayPrice: prices) {
            int currentProfit = todayPrice - buyPrice;

            // If currentProfit is greater than previous profit, update the profit
            profit = Math.max(currentProfit, profit);

            // If we get a buy price lesser than we have got previously, update the buy price
            buyPrice = Math.min(todayPrice, buyPrice);
        }
        return profit;
    }
}
