package ru.innopolis.stc9.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mark")
@NoArgsConstructor
@AllArgsConstructor
public class Mark {
    @Getter
    @Setter
    @Id
    @SequenceGenerator(name = "markSeq", sequenceName = "MARK_SEQUENCE", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "markSeq")
    private int id;
    @Getter
    @Setter
    private int value;
    @Getter
    @Setter
    private String comment;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", nullable = false)
    private User student;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lessonId", nullable = false)
    private Lessons lesson;
    @Getter
    @Setter
    @Transient
    //TODO need to delete
    private int userId;
    @Getter
    @Setter
    @Transient
    //TODO need to delete
    private int lessonId;

    public Mark(int id, int value, int userId, int lessonId, String comment) {
        this.id = id;
        this.value = value;
        this.comment = comment;
        this.userId = userId;
        this.lessonId = lessonId;
    }
}
