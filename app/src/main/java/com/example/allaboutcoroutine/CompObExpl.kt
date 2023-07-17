package com.example.allaboutcoroutine

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Greeting() {
    val message = CompObExpl.getMessage()
    Text(text = CompObExpl.some)

}

class CompObExpl {
    companion object {
        var some = "pie"
        fun getMessage(): String {
            return "Hello, World!"
        }
    }
}

// no create an instance of a class to access it's members
// usually we use val obj = ClassName ()
// and then we use obj.variable or func name
/*

By using the companion object, we can define functions or properties
that are associated with the class itself rather than requiring an instance
 of the class. This allows us to access these members directly on the class,
 such as MyScreen.Companion.getMessage().

*/


/*When using a companion object, you can access its members directly on the class itself
 without the need to create an instance of the class. This is one of the advantages of using companion objects.

Here are some key advantages of using companion objects in Kotlin:

Access without instance: You can access the properties and functions defined inside a companion object directly on the class, without creating an instance of the class. This makes it convenient to access shared or static members associated with the class.
Namespacing: companion objects provide a way to group related functionality and data within a class. It serves as a namespace for members that are closely associated with the class itself, making the code organization clearer and more structured.
Encapsulation: Members inside a companion object have access to the private members of the class. This allows you to encapsulate related logic and data within the class and control the visibility and accessibility of those members.
Overrides: companion objects can also inherit from interfaces or superclasses and override their members, providing flexibility in implementing specific behaviors for the class.
Overall, companion objects offer a way to define and access members that are closely tied to a class without requiring an instance of the class. They provide a clean and organized approach for creating static or shared functionality within the context of a class.

It's important to note that companion objects are specific to the class in which they are defined, meaning each class can have its own companion object with its own set of members. This allows you to define and access class-specific static functionality.*/