package atividadeQualitativaDAC.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atividadeQualitativaDAC.entidates.Aviao;

public class AviaoDaoTest {

    private AviaoDao aviaoDao;

    @Before
    public void setUp() {
        aviaoDao = new AviaoDao();
    }

    @After
    public void tearDown() {
        aviaoDao = null;
    }

    @Test
    public void testInsereAviao() {
        Aviao aviao = new Aviao();
        aviao.setId(1);
        aviao.setModelo("Boeing 747");

        aviaoDao.insereAviao(aviao);

        Aviao aviaoRecuperado = aviaoDao.byId(1);
        assertNotNull(aviaoRecuperado);
        assertEquals("Boeing 747", aviaoRecuperado.getModelo());
    }

    @Test
    public void testAtualizarAviao() {
        Aviao aviao = new Aviao();
        aviao.setId(2);
        aviao.setModelo("Airbus A380");

        aviaoDao.insereAviao(aviao);

        aviao.setModelo("Boeing 777");
        aviaoDao.atualizarAviao(aviao);

        Aviao aviaoAtualizado = aviaoDao.byId(2);
        assertNotNull(aviaoAtualizado);
        assertEquals("Boeing 777", aviaoAtualizado.getModelo());
    }

    @Test
    public void testRemoverAviao() {
        Aviao aviao = new Aviao();
        aviao.setId(3);
        aviao.setModelo("Embraer E195");

        aviaoDao.insereAviao(aviao);

        aviaoDao.removerAviao(3);

        Aviao aviaoRemovido = aviaoDao.byId(3);
        assertNull(aviaoRemovido);
    }
}
