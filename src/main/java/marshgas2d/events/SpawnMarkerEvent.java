package marshgas2d.events;

import net.kiberion.swampmachine.gui.prototypes.ElementPrototype;

public class SpawnMarkerEvent {
    private final ElementPrototype elementPrototype;

    public SpawnMarkerEvent(ElementPrototype elementPrototype) {
        this.elementPrototype = elementPrototype;
    }

    public ElementPrototype getElementPrototype() {
        return elementPrototype;
    }
}
