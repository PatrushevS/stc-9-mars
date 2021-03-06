package ru.innopolis.stc9.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

//@Entity
//TODO need to delete class
@Table(name = "progress")
@NoArgsConstructor
@AllArgsConstructor
public class Progress {
    @Getter
    @Setter
    @Id
    @SequenceGenerator(name = "progressSeq", sequenceName = "PROGRESS_SEQUENCE", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "progressSeq")
    private Integer id;
    @Getter
    @Setter
    private int value;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String secondName;
    @Getter
    @Setter
    private String lessonsName;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private String subjectName;
    @Getter
    @Setter
    private String groupName;
    @Getter
    @Setter
    private String login;
}
