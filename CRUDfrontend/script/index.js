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
    nextSong.innerText = `Song: ${song.songName}, Artist: ${song.artist}, Duration: ${song.duration}`;
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