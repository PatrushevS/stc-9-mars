package ru.innopolis.stc9.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc9.pojo.Subject;
import ru.innopolis.stc9.service.SubjectService;
import ru.innopolis.stc9.service.SubjectServiceImpl;

@Controller
@RequestMapping(value = "/views/subject")
public class SubjectController {
    private final Logger logger = Logger.getLogger(GroupController.class);
    @Autowired
    private final SubjectService subjectService = new SubjectServiceImpl();

    @RequestMapping(method = RequestMethod.GET)
    private String doGet(Model model) {
        model.addAttribute("subjects", subjectService.findAllSubject());
        return "views/subject";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSubjectMethodPost(@RequestParam(value = "name", required = false) String name, Model model) {
        Subject subject = new Subject(name);
        if (checkSubjectName(name)) {
            model.addAttribute("errorName", "Предмет (" + name + ") присутствует в списке предметов");
        } else {
            subjectService.addSubject(subject);
            logger.info("subject (" + name + ") added");
        }
        return doGet(model);
    }

    private boolean checkSubjectName(String name) {
        boolean result = false;
        for (Subject subject : subjectService.findAllSubject()) {
            if (name.equals(subject.getName())) {
                result = true;
            }
        }
        return result;
    }

    @RequestMapping(value = "/delete")
    private String delSubjectMethodPost(@RequestParam("idSubj") int id, Model model) {
        if (id > 0) {
            subjectService.deleteSubject(id);
            logger.info("subject " + id + " deleted");
        }
        return doGet(model);
    }

}