package kg.dpa.gov.evaluation.controllers;

import kg.dpa.gov.evaluation.models.Question;
import kg.dpa.gov.evaluation.repository.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private final QuestionRepository repository;
    private List<Question> questions;
    private int currentQuestionIndex;
    private int result;

    public QuizController(QuestionRepository repository) {
        this.repository = repository;
        this.questions = repository.findAll();
        currentQuestionIndex = 0;
    }

    @GetMapping()
    public String showQuestion(Model model) {
        questions.forEach(System.out::println);

        if (currentQuestionIndex > questions.size()) currentQuestionIndex = 0;
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            model.addAttribute("result", result);
            model.addAttribute("quizSize", questions.size());
            model.addAttribute("question", currentQuestion);
            return "question";
        }

        model.addAttribute("result", result);
        model.addAttribute("quizSize", questions.size());

        result = 0;
        currentQuestionIndex = 0;

        return "result";
    }

    @PostMapping()
    public String submitAnswer(@RequestParam("correctAnswer") Integer answer, Model model) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        boolean check = currentQuestion.isCorrect(answer != null ? answer : -1);

        currentQuestionIndex++;
        System.out.println(currentQuestionIndex);

        if (check) {
            result++;
            return "redirect:/quiz";

        }else {
            model.addAttribute("rightAnswer",
                    currentQuestion.getOptions().get(currentQuestion.getCorrectAnswer()));
            model.addAttribute("why",
                    currentQuestion.getAnswerExplain());
            return "checker";
        }
    }
}
