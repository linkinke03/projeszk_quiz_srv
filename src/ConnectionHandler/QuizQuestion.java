package ConnectionHandler;

import java.io.Serializable;
import java.util.ArrayList;

public class QuizQuestion implements Serializable{
    private String question;
    private ArrayList<String> answers;

    /**
     * Visszaadja a kérdést.
     * @return A kérdés
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Visszadja a válaszokat
     * @return A válaszok ArryListben
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }
    
    /**
     * A kérdésből és a válaszokból létrehozza az objektumot.
     * @param q A kérdés
     * @param answers A válaszok
     */
    public QuizQuestion(String q, ArrayList<String> answers) {
        question = q;
        this.answers = answers;
    }
    
    
}
