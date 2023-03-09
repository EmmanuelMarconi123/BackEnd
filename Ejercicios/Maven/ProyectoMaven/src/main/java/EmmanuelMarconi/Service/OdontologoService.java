package EmmanuelMarconi.Service;

import com.EmmanuelMarconi.Dao.IDao;
import com.EmmanuelMarconi.Model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologos;

    public OdontologoService(IDao<Odontologo> odontologos) {
        this.odontologos = odontologos;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologos.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos() {
        return odontologos.buscarTodos();
    }
}
