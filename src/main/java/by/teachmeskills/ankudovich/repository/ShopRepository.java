package by.teachmeskills.ankudovich.repository;


import by.teachmeskills.ankudovich.entity.User;

import java.util.Collection;

public interface ShopRepository {
    public void add(User user);
    public void  deleteById(long userId);
    public Collection<User> allUsers();

}


