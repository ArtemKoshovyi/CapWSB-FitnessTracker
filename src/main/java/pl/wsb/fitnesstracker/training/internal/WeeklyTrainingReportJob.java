package pl.wsb.fitnesstracker.training.internal;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.mail.api.EmailDto;
import pl.wsb.fitnesstracker.mail.api.EmailService;
import pl.wsb.fitnesstracker.training.api.TrainingRepository;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;

@Component
public class WeeklyTrainingReportJob {

    private final UserProvider userProvider;
    private final TrainingRepository trainingRepository;
    private final EmailService emailService;

    public WeeklyTrainingReportJob(UserProvider userProvider,
                                   TrainingRepository trainingRepository,
                                   EmailService emailService) {
        this.userProvider = userProvider;
        this.trainingRepository = trainingRepository;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 60000)
    public void sendWeeklyEmails() {
        for (User user : userProvider.findAllUsers()) {
            long totalTrainings = trainingRepository.countByUser_Id(user.getId());

            String subject = "FitnessTracker - weekly summary";
            String body = "Hello " + user.getFirstName() + "!\n\n"
                    + "You have " + totalTrainings + " trainings registered in total.\n\n"
                    + "Regards,\nFitnessTracker";

            emailService.send(new EmailDto(user.getEmail(), subject, body));

            System.out.println("Email sent to: " + user.getEmail());
        }}
}