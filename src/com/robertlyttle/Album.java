package com.robertlyttle;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String artist;
    private String title;
    private ArrayList<Song> songs;

    public Album(String artist, String title) {
        this.artist = artist;
        this.title = title;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public Song findSong(String title) {
        for (Song song : this.songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song trackToAdd = findSong(title);
        if (trackToAdd != null) {
            playlist.add(trackToAdd);
            return true;
        }
        System.out.println("Track: " + title + " does not exist in this album");
        return false;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return this.artist + " - " + this.title;
    }
}
