package com.example.week4.exercises

// ============================================================
// Exercise 3 — Converting Java Class → Kotlin Class
// ============================================================

/*
 Original Java class:

    public class Person {
        private String name;
        private int age;
        private String email;

        public Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
        }
    }

    // ~30 lines of boilerplate for 3 fields
*/

// ============================================================
// Part A — Kotlin Class (rewritten from Java)
// ============================================================

class Person(
    var name: String,
    var age: Int,
    var email: String
) {
    override fun toString(): String = "Person(name='$name', age=$age, email='$email')"
}

/*
 What changed:
  - Constructor is part of the class header — no separate constructor body
  - "var" properties auto-generate getters AND setters (use "val" for read-only)
  - No private fields + manual getters/setters needed
  - ~30 lines of Java → ~5 lines of Kotlin with identical functionality
*/

// ============================================================
// Part B — Extension Function
// ============================================================

// Extension function: adds a method to Person without modifying the class
fun Person.isAdult(): Boolean = age >= 18

// Another extension: formatted display string
fun Person.profileSummary(): String = "$name ($age) - $email"

/*
 What are extension functions?
   Functions that "extend" an existing class with new behavior, without inheriting
   from it or modifying its source code. The class appears on the left of the dot,
   and inside the function you can access its public members via "this".

 Why are they useful?
   - Add utility methods to classes you don't own (e.g., String, List)
   - Keep classes focused — put helper logic outside the class definition
   - Improve readability: "person.isAdult()" reads better than "PersonUtils.isAdult(person)"

 When might they be dangerous or confusing?
   - They don't actually modify the class — they're resolved statically, not dynamically
   - Can make it unclear where a method is defined (is it in the class or an extension?)
   - Overuse can scatter logic across many files, making code harder to follow
   - They cannot access private members of the class
*/

// ============================================================
// Part C — Data Class
// ============================================================

/*
 What is a Data Class?
   A class specifically designed to hold data. Kotlin generates useful methods
   automatically based on the properties declared in the primary constructor.

 What problems does it solve?
   In Java, simple data-holding classes require tons of boilerplate: equals(),
   hashCode(), toString(), copy constructors. Data classes generate all of this.
*/

data class PersonData(
    val name: String,
    val age: Int,
    val email: String
)

fun exercise3Results(): List<String> {
    val person = Person("Alice", 25, "alice@email.com")
    person.age = 26

    val data1 = PersonData("Bob", 30, "bob@email.com")
    val data2 = PersonData("Bob", 30, "bob@email.com")
    val data3 = data1.copy(age = 31)
    val (name, age, email) = data1

    val p1 = Person("Carol", 28, "carol@email.com")
    val p2 = Person("Carol", 28, "carol@email.com")

    return listOf(
        "Normal class person -> $person",
        "person.isAdult() -> ${person.isAdult()}",
        "person.profileSummary() -> ${person.profileSummary()}",
        "Data class data1 -> $data1",
        "data1 == data2 -> ${data1 == data2}",
        "data1.copy(age = 31) -> $data3",
        "Destructuring -> name=$name, age=$age, email=$email",
        "Normal class equals (p1 == p2) -> ${p1 == p2}"
    )
}

/*
 What is automatically generated in a data class?
   - equals()    — compares all properties for structural equality
   - hashCode()  — consistent with equals, usable in HashMaps/Sets
   - toString()  — "PersonData(name=Alice, age=25, email=alice@email.com)"
   - copy()      — creates a copy with optional property changes
   - componentN() — enables destructuring: val (name, age, email) = person

 Normal class vs Data class:
   Normal class:
     - equals() compares references (identity), not content
     - toString() shows class name + memory address
     - No copy() or destructuring support
     - You must override equals/hashCode/toString manually

   Data class:
     - equals() compares property values (structural equality)
     - toString() shows all property values
     - copy() and destructuring work out of the box
     - Perfect for models, DTOs, and state objects
*/

// --- Demo usage ---
fun runExercise3() {
    println("=== Exercise 3: Classes ===")
    exercise3Results().forEach(::println)
}
