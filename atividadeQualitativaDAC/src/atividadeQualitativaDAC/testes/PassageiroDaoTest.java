package atividadeQualitativaDAC.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atividadeQualitativaDAC.entidates.Passageiro;

public class PassageiroDaoTest {

    private PassageiroDao passageiroDao;

    @Before
    public void setUp() {
        passageiroDao = new PassageiroDao();
    }

    @After
    public void tearDown() {
        passageiroDao = null;
    }

    @Test
    public void testInserePassageiro() {
        Passageiro passageiro = new Passageiro();
        passageiro.setId(1);
        passageiro.setNome("Maria");
        passageiro.setId_itinerario(1);

        passageiroDao.inserePassageiro(passageiro);

        Passageiro passageiroRecuperado = passageiroDao.byId(1);
        assertNotNull(passageiroRecuperado);
        assertEquals("Maria", passageiroRecuperado.getNome());
    }

    @Test
    public void testAtualizarPassageiro() {
        Passageiro passageiro = new Passageiro();
        passageiro.setId(2);
        passageiro.setNome("José");
        passageiro.setId_itinerario(1);

        passageiroDao.inserePassageiro(passageiro);

        passageiro.setNome("João");
        passageiroDao.atualizarPassageiro(passageiro);

        Passageiro passageiroAtualizado = passageiroDao.byId(2);
        assertNotNull(passageiroAtualizado);
        assertEquals("João", passageiroAtualizado.getNome());
    }

    @Test
    public void testRemoverPassageiro() {
        Passageiro passageiro = new Passageiro();
        passageiro.setId(3);
        passageiro.setNome("Ana");
        passageiro.setId_itinerario(1);

        passageiroDao.inserePassageiro(passageiro);

        passageiroDao.removerPassageiro(3);

        Passageiro passageiroRemovido = passageiroDao.byId(3);
        assertNull(passageiroRemovido)
    }
}
