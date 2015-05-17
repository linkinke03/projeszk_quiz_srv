package ConnectionHandler;

import entities.quiz;
import entities.quizJpaController;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import javax.persistence.Persistence;

public class ClientConnection extends java.rmi.server.UnicastRemoteObject implements Serializable, QuestionInterface {
    
    private quizJpaController quizController;
    private quiz q;
    private QuizQuestion question;
    
    public ClientConnection() throws RemoteException {
        quizController = new quizJpaController(Persistence.createEntityManagerFactory("quiz_serverPU"));
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

    @Override
    public QuizQuestion getNewQuestion() {
        q = quizController.getRandomQuiz();
        createQuizQuestion(q);
        return this.question;
    }

    @Override
    public Boolean isCorrect(String answer) {
        return answer.equals(q.helyesValasz);
    }

    @Override
    public String getCorrectAnswer() {
        return q.helyesValasz;
    }
}
