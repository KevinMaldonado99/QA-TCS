package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipal {

    public static final Target PRODUCTO =
            Target.the("producto {0}")
                    .locatedBy("//a[text()='{0}']");

    public static final Target BOTON_AGREGAR_CARRITO =
            Target.the("boton agregar al carrito")
                    .located(By.linkText("Add to cart"));

    public static final Target BOTON_HOME =
            Target.the("boton home")
                    .located(By.id("nava"));

    public static final Target BOTON_CARRITO =
            Target.the("boton carrito")
                    .located(By.id("cartur"));

    public static final Target BOTON_LUGAR_ORDEN =
            Target.the("boton lugar orden")
                    .located(By.xpath("//button[text()='Place Order']"));

    public static final Target INPUT_NOMBRE =
            Target.the("campo nombre")
                    .located(By.id("name"));

    public static final Target INPUT_PAIS =
            Target.the("campo pais")
                    .located(By.id("country"));

    public static final Target INPUT_CIUDAD =
            Target.the("campo ciudad")
                    .located(By.id("city"));

    public static final Target INPUT_TARJETA =
            Target.the("campo tarjeta")
                    .located(By.id("card"));

    public static final Target INPUT_MES =
            Target.the("campo mes")
                    .located(By.id("month"));

    public static final Target INPUT_ANIO =
            Target.the("campo anio")
                    .located(By.id("year"));

    public static final Target BOTON_COMPRA =
            Target.the("boton compra")
                    .located(By.xpath("//button[text()='Purchase']"));

    public static final Target MENSAJE_COMPRA_EXITOSA =
            Target.the("mensaje de compra exitosa")
                    .located(By.xpath("//h2[contains(text(),'Thank you for your purchase')]"));
    
    public static final Target TEXTO_CONFIRMACION =
            Target.the("texto de confirmacion de compra")
                    .located(By.className("sweet-alert"));
}