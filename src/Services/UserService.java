package Services;

import Entities.Client;
import Entities.User;
import Services.ClientService;

import java.util.Scanner;

public class UserService {

    Scanner input = new Scanner(System.in);

    public User createUser() {
        User user = new User();

        user.setUserName(validatorString("nombre de usuario"));
        user.setPassword(validatorString("contraseña"));

        //todo crear numero de tarjeta
        user.setCardNumber(input.next());
        //todo crear un aleatorio con cierto monto
        user.setSavingAccount(0d);
        return user;
    }

    public String validatorString(String msj) {
        String str;
        System.out.print("Ingrese el " + msj + " del cliente: ");
        str = input.nextLine();

        while (str == null || str.isEmpty()) {
            System.out.print("Error. Ingrese el " + msj + " nuevamente: ");
            str = input.nextLine();
        }
        return str;
    }

//    public boolean uniqueUserName(String str) {
//        Boolean match = false;
//
//        for (Client client : ClientService.clients) {
//            if (str.equalsIgnoreCase(str)) {
//                System.out.println("Ya existe un usuario con ese nombre.");
//                match=true;
//                break;
//            }
//        }
//        return match;
//    }
}
