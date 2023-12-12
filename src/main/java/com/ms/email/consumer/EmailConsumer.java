package com.ms.email.consumer;

import com.ms.email.config.RabbitMQConfig;
import com.ms.email.dto.EmailDTO;
import com.ms.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_SEND_EMAIL)
    public void listenEmailQueue(@Payload EmailDTO emailDTO){
        this.emailService.sendEmail(emailDTO);
    }
}
