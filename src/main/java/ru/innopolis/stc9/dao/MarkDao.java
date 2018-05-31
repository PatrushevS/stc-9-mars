package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.pojo.Mark;

import java.util.List;

public interface MarkDao {
    public List<Mark> getMarksByLessonId(int id);

    public Mark getMarkById(int id);

    public boolean updateMark(Mark mark);
}