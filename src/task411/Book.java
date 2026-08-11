package task411;

public class Book implements LibraryItem1 {
        private String title = "Untitled";
        private String author = "Unknown";
        private int pages;

        public Book() {}

        public Book(String title, String author, int pages) {
            setTitle(title);
            setAuthor(author);
            setPages(pages);
        }

        // LibraryItem Interface Methods
        @Override
        public void printAllInfo() {
            IO.println("task411.Book: " + title + " by " + author + " (" + pages + " pages) [" + getShelfCode() + "]");
        }

        @Override
        public String getLabel() {
            return title;
        }

        @Override
        public String getShelfCode() {
            return "Shelf B-01";
        }

        // Getters and Setters with Validation Rules
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            if (title == null || title.trim().isEmpty()) {
               IO.println("Name cannot be empty.");
            } else {
                this.title = title;
            }
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            if (pages <= 0) {
                this.pages = 0;
                IO.println("Pages must be above 0");
            } else {
                this.pages = pages;
            }
//book
        }
    }
