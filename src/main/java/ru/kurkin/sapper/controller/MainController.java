package ru.kurkin.sapper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kurkin.sapper.model.GameInfoResponse;
import ru.kurkin.sapper.model.GameTurnRequest;
import ru.kurkin.sapper.model.NewGameRequest;
import ru.kurkin.sapper.service.SapperService;

@RestController
@RequestMapping("/api")
public class MainController {

    private final SapperService sapperService;

    public MainController(SapperService sapperService) {
        this.sapperService=sapperService;
    }

    @PostMapping("/new")
    public ResponseEntity<GameInfoResponse> postNewGame(@RequestBody NewGameRequest newGameRequest) {
        GameInfoResponse response = sapperService.startNewGame(newGameRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/turn")
    public ResponseEntity<GameInfoResponse> postNewGame(@RequestBody GameTurnRequest gameTurnRequest) {
        GameInfoResponse response = sapperService.makeTurn(gameTurnRequest);
        return ResponseEntity.ok(response);
    }
}
