/******************************************************************************
Omar El Kouzi
03/30/2021
Computer Science RST (Final Project)
600 or so lines of tears and laughs and all the applicable emotions.
An interactive casino game with 4 main games and lots of side games.
*******************************************************************************/
// Psuedo https://docs.google.com/document/d/1Ha-wZY9mKEFeFy9e_TPSALFAV2FY_2KrDTTkuK5Pfco/edit?usp=sharing 

import java.util.concurrent.TimeUnit; //import for the timer
import java.util.Scanner; // Scanner Import
import java.text.DecimalFormat; // Decimal Place Import

public class Main {

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) throws InterruptedException {

    int choice;
    String userName;
    int tries;
    int entrance = 0;
    String passWordReset;
    String lastName = "";
    String passWord = "";
    String newPassword = "gambling"; // The Main Password
    System.out.println("Welcome To Omar's Casno. Please Enter Your Username And Password ");
    System.out.print("Username:");
    userName = input.nextLine();

    do { // The Do statement for the password reset and password input

      System.out.print("Please Enter Your Password " + userName + " : ");
      passWord = input.nextLine();
      for (tries = 0; tries < 2; tries++) { // The loop for the password guesses

        if (passWord.equals(newPassword)) { // If The password is correct

          tries = +4; // Adds 4 to exit loop

        } else {

          if (tries == 1) { // the password hint
            System.out.println(
              "The Password Is An Action That Garry From Unit 4 Progect Liked To Do ALOT OF");
          }

          System.out.print("Try Again,You Said The Wrong " + "Password: ");
          passWord = input.nextLine();

        }

      }
      // if the password isnt right after 3 tries then this will execute
      if (tries < 3 && !passWord.equals(newPassword)) {

        System.out.println("You Seem To Be Having Trouble Remembering The Password You Set To This Casino");
        System.out.print("Would You Like To Reset Your Password?: ");
        passWordReset = input.nextLine();
        if (passWordReset.equalsIgnoreCase("yes") || passWordReset.equalsIgnoreCase("y")) { // If They want to reset thir password
          System.out.print("Please Say Your Last Name As Verification: ");
          lastName = input.nextLine();
          if (lastName.equalsIgnoreCase("McDougall")) {

            System.out.print("What Would You Like You New Password To Be?: ");
            newPassword = input.nextLine();

          } else { // if they answer the security question wrong
            System.out.println("***********************************\n" +
              "IMPOSTOR!!! DONT EVEN THINK OF COMING HERE AGAIN *Throws You Across The Road*\n" +
              "***********************************");
            System.exit(0);

          }

        } else { // if they answer no to the password reset
          System.out.println("***********************************\n" +
            "IMPOSTOR!!! DONT EVEN THINK OF COMING HERE AGAIN *Throws You Across The Road*\n" +
            "***********************************");
          System.exit(0);

        }
      }
    } while (!(passWord.equals(newPassword)));

    do {
      if (entrance == 0) {
        System.out.println("You Have Successfully Entered The Casino!");
        entrance++;
      }
      System.out.println("Welcome To The Main Lobby!");
      System.out.println("Enter 0 To Quit At Any Time");
      System.out.println("Enter A Number Between 1 And 4 To Choose Your Game ");
      System.out
        .println("1 = Dice Roll \n2 = Guessing Game \n3 = number Count \n4 = Resturant \n0 = Exit Casino");
      while (!input.hasNextInt()) { // Stops code from crashing
        input.next();

        System.out.println("Enter 1-4 Or 0 To Quit Please:");
      }
      choice = input.nextInt();
      if (choice == 1) {
        int betammount = diceRoll(); // method call
        System.out.println(
          "The Total Ammount Of Money You Made Is: " + betammount + "$" + " In The Dice Roll Game,");
      } else if (choice == 2) {
        guessingGame(); // method call
      } else if (choice == 3) {
        numberCount(); // method call
      } else if (choice == 4) {
        resturant(); // method call
      }
      System.out.println("\n");
    } while (choice != 0);

    input.nextLine();
    System.out.println("You Leave The Casino And Find Yourself In Therepy ");
    System.out.println("You Therapist Asks You if You Are Happy? (Y/N): ");
    String happy = input.nextLine(); // Opening user input and storing it as catFed
    if (happy.equalsIgnoreCase("no") || happy.equalsIgnoreCase("n")) {
      // If The user is not happy

      System.out.println("Is It Because Of All The Gambling You Have Been Doing?");
      String reason = input.nextLine(); // Opening user input and storing it as reason
      if (reason.equalsIgnoreCase("yes") || reason.equalsIgnoreCase("y")) {
        // If The user is sad because of gambling
        System.out.println(
          "Then  Stop Gambling....See? Easy..You Owe Me 1000$ For The Consult Tho..Cash Or Credit? ");
      } else {
        // If The Cat Wants Pets
        System.out.println("Is It Because You Ate Something Bad At The Casino?");
        String badFood = input.nextLine(); // Opening user input and storing it as badFood
        if (badFood.equalsIgnoreCase("yes") || badFood.equalsIgnoreCase("y")) {
          // If The user ate bad food
          System.out.println(
            "Thats A Doctors Job Not Mine....You Owe Me 1000$ For The Consult Tho..Cash Or Credit?");
        } else {
          // If The user didn't eat bad food
          System.out.println("Could It Be Because Your Shoes Are Untied ");
          String shoes = input.nextLine(); // Opening user input and storing it as shoes
          if (shoes.equalsIgnoreCase("yes") || shoes.equalsIgnoreCase("yes")) {
            // If Cat Is Not A Guy
            System.out.println(
              "Well Then Just Tie Your Shoes....You Owe Me 1000$ For The Consult Tho..Cash Or Credit?");
          } else {
            // If Cat Is A Guy
            System.out.println(
              "HMMMMMMMMMM I Dont Know....Is It Because You Didnt Give Omar A 4++++On His RST?");
            String omarmark = input.nextLine(); // Opening user input and storing it as omarmark

            if (omarmark.equalsIgnoreCase("yes") || omarmark.equalsIgnoreCase("y")) {
              // If omar's mark doesn't have 4+++++++++++
              System.out.println(
                "Well Thats An Easy Fix, Give Him A 4++ Becuase He So Rightfully Deserves It, And Everything Will Be AOK! I Wont Charge You For The Session If You Give Him A 4+");
            } else {
              // If cat doesn't have his marbles
              System.out.println(
                "I Have No Clue What Is Wrong With You.......You Owe Me 1000$ For The Consult Tho..Cash Or Credit? ");
            }
          }
        }
      }

    } else {
      // If The user is happy
      System.out.println(
        "Why Are You Hear Then? Go Out And Enjoy Life!......You Still Owe Me 1000$ For The Consult.....Cash or Credit?");
    }

    int num;
    System.out.println("*************************************************");

    System.out.print(
      "Your Spouse Sees You Trying To Sneak In Through The Window, They Ask You To Explain Yourself How Many Words Do You Need? : ");

    while (!input.hasNextInt()) { // Stops code from crashing
      input.next();
      System.out.println("Use Whole Numbers Only Please!");
      System.out.print("Please enter your guess: ");
    }
    num = input.nextInt();

    String[] words = new String[num]; // Making an array

    System.out.println("Please Enter " + num + " Words : ");

    for (int i = 0; i < words.length; i++) { // Making a loop depending on how long words is
      words[i] = input.next(); // Opening words to user input
    }

    for (int i = 0; i < words.length; i++) {

      System.out.println("Word  [" + (i) + "]   = " + words[i]); // print the array out
    }
    if (words.length > 5 ) {

      System.out.println("Oh Ok! Thaught You Where Out Gambling Again.....Why Do You Smell Like Alcohol??? ");
    } else {
      System.out.println("Thats not enough of an explanation for me....Wait Did You Gamble Our Morgage Away?????....Again????");
    }    
    // Dev Notes
    System.out.println(
      "**************************************Dev Notes**********************************************************");

    System.out.println(
      "Thank You For Playing My Game, I Spent Alot Of Time And Effort Programming And Editing This Code; Omar EL Kouzi ");

    System.out.println(
      "**************************************Dev Notes**********************************************************");

  }

  // Create your 3 methods here:
  public static int diceRoll() {
    DecimalFormat df = new DecimalFormat("0.00");
    String playAgain;
    String userGuessDiceRoll;
    int dice1; // Making An Intiger Called Dice1
    dice1 = (int)(Math.random() * 6) + 1; // Assigning The number In Dice1.
    int dice2; // Making An Intiger Called Dice2
    dice2 = (int)(Math.random() * 6) + 1; // Assigning The number In Dice2.
    int roll; // The total roll (sum of the two dice).
    roll = dice1 + dice2; // The Sum Of Dice 1 And Dice2
    int rollTimes; // The Number Of Times The Dice Is Rolled
    double betammount = 0.00;

    do { // do statement for the main diceroll game

      System.out.println("Welcome To The Dice Roll \n" + "****************************");
      System.out.println(
        "The Rules Are Simple You Will Get To Bet On Wether The Dice Total Will Be Above Or Equal To 6, Or If The Total Will Be Below 6 . If You Guess Correctley You Will Double Your Money, If Not You Will Loose It.");
      System.out.print("How Much Would You Like To Bet? (Your Past Bets Will Be Added To This Bet): ");
      while (!input.hasNextDouble()) { // Stops code from crashing
        input.next();
        System.out.println("Use  Numbers Only Please!");
      }
      betammount = input.nextDouble() + betammount;
      input.nextLine(); // Clear The Buffer
      do {
        System.out.print("Do You Think The Total Will Be Above 6 Or Below?:");
        while (!input.hasNextLine()) {
          input.next();
          System.out.println("Use Above Or Below Only Please!");
          System.out.print("Please enter your guess: ");
        }
        userGuessDiceRoll = input.nextLine();
      } while (!(userGuessDiceRoll.equalsIgnoreCase("below") || userGuessDiceRoll.equalsIgnoreCase("above")));
      if (userGuessDiceRoll.equalsIgnoreCase("above")) { // If The User Guesses Above
        System.out.format(" %7s %10s %14s", "Dice 1", "Dice 2", "Total \n");

        for (rollTimes = 0; rollTimes < 1;) { // The for statement for the dice roll

          dice1 = (int)(Math.random() * 6) + 1; // Equation For Random number between 6 and 1
          dice2 = (int)(Math.random() * 6) + 1; // Equation For Random number between 6 and 1
          roll = dice2 + dice1; // Adds Dice1 And Dice2 And Stores It
          System.out.format(" %2s %10s %14s", +dice1, +dice2, +roll + "\n");

          if (roll >= 6 && roll < 13) { // If They Guess right
            betammount = betammount * 2;
            System.out.println("CONGRATS!! You Have Doubled Your Bet!");
            System.out.println("Your Bets Turned Into: " + df.format(betammount) + "$");;
          } else if (roll < 6 && roll < 13) { // If They Guess Wrong

            betammount = 0;
            System.out.println(
              ".............You Kinda Lost Your Bet......Sorry....Ill Still Take your Money Though... ");
            System.out.println("Your Bets Turned Into: " + df.format(betammount) + "$");;

          }
          rollTimes++; // Ads 1 To Exit Loop

        }
      } else if (userGuessDiceRoll.equalsIgnoreCase("below")) { // If The User Guesses Below

        System.out.format(" %7s %10s %14s", "Dice 1", "Dice 2", "Total \n");

        for (rollTimes = 0; rollTimes < 1;) { // The for statement for the dice roll

          dice1 = (int)(Math.random() * 6) + 1; // Equation For Random number between 6 and 1
          dice2 = (int)(Math.random() * 6) + 1; // Equation For Random number between 6 and 1
          roll = dice2 + dice1; // Adds Dice1 And Dice2 And Stores It
          System.out.format(" %2s %10s %14s", +dice1, +dice2, +roll + "\n");

          rollTimes++; // Ads 1 To Exit Loop
          if (roll <= 6 && roll < 13) { // If They Guess right
            betammount = betammount * 2;
            System.out.println("CONGRATS!! You Have Doubled Your Bet!");
            System.out.println("Your Bets Turned Into: " + df.format(betammount) + "$");
          } else if (roll > 6 && roll < 13) { // If They Guess Wrong
            betammount = 0;
            System.out.println(
              ".............You Kinda Lost Your Bet......Sorry....Ill Still Take your Money Though...  ");
            System.out.println("Your Bets Turned Into: " + df.format(betammount) + "$");
          }

        }
      }
      System.out.print("Would you like to cash out?: ");
      playAgain = input.nextLine();

    } while (playAgain.equalsIgnoreCase("no") || playAgain.equalsIgnoreCase("n"));

    return (int) betammount;

  }

  public static int guessingGame() {

    String playAgain;
    double betammountguessing;

    do {
      int randomNumber = (int)((10 - 1 + 1) * Math.random() + 1);
      betammountguessing = 0.00;
      System.out.println("Lets Play A Game! ");
      System.out.print("How Much Would You Like To Bet? (Your Past Bets Will NOT Be Added To This Bet): ");
      while (!input.hasNextDouble()) { // Stops code from crashing
        input.next();
        System.out.println("Use  Numbers Only Please!");
      }
      betammountguessing = input.nextDouble();
      System.out.print("The Computer Is Thinking Of A Number Between 1 and 10. Can You Guess it?");

      // Making The Unexpected Entree Code
      while (!input.hasNextInt()) { // Stops code from crashing
        input.next();
        System.out.println("Use Whole Numbers Only Please!");
        System.out.print("Please enter your guess: ");
      }

      int guess1 = input.nextInt(); // Making guess number 1 a variable and opening it to the user

      if (guess1 == randomNumber) { // The first if statement bunch
        System.out.println("You Guessed It Right! You Had A 1 In 10 Chance Guessing It.....Amazing!");
        betammountguessing = betammountguessing * 2;
        System.out.println("You Made: " + betammountguessing + "$" + " This Round");
      } else {
        if (guess1 > randomNumber) { // Making an if statement within an if statement
          System.out.println("Psst......Guess Lower");
        } else if (guess1 < randomNumber) {
          System.out.println("Psst......Guess Higher");
        }

        System.out.print("Try Guessing The Number A Second Time ");

        while (!input.hasNextInt()) { // Stops code from crashing
          input.next();
          System.out.println("Unexpexted entry");
          System.out.print("Try Guessing The Number A Second Time  ");
        }
        int guess2 = input.nextInt();

        if (guess2 == randomNumber) { // The second if statemet bunch
          System.out.println("You Guessed It Right! You Had A 2 In 10 Chances Guessing It.....Amazing!");
          betammountguessing = betammountguessing * 2;
          System.out.println("You Made: " + betammountguessing + "$" + " This Round");
        } else {
          if (guess2 > randomNumber) { // Making the second if statemet within an if statemnt
            System.out.println("Psst......Guess Lower");
          } else if (guess2 < randomNumber) {
            System.out.println("Psst......Guess Higher");
          }
          System.out.print("Try Guessing The Number One Last Time : ");

          while (!input.hasNextInt()) { // Stops code from crashing
            input.next();
            System.out.println("Unexpexted entry");
            System.out.print("Try Guessing The Number One Last Time : ");
          }
          int guess3 = input.nextInt();

          if (guess3 == randomNumber) { // The last if statement bunch
            System.out.println("You Guessed It Right! You Had A 3 In 10 Chances Guessing It.....Amazing!");
            betammountguessing = betammountguessing * 2;
            System.out.println("You Made: " + betammountguessing + "$" + " This Round");
          } else {
            if (guess3 > randomNumber) { // Making the final if statement within an if statement
              System.out.println("Psst......Guess Lower");
            } else if (guess3 < randomNumber) {
              System.out.println("Psst......Guess Higher");
            }
            // Making The Code For If The Player Runs Out Of Guesses
            System.out.println("Sorry You Ran Out Of Guesses ");
            System.out.println("The Compuer's Number Was: " + randomNumber);
            System.out.println("Your Guesses Were: " + guess1);
            System.out.println("Your Guesses Were: " + guess2);
            System.out.println("Your Guesses Were: " + guess3);
            System.out.println("Better Luck Next Time!");
            System.out.println("You Have Lost You Money.");
            betammountguessing = 0;
          }
        }
      }
      input.nextLine(); // Clearing Buffer
      System.out.print("Would you like to cash out?: ");

      playAgain = input.nextLine();

    } while (playAgain.equalsIgnoreCase("no") || playAgain.equalsIgnoreCase("n")); // no working

    return (int) betammountguessing;

  }

  public static void numberCount() throws InterruptedException {
    String answer;
    String anything;
    long randomnum;
    long score = 0;
    long userguess;
    long minmumnumber = 0;
    long maximumnumber = 10000;
    input.nextLine(); // clear the buffer
    do {
        score = 0;
      System.out.println("This Game Is All About Skill Not Luck! So You Cant Bet Here.");
      System.out.println(
        "Youll See A Number Displayed On The Screen Remember it for 5 seconds and then type it back out!.");
      System.out.println("Are You Ready? Type Anything");

      do {

        while (!input.hasNextLine()) { // Stops code from crashing
          input.next();

          System.out.println("Please enter Yes to begin");
        }

        anything = input.nextLine();

      } while (!(anything.equalsIgnoreCase("yes") || (!(anything.equalsIgnoreCase("y")))));

      for (long repetition = 1; repetition > 0; repetition++) {

        randomnum = (long)((maximumnumber - minmumnumber + 1) * Math.random() + minmumnumber); // Making The
        // Number A
        // Random one
        // between the
        // Minimum
        // variable and
        // max
        System.out.println("Memorize This Number You Have 5 Seconds To Do So");
        System.out.println(randomnum);

        TimeUnit.SECONDS.sleep(5);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("Enter The Numbers: ");
        while (!input.hasNextLong()) {
          input.next();
          System.out.print("Must enter whole numbers: ");
        }

        userguess = input.nextLong();

        if (!(userguess == randomnum)) {
          repetition = -(repetition + 9);

        } else {
          System.out.println("You Got It! Next Number!\n");
          score++;
        }
      }
      // if enters wrong numbers
      System.out.println("Incorrect");
      System.out.println("Your final score was : " + score);

      input.nextLine(); // clear the buffer

      
        System.out.print("Would you like to play again? (y/n): ");

        answer = input.nextLine();
        

    } while (answer.equalsIgnoreCase("yes")||answer.equalsIgnoreCase("y"));

  }

  public static void resturant() {

    double bruschetta; // Making the variables, double so they display the decimal places
    double foiegras;
    double grilledlobster;
    double watercress;
    double pricebruschetta;
    double pricefoiegras;
    double pricegrilledlobster;
    double pricewatercress;
    double subtotal;
    double tax;
    double grandtotal;
    double tender;
    double ammountpayed = 0;
    int resturant;
    String again;
    // Scanner input = new Scanner(System.in);

    DecimalFormat df = new DecimalFormat("0.00");
    input.nextLine(); // Clearing Buffer
    // displays listing the prices

    System.out.println("----------------------------------------------------------------------");

    System.out.println("Welcome To The Casino's Resturant ");

    System.out.println("Bruschetta : 25 $ (1)");
    System.out.println("Foie gras: 53 $ (2)");
    System.out.println("Grilled Lobster Tails With Lemon & Herb Butter: 100 $ (3)");
    System.out.println("Watercress & Celeriac Soup With Goat’s Cheese Crouton: 145 $ (4)");
    System.out.println("----------------------------------------------------------------------");
    do {
      System.out.print("Please enter 1 - 4 To Learn About A Dish: ");
      while (!input.hasNextInt()) { // Making The Unexpected Enter Code To Not Crash The Program
        input.next();
        System.out.println("Use Whole Numbers Only Please! ");
      }
      resturant = input.nextInt();

      input.nextLine(); // Clearing Buffer
      switch (resturant) { // 1-5 It displays the speed anything else Invalid
      case 1:
        System.out.println(
          "Great Choice, The Bruschetta is an antipasto from Italy consisting of grilled bread rubbed with garlic and topped with olive oil and salt.  ");
        break;
      case 2:
        System.out.println(
          "Ooh A Person With Taste! Foie gras is a specialty food product made of the liver of a duck or goose. ");
        break;
      case 3:
        System.out.println(
          "Fishy Taste? No Probelem The lobster tails are complimented with parsley, lemon, and garlic butter.");
        break;
      case 4:
        System.out.println(
          "Good Starter,This is a simple starter you can freeze ahead for your friends and family, and for an extra richness add the goat’s cheese.");
        break;
      default:
        System.out.println("INVALID ONLY 1-5");

      }

      System.out.println("Want To Learn About Another Dish?");
      again = input.nextLine();

    } while (again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y"));

    System.out.print("#  Of Bruschetta : ");
    while (!input.hasNextInt()) { // Making The Unexpected Entree Code To Not Crash The Program
      input.next();
      System.out.println("Use Whole Numbers Only Please! ");
    }
    bruschetta = input.nextInt();
    System.out.print("#  Of Foie gras : ");
    while (!input.hasNextInt()) { // Making The Unexpected Entree Code To Not Crash The Program
      input.next();
      System.out.println("Use Whole Numbers Only Please! ");
    }
    foiegras = input.nextInt();
    System.out.print("#  Of Grilled Lobster Tails : ");
    while (!input.hasNextInt()) { // Making The Unexpected Entree Code To Not Crash The Program
      input.next();
      System.out.println("Use Whole Numbers Only Please! ");
    }
    grilledlobster = input.nextInt();
    System.out.print("#  Of Watercress & Celeriac : ");
    while (!input.hasNextInt()) { // Making The Unexpected Entree Code To Not Crash The Program
      input.next();
      System.out.println("Use Whole Numbers Only Please! ");
    }
    watercress = input.nextInt();

    pricebruschetta = bruschetta * 25;
    pricefoiegras = foiegras * 53;
    pricegrilledlobster = grilledlobster * 100;
    pricewatercress = watercress * 200;

    subtotal = pricebruschetta + pricefoiegras + pricegrilledlobster + pricewatercress;

    System.out.println("Subtotal : " + df.format(subtotal) + "$");
    tax = subtotal * 0.13;
    System.out.println("Tax (0.13) : " + df.format(tax) + "$");
    grandtotal = tax + subtotal;
    System.out.println("GrandTotal : " + df.format(grandtotal) + "$");

    System.out.println("----------------------------------------------------------------------");

    // Making the "Paying" Code which subtracts the ammount payed by the grand total
    System.out.print(
      "We Dont Take Casino Money At The Resturant Please Pay Cash Or Card. (If Card Please Enter The Full Ammount, If Cash Type How Much Cash) : ");
    while (!input.hasNextInt()) { // Making The Unexpected Entree Code To Not Crash The Program
      input.next();
      System.out.println("Use Whole Numbers Only Please! ");
    }
    ammountpayed = input.nextDouble();

    System.out.println("Ammount Payed : " + df.format(ammountpayed) + "$");
    tender = ammountpayed - grandtotal;
    System.out.println("Tender : " + df.format(tender) + "$");
    if (ammountpayed < grandtotal) {
      System.out.println("HEY!!!HEY YOU!! WHAT DO YOU THINK YOUR DOING...GAURDS GAURDS THEY ARE STEALING!!!");
      System.out.println("*You Slip Your Hood Up And Blend Into The Crowd, The Gaurds Loose Track Of You.....Well Done Agent 47");
    }
  }
}
