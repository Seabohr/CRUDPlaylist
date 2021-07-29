package playlist.services;

import java.util.List;

import playlist.data.Song;

public interface SongService {

	public Song addSong(Song s);

	public List<Song> getAllSongs();

	public Song getSongById(int i);

	public List<Song> getByArtist(String artist);

	public Song replaceSong(int i, Song s);

	public String deleteSong(int i);

}
