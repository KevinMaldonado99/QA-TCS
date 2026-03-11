package pasosdefinitions;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tareas.AgregarProductosCarrito;
import tareas.CompletarCompra;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.questions.Text;
import static org.hamcrest.Matchers.containsString;
import ui.PaginaPrincipal;
import net.serenitybdd.core.Serenity;
import models.ProductosCSVReader;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import tareas.AbrirPagina;
public class CompraPasosDef {

    @Managed(driver = "firefox")
    WebDriver navegador;

    Actor usuario = Actor.named("Kevin");
    String productoComprado1;
    String productoComprado2;

    /*@Given("el usuario abre la página de Demoblaze")
    public void abrirPaginaDemoblaze() {

        navegador = new FirefoxDriver();
        navegador.manage().window().maximize();
        navegador.get("https://www.demoblaze.com");

        usuario.can(BrowseTheWeb.with(navegador));
    }

     */
    @Given("el usuario abre la pagina de Demoblaze")
    public void abrirPaginaDemoblaze() {

        navegador.manage().window().maximize();
        navegador.get("https://www.demoblaze.com");

        usuario.can(BrowseTheWeb.with(navegador));
    }



    @When("el usuario agrega {string} y {string} al carrito")

    public void agregarProductosAlCarrito(String producto1, String producto2) {

        productoComprado1 = producto1;
        productoComprado2 = producto2;

        usuario.attemptsTo(
                AgregarProductosCarrito.conDatos(producto1, producto2)
        );
    }

    @When("el usuario agrega productos desde csv")
    public void agregarProductosDesdeCSV() {

        var productos = ProductosCSVReader.leerProductos();

        for (String[] fila : productos) {

            String producto1 = fila[0];
            String producto2 = fila[1];

            productoComprado1 = producto1;
            productoComprado2 = producto2;

            // Registrar en Serenity los productos usados desde CSV
            Serenity.recordReportData()
                    .withTitle("Productos cargados desde CSV")
                    .andContents(
                            "Producto 1: " + producto1 + "\n" +
                                    "Producto 2: " + producto2
                    );

            usuario.attemptsTo(
                    AbrirPagina.enDemoblaze()
            );

            usuario.attemptsTo(
                    AgregarProductosCarrito.conDatos(producto1, producto2)
            );

        }
    }

    @And("el usuario completa la compra")
    public void completarCompra() {

        usuario.attemptsTo(
                CompletarCompra.ahora()
        );

    }

    @Then("la compra deberia ser exitosa")
    public void validarCompra() {

        usuario.attemptsTo(
                WaitUntil.the(PaginaPrincipal.MENSAJE_COMPRA_EXITOSA, isVisible()).forNoMoreThan(10).seconds()
        );

        usuario.should(
                seeThat(
                        Text.of(PaginaPrincipal.MENSAJE_COMPRA_EXITOSA),
                        containsString("Thank you for your purchase!")
                )
        );

        String confirmacion = Text.of(PaginaPrincipal.TEXTO_CONFIRMACION)
                .answeredBy(usuario);

        String[] datos = confirmacion.split("\n");

        String id = datos[1].replace("Id:", "").trim();
        String monto = datos[2].replace("Amount:", "").trim();
        String tarjeta = datos[3].replace("Card Number:", "").trim();
        String nombre = datos[4].replace("Name:", "").trim();
        String fecha = datos[5].replace("Date:", "").trim();

        System.out.println("====================================");
        System.out.println("COMPRA REALIZADA CORRECTAMENTE");
        System.out.println("====================================");

        System.out.println("Productos comprados:");
        System.out.println("- " + productoComprado1);
        System.out.println("- " + productoComprado2);
        System.out.println("");

        System.out.println("ID de compra: " + id);
        System.out.println("Monto total: " + monto);
        System.out.println("Número de tarjeta: " + tarjeta);
        System.out.println("Nombre del cliente: " + nombre);
        System.out.println("Fecha de compra: " + fecha);

        System.out.println("====================================");
        Serenity.recordReportData()
                .withTitle("Detalle de la compra")
                .andContents(
                        "Productos comprados:\n" +
                                "- " + productoComprado1 + "\n" +
                                "- " + productoComprado2 + "\n\n" +
                                "ID de compra: " + id + "\n" +
                                "Monto total: " + monto + "\n" +
                                "Número de tarjeta: " + tarjeta + "\n" +
                                "Nombre del cliente: " + nombre + "\n" +
                                "Fecha de compra: " + fecha
                );
    }
}