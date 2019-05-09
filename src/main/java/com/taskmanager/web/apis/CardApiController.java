package com.taskmanager.web.apis;

import com.taskmanager.domain.application.CardService;
import com.taskmanager.domain.common.security.CurrentUser;
import com.taskmanager.domain.model.card.Card;
import com.taskmanager.domain.model.user.SimpleUser;
import com.taskmanager.web.payload.AddCardPayload;
import com.taskmanager.web.payload.ChangeCardPositionsPayload;
import com.taskmanager.web.results.AddCardResult;
import com.taskmanager.web.results.ApiResult;
import com.taskmanager.web.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CardApiController {

    private CardService cardService;

    public CardApiController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/api/cards")
    public ResponseEntity<ApiResult> addCard(@RequestBody AddCardPayload payload,
                                             @CurrentUser SimpleUser currentUser) {
        Card card = cardService.addCard(payload.toCommand(currentUser.getUserId()));
        return AddCardResult.build(card);
    }

    @PostMapping("/api/cards/positions")
    public ResponseEntity<ApiResult> changeCardPositions(@RequestBody ChangeCardPositionsPayload payload) {
        cardService.changePositions(payload.toCommand());
        return Result.ok();
    }
}
