package ru.kurkin.sapper.model;

import lombok.Data;

import java.util.List;
@Data
public class GameInfoResponse {
    private String game_id;
    private int width;
    private int height;
    private int mines_count;
    private boolean completed;
    private List<List<String>> field;
}
