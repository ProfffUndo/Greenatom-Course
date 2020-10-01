package com.company.JDBC;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  UserApplication {
    private static final Logger LOGGER =
            Logger.getLogger(UserApplication.class.getName());
    private static final DAO<User, Integer> user_DAO = new PostgreSqlDao();

    public static void main(String[] args){
        /*
        try {
            User user = getUser(1);
        } catch (NonExistentEntityException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }*/
        User firstUser =
                new User("Manuel", "Kelley", 189, 80);
        User secondUser =
                new User("Joshua", "Daulton", 176,76);
        User thirdUser =
                new User("April", "Ellis", 183,98);
        addUser(firstUser).ifPresent(firstUser::setId);
        addUser(secondUser).ifPresent(secondUser::setId);
        addUser(thirdUser).ifPresent(thirdUser::setId);


        firstUser.setFirstName("Franklin");
        firstUser.setLastName("Hudson");
        firstUser.setHeight(186);
        firstUser.setWeight(67);
        updateUser(firstUser);


        getAllUsers().forEach(System.out::println);


        deleteUser(secondUser);
    }

    // Static helper methods referenced above
    public static User getUser(int id) throws NonExistentEntityException {
        Optional<User> user = user_DAO.get(id);
        return user.orElseThrow(NonExistentUserException::new);
    }

    public static Collection<User> getAllUsers() {
        return user_DAO.getAll();
    }

    public static void updateUser(User user) {
        user_DAO.update(user);
    }

    public static Optional<Integer> addUser(User user) {
        return user_DAO.save(user);
    }

    public static void deleteUser(User user) {
        user_DAO.delete(user);
    }
}
