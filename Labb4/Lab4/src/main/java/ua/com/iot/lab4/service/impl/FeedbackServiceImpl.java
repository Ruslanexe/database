package ua.com.iot.lab4.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ua.com.iot.lab4.dao.IFeedbackDao;
import ua.com.iot.lab4.domain.Feedback;
import ua.com.iot.lab4.service.IFeedbackService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements IFeedbackService {
    private IFeedbackDao feedbackDao;

    @Override
    public List<Feedback> getAll() {
        return feedbackDao.getAll();
    }

    @Override
    public Optional<Feedback> getById(Integer id) {
        return feedbackDao.getById(id);
    }

    @Override
    public int create(Feedback feedback) {
        return feedbackDao.create(feedback);
    }

    @Override
    public int delete(Integer id) {
        return feedbackDao.delete(id);
    }
}
