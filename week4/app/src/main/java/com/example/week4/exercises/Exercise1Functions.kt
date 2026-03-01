package com.example.week4.exercises

// ============================================================
// Exercise 1 — Kotlin Functions vs Java Methods
// ============================================================

// --- 1. Greeting function ---
// Kotlin: concise, single-expression function with type inference
fun greet(name: String): String = "Hello, $name! Welcome to Kotlin."

// Extra simple math function (addition)
fun add(a: Int, b: Int): Int = a + b

/*
 Java equivalent:
    public static String greet(String name) {
        return "Hello, " + name + "! Welcome to Kotlin.";
    }

 Differences:
  - Kotlin uses "fun" keyword instead of access modifier + return type + method name
  - String templates ($name) replace concatenation
  - Single-expression functions can use "=" instead of braces
  - No "static" keyword — Kotlin top-level functions are not inside a class
*/

// --- 2. Simple math function ---
fun multiply(a: Int, b: Int): Int = a * b

/*
 Java equivalent:
    public static int multiply(int a, int b) {
        return a * b;
    }

 Differences:
  - Kotlin parameter syntax is "name: Type" (reversed from Java's "Type name")
  - Return type comes after the parameter list with a colon
  - No primitive vs wrapper type distinction — Kotlin uses Int (compiled to int)
*/

// --- 3. Default parameter values ---
fun calculateArea(width: Double, height: Double = 1.0): Double = width * height

/*
 Java equivalent (requires method overloading):
    public static double calculateArea(double width, double height) {
        return width * height;
    }
    public static double calculateArea(double width) {
        return calculateArea(width, 1.0);
    }

 Differences:
  - Kotlin supports default parameter values directly in the signature
  - Java needs method overloading to achieve the same effect — more boilerplate
  - One Kotlin function replaces two (or more) Java methods
*/

// --- 4. Named parameters ---
fun createProfile(name: String, age: Int, city: String = "Unknown"): String {
    return "Name: $name, Age: $age, City: $city"
}

fun exercise1Results(): List<String> {
    return listOf(
        "greet(\"Student\") -> ${greet("Student")}",
        "add(5, 3) -> ${add(5, 3)}",
        "multiply(5, 3) -> ${multiply(5, 3)}",
        "calculateArea(5.0, 3.0) -> ${calculateArea(5.0, 3.0)}",
        "calculateArea(5.0) [default height] -> ${calculateArea(5.0)}",
        "createProfile(age = 25, name = \"Alice\", city = \"Helsinki\") -> ${
            createProfile(
                age = 25,
                name = "Alice",
                city = "Helsinki"
            )
        }",
        "createProfile(name = \"Bob\", age = 30) [default city] -> ${
            createProfile(
                name = "Bob",
                age = 30
            )
        }"
    )
}

/*
 Java equivalent:
    public static String createProfile(String name, int age, String city) {
        return "Name: " + name + ", Age: " + age + ", City: " + city;
    }
    // No named parameters — caller must remember argument order:
    // createProfile("Alice", 30, "Helsinki")

 Differences:
  - Kotlin allows calling with named parameters: createProfile(age = 30, name = "Alice")
  - This makes call sites self-documenting and order-independent
  - Java has no equivalent — you must rely on parameter order and IDE hints
*/

// --- Demo usage ---
fun runExercise1() {
    println("=== Exercise 1: Kotlin Functions ===")
    exercise1Results().forEach(::println)
}

/*
 Reflection:
  - Kotlin is shorter: no boilerplate (access modifiers, class wrappers, overloads)
  - Kotlin is clearer: string templates, named parameters, default values
  - Java may feel familiar if coming from a Java background, and its explicit
    style can make types and access levels immediately visible
*/
