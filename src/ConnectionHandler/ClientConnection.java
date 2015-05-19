package ConnectionHandler;

import entities.quiz;
import entities.quizJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.persistence.Persistence;

public class ClientConnection extends Thread {
    
    private final quizJpaController quizController;
    private quiz q;
    private QuizQuestion question;
    
    private final Socket s;
    private final Scanner sc;
    private final PrintWriter pw;
    
    
    /**
     * A kapott socketre létrehozza a kapcsolatot a kliens felé és
     * a kapcsolatot az adatbázis felé.
     * @param s A kliens sockete.
     * @throws IOException Kommunikációs hiba.
     */
    public ClientConnection(Socket s) throws IOException {
        quizController = new quizJpaController(Persistence.createEntityManagerFactory("quiz_serverPU"));
        this.s = s;
        sc = new Scanner(s.getInputStream());
        pw = new PrintWriter(s.getOutputStream());
    }
    
    @Override
    public void run() {
        String action = sc.nextLine();
        while(!action.equals("quit")) {
            switch (action) {
                case "new":
                    createQuizQuestion(q);
                    action = sc.nextLine();
                    break;
                case "isCorrect":
                    String answer = sc.nextLine();
                    if(isCorrect(answer)){
                        pw.println(1);
                        pw.flush();
                    } else {
                        pw.println(0);
                        pw.flush();
                    }
                    action = sc.nextLine();
                    break;
                case "getCorrectAnswer":
                    pw.println(q.helyesValasz);
                    pw.flush();
                    action = sc.nextLine();
                    break;
                case "getQuestion":
                    pw.println(question.getQuestion());
                    pw.println(question.getAnswers().get(0));
                    pw.println(question.getAnswers().get(1));
                    pw.println(question.getAnswers().get(2));
                    pw.println(question.getAnswers().get(3));
                    pw.flush();
                    action = sc.nextLine();
                    break;
                default:
                    action = sc.nextLine();
                    break;
            }
        }
    }
    
    private void createQuizQuestion(quiz q) {
        Random r = new Random();
        String question = q.getKerdes();
        
        ArrayList<String> answers = new ArrayList();
        Integer n = r.nextInt(3)+1;
        Boolean correctAdded = false;
        
        for(int i = 0; i<4; ++i){
            if(i == n) {
                answers.add(q.getHelyesValasz());
                correctAdded = true;
                continue;
            }
            
            if(!correctAdded) {
                switch (i) {
                    case 0:
                        answers.add(q.getValasz_2());
                        break;
                    case 1:
                        answers.add(q.getValasz_3());
                        break;
                    case 2:
                        answers.add(q.getValasz_4());
                        break;
                    default:
                        break;
                }
            } else {
                switch (i) {
                    case 1:
                        answers.add(q.getValasz_2());
                        break;
                    case 2:
                        answers.add(q.getValasz_3());
                        break;
                    case 3:
                        answers.add(q.getValasz_4());
                        break;
                    default:
                        break;
                }
            }
        }
        
        this.question = new QuizQuestion(question, answers);
    }

    public QuizQuestion getNewQuestion() {
        q = quizController.getRandomQuiz();
        createQuizQuestion(q);
        return this.question;
    }

    public Boolean isCorrect(String answer) {
        return answer.equals(q.helyesValasz);
    }

    public String getCorrectAnswer() {
        return q.helyesValasz;
    }
}
