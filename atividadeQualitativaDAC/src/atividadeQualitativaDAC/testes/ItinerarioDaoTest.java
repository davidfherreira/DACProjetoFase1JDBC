package atividadeQualitativaDAC.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atividadeQualitativaDAC.entidates.Itinerario;

public class ItinerarioDaoTest {

    private ItinerarioDao itinerarioDao;

    @Before
    public void setUp() {
        itinerarioDao = new ItinerarioDao();
    }

    @After
    public void tearDown() {
        itinerarioDao = null;
    }

    @Test
    public void testInsereItinerario() {
        Itinerario itinerario = new Itinerario();
        itinerario.setId(1);
        itinerario.setId_aviao(1);
        itinerario.setOrigem("São Paulo");
        itinerario.setDestino("Rio de Janeiro");
        itinerario.setDataVoo("2024-04-01");

        itinerarioDao.insereItinerario(itinerario);

        Itinerario itinerarioRecuperado = itinerarioDao.byId(1);
        assertNotNull(itinerarioRecuperado);
        assertEquals("São Paulo", itinerarioRecuperado.getOrigem());
    }

    @Test
    public void testAtualizarItinerario() {
        Itinerario itinerario = new Itinerario();
        itinerario.setId(2);
        itinerario.setId_aviao(1);
        itinerario.setOrigem("São Paulo");
        itinerario.setDestino("Rio de Janeiro");
        itinerario.setDataVoo("2024-04-01");

        itinerarioDao.insereItinerario(itinerario);

        itinerario.setDestino("Belo Horizonte");
        itinerarioDao.atualizarItinerario(itinerario);

        Itinerario itinerarioAtualizado = itinerarioDao.byId(2);
        assertNotNull(itinerarioAtualizado);
        assertEquals("Belo Horizonte", itinerarioAtualizado.getDestino());
    }

    @Test
    public void testRemoverItinerario() {
        Itinerario itinerario = new Itinerario();
        itinerario.setId(3);
        itinerario.setId_aviao(1);
        itinerario.setOrigem("São Paulo");
        itinerario.setDestino("Rio de Janeiro");
        itinerario.setDataVoo("2024-04-01");

        itinerarioDao.insereItinerario(itinerario);

        itinerarioDao.removerItinerario(3);

        Itinerario itinerarioRemovido = itinerarioDao.byId(3);
        assertNull(itinerarioRemovido);
    }
}
