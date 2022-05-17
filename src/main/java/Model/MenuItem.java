package Model;

public class MenuItem implements Comparable<MenuItem> , java.io.Serializable{
    private String title;

    public MenuItem(String title)
    {
        this.title=title;
    }


    public int computePrice()
    {
        return 0;
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public int compareTo(MenuItem o) {
       return this.title.compareTo(o.title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean containsTitle(String title)
    {
        return this.title.contains(title);
    }
}
