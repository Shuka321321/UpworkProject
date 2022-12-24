import models.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConvertPage;
import utils.DataReader;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static utils.DataReader.writeToModel;

public class Tests extends BaseTest {

    private final Data data = writeToModel(DataReader.TestdataContentData, Data.class);

    ConvertPage convertPage = new ConvertPage();

    @Test(priority = 1)
    public void sellAndBuyInputTest() {
        convertPage.waitLoaderIcon();
        convertPage.fillAmountBuyInput(data.getAmount());
        Assert.assertEquals(convertPage.getAmountBuyInputValue(), data.getAmount(), "SellAmount input is filled");

        convertPage.fillAmountSellInput(data.getAmount());
        Assert.assertEquals(convertPage.getAmountBuyInputValue(), "", "BuyAmount is empty");

        convertPage.fillAmountBuyInput(data.getAmount());
        Assert.assertEquals(convertPage.getAmountSellInputValue(), "", "SellAmount is empty");
    }

    @Test(priority = 2)
    public void countrySelectTest() {
        convertPage.waitLoaderIcon();
        convertPage.clickChooseCountryButton();
        convertPage.clickCountryDropdownButton();
        convertPage.clickUnitedKingdomInDropDown();
        convertPage.waitLoaderIcon();

        Assert.assertEquals(convertPage.getCurrencyValue(), data.getUnitedKingdomCurrency(),
                "UK currency is displayed");
        Assert.assertEquals(convertPage.getCurrencyInTableText(), data.getEuroCurrencyFromTable(),
                "UK currency is displayed in table");

        convertPage.clickChooseCountryButton();
        convertPage.clickCountryDropdownButton();
        convertPage.clickLithuaniaInDropDown();
        convertPage.waitLoaderIcon();

        Assert.assertEquals(convertPage.getCurrencyValue(), data.getEuroCurrency(),
                "EURO currency is displayed");
        Assert.assertEquals(convertPage.getCurrencyInTableText(), data.getUsdCurrencyFromTable(),
                "EURO currency is displayed in table");
    }

    @Test(priority = 3)
    public void test() {
        convertPage.waitLoaderIcon();

        double payersaValue = Double.parseDouble(convertPage.getPayersaValue());
        double swedbankValue = Double.parseDouble(convertPage.getSwedbankValue());
        double lossTextBoxValue = Double.parseDouble(convertPage.getLossTextBoxValue()
                .replaceAll("[\\[\\]()]", ""));

        BigDecimal diff = new BigDecimal(swedbankValue - payersaValue);
        double rounded = diff.setScale(2, RoundingMode.HALF_UP).doubleValue();

        Assert.assertEquals(rounded, lossTextBoxValue, "Text box value is correct");

    }
}