package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ConvertPage extends Form {
    private final ITextBox amountSellInput = getElementFactory()
            .getTextBox(By.xpath("//label[text()='Sell']/following-sibling::input"),
                    "amountSellInput");
    private final ITextBox amountBuyInput = getElementFactory()
            .getTextBox(By.xpath("//label[text()='Buy']/following-sibling::input"),
                    "amountSellInput");

    private final IButton filterButton = getElementFactory()
            .getButton(By.xpath("//button[contains(text(),'Filter')]"),
                    "filterButton");

    private final IButton loader = getElementFactory()
            .getButton(By.xpath("//div[@data-ng-show='currencyExchangeVM.loading']"),
                    "loaderLogo");

    private final IButton chooseCountryButton = getElementFactory()
            .getButton(By.xpath("//span[@role='button']"),
                    "chooseCountryButton");

    private final IButton countryDropdownButton = getElementFactory()
            .getButton(By.id("countries-dropdown"),
                    "countryDropdownButton");

    private final IButton unitedKingdomInDropDown = getElementFactory()
            .getButton(By.xpath("//ul[@aria-labelledby='countries-dropdown']/child::li[8]"),
                    "unitedKingdomInDropDown");

    private final IButton LithuaniaInDropDown = getElementFactory()
            .getButton(By.xpath("//ul[@aria-labelledby='countries-dropdown']/child::li[1]"),
                    "unitedKingdomInDropDown");

    private final ITextBox currencySell = getElementFactory()
            .getTextBox(By.xpath("//label[text()='Sell']/following-sibling::div/div/span/span/span"),
                    "currencySell");

    private final ITextBox currencyInTable = getElementFactory()
            .getTextBox(By.xpath("//tbody[contains(@data-ng-if,'currencyExchange')]/tr[1]/td[1]"),
                    "currencyInTable");

    private final ITextBox payersaAmount = getElementFactory()
            .getTextBox(By.xpath("//td[@data-title='Paysera rate']/span/span/span"),
                    "payersaAmount");

    private final ITextBox swedbankAmount = getElementFactory()
            .getTextBox(By.xpath("//td[@data-title='Swedbank amount']/span/span/span"),
                    "payersaAmount");

    private final ITextBox lossTextBox = getElementFactory()
            .getTextBox(By.xpath("//span[contains(@class,'other-bank-loss')]"),
                    "lossTextBox");

    public ConvertPage() {
        super(By.xpath("//label[text()='Sell']/following-sibling::input"),
                "amountSellInput");
    }

    public void fillAmountSellInput(String amount) {
        amountSellInput.clearAndType(amount);
    }

    public String getAmountSellInputValue() {
        return amountSellInput.getValue();
    }

    public void fillAmountBuyInput(String amount) {
        amountBuyInput.clearAndType(amount);
    }

    public String getAmountBuyInputValue() {
        return amountBuyInput.getValue();
    }

    public void clickChooseCountryButton() {
        chooseCountryButton.click();
    }

    public void clickCountryDropdownButton() {
        countryDropdownButton.click();
    }

    public void clickUnitedKingdomInDropDown() {
        unitedKingdomInDropDown.click();
    }

    public String getCurrencyValue() {
        return currencySell.getText();
    }

    public void waitLoaderIcon() {
        loader.state().waitForNotDisplayed();
    }

    public String getCurrencyInTableText() {
        return currencyInTable.getText();
    }

    public void clickLithuaniaInDropDown() {
        LithuaniaInDropDown.click();
    }

    public String getPayersaValue() {
        return payersaAmount.getText();
    }

    public String getSwedbankValue() {
        return swedbankAmount.getText();
    }

    public String getLossTextBoxValue() {
        return lossTextBox.getText();
    }


}
