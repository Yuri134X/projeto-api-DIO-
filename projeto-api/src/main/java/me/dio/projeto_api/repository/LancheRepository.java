package me.dio.projeto_api.repository;

import com.exemplo.lanchonete.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancheRepository extends JpaRepository<Lanche, Long> {
}
