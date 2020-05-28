/**
   Created by briankallay on 5/8/20.
 */
import java.util.*;
public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.println("How many players will be playing?");
        int numberOfPlayers = input.nextInt();
        input.nextLine();

        //PLAYER INFO GATHERING
        for (int i = 1; i <= numberOfPlayers; i++) {
            Player p = new Player();

            //ask for the players name, set on the player object
            //use input.nextLine() to read a string
            System.out.println("Enter a name for player " + i + ":");
            String name = input.nextLine();
            p.setName(name);
            //add player to the list of players
            players.add(p);
        }

        //TODO: ASSIGN CARDS TO GAME
        Character doppelganger = new Character("Doppelganger");
        Character werewolf = new Character ("Werewolf");
        Character werewolf2 = new Character ("Werewolf");
        Character minion = new Character ("Minion");
        Character mason = new Character ("Mason");
        Character mason2 = new Character ("Mason");
        Character seer = new Character ("Seer");
        Character robber = new Character ("Robber");
        Character troublemaker = new Character ("Troublemaker");
        Character drunk = new Character ("Drunk");
        Character insomniac = new Character("Insomniac");
        Character villager = new Character ("Villager");
        Character villager2 = new Character ("Villager");
        Character villager3 = new Character ("Villager");
        Character[] charRoles = {doppelganger, werewolf, werewolf2, minion, mason, mason2, seer, robber, troublemaker, drunk, insomniac, villager, villager2, villager3};
        Character[] activeRoles = new Character[numberOfPlayers + 3];
        for (int r = 0; r < numberOfPlayers + 3; r++) {
            System.out.println("Choose role:");
            System.out.println("Doppelganger=0, Werewolf=1, Werewolf=2, Robber=3, Minion=4, Mason=5, Mason=6, Seer=7, Insomniac=8, Drunk=9, Villager1=10, Villager2=11");
            int charIndex = input.nextInt();
            activeRoles[r] = charRoles[charIndex];
        }
        System.out.println("chosenCharacters");
        for (Character S : activeRoles) {
            System.out.println(S.getName());
        }
        {

            Random rand = new Random();
            for (Player P: players){
                boolean didSet = false;
                do {
                    int choose = rand.nextInt(activeRoles.length);
                    Character C = activeRoles[choose];
                    if (!C.isAssigned())
                    {
                        didSet = true;
                        C.setAssigned(true);
                        P.setCharacter(activeRoles[choose]);
                        if (C.getName().equals("Doppelganger")){
                            P.setDoppelganger(true);
                        }
                    }
                } while(!didSet);


                System.out.println("Player "+P.getName()+" has role "+P.getCharacter().getName());
            }
            Character[] centerCards = new Character[3];
            int index = 0;
            for (Character C: activeRoles){
                if (!C.isAssigned()){
                    centerCards[index] = C;
                    index++;
                    System.out.println(C.getName());
                }
            }
            //TODO: IF someone is Doppelganger have role start
            for (Player D: players){
                if (D.isDoppelganger()){

                    System.out.println("Player "+D.getName()+" is the Doppelganger");
                    initializedDoppelganger(D, players, input);
                }

            }
            nightTurns(charRoles, players, input);
        }
    }
    public static void initializedDoppelganger(Player doppelganger, ArrayList<Player> players, Scanner input){
        //TODO:
        int index = 0;
        System.out.println("Choose the player who's card you want to look at");
        for (Player D: players) {
            if (doppelganger != D) {
                System.out.println("Player "+D.getName()+" = " + index);

            }
            index++;
        }
        int charIndex = input.nextInt();
        Player selected = players.get(charIndex);
        doppelganger.setCharacter(selected.getCharacter());
        System.out.println("You are now the "+doppelganger.getCharacter().getName());
    }
    public static void nightTurns(Character characters[], ArrayList<Player> players, Scanner input){
        boolean didWerewolves = false;
        boolean didMinions = false;
        boolean didMasons = false;
        for (Character C: characters) {
            ArrayList<Player> werewolves = new ArrayList<>();
            ArrayList<Player> minions = new ArrayList<>();
            ArrayList<Player> masons = new ArrayList<>();
            for (Player P : players) {
                if (P.getCharacter() == C) {
                    System.out.println("Found " + P.getName() + " for " + C.getName());
                    if (C.getName().equals("Werewolf")) {
                        werewolves.add(P);
                    } else if (C.getName().equals("Minion")) {
                        minions.add(P);
                    } else if (C.getName().equals("Mason")) {
                        masons.add(P);
                    } else if (C.getName().equals("Seer")) {

                    } else if (C.getName().equals("Robber")) {

                    } else if (C.getName().equals("Troublemaker")) {

                    } else if (C.getName().equals("Drunk")) {

                    } else if (C.getName().equals("Insomniac")) {

                    }
                }
            }
            if (C.getName().equals("Werewolf") && !didWerewolves) {
                didWerewolves = true;
                String msg = "The Werewolves Are: ";
                for (Player wolf : werewolves) {
                    msg += wolf.getName() + " ";
                }
                System.out.println(msg);
            }
            if (C.getName().equals("Minion") && !didMinions) {
                didMinions = true;
                String msg = "The Minions Are: ";
                for (Player minion : minions) {
                    msg += minion.getName() + " ";
                }
                System.out.println(msg);
            }
            if(C.getName().equals("Mason") && !didMasons) {
                didMasons = true;
                String msg = "The Masons Are: ";
                for (Player mason : masons) {
                    msg += mason.getName() + " ";
                }
                System.out.println(msg);
            }
        }
    }
}

