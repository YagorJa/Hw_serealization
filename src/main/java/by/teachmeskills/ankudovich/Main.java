package by.teachmeskills.ankudovich;

import by.teachmeskills.ankudovich.entity.User;
import by.teachmeskills.ankudovich.repository.FileRepository;
import by.teachmeskills.ankudovich.repository.ShopRepository;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        FileRepository repository = new FileRepository();
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Мужик");
        user1.setSurname("Мужиков");
        user1.setLogin("RealMan");
        user1.setPassword("0_ManRules_0");

        User user2 = new User();
        user2.setId(2l);
        user2.setName("Дама");
        user2.setSurname("Женских");
        user2.setLogin("Miss_lady");
        user2.setPassword("Woman_woman123");

        repository.add(user1);
        repository.add(user2);

//        List<User> allUsers = (List<User>) repository.allUsers();
//        System.out.println("Все пользователи:");
//        allUsers.forEach(System.out::println);
//
//        repository.deleteById(1L);
//        System.out.println("Пользователь с id=1 был удален.");
//
//        allUsers = (List<User>) repository.allUsers();
//        System.out.println("Все пользователи после удаления:");
//        allUsers.forEach(System.out::println);
        //тестил методы, все работает
    }
}