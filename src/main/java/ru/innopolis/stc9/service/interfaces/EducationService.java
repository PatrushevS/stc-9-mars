package ru.innopolis.stc9.service.interfaces;

import ru.innopolis.stc9.pojo.Education;

import java.util.List;

/**
 * Created by Сергей on 01.06.2018.
 */
public interface EducationService {
    List<Education> findAllEducations();
}
