package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


//abstract class meaning that we can not create new objects of question type?
//abstract meaning a set of behaviors we want to share between classes?
public abstract class Question {

    //initializing class attributes
    //we have a String called question
    // a HashMap of integers and choices
    private final String question;
    private HashMap<Integer, Choice> choiceMap;

    //class constructor. Constructors set the initial value for object attribtutes
    // does not have a return, must be of same name as Class
    //constructors are responsible for us being able to add values to new instances of the class?

    public Question(String question, Choice[] choiceArray) {
        this.question = question;
        createRandomChoiceMap(choiceArray);
    }

    public String getQuestion() {
        return question;
    }

    public HashMap<Integer, Choice> getChoiceMap() {
        return choiceMap;
    }


    // overriding the default toString method
    @Override
    public abstract String toString();

    void createRandomChoiceMap (Choice[] choiceArray) {
        choiceMap = new HashMap<>();
        ArrayList<Choice> choiceList = new ArrayList<>();
        Collections.addAll(choiceList, choiceArray);
        Collections.shuffle(choiceList);

        for(int i =0; i< choiceList.size(); i++){
            choiceMap.put(i+1, choiceList.get(i));
        }
    }

    String getForomattedChoices(){
        StringBuilder formattedChoices = new StringBuilder();
        for (int choiceNum : choiceMap.keySet()) {
            String choice = "\t" + choiceNum + " - " + choiceMap.get(choiceNum).getContent() + "\n";
            formattedChoices.append(choice);
        }
        return formattedChoices.toString();
    }

}
