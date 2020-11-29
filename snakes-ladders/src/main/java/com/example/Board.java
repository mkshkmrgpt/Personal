package com.example;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Board {

    private int size;
    private State state;
    private Set<Player> players = new HashSet<>();
    private Player winner;
    private Set<Snake> snakes = new HashSet<>();

    public Board(int size) {
        this.size = size;
        this.state = State.NOT_STARTED;
    }

    public int size() {
        return size;
    }

    public Set<Player> players() {
        return players;
    }

    public void registerPlayer(Player player) {
        players.add(player);
    }

    public void updatePlayer(int id, int diceNumber) {
        players.stream().filter(player -> player.getId() == id)
                .peek(player -> player.setCurrentPosition(player.getCurrentPosition() + diceNumber))
                .filter(player -> player.getCurrentPosition() <= size)
                .findFirst()
                .ifPresent(player -> snakes.stream().filter(snake -> snake.start == player.getCurrentPosition())
                        .findAny()
                        .ifPresent(snake -> {
                            player.setCurrentPosition(snake.end);
                            players.add(player);
                        }));
        updateState();
    }

    private void updateState() {
        if (state.equals(State.NOT_STARTED)) {
            state = State.STARTED;
        }
        players.stream().filter(player -> player.getCurrentPosition() == size)
                .findFirst().ifPresent(player -> {
            winner = player;
            state = State.ENDED;
        });
    }

    public Optional<Player> winner() {
        return Optional.ofNullable(winner);
    }

    public void registerSnake(Snake snake) {
        snakes.add(snake);
    }

    public void status() {
        if (winner == null) {
            System.out.println("Game has " + state);
            players.forEach(player -> System.out.println("Player " + player.getId() + " is at " + player.getCurrentPosition()));
            return;
        }
        System.out.println("Winner is :  " + winner.getId());
        System.out.println("Game has " + state);
    }
}
