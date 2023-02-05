package quiz;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {

    private final ArrayList<Question> questions = new ArrayList<>();
    private int numCorrect = 0;

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public void addQuestions(Question[] questionArray) {
        Collections.addAll(questions, questionArray);
    }

    public void updateScore() {
        numCorrect++;
    }

    public void runQuiz() {
        Scanner input = new Scanner(System.in);
        Collections.shuffle(questions);

        for (Question question : questions) {
    // Prints questions and choices
            System.out.println(question);

            // Checks correct responses
            ArrayList<Integer> correctResponses = new ArrayList<>();
            for (int choiceNum : question.getChoiceMap().keySet()) {
                if (question.getChoiceMap().get(choiceNum).isCorrect()){
                    correctResponses.add(choiceNum);
                }
            }

            // capture users responses and evalutae them
            ArrayList<Integer> userResponses = new ArrayList<>();
            int i=0;
            while(i < correctResponses.size()){
                System.out.println("Please enter a number:");
                int userResponse = input.nextInt();
                if(userResponses.contains(userResponse))  {
                    System.out.println();
                } else if (!correctResponses.contains(userResponse)) {
                    System.out.println("Sorry, that is inccorect. The correct answer is:");
                    for (int resp : correctResponses) {
                        System.out.println(question.getChoiceMap().get(resp).getContent());
                    }
                    break;
                } else {
                    System.out.println("You got it right!");
                    userResponses.add(userResponse);
                    if (i == correctResponses.size() - 1) {
                        updateScore();
                    }
                    i++;
                }
            }

        }

        input.close();
    }

}

