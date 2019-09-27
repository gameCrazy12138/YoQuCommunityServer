package net.gupt.community.service.impl;

import net.gupt.community.entity.Student;
import net.gupt.community.mapper.StudentMapper;
import net.gupt.community.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <h3>gupt-community</h3>
 * <p>StudentService实现类</p>
 *
 * @author : Cui
 * @date : 2019-07-29 15:06
 **/
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student loginByUid(Integer uid) {
        return studentMapper.findStudentByUid(uid);
    }

    @Override
    public Student loginByOpenId(String openId) {
        return studentMapper.findStudentByOpenId(openId);
    }

    @Override
    public boolean userBinding(Student student) {
        int result = studentMapper.insert(student);
        return result != 0;
    }

    @Override
    public boolean updateWxInfo(String openId, String nickName, String avatarUrl) {
        int result = studentMapper.updateStudentWxInfo(openId, nickName, avatarUrl);
        return result != 0;
    }
}


