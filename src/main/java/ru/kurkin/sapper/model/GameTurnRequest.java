package ru.kurkin.sapper.model;

import lombok.Data;

@Data
public class GameTurnRequest {
    private String game_id;
    private int col;
    private int row;
}
