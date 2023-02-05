package quiz;

public class QuizzRunner {

    private static final Quiz quiz = new Quiz();

    public static void main (String[] args){


        String q1 = "How many of these characters were the Hokage?";
        Choice[] q1Choices = new Choice[] {
                new Choice("Guy Sensei"),
                new Choice("Hiruzen Sarutobi", true),
                new Choice("Shikamaru Nara"),
                new Choice("Hashirama Senju", true),
                new Choice("Orochimaru"),
                new Choice("Kakashi Hatake", true),
        };

        Checkbox question1 = new Checkbox(q1,q1Choices);

        quiz.addQuestions(new Question[]{question1});

        quiz.runQuiz();

        System.out.println("\nYou answered" + quiz.getNumCorrect() + "of " + quiz.getQuestions().size() + "questions correctly. Thanks for playing!");
    }
}
