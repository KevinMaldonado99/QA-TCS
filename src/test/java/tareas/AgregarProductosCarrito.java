package tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import ui.PaginaPrincipal;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProductosCarrito implements Task {

    private String producto1;
    private String producto2;

    public AgregarProductosCarrito(String producto1, String producto2) {
        this.producto1 = producto1;
        this.producto2 = producto2;
    }

    public static AgregarProductosCarrito conDatos(String producto1, String producto2){
        return Tasks.instrumented(AgregarProductosCarrito.class, producto1, producto2);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("Agregando productos: " + producto1 + " y " + producto2);

        // Registrar datos en el reporte de Serenity
        Serenity.recordReportData()
                .withTitle("Productos agregados al carrito")
                .andContents(
                        "Producto 1: " + producto1 + "\n" +
                                "Producto 2: " + producto2
                );

        actor.attemptsTo(

                WaitUntil.the(PaginaPrincipal.PRODUCTO.of(producto1), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaPrincipal.PRODUCTO.of(producto1)),

                WaitUntil.the(PaginaPrincipal.BOTON_AGREGAR_CARRITO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaPrincipal.BOTON_AGREGAR_CARRITO)

        );

        // esperar y aceptar alert producto 1
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();

        actor.attemptsTo(

                WaitUntil.the(PaginaPrincipal.BOTON_HOME, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaPrincipal.BOTON_HOME),

                WaitUntil.the(PaginaPrincipal.PRODUCTO.of(producto2), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaPrincipal.PRODUCTO.of(producto2)),

                WaitUntil.the(PaginaPrincipal.BOTON_AGREGAR_CARRITO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaPrincipal.BOTON_AGREGAR_CARRITO)

        );

        // esperar y aceptar alert producto 2
        wait.until(ExpectedConditions.alertIsPresent());
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();

    }

}