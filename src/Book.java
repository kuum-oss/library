/**
 * 3. Конкретний клас: Книга.
 * Успадковує AbstractLibraryItem і додає автора.
 */
public class Book extends AbstractLibraryItem {

    protected String author;

    public Book(String title, String catalogId, String author, int totalCopies) {
        // Викликаємо конструктор батьківського (абстрактного) класу
        super(title, catalogId, totalCopies);
        this.author = author;
    }

    /**
     * Перевизначаємо (Override) метод для GUI.
     * Ми викликаємо батьківський метод, щоб отримати базову інформацію,
     * а потім додаємо свою унікальну.
     */
    @Override
    public String getDetailsAsString() {
        // Отримуємо "Назва: ...", "ID: ..." від батьківського класу
        String baseDetails = super.getDetailsAsString();

        // Додаємо свою інформацію
        return "--- [КНИГА] ---\n" +
                baseDetails + "\n" +
                "Автор: " + author;
    }
}