package com.humanbooster;

import com.humanbooster.dao.Connector;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connector dbConnector = Connector.getInstance();
    }
}
