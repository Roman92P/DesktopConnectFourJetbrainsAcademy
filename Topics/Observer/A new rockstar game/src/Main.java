import java.util.*;     

/**
 * Observable interface
**/
interface Observable {
    // write your code here ...
    void addObserver(Observer observer);
}

/**
 * Concrete Observable - Rockstar Games
**/
class RockstarGames implements Observable {

    public String releaseGame;

    // write your code here ...
    private ArrayList<Observer> observers = new ArrayList<>();
    
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void release(String game) {
        this.releaseGame = game;
        // write your code here ...
        for (Observer o : observers) {
            o.update(releaseGame);
        }
        
    }
}

/**
 * Observer interface
**/
interface Observer {
    // write your code here ...
    void update(String game);
}

/**
 * Concrete observer - Gamer
**/
class Gamer implements Observer {

    private String name;
    private Set<String> games = new HashSet<>();

    public Gamer(String name) {
        this.name = name;
    }

    // write your code here ...
    @Override
    public void update(String game) {
        System.out.println("Notification for gamer : " + name);
        int s = games.size();
        games.add(game);
        int s1 = games.size();
        if (s1 == s) {
            System.out.println("What? They've already released this game ... I don't understand");
        } else {
            this.buyGame(game);
        }
    }

    public void buyGame(String game) {
        System.out.println(name + " says : \"Oh, Rockstar releases new game " + game + " !\"");
        games.add(game);
    }

    @Override
    public String toString() {
        return this.name;
    }    
}

/**
 * Main class
**/
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String game = null;

        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose");
        Gamer peter = new Gamer("Peter Johnston");
        Gamer helen = new Gamer("Helen Jack");

        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);

        for (int i = 0; i < 2; i++) {
            game = scanner.nextLine();
            rockstarGames.release(game);
        }
    }
}
