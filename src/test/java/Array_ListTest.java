import array_list.Array_List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static array_list.Array_List.quickSort;
import static org.junit.jupiter.api.Assertions.*;


public class Array_ListTest {


    @Test
    public void addIntegerElementType() {
        Array_List<Integer> testList = new Array_List();
        int testListSize = 11;
        int negativeIndex = -1;
        int utilityInt = 15;
        for (int i = 0; i < testListSize; i++) {
            testList.add(i);
        }
        assertTrue(testList.size() > 0);
        assertEquals(testListSize, testList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(testList.size() + utilityInt));
        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(negativeIndex));
    }

    @Test
    public void addStringElementType() {
        Array_List<String> testList = new Array_List();
        int testListSize = 11;
        int negativeIndex = -1;
        int utilityInt = 15;
        for (int i = 0; i < testListSize; i++) {
            testList.add(String.valueOf(i));
        }
        assertTrue(testList.size() > 0);
        assertEquals(testListSize, testList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(testList.size() + utilityInt));
        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(negativeIndex));
    }

    @Test
    public void addByIndex() {
        Array_List<String> list = new Array_List();
        int testListSize = 1000;
        int negativeIndex = -1;
        int utilityInt = 15;
        for (int i = 0; i < testListSize; i++) {
            list.add(i, String.valueOf(i));
        }
        assertTrue(list.size() > 0);
        assertEquals(testListSize, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + utilityInt));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(negativeIndex));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(negativeIndex, "1"));

    }

    @Test
    public void remove() {
        Array_List<Integer> list = new Array_List();
        int testListSize = 1000;
        int negativeIndex = -1;
        int utilityInt = 15;
        for (int i = 0; i < testListSize; i++) {
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(negativeIndex));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size() + utilityInt));
    }

    @Test
    public void getElement() {
        Array_List<String> list = new Array_List();
        int testListSize = 1000;
        int negativeIndex = -1;
        for (int i = 0; i < testListSize; i++) {
            String element = String.valueOf(i);
            list.add(element);
            assertEquals(element, list.get(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(negativeIndex));
    }

    @Test
    public void setElement() {
        Array_List<String> list = new Array_List();
        int testListSize = 1000;
        int negativeIndex = -1;
        for (int i = 0; i < testListSize; i++) {
            String element = String.valueOf(i);
            list.add(element);
            assertEquals(element, list.get(i));
        }

        String element = "element";
        for (int i = 0; i < testListSize; i++) {
            list.set(i, element);
            assertEquals(element, list.get(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(negativeIndex, element));
    }

    @Test
    public void clearList() {
        Array_List<String> list = new Array_List();
        int testListSize = 1000;
        for (int i = 0; i < testListSize; i++) {
            list.add(String.valueOf(i));
        }
        int startListSize = list.size();
        list.clear();
        int finishListSize = list.size();
        assertTrue(startListSize > finishListSize);
    }

    @Test
    public void quickSortElements(){
        Array_List<String> testList = new Array_List();
            testList.add("5");
            testList.add("77");
            testList.add("-345");
            testList.add("665");
            testList.add("0");

            quickSort(testList);
        System.out.println(testList);

        Array_List<String> expectedList = new Array_List();
        expectedList.add("-345");
        expectedList.add("0");
        expectedList.add("5");
        expectedList.add("665");
        expectedList.add("77");

        for (int i = 0; i <expectedList.size(); i++) {
            assertEquals(testList.get(i),expectedList.get(i));
        }
    }
}
