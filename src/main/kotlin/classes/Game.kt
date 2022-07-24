package classes

class Game {
    private val gamefield: Gamefield = Gamefield()
    private var bRunning: Boolean = false

    init {
        println("Game created")
    }

    fun play() {
        var playersTurn = 1;
        bRunning = true;
        println("Game started")

        //This is the Game Loop
        while (bRunning) {
            val input: Int = getInput()

            //Try to add player number to column bottom. -1 if invalid input
            val y = gamefield.addMark(playersTurn, input-1)

            //If move is valid, print gamefield and check current move for winning conditions
            if (isValidMove(y)) {
                println("Player $playersTurn placed a mark in column $input at row $y")
                if (checkDraw()) {
                    bRunning = false
                    println("Game ended in a draw")
                }
                if (checkWinningCondition(playersTurn,input-1, y)) {
                    bRunning = false
                    println("Player $playersTurn won!")
                }
                playersTurn = if (playersTurn==1) 2 else 1
            } else {
                println("Invalid move. Please try again, player $playersTurn. Valid Inputs arte 1 - 7 excluding full columns")
            }

            //Print gamefield
            println(gamefield.toString())
        }
    }

    fun isValidMove(x: Int): Boolean {
        return (x!=-1)
    }

    fun getInput(): Int {
        //get input from console - only allow integers
        return (readLine()?:"").toIntOrNull()?:-1
    }

    fun checkWinningCondition(p: Int, x: Int, y: Int): Boolean {
        return gamefield.checkWinningCondition(p, x, y)
    }

    fun checkDraw(): Boolean {
        return gamefield.isFull()
    }
}