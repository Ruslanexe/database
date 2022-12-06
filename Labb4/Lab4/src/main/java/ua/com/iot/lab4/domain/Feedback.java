package ua.com.iot.lab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private Integer id;
    private String response;
    private Integer mark;
    private Integer studentId;
    private Integer lectureId;
}
