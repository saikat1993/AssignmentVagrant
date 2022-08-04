/*
Module Name : ScenarioValidations
Date of creation: 04-08-2022
Name of creator of module: Saikat Bhattacharjee
History of modification: First creation
Summary of what the module does: This module contains a before class method which deserialize into of team class 
	and stores it in a suite variable so that other test methods can access 
Functions in the module: getDataObject ,validateIfTeamHasOnlyFourForeignPlayers,validateTeamHasAtleastOneWicketKeeper
Variables accessed by the module: 
	input-json-path -> Coming from testng.xml


*/

package testClasses;
import java.io.File;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import objectClasses.Team;
import objectClasses.Player;


public class TestScenarioValidations {

	// Deserializes team object and stores the object in a suite level variable so that other test method can access
	@BeforeClass
	@Parameters({ "input-json-path" })
	public void getDataObject(String data_path, ITestContext context) {
//		String data_path="resource/TeamRCB.json";
		ObjectMapper objectMapper = new ObjectMapper();
		Team team = new Team();
		try {
			team = objectMapper.readValue(new File(data_path), Team.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ISuite suite = context.getSuite();
		suite.setAttribute("Team", team);
	}

	@Test(testName = "Write a test that validates that there are not more that 4 foreign players in the team")
	public void validateIfTeamHasOnlyFourForeignPlayers(ITestContext context) {
		// Fetch Team object
		Team team = (Team) context.getSuite().getAttribute("Team");

		// Fetching the number of foreign players by parsing team object
		int foreign_player_count = 0;
		for (Player a_player : team.getPlayer()) {
			foreign_player_count = (a_player.getCountry().equalsIgnoreCase("India") == false)
					? foreign_player_count = foreign_player_count + 1
					: foreign_player_count;
		}

		// Validating that there are not more than 4 foreign players in the team
		Assert.assertTrue(foreign_player_count < 5, "Failed since team contains more than 4 foreign players");
	}

	@Test(testName = "Write a test that validates that there is atleast one wicket keeper")
	public void validateTeamHasAtleastOneWiketKeeper(ITestContext context) {

		// Fetch Team object
		Team team = (Team) context.getSuite().getAttribute("Team");

		// Fetching the number of wicket keepers by parsing team object
		int WK_count = 0;
		for (Player a_player : team.getPlayer()) {
			WK_count = (a_player.getRole().equalsIgnoreCase("Wicket-keeper") == false) ? WK_count = WK_count + 1
					: WK_count;
		}

		// Validating that there are atleast one wicket keeper in the team
		Assert.assertTrue(WK_count > 1, "Failed since team has no wicket keeper");
	}
}
