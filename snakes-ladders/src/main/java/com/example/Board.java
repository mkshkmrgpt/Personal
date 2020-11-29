package com.example;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Board {

    private int size;
    private State state;
    private Set<Player> players = new HashSet<>();
    private Player winner;

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

    public void updatePlayer(int id, int asInt) {
        players.stream().filter(player -> player.getId() == id)
                .peek(player -> player.setCurrentPosition(player.getCurrentPosition() + asInt))
                .filter(player -> player.getCurrentPosition() <= size)
                .findFirst()
                .ifPresent(player -> players.add(player));
        updateState();
    }

    private void updateState() {
        if (state.equals(State.NOT_STARTED)) {
            state = state.STARTED;
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
}
