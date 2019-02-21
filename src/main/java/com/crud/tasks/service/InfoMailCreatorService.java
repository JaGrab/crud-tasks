package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoMailCreatorService implements MailCreator {
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private CompanyConfig companyConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;
    @Autowired
    private TaskRepository taskRepository;

    public String buildEmail(String message) {
        List<Task> tasks = taskRepository.retrieveLastThreeTasks();

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("company_config", companyConfig);
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("last_tasks", tasks);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
