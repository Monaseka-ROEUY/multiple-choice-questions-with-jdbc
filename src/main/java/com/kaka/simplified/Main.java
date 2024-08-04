package com.kaka.simplified;


import com.kaka.simplified.dao.AnswerService;
import com.kaka.simplified.dao.QuestionService;
import com.kaka.simplified.model.Answer;
import com.kaka.simplified.model.Question;
import com.kaka.simplified.utils.ConsoleColor;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        QuestionService questionService = new QuestionService();
        AnswerService answerService = new AnswerService();
        AtomicInteger score = new AtomicInteger(0);
        boolean isPlaying = true;
        int questionNumber;

        while (isPlaying) {
            int numberOfQuestion = questionService.getNumberOfRecords();

            // Welcome to user when user enter the program
            System.out.println("Welcome to multiple choice questions");

            // Ask user for numbers of questions
            System.out.printf("How many questions would you like to answers (we have %d questions)? ", numberOfQuestion);

            // Get user number of questions
            questionNumber = SCANNER.nextInt();

            // Fetch questions from table
            List<Question> questions = questionService.getQuestions(questionNumber);

            // Iterate through each questions
            questions.forEach(q -> {
                // Display each question title
                questionService.displayQuestion(q);

                // Get all answers for each question for displaying all answer options to user
                List<Answer> answers = answerService.getAllAnswersByQuestionId(q.getId());

                // Display all answer to user
                answerService.displayAllAnswer(answers);

                // Hint user to choose one option from 1 to 3
                System.out.print("Choose an option from 1 -> 3: ");

                // Get input option number from user
                int userOptionNumber = SCANNER.nextInt();

                // Get answer text from user optionNumber then we minus 1 because it's index base
                String userAnswerText = answerService.getAnswerFromUser(answers, userOptionNumber);

                // Get correct answer text to verify with user answer text
                String correctAnswerText = answerService.getCorrectAnswerText(answers);

                // Check it's correct or not if correct increase score by 1
                if (answerService.isCorrect(userAnswerText, correctAnswerText)) {
                    System.out.println(ConsoleColor.GREEN + "You're correct" + ConsoleColor.RESET);
                    score.getAndIncrement();
                } else
                    System.out.println(ConsoleColor.RED + "You're incorrect!" + ConsoleColor.RESET);
            });

            // Display Scores
            System.out.println(ConsoleColor.YELLOW + "You got " + score.get() + " of " + questionNumber);

            // Ask user want to play it or not
            System.out.print("Would you like to play again (Y/N)? : " + ConsoleColor.RESET);

            // Receive user response
            String userAnswer = SCANNER.next();

            // If user say no terminate the program.
            if (userAnswer.equalsIgnoreCase("n") || userAnswer.equalsIgnoreCase("no")) {
                isPlaying = false;
            }
            score.set(0);
        }

    }
}

