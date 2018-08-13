package se.javierdlc;

import java.util.HashMap;
import java.util.Map;

public class CoinChanger {
    private double[] coinTypes;

    public CoinChanger(double[] coinTypes) {
        this.coinTypes = coinTypes;
    }

    public Map<Double, Integer> makeChange(double v) {
        Map<Double, Integer> map = new HashMap<>();
        double total = v;
        sortCoinTypes();
        for (double coinType : coinTypes) {
            int maxCoins = (int) (total / coinType);
            map.put(coinType, maxCoins);
            total -= maxCoins * coinType;
        }
        return map;
    }

    private void sortCoinTypes() {
        double temp;
        for (int i = 0; i < coinTypes.length; i++) {
            if (i < coinTypes.length - 1) {
                if (coinTypes[i] < coinTypes[i + 1]) {
                    temp = coinTypes[i];
                    coinTypes[i] = coinTypes[i + 1];
                    coinTypes[i + 1] = temp;
                }
            }
        }
    }
}
