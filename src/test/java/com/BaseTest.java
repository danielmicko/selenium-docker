package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        //uživatel, který rozbíhá skript může předat browser variable podle toho, který chce použít prohlížeč
            //f.e. BROWSER => chrome / firefox
        //potřebujeme také vědět, kde je přítomný selenium grid
            //f.e. HUB_HOST => localhost / 10.0.1.3 / hostname
        //uživatel, který však skript rozbíhat bez předání těchto variables, potřebuje, aby byla nastavena defaultní hodnota

        //default values
        String host = "localhost"; //hub host je localhost
        DesiredCapabilities dc; //inicialiyujeme dc

        if(System.getProperty("BROWSER") != null && //když někdo vyplní tuto property
            System.getProperty("BROWSER").equalsIgnoreCase("firefox")){ //a tato property se rovná firefox
            dc = DesiredCapabilities.firefox(); //jako prohlížeš selenium použije firefox
        }else{
            dc = DesiredCapabilities.chrome(); //jinak je default firefox
        }

        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeURL="http://" + host + ":4444/wd/hub"; //na tento port mapujeme selenium/hub a přesměrováváme se na něj
        this.driver = new RemoteWebDriver(new URL(completeURL), dc); //definujeme remote webdriver, který je právě na hubu a dc je prohlížeč

        /*System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();*/
        //this.driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        //this.driver.close();
        this.driver.quit();
    }
}
