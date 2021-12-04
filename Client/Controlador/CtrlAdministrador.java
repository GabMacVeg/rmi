package Client.Controlador;
import java.util.Scanner;

import Client.Vistas.Menus.MenuAdministrador;
import Client.Vistas.Altas.AltaAdministrador;
import Client.Vistas.Bajas.BajaAdministrador;
import Common.Modelo.ModeloAdministrador;
import Client.Vistas.Listas.ListaAdministrador;

import Client.Vistas.Listas.ListaMaestro;
import Client.Vistas.Altas.AltaMaestro;
import Client.Vistas.Bajas.BajaMaestro;
import Common.Modelo.ModeloMaestro;

import Client.Vistas.Listas.ListaAlumno;
import Common.Modelo.ModeloAlumno;
import Client.Vistas.Altas.AltaAlumno;
import Client.Vistas.Bajas.BajaAlumno;

import Common.Modelo.ModeloCarrera;
import Client.Vistas.Altas.AltaCarrera;
import Client.Vistas.Bajas.BajaCarrera;
import Client.Vistas.Listas.ListaCarreras;

import Common.Modelo.ModeloMateria;
import Client.Vistas.Altas.AltaMateria;
import Client.Vistas.Bajas.BajaMateria;
import Client.Vistas.Listas.ListaMaterias;
import Client.Vistas.Listas.VerDatosAdmin;



public class CtrlAdministrador{

    private Scanner sc;
    private ModeloAdministrador modeloAdministrador;
    private ModeloCarrera modeloCarrera;
    private ModeloMaestro modeloMaestro;
    private ModeloAlumno modeloAlumno;
    private ModeloMateria modeloMateria;

