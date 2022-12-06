package ua.com.iot.lab4.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ua.com.iot.lab4.controller.IFeedbackController;
import ua.com.iot.lab4.domain.Feedback;
import ua.com.iot.lab4.service.IFeedbackService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FeedbackControllerImpl implements IFeedbackController {
    private IFeedbackService feedbackService;

    @Override
    public List<Feedback> getAll() {
        return feedbackService.getAll();
    }

    @Override
    public Optional<Feedback> getById(Integer id) {
        return feedbackService.getById(id);
    }

    @Override
    public int create(Feedback feedback) {
        return feedbackService.create(feedback);
    }

    @Override
    public int delete(Integer id) {
        return feedbackService.delete(id);
    }
}



