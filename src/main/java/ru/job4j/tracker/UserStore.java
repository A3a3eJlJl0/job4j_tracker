package ru.job4j.tracker;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user: users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if(user.isValid()) {
            return user.isValid();
        }
        throw new UserInvalidException("Invalid user");
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true),
                    new User("Ivan Ivanov", false),
            };
            User user = findUser(users, "Ivan Ivanov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
