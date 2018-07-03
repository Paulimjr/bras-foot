package br.com;

import br.com.entity.Player;
import br.com.entity.Team;
import br.com.repository.PlayerRepository;
import br.com.repository.TeamRepository;
import br.com.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BrasFootApplication implements CommandLineRunner {
	
	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;


    public static void main(String[] args) {
		SpringApplication.run(BrasFootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Team p1 = new Team(null, "Corinthians","https://dreamleaguesoccer.com.br/wp-content/uploads/2016/11/escudo-Corinthians.png",0);
		Team p2 = new Team(null, "Sao Paulo", "http://imagensemoldes.com.br/wp-content/uploads/2018/01/EMBLEMA-DO-S%C3%83O-PAULO-FUTEBOL-CLUBE-DE-S%C3%83O-PAULO-SP-EM-VETOR-JPG-PNG-EDIT%C3%81VEL-18-1.png",0);
		Team p3 = new Team(null, "Santos", "https://wikioso.org/wp-content/uploads/2013/04/escudo-do-santos.png",0);
		Team p4 = new Team(null, "Cruzeiro", "https://wikioso.org/wp-content/uploads/2013/04/escudo-do-santos.png",0);

		List<Team> teamList = new ArrayList<>();
		
		teamList.add(p1);
		teamList.add(p2);
		teamList.add(p3);
		teamList.add(p4);

		teamRepository.save(teamList);

        List<Player> listPlayers = new ArrayList<>();

		Player player1 = new Player(null, "Pedro Oliveira", 0,1, "", "N", Player.Posicao.ATACANTE);
		Player player2 = new Player(null, "Silveira Pedro", 0,1, "", "N" , Player.Posicao.ATACANTE);
		Player player3 = new Player(null, "Paulo Cesar", 0,1 ,"", "N", Player.Posicao.MEIA);
		Player player4 = new Player(null, "Joaquim", 0,1 ,"", "N", Player.Posicao.MEIA);
		Player player5 = new Player(null, "Neymar Junior", 0,1 ,"", "N", Player.Posicao.ATACANTE);
		Player jeferGoleiro = new Player(null, "Jeferson ", 0,4, "https://s.glbimg.com/es/sde/f/2018/05/17/79d40929e5229e61e98f574de745d4e5_140x140.png", "N", Player.Posicao.ATACANTE);
		Player reinaldoSp = new Player(null, "Reinaldo ", 0,4, "https://s.glbimg.com/es/sde/f/2018/05/26/de6f3a08fa69d30bfb5573c0aac02244_140x140.png", "N", Player.Posicao.ATACANTE);
		Player diegoSouza = new Player(null, "Diego Souza", 0,4, "https://s.glbimg.com/es/sde/f/2018/05/26/de6f3a08fa69d30bfb5573c0aac02244_140x140.png", "N", Player.Posicao.LATERAL);
		Player Jesus = new Player(null, "Gabriel Jesus", 0,4, "https://s.glbimg.com/es/sde/f/2018/05/26/de6f3a08fa69d30bfb5573c0aac02244_140x140.png", "S", Player.Posicao.LATERAL);
		Player Coutinho = new Player(null, "Felipe Coutinho", 0,4, "https://s.glbimg.com/es/sde/f/2018/05/26/de6f3a08fa69d30bfb5573c0aac02244_140x140.png", "N", Player.Posicao.ZAGUEIRO);
		Player Firmino = new Player(null, "Firmino", 0,4, "https://s.glbimg.com/es/sde/f/2018/05/26/de6f3a08fa69d30bfb5573c0aac02244_140x140.png", "S", Player.Posicao.ZAGUEIRO);

        listPlayers.add(player1);
        listPlayers.add(player2);
        listPlayers.add(player3);
        listPlayers.add(player4);
        listPlayers.add(player5);
        listPlayers.add(jeferGoleiro);
        listPlayers.add(reinaldoSp);
        listPlayers.add(diegoSouza);
        listPlayers.add(Jesus);
        listPlayers.add(Coutinho);
        listPlayers.add(Firmino);

		Player player6 = new Player(null, "Pedro Oliveira", 0,2 ,"", "N", Player.Posicao.ATACANTE);
		Player player7 = new Player(null, "Silveira Pedro", 0,2 ,"", "N", Player.Posicao.MEIA);
		Player player8 = new Player(null, "Paulo Cesar", 0,2 ,"", "N", Player.Posicao.LATERAL);
		Player player9 = new Player(null, "Joaquim ", 0,2 ,"", "N", Player.Posicao.ATACANTE);
		Player player10 = new Player(null, "Neymar Junior", 0,2 ,"", "N", Player.Posicao.MEIA);


        listPlayers.add(player6);
        listPlayers.add(player7);
        listPlayers.add(player8);
        listPlayers.add(player9);
        listPlayers.add(player10);

        for (Player player : listPlayers) {
            playerService.insert(player);
        }
	}
}
