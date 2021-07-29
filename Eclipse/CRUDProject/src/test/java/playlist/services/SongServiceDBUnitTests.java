package playlist.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import playlist.data.Song;
import playlist.data.repo.SongRepo;

@SpringBootTest
@ActiveProfiles("test")
public class SongServiceDBUnitTests {

	@Autowired
	private SongServiceDB service;

	@MockBean
	private SongRepo repo;

	@Test
	void testAddSong() {
		int id = 1;
		Song testNewSong = new Song(id, "Poison Lips", "Flashmob", 3.54);

		Mockito.when(this.repo.save(new Song(id, "Poison Lips", "Flashmob", 3.54))).thenReturn(testNewSong);
		Song actual = this.service.addSong(testNewSong);

		assertThat(actual).isEqualTo(testNewSong);

		Mockito.verify(this.repo, Mockito.times(1)).save(new Song(id, "Poison Lips", "Flashmob", 3.54));
	}

	@Test
	void testGetAllSongs() {
		int id = 1;
		Song testSong = new Song(id, "Poison Lips", "Flashmob", 3.54);
		List<Song> testSongList = new ArrayList<>();
		testSongList.add(testSong);

		Mockito.when(this.repo.findAll()).thenReturn(testSongList);
		List<Song> actual = this.service.getAllSongs();

		assertThat(actual).isEqualTo(testSongList);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testGetSongById() {
		int id = 1;
		Song testSong = new Song(id, "Poison Lips", "Flashmob", 3.54);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testSong));
		Song actual = this.service.getSongById(id);

		assertThat(actual).isEqualTo(testSong);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	void testGetByArtist() {
		int id = 1;
		Song testSong = new Song(id, "Poison Lips", "Flashmob", 3.54);
		List<Song> testSongList = new ArrayList<>();
		testSongList.add(testSong);

		Mockito.when(this.repo.findByArtist("Flashmob")).thenReturn(testSongList);
		List<Song> actual = this.service.getByArtist("Flashmob");

		assertThat(actual).isEqualTo(testSongList);

		Mockito.verify(this.repo, Mockito.times(1)).findByArtist("Flashmob");

	}

	@Test
	void testReplaceSong() {
		int id = 1;
		Song testSong = new Song(id, "Poison Lips", "Flashmob", 3.54);
		Song testNewSong = new Song(id, "Long Live the Chief", "Jidenna", 2.40);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testSong));
		Mockito.when(this.repo.save(new Song(id, "Long Live the Chief", "Jidenna", 2.40))).thenReturn(testNewSong);
		Song actual = this.service.replaceSong(id, testNewSong);

		assertThat(actual).isEqualTo(testNewSong);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(new Song(id, "Long Live the Chief", "Jidenna", 2.40));
	}

	@Test
	void testDeleteSong() {
		int id = 1;

		assertThat(this.service.deleteSong(id)).isEqualTo("Deleted: " + id);

	}

}
