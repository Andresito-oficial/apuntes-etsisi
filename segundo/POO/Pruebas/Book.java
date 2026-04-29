

public class Book {
    private final int year;
    private final String title;
    private final String author;

    public Book( String title, int year, String author) {
        if (title.isEmpty()) throw new IllegalArgumentException("Title is missing");
        this.title = normalizeText( title, "Title");
        //this.title = Arrays.stream(words).collect(Collectors.joining(" "));
        this.year = year;
        this.author = normalizeText(author, "Author");
    }

    private String normalizeText (String input, String field){
        if (input.isEmpty()) throw new IllegalArgumentException(field + " is missing");
        String lowerText = input.toLowerCase();
        final String[] words = lowerText.split(" ");
        final int length = words.length;
        for (int i = 0; i < length; i++) {
            final String word = words[i];
            final char firstCharacter = word.charAt(0);
            final char upperFirstCharacter = Character.toUpperCase(firstCharacter);
            final String secondPart = word.substring(1);
            final String capitalizedWord = String.valueOf(upperFirstCharacter) + secondPart;
            words[i] = capitalizedWord;
        }
        return String.join(" ", words);
    }

    public boolean titleStartsWith(String title) {
        return this.title.startsWith(normalizeText(title, "filter"));
    }

    @Override
    public String toString() {
        return "" + title + " (" + year + "), by " + author;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != Book.class) return false;
        if (this == obj) return true;
        final Book other = (Book) obj;
        return (this.title.equals(other.title)) &&
                (this.year == other.year) &&
                (this.author.equals(other.author));
    }
      

}
