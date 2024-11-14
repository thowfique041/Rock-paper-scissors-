import java.util.Scanner
import kotlin.random.Random

fun printRound(i: Int) {
    println("Round $i")
}

fun printNumberOfWins(playerWins: Int, computerWins: Int, ties: Int) {
    println("            Player wins -> $playerWins")
    println("            Computer wins -> $computerWins")
    println("            Ties         -> $ties")
}

fun main() {
    val input = Scanner(System.`in`)
    print("Do you want to play Rock-Paper-Scissors?\n" +
            "1. Yes\n" +
            "2. No\n")
    val y = input.nextInt()
    //print("\u001b[H\u001b[2J")
    if (y == 1) {
        print("Enjoy it!\n" +
                "How many rounds do you want to play? \n")
        var n = input.nextInt()
        var round = 1
        var playerWinCount = 0
        var computerWinCount = 0
        var tieCount = 0

        while (n-- > 0) {
            printRound(round)
            printNumberOfWins(playerWinCount, computerWinCount, tieCount)
            print("Select an option:\n" +
                    "1. Rock\n" +
                    "2. Paper\n" +
                    "3. Scissors\n")

            var playerChoice = input.nextInt()
            while (playerChoice !in 1..3) {
                println("Your selected choice is invalid.\n" +
                        "Please try again.\n")
                print("Select an option:\n" +
                        "1. Rock\n" +
                        "2. Paper\n" +
                        "3. Scissors\n")
                playerChoice = input.nextInt()
            }

            val computerChoice = Random.nextInt(1, 4)
            println("Computer chose: ${getChoiceName(computerChoice)}")
            println("You chose: ${getChoiceName(playerChoice)}")

            when {
                playerChoice == computerChoice -> {
                    println("It's a tie!")
                    ++tieCount
                }
                (playerChoice == 1 && computerChoice == 3) ||
                        (playerChoice == 2 && computerChoice == 1) ||
                        (playerChoice == 3 && computerChoice == 2) -> {
                    println("You win this round!")
                    ++playerWinCount
                }
                else -> {
                    println("Computer wins this round!")
                    ++computerWinCount
                }
            }

            round++
        }

        // Final result
        printNumberOfWins(playerWinCount, computerWinCount, tieCount)
        if (computerWinCount > playerWinCount) {
            println("Computer wins the match!")
        } else if (playerWinCount > computerWinCount) {
            println("Congratulations! You win the match!")
        } else {
            println("The match is a tie!")
        }
    } else {
        println("Thanks!")
    }
}

fun getChoiceName(choice: Int): String {
    return when (choice) {
        1 -> "Rock"
        2 -> "Paper"
        3 -> "Scissors"
        else -> "Invalid Choice"
    }
}
