package tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import ui.PaginaPrincipal;

public class CompletarCompra implements Task {

    public static CompletarCompra ahora(){
        return Tasks.instrumented(CompletarCompra.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(PaginaPrincipal.BOTON_CARRITO),
                Click.on(PaginaPrincipal.BOTON_LUGAR_ORDEN),

                Enter.theValue("Kevin").into(PaginaPrincipal.INPUT_NOMBRE),
                Enter.theValue("Ecuador").into(PaginaPrincipal.INPUT_PAIS),
                Enter.theValue("Quito").into(PaginaPrincipal.INPUT_CIUDAD),
                Enter.theValue("123456").into(PaginaPrincipal.INPUT_TARJETA),
                Enter.theValue("12").into(PaginaPrincipal.INPUT_MES),
                Enter.theValue("2026").into(PaginaPrincipal.INPUT_ANIO),

                Click.on(PaginaPrincipal.BOTON_COMPRA)

        );
    }
}