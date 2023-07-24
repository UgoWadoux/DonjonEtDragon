package fr.campus.dd.ui.cases;

import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;

public class EmptyCase implements Case {
    String empty;

    public EmptyCase() {
        display();
    }

    @Override
    public void display() {
        this.empty = "Case vide";
    }

    @Override
    public String toString() {
        return "EmptyCase{" +
                "empty='" + empty + '\'' +
                '}';
    }

}
