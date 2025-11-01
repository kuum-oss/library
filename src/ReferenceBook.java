/**
 * 4. Конкретний клас: Довідник (наприклад, енциклопедія).
 * Такі книги не можна видавати додому.
 */
public class ReferenceBook extends AbstractLibraryItem {

    protected String subject; // Тематика (напр., "Історія", "Біологія")

    public ReferenceBook(String title, String catalogId, String subject, int totalCopies) {
        super(title, catalogId, totalCopies);
        this.subject = subject;
    }

    /**
     * Перевизначаємо isLoanable, щоб вказати,
     * що цей тип книг видається ТІЛЬКИ в читальний зал.
     */
    @Override
    public boolean isLoanable() {
        return false; // Заборонено видавати на абонемент
    }

    /**
     * Перевизначаємо метод для GUI.
     */
    @Override
    public String getDetailsAsString() {
        String baseDetails = super.getDetailsAsString();
        return "--- [ДОВІДНИК] ---\n" +
                baseDetails + "\n" +
                "Тематика: " + subject;
    }
}