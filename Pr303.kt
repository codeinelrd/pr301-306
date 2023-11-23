import kotlin.math.sqrt

fun main(args: Array<String>) {
    println("1.Perimetro\n" +
            "2.Superficie\n" +
            "3.Diagonal\n")
    var opcion = readln().toInt()
    println("Introduce el lado 1")
    var lado1 = readln().toInt()
    println("Introduce el lado 2")
    var lado2 = readln().toInt()

        when(opcion){
            1 -> {
                println("El perimetro es: ${2* (lado1 + lado2)}")
            }
            2 -> println("La superficie es: ${(lado1 * lado2)}")
            3 -> {
                println("La diagonal es: ${sqrt((lado1 * lado1 + lado2 * lado2).toDouble())}")
            }
            4 -> System.exit(0)
        }
}