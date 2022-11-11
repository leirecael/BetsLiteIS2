package businessLogic;

import java.util.List;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator<Event>{
	private List<Event> events;
	private int index;
	
	public ExtendedIteratorEvents(List<Event> l) {
		events = l;
		goFirst();
	}

	@Override
	public Event previous() {
		Event e = events.get(index);
		index--;
		return e;
	}

	@Override
	public boolean hasPrevious() {
		return index > 0;
	}

	@Override
	public void goFirst() {
		index = 0;
	}

	@Override
	public void goLast() {
		index = events.size() - 1;
	}

	@Override
	public boolean hasNext() {
		return index < events.size();
	}

	@Override
	public Event next() {
		Event e = events.get(index);
		index++;
		return e;
	}

}
