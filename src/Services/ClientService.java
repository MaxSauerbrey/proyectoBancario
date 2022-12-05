package Services;

import Entities.Client;
import Entities.User;

import java.util.*;

public class ClientService {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    static List<Client> clients = new ArrayList<>();

    UserService userServ = new UserService();

    public void createClient() {
        Client client = new Client();
        Integer age = enterAge();

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

    public Integer enterAge() {
        Integer age = 0;
        Boolean err;
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
        return age;
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
        str = input.next();
        while (str == null || str.isEmpty()) {
            System.out.print("Error. Ingrese el " + msj + " nuevamente: ");
            str = input.next();
        }
        return str;
    }

    public void userMenu() {
        String userName;
        Integer index, opt = 0;
        Boolean err;


        System.out.print("\nIngrese su nombre de usuario: ");
        userName = input.next();

        index = getIndex(userName);
        if (index == -1) System.out.println("\nNo existe un usuario con el alias ingresado.");
        else {
            System.out.println("\n\t\t  Bienvenido " +userName);
            //todo ingresar contraseña

            do {
                do {
                    System.out.print("\n\t\t\t Homebanking\n\n1- Ver saldo disponible.\n2- Ver sus datos personales.\n3- Deposito a otra cuenta.\n4- Salir.\n\nPor favor, elija una opción: ");
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
                        System.out.println("Saldo disponible."); //todo ver saldo disponible
                        break;
                    case 2:
                        System.out.println("Ver datos personales "); //todo
                        break;
                    case 3:
                        depositMoney(index);
                        break;
                    case 4:
                        System.out.println("\n\t\t  Adios " +userName);
                        break;
                    default:
                        System.out.print("\nError.Ingrese una opcion correcta.\n");
                }
            } while (opt != 4);
        }
    }

    private void depositMoney(Integer userIndex) {
        Integer depositIndex;
        String userTarget;
        Double amount = 0D;

        System.out.print("Ingrese el nombre de usuario a hacer el deposito: ");
        userTarget = input.next();
        depositIndex = getIndex(userTarget);


        if (depositIndex != -1) {
            amount = validateAmount(amount);
            transaction(userIndex, depositIndex, userTarget, amount);
            showClients();
        } else if (userIndex == depositIndex) {
            System.out.println("\nPara depositar en su cuenta elija la opcion autodeposito.");
        } else {
            System.out.println("\nNo existe un usuario con el alias ingresado.");
        }


    }

    private void transaction(Integer userIndex, Integer depositIndex, String userTarget, Double amount) {
        String ans;
        if (!checkCountAmount(userIndex, amount)) {
            System.out.println("Se depositaran $" + amount + " en la cuenta de " + userTarget + ".");
            do {
                System.out.println("Esta seguro de hacer esta operacion?(s/n): ");
                ans = input.next();
            } while (!ans.equalsIgnoreCase("s") && !ans.equalsIgnoreCase("n"));
            if (ans.equalsIgnoreCase("s")) {
                clients.get(userIndex).getUser().setSavingAccount(clients.get(userIndex).getUser().getSavingAccount() - amount);
                clients.get(depositIndex).getUser().setSavingAccount(clients.get(depositIndex).getUser().getSavingAccount() + amount);
                System.out.println("Operacion exitosa.");
            } else {
                System.out.println("Operacion cancelada.");
            }
        } else System.out.println("El saldo de su cuenta es inferior al monto de la transacción.");
    }

    private Boolean checkCountAmount(Integer userIndex, Double amount) {
        Boolean err = false;
        if (clients.get(userIndex).getUser().getSavingAccount() < amount) {
            err = true;
        }
        return err;
    }

    private Double validateAmount(Double amount) {
        boolean err = false;
        do {
            try {
                System.out.print("Ingrese el monto a depositar: ");
                amount = input.nextDouble();
                err = false;
            } catch (InputMismatchException e) {
                System.out.println("Error. Solamente se pueden ingresar números.");
                err = true;
                input.nextLine();
            }
        } while (err);
        return amount;
    }

    private Integer getIndex(String user) {
        Integer index = -1;
        for (Client u : clients) {
            if (u.getUser().getUserName().equals(user)) {
                index = clients.indexOf(u);
            }
        }
        return index;
    }


    public void menu() {
        addClient(new Client("Juan", "Perez", "1555584524", "juanperez@gmail.com", new User("juanpe", "juancho22", "1555555858321452", 500D)));
        addClient(new Client("Laura", "Palmer", "1555584534", "laurapalmer@gmail.com", new User("laurap", "laurapalmera", "1555545812389517", 30D)));
        addClient(new Client("Laura", "Palmera", "1555584533", "laurapalmera@gmail.com", new User("laurapa", "laurapalmeraa", "1558152336599875", 300D)));
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
                    showClients();
                    userMenu();
                    break;
                case 2:

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
