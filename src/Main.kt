class R2D2(private var nombre: String){
    init {
        if(nombre.isEmpty()) nombre = "ROBOT"
    }

    private var posX:Int = 0
    private var posY:Int = 0
    private var direccion: Direccion = Direccion.PositiveY

    enum class Direccion {
        PositiveY, NegativeX, NegativeY, PositiveX
    }

    fun mover(movimientos: IntArray) {
        for (paso in movimientos) {
            when (direccion) {
                Direccion.PositiveY -> posY += paso
                Direccion.NegativeX -> posX -= paso
                Direccion.NegativeY -> posY -= paso
                Direccion.PositiveX -> posX += paso
            }
            direccion = when (direccion) {
                Direccion.PositiveX -> Direccion.PositiveY
                else -> Direccion.entries[direccion.ordinal + 1]
            }
        }
    }

    private fun obtenerDireccion():String =  direccion.name

    fun mostrarPosicion() = println("$nombre está en ($posX, $posY) ${obtenerDireccion()}")
}

fun main() {
    val robot1 = R2D2("r2d2")
    val todosMovimientos = arrayListOf(intArrayOf(10, 5, -2), intArrayOf(0, 0, 0) , intArrayOf(), intArrayOf(-10, -5, 2), intArrayOf(-10, -5, 2, 4, -8))
    for (movimiento in todosMovimientos){
        robot1.mover(movimiento)
        robot1.mostrarPosicion()
    }
}