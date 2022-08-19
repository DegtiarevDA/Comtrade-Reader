package mpei.ru.back.repository;

import mpei.ru.back.model.entity.Fault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Degtiarev Dmitry on 19.08.2022
 * @project Comtrade_reader
 */
@Repository
public interface FaultRepository extends JpaRepository<Fault, Long> {
}
