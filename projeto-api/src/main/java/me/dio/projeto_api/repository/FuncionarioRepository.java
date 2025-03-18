package me.dio.projeto_api.repository;

import com.exemplo.lanchonete.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
