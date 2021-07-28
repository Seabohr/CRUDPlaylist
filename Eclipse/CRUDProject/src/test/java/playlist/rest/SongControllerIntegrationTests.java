package playlist.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import playlist.data.Song;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:Song-schema.sql",
		"classpath:Song-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SongControllerIntegrationTests {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testAddSong() throws Exception {
		Song testNewSong = new Song("Smugglers Blues", "Cypress Hill", 4.21);
		String testNewSongJSON = this.mapper.writeValueAsString(testNewSong);

		RequestBuilder request = post("/addSong").contentType(MediaType.APPLICATION_JSON).content(testNewSongJSON);

		ResultMatcher checkStatus = status().is(201);

		Song testAddedSong = new Song("Smugglers Blues", "Cypress Hill", 4.21);
		testAddedSong.setId(3);
		String testAddedSongJSON = this.mapper.writeValueAsString(testAddedSong);

		ResultMatcher checkBody = content().json(testAddedSongJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAllSongs() throws Exception {
		RequestBuilder request = get("/getAllSongs");

		ResultMatcher checkStatus = status().is(200);

		List<Song> testList = new ArrayList<>();
		Song testSong = new Song("Bassline Junkie", "Dizzee Rascal", 3.25);
		Song test2Song = new Song("The Crew", "FDEL", 4.31);
		testSong.setId(1);
		test2Song.setId(2);
		testList.add(testSong);
		testList.add(test2Song);
		String testSongJSON = this.mapper.writeValueAsString(testList);

		ResultMatcher checkBody = content().json(testSongJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetSongById() throws Exception {
		RequestBuilder request = get("/getSong/1");

		ResultMatcher checkStatus = status().is(200);

		Song testSong = new Song("Bassline Junkie", "Dizzee Rascal", 3.25);
		testSong.setId(1);
		String testSongJSON = this.mapper.writeValueAsString(testSong);

		ResultMatcher checkBody = content().json(testSongJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetByArtist() throws Exception {
		RequestBuilder request = get("/getArtist/Dizzee Rascal");

		ResultMatcher checkStatus = status().is(200);

		List<Song> testList = new ArrayList<>();
		Song testSong = new Song("Bassline Junkie", "Dizzee Rascal", 3.25);
		testSong.setId(1);
		testList.add(testSong);
		String testListJSON = this.mapper.writeValueAsString(testList);

		ResultMatcher checkBody = content().json(testListJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testReplaceSong() throws Exception {
		Song testSong = new Song("Riding The Void", "S.P.Y", 5.58);
		String testSongJSON = this.mapper.writeValueAsString(testSong);

		RequestBuilder request = put("/updateSong/1").contentType(MediaType.APPLICATION_JSON).content(testSongJSON);

		ResultMatcher checkStatus = status().is(202);

		Song test2Song = new Song("Riding The Void", "S.P.Y", 5.58);
		test2Song.setId(1);
		String test2SongJSON = this.mapper.writeValueAsString(test2Song);

		ResultMatcher checkBody = content().json(test2SongJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDeleteSong() throws Exception {
		RequestBuilder request = delete("/deleteSong/1");

		ResultMatcher checkStatus = status().is(202);
		ResultMatcher checkBody = content().string("Deleted: 1");

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

}
