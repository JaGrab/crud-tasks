package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrelloMapperTestSuite {
    @Test
    public void mapToCardTest() {
        //Given
        TrelloMapper mapper = new TrelloMapper();
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card", "Card description", "1234", "8");
        //When
        TrelloCard trelloCard = mapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("Card", trelloCard.getName());
        assertEquals("Card description", trelloCard.getDescription());
        assertEquals("1234", trelloCard.getPos());
        assertEquals("8", trelloCard.getListId());
    }
    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloMapper mapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("Card 2", "Card description 2", "2345", "9");
        //When
        TrelloCardDto trelloCardDto = mapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Card 2", trelloCard.getName());
        assertEquals("Card description 2", trelloCard.getDescription());
        assertEquals("2345", trelloCard.getPos());
        assertEquals("9", trelloCard.getListId());
    }
    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloMapper mapper = new TrelloMapper();
        TrelloListDto list1 = new TrelloListDto("12ab", "List 1", true);
        TrelloListDto list2 = new TrelloListDto("23bc", "List 2", false);
        TrelloListDto list3 = new TrelloListDto("34cd", "List 3", false);
        List<TrelloListDto> lists1 = new ArrayList<>();
        List<TrelloListDto> lists2 = new ArrayList<>();
        lists1.add(list1);
        lists1.add(list2);
        lists2.add(list3);
        TrelloBoardDto board1 = new TrelloBoardDto("abcd", "Board 1", lists1);
        TrelloBoardDto board2 = new TrelloBoardDto("cdef", "Board 2", lists2);
        List<TrelloBoardDto> boardsDto = new ArrayList<>();
        boardsDto.add(board1);
        boardsDto.add(board2);
        //When
        List<TrelloBoard> boards = mapper.mapToBoards(boardsDto);
        //Then
        assertEquals(2, boards.size());
        assertEquals("Board 1", boards.get(0).getName());
        assertEquals("Board 2", boards.get(1).getName());
        assertEquals(2, boards.get(0).getLists().size());
        assertEquals(1, boards.get(1).getLists().size());
        assertEquals("23bc", boards.get(0).getLists().get(1).getId());
        assertEquals(false, boards.get(1).getLists().get(0).isClosed());
    }
    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloMapper mapper = new TrelloMapper();
        TrelloList list1 = new TrelloList("ab12", "List A", false);
        TrelloList list2 = new TrelloList("bc23", "List B", true);
        TrelloList list3 = new TrelloList("cd34", "List C", false);
        List<TrelloList> lists1 = new ArrayList<>();
        List<TrelloList> lists2 = new ArrayList<>();
        lists1.add(list1);
        lists1.add(list2);
        lists2.add(list3);
        TrelloBoard board1 = new TrelloBoard("4312", "Board X", lists1);
        TrelloBoard board2 = new TrelloBoard("5342", "Board Y", lists2);
        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(board1);
        boards.add(board2);
        //When
        List<TrelloBoardDto> boardsDto = mapper.mapToBoardsDto(boards);
        //Then
        assertEquals(2, boardsDto.size());
        assertEquals("Board X", boardsDto.get(0).getName());
        assertEquals("Board Y", boardsDto.get(1).getName());
        assertEquals(2, boardsDto.get(0).getLists().size());
        assertEquals(1, boardsDto.get(1).getLists().size());
        assertEquals("bc23", boardsDto.get(0).getLists().get(1).getId());
        assertEquals(false, boardsDto.get(1).getLists().get(0).isClosed());
    }
}
