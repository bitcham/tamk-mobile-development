package com.example.week4.exercises

// ============================================================
// Exercise 2 — Null Safety (Nullable Types + Elvis Operator)
// ============================================================

/*
 Java example idea (from assignment):
 - Order can be null
 - order.customer can be null
 - customer.email can be null
 - Fallback should be "no-email@unknown.com"
*/

data class Customer(val email: String?)
data class Order(val customer: Customer?)

// --- Kotlin refactored version using null safety features ---
fun getCustomerEmail(order: Order?): String {
    // Nullable type: Order?
    // Safe calls: ?. traverses nullable references
    // Elvis operator: ?: provides a fallback when null
    return order?.customer?.email ?: "no-email@unknown.com"
}
// One line replaces the full Java if-chain.

fun exercise2Results(): List<String> {
    val nullableName: String? = null
    val nonNullName: String = "Alice"
    val nameLength: Int = nullableName?.length ?: 0

    val orderWithEmail = Order(Customer("alice@example.com"))
    val orderWithoutCustomer = Order(null)
    val orderWithNullEmail = Order(Customer(null))

    return listOf(
        "nullableName?.length -> ${nullableName?.length}",
        "nonNullName.length -> ${nonNullName.length}",
        "nullableName?.length ?: 0 -> $nameLength",
        "getCustomerEmail(orderWithEmail) -> ${getCustomerEmail(orderWithEmail)}",
        "getCustomerEmail(orderWithoutCustomer) -> ${getCustomerEmail(orderWithoutCustomer)}",
        "getCustomerEmail(orderWithNullEmail) -> ${getCustomerEmail(orderWithNullEmail)}",
        "getCustomerEmail(null) -> ${getCustomerEmail(null)}"
    )
}

fun demonstrateNullSafety() {
    println("=== Exercise 2: Null Safety ===")
    exercise2Results().forEach(::println)
}

/*
 Investigation answers:

 What is a nullable type?
   A type that explicitly allows null values. In Kotlin, you add "?" to the type
   (String? vs String). Without "?", the compiler guarantees the value is never null.

 Why does Kotlin force you to think about null?
   NullPointerException is the most common runtime crash in Java. By making nullability
   part of the type system, Kotlin catches potential null errors at compile time instead
   of at runtime. You must explicitly handle the null case before the code compiles.

 What does the Elvis operator do?
   The Elvis operator (?:) provides a default value when the left-hand expression is null.
   Example: val email = order?.customer?.email ?: "no-email@unknown.com"
   If any part of the chain is null, fallback text is returned instead of crashing.

 How does Kotlin reduce verbose null checking compared to Java?
   - Safe calls (?.) replace nested if-not-null checks with a single chain
   - Elvis operator (?:) replaces the final fallback if-else
   - The entire getCustomerEmail function is one line vs many Java if blocks

 Reflection:
   Kotlin null safety makes code both safer AND more concise. It is stricter because
   the compiler forces you to handle nulls, but this strictness prevents bugs that would
   only appear at runtime in Java. The trade-off is worth it, a small amount of extra
   thought at compile time saves hours of debugging NullPointerExceptions later.
*/
