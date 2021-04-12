package EvaluacionEmpleosChoucairtesting.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QAEmpleados {

    public static void main(String[] args) throws InterruptedException {
        //Instanciar un objeto WebDriver
        WebDriver driver;
        //Declarar variables
        //String baseURL = "http://live.demoguru99.com/index.php/";
        String baseURL = "https://www.tottus.com.pe/";//https://www.tottus.com.pe/"
        String actualResult = "";
        String expectedResult = "s/ 419 UN";

        String chromePath = System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
        //Indicar la localización del archivo chromedriver.exe
        System.setProperty("webdriver.chrome.driver",chromePath);
        //Abrir el navegador Chrome
        driver = new ChromeDriver();
        //Maximizar la pantalla
        driver.manage().window().maximize();
        //Nevegar en la página Chrome
        driver.get(baseURL);

        //Clic en el link de TV
        Thread.sleep(5000);

        WebElement IntDOR = driver.findElement(By.xpath("//*[@id=\"Header\"]/div[2]/div[2]/ul/li[5]"));
        IntDOR.click();

        Thread.sleep(5000);

        WebElement Dormitorio  = driver.findElement(By.xpath("//*[@id=\"Header\"]/div[2]/div[2]/ul/li[10]/div/div[2]/div[3]/div/div/div/a[1]"));
        Dormitorio.click();

        //Clic en el botón Add To Cart en F12 copy xpath
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();

        // WebElement total= driver.findElement(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]"));
        //total.click();

        //Obtener el precio
        Thread.sleep(5000);
        // actualResult = driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-total>span>span")).getText();
        WebElement total=  driver.findElement(By.cssSelector("#container>div.productList>section>div.jsx-1125367764.content>div.jsx-4126528526.items>ul>li:nth-child(1)>section>div.jsx-25214388.ProductPrice>span>span.list.price.medium.cmrPrice"));
        actualResult=total.getText();

        if (actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba Exitosa. El resultado actual es: " + actualResult + " es igual a " + expectedResult);
        }else{
            System.out.println("Prueba Fallida. El resultado actual es: " + actualResult + " no es igual a " + expectedResult);
        }
        driver.close();
    }
}
