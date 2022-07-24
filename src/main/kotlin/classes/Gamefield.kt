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
        //inverted print to show field in console correctly with X on visual X-Axis
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
        //checking X, Y and Crossdirections from current position until field is invalid, 0 or not the same player
        val sumX = checkNeighbours(p, x, y, 1, 0) + checkNeighbours(p, x, y, -1, 0) - 1 //-1 because starter position is counted twice for pos and neg
        val sumY = checkNeighbours(p, x, y, 0, 1) + checkNeighbours(p, x, y, 0, -1) - 1
        val sumXYPos = checkNeighbours(p, x, y, 1, 1) + checkNeighbours(p, x, y, -1, -1) - 1
        val sumXYNeg = checkNeighbours(p, x, y, 1, -1) + checkNeighbours(p, x, y, -1, 1) - 1

        return (sumX >= 4 || sumY >= 4 || sumXYPos >= 4 || sumXYNeg >= 4)
    }

    private fun checkNeighbours(p: Int, x: Int, y: Int, xDir: Int, yDir: Int): Int {
        return if (field[x][y] == p) {
            if (x + xDir in field.indices && y + yDir in field[0].indices) {
                1 + checkNeighbours(p, x+xDir, y+yDir, xDir, yDir)
            } else {
                1
            }
        } else {
            0
        }
    }
}