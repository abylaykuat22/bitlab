package kz.bitlab.g128springrestapi.mapper;

import kz.bitlab.g128springrestapi.dtos.StudentCreate;
import kz.bitlab.g128springrestapi.dtos.StudentEdit;
import kz.bitlab.g128springrestapi.dtos.StudentView;
import kz.bitlab.g128springrestapi.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    List<StudentView> toDtoList(List<Student> entities);

    @Mapping(target = "fullName", source = "name")
    StudentView toDto(Student entity);

    Student toEntity(StudentCreate dto);
    Student toEntity(StudentEdit dto);
}
