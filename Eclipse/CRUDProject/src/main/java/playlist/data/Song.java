package playlist.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String songName;
	private String artist;
	private Double duration;

	public Song(int id, String songName, String artist, Double duration) {
		super();
		this.id = id;
		this.songName = songName;
		this.artist = artist;
		this.duration = duration;
	}

	public Song(String songName, String artist, Double duration) {
		super();
		this.songName = songName;
		this.artist = artist;
		this.duration = duration;
	}

	public Song() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(artist, duration, id, songName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(artist, other.artist) && Objects.equals(duration, other.duration) && id == other.id
				&& Objects.equals(songName, other.songName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", artist=" + artist + ", duration=" + duration + "]";
	}

}
