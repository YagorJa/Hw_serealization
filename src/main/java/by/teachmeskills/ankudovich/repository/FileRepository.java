package by.teachmeskills.ankudovich.repository;

import by.teachmeskills.ankudovich.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class FileRepository implements ShopRepository {
    private String filename = "src/main/resources/file.ser";
    private List<User> users;
    public FileRepository() {
        users = deserializeUser();
    }
    @Override
    public void add(User user) {
        users.add(user);
        serializeUser(); // comit
    }

    @Override
    public void deleteById(long userId) {
        users.removeIf(userOk -> userOk.getId().equals(userId));
        serializeUser(); //comit
    }

    @Override
    public Collection<User> allUsers() {
        return users;
    }

    private void serializeUser() {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);


            out.writeObject(users);

            out.close();
            file.close();

            System.out.println("Юзеры были сериализованы");
        } catch (IOException ex) {
           throw new RuntimeException("Юзеры не сериализовались",ex);
        }

    }
    private List<User> deserializeUser() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<User> deserUsers = (List<User>) ois.readObject();
            return deserUsers;


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации пользователей: " + e.getMessage());
        }
        return new ArrayList<>();
    }

}
