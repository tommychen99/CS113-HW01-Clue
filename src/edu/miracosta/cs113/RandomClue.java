package edu.miracosta.cs113;

/**
 * RandomClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries.  RandomClue is ONE solution to the problem,
 * where a set of random numbers is generated every attempt until all three
 * random numbers match the solution from the AssistantJack object.
 *
 * This is a sample solution, a driver using random number implementation.
 * You can use this file as a guide to create your own SEPARATE driver for
 * your implementation that can solve it in <= 20 times consistently.
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;
import java.util.ArrayList;

public class RandomClue {

    /*
     *  ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * DO
     *      weapon = random int between 1 and 6
     *      location = random int between 1 and 10
     *      murder = random int between 1 and 6
     *      solution = jack.checkAnswer(weapon, location, murder)
     * WHILE solution != 0
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        do
        {
            weapon = 0;
            location = 0;
            murder = 0;
            solution = 0;

            ArrayList<Integer> weaponArr = new ArrayList<>();
            ArrayList<Integer> locationArr = new ArrayList<>();
            ArrayList<Integer> murderArr = new ArrayList<>();

            for(int i = 0; i < 6; i++)
            {
                for(int j = 0; j < 10; j++)
                {
                    for(int k = 0; k < 6; k++)
                    {
                        weapon = i + 1;
                        location = j + 1;
                        murder = k + 1;

                        if(weaponArr.contains(weapon))
                        {
                            for(int a = 1; a <= 6; a++)
                            {
                                if(!weaponArr.contains(a))
                                {
                                    weapon = a;
                                    break;
                                }
                            }
                        }

                        if(locationArr.contains(location))
                        {
                            for(int a = 1; a <= 10; a++)
                            {
                                if(!locationArr.contains(a))
                                {
                                    location = a;
                                    break;
                                }
                            }
                        }

                        if(murderArr.contains(murder))
                        {
                            for(int a = 1; a <= 6; a++)
                            {
                                if(!murderArr.contains(a))
                                {
                                    murder = a;
                                    break;
                                }
                            }
                        }

                        solution = jack.checkAnswer(weapon, location, murder);

                        if(solution == 1)
                        {
                            if(!weaponArr.contains(weapon))
                            {
                                weaponArr.add(weapon);
                            }
                        }

                        else if(solution == 2)
                        {
                            if(!locationArr.contains(location))
                            {
                                locationArr.add(location);
                            }
                        }

                        else if(solution == 3)
                        {
                            if(!murderArr.contains(murder))
                            {
                                murderArr.add(murder);
                            }
                        }

                        if(solution == 0)
                        {
                            break;
                        }
                    }

                    if(solution == 0)
                    {
                        break;
                    }
                }

                if(solution == 0)
                {
                    break;
                }
            }
        }

        while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}