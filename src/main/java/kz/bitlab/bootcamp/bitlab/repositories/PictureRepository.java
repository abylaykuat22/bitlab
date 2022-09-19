package kz.bitlab.bootcamp.bitlab.repositories;

import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findAllByRolePicture(String rolePicture);
}
