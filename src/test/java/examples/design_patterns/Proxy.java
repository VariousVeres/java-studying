package examples.design_patterns;

import org.junit.Test;

public class Proxy {
    @Test
    public void method() {
        Player p1 = new ProxyMoviePlayer("Titanic.avi");
        p1.play();
        Player p2 = new ProxyMoviePlayer("It.avi");
        p2.play();
    }
}


interface Player {
    void play();
}

class MoviePlayer implements Player {
    String movieName;

    MoviePlayer(String str) {
        this.movieName = str;
        System.out.println("Hi, it's movie player");
        load();
    }

    @Override
    public void play() {
        System.out.println("Play");
    }

    void load() {
        System.out.println("Loading file " + this.movieName);
    }
}

class ProxyMoviePlayer implements Player {
    String movieName;
    Player p;

    ProxyMoviePlayer(String str) {
        movieName = str;
    }

    @Override
    public void play() {
        if (p == null) {
            p = new MoviePlayer(movieName);
            p.play();
        }
    }
}
