package controlador.ControladoresBD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.Staff;

import javax.swing.*;

public class ControladorStaff {
    private ControladorModelo cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Staff s;

    public ControladorStaff(ControladorModelo cm)
    {
        this.cm = cm;

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();

        System.out.println("Elementos creados");
    }

    public void terminar() throws Exception{
        em.close();
        emf.close();
    }

    public void insertarStaff(Staff s) throws Exception
    {
        try
        {
            transaction.begin();
            em.persist(s);
            transaction.commit();
        }
        catch (Exception ex)
        {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public void borrarStaff() throws Exception
    {
        transaction.begin();
        em.remove(s);
        transaction.commit();
    }

    public Staff buscarStaff(Integer id_staff) throws Exception
    {
        transaction.begin();
        s = em.find(Staff.class, id_staff);
        if (s == null){
            JOptionPane.showMessageDialog(null,"No hay ningún staff con ese id");
        }
        transaction.commit();
        return s;
    }

    public void modificarStaff(Staff staff) throws Exception
    {
        transaction.begin();
        Staff s = em.find(Staff.class, staff.getIdStaff());
        if (s != null){

            s.setPuesto(staff.getPuesto());
            s.setNombre(staff.getNombre());
            s.setFechaNac(staff.getFechaNac());
            s.setSueldo(staff.getSueldo());
            s.setEquipoByIdEquipo(staff.getEquipoByIdEquipo());

            em.merge(s);
            transaction.commit();
        }
        else
        {
            throw new Exception("No se encontró ningún staff con el ID provisto: "+ staff.getIdStaff());
        }
    }
}
