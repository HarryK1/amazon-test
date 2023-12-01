package amazon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
 * 1. Open the url https://www.amazon.co.uk/
 * 2. Type "Dell Laptop" in the search box and press enter or click on search
 *    Button.
 * 3. Click on the checkbox brand Dell on the left side.
 * 4. Verify that the  30(May be different) products are displayed on the page.
 * 5. Print all product names in the console.
 * 6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
 * Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
 * 7. Varify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
 * Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
 * 5. Close the Browser.
 */
public class TestSuite extends BaseTest{

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    //Type "Dell Laptop" in the search box and press enter or click on search
    //   Button.
    @Test

    public void laptop() throws InterruptedException {
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("Dell laptop");
        searchField.sendKeys(Keys.ENTER);

     //Click on the checkbox brand Dell on the left side.
        WebElement brandCheckbox = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]"));////div[@class='nav-search-submit nav-sprite']//(//i[@class='a-icon a-icon-checkbox'])[3]
        brandCheckbox.click();

      //Verify that the  30(May be different) products are displayed on the page.
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']"));
        System.out.println("Total product: " + productList.size());
        System.out.println("-------------------");

        for (WebElement e : productList){
            System.out.println(e.getText());
        }

        //Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
          //      * Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
        driver.findElements(By.xpath("(//img[@class='s-image'])[23]"));

        //Verify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
        // * Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
        String expectedName = "Dell XPS 15 9530 15.6 OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver";
        String actualName = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[19]")).getText();
        Assert.assertEquals(expectedName, actualName);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
