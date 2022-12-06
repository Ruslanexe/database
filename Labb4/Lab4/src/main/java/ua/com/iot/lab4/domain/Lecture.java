package ua.com.iot.lab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {
    private Integer id;
    private String date;
    private String topic;
    private Integer groupId;
    private Integer subjectId;
    private Integer lecturerId;
}
