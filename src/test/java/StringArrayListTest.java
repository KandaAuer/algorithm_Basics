import org.example.StringArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringArrayListTest {
    private StringArrayList list;

    @BeforeEach
    public void setUp() {
        list = new StringArrayList(2);
    }

    @Test
    public void testAdd() {
        assertEquals("Я в кармане ношу", list.add("Я в кармане ношу"));
        assertEquals("Никому не расскажу", list.add("Никому не расскажу"));
        assertEquals(2, list.size());
    }

    @Test
    public void testAddAtIndex() {
        list.add("Я в кармане ношу");
        list.add(0, "Никому не расскажу");
        assertEquals("Никому не расскажу", list.get(0));
        assertEquals("Я в кармане ношу", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testSet() {
        list.add("Я в кармане ношу");
        assertEquals("Я в кармане ношу", list.set(0, "Никому не расскажу"));
        assertEquals("Никому не расскажу", list.get(0));
    }

    @Test
    public void testRemoveByItem() {
        list.add("Я в кармане ношу");
        list.add("Никому не расскажу");
        assertEquals("Я в кармане ношу", list.remove("Я в кармане ношу"));
        assertEquals(1, list.size());
        assertFalse(list.contains("Я в кармане ношу"));
    }

    @Test
    public void testRemoveByIndex() {
        list.add("Я в кармане ношу");
        list.add("Никому не расскажу");
        assertEquals("Никому не расскажу", list.remove(1));
        assertEquals(1, list.size());
    }

    @Test
    public void testContains() {
        list.add("Я в кармане ношу");
        assertTrue(list.contains("Я в кармане ношу"));
        assertFalse(list.contains("Неизвестная фраза"));
    }

    @Test
    public void testIndexOf() {
        list.add("Я в кармане ношу");
        list.add("Никому не расскажу");
        assertEquals(0, list.indexOf("Я в кармане ношу"));
        assertEquals(-1, list.indexOf("Неизвестная фраза"));
    }

    @Test
    public void testLastIndexOf() {
        list.add("Я в кармане ношу");
        list.add("Никому не расскажу");
        list.add("Я в кармане ношу");
        assertEquals(2, list.lastIndexOf("Я в кармане ношу"));
        assertEquals(-1, list.lastIndexOf("Неизвестная фраза"));
    }

    @Test
    public void testGet() {
        list.add("Я в кармане ношу");
        assertEquals("Я в кармане ношу", list.get(0));
    }

    @Test
    public void testEquals() {
        StringArrayList anotherList = new StringArrayList(2);
        list.add("Я в кармане ношу");
        anotherList.add("Я в кармане ношу");
        assertTrue(list.equals(anotherList));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add("Я в кармане ношу");
        assertEquals(1, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("Я в кармане ношу");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.add("Я в кармане ношу");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        list.add("Я в кармане ношу");
        list.add("Никому не расскажу");
        String[] expectedArray = {"Я в кармане ношу", "Никому не расскажу"};
        assertArrayEquals(expectedArray, list.toArray());
    }

    @Test
    public void testAddNull() {
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @Test
    public void testAddAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "Выход за пределы"));
    }

    @Test
    public void testSetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "Выход за пределы"));
    }

    @Test
    public void testRemoveNotFound() {
        assertThrows(IllegalArgumentException.class, () -> list.remove("Неизвестная фраза"));
    }

    @Test
    public void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testEqualsWithNull() {
        assertThrows(IllegalArgumentException.class, () -> list.equals(null));
    }
}
