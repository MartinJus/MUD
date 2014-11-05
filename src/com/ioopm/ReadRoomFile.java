package com.ioopm;
import java.io.*;
//import java.io.IOException;
import java.lang.System;
import java.util.*;

public class ReadRoomFile{
    private Scanner rooms;
    // Lade till world variabel här ute så vi kommer åt den utifrån.
    public Room[] world;
    public void openFile(){
        try{
            rooms = new Scanner(new File("rooms.txt"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found! check rooms.txt");
        }
    }
    public Room[] readFile() {
        /**
         *  Creating an array which is filled with room-objects
         */
        world = new Room[19];
        /**
         *  Separates the segments at "; " instead of just a blankspace
         */
        rooms.useDelimiter("; ");
        /**
         * variable to increase index of world (the array the rooms are written to)
         */
        int x = 0;
        while (rooms.hasNext()) {
            /**
             * Puts the info from the different segments in a line from rooms.txt
             * to variables
             */
            String roomName = rooms.next();
            String northConnection = rooms.next();
            String eastConnection = rooms.next();
            String southConnection = rooms.next();
            String westConnection = rooms.next();
            String northLock = rooms.next();
            String eastLock = rooms.next();
            String southLock = rooms.next();
            String westLock = rooms.nextLine(); // Fråga ass!!
            westLock = westLock.substring(2, westLock.length());

            /**
             * Creating an array to which the rooms are written
             */
            world[x] = new Room(roomName, northConnection, eastConnection, southConnection, westConnection
                    , northLock, eastLock, southLock, westLock);
            x += 1;
        }
        return world;
    }
    public void closeFile(){
    rooms.close();
    }

    /**
     * this method creates the world in which the game is set
     */
    public void makeWorld(){
        openFile();
        this.world = readFile();
        closeFile();
    }

    private Scanner creatureScanner;
    // Lade till world variabel här ute så vi kommer åt den utifrån.
    public Creature[] creatures;
    public void openCreatureFile(){
        try{
            creatureScanner = new Scanner(new File("creatures.txt"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found! check creatures.txt");
        }
    }
    public Creature[] readCreatureFile() {
        /**
         *  Creating an array which is filled with creature-objects
         */
        creatures = new Creature[1];
        /**
         *  Separates the segments at "; " instead of just a blankspace
         */
        creatureScanner.useDelimiter(";");
        /**
         * variable to increase index of world (the array the rooms are written to)
         */
        int x = 0;
        while (creatureScanner.hasNext()) {
            /**
             * Puts the info from the different segments in a line from rooms.txt
             * to variables
             */
            String name = creatureScanner.next();
            if (creatureScanner.next().equals("Teacher")){
                /*creatures[x] = new Teacher(name);*/
            }else if (creatureScanner.next().equals("Student")){
                /*creatures[x] = new Student(name);*/
            }
            x += 1;
        }
        return creatures;
    }
    public void closeCreatureFile(){
        creatureScanner.close();
    }
    public void makeCreatures(){
        openCreatureFile();
        this.creatures = readCreatureFile();
        closeCreatureFile();
    }


}