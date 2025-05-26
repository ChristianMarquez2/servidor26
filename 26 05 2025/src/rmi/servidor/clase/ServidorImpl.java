package rmi.servidor.clase;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ServidorImpl extends UnicastRemoteObject implements Servidor {
    private static ArrayList<Persona> listPersonas(){
        ArrayList<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona(1, "Juan", "<juan@empresa.com>", "Gerente", 100000));
        lista.add(new Persona(2, "Maria", "<maria@empresa.com>", "Jefe", 80000));
        lista.add(new Persona(3, "Pedro", "<pedro@empresa.com>", "administador", 50000));
        lista.add(new Persona(4, "Ana", "<ana@empresa.com>", "tecnico", 40000));
        lista.add(new Persona(5, "Jose", "<jose@empresa.com>", "Empleado", 30000));
        lista.add(new Persona(6, "Luis", "<lusi@empresa.com>", "Empleado", 20000));
        lista.add(new Persona(7, "Carlos", "<carlos@empresa.com>", "secretario", 10000));
        lista.add(new Persona(8, "Jorge", "<jorge@empresa.com>", "colaborador", 5000));
        return lista;
    }
    private static String getPersona(int id){
        return "Nombre: "+listPersonas().get(id-1).getNombre()+
                "\n"+ "Correo: "+listPersonas().get(id-1).getCorreo()+
                "\n"+ "Cargo: "+listPersonas().get(id-1).getCargo()+
                "\n"+ "Sueldo: "+listPersonas().get(id-1).getSueldo();
    }
    public ServidorImpl() throws RemoteException {
    }
    @Override
    public String consultar(int id) throws Exception {
        if(id<listPersonas().size() +1){
            return getPersona(id);
        }else {
            return "No existe datos del empleado";
        }
    }
}