    public CtrlAdministrador(Scanner sc, ModeloAdministrador modeloAdministrador, ModeloCarrera modeloCarrera, ModeloMaestro modeloMaestro, ModeloAlumno modeloAlumno, ModeloMateria modeloMateria ){
        
        try{

            this.sc=sc;
            this.modeloAdministrador = modeloAdministrador;
            this.modeloCarrera = modeloCarrera;
            this.modeloMaestro = modeloMaestro;
            this.modeloAlumno = modeloAlumno;
            this.modeloMateria = modeloMateria;

            MenuAdministrador menuAdmi = new MenuAdministrador(sc);
            boolean existe;

            do{
                menuAdmi.show();
                switch(menuAdmi.getOpcion()){
                    case 1://ALTA ADMINISTRADOR
                        AltaAdministrador altaadmin = new AltaAdministrador(sc);
                        existe = modeloAdministrador.buscarAdmin(altaadmin.getAdmin().getUser());
                        if(existe)
                            altaadmin.setMsg("El usuario ya existe!");
                        else{
                            modeloAdministrador.alta(altaadmin.getAdmin());    
                            altaadmin.setMsg("Usuario creado"); 
                        }                      
                    break;
                    
                    case 2://BAJA ADMINISTRADOR
                        /*BajaAdministrador bajaadmin =  new BajaAdministrador(sc);
                            bajaadmin.show();
                            existe = modeloAdministrador.buscarAdmin(bajaadmin.getAdmin());
                            if(existe){
                                //Existe el usuario
                                modeloAdministrador.eliminar(bajaadmin.getAdmin());
                                bajaadmin.setMsg("Se da de baja!");
                            }else{
                                bajaadmin.setMsg("Usuario inexistente");
                            }*/
                    break;

                    case 3://LISTADOS - ADMINISTRADORES - MESTROS - ALUMNOS
                    
                        ListaAdministrador listadoadmi  = new ListaAdministrador();
                        ListaMaestro listadomae  = new ListaMaestro();
                        ListaAlumno listadoalu = new ListaAlumno();
                        do{
                            menuAdmi.showVer();
                            switch(menuAdmi.getVer()){
                                case 1: //Ver Administradores
                                    listadoadmi.imprimirAdministradores();
                                break;
                                case 2://Ver Maestros
                                    listadomae.imprimirMaestros();
                                break;
                                case 3://Ver Alumnos
                                    listadoalu.imprimirAlumnos();
                                break;
                                case 4://Ver Todos
                                    listadoadmi.imprimirAdministradores();
                                    listadomae.imprimirMaestros();
                                    listadoalu.imprimirAlumnos();
                                break;
                                case 5://Salir
                                
                                break;
                            }         
                        }while(menuAdmi.getVer()!=5);
                    break;
                    case 4://Alta maestros
                        AltaMaestro altamae = new AltaMaestro(sc);
                        existe = modeloMaestro.buscarMaestro(altamae.getMaestro().getUser());
                        if(existe)
                            altamae.setMsg("El Maestro ya existe!");
                        else{
                            modeloMaestro.alta(altamae.getMaestro());    
                            altamae.setMsg("Maestro creado"); 
                        }
                    break;
                    case 5://baja maestros
                        /*BajaMaestro bajamae =  new BajaMaestro(sc);
                            bajamae.show();
                            existe = modeloMaestro.buscarMaestro(bajamae.getMaestro());
                            if(existe){
                                //Existe el usuario
                                modeloMaestro.eliminar(bajamae.getMaestro());
                                bajamae.setMsg("Se da de baja!");
                            }else{
                                bajamae.setMsg("Maestro inexistente");
                            }*/
                    break;
                    case 6://alta alumnos
                        AltaAlumno altaalum = new AltaAlumno(sc);
                        existe = modeloAlumno.buscarAlumno(altaalum.getAlumno().getUser());
                        if(existe)
                            altaalum.setMsg("El Alumno ya existe!");
                        else{
                            modeloAlumno.alta(altaalum.getAlumno());    
                            altaalum.setMsg("Alumno creado"); 
                        }
                    break;
                    case 7:// baja alumnos
                        /*BajaAlumno bajaalum =  new BajaAlumno(sc);
                            bajaalum.show();
                            existe = modeloAlumno.buscarAlumno(bajaalum.getAlumno());
                            if(existe){
                                //Existe el usuario
                                modeloAlumno.eliminar(bajaalum.getAlumno());
                                bajaalum.setMsg("Se da de baja!");
                            }else{
                                bajaalum.setMsg("Alumno inexistente");
                            }*/
                    break;
                    case 8://alta materias
                        AltaMateria altamat = new AltaMateria(sc);
                        existe = modeloMateria.buscarMateria(altamat.getMateria().getNombre());
                        if(existe)
                            altamat.setMsg("La Materia ya existe!");
                        else{
                            modeloMateria.altaMateria(altamat.getMateria());    
                            altamat.setMsg("Materia creada"); 
                        }
                    break;
                    case 9://baja materias
                        /*BajaMateria bajamat =  new BajaMateria(sc);
                            bajamat.show();
                            existe = modeloMateria.buscarMateria(bajamat.getMateria());
                            if(existe){
                                //Existe la materia
                                modeloMateria.eliminar(bajamat.getMateria());
                                bajamat.setMsg("Se da de baja!");
                            }else{
                                bajamat.setMsg("Materia inexistente");
                            }*/
                    break;
                    case 10://lista materias
                        //ListaMaterias listadomaterias = new ListaMaterias();
                        //listadomaterias.imprimirMaterias(modeloMateria.getMaterias());
                    break;
                    case 11://alta carreras
                    AltaCarrera altacarrera = new AltaCarrera(sc);
                        existe = modeloCarrera.buscarCarrera(altacarrera.getCarrera().getNombre());
                        if(existe)
                            altacarrera.setMsg("La carrera  ya existe!");
                        else{
                            modeloCarrera.alta(altacarrera.getCarrera());
                            altacarrera.setMsg("La carrera se creo");
                        }
                    break;
                    case 12://baja carreras
                    /*BajaCarrera bajacarrera = new BajaCarrera(sc);
                        do{
                            bajacarrera.show();
                            existe = modeloCarrera.buscarCarrera(bajacarrera.getNombre());
                            if(existe){
                                modeloCarrera.eliminar(bajacarrera.getNombre());
                                bajacarrera.setMsg("Se da de baja!");
                            }else{
                                bajacarrera.setMsg("Carrera inexistente. Intenta de nuevo!");
                            }
                        }while(!existe);*/
                    break;
                    case 13://lista carreras
                        //ListaCarreras listadocarreras = new ListaCarreras();
                        //listadocarreras.imprimirCarreras(modeloCarrera.getCarreras());  
                    break;
                    case 14://Ver DATOS
                        //VerDatosAdmin verDatosAdmin = new VerDatosAdmin();
                        //verDatosAdmin.imprimirDatosAdmin(modeloAdministrador.getAdministradores(),nombreAd);
                    break;
                    case 20://salir
                    break;
                    default://opcion incorrecta
                    menuAdmi.setMsg("Opcion incorrecta");
                }

            }while(menuAdmi.getOpcion()!=20);//aqi acaba el while
        }catch(Exception e){
            //TODO: handle exception
        }
    }//constructor

}//fin
