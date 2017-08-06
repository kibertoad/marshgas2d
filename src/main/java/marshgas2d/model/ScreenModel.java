package marshgas2d.model;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.Setter;
import net.kiberion.swampmachine.gui.prototypes.ElementPrototype;

import java.util.ArrayList;
import java.util.List;

public class ScreenModel {

    @Getter
    @Setter
    private String id;

    private final List<ElementPrototype> elements = new ArrayList<>();

    public List<ElementPrototype> getElements() {
        return ImmutableList.copyOf(elements);
    }

    public void addElement(ElementPrototype element) {
        elements.add(element);
    }

    public void removeElement(ElementPrototype element) {
        elements.remove(element);
    }

}
