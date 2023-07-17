package com.example.allaboutcoroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.allaboutcoroutine.ui.theme.AllAboutCoroutineTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllAboutCoroutineTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Launcdef()
                    //Asynawai()
                    //WitConxt()
                    //lachdsedexpl()
                    //deffrdexpl()

                    explwit()
                }
            }
        }
    }
}

@Composable
fun Launcdef() {
    LaunchedEffect(Unit) {
        launch {
            // Long-running or async task
            Log.d("bg task start", "Launcdef bg work started")
            delay(8000)
            Log.d("bg task start", "Launcdef bg work finished")

        }
    }
}


@Composable
fun Asynawai() {
    val result = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val deferredResult = async {
            // Perform computationally intensive task
            Log.d("bg task start", "Asynawai bg work started")
            delay(8000)
            Log.d("bg task start", "Asynawai bg work finished")
            "Result from Asynawai"
        }

        result.value = deferredResult.await()
    }

    Text(text = result.value)

    /// it is and it can return result
}


@Composable
fun WitConxt() {
    val result = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            // Perform IO task in the background

            delay(1000) // Simulating an IO operation
            "Result from WitConxt"
        }.also {
                data ->
            withContext(Dispatchers.Main) {
                result.value = data
            }
        }
    }
    Text(text = result.value)
}


@Composable
fun deffrdexpl() {
    var result by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        // Launch multiple coroutines concurrently
        val deferredResults = listOf(
            async { fetchData3(8) },
            async { fetchData3(7) },
            async { fetchData3(9) }
        )

        // Await the completion of all coroutines
        val fetchedData = deferredResults.awaitAll()

        // Update the UI with the combined result
        result = fetchedData.joinToString(separator = "\n")
    }

    Text(text = result)
}


suspend fun fetchData3(id: Int): String {
    // Simulating a network request delay
    delay(3000)

    return "Data $id"
}



/*

Scope functions :
let, run , with , apply , also

*/

@Composable
fun expllet(){

    //let example
    /*let: The let function allows you to perform operations on an object
    within a lambda expression and return a result.
    It is often used for null-checking and chaining function calls. */
    val numbers = mutableListOf(1.2,3,5,67,7,8)

    val result = numbers?.let {
        // Perform operations on the non-null value
        it.size
    } // Default value if 'text' is null

    Text(text = "Length: $result")

    val name: String? = "India"

    val res = name?.let {
            text ->
        // Perform operations on non-null 'text'
        val uppercaseText = text.uppercase(Locale.ROOT)
        val length = text.length
        "$uppercaseText ($length)"
    } ?: "Default Value"

    Text(text = res)

}

@Composable
fun explrun(){

    //run example
    /*run: The run function executes a block of code within the context
    of an object and returns the result of the last expression in that block.
    It is useful when you want to execute multiple statements on an object*/
    val message = run {
        val greeting = "Hello"
        val name = "John"
        "$greeting, $name!"

    }

    Text(text = message)

 }

data class Pers(var name : String,var age :Int)

@Composable
fun explwit(){

    Column() {


        //with example
        /*
    with: The with function allows you to execute multiple operations on
    an object without the need for a lambda expression.
    It simplifies accessing properties and invoking functions on an object.
    */
        val person = Pers("John", 30)

        with(person) {
            person.name = "Jane"
            age += 1
        }

        Text(text = " iam from with example Name: ${person.name}, Age: ${person.age} \n\n")

        // apply example
        /*
    apply: The apply function is similar to with, but it returns
    the original object instead of a result. It is commonly used for
    configuring properties of an object in a concise manner*/
        val perso = Pers("Jane", 36).apply {
            name = "Marie"
            age += 2
        }
        perso.apply {

        }

        Text(text = "iam from apply example updated Name: ${perso.name}, Age: ${perso.age}")


        //also example
        /*
    also: The also function is similar to apply, but it returns
    the original object instead of a result. It is useful when you
    want to perform additional operations on an object within a chain
    of function calls*/
        val text = "Hello"


        val rest = text.also {
            // Perform additional operations on 'text'
            println("Length: "+it.length.toString())
        }

        Text(text =  text.length.toString())

    }
}

