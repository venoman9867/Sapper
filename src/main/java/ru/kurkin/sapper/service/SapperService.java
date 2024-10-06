package ru.kurkin.sapper.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.kurkin.sapper.exception.MyException;
import ru.kurkin.sapper.model.GameInfoResponse;
import ru.kurkin.sapper.model.GameTurnRequest;
import ru.kurkin.sapper.model.NewGameRequest;

@Service
public class SapperService {
    private final String API_URL = "https://minesweeper-test.studiotg.ru/api";
    private final RestTemplate restTemplate;

    public SapperService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GameInfoResponse startNewGame(NewGameRequest newGameRequest) {
        String url = API_URL + "/new";
        try {
            return restTemplate.postForObject(url, newGameRequest, GameInfoResponse.class);
        }catch (RuntimeException e){
            throw new MyException("Произошла непредвиденная ошибка");
        }
    }
    public GameInfoResponse makeTurn(GameTurnRequest gameTurnRequest) {
        String url = API_URL + "/turn";
        try {
        return restTemplate.postForObject(url, gameTurnRequest, GameInfoResponse.class);
        }catch (RuntimeException e){
            throw new MyException("Произошла непредвиденная ошибка");
        }
    }
}
