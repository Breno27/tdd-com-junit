package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        System.out.println("inicio");
        service = new ReajusteService();
        funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void finalizar() {
        System.out.println("fim");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("antes de todos");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("depois de todos");
    }

    @Test
    public void reajusteDeverisSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        service.concederRajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeverisSerDeQuizePorCentoQuandoDesempenhoForBom() {
        service.concederRajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeverisSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        service.concederRajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
