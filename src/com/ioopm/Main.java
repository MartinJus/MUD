package com.ioopm;
import java.util.Scanner;

class Main
{
    public static ReadRoomFile creator;

    /**
     * method to find index of a specific string in an array
     * @param string name of the room
     * @param array name of array variable
     * @return index of string in array
     */
    public static int findIndex(String string, String[] array){
        for (int i = 0; i <= 18; i++){
            if (array[i].equals(string)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param name
     */
    public static void move(Avatar name){
        System.out.println("Choose direction:");
        Scanner option = new Scanner(System.in);
        String choice = option.nextLine();
        Room location = name.getCurrentLocation();
        if (choice.equals("North")||choice.equals("East")||choice.equals("South")||choice.equals("West")){
            if (location.validateConnection(choice)) {
                if (location.isOpen(choice)){
                    name.setCurrentLocation(location.getRoomNameInDirection(choice));

                }else{
                    System.out.println("Door is locked,l00k 4 k3y, bb!!");
                }
            }else{
                System.out.println("There is no door in that direction!");
                move(name);
            }
        }else{
            System.out.println("Chosen direction is not valid! Valid directions are: North, East, South, West.");
            move(name);
        }
    }

    public static void playGame(Avatar name){
        boolean gameOn = true;
        while(gameOn) {
            name.printCurrentLocation();
            move(name);
            System.out.println("Continue your adventure? (Yes/No)");
            Scanner answerToTheUltimateQuestion = new Scanner(System.in);
            String answer = answerToTheUltimateQuestion.nextLine();
            if (answer.equals("No")||answer.equals("no")||answer.equals("NO")){
                gameOn = false;
            }
        }
    }

    public static void main(String args[]){
    System.out.println("Enter player name: ");
	Scanner name = new Scanner(System.in);
	String namn1 = name.nextLine();
    Avatar Erik = new Avatar(namn1);
	System.out.printf("Hi, %s! Welcome to P0ll4x!!\n", Erik.getName());
	Erik.addFinishedCourse("Bokvetenskap 101");
	Erik.addFinishedCourse("Datakomm. 301");
	Erik.printList();
    // För att testa om ReadRoomFile lyckas göra sitt.
    creator = new ReadRoomFile();
    creator.makeWorld();
    Erik.setCurrentLocation("FooBar");
    /*creator.world[0].roomInfo();
    creator.world[1].roomInfo();
    Erik.setCurrentLocation("Hallway 4");
    Erik.printCurrentLocation();
    Erik.setCurrentLocation("Room 1357");
    Erik.printCurrentLocation();*/
    playGame(Erik);
    }
}
