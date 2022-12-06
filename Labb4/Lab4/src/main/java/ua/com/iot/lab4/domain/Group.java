package ua.com.iot.lab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private Integer id;
    private Integer number;
    private Integer programId;
}
