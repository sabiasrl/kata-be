package com.soprasteria.bookstore.config;

import com.soprasteria.bookstore.model.Book;
import com.soprasteria.bookstore.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("acc")
public class DataInitializer {
    @Bean
    @Primary
    public ApplicationRunner customDataInitializer(BookRepository bookRepository) {
        return args -> {
            if (bookRepository.count() == 0) {
                List<Book> books = Arrays.asList(
                        new Book("The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien", 19.99),
                        new Book("The Lord of the Rings: The Two Towers", "J.R.R. Tolkien", 19.99),
                        new Book("The Lord of the Rings: The Return of the King", "J.R.R. Tolkien", 19.99),
                        new Book("The Hobbit", "J.R.R. Tolkien", 14.99),
                        new Book("The Silmarillion", "J.R.R. Tolkien", 16.99),
                        new Book("A Game of Thrones", "George R.R. Martin", 18.99),
                        new Book("A Clash of Kings", "George R.R. Martin", 18.99),
                        new Book("A Storm of Swords", "George R.R. Martin", 18.99),
                        new Book("A Feast for Crows", "George R.R. Martin", 18.99),
                        new Book("A Dance with Dragons", "George R.R. Martin", 18.99),
                        new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 12.99),
                        new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 12.99),
                        new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 12.99),
                        new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 13.99),
                        new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 13.99),
                        new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 13.99),
                        new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", 13.99),
                        new Book("The Name of the Wind", "Patrick Rothfuss", 15.99),
                        new Book("The Wise Man's Fear", "Patrick Rothfuss", 15.99),
                        new Book("The Way of Kings", "Brandon Sanderson", 17.99),
                        new Book("Words of Radiance", "Brandon Sanderson", 17.99),
                        new Book("Oathbringer", "Brandon Sanderson", 17.99),
                        new Book("Rhythm of War", "Brandon Sanderson", 17.99),
                        new Book("Mistborn: The Final Empire", "Brandon Sanderson", 14.99),
                        new Book("Mistborn: The Well of Ascension", "Brandon Sanderson", 14.99),
                        new Book("Mistborn: The Hero of Ages", "Brandon Sanderson", 14.99),
                        new Book("The Eye of the World", "Robert Jordan", 13.99),
                        new Book("The Great Hunt", "Robert Jordan", 13.99),
                        new Book("The Dragon Reborn", "Robert Jordan", 13.99),
                        new Book("The Shadow Rising", "Robert Jordan", 13.99),
                        new Book("The Fires of Heaven", "Robert Jordan", 13.99),
                        new Book("The Blade Itself", "Joe Abercrombie", 12.99),
                        new Book("Before They Are Hanged", "Joe Abercrombie", 12.99),
                        new Book("Last Argument of Kings", "Joe Abercrombie", 12.99),
                        new Book("The Lies of Locke Lamora", "Scott Lynch", 13.99),
                        new Book("Red Seas Under Red Skies", "Scott Lynch", 13.99),
                        new Book("The Republic of Thieves", "Scott Lynch", 13.99),
                        new Book("The Priory of the Orange Tree", "Samantha Shannon", 15.99),
                        new Book("The Once and Future King", "T.H. White", 14.99),
                        new Book("The Black Prism", "Brent Weeks", 13.99),
                        new Book("The Way of Shadows", "Brent Weeks", 13.99),
                        new Book("The Magicians", "Lev Grossman", 12.99),
                        new Book("The Golden Compass", "Philip Pullman", 12.99),
                        new Book("The Subtle Knife", "Philip Pullman", 12.99),
                        new Book("The Amber Spyglass", "Philip Pullman", 12.99),
                        new Book("Eragon", "Christopher Paolini", 11.99),
                        new Book("Eldest", "Christopher Paolini", 11.99),
                        new Book("Brisingr", "Christopher Paolini", 11.99),
                        new Book("Inheritance", "Christopher Paolini", 11.99),
                        new Book("The Sword of Shannara", "Terry Brooks", 13.99),
                        new Book("The Elfstones of Shannara", "Terry Brooks", 13.99),
                        new Book("The Wishsong of Shannara", "Terry Brooks", 13.99),
                        new Book("The Colour of Magic", "Terry Pratchett", 12.99),
                        new Book("The Light Fantastic", "Terry Pratchett", 12.99),
                        new Book("Equal Rites", "Terry Pratchett", 12.99),
                        new Book("Mort", "Terry Pratchett", 12.99),
                        new Book("Guards! Guards!", "Terry Pratchett", 12.99),
                        new Book("Good Omens", "Neil Gaiman & Terry Pratchett", 14.99),
                        new Book("American Gods", "Neil Gaiman", 14.99),
                        new Book("Neverwhere", "Neil Gaiman", 13.99),
                        new Book("Stardust", "Neil Gaiman", 13.99),
                        new Book("The Ocean at the End of the Lane", "Neil Gaiman", 13.99),
                        new Book("The Broken Empire: Prince of Thorns", "Mark Lawrence", 13.99),
                        new Book("The Broken Empire: King of Thorns", "Mark Lawrence", 13.99),
                        new Book("The Broken Empire: Emperor of Thorns", "Mark Lawrence", 13.99),
                        new Book("The Witcher: The Last Wish", "Andrzej Sapkowski", 13.99),
                        new Book("The Witcher: Sword of Destiny", "Andrzej Sapkowski", 13.99),
                        new Book("The Witcher: Blood of Elves", "Andrzej Sapkowski", 13.99),
                        new Book("The Witcher: Time of Contempt", "Andrzej Sapkowski", 13.99),
                        new Book("The Witcher: Baptism of Fire", "Andrzej Sapkowski", 13.99),
                        new Book("The Witcher: The Tower of the Swallow", "Andrzej Sapkowski", 13.99),
                        new Book("The Witcher: The Lady of the Lake", "Andrzej Sapkowski", 13.99),
                        new Book("The Witcher: Season of Storms", "Andrzej Sapkowski", 13.99),
                        new Book("The Chronicles of Narnia: The Lion, the Witch and the Wardrobe", "C.S. Lewis", 11.99),
                        new Book("The Chronicles of Narnia: Prince Caspian", "C.S. Lewis", 11.99),
                        new Book("The Chronicles of Narnia: The Voyage of the Dawn Treader", "C.S. Lewis", 11.99),
                        new Book("The Chronicles of Narnia: The Silver Chair", "C.S. Lewis", 11.99),
                        new Book("The Chronicles of Narnia: The Horse and His Boy", "C.S. Lewis", 11.99),
                        new Book("The Chronicles of Narnia: The Magician's Nephew", "C.S. Lewis", 11.99),
                        new Book("The Chronicles of Narnia: The Last Battle", "C.S. Lewis", 11.99),
                        new Book("The Earthsea Cycle: A Wizard of Earthsea", "Ursula K. Le Guin", 13.99),
                        new Book("The Earthsea Cycle: The Tombs of Atuan", "Ursula K. Le Guin", 13.99),
                        new Book("The Earthsea Cycle: The Farthest Shore", "Ursula K. Le Guin", 13.99),
                        new Book("The Earthsea Cycle: Tehanu", "Ursula K. Le Guin", 13.99),
                        new Book("The Earthsea Cycle: Tales from Earthsea", "Ursula K. Le Guin", 13.99),
                        new Book("The Earthsea Cycle: The Other Wind", "Ursula K. Le Guin", 13.99),
                        new Book("The Belgariad: Pawn of Prophecy", "David Eddings", 12.99),
                        new Book("The Belgariad: Queen of Sorcery", "David Eddings", 12.99),
                        new Book("The Belgariad: Magician's Gambit", "David Eddings", 12.99),
                        new Book("The Belgariad: Castle of Wizardry", "David Eddings", 12.99),
                        new Book("The Belgariad: Enchanters' End Game", "David Eddings", 12.99)
                );
                bookRepository.saveAll(books);
            }
        };
    }
}
