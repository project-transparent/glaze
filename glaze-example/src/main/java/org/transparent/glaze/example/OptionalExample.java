package org.transparent.glaze.example;

import org.transparent.glaze.annotations.Optional;

public class OptionalExample {
    public static void main(String[] args) {
//        test("Test string.");
//        test();
//
//        test2("This here's an optional string.", "This here's a required string.");
//        test2("Where did the optional string go?");
    }

    public static void test(@Optional String optional) {
        System.out.println(optional.isEmpty()
                ? "Empty String!"
                : optional);
    }

    public static void test2(@Optional String s, String required) {
        System.out.println("Optional: " + s + "\nRequired: " + required);
    }
}