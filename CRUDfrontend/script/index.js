'use strict';

const baseURL = "http://localhost:8081";

axios.get(`${baseURL}/`)
.then(res => {
    console.log(res);
    console.log("data: ", res.data);
}).catch(err => console.log(err));

const playlistdiv = document.querySelector("#playlist")

const renderSongs = (song, location) => {
    const nextSong = document.createElement('div');
    nextSong.innerText = `Song: ${song.songName}, Artist: ${song.artist}, Duration: ${song.duration} `;
    const deleteButton = document.createElement('button');
    deleteButton.innerText = "Delete";
    deleteButton.addEventListener('click', () => deleteSong(song.id));
    nextSong.appendChild(deleteButton);
    location.appendChild(nextSong);
}

const getAll = () => {
    axios.get(`${baseURL}/getAllSongs`)
    .then(res => {
        const music = res.data;
        playlistdiv.innerHTML = "";
        music.forEach(song => renderSongs(song, playlistdiv));
    }).catch(err => console.log(err));
}

getAll();

document.querySelector("form#addSongForm").addEventListener('submit', function(e) {
    e.preventDefault();
    console.log("Add: ", this);

    const data = {
        songName: this.songName.value,
        artist: this.artist.value,
        duration: this.duration.value
    }
    console.log("Data: ", data);

    axios.post(`${baseURL}/addSong`, data)
    .then(res => {
        console.log(res);
        getAll();
        this.reset();
        this.songName.focus();
    }).catch(err => console.log(err));
})