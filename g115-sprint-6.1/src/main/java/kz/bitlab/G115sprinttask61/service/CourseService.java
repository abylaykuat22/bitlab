package kz.bitlab.G115sprinttask61.service;

import java.util.List;
import kz.bitlab.G115sprinttask61.entity.Course;
import kz.bitlab.G115sprinttask61.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  @Autowired
  private CourseRepository courseRepository;

  public List<Course> getCourses() {
    return courseRepository.findAll();
  }
}
