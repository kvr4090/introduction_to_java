package classes.task11;

/*
 * Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
 * консоль текст, заголовок текста.
 */

public class Text {
    private String text;
    private String textTitle;

    public Text(String text, String text_title) {
        this.text = text;
        this.textTitle = text_title;
    }

    public Text(String text) {
        this.text = text;
    }

    private void addText(String textToAdd) {
        text = text + textToAdd;
    }

    private void textToScreen() {
        System.out.println(text);
        System.out.println(textTitle);
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public static void main(String[] args) {
        Text text = new Text(new Sentence().getText(), new Word().getWord());
    }
}

