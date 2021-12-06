package Client.Controlador;

import java.util.Scanner;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import Client.Vistas.Login;

import Common.Modelo.ModeloAdministrador;
import Common.Modelo.ModeloAlumno;
import Common.Modelo.ModeloMaestro;
import Common.Modelo.ModeloCarrera;
import Common.Modelo.ModeloMateria;
import Common.Modelo.ModeloHorarioAlumno;
import Common.Modelo.ModeloHorarioMaestro;

import Common.Dataobjects.Administrador;
import Common.Dataobjects.Alumno;
import Common.Dataobjects.Carrera;
import Common.Dataobjects.Maestro;
import Common.Dataobjects.Materia;
import Common.Dataobjects.HorarioAlumno;
import Common.Dataobjects.HorarioMaestro;

public class CtrlPrincipal{
    private Scanner sc = new Scanner(System.in);
    private Login login = new Login(sc);
    private Registry registry;

    private ModeloAdministrador modeloAdministrador;
    private ModeloAlumno modeloAlumno;
    private ModeloMaestro modeloMaestro;
    private ModeloCarrera modeloCarrera;
    private ModeloMateria modeloMateria;
    private ModeloHorarioMaestro modeloHorarioMaestro;
    private ModeloHorarioAlumno modeloHorarioAlumno;

    public CtrlPrincipal(){
        try{
            registry = LocateRegistry.getRegistry("localhost");
            modeloAdministrador = (ModeloAdministrador)registry.lookup("ModeloAdministrador");    
            modeloAlumno = (ModeloAlumno)registry.lookup("ModeloAlumno");  
            modeloMaestro = (ModeloMaestro)registry.lookup("ModeloMaestro");  
            modeloCarrera = (ModeloCarrera)registry.lookup("ModeloCarrera");
            modeloMateria = (ModeloMateria)registry.lookup("ModeloMateria");
            modeloHorarioMaestro = (ModeloHorarioMaestro)registry.lookup("ModeloHorarioMaestro");  
            modeloHorarioAlumno = (ModeloHorarioAlumno)registry.lookup("ModeloHorarioAlumno");  

            do{
            login.show();
            Maestro maestro = modeloMaestro.login(login.getUser(),login.getPass());
            Administrador administrador = modeloAdministrador.login(login.getUser(),login.getPass());
            Alumno alumno = modeloAlumno.login(login.getUser(),login.getPass());
            if(maestro!=null){
                int identificadorM = modeloMaestro.buscarMatricula(login.getUser());
                String nombreM = modeloMaestro.buscarNombre(login.getUser());
                new CtrlMaestro(sc,nombreM,identificadorM , modeloMaestro,modeloCarrera,modeloMateria, modeloHorarioMaestro, modeloHorarioAlumno);                
            }else{
                if(administrador!=null){
                    String nombreAd = modeloAdministrador.buscarNombre(login.getUser());
                    new CtrlAdministrador(sc,nombreAd,modeloAdministrador, modeloCarrera, modeloMaestro, modeloAlumno, modeloMateria);
                }else{
                    if(alumno!=null){
                        int identificadorA = modeloAlumno.buscarMatricula(login.getUser());
                        String nombreA = modeloAlumno.buscarNombre(login.getUser());
                        new CtrlAlumno(sc,nombreA, identificadorA, modeloCarrera, modeloMateria, modeloHorarioAlumno, modeloAlumno);
                    }else{
                        login.setMsg("Incorrecto");
                        
                    }
                }
            }        
        }while(true);

        }catch (Exception e) {
        //TODO: handle exception
        }
    }
}
