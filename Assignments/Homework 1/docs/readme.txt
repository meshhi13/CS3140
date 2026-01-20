Prithee Game
1/20/26
Himesh Ahuja

This program simulates a word-guessing game using a Shakespeare sonnet.
One word is hidden, and the player must guess it correctly.
The game ends when the player reaches either three correct guesses or three incorrect guesses.

The program entry point will be the Main class, which calls the game loop.

Pseudocode

let correctCount = 0
let wrongCount = 0

while correctCount < 3 and wrongCount < 3:
    call pritheeGame
    if pritheeGame returns true:
        correctCount = correctCount + 1
    else:
        wrongCount = wrongCount + 1

on exit of while loop, game is over

function pritheeGame:
    let index = random number between 0 and number of words

    for each word before index:
        print the word followed by a space

    let hiddenLength = length of the hidden word
    print "_" hiddenLength times

    let guess = user input
    if guess equals the hidden word (ignoring case):
        return true
    else:
        return false

Test Design

Test 1: Empty Safety Test
If all words were removed or arrays were empty (hypothetical case), the program should not crash and should not attempt to run a round.

Expected result: No errors, program safely exits.

Test 2: Correct Guess Recognition
Let hiddenWord = "verona"
Let userInput = "Verona"

Expected result:
The round returns true because comparison is case-insensitive.

Test 3: Incorrect Guess Recognition
Let hiddenWord = "verona"
Let userInput = "rome"

Expected result:
The round returns false.

Test 4: Underscore Length Test
Let hiddenWord = "dignity"
Let hiddenWordLength = 7

Expected result:
The program prints exactly 7 underscores:

Test 5: Word Order Test
Let index = 4

Expected output should show:
All words from position 0 through 3 printed in order, followed by spaces, before any underscores appear.

This confirms that:

No words are skipped

No words are repeated

Word order is preserved

Test 6: Score Update Test
Let correctCount = 2
Let wrongCount = 1
If the next round is correct:

Expected result:
correctCount becomes 3
wrongCount stays 1
Game ends immediately.

Test 7: Loss Condition Test
Let correctCount = 1
Let wrongCount = 2
If the next round is incorrect:

Expected result:
wrongCount becomes 3
Game ends immediately.

Test 8: Data Alignment Test
For any index i:

Let rawWord = word from original array
Let cleanedWord = word from cleaned array

After removing commas, replacing periods, and converting to lowercase from rawWord:
cleanedWord should match

Expected result:
All indices align correctly between the two arrays.