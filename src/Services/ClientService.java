package Services;

import Entities.Client;
import Entities.User;

import java.sql.ClientInfoStatus;
import java.util.*;

public class ClientService {
    static Scanner input = new Scanner(System.in);
    //    HashSet<Client> clients = new HashSet<Client>(10);
    List<Client> clients = new ArrayList<Client>(10);
//    Client [] clients = new Client [10];
    UserService userServ = new UserService();

    public void createClient() {
        Client client = new Client();
        Boolean err;
        Integer age = 0;
        do {
            try {
                System.out.print("Ingrese su edad: ");
                age = input.nextInt();
                err = false;
            } catch (InputMismatchException e) {
                System.out.println("Error. Debe ingresar un numero.");
                err = true;
                input.nextLine();
            }
        } while (err);

        if (age > 17) {
            client.setName(validatorString("nombre"));
            client.setSurname(validatorString("apellido"));
            client.setPhone(validatorString("telefono"));
            client.setEmail(validatorString("email"));
            client.setUser(userServ.createUser());
            addClient(client);
            System.out.println("Cliente agregado.");
        } else {
            System.out.println("Para crear una cuenta debe ser mayor de edad.");
        }
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void showClients() {
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public static String validatorString(String msj) {
        String str;
        System.out.print("Ingrese el " + msj + " del cliente: ");
        str = input.nextLine();
        while (str == null || str.isEmpty()) {
            System.out.print("Error. Ingrese el " + msj + " nuevamente: ");
            str = input.nextLine();
        }
        return str;
    }

    public void userMenu() {
        String userName, userTarget;
        Integer index = -1, depositIndex = -1;
        double amount = 0;

        //todo try-catch
        System.out.print("\nIngrese su nombre de usuario: ");
        userName = input.next();

        System.out.println(userName);

        // todo hacer funcion
        for (Client u : clients) {
            if (u.getUser().getUserName().equals(userName)) {
                index = clients.indexOf(u);
            }
        }

        if (index == -1) {
            System.out.println("\nNo existe un usuario de este banco con este alias");
            return;
        }

        System.out.println("1 -Deposito a otra cuenta");
        System.out.print("Ingrese el nombre de usuario a hacer el deposito: ");
        userTarget = input.next();
        System.out.println(userTarget);
        for (Client u : clients) {
            if (u.getUser().getUserName().equals(userTarget)) {
                depositIndex = clients.indexOf(u);
            }
        }
        System.out.println(depositIndex);
        if (depositIndex == -1) {
            System.out.println("El alias ingresado no pertenece a un usuario.");
            return;
        } else if (index == depositIndex) {
            System.out.println("Para depositar en su cuenta elija la opcion autodeposito.");
            return;
        }

        //todo try catch
        System.out.print("Ingrese el monto a depositar: ");
        amount = input.nextDouble();
        //todo validacion si-no
        System.out.println("Se depositaran " + amount + "$ en la cuenta " + userTarget + ". Esta seguro de hacer esta operacion? ");

        clients.get(index).getUser().setSavingAccount(clients.get(index).getUser().getSavingAccount()-amount);
        clients.get(depositIndex).getUser().setSavingAccount(clients.get(depositIndex).getUser().getSavingAccount()+amount);
        showClients();
    }


    public void menu() {
        addClient(new Client("Juan", "Perez", "1555584524", "juanperez@gmail.com", new User("juanpe", "juancho22", "15555", 500D)));
        addClient(new Client("Laura", "Palmer", "1555584534", "laurapalmer@gmail.com", new User("laurap", "laurapalmera", "15555", 30D)));
        addClient(new Client("Laura", "Palmer", "1555584533", "laurapalmera@gmail.com", new User("laurapa", "laurapalmeraa", "155535", 30D)));
        addClient(new Client("Laura", "Palmer", "1555584533", "laurapalmera@gmail.com", new User("laurapa", "laurapalmeraa", "155535", 30D)));
        Integer opt = 0;
        Boolean err;
        System.out.println("\n\t.:Bienvenido al banco:.");
        do {
            do {

                System.out.print("\n\t\t\tMENU\n\n1.Ingresar como usuario.\n2.Crear usuario.\n3.Salir.\n\n");
                System.out.print("Por favor, elija una opción: ");
                try {
                    opt = input.nextInt();
                    err = false;
                } catch (InputMismatchException e) {
                    System.out.println("Error. Solamente se pueden ingresar numeros.");
                    err = true;
                    input.nextLine();
                }
            } while (err);
            switch (opt) {
                case 1:
                    userMenu();
//                    showClients();
                    break;
                case 2:
                    System.out.print("Ingrese su edad: ");
                    this.createClient();
                    break;
                case 3:
                    System.out.println("Muchas gracias por su visita.");
                    break;
                default:
                    System.out.print("\nError.Ingrese una opcion correcta.\n");
            }
        } while (opt != 3);
    }


}
