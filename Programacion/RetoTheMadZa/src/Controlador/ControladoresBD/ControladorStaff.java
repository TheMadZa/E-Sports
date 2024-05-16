package Controlador.ControladoresBD;

import Modelo.Staff;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorStaff {
    private final List<Staff> staffList;

    public ControladorStaff() {
        this.staffList = new ArrayList<>();
        System.out.println("Elementos creados de ControladorStaff.");
    }

    public void insertarStaff(Staff s) throws Exception {
        try {
            staffList.add(s);
        } catch (Exception ex) {
            throw new Exception("Error al insertar el staff: " + ex.getMessage());
        }
    }

    public void borrarStaff(Staff s) throws Exception {
        if (staffList.remove(s)) {
            System.out.println("Staff eliminado.");
        } else {
            throw new Exception("No se encontró el staff a eliminar.");
        }
    }

    public Staff buscarStaff(Integer id_staff) throws Exception {
        for (Staff staff : staffList) {
            if (staff.getIdStaff() == id_staff) {
                return staff;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ningún staff con ese ID.");
        return null;
    }

    public void modificarStaff(Staff staff) throws Exception {
        Staff s = buscarStaff(staff.getIdStaff());
        if (s != null) {
            s.setPuesto(staff.getPuesto());
            s.setNombre(staff.getNombre());
            s.setFechaNac(staff.getFechaNac());
            s.setSueldo(staff.getSueldo());
            s.setEquipo(staff.getEquipo());
        } else {
            throw new Exception("No se encontró ningún staff con el ID provisto: " + staff.getIdStaff());
        }
    }
}
