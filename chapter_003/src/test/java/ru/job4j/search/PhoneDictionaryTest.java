package ru.job4j.search;

/**
 * Test проверяет поиск по справочнику.
 *
 * @author TinaGVI
 * @since 08.10.2018
 */
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Pet");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByName2() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Tina", "GVI", "534872", "SPB")
        );
        List<Person> persons = phones.find("Tina");
        assertThat(persons.iterator().next().getSurname(), is("GVI"));
    }
}
