package br.com;

import br.com.entity.Player;
import br.com.entity.Team;
import br.com.repository.PlayerRepository;
import br.com.repository.TeamRepository;
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


	public static void main(String[] args) {
		SpringApplication.run(BrasFootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Team p1 = new Team(null, "Corinthians","https://dreamleaguesoccer.com.br/wp-content/uploads/2016/11/escudo-Corinthians.png",0);
		Team p2 = new Team(null, "Sao Paulo", "http://imagensemoldes.com.br/wp-content/uploads/2018/01/EMBLEMA-DO-S%C3%83O-PAULO-FUTEBOL-CLUBE-DE-S%C3%83O-PAULO-SP-EM-VETOR-JPG-PNG-EDIT%C3%81VEL-18-1.png",0);
		Team p3 = new Team(null, "Santos", "https://wikioso.org/wp-content/uploads/2013/04/escudo-do-santos.png",0);

		List<Team> teamList = new ArrayList<>();
		
		teamList.add(p1);
		teamList.add(p2);
		teamList.add(p3);

		teamRepository.save(teamList);

		Player player1 = new Player(null, "Pedro Oliveira", 0,1);
		Player player2 = new Player(null, "Silveira Pedro", 0,1);
		Player player3 = new Player(null, "Paulo Cesar", 0,1);
		Player player4 = new Player(null, "Joaquim ", 0,1);
		Player player5 = new Player(null, "Neymar Junior", 0,1);

		playerRepository.save(Arrays.asList(player1, player2, player3, player4, player5));


		Player player6 = new Player(null, "Pedro Oliveira", 0,2);
		Player player7 = new Player(null, "Silveira Pedro", 0,2);
		Player player8 = new Player(null, "Paulo Cesar", 0,2);
		Player player9 = new Player(null, "Joaquim ", 0,2);
		Player player10 = new Player(null, "Neymar Junior", 0,2);


		playerRepository.save(Arrays.asList(player6, player7, player8, player9, player10));

	}
}
