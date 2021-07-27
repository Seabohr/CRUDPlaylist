package playlist.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import playlist.data.Song;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {

	List<Song> findByArtist(String artist);

}
