package ua.com.iot.lab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {
    private Integer id;
    private String name;
    private String  description;

}
