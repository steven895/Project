/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Objetos.Sensor;
import Recursos.ManejoArchivo;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tago
 */
public class Sistema {

<<<<<<< HEAD
    private static ArrayList<Sensor> sensores = cargarSensores();
    private static ArrayList<Usuario> usuarios = ManejoArchivo.obtenerUsuarios("usuarios.txt");

=======
>>>>>>> a650824f123749caafce42ca3ec6140d5631b5ca
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario user = null;
        int op = 0;
        while (op != 6) {
            op = Menu();
            switch (op) {
                case 1:
                    user = crearCuenta();
                    break;
                case 2:
                    user = iniciarSesion();
                    break;
                case 3:
                    System.out.println("|||||     Elija notificacion que desea desactivar     |||||");
                    System.out.println("1.Notificacion Propiedad observable");
                    System.out.println("2.Notificacion Dispositivo");
                    int op2 = 0;
                    while (op2 <= 0 || op2 > 2) {
                        Scanner sc2 = new Scanner(System.in);
                        System.out.print("Seleccione un numero: ");
                        op2 = sc2.nextInt();
                    }
                    switch (op2) {
                        case 1:
                            crearNotiXPropiedad(user);
                            break;
                        case 2:
                            crearNotiXDispositivo(user);
                            break;
                        default:
                            System.out.println("Lo ingreasdo no esta entre las opciones intente de nuevo");
                    }
                    break;
                case 4:
                    generarNotificaciones(user);
                    break;
                case 5:
                    desactivarNotificacion(user);
                    break;
                case 6:
                    System.out.println("SALIENDO******");
                    break;
                default:
                    System.out.println("Esto no forma parte de las opciones intente de nuevo");

            }
        }
    }

    public static int Menu() {
        System.out.println("|||||     MENU     |||||");
        System.out.println("1.Registrar usuario");
        System.out.println("2.Iniciar sesion");
        System.out.println("3.Programar notificacion");
        System.out.println("4.Generar Notificaciones");
        System.out.println("5.Desactivar Notificaciones");
        System.out.println("6.Salir");
        System.out.println("Elija un numero:");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        return op;
    }

    public static Usuario crearCuenta() {
        System.out.println("|||||     Creacion de cuenta usuario     |||||");
        System.out.println("Ingrese id de usuario:");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        System.out.println("Ingrese password: ");
        String pass = sc.nextLine();

        Usuario user = new Usuario(id, pass);
        if (usuarios.contains(user)) {
            System.out.println("ADVERTENCIA: Este usuario ya a sido creado anteriormente intente de nuevo");
            return null;
        }
        System.out.println("|||   Creacion de cuenta exitosa   |||");
        usuarios.add(user);
        String cadena = "";
        for (Usuario us : usuarios) {
            cadena += us.getId() + "," + us.getPassword() + "n";
        }
        ManejoArchivo.EscribirArchivo("usuarios.txt", cadena);
        return user;
    }

    public static Usuario iniciarSesion() {
        System.out.println("|||||     Inicio de sesion     |||||");
        System.out.println("Ingrese id de usuario:");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        System.out.println("Ingrese password: ");
        String pass = sc.nextLine();
        Usuario user = new Usuario(id, pass);
        if (usuarios.contains(user)) {
            System.out.println("|||   Bienvenid@   |||");
            return user;
        }
        System.out.println("ADVERTENCIA: este usuario no existe en la base de datos cree una cuenta");
        return null;
    }

    public static ArrayList<Sensor> cargarSensores() {
        ArrayList<Sensor> sensores = ManejoArchivo.LeeSensores("data.csv");
        return sensores;
    }
