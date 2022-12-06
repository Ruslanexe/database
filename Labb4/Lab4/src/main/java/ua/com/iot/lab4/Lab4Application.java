package ua.com.iot.lab4;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.com.iot.lab4.view.MyView;

@SpringBootApplication(scanBasePackages = "ua.com.iot")
@AllArgsConstructor
public class Lab4Application implements CommandLineRunner {
    private MyView view;

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }
    @Override
    public void run(String... args) {
        view.show();
    }
}
