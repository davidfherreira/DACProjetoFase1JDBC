package atividadeQualitativaDAC.main;

import atividadeQualitativaDAC.dao.AviaoDao;
import atividadeQualitativaDAC.dao.ItinerarioDao;
import atividadeQualitativaDAC.dao.PassageiroDao;
import atividadeQualitativaDAC.entidates.Aviao;
import atividadeQualitativaDAC.entidates.Itinerario;
import atividadeQualitativaDAC.entidates.Passageiro;

public class Main {

    public static void main(String[] args) {
        // Teste CRUD para Aviao
        AviaoDao aviaoDao = new AviaoDao();
        
        // Inserir Aviao
        Aviao novoAviao = new Aviao();
        novoAviao.setId(1);
        novoAviao.setModelo("Boeing 747");
        aviaoDao.insereAviao(novoAviao);
        System.out.println("Avião Cadastrado");
        
        // Buscar Aviao por ID
        Aviao aviaoEncontrado = aviaoDao.byId(1);
        System.out.println("Avião encontrado: " + aviaoEncontrado.getModelo());
        
        // Atualizar Aviao
        aviaoEncontrado.setModelo("Airbus A380");
        aviaoDao.atualizarAviao(aviaoEncontrado);
        
        // Verificando se o Aviao foi atualizado
        aviaoEncontrado = aviaoDao.byId(1);
        System.out.println("Avião Atualizado: " + aviaoEncontrado.getModelo());
        
        
        // Remover Aviao
        //aviaoDao.removerAviao(1);
        
     // Teste CRUD para Itinerario
        ItinerarioDao itinerarioDao = new ItinerarioDao();
        
        // Inserir Itinerario
        Itinerario novoItinerario = new Itinerario();
        novoItinerario.setId(1);
        novoItinerario.setId_aviao(1);
        novoItinerario.setOrigem("São Paulo");
        novoItinerario.setDestino("Rio de Janeiro");
        novoItinerario.setDataVoo("2024-03-20");
        itinerarioDao.insereItinerario(novoItinerario);
        System.out.println("Itinerario Cadastrado");
        
        // Buscar Itinerario por ID
        Itinerario itinerarioEncontrado = itinerarioDao.byId(1);
        System.out.println("Itinerário encontrado: " + itinerarioEncontrado.getOrigem() + " para " + itinerarioEncontrado.getDestino());
        
        // Atualizar Itinerario
        itinerarioEncontrado.setOrigem("Paraiba");
        itinerarioEncontrado.setDestino("Minas Gerais");
        itinerarioDao.atualizarItinerario(itinerarioEncontrado);
        
        // Verificando se o Itinerario foi atualizado
        itinerarioEncontrado = itinerarioDao.byId(1);
        System.out.println("Itinerário Atualizado: " + itinerarioEncontrado.getOrigem() + " para " + itinerarioEncontrado.getDestino());
        
        
        // Remover Itinerario
        //itinerarioDao.removerItinerario(1);
        
        // Teste CRUD para Passageiro
        PassageiroDao passageiroDao = new PassageiroDao();
        
        // Inserir Passageiro
        Passageiro novoPassageiro = new Passageiro();
        novoPassageiro.setId(1);
        novoPassageiro.setNome("João");
        novoPassageiro.setId_itinerario(1);
        passageiroDao.inserePassageiro(novoPassageiro);
        System.out.println("Passageiro Cadastrado");
        
        // Buscar Passageiro por ID
        Passageiro passageiroEncontrado = passageiroDao.byId(1);
        System.out.println("Passageiro encontrado: " + passageiroEncontrado.getNome());
        
        // Atualizar Passageiro
        passageiroEncontrado.setNome("Pedro");
        passageiroDao.atualizarPassageiro(passageiroEncontrado);
        
        // Verificando se Passageiro foi atualizado
        passageiroEncontrado = passageiroDao.byId(1);
        System.out.println("Passageiro Atualizado: " + passageiroEncontrado.getNome());
        
        ///Limpando Banco
     // Remover Passageiro, Aviao e Itinerario
        
        PassageiroDao passageiroD = new PassageiroDao();
        ItinerarioDao itinerarioD = new ItinerarioDao();
        AviaoDao aviaoD = new AviaoDao();

        passageiroD.removerPassageiro(1);
        itinerarioD.removerItinerario(1);
        aviaoD.removerAviao(1);

    }
    
    
}

