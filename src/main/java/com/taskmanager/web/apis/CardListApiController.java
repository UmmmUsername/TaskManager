package com.taskmanager.web.apis;

import com.taskmanager.domain.application.CardListService;
import com.taskmanager.domain.common.security.CurrentUser;
import com.taskmanager.domain.model.cardlist.CardList;
import com.taskmanager.domain.model.user.SimpleUser;
import com.taskmanager.web.payload.AddCardListPayload;
import com.taskmanager.web.payload.ChangeCardListPositionsPayload;
import com.taskmanager.web.results.AddCardListResult;
import com.taskmanager.web.results.ApiResult;
import com.taskmanager.web.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CardListApiController {

    private CardListService cardListService;

    public CardListApiController(CardListService cardListService) {
        this.cardListService = cardListService;
    }

    @PostMapping("/api/card-lists")
    public ResponseEntity<ApiResult> addCardList(@RequestBody AddCardListPayload payload,
                                                 @CurrentUser SimpleUser currentUser) {
        CardList cardList = cardListService.addCardList(payload.toCommand(currentUser.getUserId()));
        return AddCardListResult.build(cardList);
    }

    @PostMapping("/api/card-lists/positions")
    public ResponseEntity<ApiResult> changeCardListPositions(@RequestBody ChangeCardListPositionsPayload payload) {
        cardListService.changePositions(payload.toCommand());
        return Result.ok();
    }
}
