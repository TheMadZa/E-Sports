package Controlador.ControladoresBD;

import Modelo.EquipoCompeticion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ControladorEquiposCompeticiones {
    private EntityManager em;
    private EntityTransaction transaction;
    private EquipoCompeticion ec;

    public ControladorEquiposCompeticiones(EntityManager em, EntityTransaction transaction)
    {
        this.em = em;
        this.transaction = transaction;

        System.out.println("Elementos creados");
    }

    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception
    {
        transaction.begin();
        List<EquipoCompeticion> lista = em.createQuery("select ec from EquipoCompeticion ec order by puntos",
                EquipoCompeticion.class).getResultList();
        transaction.commit();
        return lista;
    }
}
