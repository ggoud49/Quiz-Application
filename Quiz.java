import java.util.*;

class QuizApplication {

    // ANSI Color Codes
    static final String RESET  = "\u001B[0m";
    static final String RED    = "\u001B[31m";
    static final String GREEN  = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE   = "\u001B[34m";
    static final String CYAN   = "\u001B[36m";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Question> quiz = new ArrayList<>();
        loadQuestions(quiz);

        int score = 0;

        System.out.println(BLUE + "==================================" + RESET);
        System.out.println(BLUE + "        JAVA QUIZ APPLICATION     " + RESET);
        System.out.println(BLUE + "==================================" + RESET);

        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);

            System.out.println(CYAN + "\nQ" + (i + 1) + ": " + q.question + RESET);
            System.out.println(q.option1);
            System.out.println(q.option2);
            System.out.println(q.option3);
            System.out.println(q.option4);

            System.out.print(YELLOW + "Enter answer (A/B/C/D): " + RESET);
            char ans = sc.next().toUpperCase().charAt(0);

            if (ans == q.correctAnswer) {
                System.out.println(GREEN + "Correct ✔" + RESET);
                score++;
            } else {
                System.out.println(RED + "Wrong ✘ | Correct Answer: " 
                                   + q.correctAnswer + RESET);
            }
        }

        int total = quiz.size();
        int wrong = total - score;
        double percentage = (score * 100.0) / total;

        System.out.println(BLUE + "\n========== RESULT ==========" + RESET);
        System.out.println(CYAN + "Total Questions : " + total + RESET);
        System.out.println(GREEN + "Correct Answers : " + score + RESET);
        System.out.println(RED + "Wrong Answers   : " + wrong + RESET);
        System.out.println(YELLOW + "Percentage      : " + percentage + "%" + RESET);

        if (percentage >= 80)
            System.out.println(GREEN + "Grade: A (Excellent)" + RESET);
        else if (percentage >= 60)
            System.out.println(CYAN + "Grade: B (Good)" + RESET);
        else if (percentage >= 40)
            System.out.println(YELLOW + "Grade: C (Average)" + RESET);
        else
            System.out.println(RED + "Grade: Fail" + RESET);

        System.out.println(BLUE + "============================" + RESET);
    }

    // Load 20 Questions
    static void loadQuestions(ArrayList<Question> quiz) {

        quiz.add(new Question("Which keyword is used to inherit a class?",
                "A) this", "B) super", "C) extends", "D) implements", 'C'));

        quiz.add(new Question("Which method is the entry point of Java?",
                "A) start()", "B) main()", "C) run()", "D) init()", 'B'));

        quiz.add(new Question("Which data type is not primitive?",
                "A) int", "B) float", "C) String", "D) char", 'C'));

        quiz.add(new Question("Which operator compares values?",
                "A) =", "B) ==", "C) !=", "D) All", 'D'));

        quiz.add(new Question("Which collection does not allow duplicates?",
                "A) List", "B) ArrayList", "C) Set", "D) Map", 'C'));

        quiz.add(new Question("Which keyword creates object?",
                "A) class", "B) new", "C) object", "D) create", 'B'));

        quiz.add(new Question("Which package is default in Java?",
                "A) java.util", "B) java.io", "C) java.lang", "D) java.sql", 'C'));

        quiz.add(new Question("Which keyword stops inheritance?",
                "A) static", "B) final", "C) private", "D) abstract", 'B'));

        quiz.add(new Question("Which concept supports overriding?",
                "A) Encapsulation", "B) Abstraction", "C) Polymorphism", "D) Inheritance", 'C'));

        quiz.add(new Question("Which loop is entry controlled?",
                "A) do-while", "B) while", "C) for", "D) both B & C", 'D'));

        quiz.add(new Question("Which exception is checked?",
                "A) NullPointerException", "B) ArithmeticException",
                "C) IOException", "D) ArrayIndexOutOfBounds", 'C'));

        quiz.add(new Question("Which keyword calls parent constructor?",
                "A) this", "B) parent", "C) super", "D) base", 'C'));

        quiz.add(new Question("Which collection maintains insertion order?",
                "A) HashSet", "B) TreeSet", "C) LinkedHashSet", "D) Set", 'C'));

        quiz.add(new Question("Which thread method starts execution?",
                "A) run()", "B) start()", "C) init()", "D) resume()", 'B'));

        quiz.add(new Question("Which feature supports multiple inheritance?",
                "A) Class", "B) Abstract class", "C) Interface", "D) Object", 'C'));

        quiz.add(new Question("Which keyword is used for constants?",
                "A) static", "B) final", "C) const", "D) constant", 'B'));

        quiz.add(new Question("Which access modifier has highest scope?",
                "A) private", "B) default", "C) protected", "D) public", 'D'));

        quiz.add(new Question("Which class is parent of all classes?",
                "A) Main", "B) System", "C) Object", "D) Class", 'C'));

        quiz.add(new Question("Which stream is used for input?",
                "A) System.out", "B) System.in", "C) System.err", "D) Scanner", 'B'));

        quiz.add(new Question("Which keyword is used to handle exception?",
                "A) throw", "B) throws", "C) try-catch", "D) final", 'C'));
    }
}

// Question Class
class Question {
    String question, option1, option2, option3, option4;
    char correctAnswer;

    Question(String q, String o1, String o2, String o3, String o4, char ca) {
        question = q;
        option1 = o1;
        option2 = o2;
        option3 = o3;
        option4 = o4;
        correctAnswer = ca;
    }
}
