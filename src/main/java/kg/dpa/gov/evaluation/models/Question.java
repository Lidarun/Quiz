package kg.dpa.gov.evaluation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kg.dpa.gov.evaluation.enums.Language;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tb_questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String question;

    @NotEmpty
    @Size(min = 1)
    @ElementCollection
    @Fetch(value = FetchMode.JOIN)
    private List<@NotEmpty String> options;

    private Integer correctAnswer = null;

    @NotEmpty
    private String answerExplain;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Language lang;

    public Question() {
        this.options = new ArrayList<>();
    }

    public boolean isCorrect(Integer answer) {
        return answer != null && answer.equals(correctAnswer);
    }}
