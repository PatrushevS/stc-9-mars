package ru.innopolis.stc9.service;

import org.springframework.stereotype.Service;
import ru.innopolis.stc9.dao.MarkDao;
import ru.innopolis.stc9.dao.MarkDaoImpl;
import ru.innopolis.stc9.dao.UserDao;
import ru.innopolis.stc9.dao.UserDaoImpl;
import ru.innopolis.stc9.pojo.Mark;
import ru.innopolis.stc9.pojo.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class MarkServiceImpl implements MarkService {

    private MarkDao markDao = new MarkDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    /**
     * Возвращает Map с именами студентов и их оценками за работу на уроке,
     * id которого передается параметром метода.
     *
     * @param lessonId
     * @return
     */
    @Override
    public Map<String, Mark> getMarksByLessonId(int lessonId) {
        Map<String, Mark> result = new HashMap<>();
        for (Mark mark : markDao.getMarksByLessonId(lessonId)) {
            User user = userDao.findUserByUserId(mark.getUserId());
            String name = (new StringBuilder(user.getSecondName())
                    .append(" ")
                    .append(user.getFirstName())
                    .append(" ")
                    .append(user.getMiddleName())
            ).toString();
            result.put(name, mark);
        }
        return result;
    }

    @Override
    public Mark getMarkById(int id) {
        return markDao.getMarkById(id);
    }

    @Override
    public boolean updateMark(Mark mark) {
        return markDao.updateMark(mark);
    }

    @Override
    public String getFullStudentNameInOneString(int markId) {
        Mark mark = getMarkById(markId);
        User user = userDao.findUserByUserId(mark.getUserId());
        return user.getSecondName() +
                " " +
                user.getFirstName() +
                " " +
                user.getMiddleName();
    }

    @Override
    public String getLessonName(int markId) {
        Mark mark = getMarkById(markId);
        return null;
    }

}