<<<<<<< HEAD

    public static void crearNotiXPropiedad(Usuario user) {
        if (user == null) {
            System.out.println("ADVERTENCIA: Primero inicie sesion o cree una cuenta ");
        } else {
            String[] propiedades = {"CO", "Ligth", "LPG", "Motion", "Smoke", "Temp"};
            System.out.println("|||||    Propiedades Observables    |||||");
            System.out.println("1." + propiedades[0]);
            System.out.println("2." + propiedades[1]);
            System.out.println("3." + propiedades[2]);
            System.out.println("4." + propiedades[3]);
            System.out.println("5." + propiedades[4]);
            System.out.println("6." + propiedades[5]);
            int op = 0;

            while (op <= 0 || op > 6) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Seleccione un numero: ");
                op = sc.nextInt();
            }
            Notificacion noti = new Notificacion(sensores, propiedades[op - 1]);
            noti.makeNotificacion();
            user.addNotificacion(noti);
        }
    }

    public static void crearNotiXDispositivo(Usuario user) {

        if (user.getNotificaciones().isEmpty()) {
            System.out.println("ADVERTENCIA: Neceseti primero crear una notificacion de propiedad observable");
        } else if (user == null) {
            System.out.println("ADVERTENCIA: Primero inicie sesion o cree una cuenta ");
        } else {
            System.out.println("|||||    Dispositivos Disponibles    |||||");
            for (Sensor s : sensores) {
                System.out.println("1." + s.getId());
            }
            int op = 0;
            while (op <= 0 || op > sensores.size()) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Seleccione un numero: ");
                op = sc.nextInt();
            }
            boolean flag = true;
            for (Notificacion noti : user.getNotificaciones()) {
                if (!noti.getEnlazados().contains(sensores.get(op - 1).getId())) {
                    noti.addDispositivo(sensores.get(op - 1).getId());
                } else {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("|||   Dispositivo agregado con exito   |||");
            } else {
                System.out.println("ADVERTENCIA: Este dispositivo ya a sido agregado anteriormente intente de nuevo");
            }
        }
    }

    public static void generarNotificaciones(Usuario user) {
        if (user.getNotificaciones().isEmpty()) {
            System.out.println("ADVERTENCIA: Neceseti primero crear una notificacion de propiedad observable");
        } else if (user == null) {
            System.out.println("ADVERTENCIA: Primero inicie sesion o cree una cuenta ");
        } else {
            String cadena = "Nombre etiqueta,nombre propiedad,valor propiedad,fecha\n";
            Scanner sc = new Scanner(System.in);
            System.out.println("|||||     Seleccion de fechas para las notificaciones     |||||");
            System.out.println("Ingrese la fecha de inicio (DIA/MES/ANIO): ");
            String f1 = sc.nextLine();
            Date date = returnDate(f1);
            System.out.println("Ingrese la fecha de fin (DIA/MES/ANIO): ");
            String f2 = sc.nextLine();
            Date date2 = returnDate(f2);
            if (date.before(date2)) {
                for (Notificacion noti : user.getNotificaciones()) {
                    if (noti.isEstado()) {
                        cadena += noti.getNotificaciones(date, date2);
                    }
                }
                //ESCRIBIR EN EL ARCHIVO
                int rd = (int) ((Math.random() * 156) * (Math.random() * 10) + 1);
                String archivo = user.getId() + rd + ".csv";
                ManejoArchivo.EscribirArchivo(archivo, cadena);
                System.out.println("Se a creado el archivo exitosamente");
            } else {
                System.out.println("ADVERTENCIA: LA FECHA DE INICIO DEBE SER MENOR A LA FECHA DE FIN INTENTELO DE NUEVO");
            }
        }
    }

    public static void desactivarNotificacion(Usuario user) {
        if (user.getNotificaciones().isEmpty()) {
            System.out.println("ADVERTENCIA: Neceseti primero crear una notificacion de propiedad observable");
        } else if (user == null) {
            System.out.println("ADVERTENCIA: Primero inicie sesion o cree una cuenta ");
        } else {
            System.out.println("|||||     Elija notificacion que desea desactivar     |||||");
            System.out.println("1.Notificacion Propiedad observable");
            System.out.println("2.Notificacion Dispositivo");
            int op = 0;
            while (op <= 0 || op > 2) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Seleccione un numero: ");
                op = sc.nextInt();
            }
            switch (op) {
                case 1:
                    for (int i = 0; i < user.getNotificaciones().size(); i++) {
                        System.out.println((i + 1) + "." + user.getNotificaciones().get(i).getPropiedad());
                    }
                    int op2 = 0;
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Seleccione un numero: ");
                    op2 = sc2.nextInt();
                    user.getNotificaciones().get(op2 - 1).setEstado(false);
                    System.out.println("|||   Notificacion de propiedad observable desactivado con exito   |||");
                    break;
                case 2:
                    for (int i = 0; i < sensores.size(); i++) {
                        System.out.println((i + 1) + "." + sensores.get(i));
                    }
                    int op3 = 0;
                    Scanner sc3 = new Scanner(System.in);
                    System.out.print("Seleccione un numero: ");
                    op3 = sc3.nextInt();
                    for (Notificacion noti : user.getNotificaciones()) {
                        noti.getEnlazados().remove(sensores.get(op3 - 1).getId());
                    }
                    System.out.println("|||   Notificacion de dispositivo desactivado con exito   |||");
                    break;
            }
        }
    }

    private static Date returnDate(String f1) {
        String[] lista = f1.split("/");
        int dia = Integer.parseInt(lista[0]);
        int mes = Integer.parseInt(lista[1]);
        int anio = Integer.parseInt(lista[2]);
        Date date = new Date();
        date.setDate(dia);
        date.setMonth(mes - 1);
        date.setYear(anio - 1900);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        return date;
    }
=======
>>>>>>> a650824f123749caafce42ca3ec6140d5631b5ca
}
