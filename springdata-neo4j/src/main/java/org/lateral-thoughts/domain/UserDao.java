package org.lateral-thoughts.domain;

public interface UserDao {
    User getForUsername(String username);

    void createUser(User user);
}