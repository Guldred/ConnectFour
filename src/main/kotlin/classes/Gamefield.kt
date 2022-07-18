package classes

class Gamefield {
    //create 7x6 array
    private val field = arrayOf(
        arrayOf(0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0)
    )

    //override toString method
    override fun toString(): String {
        var output = ""
        for (i in field.indices) {
            for (j in field[i].indices) {
                output += field[i][j].toString() + " "
            }
            output += "\n"
        }
        return output
    }

    fun addMark(posX: Int, player: Int) {
        var lastEmpty = -1;
        for (i in field[posX].indices) {
            if (field[posX][i] == 0) {
                lastEmpty = i;
            }
        }
        field[posX][lastEmpty] = player
    }
}