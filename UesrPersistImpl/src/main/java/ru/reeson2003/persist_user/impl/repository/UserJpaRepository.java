package ru.reeson2003.persist_user.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.reeson2003.persist_user.impl.entity.PersistedUser;

/**
 * Date: 27.08.2017.
 * Time: 21:28.
 *
 * @author Pavel Gavrilov.
 */
@Repository
public interface UserJpaRepository extends JpaRepository<PersistedUser, Long> {
    PersistedUser findByLogin(String login);
}
