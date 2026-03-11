package tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirPagina implements Task {

    private String url;

    public AbrirPagina(String url) {
        this.url = url;
    }

    public static AbrirPagina enDemoblaze() {
        return instrumented(AbrirPagina.class, "https://www.demoblaze.com");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}