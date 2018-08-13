package se.javierdlc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class CoinChangerTest {

    @Before
    public void setup() {

    }


    @Test
    public void correctChangeWhenUsingOneCoinType() {
        //Arrange
        double[] coinTypes = new double[]{1.0};
        CoinChanger sut = new CoinChanger(coinTypes);
        //Act
        Map<Double, Integer> myChange = sut.makeChange(14.0);
        //Assert
        Assert.assertEquals("got the right amount", 14, (int) myChange.get(1.0));
    }

    @Test
    public void correctChangeWhenUsingTwoCoinType() {
        //Arrange
        double[] coinTypes = new double[]{5.0, 1.0};
        CoinChanger sut = new CoinChanger(coinTypes);
        //Act
        Map<Double, Integer> myChange = sut.makeChange(14.0);
        //Assert
        Assert.assertEquals("got the right amount", 4, (int) myChange.get(1.0));
        Assert.assertEquals("got the right amount", 2, (int) myChange.get(5.0));
    }

    @Test
    public void correctChangeWhenUsingTwoCoinTypeInDifferentOrders() {
        //Arrange
        double[] coinTypes = new double[]{1.0, 5.0};
        CoinChanger sut = new CoinChanger(coinTypes);
        //Act
        Map<Double, Integer> myChange = sut.makeChange(14.0);
        //Assert
        Assert.assertEquals("got the right amount", 4, (int) myChange.get(1.0));
        Assert.assertEquals("got the right amount", 2, (int) myChange.get(5.0));
    }

    @Test
    public void correctChangeWhenUsingTwoCoinTypeWithDecimalValue() {
        //Arrange
        double[] coinTypes = new double[]{1.0, 5.0, 0.25, 0.5};
        CoinChanger sut = new CoinChanger(coinTypes);
        //Act
        Map<Double, Integer> myChange = sut.makeChange(13.75);
        //Assert
        Assert.assertEquals("got the right amount", 3, (int) myChange.get(1.0));
        Assert.assertEquals("got the right amount", 2, (int) myChange.get(5.0));
        Assert.assertEquals("got the right amount", 1, (int) myChange.get(0.25));
        Assert.assertEquals("got the right amount", 1, (int) myChange.get(0.5));
    }
}