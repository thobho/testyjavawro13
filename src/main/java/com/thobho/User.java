package com.thobho;

public class User {

    private String userName;

    private int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    static public User of(String userName, int age){
        return new User(userName, age);
    }

    public static void main(String[] args) {
        User janusz = User.of("Janusz", 22);
    }
}
