import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Selenium {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/volodymyr/Downloads/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://vns.lpnu.ua/login/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//*[@id=\"username\"]").sendKeys("halyna.zholinska.mk.2019");
        driver.findElementByXPath("//*[@id=\"password\"]").sendKeys("12.06.2002");
        driver.findElementByXPath("//*[@id=\"loginbtn\"]").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Перехід на розділ фінанси та кредити

        driver.findElementByXPath("//*[@id=\"inst1092204\"]/div/div/ul/li[21]/div/a").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // на тест теми 16

        driver.findElementByXPath("//*[@id=\"module-83495\"]/div/div/div[2]/div/a").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //огляд виконаного тесту

        driver.findElementByXPath("//*[@id=\"region-main\"]/div[1]/table/tbody/tr/td[3]/a").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //показ усіх тестів на 1 сторінці
        driver.findElementByXPath("//*[@id=\"mod_quiz_navblock\"]/div/div/div[2]/a[1]").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //нова вкладка

//        String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN);
//        driver.findElement(By.linkText("http://vns.lpnu.ua/mod/quiz/view.php?id=83496")).sendKeys(selectLinkOpeninNewTab);
//        driver.findElementByXPath("")
        ((JavascriptExecutor) driver).executeScript("window.open('http://vns.lpnu.ua/mod/quiz/view.php?id=83495')");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElementByXPath("/html/body/div[1]/div[2]/div/div/section/div[1]/div[3]/div/form/button").click();
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 110; i++) {

            String id = driver.findElementByXPath("/html/body/div[1]/div[2]/div/div/section[1]/div[1]/form/div/div[1]").getAttribute("id");
            System.out.println(id);


            driver.switchTo().window(tabs.get(0));
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String text = driver.findElementByXPath("//*[@id=\"" + id + "\"]/div[2]/div[2]/div/div").getText();
            String substring = text.substring(21);
            System.out.println(substring);
            System.out.println(substring.length());
            driver.switchTo().window(tabs.get(1));
            driver.findElement(By.xpath("//*[text() = '"+substring+"']")).click();
            if (i == 1){
                driver.findElementByXPath("/html/body/div[1]/div[2]/div/div/section[1]/div[1]/form/div/div[2]/input[1]").click();
            }else {
                driver.findElementByXPath("/html/body/div[1]/div[2]/div/div/section[1]/div[1]/form/div/div[2]/input[2]").click();
            }
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
