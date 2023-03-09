import java.util.List;

public class ProxyAccederDocumento implements GoogleDIve {

    private AccesoConcedido accesoConcedido;

    private List<String> emailsBloqueados;


    public ProxyAccederDocumento(AccesoConcedido accesoConcedido, List<String> emailsBloqueados) {
        this.accesoConcedido = accesoConcedido;
        this.emailsBloqueados = emailsBloqueados;
    }

    @Override
    public void traerDocumento(String url, String email) {
        if ( !this.emailsBloqueados.contains(email) ){
            this.accesoConcedido.traerDocumento(url,email);
        }
        else {
            System.out.println("no tienes acceso a este documento");
        }
    }
}
