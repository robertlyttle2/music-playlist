package com.robertlyttle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Album> myAlbums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Pink Floyd", "Dark Side of the Moon");
        album.addSong("Speak to Me", 1.05);
        album.addSong("Breathe (In the Air)", 2.49);
        album.addSong("Time", 6.53);
        album.addSong("The Great Gig in the Sky", 4.43);
        album.addSong("Money", 6.22);
        album.addSong("Us and Them", 7.49);
        album.addSong("Any Colour You Like", 3.26);
        album.addSong("Brain Damage", 3.46);
        album.addSong("Eclipse", 2.12);

        myAlbums.add(album);

        album = new Album("The Beatles", "Sgt. Pepper's Lonely Hearts Club Band");
        album.addSong("Sgt. Pepper's Lonely Hearts Club Band", 2.02);
        album.addSong("With a Little Help From My Friends", 2.44);
        album.addSong("Lucy in the Sky with Diamonds", 3.28);
        album.addSong("Getting Better", 2.48);
        album.addSong("Fixing a Hole", 2.36);
        album.addSong("She's Leaving Home", 3.35);
        album.addSong("Being for the Benefit of Mr. Kite!", 2.37);
        album.addSong("Within you Without You", 5.04);
        album.addSong("When I'm Sixty Four", 2.37);
        album.addSong("Lovely Rite", 2.42);
        album.addSong("Good Morning Good Morning", 2.41);
        album.addSong("Sgt. Pepper's Lonely Hearts Club Band Reprise", 1.19);
        album.addSong("A Day in the Life", 5.37);

        myAlbums.add(album);

        LinkedList<Song> myPlaylist = new LinkedList<>();

        myAlbums.get(0).addToPlaylist("Speak to Me", myPlaylist);
        myAlbums.get(0).addToPlaylist("Time", myPlaylist);
        myAlbums.get(0).addToPlaylist("Brain Damage", myPlaylist);
        myAlbums.get(0).addToPlaylist("Eclipse", myPlaylist);
        myAlbums.get(1).addToPlaylist("Lucy in the Sky with Diamonds", myPlaylist);
        myAlbums.get(1).addToPlaylist("When I'm Sixty Four", myPlaylist);
        myAlbums.get(1).addToPlaylist("A Day in the Life", myPlaylist);

        play(myPlaylist);

    }

    private static void printPlaylist(LinkedList<Song> playlist) {
        System.out.println("---------- PLAYLIST ------------");
        for (Song song : playlist) {
            System.out.println(song);
        }
        System.out.println("--------------------------------");
    }

    private static void play(LinkedList<Song> playlist) {
        ListIterator<Song> songListIterator = playlist.listIterator();

        boolean quit = false;
        boolean goingForward = true;

        if (playlist.isEmpty()) {
            System.out.println("No tracks in playlist");
        } else {
            System.out.println("Now playing: " + songListIterator.next());
            System.out.println("---------------------");
            printOptions();
        }

        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> {
                    printPlaylist(playlist);
                    printOptions();
                }
                case 1 -> {
                    if (!goingForward) {
                        if (songListIterator.hasNext()) {
                            songListIterator.next();
                        }
                        goingForward = true;
                    }
                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing: " + songListIterator.next());
                    } else {
                        System.out.println("You have reached the end of the playlist");
                        goingForward = false;
                    }
                }
                case 2 -> {
                    if (goingForward) {
                        if (songListIterator.hasPrevious()) {
                            songListIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (songListIterator.hasPrevious()) {
                        System.out.println("Now playing: " + songListIterator.previous());
                    } else {
                        System.out.println("You are at the start of the playlist");
                        goingForward = true;
                    }
                }
                case 3 -> {
                    if (goingForward) {
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing: " + songListIterator.previous());
                            goingForward = false;
                        } else {
                            System.out.println("You are at the start of the playlist");
                        }
                    } else {
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing: " + songListIterator.next());
                            goingForward = true;
                        } else {
                            System.out.println("You have reached the end of the playlist");
                        }
                    }
                }
                case 4 -> {
                    songListIterator.remove();
                    System.out.println("Track removed from playlist");
                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing: " + songListIterator.next());
                    } else if (songListIterator.hasPrevious()) {
                        System.out.println("Now playing: " + songListIterator.previous());
                    }
                }

                case 5 -> {
                    printAlbums();
                    printOptions();
                }


                case 6 -> quit = true;
            }
        }
    }

    private static void printOptions() {
        System.out.println("0 - View songs in playlist");
        System.out.println("1 - Next track");
        System.out.println("2 - Previous track");
        System.out.println("3 - Replay track");
        System.out.println("4 - Remove track from playlist");
        System.out.println("5 - View albums");
        System.out.println("6 - Quit");
    }

    private static void printAlbums() {
        System.out.println("---------- ALBUMS ------------");
        for (Album album : myAlbums) {
            System.out.println(album.getArtist() + " - " + album.getTitle());
        }
        System.out.println("------------------------------");
    }

}