import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.Thread;
import java.util.List;

public class Exercise2 {
    private WebDriver driver;
    private String browserName;

    public Exercise2(WebDriver driver, String browserName) {
        this.driver = driver;
        this.browserName = browserName;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void browserStart(String webPage){
        System.out.println(browserName+": Navigating to page "+webPage);
        driver.manage().window().maximize();
        driver.get(webPage);
        codePause();
    }

    public void findElementUsingText(String textToSearch){
        List<WebElement> elementsList = driver.findElements(By.linkText(textToSearch));
        if(elementsList.isEmpty()){
            System.out.println(browserName+": Element not found using text");
        }
        else{
            System.out.println(browserName+": Element found using text");
        }
        codePause();
    }

    public void findElementUsingXpath(String usedXpath){
        List<WebElement> elementsList = driver.findElements(By.xpath(usedXpath));
        if(elementsList.isEmpty()){
            System.out.println(browserName+": Element not found using Xpath");
        }
        else{
            System.out.println(browserName+": Element found using Xpath");
        }
        codePause();
    }

    public void findElementUsingCSS(String usedCSS){
        List<WebElement> elementsList = driver.findElements(By.cssSelector(usedCSS));
        if(elementsList.isEmpty()){
            System.out.println(browserName+": Element not found using CSS");
        }
        else{
            System.out.println(browserName+": Element found using CSS");
        }
        codePause();
    }

    public void clickUsingXpath(String usedXpath){
        System.out.println(browserName+": Click on element");
        driver.findElement(By.xpath(usedXpath)).click();
        codePause();
    }

    public void findElementUsingID(String usedID){
        List<WebElement> elementsList = driver.findElements(By.id(usedID));
        if(elementsList.isEmpty()){
            System.out.println(browserName+": Element not found using ID");
        }
        else{
            System.out.println(browserName+": Element found using ID");
        }
        codePause();
    }

    public void extractTextUsingID(String usedID){
        System.out.println(browserName+": Text of element: \n"+driver.findElement(By.id(usedID)).getText());
        codePause();
    }

    public void refreshPage(){
        System.out.println(browserName+": Refresh page");
        driver.navigate().refresh();
        codePause();
    }

    public void firstUsingXpath(String usedXpath){
        String firstOne = driver.findElement(By.xpath(usedXpath)).getAttribute("innerText");
        System.out.println(browserName+": Text of first Element "+firstOne.replaceAll(" ", ""));
        codePause();
    }

    public void lastUsingXpath(String usedXpath){
        String lastOne = driver.findElement(By.xpath(usedXpath)).getAttribute("innerText");
        System.out.println(browserName+": Text of last Element "+lastOne.replaceAll(" ", ""));
        codePause();
    }

    public void closeBrowser(){
        codePause();
        driver.close();
    }

    public void codePause(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
