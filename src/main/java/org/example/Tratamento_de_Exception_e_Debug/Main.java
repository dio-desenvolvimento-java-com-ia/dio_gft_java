package org.example.Tratamento_de_Exception_e_Debug;

import org.example.Tratamento_de_Exception_e_Debug.DAO.UserDAO;
import org.example.Tratamento_de_Exception_e_Debug.model.MenuOption;
import org.example.Tratamento_de_Exception_e_Debug.model.UserModel;

import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserDAO dao = new UserDAO();
    public static void main(String[] args) {

        System.out.println("Bem vindo ao cadastro de usuários selecione a operação desejada");
        System.out.println("1- Cadastrar");
        System.out.println("2- Atualizar");
        System.out.println("3- Excluir");
        System.out.println("4- Buscar por identificador");
        System.out.println("5- Listar");
        System.out.println("6- Sair");

        int inputOption = sc.nextInt();
        while (true) {
            MenuOption selectedOption = MenuOption.values()[inputOption-1];
            switch (selectedOption) {
                case SAVE -> {
                    var user = dao.save(requestUserInfo());
                    System.out.printf("Usuário Cadastrado %s%n", user);
                }
                case UPDATE -> {
                    var  user = dao.update(requestToUpdate());
                    System.out.printf("Usuário atualizado %s%n", user);
                }
                case DELETE -> {
                    dao.delete(requestID());
                    System.out.println("Usuários cadastrados");
                }
                case FIND_BY_ID ->{
                    long id = requestID();
                    var user = dao.findById(id);
                    System.out.printf("Usuário com id %d%n", id);
                    System.out.println(user);
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados");
                    users.forEach(System.out::println);
                }
                case EXIT -> System.exit(0);

            }
        }
    }

    private static UserModel requestUserInfo(){
        System.out.println("Informe o nome do usuário");
        String name = sc.next();
        System.out.println("Inform o e-mail do usuário");
        String email = sc.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        String birthdayString = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        OffsetDateTime birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(0, name, email, birthday);
    }

    private static UserModel requestToUpdate(){
        System.out.println("Informe o identificador do user");
        long id = sc.nextLong();
        System.out.println("Informe o nome do usuário");
        String name = sc.next();
        System.out.println("Inform o e-mail do usuário");
        String email = sc.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        String birthdayString = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        OffsetDateTime birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(id, name, email, birthday);
    }

    private static long requestID(){
        System.out.println("Informe o identificador do user");
        return sc.nextLong();
    }

}
