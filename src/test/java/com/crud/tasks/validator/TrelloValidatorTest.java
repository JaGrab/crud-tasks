package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrelloValidatorTest {
    @Test
    public void validateTrelloBoardsTest() {
        //Given
        TrelloValidator validator = new TrelloValidator();
        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList("1", "Test list", false));
        lists.add(new TrelloList("2", "Simple test list", false));
        lists.add(new TrelloList("3", "Simplest list", false));
        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(new TrelloBoard("1", "Board test", lists));
        boards.add(new TrelloBoard("2", "Testing", lists));
        boards.add(new TrelloBoard("3", "test", lists));
        //When
        List<TrelloBoard> validatedBoards = validator.validateTrelloBoards(boards);
        //Then
        assertEquals(2, validatedBoards.size());
        assertEquals(3, validatedBoards.get(1).getLists().size());
    }
    @Test
    public void validateTrelloCardTest() {
        //Given
        TrelloValidator validator = new TrelloValidator();
        TrelloCard testCard = new TrelloCard("Just testing", "My test", "11", "8");
        TrelloCard standardCard = new TrelloCard("Important note", "Note imporatant notes!", "12", "8");
        //When
        validator.validateCard(testCard);
        validator.validateCard(standardCard);
        //Then
        //check output
    }
}
