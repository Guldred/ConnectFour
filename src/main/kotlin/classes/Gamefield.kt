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

    @Override
    override fun toString(): String {
        //inverted print to show field in console correctly
        var output = ""
        for (i in field[0].indices) {
            for (j in field.indices) {
                output += field[j][i].toString() + " "
            }
            output += "\n"
        }
        return output
    }

    fun addMark(player: Int, posX: Int ): Int {
        if (posX > field.size - 1 || posX < 0) {
            println("Invalid Input")
            return -1
        }
        var lastEmpty = -1;
        for (i in field[posX].indices) {
            if (field[posX][i] == 0) {
                lastEmpty = i;
            }
        }
        if (lastEmpty == -1) {
            println("Seems like this column is full")
            return -1
        }
        field[posX][lastEmpty] = player
        return lastEmpty
    }

    fun isFull(): Boolean {
        for (i in field.indices) {
            if (field[i][0] == 0) {
                return false
            }
        }
        println("Draw")
        return true
    }

    fun checkWinningCondition(p: Int, x: Int, y: Int): Boolean {

        return false;
    }
}