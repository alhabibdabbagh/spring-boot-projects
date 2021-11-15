package project7.security7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import project7.security7.entity.WalletServiceTranscationLogger;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TranscationLoggerRepository extends PagingAndSortingRepository<WalletServiceTranscationLogger, Long> {
    @Query("SELECT w FROM WalletServiceTranscationLogger w where w.transcatiınDataTime=?1")
    Page<List<WalletServiceTranscationLogger>> findTreanscationAboutDate(LocalDate dataTranscationResult, Pageable pageable);
}
