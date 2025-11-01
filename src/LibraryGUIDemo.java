import javax.swing.*; // Імпортуємо бібліотеку для GUI (вікон)
import java.awt.Font; // Імпортуємо для налаштування шрифту
import java.util.ArrayList;
import java.util.List;

/**
 * 6. Головний клас з "Міні-Дисплеєм" (GUI).
 * На поки він вииодиьть лише інформацію , ніяк з нею не працює
 * Створює колекцію об'єктів та виводить інформацію про них у вікно.
 */
public class LibraryGUIDemo {

    public static void main(String[] args) {

        // 1. Створити колекцію (List) об'єктів.
        // Ми використовуємо List<LibraryItem> (наш інтерфейс).
        List<LibraryItem> catalog = new ArrayList<>();

        // 2. Наповнюємо колекцію різними типами об'єктів
        catalog.add(new Book("Кобзар", "ISBN-978-001", "Тарас Шевченко", 5));
        catalog.add(new ReferenceBook("Велика українська енциклопедія", "REF-001", "Загальні знання", 2));
        catalog.add(new JournalIssue("National Geographic", "ISSN-002", "NatGeo Society", 188, 10));
        catalog.add(new Book("1984", "ISBN-978-002", "Джордж Орвелл", 3));


        // 3. Готуємо текст для нашого дисплею
        // Збираємо ВЕСЬ текст в один великий рядок
        StringBuilder displayText = new StringBuilder();
        displayText.append("   === КАТАЛОГ БІБЛІОТЕКИ ===\n\n");

        // Проходимо по КОЖНОМУ елементу в колекції
        for (LibraryItem item : catalog) {

            // Використовуємо наш НОВИЙ метод getDetailsAsString()
            // Завдяки поліморфізму, Java сама викличе потрібну версію
            // (з Book, ReferenceBook чи JournalIssue)
            displayText.append(item.getDetailsAsString());

            // Додаємо роздільник
            displayText.append("\n\n----------------------------------\n\n");
        }

        // 4. Створюємо GUI компоненти ("Міні-дисплей")

        // Створюємо головне вікно
        JFrame frame = new JFrame("Міні-дисплей: Каталог Бібліотеки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закриття програми при закритті вікна
        frame.setSize(500, 600); // Розмір вікна (ширина, висота)

        // Створюємо текстову область, куди ми помістимо наш текст
        JTextArea textArea = new JTextArea();
        textArea.setText(displayText.toString()); // Встановлюємо наш зібраний текст
        textArea.setEditable(false); // Забороняємо користувачу редагувати текст
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Встановлюємо шрифт
        textArea.setMargin(new javax.swing.border.EmptyBorder(10, 10, 10, 10).getBorderInsets(textArea)); // Відступи

        // Додаємо можливість прокрутки (JScrollPane) на випадок, якщо тексту забагато
        JScrollPane scrollPane = new JScrollPane(textArea);

        // 5. Збираємо все разом і показуємо вікно
        frame.add(scrollPane); // Додаємо прокрутку з текстом у вікно
        frame.setLocationRelativeTo(null); // Вікно з'явиться по центру екрану
        frame.setVisible(true); // Робимо вікно видимим
    }
}